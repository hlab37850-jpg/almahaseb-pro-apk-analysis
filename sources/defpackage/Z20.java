package defpackage;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.p000authapi.zbai;
import com.google.android.gms.internal.p000authapi.zbaw;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class Z20 extends zbai {
    public final /* synthetic */ TaskCompletionSource a;

    public Z20(zbaw zbawVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbaj
    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) {
        if (status.isSuccess()) {
            this.a.setResult(saveAccountLinkingTokenResult);
        } else {
            this.a.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
