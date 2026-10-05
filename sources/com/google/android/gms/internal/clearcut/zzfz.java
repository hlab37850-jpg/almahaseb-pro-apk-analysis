package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzfz {
    protected volatile int zzrs = -1;

    public String toString() {
        return zzga.zza(this);
    }

    public void zza(zzfs zzfsVar) {
    }

    public final int zzas() {
        int iZzen = zzen();
        this.zzrs = iZzen;
        return iZzen;
    }

    public int zzen() {
        return 0;
    }

    @Override // 
    /* JADX INFO: renamed from: zzep, reason: merged with bridge method [inline-methods] */
    public zzfz clone() {
        return (zzfz) super.clone();
    }

    public static final void zza(zzfz zzfzVar, byte[] bArr, int i, int i2) {
        try {
            zzfs zzfsVarZzh = zzfs.zzh(bArr, 0, i2);
            zzfzVar.zza(zzfsVarZzh);
            zzfsVarZzh.zzem();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }
}
