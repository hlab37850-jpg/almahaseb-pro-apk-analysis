package defpackage;

/* JADX INFO: renamed from: Oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0796Oi extends DN {
    public static final C0796Oi g = new C0796Oi();

    public C0796Oi() {
        super(FT.b, FT.c, FT.d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        return "Dispatchers.Default";
    }
}
