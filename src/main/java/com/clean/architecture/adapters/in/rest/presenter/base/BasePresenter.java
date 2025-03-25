package com.clean.architecture.adapters.in.rest.presenter.base;

import com.generated.swaggerCodegen.model.BasicBackendResponse;
import com.generated.swaggerCodegen.model.MetaData;

import java.time.Instant;
import java.util.List;

public abstract class BasePresenter<E, I, S extends BasicBackendResponse, L extends BasicBackendResponse> {

    public L mapToListResponse(final List<E> entities) {
        L response = createListResponse(entities.stream().map(this::map).toList());
        decorate(response);
        return response;
    }

    public S mapToSingleResponse(final E entity) {
        S response = createSingleResponse(map(entity));
        decorate(response);
        return response;
    }

    private void decorate(final BasicBackendResponse response) {
        MetaData metaData = new MetaData();
        metaData.setTimestamp(Instant.now().toString());
        response.setMeta(metaData);
        response.setDescription("Запрос успешно выполнен");
    }

    protected abstract I map(E entity);

    protected abstract L createListResponse(List<I> collection);

    protected abstract S createSingleResponse(I single);
}

