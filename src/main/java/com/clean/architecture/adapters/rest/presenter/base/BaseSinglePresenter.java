package com.clean.architecture.adapters.rest.presenter.base;

import com.generated.swaggerCodegen.model.BasicBackendResponse;
import com.generated.swaggerCodegen.model.MetaData;

import java.time.Instant;

public abstract class BaseSinglePresenter<R extends BasicBackendResponse, T> {
    public R present(final T req) {
        R result = this.newResponse(req);
        result.setMeta(getMetaData());
        result.setDescription("Запрос успешно выполнен");
        return result;
    }

    protected abstract R newResponse(final T req);

    protected MetaData getMetaData() {
        MetaData metaData = new MetaData();
        metaData.setTimestamp(Instant.now().toString());
        return metaData;
    }
}
