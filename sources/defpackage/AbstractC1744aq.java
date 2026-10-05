package defpackage;

/* JADX INFO: renamed from: aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1744aq {
    public static final AbstractC0452Ep[] a = {new k("sin"), new n("cos"), new o("tan"), new p("log"), new s("log1p"), new t("abs"), new u("acos"), new a("asin"), new b("atan"), new c("cbrt"), new i("ceil"), new d("floor"), new e("sinh"), new f("sqrt"), new g("tanh"), new h("cosh"), new j("pow", 2), new l("exp", 1), new m("expm1", 1), new r("log10"), new q("log2")};

    /* JADX INFO: renamed from: aq$a */
    public static class a extends AbstractC0452Ep {
        public a(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.asin(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$b */
    public static class b extends AbstractC0452Ep {
        public b(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.atan(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$c */
    public static class c extends AbstractC0452Ep {
        public c(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.cbrt(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$d */
    public static class d extends AbstractC0452Ep {
        public d(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.floor(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$e */
    public static class e extends AbstractC0452Ep {
        public e(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.sinh(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$f */
    public static class f extends AbstractC0452Ep {
        public f(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.sqrt(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$g */
    public static class g extends AbstractC0452Ep {
        public g(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.tanh(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$h */
    public static class h extends AbstractC0452Ep {
        public h(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.cosh(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$i */
    public static class i extends AbstractC0452Ep {
        public i(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.ceil(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$j */
    public static class j extends AbstractC0452Ep {
        public j(String str, int i) {
            super(str, i);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.pow(dArr[0], dArr[1]);
        }
    }

    /* JADX INFO: renamed from: aq$k */
    public static class k extends AbstractC0452Ep {
        public k(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.sin(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$l */
    public static class l extends AbstractC0452Ep {
        public l(String str, int i) {
            super(str, i);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.exp(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$m */
    public static class m extends AbstractC0452Ep {
        public m(String str, int i) {
            super(str, i);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.expm1(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$n */
    public static class n extends AbstractC0452Ep {
        public n(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.cos(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$o */
    public static class o extends AbstractC0452Ep {
        public o(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.tan(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$p */
    public static class p extends AbstractC0452Ep {
        public p(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.log(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$q */
    public static class q extends AbstractC0452Ep {
        public q(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.log(dArr[0]) / Math.log(2.0d);
        }
    }

    /* JADX INFO: renamed from: aq$r */
    public static class r extends AbstractC0452Ep {
        public r(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.log10(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$s */
    public static class s extends AbstractC0452Ep {
        public s(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.log1p(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$t */
    public static class t extends AbstractC0452Ep {
        public t(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.abs(dArr[0]);
        }
    }

    /* JADX INFO: renamed from: aq$u */
    public static class u extends AbstractC0452Ep {
        public u(String str) {
            super(str);
        }

        @Override // defpackage.AbstractC0452Ep
        public double a(double... dArr) {
            return Math.acos(dArr[0]);
        }
    }

    public static AbstractC0452Ep a(String str) {
        if (str.equals("sin")) {
            return a[0];
        }
        if (str.equals("cos")) {
            return a[1];
        }
        if (str.equals("tan")) {
            return a[2];
        }
        if (str.equals("asin")) {
            return a[7];
        }
        if (str.equals("acos")) {
            return a[6];
        }
        if (str.equals("atan")) {
            return a[8];
        }
        if (str.equals("sinh")) {
            return a[12];
        }
        if (str.equals("cosh")) {
            return a[15];
        }
        if (str.equals("tanh")) {
            return a[14];
        }
        if (str.equals("abs")) {
            return a[5];
        }
        if (str.equals("log")) {
            return a[3];
        }
        if (str.equals("log10")) {
            return a[19];
        }
        if (str.equals("log2")) {
            return a[20];
        }
        if (str.equals("log1p")) {
            return a[4];
        }
        if (str.equals("ceil")) {
            return a[10];
        }
        if (str.equals("floor")) {
            return a[11];
        }
        if (str.equals("sqrt")) {
            return a[13];
        }
        if (str.equals("cbrt")) {
            return a[9];
        }
        if (str.equals("pow")) {
            return a[16];
        }
        if (str.equals("exp")) {
            return a[17];
        }
        if (str.equals("expm1")) {
            return a[18];
        }
        return null;
    }
}
