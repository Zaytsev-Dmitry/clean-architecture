package com.clean.architecture.adapters.rest.validator.strategy;

import com.clean.architecture.adapters.rest.validator.base.ValidationRuleType;
import com.clean.architecture.adapters.rest.validator.dto.ValidateItem;
import com.clean.architecture.adapters.rest.validator.base.ValidationRule;
import com.clean.architecture.domain.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class NotNullRule implements ValidationRule {
    @Override
    public void validate(ValidateItem item) throws ValidationException {
        if (item.getValue() == null) {
            throw new ValidationException("Поле: " + item.getName() + " не может быть null");
        }
    }

    @Override
    public String getRuleName() throws ValidationException {
        return ValidationRuleType.NOT_NULL.toString();
    }
}
