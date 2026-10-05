package defpackage;

import com.google.android.gms.internal.vision.B;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzii;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzjg;
import com.google.android.gms.internal.vision.zzjt;
import com.google.android.gms.internal.vision.zzjv;
import com.google.android.gms.internal.vision.zzkk;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: lg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3331lg0 {
    public static final Class a = F();
    public static final Ag0 b = i(false);
    public static final Ag0 c = i(true);
    public static final Ag0 d = new B();

    public static int A(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Df0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzf = 0;
        for (int i = 0; i < size; i++) {
            iZzf += zzii.zzf(((Long) list.get(i)).longValue());
        }
        return iZzf;
    }

    public static Ag0 B() {
        return d;
    }

    public static void C(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.a(i, list, z);
    }

    public static int D(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzii.zze(i));
    }

    public static int E(List list) {
        int iZzk;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4142vf0) {
            C4142vf0 c4142vf0 = (C4142vf0) list;
            iZzk = 0;
            while (i < size) {
                iZzk += zzii.zzk(c4142vf0.a(i));
                i++;
            }
        } else {
            iZzk = 0;
            while (i < size) {
                iZzk += zzii.zzk(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzk;
    }

    public static Class F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.v(i, list, z);
    }

    public static int H(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * zzii.zze(i));
    }

    public static int I(List list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4142vf0) {
            C4142vf0 c4142vf0 = (C4142vf0) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzii.zzf(c4142vf0.a(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzii.zzf(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzf;
    }

    public static Class J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.d(i, list, z);
    }

    public static int L(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * zzii.zze(i));
    }

    public static int M(List list) {
        int iZzg;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4142vf0) {
            C4142vf0 c4142vf0 = (C4142vf0) list;
            iZzg = 0;
            while (i < size) {
                iZzg += zzii.zzg(c4142vf0.a(i));
                i++;
            }
        } else {
            iZzg = 0;
            while (i < size) {
                iZzg += zzii.zzg(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzg;
    }

    public static void N(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.t(i, list, z);
    }

    public static int O(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzii.zze(i));
    }

    public static int P(List list) {
        int iZzh;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4142vf0) {
            C4142vf0 c4142vf0 = (C4142vf0) list;
            iZzh = 0;
            while (i < size) {
                iZzh += zzii.zzh(c4142vf0.a(i));
                i++;
            }
        } else {
            iZzh = 0;
            while (i < size) {
                iZzh += zzii.zzh(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzh;
    }

    public static void Q(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.b(i, list, z);
    }

    public static int R(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzi(i, 0);
    }

    public static int S(List list) {
        return list.size() << 2;
    }

    public static void T(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.h(i, list, z);
    }

    public static int U(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzg(i, 0L);
    }

    public static int V(List list) {
        return list.size() << 3;
    }

    public static void W(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.c(i, list, z);
    }

    public static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzb(i, true);
    }

    public static int Y(List list) {
        return list.size();
    }

    public static void Z(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.w(i, list, z);
    }

    public static int a(int i, Object obj, InterfaceC3167jg0 interfaceC3167jg0) {
        return obj instanceof zzjt ? zzii.zza(i, (zzjt) obj) : zzii.zzb(i, (zzkk) obj, interfaceC3167jg0);
    }

    public static void a0(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.n(i, list, z);
    }

    public static int b(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzii.zze(i) * size;
        if (list instanceof zzjv) {
            zzjv zzjvVar = (zzjv) list;
            while (i2 < size) {
                Object objZzb = zzjvVar.zzb(i2);
                iZze += objZzb instanceof zzht ? zzii.zzb((zzht) objZzb) : zzii.zzb((String) objZzb);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iZze += obj instanceof zzht ? zzii.zzb((zzht) obj) : zzii.zzb((String) obj);
                i2++;
            }
        }
        return iZze;
    }

    public static void b0(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.p(i, list, z);
    }

    public static int c(int i, List list, InterfaceC3167jg0 interfaceC3167jg0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzii.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iZze += obj instanceof zzjt ? zzii.zza((zzjt) obj) : zzii.zza((zzkk) obj, interfaceC3167jg0);
        }
        return iZze;
    }

    public static void c0(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.i(i, list, z);
    }

    public static int d(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzii.zze(i));
    }

    public static void d0(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.f(i, list, z);
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Df0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzd = 0;
        for (int i = 0; i < size; i++) {
            iZzd += zzii.zzd(((Long) list.get(i)).longValue());
        }
        return iZzd;
    }

    public static Object f(int i, int i2, Object obj, Ag0 ag0) {
        if (obj == null) {
            obj = ag0.a();
        }
        ag0.d(obj, i, i2);
        return obj;
    }

    public static Object g(int i, List list, zzjg zzjgVar, Object obj, Ag0 ag0) {
        if (zzjgVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzjgVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = f(i, iIntValue, obj, ag0);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzjgVar.zza(iIntValue2)) {
                    obj = f(i, iIntValue2, obj, ag0);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static Ag0 h() {
        return b;
    }

    public static Ag0 i(boolean z) {
        try {
            Class clsJ = J();
            if (clsJ == null) {
                return null;
            }
            return (Ag0) clsJ.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(int i, List list, Wg0 wg0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.B(i, list);
    }

    public static void k(int i, List list, Wg0 wg0, InterfaceC3167jg0 interfaceC3167jg0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.E(i, list, interfaceC3167jg0);
    }

    public static void l(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.e(i, list, z);
    }

    public static void m(Class cls) {
        Class cls2;
        if (!zzjb.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void n(Xe0 xe0, Object obj, Object obj2) {
        C1812bf0 c1812bf0D = xe0.d(obj2);
        if (c1812bf0D.a.isEmpty()) {
            return;
        }
        xe0.i(obj).g(c1812bf0D);
    }

    public static void o(Rf0 rf0, Object obj, Object obj2, long j) {
        Ig0.j(obj, j, rf0.e(Ig0.F(obj, j), Ig0.F(obj2, j)));
    }

    public static void p(Ag0 ag0, Object obj, Object obj2) {
        ag0.g(obj, ag0.p(ag0.k(obj), ag0.k(obj2)));
    }

    public static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzii.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzii.zzb((zzht) list.get(i2));
        }
        return iZze;
    }

    public static int s(int i, List list, InterfaceC3167jg0 interfaceC3167jg0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzii.zzc(i, (zzkk) list.get(i2), interfaceC3167jg0);
        }
        return iZzc;
    }

    public static int t(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * zzii.zze(i));
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Df0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZze = 0;
        for (int i = 0; i < size; i++) {
            iZze += zzii.zze(((Long) list.get(i)).longValue());
        }
        return iZze;
    }

    public static Ag0 v() {
        return c;
    }

    public static void w(int i, List list, Wg0 wg0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.x(i, list);
    }

    public static void x(int i, List list, Wg0 wg0, InterfaceC3167jg0 interfaceC3167jg0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.I(i, list, interfaceC3167jg0);
    }

    public static void y(int i, List list, Wg0 wg0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wg0.z(i, list, z);
    }

    public static int z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzii.zze(i));
    }
}
