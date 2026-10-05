package defpackage;

import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzjk;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ag0 {
    public abstract Object a();

    public abstract Object b(Object obj);

    public abstract void c(Object obj, int i, int i2);

    public abstract void d(Object obj, int i, long j);

    public abstract void e(Object obj, int i, zzht zzhtVar);

    public abstract void f(Object obj, int i, Object obj2);

    public abstract void g(Object obj, Object obj2);

    public abstract void h(Object obj, Wg0 wg0);

    public final boolean i(Object obj, InterfaceC3249kg0 interfaceC3249kg0) throws zzjk {
        int iZzb = interfaceC3249kg0.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            d(obj, i, interfaceC3249kg0.zzg());
            return true;
        }
        if (i2 == 1) {
            l(obj, i, interfaceC3249kg0.zzi());
            return true;
        }
        if (i2 == 2) {
            e(obj, i, interfaceC3249kg0.f());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzjk.zzf();
            }
            c(obj, i, interfaceC3249kg0.zzj());
            return true;
        }
        Object objA = a();
        int i3 = 4 | (i << 3);
        while (interfaceC3249kg0.zza() != Integer.MAX_VALUE && i(objA, interfaceC3249kg0)) {
        }
        if (i3 != interfaceC3249kg0.zzb()) {
            throw zzjk.zze();
        }
        f(obj, i, b(objA));
        return true;
    }

    public abstract boolean j(InterfaceC3249kg0 interfaceC3249kg0);

    public abstract Object k(Object obj);

    public abstract void l(Object obj, int i, long j);

    public abstract void m(Object obj, Object obj2);

    public abstract void n(Object obj, Wg0 wg0);

    public abstract Object o(Object obj);

    public abstract Object p(Object obj, Object obj2);

    public abstract void q(Object obj);

    public abstract int r(Object obj);

    public abstract int s(Object obj);
}
