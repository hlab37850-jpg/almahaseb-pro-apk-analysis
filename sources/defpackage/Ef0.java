package defpackage;

import com.google.android.gms.internal.vision.zzjl;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Ef0 extends Af0 {
    public Ef0() {
        super();
    }

    public static zzjl f(Object obj, long j) {
        return (zzjl) Ig0.F(obj, j);
    }

    @Override // defpackage.Af0
    public final List a(Object obj, long j) {
        zzjl zzjlVarF = f(obj, j);
        if (zzjlVarF.zza()) {
            return zzjlVarF;
        }
        int size = zzjlVarF.size();
        zzjl zzjlVarZza = zzjlVarF.zza(size == 0 ? 10 : size << 1);
        Ig0.j(obj, j, zzjlVarZza);
        return zzjlVarZza;
    }

    @Override // defpackage.Af0
    public final void c(Object obj, Object obj2, long j) {
        zzjl zzjlVarF = f(obj, j);
        zzjl zzjlVarF2 = f(obj2, j);
        int size = zzjlVarF.size();
        int size2 = zzjlVarF2.size();
        if (size > 0 && size2 > 0) {
            if (!zzjlVarF.zza()) {
                zzjlVarF = zzjlVarF.zza(size2 + size);
            }
            zzjlVarF.addAll(zzjlVarF2);
        }
        if (size > 0) {
            zzjlVarF2 = zzjlVarF;
        }
        Ig0.j(obj, j, zzjlVarF2);
    }

    @Override // defpackage.Af0
    public final void e(Object obj, long j) {
        f(obj, j).zzb();
    }
}
