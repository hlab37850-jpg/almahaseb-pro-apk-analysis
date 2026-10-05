package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Date;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: renamed from: pr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3671pr extends FV {
    public int c;
    public int d;
    public int e;
    public int f;
    public short g;
    public short h;
    public long i;
    public long j;
    public short k;
    public short l;
    public short m;
    public short n;
    public short o;
    public short p;
    public short q;
    public short r;
    public short s;

    public C3671pr() {
        super(1751474532);
        K(65536);
        C(65536);
        y(0);
        H(1594834165);
        A((short) 0);
        J((short) 64);
        z(System.currentTimeMillis());
        I(System.currentTimeMillis());
        M((short) 0);
        L(Font.COLOR_NORMAL);
        O((short) 0);
        N(Font.COLOR_NORMAL);
        G((short) 0);
        F((short) 0);
        B((short) 0);
        E((short) 0);
        D((short) 0);
    }

    public void A(short s) {
        this.g = s;
    }

    public void B(short s) {
        this.q = s;
    }

    public void C(int i) {
        this.d = i;
    }

    public void D(short s) {
        this.s = s;
    }

    public void E(short s) {
        this.r = s;
    }

    public void F(short s) {
        this.p = s;
    }

    public void G(short s) {
        this.o = s;
    }

    public void H(int i) {
        this.f = i;
    }

    public void I(long j) {
        this.j = j;
    }

    public void J(short s) {
        this.h = s;
    }

    public void K(int i) {
        this.c = i;
    }

    public void L(short s) {
        this.m = s;
    }

    public void M(short s) {
        this.k = s;
    }

    public void N(short s) {
        this.n = s;
    }

    public void O(short s) {
        this.l = s;
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(n());
        t8B.B(t());
        t8B.B(k());
        t8B.B(g());
        t8B.B(q());
        t8B.E(i());
        t8B.E(s());
        t8B.D(h());
        t8B.D(r());
        t8B.E(v());
        t8B.E(u());
        t8B.E(x());
        t8B.E(w());
        t8B.E(p());
        t8B.E(o());
        t8B.E(j());
        t8B.E(m());
        t8B.E(l());
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        if (t8.F() != 54) {
            throw new IllegalArgumentException("Bad Head table size");
        }
        K(t8.n());
        C(t8.n());
        y(t8.n());
        H(t8.n());
        A(t8.p());
        J(t8.p());
        z(t8.o());
        I(t8.o());
        M(t8.p());
        L(t8.p());
        O(t8.p());
        N(t8.p());
        G(t8.p());
        F(t8.p());
        B(t8.p());
        E(t8.p());
        D(t8.p());
    }

    public int g() {
        return this.e;
    }

    public long h() {
        return this.i;
    }

    public short i() {
        return this.g;
    }

    public short j() {
        return this.q;
    }

    public int k() {
        return this.d;
    }

    public short l() {
        return this.s;
    }

    public short m() {
        return this.r;
    }

    public int n() {
        return 54;
    }

    public short o() {
        return this.p;
    }

    public short p() {
        return this.o;
    }

    public int q() {
        return this.f;
    }

    public long r() {
        return this.j;
    }

    public short s() {
        return this.h;
    }

    public int t() {
        return this.c;
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Version          : " + Integer.toHexString(t()) + StringUtilities.LF);
        stringBuffer.append("    Revision         : " + Integer.toHexString(k()) + StringUtilities.LF);
        stringBuffer.append("    ChecksumAdj      : " + Integer.toHexString(g()) + StringUtilities.LF);
        stringBuffer.append("    MagicNumber      : " + Integer.toHexString(q()) + StringUtilities.LF);
        stringBuffer.append("    Flags            : " + Integer.toBinaryString(i()) + StringUtilities.LF);
        stringBuffer.append("    UnitsPerEm       : " + ((int) s()) + StringUtilities.LF);
        stringBuffer.append("    Created          : " + new Date(h()) + StringUtilities.LF);
        stringBuffer.append("    Modified         : " + new Date(r()) + StringUtilities.LF);
        stringBuffer.append("    XMin             : " + ((int) v()) + StringUtilities.LF);
        stringBuffer.append("    XMax             : " + ((int) u()) + StringUtilities.LF);
        stringBuffer.append("    YMin             : " + ((int) x()) + StringUtilities.LF);
        stringBuffer.append("    YMax             : " + ((int) w()) + StringUtilities.LF);
        stringBuffer.append("    MacStyle         : " + Integer.toBinaryString(p()) + StringUtilities.LF);
        stringBuffer.append("    LowestPPem       : " + ((int) o()) + StringUtilities.LF);
        stringBuffer.append("    FontDirectionHint: " + ((int) j()) + StringUtilities.LF);
        stringBuffer.append("    IndexToLocFormat : " + ((int) m()) + StringUtilities.LF);
        stringBuffer.append("    GlyphDataFormat  : " + ((int) l()) + StringUtilities.LF);
        return stringBuffer.toString();
    }

    public short u() {
        return this.m;
    }

    public short v() {
        return this.k;
    }

    public short w() {
        return this.n;
    }

    public short x() {
        return this.l;
    }

    public void y(int i) {
        this.e = i;
    }

    public void z(long j) {
        this.i = j;
    }
}
