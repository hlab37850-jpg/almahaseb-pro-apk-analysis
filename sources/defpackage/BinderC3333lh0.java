package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p001authapiphone.zzd;
import com.google.android.gms.internal.p001authapiphone.zzr;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: lh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3333lh0 extends zzd {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC3333lh0(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zze
    public final void zzb(Status status, int i) {
        TaskUtil.setResultOrApiException(status, Integer.valueOf(i), this.a);
    }
}
