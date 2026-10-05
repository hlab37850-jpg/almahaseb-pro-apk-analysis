package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.iid.zzaq;
import com.google.firebase.iid.zzaz;
import java.io.IOException;

/* JADX INFO: renamed from: h60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC2334h60 implements Runnable {
    public final long a;
    public final PowerManager.WakeLock b;
    public final FirebaseInstanceId c;
    public final C3694q60 d;

    public RunnableC2334h60(FirebaseInstanceId firebaseInstanceId, zzaq zzaqVar, C3694q60 c3694q60, long j) {
        this.c = firebaseInstanceId;
        this.d = c3694q60;
        this.a = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public final Context a() {
        return this.c.zza().getApplicationContext();
    }

    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean c() throws IOException {
        C3285l60 c3285l60Zzb = this.c.zzb();
        if (!this.c.zza(c3285l60Zzb)) {
            return true;
        }
        try {
            String strZzc = this.c.zzc();
            if (strZzc == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((c3285l60Zzb == null || !strZzc.equals(c3285l60Zzb.a)) && FirebaseApp.DEFAULT_APP_NAME.equals(this.c.zza().getName())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf = String.valueOf(this.c.zza().getName());
                    Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(strValueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", strZzc);
                Context contextA = a();
                Intent intent2 = new Intent(contextA, (Class<?>) FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                contextA.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message2 = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message2);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zZza;
        if (zzaz.zza().zza(a())) {
            this.b.acquire();
        }
        try {
            this.c.zza(true);
            if (!this.c.zzf()) {
                this.c.zza(false);
            } else {
                if (zzaz.zza().zzb(a()) && !b()) {
                    new C4098v60(this).a();
                    if (zZza) {
                        return;
                    } else {
                        return;
                    }
                }
                if (c() && this.d.c(this.c)) {
                    this.c.zza(false);
                } else {
                    this.c.zza(this.a);
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.c.zza(false);
        } finally {
            if (zzaz.zza().zza(a())) {
                this.b.release();
            }
        }
    }
}
