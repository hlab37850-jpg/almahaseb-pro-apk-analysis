package defpackage;

import java.util.List;

/* JADX INFO: renamed from: bc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1806bc0 extends Ub0 {
    public final Zb0 b = new Zb0();

    @Override // defpackage.Ub0
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> listA = this.b.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            try {
                for (Throwable th2 : listA) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // defpackage.Ub0
    public final void b(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.b.a(th, true).add(th2);
    }
}
