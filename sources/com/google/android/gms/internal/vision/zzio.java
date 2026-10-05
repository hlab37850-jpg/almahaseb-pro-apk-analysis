package com.google.android.gms.internal.vision;

import defpackage.AbstractC2214ff0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class zzio {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzio zzc;
    private static volatile zzio zzd;
    private static final zzio zze = new zzio(true);
    private final Map<a, zzjb.zze<?, ?>> zzf;

    public static final class a {
        public final Object a;
        public final int b;

        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    public zzio() {
        this.zzf = new HashMap();
    }

    public static zzio zza() {
        return new zzio();
    }

    public static zzio zzb() {
        zzio zzioVar = zzc;
        if (zzioVar == null) {
            synchronized (zzio.class) {
                try {
                    zzioVar = zzc;
                    if (zzioVar == null) {
                        zzioVar = zze;
                        zzc = zzioVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzioVar;
    }

    public static zzio zzc() {
        zzio zzioVar = zzd;
        if (zzioVar != null) {
            return zzioVar;
        }
        synchronized (zzio.class) {
            try {
                zzio zzioVar2 = zzd;
                if (zzioVar2 != null) {
                    return zzioVar2;
                }
                zzio zzioVarA = AbstractC2214ff0.a(zzio.class);
                zzd = zzioVarA;
                return zzioVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <ContainingType extends zzkk> zzjb.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzjb.zze) this.zzf.get(new a(containingtype, i));
    }

    private zzio(boolean z) {
        this.zzf = Collections.emptyMap();
    }

    public final void zza(zzjb.zze<?, ?> zzeVar) {
        this.zzf.put(new a(zzeVar.zza, zzeVar.zzd.b), zzeVar);
    }
}
