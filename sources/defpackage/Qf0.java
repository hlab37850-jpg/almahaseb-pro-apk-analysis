package defpackage;

import com.google.android.gms.internal.vision.zzke;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Qf0 implements Rf0 {
    @Override // defpackage.Rf0
    public final Map a(Object obj) {
        return (zzke) obj;
    }

    @Override // defpackage.Rf0
    public final Object b(Object obj) {
        return zzke.zza().zzb();
    }

    @Override // defpackage.Rf0
    public final Object c(Object obj) {
        ((zzke) obj).zzc();
        return obj;
    }

    @Override // defpackage.Rf0
    public final boolean d(Object obj) {
        return !((zzke) obj).zzd();
    }

    @Override // defpackage.Rf0
    public final Object e(Object obj, Object obj2) {
        zzke zzkeVarZzb = (zzke) obj;
        zzke zzkeVar = (zzke) obj2;
        if (!zzkeVar.isEmpty()) {
            if (!zzkeVarZzb.zzd()) {
                zzkeVarZzb = zzkeVarZzb.zzb();
            }
            zzkeVarZzb.zza(zzkeVar);
        }
        return zzkeVarZzb;
    }

    @Override // defpackage.Rf0
    public final int f(int i, Object obj, Object obj2) {
        zzke zzkeVar = (zzke) obj;
        if (zzkeVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzkeVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.Rf0
    public final Map zza(Object obj) {
        return (zzke) obj;
    }

    @Override // defpackage.Rf0
    public final Pf0 zzb(Object obj) {
        throw new NoSuchMethodError();
    }
}
