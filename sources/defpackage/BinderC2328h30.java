package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p000authapi.zbae;
import com.google.android.gms.internal.p000authapi.zbbg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: h30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2328h30 extends zbae {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC2328h30(zbbg zbbgVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbaf
    public final void zbb(Status status, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.a);
    }
}
