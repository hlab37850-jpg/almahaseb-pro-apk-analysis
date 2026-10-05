package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: renamed from: sa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3888sa {
    public static C3888sa e;
    public Handler a;
    public HandlerThread b;
    public int c = 0;
    public final Object d = new Object();

    public static C3888sa d() {
        if (e == null) {
            e = new C3888sa();
        }
        return e;
    }

    public final void a() {
        synchronized (this.d) {
            try {
                if (this.a == null) {
                    if (this.c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.b = handlerThread;
                    handlerThread.start();
                    this.a = new Handler(this.b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.d) {
            try {
                int i = this.c - 1;
                this.c = i;
                if (i == 0) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.d) {
            a();
            this.a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.d) {
            this.c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.d) {
            this.b.quit();
            this.b = null;
            this.a = null;
        }
    }
}
