package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class EF extends IOException {
    public EF(String str) {
        super(str);
    }

    public EF(String str, Throwable th) {
        this(str);
        initCause(th);
    }
}
