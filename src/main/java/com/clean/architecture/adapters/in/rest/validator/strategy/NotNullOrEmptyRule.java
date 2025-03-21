package com.clean.architecture.adapters.in.rest.validator.strategy;

import com.clean.architecture.adapters.in.rest.validator.base.ValidationRuleType;
import com.clean.architecture.adapters.in.rest.validator.dto.ValidateItem;
import com.clean.architecture.adapters.in.rest.validator.base.ValidationRule;
import com.clean.architecture.domain.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class NotNullOrEmptyRule implements ValidationRule {
    @Override
    public void validate(ValidateItem item) throws ValidationException {
        if (item.getValue() == null) {
            throw new ValidationException("Поле: " + item.getName() + " не может быть null");
        }

        if (item.getValue() instanceof String && ((String) item.getValue()).isEmpty()) {
            throw new ValidationException(item.getErrorMessage());
        }

        if (item.getValue() instanceof Number && ((Number) item.getValue()).doubleValue() == 0) {
            throw new ValidationException("Поле: " + item.getName() + " не может быть пустым");
        }
    }

    @Override
    public String getRuleName() throws ValidationException {
        return ValidationRuleType.NOT_NULL_OR_EMPTY.toString();
    }
}
