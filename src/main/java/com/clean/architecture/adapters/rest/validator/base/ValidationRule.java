package com.clean.architecture.adapters.rest.validator.base;

import com.clean.architecture.adapters.rest.validator.dto.ValidateItem;
import com.clean.architecture.domain.exception.ValidationException;

public interface ValidationRule {
    void validate(ValidateItem item) throws ValidationException;
    String getRuleName() throws ValidationException;
}
