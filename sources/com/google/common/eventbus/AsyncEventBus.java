package com.google.common.eventbus;

import defpackage.AbstractC4391yj;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, AbstractC4391yj.b(), EventBus.a.a);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, AbstractC4391yj.b(), subscriberExceptionHandler);
    }

    public AsyncEventBus(Executor executor) {
        super("default", executor, AbstractC4391yj.b(), EventBus.a.a);
    }
}
