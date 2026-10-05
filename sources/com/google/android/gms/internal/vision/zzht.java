package com.google.android.gms.internal.vision;

import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC4306xg0;
import defpackage.Be0;
import defpackage.C4059ue0;
import defpackage.C4302xe0;
import defpackage.C4383ye0;
import defpackage.C4474ze0;
import defpackage.Oe0;
import defpackage.Pe0;
import defpackage.Qe0;
import defpackage.Zd0;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzht implements Serializable, Iterable<Byte> {
    public static final zzht zza = new Qe0(zzjf.zzb);
    private static final Be0 zzb;
    private static final Comparator<zzht> zzd;
    private int zzc = 0;

    static {
        C4059ue0 c4059ue0 = null;
        zzb = Zd0.b() ? new Pe0(c4059ue0) : new C4474ze0(c4059ue0);
        zzd = new C4302xe0();
    }

    public static zzht zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new Qe0(zzb.a(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    public static Oe0 zzc(int i) {
        return new Oe0(i, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZza = this.zzc;
        if (iZza == 0) {
            int iZza2 = zza();
            iZza = zza(iZza2, 0, iZza2);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzc = iZza;
        }
        return iZza;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new C4059ue0(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()), zza() <= 50 ? AbstractC4306xg0.a(this) : String.valueOf(AbstractC4306xg0.a(zza(0, 47))).concat("..."));
    }

    public abstract byte zza(int i);

    public abstract int zza();

    public abstract int zza(int i, int i2, int i3);

    public abstract zzht zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzhq zzhqVar);

    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzb(int i);

    public abstract boolean zzc();

    public final int zzd() {
        return this.zzc;
    }

    public static zzht zzb(byte[] bArr, int i, int i2) {
        return new C4383ye0(bArr, i, i2);
    }

    public static zzht zza(byte[] bArr) {
        return new Qe0(bArr);
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzjf.zza);
    }

    public static zzht zza(String str) {
        return new Qe0(str.getBytes(zzjf.zza));
    }

    public static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
