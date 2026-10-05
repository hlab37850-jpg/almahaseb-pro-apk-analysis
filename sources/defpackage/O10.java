package defpackage;

import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabw;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class O10 extends zabw {
    public final WeakReference a;

    public O10(zabe zabeVar) {
        this.a = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.a.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }
}
