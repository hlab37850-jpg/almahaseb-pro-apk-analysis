package defpackage;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzax;

/* JADX INFO: loaded from: classes2.dex */
public final class Ca0 extends AbstractC2298gg0 {
    public final /* synthetic */ zzax b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ca0(AccountTransferClient accountTransferClient, int i, zzax zzaxVar) {
        super(1607, null);
        this.b = zzaxVar;
    }

    @Override // defpackage.AbstractC2298gg0
    public final void a(zzau zzauVar) {
        zzauVar.zzg(new BinderC3455n90(this, this), this.b);
    }
}
