package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: xR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4284xR implements InterfaceC3461nF {
    public static final byte[] d = {115, 65, 108, 84};
    public static final byte[] e = {40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, DocWriter.GT, UnsignedBytes.MAX_POWER_OF_TWO, DocWriter.FORWARD, 12, -87, -2, 100, 83, 105, 122};
    public boolean a;
    public byte[] b;
    public a c;

    /* JADX INFO: renamed from: xR$a */
    public enum a {
        RC4,
        AESV2;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            int length = aVarArrValuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }

        public boolean a() {
            return this == AESV2;
        }

        public boolean b() {
            return this == RC4;
        }
    }

    public C4284xR(a aVar, BF bf, int i, int i2, byte[] bArr, byte[] bArr2, int i3, boolean z, GF gf) throws C3338ll, EF, C3420ml {
        this.a = false;
        this.c = aVar;
        byte[] bArrQ = bf == null ? null : bf.e(0).q();
        B(i);
        try {
            List listB = gf.b(false);
            for (int i4 = 0; this.b == null && i4 < listB.size(); i4++) {
                byte[] bArr3 = (byte[]) listB.get(i4);
                byte[] bArrG = g(bArr3, bArrQ, i, i2, bArr, bArr2, i3, z);
                this.b = bArrG;
                if (bArrG != null) {
                    this.a = true;
                } else {
                    this.b = h(bArr3, bArrQ, i, i2, bArr, bArr2, i3, z);
                }
            }
            if (this.b == null) {
                throw new C2346hF("Password failed authentication for both owner and user password");
            }
        } catch (GeneralSecurityException e2) {
            throw new EF("Unable to check passwords: " + e2.getMessage(), e2);
        }
    }

    public final void A(AbstractC0360Bb abstractC0360Bb, byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        byte[] bArr3 = new byte[length];
        for (int i = 19; i >= 0; i--) {
            for (int i2 = 0; i2 < length; i2++) {
                bArr3[i2] = (byte) (bArr2[i2] ^ i);
            }
            w(abstractC0360Bb, m(bArr3));
            o(abstractC0360Bb, bArr);
        }
    }

    public final void B(int i) throws C3338ll, EF {
        byte[] bArr = new byte[16];
        Arrays.fill(bArr, (byte) -82);
        byte[] bArr2 = new byte[u(i / 8)];
        Arrays.fill(bArr2, (byte) -82);
        try {
            j(T8.K(bArr), bArr2);
            try {
                k();
                if (this.c != a.RC4) {
                    try {
                        AbstractC0360Bb abstractC0360BbL = l();
                        byte[] bArr3 = new byte[5];
                        Arrays.fill(bArr2, (byte) -82);
                        try {
                            w(abstractC0360BbL, m(bArr3));
                        } catch (InvalidKeyException e2) {
                            throw new C3338ll("JCE did not accept 40-bit RC4 key; policy problem?", e2);
                        }
                    } catch (GeneralSecurityException e3) {
                        throw new C3338ll("JCE did not offer RC4 cipher", e3);
                    }
                }
            } catch (NoSuchAlgorithmException e4) {
                throw new C3338ll("No MD5 digest available from JCE", e4);
            }
        } catch (EF e5) {
            throw new EF("Internal error; failed to produce test cipher: " + e5.getMessage());
        } catch (InvalidAlgorithmParameterException e6) {
            throw new C3338ll("JCE did not accept cipher parameter", e6);
        } catch (InvalidKeyException e7) {
            throw new C3338ll("JCE does accept key size of " + (t() * 8) + " bits- could it be a policy restriction?", e7);
        } catch (NoSuchAlgorithmException e8) {
            throw new C3338ll("JCE does not offer required cipher", e8);
        } catch (NoSuchPaddingException e9) {
            throw new C3338ll("JCE does not offer required padding", e9);
        }
    }

    @Override // defpackage.InterfaceC3461nF
    public T8 a(String str, BF bf, T8 t8) throws EF {
        if (str != null) {
            throw new EF("This encryption version does not support Crypt filters");
        }
        if (bf != null) {
            f(bf.p(), bf.o());
        }
        return p(t8, bf == null ? v() : s(bf.p(), bf.o()));
    }

    @Override // defpackage.InterfaceC3461nF
    public boolean b() {
        return this.a;
    }

    @Override // defpackage.InterfaceC3461nF
    public String c(int i, int i2, String str) throws EF {
        byte[] bArrB = LF.b(str);
        T8 t8P = p(T8.K(bArrB), s(i, i2));
        return LF.a(t8P.c(), t8P.d(), t8P.s());
    }

    public final byte[] d(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, int i3, boolean z) throws DigestException {
        byte[] bArrY = y(bArr);
        MessageDigest messageDigestK = k();
        messageDigestK.reset();
        messageDigestK.update(bArrY);
        messageDigestK.update(bArr3);
        messageDigestK.update((byte) (i3 & 255));
        messageDigestK.update((byte) ((i3 >> 8) & 255));
        messageDigestK.update((byte) ((i3 >> 16) & 255));
        messageDigestK.update((byte) (i3 >> 24));
        if (bArr2 != null) {
            messageDigestK.update(bArr2);
        }
        if (i2 >= 4 && !z) {
            for (int i4 = 0; i4 < 4; i4++) {
                messageDigestK.update((byte) -1);
            }
        }
        byte[] bArrDigest = messageDigestK.digest();
        int i5 = i2 == 2 ? 5 : i / 8;
        byte[] bArr4 = new byte[i5];
        if (i2 >= 3) {
            for (int i6 = 0; i6 < 50; i6++) {
                messageDigestK.update(bArrDigest, 0, i5);
                q(messageDigestK, bArrDigest);
            }
        }
        System.arraycopy(bArrDigest, 0, bArr4, 0, i5);
        return bArr4;
    }

    public final byte[] e(byte[] bArr, byte[] bArr2, int i) throws C3420ml {
        if (i == 2) {
            AbstractC0360Bb abstractC0360BbL = l();
            x(abstractC0360BbL, m(bArr));
            return n(abstractC0360BbL, e);
        }
        if (i < 3) {
            throw new C3420ml("Unsupported standard security handler revision " + i);
        }
        MessageDigest messageDigestK = k();
        messageDigestK.update(e);
        if (bArr2 != null) {
            messageDigestK.update(bArr2);
        }
        byte[] bArrDigest = messageDigestK.digest();
        AbstractC0360Bb abstractC0360BbL2 = l();
        x(abstractC0360BbL2, m(bArr));
        byte[] bArrN = n(abstractC0360BbL2, bArrDigest);
        z(bArrN, bArr, abstractC0360BbL2);
        byte[] bArr3 = new byte[32];
        System.arraycopy(bArrN, 0, bArr3, 0, bArrN.length);
        System.arraycopy(bArrN, 0, bArr3, 16, bArrN.length);
        return bArr3;
    }

    public final void f(int i, int i2) throws EF {
        if (i < 0) {
            throw new EF("Internal error: Object has bogus object number");
        }
        if (i2 < 0) {
            throw new EF("Internal error: Object has bogus generation number");
        }
    }

    public final byte[] g(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, byte[] bArr4, int i3, boolean z) throws DigestException, C3420ml {
        byte[] bArrN;
        byte[] bArrR = r(bArr, i, i2);
        AbstractC0360Bb abstractC0360BbL = l();
        w(abstractC0360BbL, m(bArrR));
        if (i2 == 2) {
            bArrN = n(abstractC0360BbL, bArr3);
        } else {
            if (i2 < 3) {
                throw new C3420ml("Unsupported revision: " + i2);
            }
            byte[] bArr5 = new byte[32];
            System.arraycopy(bArr3, 0, bArr5, 0, 32);
            A(abstractC0360BbL, bArr5, bArrR);
            bArrN = bArr5;
        }
        return h(bArrN, bArr2, i, i2, bArr3, bArr4, i3, z);
    }

    public final byte[] h(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, byte[] bArr4, int i3, boolean z) throws EF, DigestException, C3420ml {
        byte[] bArrD = d(bArr, bArr2, i, i2, bArr3, i3, z);
        byte[] bArrE = e(bArrD, bArr2, i2);
        if (bArr4.length != bArrE.length) {
            throw new EF("Improper U entry length; expected 32, is " + bArr4.length);
        }
        int i4 = i2 == 2 ? 32 : 16;
        for (int i5 = 0; i5 < i4; i5++) {
            if (bArr4[i5] != bArrE[i5]) {
                return null;
            }
        }
        return bArrD;
    }

    public final AbstractC0360Bb i() {
        return AbstractC0360Bb.d("AES/CBC/PKCS5Padding");
    }

    public final AbstractC0360Bb j(T8 t8, byte[] bArr) throws EF {
        if (this.c.b()) {
            AbstractC0360Bb abstractC0360BbD = AbstractC0360Bb.d("RC4");
            abstractC0360BbD.g(2, m(bArr));
            return abstractC0360BbD;
        }
        if (!this.c.a()) {
            throw new EF("Internal error - unhandled cipher type: " + this.c);
        }
        AbstractC0360Bb abstractC0360BbI = i();
        byte[] bArr2 = new byte[16];
        if (t8.F() < 16) {
            throw new EF("AES encrypted stream too short - no room for initialisation vector");
        }
        t8.j(bArr2);
        abstractC0360BbI.h(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return abstractC0360BbI;
    }

    public final MessageDigest k() {
        return MessageDigest.getInstance("MD5");
    }

    public final AbstractC0360Bb l() {
        return AbstractC0360Bb.d("RC4");
    }

    public final SecretKeySpec m(byte[] bArr) {
        return new SecretKeySpec(bArr, "RC4");
    }

    public final byte[] n(AbstractC0360Bb abstractC0360Bb, byte[] bArr) {
        return abstractC0360Bb.c(bArr);
    }

    public final void o(AbstractC0360Bb abstractC0360Bb, byte[] bArr) {
        abstractC0360Bb.b(bArr, 0, bArr.length, bArr);
    }

    public final T8 p(T8 t8, byte[] bArr) throws EF {
        try {
            AbstractC0360Bb abstractC0360BbJ = j(t8, bArr);
            try {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(t8.F());
                abstractC0360BbJ.a(t8.J(), byteBufferAllocate);
                byteBufferAllocate.flip();
                return T8.g(byteBufferAllocate);
            } catch (GeneralSecurityException e2) {
                throw new EF("Could not decrypt: " + e2.getMessage(), e2);
            }
        } catch (GeneralSecurityException e3) {
            throw new EF("Unable to create cipher due to platform limitation: " + e3.getMessage(), e3);
        }
    }

    public final void q(MessageDigest messageDigest, byte[] bArr) throws DigestException {
        messageDigest.digest(bArr, 0, bArr.length);
    }

    public final byte[] r(byte[] bArr, int i, int i2) throws DigestException {
        MessageDigest messageDigestK = k();
        messageDigestK.update(y(bArr));
        byte[] bArrDigest = messageDigestK.digest();
        if (i2 >= 3) {
            for (int i3 = 0; i3 < 50; i3++) {
                messageDigestK.update(bArrDigest);
                q(messageDigestK, bArrDigest);
            }
        }
        int i4 = i / 8;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArrDigest, 0, bArr2, 0, i4);
        return bArr2;
    }

    public final byte[] s(int i, int i2) throws EF {
        try {
            MessageDigest messageDigestK = k();
            messageDigestK.update(this.b);
            messageDigestK.update((byte) i);
            messageDigestK.update((byte) (i >> 8));
            messageDigestK.update((byte) (i >> 16));
            messageDigestK.update((byte) i2);
            messageDigestK.update((byte) (i2 >> 8));
            if (this.c == a.AESV2) {
                messageDigestK.update(d);
            }
            byte[] bArrDigest = messageDigestK.digest();
            int iT = t();
            byte[] bArr = new byte[iT];
            System.arraycopy(bArrDigest, 0, bArr, 0, iT);
            return bArr;
        } catch (NoSuchAlgorithmException e2) {
            throw new EF("Unable to get MD5 digester", e2);
        }
    }

    public final int t() {
        return u(this.b.length);
    }

    public final int u(int i) {
        return Math.min(i + 5, 16);
    }

    public final byte[] v() {
        return this.b;
    }

    public final void w(AbstractC0360Bb abstractC0360Bb, Key key) {
        abstractC0360Bb.e(2, key);
    }

    public final void x(AbstractC0360Bb abstractC0360Bb, SecretKey secretKey) {
        abstractC0360Bb.f(1, secretKey);
    }

    public final byte[] y(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] bArr2 = new byte[32];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length > 32 ? 32 : bArr.length);
        if (bArr.length < 32) {
            System.arraycopy(e, 0, bArr2, bArr.length, 32 - bArr.length);
        }
        return bArr2;
    }

    public final void z(byte[] bArr, byte[] bArr2, AbstractC0360Bb abstractC0360Bb) {
        int length = bArr2.length;
        byte[] bArr3 = new byte[length];
        for (int i = 1; i <= 19; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                bArr3[i2] = (byte) (bArr2[i2] ^ i);
            }
            x(abstractC0360Bb, m(bArr3));
            o(abstractC0360Bb, bArr);
        }
    }
}
