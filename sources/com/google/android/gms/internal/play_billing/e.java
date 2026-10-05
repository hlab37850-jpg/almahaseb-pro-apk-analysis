package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e b = new e(new a("Failure occurred while trying to finish a future."));
    public static final e c = new e(new b("Failure.exception is unexpectedly null."));
    public final Throwable a;

    public class a extends Throwable {
        public a(String str) {
            super("Failure occurred while trying to finish a future.");
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    public class b extends Throwable {
        public b(String str) {
            super("Failure.exception is unexpectedly null.");
        }

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    public e(Throwable th) {
        th.getClass();
        this.a = th;
    }
}
