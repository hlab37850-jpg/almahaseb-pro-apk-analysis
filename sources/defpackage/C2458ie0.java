package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: ie0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2458ie0 extends AbstractC3409me0 {
    public C2458ie0(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // defpackage.AbstractC3409me0
    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(this.a.getLong(obj, j));
    }

    @Override // defpackage.AbstractC3409me0
    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(this.a.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: ne0.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: ne0.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: ne0.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: ne0.o(java.lang.Object, long, boolean):void */
    @Override // defpackage.AbstractC3409me0
    public final void c(Object obj, long j, boolean z) {
        if (AbstractC3491ne0.h) {
            AbstractC3491ne0.n(obj, j, z);
        } else {
            AbstractC3491ne0.o(obj, j, z);
        }
    }

    @Override // defpackage.AbstractC3409me0
    public final void d(Object obj, long j, byte b) {
        if (AbstractC3491ne0.h) {
            AbstractC3491ne0.d(obj, j, b);
        } else {
            AbstractC3491ne0.e(obj, j, b);
        }
    }

    @Override // defpackage.AbstractC3409me0
    public final void e(Object obj, long j, double d) {
        this.a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.AbstractC3409me0
    public final void f(Object obj, long j, float f) {
        this.a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.AbstractC3409me0
    public final boolean g(Object obj, long j) {
        return AbstractC3491ne0.h ? AbstractC3491ne0.y(obj, j) : AbstractC3491ne0.z(obj, j);
    }
}
