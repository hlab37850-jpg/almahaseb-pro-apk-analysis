package defpackage;

import java.util.Formatter;

/* JADX INFO: renamed from: fj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2221fj {
    public final D8 a;
    public final C0928Tb[] b;

    public C2221fj(D8 d8) {
        this.a = new D8(d8);
        this.b = new C0928Tb[(d8.e() - d8.g()) + 1];
    }

    public final D8 a() {
        return this.a;
    }

    public final C0928Tb b(int i) {
        return this.b[e(i)];
    }

    public final C0928Tb c(int i) {
        C0928Tb c0928Tb;
        C0928Tb c0928Tb2;
        C0928Tb c0928TbB = b(i);
        if (c0928TbB != null) {
            return c0928TbB;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iE = e(i) - i2;
            if (iE >= 0 && (c0928Tb2 = this.b[iE]) != null) {
                return c0928Tb2;
            }
            int iE2 = e(i) + i2;
            C0928Tb[] c0928TbArr = this.b;
            if (iE2 < c0928TbArr.length && (c0928Tb = c0928TbArr[iE2]) != null) {
                return c0928Tb;
            }
        }
        return null;
    }

    public final C0928Tb[] d() {
        return this.b;
    }

    public final int e(int i) {
        return i - this.a.g();
    }

    public final void f(int i, C0928Tb c0928Tb) {
        this.b[e(i)] = c0928Tb;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (C0928Tb c0928Tb : this.b) {
                if (c0928Tb == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(c0928Tb.c()), Integer.valueOf(c0928Tb.e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
