package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class xi0 {
    public static final xi0 e = new xi0(true, 3, 1, null, null);
    public final boolean a;
    public final String b;
    public final Throwable c;
    public final int d;

    public xi0(boolean z, int i, int i2, String str, Throwable th) {
        this.a = z;
        this.d = i;
        this.b = str;
        this.c = th;
    }

    public static xi0 b() {
        return e;
    }

    public static xi0 c(String str) {
        return new xi0(false, 1, 5, str, null);
    }

    public static xi0 d(String str, Throwable th) {
        return new xi0(false, 1, 5, str, th);
    }

    public static xi0 f(int i) {
        return new xi0(true, i, 1, null, null);
    }

    public static xi0 g(int i, int i2, String str, Throwable th) {
        return new xi0(false, i, i2, str, th);
    }

    public String a() {
        return this.b;
    }

    public final void e() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
