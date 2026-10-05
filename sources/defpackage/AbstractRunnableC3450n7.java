package defpackage;

/* JADX INFO: renamed from: n7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRunnableC3450n7 implements Runnable {
    public static boolean e = false;
    public int a = 0;
    public Object b = new Object();
    public Object c = new Object();
    public Thread d;

    public AbstractRunnableC3450n7() {
        i(1);
    }

    public abstract void a();

    public synchronized void b(boolean z) {
        try {
            if (this.d != null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            } else {
                if (f()) {
                    return;
                }
                if (z) {
                    this.d = Thread.currentThread();
                    run();
                } else {
                    Thread thread = new Thread(this);
                    this.d = thread;
                    thread.setName(getClass().getName());
                    this.d.start();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int c() {
        return this.a;
    }

    public synchronized void d(boolean z) {
        b(z);
    }

    public boolean e() {
        int i = this.a;
        return i == 2 || i == 4;
    }

    public boolean f() {
        int iC = c();
        return iC == 6 || iC == 7;
    }

    public abstract int g();

    public void h(Exception exc) {
        if (!e) {
            exc.printStackTrace();
        }
        i(7);
    }

    public void i(int i) {
        synchronized (this.b) {
            this.a = i;
            this.b.notifyAll();
        }
    }

    public abstract void j();

    @Override // java.lang.Runnable
    public void run() {
        if (c() == 1) {
            j();
        }
        i(2);
        synchronized (this.c) {
            while (!f() && c() != 5) {
                try {
                    if (e()) {
                        i(4);
                        while (c() == 4) {
                            try {
                                i(g());
                            } catch (Exception e2) {
                                h(e2);
                            }
                        }
                        if (c() == 4) {
                            i(2);
                        }
                    } else {
                        synchronized (this.b) {
                            if (!e()) {
                                try {
                                    this.b.wait();
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (c() == 6 || c() == 7) {
            a();
        }
        this.d = null;
    }
}
