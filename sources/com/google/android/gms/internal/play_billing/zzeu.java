package com.google.android.gms.internal.play_billing;

import defpackage.C3407md0;
import defpackage.C3810rb0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeu {
    static final zzeu zza = new zzeu(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzeu zzd;
    private final Map zze;

    public zzeu() {
        this.zze = new HashMap();
    }

    public static zzeu zza() {
        zzeu zzeuVar = zzd;
        if (zzeuVar != null) {
            return zzeuVar;
        }
        synchronized (zzeu.class) {
            try {
                zzeu zzeuVar2 = zzd;
                if (zzeuVar2 != null) {
                    return zzeuVar2;
                }
                C3407md0 c3407md0 = C3407md0.c;
                zzeu zzeuVarZzb = zzfc.zzb(zzeu.class);
                zzd = zzeuVarZzb;
                return zzeuVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzfh zzb(zzgl zzglVar, int i) {
        return (zzfh) this.zze.get(new C3810rb0(zzglVar, i));
    }

    public zzeu(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
