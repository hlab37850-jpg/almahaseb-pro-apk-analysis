package defpackage;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzau;

/* JADX INFO: loaded from: classes2.dex */
public final class Mc0 extends AbstractC2298gg0 {
    public final /* synthetic */ zzaq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mc0(AccountTransferClient accountTransferClient, int i, zzaq zzaqVar) {
        super(1608, null);
        this.b = zzaqVar;
    }

    @Override // defpackage.AbstractC2298gg0
    public final void a(zzau zzauVar) {
        zzauVar.zzd(new Eb0(this, this), this.b);
    }
}
