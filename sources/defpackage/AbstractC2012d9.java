package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: renamed from: d9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2012d9 {
    public short a;
    public short b;

    public AbstractC2012d9(short s, short s2) {
        this.a = s;
        this.b = s2;
    }

    public static AbstractC2012d9 a(short s, short s2) {
        if (s == 0) {
            return new C2093e9(s2);
        }
        if (s == 4) {
            return new C2175f9(s2);
        }
        if (s == 6) {
            return new C2257g9(s2);
        }
        System.out.println("Unsupport CMap format: " + ((int) s));
        return null;
    }

    public static AbstractC2012d9 f(T8 t8) {
        short sP = t8.p();
        t8.t(Math.min(t8.p() & 65535, t8.s()));
        AbstractC2012d9 abstractC2012d9A = a(sP, t8.p());
        if (abstractC2012d9A == null) {
            return null;
        }
        abstractC2012d9A.h(t8.s(), t8);
        return abstractC2012d9A;
    }

    public abstract T8 b();

    public short c() {
        return this.a;
    }

    public short d() {
        return this.b;
    }

    public abstract short e();

    public abstract char g(char c);

    public abstract void h(int i, T8 t8);

    public String toString() {
        return "         format: " + ((int) c()) + " length: " + ((int) e()) + " language: " + ((int) d()) + StringUtilities.LF;
    }
}
