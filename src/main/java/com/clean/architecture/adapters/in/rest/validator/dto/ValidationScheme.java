package com.clean.architecture.adapters.in.rest.validator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationScheme {
    private String schemeName;
    private List<ValidationSchemeField> fields;
}
