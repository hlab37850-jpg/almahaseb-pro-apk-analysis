package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {
    public final zzcj a;
    public final zzcz b;

    public d(zzcj zzcjVar, zzcz zzczVar) {
        this.a = zzcjVar;
        this.b = zzczVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.valueField != this) {
            return;
        }
        if (m.zzq(this.a, this, zzcj.zzr(this.b))) {
            zzcj.zzu(this.a, false);
        }
    }
}
