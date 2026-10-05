package defpackage;

import com.google.android.gms.internal.clearcut.o;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzcv;
import com.google.android.gms.internal.clearcut.zzcx;
import com.google.android.gms.internal.clearcut.zzdo;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ya0 {
    public static final Class a = C();
    public static final Bb0 b = w(false);
    public static final Bb0 c = w(true);
    public static final Bb0 d = new o();

    public static Bb0 A() {
        return c;
    }

    public static Bb0 B() {
        return d;
    }

    public static Class C() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int E(List list) {
        int iZzs;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3859s80) {
            C3859s80 c3859s80 = (C3859s80) list;
            iZzs = 0;
            while (i < size) {
                iZzs += zzbn.zzs(c3859s80.a(i));
                i++;
            }
        } else {
            iZzs = 0;
            while (i < size) {
                iZzs += zzbn.zzs(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzs;
    }

    public static void F(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.d(i, list, z);
    }

    public static int G(List list) {
        int iZzt;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3859s80) {
            C3859s80 c3859s80 = (C3859s80) list;
            iZzt = 0;
            while (i < size) {
                iZzt += zzbn.zzt(c3859s80.a(i));
                i++;
            }
        } else {
            iZzt = 0;
            while (i < size) {
                iZzt += zzbn.zzt(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzt;
    }

    public static void H(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.t(i, list, z);
    }

    public static void I(Class cls) {
        Class cls2;
        if (!zzcg.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int J(List list) {
        int iZzu;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3859s80) {
            C3859s80 c3859s80 = (C3859s80) list;
            iZzu = 0;
            while (i < size) {
                iZzu += zzbn.zzu(c3859s80.a(i));
                i++;
            }
        } else {
            iZzu = 0;
            while (i < size) {
                iZzu += zzbn.zzu(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzu;
    }

    public static void K(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.b(i, list, z);
    }

    public static int L(List list) {
        return list.size() << 2;
    }

    public static void M(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.h(i, list, z);
    }

    public static int N(List list) {
        return list.size() << 3;
    }

    public static void O(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.c(i, list, z);
    }

    public static int P(List list) {
        return list.size();
    }

    public static void Q(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.w(i, list, z);
    }

    public static void R(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.n(i, list, z);
    }

    public static void S(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.p(i, list, z);
    }

    public static void T(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.i(i, list, z);
    }

    public static void U(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.f(i, list, z);
    }

    public static int V(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbn.zzr(i));
    }

    public static int W(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzbn.zzr(i));
    }

    public static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return q(list) + (size * zzbn.zzr(i));
    }

    public static int Y(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return v(list) + (size * zzbn.zzr(i));
    }

    public static int Z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzbn.zzr(i));
    }

    public static int a(List list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4347y90) {
            C4347y90 c4347y90 = (C4347y90) list;
            iZze = 0;
            while (i < size) {
                iZze += zzbn.zze(c4347y90.a(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzbn.zze(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZze;
    }

    public static int a0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * zzbn.zzr(i));
    }

    public static Object b(int i, int i2, Object obj, Bb0 bb0) {
        if (obj == null) {
            obj = bb0.f();
        }
        bb0.a(obj, i, i2);
        return obj;
    }

    public static int b0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return J(list) + (size * zzbn.zzr(i));
    }

    public static Object c(int i, List list, zzck zzckVar, Object obj, Bb0 bb0) {
        if (zzckVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzckVar.zzb(iIntValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = b(i, iIntValue, obj, bb0);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (zzckVar.zzb(iIntValue2) == null) {
                    obj = b(i, iIntValue2, obj, bb0);
                    it.remove();
                }
            }
        }
        return obj;
    }

    public static int c0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzj(i, 0);
    }

    public static void d(int i, List list, InterfaceC3812rc0 interfaceC3812rc0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.B(i, list);
    }

    public static int d0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzg(i, 0L);
    }

    public static void e(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, Ta0 ta0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.D(i, list, ta0);
    }

    public static int e0(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzc(i, true);
    }

    public static void f(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.e(i, list, z);
    }

    public static void g(AbstractC4343y70 abstractC4343y70, Object obj, Object obj2) {
        H70 h70B = abstractC4343y70.b(obj2);
        if (h70B.b()) {
            return;
        }
        abstractC4343y70.e(obj).j(h70B);
    }

    public static void h(I90 i90, Object obj, Object obj2, long j) {
        Sb0.i(obj, j, i90.c(Sb0.M(obj, j), Sb0.M(obj2, j)));
    }

    public static void i(Bb0 bb0, Object obj, Object obj2) {
        bb0.g(obj, bb0.i(bb0.k(obj), bb0.k(obj2)));
    }

    public static int j(List list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4347y90) {
            C4347y90 c4347y90 = (C4347y90) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzbn.zzf(c4347y90.a(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzbn.zzf(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzf;
    }

    public static void k(int i, List list, InterfaceC3812rc0 interfaceC3812rc0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.x(i, list);
    }

    public static void l(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, Ta0 ta0) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.F(i, list, ta0);
    }

    public static void m(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.z(i, list, z);
    }

    public static int n(int i, Object obj, Ta0 ta0) {
        return obj instanceof zzcv ? zzbn.zza(i, (zzcv) obj) : zzbn.zzb(i, (zzdo) obj, ta0);
    }

    public static int o(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzr = zzbn.zzr(i) * size;
        if (list instanceof zzcx) {
            zzcx zzcxVar = (zzcx) list;
            while (i2 < size) {
                Object raw = zzcxVar.getRaw(i2);
                iZzr += raw instanceof zzbb ? zzbn.zzb((zzbb) raw) : zzbn.zzh((String) raw);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iZzr += obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
                i2++;
            }
        }
        return iZzr;
    }

    public static int p(int i, List list, Ta0 ta0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzr = zzbn.zzr(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iZzr += obj instanceof zzcv ? zzbn.zza((zzcv) obj) : zzbn.zzb((zzdo) obj, ta0);
        }
        return iZzr;
    }

    public static int q(List list) {
        int iZzg;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C4347y90) {
            C4347y90 c4347y90 = (C4347y90) list;
            iZzg = 0;
            while (i < size) {
                iZzg += zzbn.zzg(c4347y90.a(i));
                i++;
            }
        } else {
            iZzg = 0;
            while (i < size) {
                iZzg += zzbn.zzg(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzg;
    }

    public static void r(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.a(i, list, z);
    }

    public static boolean s(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = ((long) i2) - ((long) i);
        long j2 = i3;
        return j + 10 <= ((2 * j2) + 3) + ((j2 + 3) * 3);
    }

    public static int t(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzr = size * zzbn.zzr(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzr += zzbn.zzb((zzbb) list.get(i2));
        }
        return iZzr;
    }

    public static int u(int i, List list, Ta0 ta0) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzbn.zzc(i, (zzdo) list.get(i2), ta0);
        }
        return iZzc;
    }

    public static int v(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C3859s80) {
            C3859s80 c3859s80 = (C3859s80) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzbn.zzx(c3859s80.a(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzbn.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    public static Bb0 w(boolean z) {
        try {
            Class clsD = D();
            if (clsD == null) {
                return null;
            }
            return (Bb0) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void x(int i, List list, InterfaceC3812rc0 interfaceC3812rc0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC3812rc0.v(i, list, z);
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Bb0 z() {
        return b;
    }
}
