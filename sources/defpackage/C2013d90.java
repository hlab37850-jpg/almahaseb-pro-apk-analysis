package defpackage;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.zza;
import com.google.firebase.messaging.zzb;
import com.google.firebase.messaging.zzn;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: d90, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2013d90 {
    public final Executor a;
    public final Context b;
    public final zzn c;

    public C2013d90(Context context, zzn zznVar, Executor executor) {
        this.a = executor;
        this.b = context;
        this.c = zznVar;
    }

    public final boolean a() {
        if (this.c.zzb("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10L);
            }
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (runningAppProcessInfo.importance != 100) {
                            break;
                        }
                        return false;
                    }
                }
            }
        }
        Gg0 gg0D = Gg0.d(this.c.zza("gcm.n.image"));
        if (gg0D != null) {
            gg0D.g(this.a);
        }
        zza zzaVarZza = zzb.zza(this.b, this.c);
        NotificationCompat.Builder builder = zzaVarZza.zza;
        if (gg0D != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(gg0D.c(), 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                gg0D.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                String strValueOf = String.valueOf(e.getCause());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
                sb.append("Failed to download image: ");
                sb.append(strValueOf);
                Log.w("FirebaseMessaging", sb.toString());
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                gg0D.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.b.getSystemService("notification")).notify(zzaVarZza.zzb, 0, zzaVarZza.zza.build());
        return true;
    }
}
