package com.clean.architecture.adapters.in.rest.validator.aspecj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEndpointParameters {
    String endpointName();
    String baseSchemeName();
}
