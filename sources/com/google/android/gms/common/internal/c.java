package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ PendingResultUtil.ResultConverter c;
    public final /* synthetic */ zas d;

    public c(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zasVar) {
        this.a = pendingResult;
        this.b = taskCompletionSource;
        this.c = resultConverter;
        this.d = zasVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (!status.isSuccess()) {
            this.b.setException(ApiExceptionUtil.fromStatus(status));
        } else {
            this.b.setResult(this.c.convert(this.a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
