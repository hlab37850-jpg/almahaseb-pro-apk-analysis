package defpackage;

import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.p000authapi.zbaq;
import com.google.android.gms.internal.p000authapi.zby;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class X20 extends zby {
    public final /* synthetic */ TaskCompletionSource a;

    public X20(zbaq zbaqVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbz
    public final void zbb(Status status, AuthorizationResult authorizationResult) {
        if (status.isSuccess()) {
            this.a.setResult(authorizationResult);
        } else {
            this.a.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
