package com.clean.architecture.adapters.rest.validator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateSchemeItem {
    private String field;
    private String description;
    private String rule;
    private String errorMsg;
    private boolean isCustomLogic;
}
