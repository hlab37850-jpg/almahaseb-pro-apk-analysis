package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends TaskApiCall {
    public final /* synthetic */ TaskApiCall.Builder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.a = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.a.zaa.accept(anyClient, taskCompletionSource);
    }
}
