package defpackage;

/* JADX INFO: renamed from: sJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3871sJ extends AbstractC3790rJ {
    public static float c(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int d(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long e(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static float f(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int g(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long h(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static Comparable i(Comparable comparable, Comparable comparable2) {
        AbstractC4492zt.h(comparable, "<this>");
        AbstractC4492zt.h(comparable2, "maximumValue");
        return comparable.compareTo(comparable2) > 0 ? comparable2 : comparable;
    }

    public static double j(double d, double d2, double d3) {
        if (d2 <= d3) {
            if (d < d2) {
                return d2;
            }
            return d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static float k(float f, float f2, float f3) {
        if (f2 <= f3) {
            if (f < f2) {
                return f2;
            }
            return f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int l(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            return i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static int m(int i, InterfaceC0815Pb interfaceC0815Pb) {
        AbstractC4492zt.h(interfaceC0815Pb, "range");
        if (interfaceC0815Pb instanceof InterfaceC0789Ob) {
            return ((Number) o(Integer.valueOf(i), (InterfaceC0789Ob) interfaceC0815Pb)).intValue();
        }
        if (!interfaceC0815Pb.isEmpty()) {
            if (i < ((Number) interfaceC0815Pb.getStart()).intValue()) {
                return ((Number) interfaceC0815Pb.getStart()).intValue();
            }
            return i > ((Number) interfaceC0815Pb.getEndInclusive()).intValue() ? ((Number) interfaceC0815Pb.getEndInclusive()).intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC0815Pb + '.');
    }

    public static long n(long j, long j2, long j3) {
        if (j2 <= j3) {
            if (j < j2) {
                return j2;
            }
            return j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static Comparable o(Comparable comparable, InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(comparable, "<this>");
        AbstractC4492zt.h(interfaceC0789Ob, "range");
        if (!interfaceC0789Ob.isEmpty()) {
            if (!interfaceC0789Ob.a(comparable, interfaceC0789Ob.getStart()) || interfaceC0789Ob.a(interfaceC0789Ob.getStart(), comparable)) {
                return (!interfaceC0789Ob.a(interfaceC0789Ob.getEndInclusive(), comparable) || interfaceC0789Ob.a(comparable, interfaceC0789Ob.getEndInclusive())) ? comparable : interfaceC0789Ob.getEndInclusive();
            }
            return interfaceC0789Ob.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC0789Ob + '.');
    }

    public static C0945Ts p(int i, int i2) {
        return C0945Ts.d.a(i, i2, -1);
    }

    public static C0945Ts q(C0945Ts c0945Ts) {
        AbstractC4492zt.h(c0945Ts, "<this>");
        return C0945Ts.d.a(c0945Ts.c(), c0945Ts.b(), -c0945Ts.d());
    }

    public static C0945Ts r(C0945Ts c0945Ts, int i) {
        AbstractC4492zt.h(c0945Ts, "<this>");
        AbstractC3790rJ.a(i > 0, Integer.valueOf(i));
        C0945Ts.a aVar = C0945Ts.d;
        int iB = c0945Ts.b();
        int iC = c0945Ts.c();
        if (c0945Ts.d() <= 0) {
            i = -i;
        }
        return aVar.a(iB, iC, i);
    }

    public static C1001Vs s(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? C1001Vs.e.a() : new C1001Vs(i, i2 - 1);
    }
}
