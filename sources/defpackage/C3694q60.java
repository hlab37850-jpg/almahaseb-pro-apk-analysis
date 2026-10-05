package defpackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: q60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3694q60 {
    public int a = 0;
    public final Map b = new ArrayMap();
    public final R50 c;

    public C3694q60(R50 r50) {
        this.c = r50;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    public static boolean d(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        byte b;
        String[] strArrSplit = str.split("!");
        if (strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            try {
                int iHashCode = str2.hashCode();
                if (iHashCode != 83) {
                    if (iHashCode == 85 && str2.equals("U")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("S")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    firebaseInstanceId.zzb(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    }
                } else if (b == 1) {
                    firebaseInstanceId.zzc(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e) {
                if (!"SERVICE_NOT_AVAILABLE".equals(e.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                    if (e.getMessage() != null) {
                        throw e;
                    }
                    Log.e("FirebaseInstanceId", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                }
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 53);
                sb.append("Topic operation failed: ");
                sb.append(message);
                sb.append(". Will retry Topic operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                return false;
            }
        }
        return true;
    }

    public final synchronized Task a(String str) {
        String strA;
        TaskCompletionSource taskCompletionSource;
        synchronized (this.c) {
            strA = this.c.a();
            R50 r50 = this.c;
            StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 1 + String.valueOf(str).length());
            sb.append(strA);
            sb.append(",");
            sb.append(str);
            r50.d(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource();
        this.b.put(Integer.valueOf(this.a + (TextUtils.isEmpty(strA) ? 0 : strA.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final synchronized boolean b() {
        return e() != null;
    }

    public final boolean c(FirebaseInstanceId firebaseInstanceId) {
        TaskCompletionSource taskCompletionSource;
        while (true) {
            synchronized (this) {
                try {
                    String strE = e();
                    if (strE == null) {
                        if (FirebaseInstanceId.zzd()) {
                            Log.d("FirebaseInstanceId", "topic sync succeeded");
                        }
                        return true;
                    }
                    if (!d(firebaseInstanceId, strE)) {
                        return false;
                    }
                    synchronized (this) {
                        taskCompletionSource = (TaskCompletionSource) this.b.remove(Integer.valueOf(this.a));
                        f(strE);
                        this.a++;
                    }
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final String e() {
        String strA;
        synchronized (this.c) {
            strA = this.c.a();
        }
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String[] strArrSplit = strA.split(",");
        if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1])) {
            return null;
        }
        return strArrSplit[1];
    }

    public final synchronized boolean f(String str) {
        synchronized (this.c) {
            try {
                String strA = this.c.a();
                String strValueOf = String.valueOf(str);
                if (!strA.startsWith(strValueOf.length() != 0 ? ",".concat(strValueOf) : new String(","))) {
                    return false;
                }
                String strValueOf2 = String.valueOf(str);
                this.c.d(strA.substring((strValueOf2.length() != 0 ? ",".concat(strValueOf2) : new String(",")).length()));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
