package com.google.android.gms.internal.clearcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.clearcut.zzae;
import com.google.android.gms.internal.clearcut.zzy;
import defpackage.J40;
import defpackage.Z40;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzae<T> {
    private static final Object zzdn = new Object();
    private static boolean zzdo = false;
    private static volatile Boolean zzdp;
    private static volatile Boolean zzdq;

    @SuppressLint({"StaticFieldLeak"})
    private static Context zzh;
    private final zzao zzdr;
    final String zzds;
    private final String zzdt;
    private final T zzdu;
    private T zzdv;
    private volatile zzab zzdw;
    private volatile SharedPreferences zzdx;

    private zzae(zzao zzaoVar, String str, T t) {
        this.zzdv = null;
        this.zzdw = null;
        this.zzdx = null;
        if (zzaoVar.zzef == null && zzaoVar.zzeg == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzaoVar.zzef != null && zzaoVar.zzeg != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzdr = zzaoVar;
        String strValueOf = String.valueOf(zzaoVar.zzeh);
        String strValueOf2 = String.valueOf(str);
        this.zzdt = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        String strValueOf3 = String.valueOf(zzaoVar.zzei);
        String strValueOf4 = String.valueOf(str);
        this.zzds = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
        this.zzdu = t;
    }

    public static void maybeInit(Context context) {
        Context applicationContext;
        if (zzh == null) {
            synchronized (zzdn) {
                try {
                    if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                        context = applicationContext;
                    }
                    if (zzh != context) {
                        zzdp = null;
                    }
                    zzh = context;
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzdo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> zzae<T> zza(zzao zzaoVar, String str, T t, zzan<T> zzanVar) {
        return new C1909d(zzaoVar, str, t, zzanVar);
    }

    @TargetApi(24)
    private final T zzl() {
        boolean zBooleanValue;
        if (zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String strValueOf = String.valueOf(this.zzds);
            Log.w("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else if (this.zzdr.zzeg != null) {
            if (this.zzdw == null) {
                this.zzdw = zzab.zza(zzh.getContentResolver(), this.zzdr.zzeg);
            }
            final zzab zzabVar = this.zzdw;
            String str = (String) zza(new Z40(this, zzabVar) { // from class: com.google.android.gms.internal.clearcut.a
                public final zzae a;
                public final zzab b;

                {
                    this.a = this;
                    this.b = zzabVar;
                }

                @Override // defpackage.Z40
                public final Object zzp() {
                    return this.b.zzg().get(this.a.zzds);
                }
            });
            if (str != null) {
                return zzb(str);
            }
        } else if (this.zzdr.zzef != null) {
            if (Build.VERSION.SDK_INT < 24 || zzh.isDeviceProtectedStorage()) {
                zBooleanValue = true;
            } else {
                if (zzdq == null || !zzdq.booleanValue()) {
                    zzdq = Boolean.valueOf(((UserManager) zzh.getSystemService(UserManager.class)).isUserUnlocked());
                }
                zBooleanValue = zzdq.booleanValue();
            }
            if (!zBooleanValue) {
                return null;
            }
            if (this.zzdx == null) {
                this.zzdx = zzh.getSharedPreferences(this.zzdr.zzef, 0);
            }
            SharedPreferences sharedPreferences = this.zzdx;
            if (sharedPreferences.contains(this.zzds)) {
                return zza(sharedPreferences);
            }
        }
        return null;
    }

    private final T zzm() {
        String str;
        if (this.zzdr.zzej || !zzn() || (str = (String) zza(new Z40(this) { // from class: A40
            public final zzae a;

            {
                this.a = this;
            }

            @Override // defpackage.Z40
            public final Object zzp() {
                return this.a.zzo();
            }
        })) == null) {
            return null;
        }
        return zzb(str);
    }

    private static boolean zzn() {
        if (zzdp == null) {
            Context context = zzh;
            if (context == null) {
                return false;
            }
            zzdp = Boolean.valueOf(PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzdp.booleanValue();
    }

    public final T get() {
        if (zzh == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        if (this.zzdr.zzek) {
            T tZzm = zzm();
            if (tZzm != null) {
                return tZzm;
            }
            T tZzl = zzl();
            if (tZzl != null) {
                return tZzl;
            }
        } else {
            T tZzl2 = zzl();
            if (tZzl2 != null) {
                return tZzl2;
            }
            T tZzm2 = zzm();
            if (tZzm2 != null) {
                return tZzm2;
            }
        }
        return this.zzdu;
    }

    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zzb(String str);

    public final /* synthetic */ String zzo() {
        return zzy.zza(zzh.getContentResolver(), this.zzdt, (String) null);
    }

    public /* synthetic */ zzae(zzao zzaoVar, String str, Object obj, J40 j40) {
        this(zzaoVar, str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzae<String> zza(zzao zzaoVar, String str, String str2) {
        return new C1908c(zzaoVar, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzae<Boolean> zza(zzao zzaoVar, String str, boolean z) {
        return new C1907b(zzaoVar, str, Boolean.valueOf(z));
    }

    private static <V> V zza(Z40 z40) {
        try {
            return (V) z40.zzp();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return (V) z40.zzp();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public static boolean zza(final String str, boolean z) {
        final boolean z2 = false;
        if (zzn()) {
            return ((Boolean) zza(new Z40(str, z2) { // from class: E40
                public final String a;
                public final boolean b = false;

                {
                    this.a = str;
                }

                @Override // defpackage.Z40
                public final Object zzp() {
                    return Boolean.valueOf(zzy.zza(zzae.zzh.getContentResolver(), this.a, this.b));
                }
            })).booleanValue();
        }
        return false;
    }
}
