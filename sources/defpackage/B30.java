package defpackage;

import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class B30 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ zzfi.zzo b;
    public final /* synthetic */ DynamiteClearcutLogger c;

    public B30(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzfi.zzo zzoVar) {
        this.c = dynamiteClearcutLogger;
        this.a = i;
        this.b = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.zzc.zza(this.a, this.b);
    }
}
