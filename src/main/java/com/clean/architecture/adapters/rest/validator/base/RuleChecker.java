package com.clean.architecture.adapters.rest.validator.base;

import com.clean.architecture.adapters.rest.validator.dto.ValidateItem;
import com.clean.architecture.domain.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RuleChecker {
    private final Map<ValidationRuleType, ValidationRule> ruleMap;

    @Autowired
    public RuleChecker(final List<ValidationRule> rules) {
        this.ruleMap = rules.stream().collect(Collectors.toMap(
                rule -> ValidationRuleType.valueOf(rule.getRuleName()),
                rule -> rule
        ));
    }

    public void check(final ValidateItem item) {
        ValidationRule rule = ruleMap.get(item.getRule());
        if (rule == null) {
            log.warn("Неизвестное правило валидации: {}", item.getRule());
            return;
        }

        try {
            rule.validate(item);
        } catch (ValidationException e) {
            log.error("Ошибка валидации: {}", e.getMessage());
            throw e;
        }
    }
}
