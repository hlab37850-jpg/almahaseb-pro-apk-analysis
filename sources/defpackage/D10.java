package defpackage;

import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class D10 extends zac {
    public final WeakReference a;

    public D10(zaaw zaawVar) {
        this.a = new WeakReference(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(zak zakVar) {
        zaaw zaawVar = (zaaw) this.a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.zaa.zal(new C10(this, zaawVar, zaawVar, zakVar));
    }
}
