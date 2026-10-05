package defpackage;

import com.google.android.gms.internal.fido.zzam;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* JADX INFO: renamed from: o60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3531o60 extends C4341y60 {
    public final char[] c;

    public C3531o60(String str, String str2) {
        C3121j60 c3121j60 = new C3121j60("base16()", "0123456789ABCDEF".toCharArray());
        super(c3121j60, null);
        this.c = new char[512];
        zzam.zzc(c3121j60.b.length == 16);
        for (int i = 0; i < 256; i++) {
            this.c[i] = c3121j60.a(i >>> 4);
            this.c[i | 256] = c3121j60.a(i & 15);
        }
    }

    @Override // defpackage.C4341y60, com.google.android.gms.internal.fido.zzbf
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzam.zze(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
            appendable.append(this.c[i4]);
            appendable.append(this.c[i4 | 256]);
        }
    }
}
