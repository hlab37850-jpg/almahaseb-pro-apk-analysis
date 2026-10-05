package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC2172f70;
import defpackage.C4434z70;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbv {
    Object[] zza = new Object[8];
    int zzb = 0;
    C4434z70 zzc;

    public final zzbv zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            if (i2 > length) {
                length = length + (length >> 1) + 1;
                if (length < i2) {
                    int iHighestOneBit = Integer.highestOneBit(i2 - 1);
                    length = iHighestOneBit + iHighestOneBit;
                }
                if (length < 0) {
                    length = Integer.MAX_VALUE;
                }
            }
            this.zza = Arrays.copyOf(objArr, length);
        }
        AbstractC2172f70.a(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzbw zzb() {
        C4434z70 c4434z70 = this.zzc;
        if (c4434z70 != null) {
            throw c4434z70.a();
        }
        C1919b c1919bA = C1919b.a(this.zzb, this.zza, this);
        C4434z70 c4434z71 = this.zzc;
        if (c4434z71 == null) {
            return c1919bA;
        }
        throw c4434z71.a();
    }
}
