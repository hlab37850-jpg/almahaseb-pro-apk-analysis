package defpackage;

import android.graphics.RectF;

/* JADX INFO: renamed from: uF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4029uF {
    public int a;
    public int b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public BF l;
    public BF m;
    public BF n;
    public BF t;
    public RectF u;
    public int k = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;

    public C4029uF(String str) {
        s(str);
    }

    public void A(int i) {
        this.j = i;
    }

    public void B(int i) {
        this.s = i;
    }

    public int a() {
        return this.d;
    }

    public BF b() {
        return this.l;
    }

    public BF c() {
        return this.m;
    }

    public BF d() {
        return this.n;
    }

    public String e() {
        return this.f;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.q;
    }

    public void h(int i) {
        this.a = i;
    }

    public void i(int i) {
        this.k = i;
    }

    public void j(int i) {
        this.b = i;
    }

    public void k(BF bf) {
        this.t = bf;
    }

    public void l(int i) {
        this.c = i;
    }

    public void m(int i) {
        this.d = i;
    }

    public void n(RectF rectF) {
        this.u = rectF;
    }

    public void o(String str) {
        this.e = str;
    }

    public void p(BF bf) {
        this.l = bf;
    }

    public void q(BF bf) {
        this.m = bf;
    }

    public void r(BF bf) {
        this.n = bf;
    }

    public void s(String str) {
        this.f = str;
    }

    public void t(String str) {
        this.g = str;
    }

    public void u(int i) {
        this.h = i;
    }

    public void v(int i) {
        this.i = i;
    }

    public void w(int i) {
        this.o = i;
    }

    public void x(int i) {
        this.p = i;
    }

    public void y(int i) {
        this.q = i;
    }

    public void z(int i) {
        this.r = i;
    }

    public C4029uF(BF bf) {
        h(bf.j("Ascent").n());
        j(bf.j("CapHeight").n());
        l(bf.j("Descent").n());
        m(bf.j("Flags").n());
        s(bf.j("FontName").s());
        v(bf.j("ItalicAngle").n());
        A(bf.j("StemV").n());
        BF[] bfArrD = bf.j("FontBBox").d();
        float[] fArr = new float[4];
        for (int i = 0; i < 4; i++) {
            fArr[i] = bfArrD[i].m();
        }
        float f = fArr[0];
        float f2 = fArr[1];
        n(new RectF(f, f2, fArr[2] - f, fArr[3] - f2));
        if (bf.k().containsKey("AvgWidth")) {
            i(bf.j("AvgWidth").n());
        }
        if (bf.k().containsKey("FontFile")) {
            p(bf.j("FontFile"));
        }
        if (bf.k().containsKey("FontFile2")) {
            q(bf.j("FontFile2"));
        }
        if (bf.k().containsKey("FontFile3")) {
            r(bf.j("FontFile3"));
        }
        if (bf.k().containsKey("Leading")) {
            w(bf.j("Leading").n());
        }
        if (bf.k().containsKey("MaxWidth")) {
            x(bf.j("MaxWidth").n());
        }
        if (bf.k().containsKey("MissingWidth")) {
            y(bf.j("MissingWidth").n());
        }
        if (bf.k().containsKey("StemH")) {
            z(bf.j("StemH").n());
        }
        if (bf.k().containsKey("XHeight")) {
            B(bf.j("XHeight").n());
        }
        if (bf.k().containsKey("CharSet")) {
            k(bf.j("CharSet"));
        }
        if (bf.k().containsKey("FontFamily")) {
            o(bf.j("FontFamily").s());
        }
        if (bf.k().containsKey("FontWeight")) {
            u(bf.j("FontWeight").n());
        }
        if (bf.k().containsKey("FontStretch")) {
            t(bf.j("FontStretch").s());
        }
    }
}
