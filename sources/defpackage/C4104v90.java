package defpackage;

import com.google.android.gms.internal.clearcut.zzcn;

/* JADX INFO: renamed from: v90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4104v90 extends X80 {
    public C4104v90() {
        super();
    }

    public static zzcn e(Object obj, long j) {
        return (zzcn) Sb0.M(obj, j);
    }

    @Override // defpackage.X80
    public final void a(Object obj, long j) {
        e(obj, j).zzv();
    }

    @Override // defpackage.X80
    public final void b(Object obj, Object obj2, long j) {
        zzcn zzcnVarE = e(obj, j);
        zzcn zzcnVarE2 = e(obj2, j);
        int size = zzcnVarE.size();
        int size2 = zzcnVarE2.size();
        if (size > 0 && size2 > 0) {
            if (!zzcnVarE.zzu()) {
                zzcnVarE = zzcnVarE.zzi(size2 + size);
            }
            zzcnVarE.addAll(zzcnVarE2);
        }
        if (size > 0) {
            zzcnVarE2 = zzcnVarE;
        }
        Sb0.i(obj, j, zzcnVarE2);
    }
}
