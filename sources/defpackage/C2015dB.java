package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: renamed from: dB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2015dB extends FV {
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;

    public C2015dB() {
        super(1835104368);
        K(65536);
        J(0);
        D(0);
        A(0);
        z(0);
        w(0);
        I(2);
        H(0);
        G(0);
        B(0);
        C(0);
        F(0);
        E(0);
        y(0);
        x(0);
    }

    public void A(int i) {
        this.f = i;
    }

    public void B(int i) {
        this.l = i;
    }

    public void C(int i) {
        this.m = i;
    }

    public void D(int i) {
        this.e = i;
    }

    public void E(int i) {
        this.o = i;
    }

    public void F(int i) {
        this.n = i;
    }

    public void G(int i) {
        this.k = i;
    }

    public void H(int i) {
        this.j = i;
    }

    public void I(int i) {
        this.i = i;
    }

    public void J(int i) {
        this.d = i;
    }

    public void K(int i) {
        this.c = i;
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(g());
        t8B.B(v());
        t8B.E((short) u());
        t8B.E((short) o());
        t8B.E((short) l());
        t8B.E((short) k());
        t8B.E((short) h());
        t8B.E((short) t());
        t8B.E((short) s());
        t8B.E((short) r());
        t8B.E((short) m());
        t8B.E((short) n());
        t8B.E((short) q());
        t8B.E((short) p());
        t8B.E((short) j());
        t8B.E((short) i());
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        if (t8.F() != 32) {
            throw new IllegalArgumentException("Bad size for Maxp table");
        }
        K(t8.n());
        J(t8.p());
        D(t8.p());
        A(t8.p());
        z(t8.p());
        w(t8.p());
        I(t8.p());
        H(t8.p());
        G(t8.p());
        B(t8.p());
        C(t8.p());
        F(t8.p());
        E(t8.p());
        y(t8.p());
        x(t8.p());
    }

    public int g() {
        return 32;
    }

    public int h() {
        return this.h & 65535;
    }

    public int i() {
        return this.q & 65535;
    }

    public int j() {
        return this.p & 65535;
    }

    public int k() {
        return this.g & 65535;
    }

    public int l() {
        return this.f & 65535;
    }

    public int m() {
        return this.l & 65535;
    }

    public int n() {
        return this.m & 65535;
    }

    public int o() {
        return this.e & 65535;
    }

    public int p() {
        return this.o & 65535;
    }

    public int q() {
        return this.n & 65535;
    }

    public int r() {
        return this.k & 65535;
    }

    public int s() {
        return this.j & 65535;
    }

    public int t() {
        return this.i & 65535;
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Version          : " + Integer.toHexString(v()) + StringUtilities.LF);
        stringBuffer.append("    NumGlyphs        : " + u() + StringUtilities.LF);
        stringBuffer.append("    MaxPoints        : " + o() + StringUtilities.LF);
        stringBuffer.append("    MaxContours      : " + l() + StringUtilities.LF);
        stringBuffer.append("    MaxCompPoints    : " + k() + StringUtilities.LF);
        stringBuffer.append("    MaxCompContours  : " + h() + StringUtilities.LF);
        stringBuffer.append("    MaxZones         : " + t() + StringUtilities.LF);
        stringBuffer.append("    MaxTwilightPoints: " + s() + StringUtilities.LF);
        stringBuffer.append("    MaxStorage       : " + r() + StringUtilities.LF);
        stringBuffer.append("    MaxFuncDefs      : " + m() + StringUtilities.LF);
        stringBuffer.append("    MaxInstDefs      : " + n() + StringUtilities.LF);
        stringBuffer.append("    MaxStackElements : " + q() + StringUtilities.LF);
        stringBuffer.append("    MaxSizeInst      : " + p() + StringUtilities.LF);
        stringBuffer.append("    MaxCompElements  : " + j() + StringUtilities.LF);
        stringBuffer.append("    MaxCompDepth     : " + i() + StringUtilities.LF);
        return stringBuffer.toString();
    }

    public int u() {
        return this.d & 65535;
    }

    public int v() {
        return this.c;
    }

    public void w(int i) {
        this.h = i;
    }

    public void x(int i) {
        this.q = i;
    }

    public void y(int i) {
        this.p = i;
    }

    public void z(int i) {
        this.g = i;
    }
}
