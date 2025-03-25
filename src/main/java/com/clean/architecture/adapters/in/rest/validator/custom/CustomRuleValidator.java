package com.clean.architecture.adapters.in.rest.validator.custom;


import com.clean.architecture.domain.exception.ValidationException;

import java.util.Map;

public interface CustomRuleValidator {
    void valid(Map<String, Object> paramMap) throws ValidationException;
}
