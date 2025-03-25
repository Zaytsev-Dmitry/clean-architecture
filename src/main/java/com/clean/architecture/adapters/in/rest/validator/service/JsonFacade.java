package com.clean.architecture.adapters.in.rest.validator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Getter
@Service
@Scope(value = SCOPE_SINGLETON)
public final class JsonFacade {
    public final static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public <T> T jsonToPojo(final String json) {
        return objectMapper.readValue(json, new TypeReference<>() {
        });
    }

    @SneakyThrows
    public <T> String pojoToJson(final Object obj) {
        return objectMapper.writeValueAsString(obj);
    }
}

