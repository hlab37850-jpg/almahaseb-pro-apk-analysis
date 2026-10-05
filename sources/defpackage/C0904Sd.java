package defpackage;

import java.util.Comparator;

/* JADX INFO: renamed from: Sd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0904Sd {
    public int a = 0;

    public C0904Sd a(byte b, byte b2) {
        int i;
        if (this.a != 0) {
            return this;
        }
        if (b < b2) {
            i = -1;
        } else {
            i = b > b2 ? 1 : 0;
        }
        this.a = i;
        return this;
    }

    public C0904Sd b(char c, char c2) {
        int i;
        if (this.a != 0) {
            return this;
        }
        if (c < c2) {
            i = -1;
        } else {
            i = c > c2 ? 1 : 0;
        }
        this.a = i;
        return this;
    }

    public C0904Sd c(double d, double d2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Double.compare(d, d2);
        return this;
    }

    public C0904Sd d(float f, float f2) {
        if (this.a != 0) {
            return this;
        }
        this.a = Float.compare(f, f2);
        return this;
    }

    public C0904Sd e(int i, int i2) {
        int i3;
        if (this.a != 0) {
            return this;
        }
        if (i < i2) {
            i3 = -1;
        } else {
            i3 = i > i2 ? 1 : 0;
        }
        this.a = i3;
        return this;
    }

    public C0904Sd f(long j, long j2) {
        int i;
        if (this.a != 0) {
            return this;
        }
        if (j < j2) {
            i = -1;
        } else {
            i = j > j2 ? 1 : 0;
        }
        this.a = i;
        return this;
    }

    public C0904Sd g(Object obj, Object obj2) {
        return h(obj, obj2, null);
    }

    public C0904Sd h(Object obj, Object obj2, Comparator comparator) {
        if (this.a != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.a = -1;
            return this;
        }
        if (obj2 == null) {
            this.a = 1;
            return this;
        }
        if (obj.getClass().isArray()) {
            t(obj, obj2, comparator);
        } else if (comparator == null) {
            this.a = ((Comparable) obj).compareTo(obj2);
        } else {
            this.a = comparator.compare(obj, obj2);
        }
        return this;
    }

    public C0904Sd i(short s, short s2) {
        int i;
        if (this.a != 0) {
            return this;
        }
        if (s < s2) {
            i = -1;
        } else {
            i = s > s2 ? 1 : 0;
        }
        this.a = i;
        return this;
    }

    public C0904Sd j(boolean z, boolean z2) {
        if (this.a != 0 || z == z2) {
            return this;
        }
        if (z) {
            this.a = 1;
        } else {
            this.a = -1;
        }
        return this;
    }

    public C0904Sd k(byte[] bArr, byte[] bArr2) {
        if (this.a != 0 || bArr == bArr2) {
            return this;
        }
        if (bArr == null) {
            this.a = -1;
            return this;
        }
        if (bArr2 == null) {
            this.a = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            this.a = bArr.length >= bArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < bArr.length && this.a == 0; i++) {
            a(bArr[i], bArr2[i]);
        }
        return this;
    }

    public C0904Sd l(char[] cArr, char[] cArr2) {
        if (this.a != 0 || cArr == cArr2) {
            return this;
        }
        if (cArr == null) {
            this.a = -1;
            return this;
        }
        if (cArr2 == null) {
            this.a = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            this.a = cArr.length >= cArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < cArr.length && this.a == 0; i++) {
            b(cArr[i], cArr2[i]);
        }
        return this;
    }

    public C0904Sd m(double[] dArr, double[] dArr2) {
        if (this.a != 0 || dArr == dArr2) {
            return this;
        }
        if (dArr == null) {
            this.a = -1;
            return this;
        }
        if (dArr2 == null) {
            this.a = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            this.a = dArr.length >= dArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < dArr.length && this.a == 0; i++) {
            c(dArr[i], dArr2[i]);
        }
        return this;
    }

    public C0904Sd n(float[] fArr, float[] fArr2) {
        if (this.a != 0 || fArr == fArr2) {
            return this;
        }
        if (fArr == null) {
            this.a = -1;
            return this;
        }
        if (fArr2 == null) {
            this.a = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            this.a = fArr.length >= fArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < fArr.length && this.a == 0; i++) {
            d(fArr[i], fArr2[i]);
        }
        return this;
    }

    public C0904Sd o(int[] iArr, int[] iArr2) {
        if (this.a != 0 || iArr == iArr2) {
            return this;
        }
        if (iArr == null) {
            this.a = -1;
            return this;
        }
        if (iArr2 == null) {
            this.a = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            this.a = iArr.length >= iArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < iArr.length && this.a == 0; i++) {
            e(iArr[i], iArr2[i]);
        }
        return this;
    }

    public C0904Sd p(long[] jArr, long[] jArr2) {
        if (this.a != 0 || jArr == jArr2) {
            return this;
        }
        if (jArr == null) {
            this.a = -1;
            return this;
        }
        if (jArr2 == null) {
            this.a = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            this.a = jArr.length >= jArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < jArr.length && this.a == 0; i++) {
            f(jArr[i], jArr2[i]);
        }
        return this;
    }

    public C0904Sd q(Object[] objArr, Object[] objArr2, Comparator comparator) {
        if (this.a != 0 || objArr == objArr2) {
            return this;
        }
        if (objArr == null) {
            this.a = -1;
            return this;
        }
        if (objArr2 == null) {
            this.a = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            this.a = objArr.length >= objArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < objArr.length && this.a == 0; i++) {
            h(objArr[i], objArr2[i], comparator);
        }
        return this;
    }

    public C0904Sd r(short[] sArr, short[] sArr2) {
        if (this.a != 0 || sArr == sArr2) {
            return this;
        }
        if (sArr == null) {
            this.a = -1;
            return this;
        }
        if (sArr2 == null) {
            this.a = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            this.a = sArr.length >= sArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < sArr.length && this.a == 0; i++) {
            i(sArr[i], sArr2[i]);
        }
        return this;
    }

    public C0904Sd s(boolean[] zArr, boolean[] zArr2) {
        if (this.a != 0 || zArr == zArr2) {
            return this;
        }
        if (zArr == null) {
            this.a = -1;
            return this;
        }
        if (zArr2 == null) {
            this.a = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            this.a = zArr.length >= zArr2.length ? 1 : -1;
            return this;
        }
        for (int i = 0; i < zArr.length && this.a == 0; i++) {
            j(zArr[i], zArr2[i]);
        }
        return this;
    }

    public final void t(Object obj, Object obj2, Comparator comparator) {
        if (obj instanceof long[]) {
            p((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            o((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            r((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            l((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            k((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            m((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            n((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            s((boolean[]) obj, (boolean[]) obj2);
        } else {
            q((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public int u() {
        return this.a;
    }
}
