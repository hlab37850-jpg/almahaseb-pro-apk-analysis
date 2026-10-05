package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3491ne0;
import defpackage.AbstractC3978te0;
import defpackage.C3816re0;
import defpackage.InterfaceC3814rd0;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzep extends zzdz {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzep.class.getName());
    private static final boolean zzd = AbstractC3491ne0.C();
    r zza;

    private zzep() {
        throw null;
    }

    public static int zzA(zzgl zzglVar, InterfaceC3814rd0 interfaceC3814rd0) {
        int iZze = ((zzds) zzglVar).zze(interfaceC3814rd0);
        return zzC(iZze) + iZze;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = AbstractC3978te0.c(str);
        } catch (C3816re0 unused) {
            length = str.getBytes(zzfo.zza).length;
        }
        return zzC(length) + length;
    }

    public static int zzC(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzD(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzy(int i, zzgl zzglVar, InterfaceC3814rd0 interfaceC3814rd0) {
        int iZzC = zzC(i << 3);
        return iZzC + iZzC + ((zzds) zzglVar).zze(interfaceC3814rd0);
    }

    public static int zzz(zzgl zzglVar) {
        int iZzj = zzglVar.zzj();
        return zzC(iZzj) + iZzj;
    }

    public final void zzE() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, C3816re0 c3816re0) throws zzen {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c3816re0);
        byte[] bytes = str.getBytes(zzfo.zza);
        try {
            int length = bytes.length;
            zzv(length);
            zzm(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i, boolean z);

    public abstract void zze(int i, zzei zzeiVar);

    public abstract void zzg(int i, int i2);

    public abstract void zzh(int i);

    public abstract void zzi(int i, long j);

    public abstract void zzj(long j);

    public abstract void zzk(int i, int i2);

    public abstract void zzl(int i);

    public abstract void zzm(byte[] bArr, int i, int i2);

    public abstract void zzn(int i, zzgl zzglVar, InterfaceC3814rd0 interfaceC3814rd0);

    public abstract void zzp(int i, zzgl zzglVar);

    public abstract void zzq(int i, zzei zzeiVar);

    public abstract void zzr(int i, String str);

    public abstract void zzt(int i, int i2);

    public abstract void zzu(int i, int i2);

    public abstract void zzv(int i);

    public abstract void zzw(int i, long j);

    public abstract void zzx(long j);

    public /* synthetic */ zzep(zzeo zzeoVar) {
    }
}
