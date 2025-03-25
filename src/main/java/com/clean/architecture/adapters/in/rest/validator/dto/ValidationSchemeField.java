package com.clean.architecture.adapters.in.rest.validator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationSchemeField {
    private String name;
    private String description;
    private String rule;
    private String errorMsg;
    private boolean isCustomLogic;

    private ValidationScheme nestedScheme; //Схема для вложенного объекта
}
