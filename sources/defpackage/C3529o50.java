package defpackage;

import com.google.android.gms.internal.fido.zzat;

/* JADX INFO: renamed from: o50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3529o50 extends AbstractC2086e50 {
    public final zzat c;

    public C3529o50(zzat zzatVar, int i) {
        super(zzatVar.size(), i);
        this.c = zzatVar;
    }

    @Override // defpackage.AbstractC2086e50
    public final Object a(int i) {
        return this.c.get(i);
    }
}
