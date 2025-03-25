package com.clean.architecture.adapters.in.rest.validator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateItem {
    private String name;
    private Rule rule;
    private String errorMessage;
    private Object value;
}
