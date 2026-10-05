package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzal;

/* JADX INFO: renamed from: z40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC4428z40 extends I40 {
    public final /* synthetic */ D40 a;

    public BinderC4428z40(D40 d40) {
        this.a = d40;
    }

    @Override // defpackage.I40, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z) {
        this.a.setResult(new T40(z ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
