package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC3590or;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class w {
    public transient Object[] a;
    public transient int[] b;
    public transient int c;
    public transient int d;
    public transient int[] e;
    public transient long[] f;
    public transient float g;
    public transient int h;

    public class a extends Multisets.f {
        public final Object a;
        public int b;

        public a(int i) {
            this.a = w.this.a[i];
            this.b = i;
        }

        public void a() {
            int i = this.b;
            if (i == -1 || i >= w.this.C() || !Objects.equal(this.a, w.this.a[this.b])) {
                this.b = w.this.m(this.a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            a();
            int i = this.b;
            if (i == -1) {
                return 0;
            }
            return w.this.b[i];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public Object getElement() {
            return this.a;
        }
    }

    public w() {
        n(3, 1.0f);
    }

    public static long D(long j, int i) {
        return (j & (-4294967296L)) | (4294967295L & ((long) i));
    }

    public static w b() {
        return new w();
    }

    public static w c(int i) {
        return new w(i);
    }

    public static int h(long j) {
        return (int) (j >>> 32);
    }

    public static int j(long j) {
        return (int) j;
    }

    public static long[] q(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] iArrR = r(i);
        long[] jArr = this.f;
        int length = iArrR.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int iH = h(jArr[i3]);
            int i4 = iH & length;
            int i5 = iArrR[i4];
            iArrR[i4] = i3;
            jArr[i3] = (((long) iH) << 32) | (((long) i5) & 4294967295L);
        }
        this.h = i2;
        this.e = iArrR;
    }

    public void B(int i, int i2) {
        Preconditions.checkElementIndex(i, this.c);
        this.b[i] = i2;
    }

    public int C() {
        return this.c;
    }

    public void a() {
        this.d++;
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    public void d(int i) {
        if (i > this.f.length) {
            y(i);
        }
        if (i >= this.h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int e() {
        return this.c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int iM = m(obj);
        if (iM == -1) {
            return 0;
        }
        return this.b[iM];
    }

    public Multiset.Entry g(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return new a(i);
    }

    public Object i(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return this.a[i];
    }

    public int k(int i) {
        Preconditions.checkElementIndex(i, this.c);
        return this.b[i];
    }

    public final int l() {
        return this.e.length - 1;
    }

    public int m(Object obj) {
        int iD = AbstractC3590or.d(obj);
        int iJ = this.e[l() & iD];
        while (iJ != -1) {
            long j = this.f[iJ];
            if (h(j) == iD && Objects.equal(obj, this.a[iJ])) {
                return iJ;
            }
            iJ = j(j);
        }
        return -1;
    }

    public void n(int i, float f) {
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f > 0.0f, "Illegal load factor");
        int iA = AbstractC3590or.a(i, f);
        this.e = r(iA);
        this.g = f;
        this.a = new Object[i];
        this.b = new int[i];
        this.f = q(i);
        this.h = Math.max(1, (int) (iA * f));
    }

    public void o(int i, Object obj, int i2, int i3) {
        this.f[i] = (((long) i3) << 32) | 4294967295L;
        this.a[i] = obj;
        this.b[i] = i2;
    }

    public void p(int i) {
        int iC = C() - 1;
        if (i >= iC) {
            this.a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
            return;
        }
        Object[] objArr = this.a;
        objArr[i] = objArr[iC];
        int[] iArr = this.b;
        iArr[i] = iArr[iC];
        objArr[iC] = null;
        iArr[iC] = 0;
        long[] jArr = this.f;
        long j = jArr[iC];
        jArr[i] = j;
        jArr[iC] = -1;
        int iH = h(j) & l();
        int[] iArr2 = this.e;
        int i2 = iArr2[iH];
        if (i2 == iC) {
            iArr2[iH] = i;
            return;
        }
        while (true) {
            long j2 = this.f[i2];
            int iJ = j(j2);
            if (iJ == iC) {
                this.f[i2] = D(j2, i);
                return;
            }
            i2 = iJ;
        }
    }

    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    public int t(int i, int i2) {
        return i - 1;
    }

    public int u(Object obj, int i) {
        AbstractC1163Zb.d(i, "count");
        long[] jArr = this.f;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        int iD = AbstractC3590or.d(obj);
        int iL = l() & iD;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[iL];
        if (i3 == -1) {
            iArr2[iL] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == iD && Objects.equal(obj, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int iJ = j(j);
                if (iJ == -1) {
                    jArr[i3] = D(j, i2);
                    break;
                }
                i3 = iJ;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        z(i5);
        o(i2, obj, i, iD);
        this.c = i5;
        if (i2 >= this.h) {
            A(this.e.length * 2);
        }
        this.d++;
        return 0;
    }

    public int v(Object obj) {
        return w(obj, AbstractC3590or.d(obj));
    }

    public final int w(Object obj, int i) {
        int iL = l() & i;
        int i2 = this.e[iL];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f[i2]) == i && Objects.equal(obj, this.a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.e[iL] = j(this.f[i2]);
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int iJ = j(this.f[i2]);
            if (iJ == -1) {
                return 0;
            }
            i3 = i2;
            i2 = iJ;
        }
    }

    public int x(int i) {
        return w(this.a[i], h(this.f[i]));
    }

    public void y(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.f = jArrCopyOf;
    }

    public final void z(int i) {
        int length = this.f.length;
        if (i > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                y(iMax);
            }
        }
    }

    public w(w wVar) {
        n(wVar.C(), 1.0f);
        int iE = wVar.e();
        while (iE != -1) {
            u(wVar.i(iE), wVar.k(iE));
            iE = wVar.s(iE);
        }
    }

    public w(int i) {
        this(i, 1.0f);
    }

    public w(int i, float f) {
        n(i, f);
    }
}
