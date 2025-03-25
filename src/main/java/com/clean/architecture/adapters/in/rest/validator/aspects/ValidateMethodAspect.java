package com.clean.architecture.adapters.in.rest.validator.aspects;

import com.clean.architecture.adapters.in.rest.validator.custom.CustomRuleValidator;
import com.clean.architecture.adapters.in.rest.validator.dto.ValidationScheme;
import com.clean.architecture.adapters.in.rest.validator.dto.ValidationSchemeField;
import com.clean.architecture.adapters.in.rest.validator.model.Rule;
import com.clean.architecture.adapters.in.rest.validator.model.ValidateItem;
import com.clean.architecture.adapters.in.rest.validator.service.JsonFacade;
import com.clean.architecture.adapters.in.rest.validator.service.RuleChecker;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class ValidateMethodAspect {
    private final RuleChecker ruleChecker;

    @Around("@annotation(com.clean.architecture.adapters.in.rest.validator.aspects.ValidateEndpoint)")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ValidateEndpoint annotation = methodSignature.getMethod().getAnnotation(ValidateEndpoint.class);
        Map<String, Object> paramMap = extractMethodParams(methodSignature, joinPoint.getArgs());

        if (annotation.customValidator().length == 1) {
            instantiateValidator(annotation.customValidator()[0]).valid(paramMap);
        } else {
            validateWithScheme(annotation, paramMap);
        }

        return joinPoint.proceed();
    }

    private void validateWithScheme(ValidateEndpoint annotation, Map<String, Object> paramMap) {
        List<CustomRuleValidator> customValidators = List.of(annotation.customFieldValidators())
                .stream()
                .map(this::instantiateValidator)
                .toList();

        ValidationScheme validationScheme = loadValidationScheme(annotation)
                .orElseThrow(() -> new IllegalArgumentException("Validation scheme file is missing"));

        validationScheme.getFields().stream()
                .map(item -> createValidationItems(validationScheme.getSchemeName(), item, paramMap))
                .forEach(items -> {
                    items.forEach(item -> ruleChecker.check(item, paramMap, customValidators));
                });
    }

    private CustomRuleValidator instantiateValidator(Class<? extends CustomRuleValidator> validatorClass) {
        try {
            return validatorClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate custom validator: " + validatorClass.getName(), e);
        }
    }

    private Map<String, Object> extractMethodParams(MethodSignature methodSignature, Object[] args) {
        String[] paramNames = methodSignature.getParameterNames();
        return IntStream.range(0, paramNames.length)
                .boxed()
                .collect(HashMap::new, (m, v) -> m.put(paramNames[v], args[v]), HashMap::putAll);
    }

    private Optional<ValidationScheme> loadValidationScheme(ValidateEndpoint annotation) {
        String schemePath = "static/validator/scheme/" + annotation.baseSchemeName() + ".json";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(schemePath)) {
            if (inputStream == null) {
                log.error("Validation scheme file not found: {}", schemePath);
                return Optional.empty();
            }
            return Optional.of(JsonFacade.objectMapper.readValue(inputStream, ValidationScheme.class));
        } catch (IOException e) {
            log.error("Error reading validation scheme: {}", schemePath, e);
            throw new IllegalStateException("Failed to read validation scheme from " + schemePath, e);
        }
    }

    private List<ValidateItem> createValidationItems(String schemeName, ValidationSchemeField item, Map<String, Object> paramMap) {
        if (!paramMap.containsKey(item.getName())) {
            log.error(
                    "ValidateMethodAspect. Не могу найти поле с названием {} в исходных аргументах endpoint. " + "\n" +
                            "Проверь конфиг валидатора: {}", item.getName(), schemeName
            );
            throw new RuntimeException();
        }
        Object value = paramMap.get(item.getName());
        List<ValidateItem> items = new ArrayList<>(List.of(createValidationItem(item, value)));

        if (item.getNestedScheme() != null) {
            items.addAll(createNestedValidationItems(item.getNestedScheme(), convertToMap(value)));
        }

        return items;
    }

    private List<ValidateItem> createNestedValidationItems(ValidationScheme nestedScheme, Map<String, Object> paramMap) {
        return nestedScheme.getFields().stream()
                .map(item -> createValidationItems(nestedScheme.getSchemeName(), item, paramMap))
                .flatMap(List::stream)
                .toList();
    }

    private ValidateItem createValidationItem(ValidationSchemeField schemeItem, Object value) {
        validateSchemeItem(schemeItem);
        return new ValidateItem(
                schemeItem.getName(),
                Rule.valueOf(schemeItem.getRule()),
                schemeItem.getErrorMsg(),
                value
        );
    }

    private void validateSchemeItem(ValidationSchemeField schemeItem) {
        if (Stream.of(schemeItem.getName(), schemeItem.getRule(), schemeItem.getErrorMsg()).anyMatch(Objects::isNull)) {
            log.error("Invalid validation scheme item: {}", schemeItem);
            throw new IllegalArgumentException("Invalid validation scheme item: " + schemeItem);
        }
    }

    private Map<String, Object> convertToMap(Object obj) {
        return JsonFacade.objectMapper.convertValue(obj, new TypeReference<>() {
        });
    }
}