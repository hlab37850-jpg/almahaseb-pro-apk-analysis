package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p000authapi.zbbg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: f30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2164f30 extends IStatusCallback.Stub {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC2164f30(zbbg zbbgVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.setResultOrApiException(status, this.a);
    }
}
