package defpackage;

import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p000authapi.zbak;
import com.google.android.gms.internal.p000authapi.zbaw;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: a30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC1196a30 extends zbak {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC1196a30(zbaw zbawVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbal
    public final void zbb(Status status, SavePasswordResult savePasswordResult) {
        TaskUtil.setResultOrApiException(status, savePasswordResult, this.a);
    }
}
