package defpackage;

import com.google.android.gms.internal.vision.zzjl;
import com.google.android.gms.internal.vision.zzjs;
import com.google.android.gms.internal.vision.zzjv;
import com.google.android.gms.internal.vision.zzlz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Bf0 extends Af0 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public Bf0() {
        super();
    }

    public static List f(Object obj, long j, int i) {
        List list;
        List listZza;
        List listG = g(obj, j);
        if (listG.isEmpty()) {
            if (listG instanceof zzjv) {
                listZza = new zzjs(i);
            } else {
                listZza = ((listG instanceof Xf0) && (listG instanceof zzjl)) ? ((zzjl) listG).zza(i) : new ArrayList(i);
            }
            Ig0.j(obj, j, listZza);
            return listZza;
        }
        if (c.isAssignableFrom(listG.getClass())) {
            ArrayList arrayList = new ArrayList(listG.size() + i);
            arrayList.addAll(listG);
            Ig0.j(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(listG instanceof zzlz)) {
                if (!(listG instanceof Xf0) || !(listG instanceof zzjl)) {
                    return listG;
                }
                zzjl zzjlVar = (zzjl) listG;
                if (zzjlVar.zza()) {
                    return listG;
                }
                zzjl zzjlVarZza = zzjlVar.zza(listG.size() + i);
                Ig0.j(obj, j, zzjlVarZza);
                return zzjlVarZza;
            }
            zzjs zzjsVar = new zzjs(listG.size() + i);
            zzjsVar.addAll((zzlz) listG);
            Ig0.j(obj, j, zzjsVar);
            list = zzjsVar;
        }
        return list;
    }

    public static List g(Object obj, long j) {
        return (List) Ig0.F(obj, j);
    }

    @Override // defpackage.Af0
    public final List a(Object obj, long j) {
        return f(obj, j, 10);
    }

    @Override // defpackage.Af0
    public final void c(Object obj, Object obj2, long j) {
        List listG = g(obj2, j);
        List listF = f(obj, j, listG.size());
        int size = listF.size();
        int size2 = listG.size();
        if (size > 0 && size2 > 0) {
            listF.addAll(listG);
        }
        if (size > 0) {
            listG = listF;
        }
        Ig0.j(obj, j, listG);
    }

    @Override // defpackage.Af0
    public final void e(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) Ig0.F(obj, j);
        if (list instanceof zzjv) {
            objUnmodifiableList = ((zzjv) list).zze();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof Xf0) && (list instanceof zzjl)) {
                zzjl zzjlVar = (zzjl) list;
                if (zzjlVar.zza()) {
                    zzjlVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        Ig0.j(obj, j, objUnmodifiableList);
    }
}
