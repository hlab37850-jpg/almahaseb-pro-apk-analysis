package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class X80 {
    public static final X80 a;
    public static final X80 b;

    static {
        AbstractC1208a90 abstractC1208a90 = null;
        a = new C3619p90();
        b = new C4104v90();
    }

    public X80() {
    }

    public static X80 c() {
        return a;
    }

    public static X80 d() {
        return b;
    }

    public abstract void a(Object obj, long j);

    public abstract void b(Object obj, Object obj2, long j);
}
