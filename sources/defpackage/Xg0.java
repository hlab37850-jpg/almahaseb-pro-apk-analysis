package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import defpackage.Xg0;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Xg0 {
    public static volatile zzag e;
    public static Context g;
    public static final Zf0 a = new Fb0(AbstractBinderC3165jf0.c("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    public static final Zf0 b = new Dc0(AbstractBinderC3165jf0.c("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    public static final Zf0 c = new Cd0(AbstractBinderC3165jf0.c("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    public static final Zf0 d = new Ee0(AbstractBinderC3165jf0.c("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    public static final Object f = new Object();

    public static xi0 a(String str, AbstractBinderC3165jf0 abstractBinderC3165jf0, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return h(str, abstractBinderC3165jf0, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static xi0 b(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, true);
    }

    public static xi0 c(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, false);
    }

    public static /* synthetic */ String d(boolean z, String str, AbstractBinderC3165jf0 abstractBinderC3165jf0) {
        String str2 = (z || !h(str, abstractBinderC3165jf0, true, false).a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestZza = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(messageDigestZza);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(messageDigestZza.digest(abstractBinderC3165jf0.t())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void e(Context context) {
        if (g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            g = context.getApplicationContext();
        }
    }

    public static boolean f() {
        boolean zZzg;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                zZzg = e.zzg();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zZzg = false;
        }
        return zZzg;
    }

    public static boolean g() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                zZzi = e.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zZzi = false;
        }
        return zZzi;
    }

    public static xi0 h(final String str, final AbstractBinderC3165jf0 abstractBinderC3165jf0, final boolean z, boolean z2) {
        try {
            j();
            Preconditions.checkNotNull(g);
            try {
                return e.zzh(new zzs(str, abstractBinderC3165jf0, z, z2), ObjectWrapper.wrap(g.getPackageManager())) ? xi0.b() : new pi0(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return Xg0.d(z, str, abstractBinderC3165jf0);
                    }
                }, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return xi0.d("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return xi0.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    public static xi0 i(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        xi0 xi0VarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(g);
            try {
                j();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.wrap(g), false, true);
                try {
                    zzq zzqVarZze = z4 ? e.zze(zzoVar) : e.zzf(zzoVar);
                    if (zzqVarZze.zzb()) {
                        xi0VarD = xi0.f(zzqVarZze.zzc());
                    } else {
                        String strZza = zzqVarZze.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarZze.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        xi0VarD = xi0.g(zzqVarZze.zzc(), zzqVarZze.zzd(), strZza, nameNotFoundException);
                    }
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    xi0VarD = xi0.d("module call", e2);
                }
            } catch (DynamiteModule.LoadingException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                xi0VarD = xi0.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            return xi0VarD;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static void j() {
        if (e != null) {
            return;
        }
        Preconditions.checkNotNull(g);
        synchronized (f) {
            try {
                if (e == null) {
                    e = zzaf.zzb(DynamiteModule.load(g, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
