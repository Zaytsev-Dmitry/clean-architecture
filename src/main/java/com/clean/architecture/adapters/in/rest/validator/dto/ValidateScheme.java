package com.clean.architecture.adapters.in.rest.validator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateScheme {
    private String validatorName;
    private List<ValidateSchemeItem> items;
}
