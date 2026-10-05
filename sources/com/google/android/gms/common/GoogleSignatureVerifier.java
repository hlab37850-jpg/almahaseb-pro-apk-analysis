package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import defpackage.AbstractBinderC3165jf0;
import defpackage.Cg0;
import defpackage.Ff0;
import defpackage.Xg0;
import defpackage.xi0;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.zzc = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    Xg0.e(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static final AbstractBinderC3165jf0 zza(PackageInfo packageInfo, AbstractBinderC3165jf0... abstractBinderC3165jf0Arr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            Ff0 ff0 = new Ff0(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < abstractBinderC3165jf0Arr.length; i++) {
                if (abstractBinderC3165jf0Arr[i].equals(ff0)) {
                    return abstractBinderC3165jf0Arr[i];
                }
            }
        }
        return null;
    }

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? zza(packageInfo2, Cg0.a) : zza(packageInfo2, Cg0.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final xi0 zzc(String str, boolean z, boolean z2) {
        xi0 xi0VarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return xi0.c("null pkg");
        }
        if (str.equals(this.zzd)) {
            return xi0.b();
        }
        if (Xg0.g()) {
            xi0VarC = Xg0.b(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    xi0VarC = xi0.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        xi0VarC = xi0.c("single cert required");
                    } else {
                        Ff0 ff0 = new Ff0(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        xi0 xi0VarA = Xg0.a(str2, ff0, zHonorsDebugCertificates, false);
                        xi0VarC = (!xi0VarA.a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !Xg0.a(str2, ff0, false, true).a) ? xi0VarA : xi0.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                return xi0.d("no pkg ".concat(str), e);
            }
        }
        if (xi0VarC.a) {
            this.zzd = str;
        }
        return xi0VarC;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        xi0 xi0VarZzc = zzc(str, false, false);
        xi0VarZzc.e();
        return xi0VarZzc.a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        xi0 xi0VarC;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            xi0VarC = xi0.c("no pkgs");
        } else {
            xi0VarC = null;
            for (String str : packagesForUid) {
                xi0VarC = zzc(str, false, false);
                if (!xi0VarC.a) {
                }
            }
            Preconditions.checkNotNull(xi0VarC);
        }
        xi0VarC.e();
        return xi0VarC.a;
    }
}
