package defpackage;

/* JADX INFO: renamed from: iE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2427iE {
    public static final InterfaceC4433z7 a = new a();

    /* JADX INFO: renamed from: iE$a */
    public static final class a implements InterfaceC4433z7 {
    }

    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }
}
