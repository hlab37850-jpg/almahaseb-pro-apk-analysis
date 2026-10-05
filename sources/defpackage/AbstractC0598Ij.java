package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: Ij, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0598Ij {
    public static InterfaceC0624Jj a() {
        return EnumC1255al.INSTANCE;
    }

    public static InterfaceC0624Jj b() {
        return c(AbstractC1177Zp.b);
    }

    public static InterfaceC0624Jj c(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new C4198wM(runnable);
    }
}
