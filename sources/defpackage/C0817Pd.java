package defpackage;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: Pd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0817Pd extends C0739Md {
    public transient long[] k;
    public transient int l;
    public transient int n;
    public final boolean p;

    public C0817Pd() {
        this(3);
    }

    public static C0817Pd c0() {
        return new C0817Pd();
    }

    public static C0817Pd d0(int i) {
        return new C0817Pd(i);
    }

    @Override // defpackage.C0739Md
    public int D() {
        return this.l;
    }

    @Override // defpackage.C0739Md
    public int E(int i) {
        return ((int) f0(i)) - 1;
    }

    @Override // defpackage.C0739Md
    public void I(int i) {
        super.I(i);
        this.l = -2;
        this.n = -2;
    }

    @Override // defpackage.C0739Md
    public void J(int i, Object obj, Object obj2, int i2, int i3) {
        super.J(i, obj, obj2, i2, i3);
        j0(this.n, i);
        j0(i, -2);
    }

    @Override // defpackage.C0739Md
    public void M(int i, int i2) {
        int size = size() - 1;
        super.M(i, i2);
        j0(e0(i), E(i));
        if (i < size) {
            j0(e0(size), i);
            j0(i, E(size));
        }
        h0(size, 0L);
    }

    @Override // defpackage.C0739Md
    public void T(int i) {
        super.T(i);
        this.k = Arrays.copyOf(g0(), i);
    }

    @Override // defpackage.C0739Md, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (N()) {
            return;
        }
        this.l = -2;
        this.n = -2;
        long[] jArr = this.k;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    public final int e0(int i) {
        return ((int) (f0(i) >>> 32)) - 1;
    }

    public final long f0(int i) {
        return g0()[i];
    }

    public final long[] g0() {
        long[] jArr = this.k;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    public final void h0(int i, long j) {
        g0()[i] = j;
    }

    public final void i0(int i, int i2) {
        h0(i, (f0(i) & 4294967295L) | (((long) (i2 + 1)) << 32));
    }

    public final void j0(int i, int i2) {
        if (i == -2) {
            this.l = i2;
        } else {
            k0(i, i2);
        }
        if (i2 == -2) {
            this.n = i;
        } else {
            i0(i2, i);
        }
    }

    public final void k0(int i, int i2) {
        h0(i, (f0(i) & (-4294967296L)) | (((long) (i2 + 1)) & 4294967295L));
    }

    @Override // defpackage.C0739Md
    public void q(int i) {
        if (this.p) {
            j0(e0(i), E(i));
            j0(this.n, i);
            j0(i, -2);
            G();
        }
    }

    @Override // defpackage.C0739Md
    public int r(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // defpackage.C0739Md
    public int s() {
        int iS = super.s();
        this.k = new long[iS];
        return iS;
    }

    @Override // defpackage.C0739Md
    public Map t() {
        Map mapT = super.t();
        this.k = null;
        return mapT;
    }

    @Override // defpackage.C0739Md
    public Map w(int i) {
        return new LinkedHashMap(i, 1.0f, this.p);
    }

    public C0817Pd(int i) {
        this(i, false);
    }

    public C0817Pd(int i, boolean z) {
        super(i);
        this.p = z;
    }
}
