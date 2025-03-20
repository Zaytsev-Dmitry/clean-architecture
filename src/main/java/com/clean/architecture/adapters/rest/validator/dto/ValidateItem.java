package com.clean.architecture.adapters.rest.validator.dto;

import com.clean.architecture.adapters.rest.validator.base.ValidationRuleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateItem {
    private String name;
    private ValidationRuleType rule;
    private String errorMessage;
    private Object value;
}
