package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends UnregisterListenerMethod {
    public final /* synthetic */ RegistrationMethods.Builder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.a = builder;
    }

    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.a.zab.accept(anyClient, taskCompletionSource);
    }
}
