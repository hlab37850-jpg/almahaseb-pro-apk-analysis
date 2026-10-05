package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import defpackage.AbstractC4472zd0;
import defpackage.M60;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbe extends Binder {
    private final zzbg zza;

    public zzbe(zzbg zzbgVar) {
        this.zza = zzbgVar;
    }

    public final void zza(final M60 m60) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        this.zza.zza(m60.a).addOnCompleteListener(AbstractC4472zd0.b(), new OnCompleteListener(m60) { // from class: I60
            public final M60 a;

            {
                this.a = m60;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.a.b();
            }
        });
    }
}
