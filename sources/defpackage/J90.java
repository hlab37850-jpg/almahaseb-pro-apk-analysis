package defpackage;

import com.google.android.gms.internal.clearcut.zzdi;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class J90 implements I90 {
    @Override // defpackage.I90
    public final Object a(Object obj) {
        return zzdi.zzbz().zzca();
    }

    @Override // defpackage.I90
    public final boolean b(Object obj) {
        return !((zzdi) obj).isMutable();
    }

    @Override // defpackage.I90
    public final Object c(Object obj, Object obj2) {
        zzdi zzdiVarZzca = (zzdi) obj;
        zzdi zzdiVar = (zzdi) obj2;
        if (!zzdiVar.isEmpty()) {
            if (!zzdiVarZzca.isMutable()) {
                zzdiVarZzca = zzdiVarZzca.zzca();
            }
            zzdiVarZzca.zza(zzdiVar);
        }
        return zzdiVarZzca;
    }

    @Override // defpackage.I90
    public final F90 d(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // defpackage.I90
    public final Object e(Object obj) {
        ((zzdi) obj).zzv();
        return obj;
    }

    @Override // defpackage.I90
    public final int f(int i, Object obj, Object obj2) {
        zzdi zzdiVar = (zzdi) obj;
        if (zzdiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzdiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // defpackage.I90
    public final Map g(Object obj) {
        return (zzdi) obj;
    }

    @Override // defpackage.I90
    public final Map h(Object obj) {
        return (zzdi) obj;
    }
}
