package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LL {
    public static final Object a(Throwable th) {
        AbstractC4492zt.h(th, "exception");
        return new KL.b(th);
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof KL.b) {
            throw ((KL.b) obj).a;
        }
    }
}
