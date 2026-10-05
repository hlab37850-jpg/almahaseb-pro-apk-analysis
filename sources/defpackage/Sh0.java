package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.a;
import com.google.firebase.iid.zzaq;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class Sh0 {
    public final FirebaseApp a;
    public final zzaq b;
    public final a c;
    public final Executor d;
    public final UserAgentPublisher e;
    public final HeartBeatInfo f;
    public final FirebaseInstallationsApi g;

    public Sh0(FirebaseApp firebaseApp, zzaq zzaqVar, Executor executor, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, zzaqVar, executor, new a(firebaseApp.getApplicationContext(), zzaqVar), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    public static String e(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
        sb.append("Unexpected response: ");
        sb.append(strValueOf);
        Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final Task a(Task task) {
        return task.continueWith(AbstractC4472zd0.b(), new C2302gi0(this));
    }

    public final Task b(String str, String str2, String str3) {
        return i(c(str, str2, str3, new Bundle()));
    }

    public final Task c(final String str, final String str2, final String str3, final Bundle bundle) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.d.execute(new Runnable(this, str, str2, str3, bundle, taskCompletionSource) { // from class: oi0
            public final Sh0 a;
            public final String b;
            public final String c;
            public final String d;
            public final Bundle e;
            public final TaskCompletionSource f;

            {
                this.a = this;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = bundle;
                this.f = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.g(this.b, this.c, this.d, this.e, this.f);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final String d() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance(DigestAlgorithms.SHA1).digest(this.a.getName().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public final /* synthetic */ void g(String str, String str2, String str3, Bundle bundle, TaskCompletionSource taskCompletionSource) throws Throwable {
        try {
            h(str, str2, str3, bundle);
            taskCompletionSource.setResult(this.c.a(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }

    public final Bundle h(String str, String str2, String str3, Bundle bundle) throws Throwable {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.b.zzd()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.zzb());
        bundle.putString("app_ver_name", this.b.zzc());
        bundle.putString("firebase-app-name-hash", d());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.g.getToken(false))).getToken();
            if (TextUtils.isEmpty(token)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            }
        } catch (InterruptedException e) {
            e = e;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        } catch (ExecutionException e2) {
            e = e2;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        String version = LibraryVersion.getInstance().getVersion("firebase-iid");
        if ("UNKNOWN".equals(version)) {
            int i = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            version = sb.toString();
        }
        String strValueOf = String.valueOf(version);
        bundle.putString("cliv", strValueOf.length() != 0 ? "fiid-".concat(strValueOf) : new String("fiid-"));
        HeartBeatInfo.HeartBeat heartBeatCode = this.f.getHeartBeatCode("fire-iid");
        if (heartBeatCode != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", this.e.getUserAgent());
        }
        return bundle;
    }

    public final Task i(Task task) {
        return task.continueWith(this.d, new Bi0(this));
    }

    public final Task j(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return a(i(c(str, str2, str3, bundle)));
    }

    public final Task k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        String strValueOf2 = String.valueOf(str3);
        return a(i(c(str, str2, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    public final Task l(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String strValueOf2 = String.valueOf(str3);
        return a(i(c(str, str2, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle)));
    }

    public Sh0(FirebaseApp firebaseApp, zzaq zzaqVar, Executor executor, a aVar, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.a = firebaseApp;
        this.b = zzaqVar;
        this.c = aVar;
        this.d = executor;
        this.e = userAgentPublisher;
        this.f = heartBeatInfo;
        this.g = firebaseInstallationsApi;
    }
}
