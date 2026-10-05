package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Runnable {
    public final /* synthetic */ Result a;
    public final /* synthetic */ zada b;

    public k(zada zadaVar, Result result) {
        this.b = zadaVar;
        this.a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                PendingResult pendingResultOnSuccess = ((ResultTransform) Preconditions.checkNotNull(this.b.zaa)).onSuccess(this.a);
                zada zadaVar = this.b;
                zadaVar.zah.sendMessage(zadaVar.zah.obtainMessage(0, pendingResultOnSuccess));
                threadLocal.set(Boolean.FALSE);
                zada zadaVar2 = this.b;
                zada.zan(this.a);
                googleApiClient = (GoogleApiClient) this.b.zag.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e) {
                zada zadaVar3 = this.b;
                zadaVar3.zah.sendMessage(zadaVar3.zah.obtainMessage(1, e));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zada zadaVar4 = this.b;
                zada.zan(this.a);
                googleApiClient = (GoogleApiClient) this.b.zag.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.zap(this.b);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada zadaVar5 = this.b;
            zada.zan(this.a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.b.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.b);
            }
            throw th;
        }
    }
}
