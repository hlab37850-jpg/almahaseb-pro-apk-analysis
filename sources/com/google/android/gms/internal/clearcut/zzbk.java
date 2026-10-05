package com.google.android.gms.internal.clearcut;

import defpackage.X60;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbk {
    private static volatile boolean zzft = true;
    private int zzfq;
    private int zzfr;
    private boolean zzfs;

    private zzbk() {
        this.zzfq = 100;
        this.zzfr = Integer.MAX_VALUE;
        this.zzfs = false;
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzm(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzaf();

    public abstract int zzl(int i);

    public static zzbk zza(byte[] bArr, int i, int i2, boolean z) {
        X60 x60 = new X60(bArr, 0, i2, false);
        try {
            x60.zzl(i2);
            return x60;
        } catch (zzco e) {
            throw new IllegalArgumentException(e);
        }
    }
}
