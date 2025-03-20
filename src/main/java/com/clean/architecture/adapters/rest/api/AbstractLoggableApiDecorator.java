package com.clean.architecture.adapters.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class AbstractLoggableApiDecorator {
    private final ObjectMapper objectMapper;

    public AbstractLoggableApiDecorator() {
        this.objectMapper = new ObjectMapper();
    }

    @SneakyThrows
    protected <T, R> R processing(
            final String nameMethod,
            final Function<T, R> function,
            final T request
    ) {
        final long startTime = System.nanoTime();
        try {
            final R response = function.apply(request);
            log.debug("processing {} ms UseCase {}({}) with result {}",
                    (System.nanoTime() - startTime) / 1_000_000D,
                    nameMethod,
                    this.objectMapper.writeValueAsString(request),
                    this.objectMapper.writeValueAsString(response)
            );
            return response;
        } catch (Exception exception) {
            log.error("processing {} ms UseCase {}({}) with error {}",
                    (System.nanoTime() - startTime) / 1_000_000D,
                    nameMethod,
                    this.objectMapper.writeValueAsString(request),
                    exception.getMessage(),
                    exception
            );
            throw exception;
        }
    }

    @SneakyThrows
    protected <R> R processing(
            final String nameMethod,
            final Supplier<R> supplier
    ) {
        final long startTime = System.nanoTime();
        try {
            final R response = supplier.get();
            log.debug("processing {} ms UseCase {}() with result {}",
                    (System.nanoTime() - startTime) / 1_000_000D,
                    nameMethod,
                    this.objectMapper.writeValueAsString(response)
            );
            return response;
        } catch (Exception exception) {
            log.error("processing {} ms UseCase {}() with error {}",
                    (System.nanoTime() - startTime) / 1_000_000D, nameMethod, exception.getMessage(), exception);
            throw exception;
        }
    }

    @SneakyThrows
    protected <T, U, R> R processing(
            final String nameMethod,
            final BiFunction<T, U, R> function,
            final T request1,
            final U request2
    ) {
        final long startTime = System.nanoTime();
        try {
            final R response = function.apply(request1, request2);
            log.debug("processing {} ms UseCase {}({}, {}) with result {}",
                    (System.nanoTime() - startTime) / 1_000_000D,
                    nameMethod,
                    this.objectMapper.writeValueAsString(request1),
                    this.objectMapper.writeValueAsString(request2),
                    this.objectMapper.writeValueAsString(response)
            );
            return response;
        } catch (Exception exception) {
            log.error(
                    "processing {} ms UseCase {}({}, {}) with error {}",
                    (System.nanoTime() - startTime) / 1_000_000D,
                    nameMethod,
                    this.objectMapper.writeValueAsString(request1),
                    this.objectMapper.writeValueAsString(request2),
                    exception.getMessage(),
                    exception
            );
            throw exception;
        }
    }
}
