package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class Wd0 extends Yd0 {
    public Wd0(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // defpackage.Yd0
    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(j(obj, j));
    }

    @Override // defpackage.Yd0
    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(i(obj, j));
    }

    @Override // defpackage.Yd0
    public final void c(Object obj, long j, boolean z) {
        if (AbstractC1244ae0.g) {
            AbstractC1244ae0.i(obj, j, z);
        } else {
            AbstractC1244ae0.j(obj, j, z);
        }
    }

    @Override // defpackage.Yd0
    public final void d(Object obj, long j, double d) {
        n(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.Yd0
    public final void e(Object obj, long j, float f) {
        m(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.Yd0
    public final boolean f(Object obj, long j) {
        return AbstractC1244ae0.g ? AbstractC1244ae0.q(obj, j) : AbstractC1244ae0.r(obj, j);
    }
}
