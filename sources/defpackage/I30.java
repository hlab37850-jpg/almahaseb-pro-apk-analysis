package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;

/* JADX INFO: loaded from: classes2.dex */
public final class I30 implements Runnable {
    public final /* synthetic */ LifecycleCallback a;
    public final /* synthetic */ String b;
    public final /* synthetic */ zzb c;

    public I30(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.c = zzbVar;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzb zzbVar = this.c;
        if (zzbVar.zzc > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            if (zzbVar.zzd != null) {
                bundle = zzbVar.zzd.getBundle(this.b);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (this.c.zzc >= 2) {
            this.a.onStart();
        }
        if (this.c.zzc >= 3) {
            this.a.onResume();
        }
        if (this.c.zzc >= 4) {
            this.a.onStop();
        }
        if (this.c.zzc >= 5) {
            this.a.onDestroy();
        }
    }
}
