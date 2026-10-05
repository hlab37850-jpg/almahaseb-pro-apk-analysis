package defpackage;

import com.google.android.gms.internal.location.zzbs;

/* JADX INFO: renamed from: l70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3287l70 extends AbstractC2090e70 {
    public final zzbs c;

    public C3287l70(zzbs zzbsVar, int i) {
        super(zzbsVar.size(), i);
        this.c = zzbsVar;
    }

    @Override // defpackage.AbstractC2090e70
    public final Object a(int i) {
        return this.c.get(i);
    }
}
