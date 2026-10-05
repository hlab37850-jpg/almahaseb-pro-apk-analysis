package defpackage;

import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import com.google.android.gms.internal.fido.zzbf;
import com.google.android.gms.internal.fido.zzbh;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: renamed from: y60, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C4341y60 extends zzbf {
    public final C3121j60 a;
    public final Character b;

    public C4341y60(C3121j60 c3121j60, Character ch) {
        this.a = c3121j60;
        if (ch != null && c3121j60.b('=')) {
            throw new IllegalArgumentException(zzan.zza("Padding character %s was already in alphabet", ch));
        }
        this.b = ch;
    }

    public final void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzam.zze(i, i + i2, bArr.length);
        int i3 = 0;
        zzam.zzc(i2 <= this.a.f);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & UnsignedBytes.MAX_VALUE))) << 8;
        }
        int i5 = ((i2 + 1) * 8) - this.a.d;
        while (i3 < i2 * 8) {
            C3121j60 c3121j60 = this.a;
            appendable.append(c3121j60.a(c3121j60.c & ((int) (j >>> (i5 - i3)))));
            i3 += this.a.d;
        }
        if (this.b != null) {
            while (i3 < this.a.f * 8) {
                this.b.charValue();
                appendable.append('=');
                i3 += this.a.d;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C4341y60) {
            C4341y60 c4341y60 = (C4341y60) obj;
            if (this.a.equals(c4341y60.a)) {
                Character ch = this.b;
                Character ch2 = c4341y60.b;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode();
        Character ch = this.b;
        return iHashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.a);
        if (8 % this.a.d != 0) {
            if (this.b == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.b);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    public void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        while (i3 < i2) {
            a(appendable, bArr, i3, Math.min(this.a.f, i2 - i3));
            i3 += this.a.f;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    public final int zzb(int i) {
        C3121j60 c3121j60 = this.a;
        return c3121j60.e * zzbh.zza(i, c3121j60.f, RoundingMode.CEILING);
    }

    public C4341y60(String str, String str2, Character ch) {
        this(new C3121j60(str, str2.toCharArray()), ch);
    }
}
