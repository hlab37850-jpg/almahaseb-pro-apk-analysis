package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC4215wb0;
import defpackage.C2208fc0;
import defpackage.C3407md0;
import defpackage.InterfaceC3814rd0;
import defpackage.InterfaceC4221we0;
import defpackage.Nc0;
import defpackage.Xd0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w {
    public static final Xd0 a;

    static {
        C3407md0 c3407md0 = C3407md0.c;
        a = new x();
    }

    public static void A(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.E(i, list, z);
    }

    public static void B(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.q(i, list, z);
    }

    public static void C(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.z(i, list, z);
    }

    public static void D(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.i(i, list, z);
    }

    public static void E(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.p(i, list, z);
    }

    public static void a(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.u(i, list, z);
    }

    public static void b(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.C(i, list, z);
    }

    public static void c(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.n(i, list, z);
    }

    public static void d(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.x(i, list, z);
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int f(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2208fc0) {
            C2208fc0 c2208fc0 = (C2208fc0) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(c2208fc0.b(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    public static int g(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i << 3) + 4);
    }

    public static int h(List list) {
        return list.size() * 4;
    }

    public static int i(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i << 3) + 8);
    }

    public static int j(List list) {
        return list.size() * 8;
    }

    public static int k(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2208fc0) {
            C2208fc0 c2208fc0 = (C2208fc0) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(c2208fc0.b(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Nc0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzD = 0;
        for (int i = 0; i < size; i++) {
            iZzD += zzep.zzD(((Long) list.get(i)).longValue());
        }
        return iZzD;
    }

    public static int m(int i, Object obj, InterfaceC3814rd0 interfaceC3814rd0) {
        int i2 = i << 3;
        if (!(obj instanceof zzfw)) {
            return zzep.zzC(i2) + zzep.zzA((zzgl) obj, interfaceC3814rd0);
        }
        int iZzC = zzep.zzC(i2);
        int iZza = ((zzfw) obj).zza();
        return iZzC + zzep.zzC(iZza) + iZza;
    }

    public static int n(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2208fc0) {
            C2208fc0 c2208fc0 = (C2208fc0) list;
            iZzC = 0;
            while (i < size) {
                int iB = c2208fc0.b(i);
                iZzC += zzep.zzC((iB >> 31) ^ (iB + iB));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzC += zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzC;
    }

    public static int o(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Nc0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzD = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iZzD += zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iZzD;
    }

    public static int p(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2208fc0) {
            C2208fc0 c2208fc0 = (C2208fc0) list;
            iZzC = 0;
            while (i < size) {
                iZzC += zzep.zzC(c2208fc0.b(i));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                iZzC += zzep.zzC(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzC;
    }

    public static int q(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof Nc0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzD = 0;
        for (int i = 0; i < size; i++) {
            iZzD += zzep.zzD(((Long) list.get(i)).longValue());
        }
        return iZzD;
    }

    public static Xd0 r() {
        return a;
    }

    public static Object s(Object obj, int i, int i2, Object obj2, Xd0 xd0) {
        if (obj2 == null) {
            obj2 = xd0.a(obj);
        }
        ((zzhi) obj2).zzj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    public static void t(AbstractC4215wb0 abstractC4215wb0, Object obj, Object obj2) {
        if (((zzff) obj2).zzb.a.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void u(Xd0 xd0, Object obj, Object obj2) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVarZze = zzfiVar.zzc;
        zzhi zzhiVar = ((zzfi) obj2).zzc;
        if (!zzhi.zzc().equals(zzhiVar)) {
            if (zzhi.zzc().equals(zzhiVarZze)) {
                zzhiVarZze = zzhi.zze(zzhiVarZze, zzhiVar);
            } else {
                zzhiVarZze.zzd(zzhiVar);
            }
        }
        zzfiVar.zzc = zzhiVarZze;
    }

    public static void v(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.a(i, list, z);
    }

    public static void w(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.e(i, list, z);
    }

    public static void x(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.c(i, list, z);
    }

    public static void y(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.b(i, list, z);
    }

    public static void z(int i, List list, InterfaceC4221we0 interfaceC4221we0, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC4221we0.d(i, list, z);
    }
}
