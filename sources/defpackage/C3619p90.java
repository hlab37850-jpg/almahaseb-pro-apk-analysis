package defpackage;

import com.google.android.gms.internal.clearcut.zzcw;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzfa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: p90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3619p90 extends X80 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public C3619p90() {
        super();
    }

    public static List e(Object obj, long j) {
        return (List) Sb0.M(obj, j);
    }

    @Override // defpackage.X80
    public final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) Sb0.M(obj, j);
        if (list instanceof zzcx) {
            objUnmodifiableList = ((zzcx) list).zzbu();
        } else if (c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        Sb0.i(obj, j, objUnmodifiableList);
    }

    @Override // defpackage.X80
    public final void b(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listE = e(obj2, j);
        int size = listE.size();
        List listE2 = e(obj, j);
        if (listE2.isEmpty()) {
            List zzcwVar = listE2 instanceof zzcx ? new zzcw(size) : new ArrayList(size);
            Sb0.i(obj, j, zzcwVar);
            list2 = zzcwVar;
        } else {
            if (c.isAssignableFrom(listE2.getClass())) {
                ArrayList arrayList = new ArrayList(listE2.size() + size);
                arrayList.addAll(listE2);
                list = arrayList;
            } else if (listE2 instanceof zzfa) {
                list2 = listE2;
                zzcw zzcwVar2 = new zzcw(listE2.size() + size);
                zzcwVar2.addAll((zzfa) listE2);
                list = zzcwVar2;
            }
            Sb0.i(obj, j, list);
            list2 = list;
        }
        list2 = listE2;
        int size2 = list2.size();
        int size3 = listE.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(listE);
        }
        if (size2 > 0) {
            listE = list2;
        }
        Sb0.i(obj, j, listE);
    }
}
