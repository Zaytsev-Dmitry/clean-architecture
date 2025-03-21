package com.clean.architecture.adapters.in.rest.validator.aspecj;

import com.clean.architecture.adapters.in.rest.validator.dto.ValidateItem;
import com.clean.architecture.adapters.in.rest.validator.dto.ValidateScheme;
import com.clean.architecture.adapters.in.rest.validator.dto.ValidateSchemeItem;
import com.clean.architecture.adapters.in.rest.validator.base.RuleChecker;
import com.clean.architecture.adapters.in.rest.validator.base.ValidationRuleType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

@Aspect
@Component
@AllArgsConstructor
public class ValidateEndpointParametersAspect {
    private final RuleChecker ruleChecker;

    @Around("@annotation(com.clean.architecture.adapters.in.rest.validator.aspecj.ValidateEndpointParameters)")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String[] parametersName = methodSig.getParameterNames();

        List<ValidateItem> validateItems = new ArrayList<>();
        ValidateEndpointParameters myAnnotation = methodSig.getMethod().getAnnotation(ValidateEndpointParameters.class);
        String validatorScheme = myAnnotation.baseSchemeName();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream in = classloader.getResourceAsStream("static/validator/scheme/" + validatorScheme + ".json");
                Reader reader = new InputStreamReader(in, UTF_8)
        ) {
            String json = FileCopyUtils.copyToString(reader);
            ObjectMapper mapper = new ObjectMapper();

            ValidateScheme validateScheme = mapper.readValue(json, ValidateScheme.class);
            List<ValidateSchemeItem> items = validateScheme.getItems();
            Set<String> parameterNamesSet = new HashSet<>(Arrays.asList(parametersName));

            for (ValidateSchemeItem currentScheme : items) {
                String field = currentScheme.getField();
                if (parameterNamesSet.contains(field)) {
                    int index = Arrays.asList(parametersName).indexOf(field);
                    ValidateItem validateItem = new ValidateItem();
                    validateItem.setName(parametersName[index]);
                    validateItem.setValue(args[index]);
                    validateItem.setErrorMessage(currentScheme.getErrorMsg());
                    validateItem.setRule(ValidationRuleType.valueOf(currentScheme.getRule()));
                    validateItems.add(validateItem);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        validateItems.forEach(ruleChecker::check);
        return joinPoint.proceed();
    }
}
