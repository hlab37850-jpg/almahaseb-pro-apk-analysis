package defpackage;

/* JADX INFO: renamed from: lr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3344lr {
    public static final ThreadLocal c = new ThreadLocal();
    public final int a;
    public int b;

    public C3344lr(int i, int i2) {
        this.b = 0;
        AbstractC4290xX.a(i % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        AbstractC4290xX.a(i2 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.a = i2;
        this.b = i;
    }

    public C3344lr a(byte b) {
        this.b = (this.b * this.a) + b;
        return this;
    }

    public C3344lr b(char c2) {
        this.b = (this.b * this.a) + c2;
        return this;
    }

    public C3344lr c(double d) {
        return f(Double.doubleToLongBits(d));
    }

    public C3344lr d(float f) {
        this.b = (this.b * this.a) + Float.floatToIntBits(f);
        return this;
    }

    public C3344lr e(int i) {
        this.b = (this.b * this.a) + i;
        return this;
    }

    public C3344lr f(long j) {
        this.b = (this.b * this.a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public C3344lr g(Object obj) {
        if (obj == null) {
            this.b *= this.a;
        } else if (obj.getClass().isArray()) {
            s(obj);
        } else {
            this.b = (this.b * this.a) + obj.hashCode();
        }
        return this;
    }

    public C3344lr h(short s) {
        this.b = (this.b * this.a) + s;
        return this;
    }

    public int hashCode() {
        return t();
    }

    public C3344lr i(boolean z) {
        this.b = (this.b * this.a) + (!z ? 1 : 0);
        return this;
    }

    public C3344lr j(byte[] bArr) {
        if (bArr == null) {
            this.b *= this.a;
        } else {
            for (byte b : bArr) {
                a(b);
            }
        }
        return this;
    }

    public C3344lr k(char[] cArr) {
        if (cArr == null) {
            this.b *= this.a;
        } else {
            for (char c2 : cArr) {
                b(c2);
            }
        }
        return this;
    }

    public C3344lr l(double[] dArr) {
        if (dArr == null) {
            this.b *= this.a;
        } else {
            for (double d : dArr) {
                c(d);
            }
        }
        return this;
    }

    public C3344lr m(float[] fArr) {
        if (fArr == null) {
            this.b *= this.a;
        } else {
            for (float f : fArr) {
                d(f);
            }
        }
        return this;
    }

    public C3344lr n(int[] iArr) {
        if (iArr == null) {
            this.b *= this.a;
        } else {
            for (int i : iArr) {
                e(i);
            }
        }
        return this;
    }

    public C3344lr o(long[] jArr) {
        if (jArr == null) {
            this.b *= this.a;
        } else {
            for (long j : jArr) {
                f(j);
            }
        }
        return this;
    }

    public C3344lr p(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.a;
        } else {
            for (Object obj : objArr) {
                g(obj);
            }
        }
        return this;
    }

    public C3344lr q(short[] sArr) {
        if (sArr == null) {
            this.b *= this.a;
        } else {
            for (short s : sArr) {
                h(s);
            }
        }
        return this;
    }

    public C3344lr r(boolean[] zArr) {
        if (zArr == null) {
            this.b *= this.a;
        } else {
            for (boolean z : zArr) {
                i(z);
            }
        }
        return this;
    }

    public final void s(Object obj) {
        if (obj instanceof long[]) {
            o((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            n((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            q((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            k((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            j((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            l((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            m((float[]) obj);
        } else if (obj instanceof boolean[]) {
            r((boolean[]) obj);
        } else {
            p((Object[]) obj);
        }
    }

    public int t() {
        return this.b;
    }
}
