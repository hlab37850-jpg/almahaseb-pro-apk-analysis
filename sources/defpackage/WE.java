package defpackage;

import com.itextpdf.tool.xml.css.CSS;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WE {
    public static final UE[] a = {new a("+", 2, true, 500), new b("-", 2, true, 500), new e("*", 2, true, 1000), new f("/", 2, true, 1000), new g("^", 2, false, Constants.CP_MAC_ROMAN), new h(CSS.Value.PERCENTAGE, 2, true, 1000), new c("-", 1, false, 5000), new d("+", 1, false, 5000)};

    public static class a extends UE {
        public a(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return dArr[0] + dArr[1];
        }
    }

    public static class b extends UE {
        public b(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return dArr[0] - dArr[1];
        }
    }

    public static class c extends UE {
        public c(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return -dArr[0];
        }
    }

    public static class d extends UE {
        public d(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return dArr[0];
        }
    }

    public static class e extends UE {
        public e(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return dArr[0] * dArr[1];
        }
    }

    public static class f extends UE {
        public f(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            double d = dArr[1];
            if (d != 0.0d) {
                return dArr[0] / d;
            }
            throw new ArithmeticException("Division by zero!");
        }
    }

    public static class g extends UE {
        public g(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            return Math.pow(dArr[0], dArr[1]);
        }
    }

    public static class h extends UE {
        public h(String str, int i, boolean z, int i2) {
            super(str, i, z, i2);
        }

        @Override // defpackage.UE
        public double a(double... dArr) {
            double d = dArr[1];
            if (d != 0.0d) {
                return dArr[0] % d;
            }
            throw new ArithmeticException("Division by zero!");
        }
    }

    public static UE a(char c2, int i) {
        if (c2 == '%') {
            return a[5];
        }
        if (c2 == '-') {
            return i != 1 ? a[1] : a[6];
        }
        if (c2 == '/') {
            return a[3];
        }
        if (c2 == '^') {
            return a[4];
        }
        if (c2 == '*') {
            return a[2];
        }
        if (c2 != '+') {
            return null;
        }
        return i != 1 ? a[0] : a[7];
    }
}
