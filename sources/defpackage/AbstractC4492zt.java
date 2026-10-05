package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: zt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4492zt {

    /* JADX INFO: renamed from: zt$a */
    public static class a {
    }

    public static boolean a(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static boolean b(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean c(Float f, Float f2) {
        if (f == null) {
            if (f2 != null) {
                return false;
            }
        } else if (f2 == null || f.floatValue() != f2.floatValue()) {
            return false;
        }
        return true;
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void e(Object obj) {
        if (obj == null) {
            q();
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) n(new NullPointerException(str + " must not be null")));
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static int j(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int k(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static String l(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = AbstractC4492zt.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void m(int i, String str) {
        u();
    }

    public static Throwable n(Throwable th) {
        return o(th, AbstractC4492zt.class.getName());
    }

    public static Throwable o(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static String p(String str, Object obj) {
        return str + obj;
    }

    public static void q() {
        throw ((NullPointerException) n(new NullPointerException()));
    }

    public static void r(String str) {
        throw ((NullPointerException) n(new NullPointerException(str)));
    }

    public static void s(String str) {
        throw ((IllegalArgumentException) n(new IllegalArgumentException(l(str))));
    }

    public static void t(String str) {
        throw ((NullPointerException) n(new NullPointerException(l(str))));
    }

    public static void u() {
        v("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void v(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void w(String str) {
        throw ((EW) n(new EW(str)));
    }

    public static void x(String str) {
        w("lateinit property " + str + " has not been initialized");
    }
}
