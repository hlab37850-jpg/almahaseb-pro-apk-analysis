package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.p001authapiphone.zzf;
import com.google.android.gms.internal.p001authapiphone.zzr;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: uh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC4065uh0 extends zzf {
    public final /* synthetic */ TaskCompletionSource a;

    public BinderC4065uh0(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzg
    public final void zzb(Status status, boolean z) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z), this.a);
    }
}
