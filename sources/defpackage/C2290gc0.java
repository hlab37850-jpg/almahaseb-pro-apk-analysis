package defpackage;

/* JADX INFO: renamed from: gc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2290gc0 extends Ub0 {
    @Override // defpackage.Ub0
    public final void a(Throwable th) {
        th.printStackTrace();
    }

    @Override // defpackage.Ub0
    public final void b(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
