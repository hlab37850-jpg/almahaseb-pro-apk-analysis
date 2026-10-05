package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final p b;
    public static final p c;
    public final Throwable a;

    static {
        if (zzo.zza) {
            c = null;
            b = null;
        } else {
            c = new p(false, null);
            b = new p(true, null);
        }
    }

    public p(boolean z, Throwable th) {
        this.a = th;
    }
}
