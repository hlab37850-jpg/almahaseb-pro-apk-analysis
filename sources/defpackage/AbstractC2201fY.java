package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: fY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2201fY {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable("Volley", 2);

    /* JADX INFO: renamed from: fY$a */
    public static class a {
        public static final boolean c = AbstractC2201fY.b;
        public final List a = new ArrayList();
        public boolean b = false;

        /* JADX INFO: renamed from: fY$a$a, reason: collision with other inner class name */
        public static class C0283a {
            public final String a;
            public final long b;
            public final long c;

            public C0283a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.a.add(new C0283a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j = ((C0283a) this.a.get(0)).c;
            AbstractC2201fY.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (C0283a c0283a : this.a) {
                long j2 = c0283a.c;
                AbstractC2201fY.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0283a.b), c0283a.a);
                j = j2;
            }
        }

        public final long c() {
            if (this.a.size() == 0) {
                return 0L;
            }
            long j = ((C0283a) this.a.get(0)).c;
            List list = this.a;
            return ((C0283a) list.get(list.size() - 1)).c - j;
        }

        public void finalize() {
            if (this.b) {
                return;
            }
            b("Request on the loose");
            AbstractC2201fY.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(AbstractC2201fY.class)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (b) {
            Log.v(a, a(str, objArr));
        }
    }
}
