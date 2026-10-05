package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.zxing.client.android.Intents;
import defpackage.I50;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static int g;
    public static PendingIntent h;
    public final Context b;
    public final zzaq c;
    public Messenger e;
    public zzi f;
    public final SimpleArrayMap a = new SimpleArrayMap();
    public Messenger d = new Messenger(new I50(this, Looper.getMainLooper()));

    public a(Context context, zzaq zzaqVar) {
        this.b = context;
        this.c = zzaqVar;
    }

    public static synchronized String b() {
        int i;
        i = g;
        g = i + 1;
        return Integer.toString(i);
    }

    public static synchronized void c(Context context, Intent intent) {
        try {
            if (h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", h);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Bundle a(Bundle bundle) {
        if (this.c.zzd() < 12000000) {
            return g(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzad.zza(this.b).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
                sb.append("Error making request: ");
                sb.append(strValueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if ((e.getCause() instanceof zzap) && ((zzap) e.getCause()).zza() == 4) {
                return g(bundle);
            }
            return null;
        }
    }

    public final void d(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzi.zza());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzi) {
                        this.f = (zzi) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String strValueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            Log.d("FirebaseInstanceId", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    } else {
                        String strGroup = matcher.group(1);
                        String strGroup2 = matcher.group(2);
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        f(strGroup, extras);
                        return;
                    }
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String strValueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(strValueOf2);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (this.a) {
                        for (int i = 0; i < this.a.size(); i++) {
                            try {
                                f((String) this.a.keyAt(i), intent2.getExtras());
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                    Log.w("FirebaseInstanceId", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                f(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    public final void f(String str, Bundle bundle) {
        synchronized (this.a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(bundle);
                } else {
                    String strValueOf = String.valueOf(str);
                    Log.w("FirebaseInstanceId", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bundle g(Bundle bundle) throws IOException {
        Bundle bundleH = h(bundle);
        if (bundleH == null || !bundleH.containsKey("google.messenger")) {
            return bundleH;
        }
        Bundle bundleH2 = h(bundle);
        if (bundleH2 == null || !bundleH2.containsKey("google.messenger")) {
            return bundleH2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.tasks.TaskCompletionSource, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.tasks.TaskCompletionSource] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.Intent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r9v24, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v25, types: [android.content.Context] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ce -> B:66:0x00d9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d4 -> B:66:0x00d9). Please report as a decompilation issue!!! */
    public final Bundle h(Bundle bundle) throws IOException {
        ?? r1;
        ?? r2;
        ?? r3;
        String strB = b();
        ?? taskCompletionSource = new TaskCompletionSource();
        synchronized (this.a) {
            this.a.put(strB, taskCompletionSource);
        }
        if (this.c.zza() == 0) {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
        ?? intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.c.zza() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        c(this.b, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 5);
        sb.append("|ID|");
        sb.append(strB);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        ?? r4 = 3;
        ?? r5 = 3;
        r4 = 3;
        r4 = 3;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(strValueOf);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        intent.putExtra("google.messenger", this.d);
        if (this.e == null && this.f == null) {
            r3 = taskCompletionSource;
            r2 = intent;
            if (this.c.zza() == 2) {
                this.b.sendBroadcast(r2);
                r1 = r3;
                r4 = r5;
            } else {
                this.b.startService(r2);
                r1 = r3;
                r4 = r5;
            }
        } else {
            r3 = taskCompletionSource;
            r2 = intent;
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.e;
                if (messenger != null) {
                    messenger.send(messageObtain);
                    r1 = taskCompletionSource;
                } else {
                    this.f.zza(messageObtain);
                    r1 = taskCompletionSource;
                }
            } catch (RemoteException unused) {
                boolean zIsLoggable = Log.isLoggable("FirebaseInstanceId", r4);
                r3 = taskCompletionSource;
                r2 = intent;
                r5 = r4;
                if (zIsLoggable) {
                    Log.d("FirebaseInstanceId", "Messenger failed, fallback to startService");
                    r3 = taskCompletionSource;
                    r2 = intent;
                    r5 = "Messenger failed, fallback to startService";
                }
                r3 = taskCompletionSource;
                r2 = intent;
                if (this.c.zza() == 2) {
                    this.b.sendBroadcast(r2);
                    r1 = r3;
                    r4 = r5;
                } else {
                    this.b.startService(r2);
                    r1 = r3;
                    r4 = r5;
                }
            }
        }
        try {
            try {
                Task task = r1.getTask();
                taskCompletionSource = TimeUnit.MILLISECONDS;
                intent = 30000;
                Bundle bundle2 = (Bundle) Tasks.await(task, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, taskCompletionSource);
                synchronized (this.a) {
                    this.a.remove(strB);
                }
                return bundle2;
            } catch (Throwable th) {
                synchronized (this.a) {
                    this.a.remove(strB);
                    throw th;
                }
            }
        } catch (InterruptedException | TimeoutException unused2) {
            Log.w("FirebaseInstanceId", "No response");
            throw new IOException(Intents.Scan.TIMEOUT);
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }
}
