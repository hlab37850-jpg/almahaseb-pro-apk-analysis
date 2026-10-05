package defpackage;

import com.google.android.gms.internal.fido.zzam;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* JADX INFO: renamed from: t60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3936t60 extends C4341y60 {
    public C3936t60(String str, String str2, Character ch) {
        C3121j60 c3121j60 = new C3121j60(str, str2.toCharArray());
        super(c3121j60, ch);
        zzam.zzc(c3121j60.b.length == 64);
    }

    @Override // defpackage.C4341y60, com.google.android.gms.internal.fido.zzbf
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & UnsignedBytes.MAX_VALUE;
            int i6 = ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | (i5 << 16) | (bArr[i3 + 2] & UnsignedBytes.MAX_VALUE);
            appendable.append(this.a.a(i6 >>> 18));
            appendable.append(this.a.a((i6 >>> 12) & 63));
            appendable.append(this.a.a((i6 >>> 6) & 63));
            appendable.append(this.a.a(i6 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            a(appendable, bArr, i3, i2 - i3);
        }
    }
}
