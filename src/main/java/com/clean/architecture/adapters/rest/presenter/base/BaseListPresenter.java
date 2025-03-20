package com.clean.architecture.adapters.rest.presenter.base;

import com.generated.swaggerCodegen.model.BasicBackendResponse;
import com.generated.swaggerCodegen.model.MetaData;

import java.time.Instant;
import java.util.List;

public abstract class BaseListPresenter<R extends BasicBackendResponse, T> {
    public R present(final List<T> req) {
        R result = this.newResponse(req);
        result.setMeta(getMetaData());
        result.setDescription("Запрос успешно выполнен");
        return result;
    }

    protected abstract R newResponse(final List<T> req);

    protected MetaData getMetaData() {
        MetaData metaData = new MetaData();
        metaData.setTimestamp(Instant.now().toString());
        return metaData;
    }
}
