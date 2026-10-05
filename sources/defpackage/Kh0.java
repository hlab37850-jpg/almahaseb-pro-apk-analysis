package defpackage;

import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class Kh0 {
    public final Object a = new Object();
    public Queue b;
    public boolean c;

    public final void a(Bh0 bh0) {
        synchronized (this.a) {
            try {
                if (this.b == null) {
                    this.b = new ArrayDeque();
                }
                this.b.add(bh0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Task task) {
        Bh0 bh0;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        try {
                            bh0 = (Bh0) this.b.poll();
                            if (bh0 == null) {
                                this.c = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    bh0.a(task);
                }
            }
        }
    }
}
