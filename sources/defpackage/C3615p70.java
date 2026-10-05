package defpackage;

import com.google.android.gms.internal.play_billing.zzbt;

/* JADX INFO: renamed from: p70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3615p70 extends AbstractC1204a70 {
    public final zzbt c;

    public C3615p70(zzbt zzbtVar, int i) {
        super(zzbtVar.size(), i);
        this.c = zzbtVar;
    }

    @Override // defpackage.AbstractC1204a70
    public final Object a(int i) {
        return this.c.get(i);
    }
}
