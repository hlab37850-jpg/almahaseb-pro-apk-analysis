package defpackage;

/* JADX INFO: renamed from: wh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4227wh0 extends AbstractC3497nh0 {
    public final C2300gh0 b = new C2300gh0();

    @Override // defpackage.AbstractC3497nh0
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.b.a(th, true).add(th2);
    }
}
