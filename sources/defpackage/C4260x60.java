package defpackage;

import com.google.android.gms.internal.clearcut.zzbb;

/* JADX INFO: renamed from: x60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4260x60 extends K60 {
    public final int b;
    public final int c;

    public C4260x60(byte[] bArr, int i, int i2) {
        super(bArr);
        zzbb.zzb(i, i + i2, bArr.length);
        this.b = i;
        this.c = i2;
    }

    @Override // defpackage.K60
    public final int b() {
        return this.b;
    }

    @Override // defpackage.K60, com.google.android.gms.internal.clearcut.zzbb
    public final int size() {
        return this.c;
    }

    @Override // defpackage.K60, com.google.android.gms.internal.clearcut.zzbb
    public final byte zzj(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.a[this.b + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}
