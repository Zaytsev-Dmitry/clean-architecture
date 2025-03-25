package com.clean.architecture.adapters.in.rest.validator.service;

import com.clean.architecture.adapters.in.rest.validator.custom.CustomRuleValidator;
import com.clean.architecture.adapters.in.rest.validator.model.Rule;
import com.clean.architecture.adapters.in.rest.validator.model.ValidateItem;
import com.clean.architecture.domain.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;


@Slf4j
@Component
public class RuleChecker {
    private static final Map<Class<?>, Predicate<Object>> EMPTY_CHECKS = Map.of(
            String.class, v -> ((String) v).isEmpty(),
            Integer.class, v -> ((Integer) v) == 0,
            Long.class, v -> ((Long) v) == 0,
            Double.class, v -> ((Double) v) == 0.0,
            Float.class, v -> ((Float) v) == 0.0f
    );

    private static final Map<Rule, Predicate<Object>> RULE_CHECKS = Map.of(
            Rule.NOT_NULL, Objects::nonNull,
            Rule.NOT_NULL_OR_EMPTY,
            value -> value != null &&
                    !EMPTY_CHECKS.getOrDefault(value.getClass(), v -> false).test(value),
            Rule.FILE_NOT_NULL_OR_EMPTY, value -> {
                MultipartFile file = (MultipartFile) value;
                return file != null && file.getSize() > 0;
            }
    );

    public void check(final ValidateItem item, Map<String, Object> allParams, List<CustomRuleValidator> customValidators) {
        if (item.getRule() == Rule.CUSTOM) {
            customValidators.forEach(validator -> {
                validator.valid(allParams);
            });
        } else {
            Predicate<Object> ruleCheck = RULE_CHECKS.get(item.getRule());
            if (ruleCheck == null || !ruleCheck.test(item.getValue())) {
                throw new ValidationException(item.getErrorMessage());
            }
        }
    }
}
