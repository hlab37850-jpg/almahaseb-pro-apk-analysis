package defpackage;

import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p000authapi.zbab;
import com.google.android.gms.internal.p000authapi.zbbg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: e30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2082e30 extends zbab {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC2082e30(zbbg zbbgVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbac
    public final void zbb(Status status, BeginSignInResult beginSignInResult) {
        TaskUtil.setResultOrApiException(status, beginSignInResult, this.a);
    }
}
