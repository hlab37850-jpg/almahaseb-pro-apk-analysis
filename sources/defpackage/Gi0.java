package defpackage;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.api.client.googleapis.notifications.ResourceStates;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class Gi0 implements InterfaceC2088e60 {
    public final ExecutorService a;

    public Gi0(ExecutorService executorService) {
        this.a = executorService;
    }

    @Override // defpackage.InterfaceC2088e60
    public final Task zza(final Intent intent) {
        return Tasks.call(this.a, new Callable(intent) { // from class: S30
            public final Intent a;

            {
                this.a = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Intent intent2 = this.a;
                String stringExtra = intent2.getStringExtra("CMD");
                if (stringExtra != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String strValueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(stringExtra.length() + 21 + strValueOf.length());
                        sb.append("Received command: ");
                        sb.append(stringExtra);
                        sb.append(" - ");
                        sb.append(strValueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                    if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                        FirebaseInstanceId.getInstance().zze();
                    } else if (ResourceStates.SYNC.equals(stringExtra)) {
                        FirebaseInstanceId.getInstance().zzg();
                    }
                }
                return -1;
            }
        });
    }
}
