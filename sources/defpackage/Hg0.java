package defpackage;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

/* JADX INFO: loaded from: classes2.dex */
public final class Hg0 extends zzan {
    public final /* synthetic */ AbstractC2218fh0 a;

    public Hg0(AbstractC2218fh0 abstractC2218fh0) {
        this.a = abstractC2218fh0;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzd(Status status) {
        this.a.a.setException(new AccountTransferException(status));
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zze() {
        this.a.a.setResult(null);
    }
}
