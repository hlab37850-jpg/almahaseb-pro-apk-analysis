package com.google.android.gms.phenotype;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.phenotype.zzf;
import com.google.android.gms.phenotype.PhenotypeFlag;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public abstract class PhenotypeFlag<T> {
    private static final Object zzak = new Object();

    @SuppressLint({"StaticFieldLeak"})
    private static Context zzal = null;
    private static boolean zzam = false;
    private static Boolean zzan;
    private final Factory zzao;
    final String zzap;
    private final String zzaq;
    private final T zzar;
    private T zzas;

    @KeepForSdk
    public static class Factory {
        private final String zzax;
        private final Uri zzay;
        private final String zzaz;
        private final String zzba;
        private final boolean zzbb;
        private final boolean zzbc;

        @KeepForSdk
        public Factory(Uri uri) {
            this(null, uri, "", "", false, false);
        }

        @KeepForSdk
        public PhenotypeFlag<String> createFlag(String str, String str2) {
            return PhenotypeFlag.zza(this, str, str2);
        }

        @KeepForSdk
        public Factory withGservicePrefix(String str) {
            boolean z = this.zzbb;
            if (z) {
                throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
            }
            return new Factory(this.zzax, this.zzay, str, this.zzba, z, this.zzbc);
        }

        @KeepForSdk
        public Factory withPhenotypePrefix(String str) {
            return new Factory(this.zzax, this.zzay, this.zzaz, str, this.zzbb, this.zzbc);
        }

        private Factory(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
            this.zzax = str;
            this.zzay = uri;
            this.zzaz = str2;
            this.zzba = str3;
            this.zzbb = z;
            this.zzbc = z2;
        }
    }

    public interface a {
        Object zzh();
    }

    private PhenotypeFlag(Factory factory, String str, T t) {
        this.zzas = null;
        if (factory.zzax == null && factory.zzay == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (factory.zzax != null && factory.zzay != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzao = factory;
        String strValueOf = String.valueOf(factory.zzaz);
        String strValueOf2 = String.valueOf(str);
        this.zzaq = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        String strValueOf3 = String.valueOf(factory.zzba);
        String strValueOf4 = String.valueOf(str);
        this.zzap = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
        this.zzar = t;
    }

    @KeepForSdk
    public static void maybeInit(Context context) {
        Context applicationContext;
        com.google.android.gms.internal.phenotype.zzh.maybeInit(context);
        if (zzal == null) {
            com.google.android.gms.internal.phenotype.zzh.init(context);
            synchronized (zzak) {
                try {
                    if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                        context = applicationContext;
                    }
                    if (zzal != context) {
                        zzan = null;
                    }
                    zzal = context;
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzam = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PhenotypeFlag<String> zza(Factory factory, String str, String str2) {
        return new g(factory, str, str2);
    }

    @TargetApi(24)
    private final T zzd() {
        if (zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String strValueOf = String.valueOf(this.zzap);
            Log.w("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else if (this.zzao.zzay != null) {
            final zza zzaVarZza = zza.zza(zzal.getContentResolver(), this.zzao.zzay);
            String str = (String) zza(new a(this, zzaVarZza) { // from class: com.google.android.gms.phenotype.e
                public final PhenotypeFlag a;
                public final zza b;

                {
                    this.a = this;
                    this.b = zzaVarZza;
                }

                @Override // com.google.android.gms.phenotype.PhenotypeFlag.a
                public final Object zzh() {
                    return this.b.zza().get(this.a.zzap);
                }
            });
            if (str != null) {
                return zza(str);
            }
        } else {
            if (this.zzao.zzax == null || !(Build.VERSION.SDK_INT < 24 || zzal.isDeviceProtectedStorage() || ((UserManager) zzal.getSystemService(UserManager.class)).isUserUnlocked())) {
                return null;
            }
            SharedPreferences sharedPreferences = zzal.getSharedPreferences(this.zzao.zzax, 0);
            if (sharedPreferences.contains(this.zzap)) {
                return zza(sharedPreferences);
            }
        }
        return null;
    }

    private final T zze() {
        String str;
        if (this.zzao.zzbb || !zzf() || (str = (String) zza(new a(this) { // from class: ph0
            public final PhenotypeFlag a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.phenotype.PhenotypeFlag.a
            public final Object zzh() {
                return this.a.zzg();
            }
        })) == null) {
            return null;
        }
        return zza(str);
    }

    private static boolean zzf() {
        if (zzan == null) {
            Context context = zzal;
            if (context == null) {
                return false;
            }
            zzan = Boolean.valueOf(PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzan.booleanValue();
    }

    @KeepForSdk
    public T get() {
        if (zzal == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        if (this.zzao.zzbc) {
            T tZze = zze();
            if (tZze != null) {
                return tZze;
            }
            T tZzd = zzd();
            if (tZzd != null) {
                return tZzd;
            }
        } else {
            T tZzd2 = zzd();
            if (tZzd2 != null) {
                return tZzd2;
            }
            T tZze2 = zze();
            if (tZze2 != null) {
                return tZze2;
            }
        }
        return this.zzar;
    }

    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(String str);

    public final /* synthetic */ String zzg() {
        return zzf.zza(zzal.getContentResolver(), this.zzaq, (String) null);
    }

    public /* synthetic */ PhenotypeFlag(Factory factory, String str, Object obj, f fVar) {
        this(factory, str, obj);
    }

    private static <V> V zza(a aVar) {
        try {
            return (V) aVar.zzh();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return (V) aVar.zzh();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public static boolean zza(final String str, boolean z) {
        final boolean z2 = false;
        if (zzf()) {
            return ((Boolean) zza(new a(str, z2) { // from class: Ah0
                public final String a;
                public final boolean b = false;

                {
                    this.a = str;
                }

                @Override // com.google.android.gms.phenotype.PhenotypeFlag.a
                public final Object zzh() {
                    return Boolean.valueOf(zzf.zza(PhenotypeFlag.zzal.getContentResolver(), this.a, this.b));
                }
            })).booleanValue();
        }
        return false;
    }
}
