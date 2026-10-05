package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class UncaughtExceptionHandlers {

    public static final class a implements Thread.UncaughtExceptionHandler {
        public static final Logger b = Logger.getLogger(a.class.getName());
        public final Runtime a;

        public a(Runtime runtime) {
            this.a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } catch (Throwable th2) {
                try {
                    PrintStream printStream = System.err;
                    printStream.println(th.getMessage());
                    printStream.println(th2.getMessage());
                } finally {
                    this.a.exit(1);
                }
            }
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new a(Runtime.getRuntime());
    }
}
