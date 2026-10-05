package defpackage;

import com.google.android.gms.stats.WakeLock;

/* JADX INFO: renamed from: a60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC1202a60 implements Runnable {
    public final /* synthetic */ WakeLock a;

    public RunnableC1202a60(WakeLock wakeLock) {
        this.a = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.zza(0);
    }
}
