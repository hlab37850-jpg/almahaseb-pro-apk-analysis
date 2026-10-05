package defpackage;

import com.google.android.gms.internal.auth.zzey;
import com.google.android.gms.internal.auth.zzfd;
import com.google.android.gms.internal.auth.zzfe;
import com.google.android.gms.internal.auth.zzff;
import com.google.android.gms.internal.auth.zzhd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: ac0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1240ac0 extends AbstractC3159jc0 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ C1240ac0(zzff zzffVar) {
        super(null);
    }

    @Override // defpackage.AbstractC3159jc0
    public final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) AbstractC1244ae0.f(obj, j);
        if (list instanceof zzfe) {
            objUnmodifiableList = ((zzfe) list).zze();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof Tc0) && (list instanceof zzey)) {
                zzey zzeyVar = (zzey) list;
                if (zzeyVar.zzc()) {
                    zzeyVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        AbstractC1244ae0.p(obj, j, objUnmodifiableList);
    }

    @Override // defpackage.AbstractC3159jc0
    public final void b(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) AbstractC1244ae0.f(obj2, j);
        int size = list3.size();
        List list4 = (List) AbstractC1244ae0.f(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzfe) {
                listZzd = new zzfd(size);
            } else {
                listZzd = ((list4 instanceof Tc0) && (list4 instanceof zzey)) ? ((zzey) list4).zzd(size) : new ArrayList(size);
            }
            AbstractC1244ae0.p(obj, j, listZzd);
            list2 = listZzd;
        } else {
            if (c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                AbstractC1244ae0.p(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzhd) {
                zzfd zzfdVar = new zzfd(list4.size() + size);
                zzfdVar.addAll(zzfdVar.size(), (zzhd) list4);
                AbstractC1244ae0.p(obj, j, zzfdVar);
                list = zzfdVar;
            } else if ((list4 instanceof Tc0) && (list4 instanceof zzey)) {
                zzey zzeyVar = (zzey) list4;
                if (!zzeyVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzey zzeyVarZzd = zzeyVar.zzd(list4.size() + size);
                    AbstractC1244ae0.p(obj, j, zzeyVarZzd);
                    list2 = zzeyVarZzd;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        AbstractC1244ae0.p(obj, j, list3);
    }
}
