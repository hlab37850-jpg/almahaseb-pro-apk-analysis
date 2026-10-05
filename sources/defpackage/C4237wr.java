package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: renamed from: wr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4237wr extends FV {
    public int c;
    public short d;
    public short e;
    public short f;
    public short g;
    public short h;
    public short i;
    public short j;
    public short k;
    public short l;
    public short m;
    public short n;
    public short o;

    public C4237wr() {
        super(1751474532);
        F(65536);
    }

    public void A(short s) {
        this.f = s;
    }

    public void B(short s) {
        this.n = s;
    }

    public void C(short s) {
        this.h = s;
    }

    public void D(short s) {
        this.i = s;
    }

    public void E(short s) {
        this.o = s;
    }

    public void F(int i) {
        this.c = i;
    }

    public void G(short s) {
        this.j = s;
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(m());
        t8B.B(s());
        t8B.E(h());
        t8B.E(l());
        t8B.E(n());
        t8B.E(g());
        t8B.E(p());
        t8B.E(q());
        t8B.E(t());
        t8B.E(j());
        t8B.E(k());
        t8B.E(i());
        t8B.E((short) 0);
        t8B.E((short) 0);
        t8B.E((short) 0);
        t8B.E((short) 0);
        t8B.E(o());
        t8B.E((short) r());
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        if (t8.F() != 36) {
            throw new IllegalArgumentException("Bad Head table size");
        }
        F(t8.n());
        v(t8.p());
        z(t8.p());
        A(t8.p());
        u(t8.p());
        C(t8.p());
        D(t8.p());
        G(t8.p());
        x(t8.p());
        y(t8.p());
        w(t8.p());
        t8.p();
        t8.p();
        t8.p();
        t8.p();
        B(t8.p());
        E(t8.p());
    }

    public short g() {
        return this.g;
    }

    public short h() {
        return this.d;
    }

    public short i() {
        return this.m;
    }

    public short j() {
        return this.k;
    }

    public short k() {
        return this.l;
    }

    public short l() {
        return this.e;
    }

    public int m() {
        return 36;
    }

    public short n() {
        return this.f;
    }

    public short o() {
        return this.n;
    }

    public short p() {
        return this.h;
    }

    public short q() {
        return this.i;
    }

    public int r() {
        return this.o & 65535;
    }

    public int s() {
        return this.c;
    }

    public short t() {
        return this.j;
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Version             : " + Integer.toHexString(s()) + StringUtilities.LF);
        stringBuffer.append("    Ascent              : " + ((int) h()) + StringUtilities.LF);
        stringBuffer.append("    Descent             : " + ((int) l()) + StringUtilities.LF);
        stringBuffer.append("    LineGap             : " + ((int) n()) + StringUtilities.LF);
        stringBuffer.append("    AdvanceWidthMax     : " + ((int) g()) + StringUtilities.LF);
        stringBuffer.append("    MinLSB              : " + ((int) p()) + StringUtilities.LF);
        stringBuffer.append("    MinRSB              : " + ((int) q()) + StringUtilities.LF);
        stringBuffer.append("    MaxExtent           : " + ((int) t()) + StringUtilities.LF);
        stringBuffer.append("    CaretSlopeRise      : " + ((int) j()) + StringUtilities.LF);
        stringBuffer.append("    CaretSlopeRun       : " + ((int) k()) + StringUtilities.LF);
        stringBuffer.append("    CaretOffset         : " + ((int) i()) + StringUtilities.LF);
        stringBuffer.append("    MetricDataFormat    : " + ((int) o()) + StringUtilities.LF);
        stringBuffer.append("    NumOfLongHorMetrics : " + r() + StringUtilities.LF);
        return stringBuffer.toString();
    }

    public void u(short s) {
        this.g = s;
    }

    public void v(short s) {
        this.d = s;
    }

    public void w(short s) {
        this.m = s;
    }

    public void x(short s) {
        this.k = s;
    }

    public void y(short s) {
        this.l = s;
    }

    public void z(short s) {
        this.e = s;
    }
}
