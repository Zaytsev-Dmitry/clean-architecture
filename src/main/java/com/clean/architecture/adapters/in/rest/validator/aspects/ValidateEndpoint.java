package com.clean.architecture.adapters.in.rest.validator.aspects;


import com.clean.architecture.adapters.in.rest.validator.custom.CustomRuleValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEndpoint {
    String baseSchemeName();
    Class<? extends CustomRuleValidator>[] customFieldValidators() default {};
    Class<? extends CustomRuleValidator>[] customValidator() default {};
}
