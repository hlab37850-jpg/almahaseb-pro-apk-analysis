package defpackage;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzal;

/* JADX INFO: renamed from: i40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2412i40 extends I40 {
    public final /* synthetic */ C3932t40 a;

    public BinderC2412i40(C3932t40 c3932t40) {
        this.a = c3932t40;
    }

    @Override // defpackage.I40, com.google.android.gms.auth.account.zzb
    public final void zzb(Account account) {
        this.a.setResult(new M40(account != null ? Status.RESULT_SUCCESS : zzal.zza, account));
    }
}
