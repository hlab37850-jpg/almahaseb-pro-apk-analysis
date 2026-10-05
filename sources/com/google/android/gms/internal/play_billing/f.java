package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final f d = new f();
    public final Runnable a;
    public final Executor b;
    public f c;

    public f() {
        this.a = null;
        this.b = null;
    }

    public f(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
