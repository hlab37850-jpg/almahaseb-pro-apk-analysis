package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IC {
    public static final YS a = new YS("LOCK_FAIL");
    public static final YS b = new YS("UNLOCK_FAIL");
    public static final YS c;
    public static final YS d;
    public static final C1019Wk e;
    public static final C1019Wk f;

    static {
        YS ys = new YS("LOCKED");
        c = ys;
        YS ys2 = new YS("UNLOCKED");
        d = ys2;
        e = new C1019Wk(ys);
        f = new C1019Wk(ys2);
    }

    public static final GC a(boolean z) {
        return new HC(z);
    }

    public static /* synthetic */ GC b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }
}
