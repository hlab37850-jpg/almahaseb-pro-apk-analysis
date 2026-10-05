package com.google.android.gms.internal.auth;

import android.content.Context;
import defpackage.AbstractC3537o90;
import defpackage.B80;
import defpackage.C2338h80;
import defpackage.InterfaceC4102v80;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdc {
    public static final /* synthetic */ int zzd = 0;
    private static volatile AbstractC3537o90 zze = null;
    private static volatile boolean zzf = false;
    final zzcz zzb;
    final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(zzcu.zza, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    public /* synthetic */ zzdc(zzcz zzczVar, String str, Object obj, boolean z, zzdb zzdbVar) {
        if (zzczVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzb = zzczVar;
        this.zzc = str;
        this.zzj = obj;
        this.zzm = true;
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            try {
                                AbstractC3537o90 abstractC3537o90 = zze;
                                Context applicationContext = context.getApplicationContext();
                                if (applicationContext != null) {
                                    context = applicationContext;
                                }
                                if (abstractC3537o90 == null || abstractC3537o90.a() != context) {
                                    zzcg.zzd();
                                    zzdd.zzc();
                                    B80.d();
                                    zze = new C2338h80(context, zzdn.zza(new zzdj() { // from class: com.google.android.gms.internal.auth.zzct
                                        @Override // com.google.android.gms.internal.auth.zzdj
                                        public final Object zza() {
                                            Context context2 = context;
                                            int i = zzdc.zzd;
                                            return zzcp.zza(context2);
                                        }
                                    }));
                                    zzi.incrementAndGet();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    public final Object zzb() {
        InterfaceC4102v80 interfaceC4102v80Zza;
        Object objZzb;
        if (!this.zzm && this.zzc == null) {
            throw new NullPointerException("flagName must not be null");
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        AbstractC3537o90 abstractC3537o90 = zze;
                        if (abstractC3537o90 == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        zzcz zzczVar = this.zzb;
                        boolean z = zzczVar.zzf;
                        if (zzczVar.zzb == null) {
                            Context contextA = abstractC3537o90.a();
                            String str = this.zzb.zza;
                            interfaceC4102v80Zza = zzdd.zza(contextA, null, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else if (zzcq.zza(abstractC3537o90.a(), this.zzb.zzb)) {
                            boolean z2 = this.zzb.zzh;
                            interfaceC4102v80Zza = zzcg.zza(abstractC3537o90.a().getContentResolver(), this.zzb.zzb, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else {
                            interfaceC4102v80Zza = null;
                        }
                        Object objZza = (interfaceC4102v80Zza == null || (objZzb = interfaceC4102v80Zza.zzb(zzc())) == null) ? null : zza(objZzb);
                        if (objZza == null) {
                            if (this.zzb.zze) {
                                objZza = null;
                            } else {
                                String strB = B80.a(abstractC3537o90.a()).zzb(this.zzb.zze ? null : this.zzc);
                                if (strB != null) {
                                    objZza = zza(strB);
                                } else {
                                    objZza = null;
                                }
                            }
                            if (objZza == null) {
                                objZza = this.zzj;
                            }
                        }
                        zzdh zzdhVar = (zzdh) abstractC3537o90.b().zza();
                        if (zzdhVar.zzb()) {
                            zzci zzciVar = (zzci) zzdhVar.zza();
                            zzcz zzczVar2 = this.zzb;
                            String strZza = zzciVar.zza(zzczVar2.zzb, null, zzczVar2.zzd, this.zzc);
                            objZza = strZza == null ? this.zzj : zza(strZza);
                        }
                        this.zzl = objZza;
                        this.zzk = i;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzl;
    }

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}
