package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.vision.zzbi;
import defpackage.AbstractC1770b70;
import defpackage.AbstractC3696q70;
import defpackage.B50;
import defpackage.C4017u60;
import defpackage.Q50;
import defpackage.R60;
import defpackage.Y60;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbi<T> {
    private static volatile AbstractC3696q70 zzb = null;
    private static volatile boolean zzc = false;
    private final zzbo zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzbi<?>>> zzd = new AtomicReference<>();
    private static zzbs zze = new zzbs(R60.a);
    private static final AtomicInteger zzi = new AtomicInteger();

    private zzbi(zzbo zzboVar, String str, T t, boolean z) {
        this.zzj = -1;
        String str2 = zzboVar.zza;
        if (str2 == null && zzboVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && zzboVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzboVar;
        this.zzg = str;
        this.zzh = t;
        this.zzl = z;
    }

    @Deprecated
    public static void zza(final Context context) {
        synchronized (zza) {
            try {
                AbstractC3696q70 abstractC3696q70 = zzb;
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                if (abstractC3696q70 == null || abstractC3696q70.a() != context) {
                    zzau.zzb();
                    zzbq.zza();
                    C4017u60.b();
                    zzb = new B50(context, zzdi.zza(new zzdf(context) { // from class: U60
                        public final Context a;

                        {
                            this.a = context;
                        }

                        @Override // com.google.android.gms.internal.vision.zzdf
                        public final Object zza() {
                            return zzbi.zzc(this.a);
                        }
                    }));
                    zzi.incrementAndGet();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zzb(Context context) {
        if (zzb != null) {
            return;
        }
        synchronized (zza) {
            try {
                if (zzb == null) {
                    zza(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final /* synthetic */ boolean zzd() {
        return true;
    }

    public abstract T zza(Object obj);

    /* JADX WARN: Code duplicated, block: B:30:0x0050 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:8:0x001c, B:10:0x0020, B:14:0x0027, B:16:0x0032, B:31:0x0052, B:33:0x0062, B:35:0x0078, B:36:0x007b, B:37:0x007f, B:19:0x0039, B:30:0x0050, B:24:0x0042, B:27:0x0049, B:38:0x0083), top: B:44:0x001c }] */
    public final T zzc() {
        T tZza;
        if (!this.zzl) {
            zzde.zzb(zze.zza(this.zzg), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i = zzi.get();
        if (this.zzj < i) {
            synchronized (this) {
                try {
                    if (this.zzj < i) {
                        AbstractC3696q70 abstractC3696q70 = zzb;
                        zzde.zzb(abstractC3696q70 != null, "Must call PhenotypeFlag.init() first");
                        if (this.zzf.zzf) {
                            tZza = zzb(abstractC3696q70);
                            if (tZza == null && (tZza = zza(abstractC3696q70)) == null) {
                                tZza = this.zzh;
                            }
                        } else {
                            tZza = zza(abstractC3696q70);
                            if (tZza == null && (tZza = zzb(abstractC3696q70)) == null) {
                                tZza = this.zzh;
                            }
                        }
                        zzcy zzcyVar = (zzcy) abstractC3696q70.b().zza();
                        if (zzcyVar.zza()) {
                            zzbe zzbeVar = (zzbe) zzcyVar.zzb();
                            zzbo zzboVar = this.zzf;
                            String strZza = zzbeVar.zza(zzboVar.zzb, zzboVar.zza, zzboVar.zzd, this.zzg);
                            tZza = strZza == null ? this.zzh : zza((Object) strZza);
                        }
                        this.zzk = tZza;
                        this.zzj = i;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzk;
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    private final T zzb(AbstractC3696q70 abstractC3696q70) {
        zzcw<Context, Boolean> zzcwVar;
        zzbo zzboVar = this.zzf;
        if (!zzboVar.zze && ((zzcwVar = zzboVar.zzi) == null || zzcwVar.zza(abstractC3696q70.a()).booleanValue())) {
            C4017u60 c4017u60A = C4017u60.a(abstractC3696q70.a());
            zzbo zzboVar2 = this.zzf;
            Object objZza = c4017u60A.zza(zzboVar2.zze ? null : zza(zzboVar2.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    public /* synthetic */ zzbi(zzbo zzboVar, String str, Object obj, boolean z, AbstractC1770b70 abstractC1770b70) {
        this(zzboVar, str, obj, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> zzbi<T> zzb(zzbo zzboVar, String str, T t, zzbp<T> zzbpVar, boolean z) {
        return new Y60(zzboVar, str, t, true, zzbpVar);
    }

    public static void zza() {
        zzi.incrementAndGet();
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.zzg);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private final T zza(AbstractC3696q70 abstractC3696q70) {
        Q50 q50Zza;
        Object objZza;
        String str;
        if (!this.zzf.zzg && (str = (String) C4017u60.a(abstractC3696q70.a()).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) != null && zzaq.zzb.matcher(str).matches()) {
            if (Log.isLoggable("PhenotypeFlag", 3)) {
                String strValueOf = String.valueOf(zzb());
                Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
            }
        } else {
            if (this.zzf.zzb != null) {
                if (!zzbg.zza(abstractC3696q70.a(), this.zzf.zzb)) {
                    q50Zza = null;
                } else if (this.zzf.zzh) {
                    ContentResolver contentResolver = abstractC3696q70.a().getContentResolver();
                    String lastPathSegment = this.zzf.zzb.getLastPathSegment();
                    String packageName = abstractC3696q70.a().getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                    sb.append(lastPathSegment);
                    sb.append("#");
                    sb.append(packageName);
                    q50Zza = zzau.zza(contentResolver, zzbj.zza(sb.toString()));
                } else {
                    q50Zza = zzau.zza(abstractC3696q70.a().getContentResolver(), this.zzf.zzb);
                }
            } else {
                q50Zza = zzbq.zza(abstractC3696q70.a(), this.zzf.zza);
            }
            if (q50Zza != null && (objZza = q50Zza.zza(zzb())) != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    public static final /* synthetic */ zzcy zzc(Context context) {
        new zzbh();
        return zzbh.zza(context);
    }
}
