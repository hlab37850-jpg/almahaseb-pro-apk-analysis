package defpackage;

/* JADX INFO: renamed from: qD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC3704qD {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);

    public final int a;

    EnumC3704qD(int i) {
        this.a = i;
    }

    public static boolean a(int i) {
        return (i & OFFLINE.a) != 0;
    }

    public static boolean b(int i) {
        return (i & NO_CACHE.a) == 0;
    }

    public static boolean c(int i) {
        return (i & NO_STORE.a) == 0;
    }
}
