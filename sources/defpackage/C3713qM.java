package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: qM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3713qM extends RuntimeException {
    public final IOException a;
    public IOException b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3713qM(IOException iOException) {
        super(iOException);
        AbstractC4492zt.h(iOException, "firstConnectException");
        this.a = iOException;
        this.b = iOException;
    }

    public final void a(IOException iOException) throws IllegalAccessException, InvocationTargetException {
        AbstractC4492zt.h(iOException, "e");
        AbstractC0773Nl.a(this.a, iOException);
        this.b = iOException;
    }

    public final IOException b() {
        return this.a;
    }

    public final IOException c() {
        return this.b;
    }
}
