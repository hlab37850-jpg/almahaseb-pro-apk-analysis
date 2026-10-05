package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public enum KB {
    NO_CACHE(1),
    NO_STORE(2);

    public final int a;

    KB(int i) {
        this.a = i;
    }

    public static boolean a(int i) {
        return (i & NO_CACHE.a) == 0;
    }

    public static boolean b(int i) {
        return (i & NO_STORE.a) == 0;
    }
}
