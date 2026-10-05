package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: renamed from: v60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4098v60 extends BroadcastReceiver {
    public RunnableC2334h60 a;

    public C4098v60(RunnableC2334h60 runnableC2334h60) {
        this.a = runnableC2334h60;
    }

    public final void a() {
        if (FirebaseInstanceId.zzd()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        RunnableC2334h60 runnableC2334h60 = this.a;
        if (runnableC2334h60 != null && runnableC2334h60.b()) {
            if (FirebaseInstanceId.zzd()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.a, 0L);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
