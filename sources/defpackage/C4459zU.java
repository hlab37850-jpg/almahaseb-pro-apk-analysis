package defpackage;

/* JADX INFO: renamed from: zU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4459zU {
    public static final C4459zU a = new C4459zU();
    public static final ThreadLocal b = new ThreadLocal();

    public final AbstractC0422Dl a() {
        return (AbstractC0422Dl) b.get();
    }

    public final AbstractC0422Dl b() {
        ThreadLocal threadLocal = b;
        AbstractC0422Dl abstractC0422Dl = (AbstractC0422Dl) threadLocal.get();
        if (abstractC0422Dl != null) {
            return abstractC0422Dl;
        }
        AbstractC0422Dl abstractC0422DlA = AbstractC0548Gl.a();
        threadLocal.set(abstractC0422DlA);
        return abstractC0422DlA;
    }

    public final void c() {
        b.set(null);
    }

    public final void d(AbstractC0422Dl abstractC0422Dl) {
        b.set(abstractC0422Dl);
    }
}
