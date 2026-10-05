package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectContext<T> implements CustomContext {
    private T obj;

    public ObjectContext(T t) {
        this.obj = t;
    }

    public T get() {
        return this.obj;
    }
}
