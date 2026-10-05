package defpackage;

import com.google.android.gms.internal.clearcut.zzbk;
import com.google.android.gms.internal.clearcut.zzco;

/* JADX INFO: loaded from: classes2.dex */
public final class X60 extends zzbk {
    public final byte[] a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public X60(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.g = Integer.MAX_VALUE;
        this.a = bArr;
        this.c = i2 + i;
        this.e = i;
        this.f = i;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzaf() {
        return this.e - this.f;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzl(int i) throws zzco {
        if (i < 0) {
            throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iZzaf = i + zzaf();
        int i2 = this.g;
        if (iZzaf > i2) {
            throw zzco.zzbl();
        }
        this.g = iZzaf;
        int i3 = this.c + this.d;
        this.c = i3;
        int i4 = i3 - this.f;
        if (i4 > iZzaf) {
            int i5 = i4 - iZzaf;
            this.d = i5;
            this.c = i3 - i5;
        } else {
            this.d = 0;
        }
        return i2;
    }
}
