package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: pG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3626pG extends AbstractC3707qG {
    public static final BigInteger H;
    public static final BigInteger I;
    public static final BigInteger J;
    public static final BigInteger K;
    public static final BigDecimal L;
    public static final BigDecimal M;
    public static final BigDecimal N;
    public static final BigDecimal O;
    public double A;
    public BigInteger B;
    public BigDecimal C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public final C0918Sr c;
    public boolean d;
    public C0353Au n;
    public EnumC0431Du p;
    public final C1876cU q;
    public byte[] w;
    public int y;
    public long z;
    public int e = 0;
    public int f = 0;
    public long g = 0;
    public int h = 1;
    public int i = 0;
    public long j = 0;
    public int k = 1;
    public int l = 0;
    public char[] t = null;
    public boolean u = false;
    public R8 v = null;
    public int x = 0;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        H = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        I = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        J = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
        K = bigIntegerValueOf4;
        L = new BigDecimal(bigIntegerValueOf3);
        M = new BigDecimal(bigIntegerValueOf4);
        N = new BigDecimal(bigIntegerValueOf);
        O = new BigDecimal(bigIntegerValueOf2);
    }

    public AbstractC3626pG(C0918Sr c0918Sr, int i) {
        this.a = i;
        this.c = c0918Sr;
        this.q = c0918Sr.e();
        this.n = C0353Au.i();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long A() throws C4412yu {
        int i = this.x;
        if ((i & 2) == 0) {
            if (i == 0) {
                X(2);
            }
            if ((this.x & 2) == 0) {
                g0();
            }
        }
        return this.z;
    }

    @Override // defpackage.AbstractC3707qG
    public void L() throws C4412yu {
        if (this.n.f()) {
            return;
        }
        P(": expected close marker for " + this.n.c() + " (from " + this.n.m(this.c.g()) + ")");
    }

    public abstract void W();

    public void X(int i) throws C4412yu {
        EnumC0431Du enumC0431Du = this.b;
        if (enumC0431Du != EnumC0431Du.VALUE_NUMBER_INT) {
            if (enumC0431Du == EnumC0431Du.VALUE_NUMBER_FLOAT) {
                Y(i);
                return;
            }
            N("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
            return;
        }
        char[] cArrP = this.q.p();
        int iQ = this.q.q();
        int i2 = this.E;
        if (this.D) {
            iQ++;
        }
        if (i2 <= 9) {
            int iC = AbstractC1779bE.c(cArrP, iQ, i2);
            if (this.D) {
                iC = -iC;
            }
            this.y = iC;
            this.x = 1;
            return;
        }
        if (i2 > 18) {
            Z(i, cArrP, iQ, i2);
            return;
        }
        long jD = AbstractC1779bE.d(cArrP, iQ, i2);
        boolean z = this.D;
        if (z) {
            jD = -jD;
        }
        if (i2 == 10) {
            if (z) {
                if (jD >= -2147483648L) {
                    this.y = (int) jD;
                    this.x = 1;
                    return;
                }
            } else if (jD <= 2147483647L) {
                this.y = (int) jD;
                this.x = 1;
                return;
            }
        }
        this.z = jD;
        this.x = 2;
    }

    public final void Y(int i) throws C4412yu {
        try {
            if (i == 16) {
                this.C = this.q.f();
                this.x = 16;
            } else {
                this.A = this.q.g();
                this.x = 8;
            }
        } catch (NumberFormatException e) {
            V("Malformed numeric value '" + this.q.h() + "'", e);
        }
    }

    public final void Z(int i, char[] cArr, int i2, int i3) throws C4412yu {
        String strH = this.q.h();
        try {
            if (AbstractC1779bE.a(cArr, i2, i3, this.D)) {
                this.z = Long.parseLong(strH);
                this.x = 2;
            } else {
                this.B = new BigInteger(strH);
                this.x = 4;
            }
        } catch (NumberFormatException e) {
            V("Malformed numeric value '" + strH + "'", e);
        }
    }

    public void a0() {
        this.q.r();
        char[] cArr = this.t;
        if (cArr != null) {
            this.t = null;
            this.c.j(cArr);
        }
    }

    public void b0(int i, char c) throws C4412yu {
        N("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.n.c() + " starting at " + ("" + this.n.m(this.c.g())) + ")");
    }

    public void c0() {
        int i = this.x;
        if ((i & 8) != 0) {
            this.C = new BigDecimal(F());
        } else if ((i & 4) != 0) {
            this.C = new BigDecimal(this.B);
        } else if ((i & 2) != 0) {
            this.C = BigDecimal.valueOf(this.z);
        } else if ((i & 1) != 0) {
            this.C = BigDecimal.valueOf(this.y);
        } else {
            S();
        }
        this.x |= 16;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        this.d = true;
        try {
            W();
        } finally {
            a0();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger d() throws C4412yu {
        int i = this.x;
        if ((i & 4) == 0) {
            if (i == 0) {
                X(4);
            }
            if ((this.x & 4) == 0) {
                d0();
            }
        }
        return this.B;
    }

    public void d0() {
        int i = this.x;
        if ((i & 16) != 0) {
            this.B = this.C.toBigInteger();
        } else if ((i & 2) != 0) {
            this.B = BigInteger.valueOf(this.z);
        } else if ((i & 1) != 0) {
            this.B = BigInteger.valueOf(this.y);
        } else if ((i & 8) != 0) {
            this.B = BigDecimal.valueOf(this.A).toBigInteger();
        } else {
            S();
        }
        this.x |= 4;
    }

    public void e0() {
        int i = this.x;
        if ((i & 16) != 0) {
            this.A = this.C.doubleValue();
        } else if ((i & 4) != 0) {
            this.A = this.B.doubleValue();
        } else if ((i & 2) != 0) {
            this.A = this.z;
        } else if ((i & 1) != 0) {
            this.A = this.y;
        } else {
            S();
        }
        this.x |= 8;
    }

    public void f0() throws C4412yu {
        int i = this.x;
        if ((i & 2) != 0) {
            long j = this.z;
            int i2 = (int) j;
            if (i2 != j) {
                N("Numeric value (" + F() + ") out of range of int");
            }
            this.y = i2;
        } else if ((i & 4) != 0) {
            if (H.compareTo(this.B) > 0 || I.compareTo(this.B) < 0) {
                k0();
            }
            this.y = this.B.intValue();
        } else if ((i & 8) != 0) {
            double d = this.A;
            if (d < -2.147483648E9d || d > 2.147483647E9d) {
                k0();
            }
            this.y = (int) this.A;
        } else if ((i & 16) != 0) {
            if (N.compareTo(this.C) > 0 || O.compareTo(this.C) < 0) {
                k0();
            }
            this.y = this.C.intValue();
        } else {
            S();
        }
        this.x |= 1;
    }

    public void g0() throws C4412yu {
        int i = this.x;
        if ((i & 1) != 0) {
            this.z = this.y;
        } else if ((i & 4) != 0) {
            if (J.compareTo(this.B) > 0 || K.compareTo(this.B) < 0) {
                l0();
            }
            this.z = this.B.longValue();
        } else if ((i & 8) != 0) {
            double d = this.A;
            if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                l0();
            }
            this.z = (long) this.A;
        } else if ((i & 16) != 0) {
            if (L.compareTo(this.C) > 0 || M.compareTo(this.C) < 0) {
                l0();
            }
            this.z = this.C.longValue();
        } else {
            S();
        }
        this.x |= 2;
    }

    public abstract boolean h0();

    @Override // com.fasterxml.jackson.core.JsonParser
    public C4321xu i() {
        return new C4321xu(this.c.g(), (this.g + ((long) this.e)) - 1, this.h, (this.e - this.i) + 1);
    }

    public final void i0() throws C4412yu {
        if (h0()) {
            return;
        }
        O();
    }

    public void j0(String str) throws C4412yu {
        N("Invalid numeric value: " + str);
    }

    public void k0() throws C4412yu {
        N("Numeric value (" + F() + ") out of range of int (-2147483648 - 2147483647)");
    }

    public void l0() throws C4412yu {
        N("Numeric value (" + F() + ") out of range of long (-9223372036854775808 - " + LocationRequestCompat.PASSIVE_INTERVAL + ")");
    }

    public void m0(int i, String str) throws C4412yu {
        String str2 = "Unexpected character (" + AbstractC3707qG.K(i) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        N(str2);
    }

    public final EnumC0431Du n0(boolean z, int i, int i2, int i3) {
        return (i2 >= 1 || i3 >= 1) ? p0(z, i, i2, i3) : q0(z, i);
    }

    public final EnumC0431Du o0(String str, double d) {
        this.q.v(str);
        this.A = d;
        this.x = 8;
        return EnumC0431Du.VALUE_NUMBER_FLOAT;
    }

    public final EnumC0431Du p0(boolean z, int i, int i2, int i3) {
        this.D = z;
        this.E = i;
        this.F = i2;
        this.G = i3;
        this.x = 0;
        return EnumC0431Du.VALUE_NUMBER_FLOAT;
    }

    public final EnumC0431Du q0(boolean z, int i) {
        this.D = z;
        this.E = i;
        this.F = 0;
        this.G = 0;
        this.x = 0;
        return EnumC0431Du.VALUE_NUMBER_INT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String r() {
        EnumC0431Du enumC0431Du = this.b;
        return (enumC0431Du == EnumC0431Du.START_OBJECT || enumC0431Du == EnumC0431Du.START_ARRAY) ? this.n.l().k() : this.n.k();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal u() throws C4412yu {
        int i = this.x;
        if ((i & 16) == 0) {
            if (i == 0) {
                X(16);
            }
            if ((this.x & 16) == 0) {
                c0();
            }
        }
        return this.C;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double v() throws C4412yu {
        int i = this.x;
        if ((i & 8) == 0) {
            if (i == 0) {
                X(8);
            }
            if ((this.x & 8) == 0) {
                e0();
            }
        }
        return this.A;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float x() {
        return (float) v();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int z() throws C4412yu {
        int i = this.x;
        if ((i & 1) == 0) {
            if (i == 0) {
                X(1);
            }
            if ((this.x & 1) == 0) {
                f0();
            }
        }
        return this.y;
    }
}
