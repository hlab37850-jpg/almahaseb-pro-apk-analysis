package defpackage;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: c50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class BinderC1847c50 extends zzah {
    public final TaskCompletionSource a;

    public BinderC1847c50(TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaaVar) {
        TaskUtil.setResultOrApiException(zzaaVar.getStatus(), this.a);
    }

    public void zzc() {
    }
}
