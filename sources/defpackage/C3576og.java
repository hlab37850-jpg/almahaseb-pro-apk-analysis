package defpackage;

import java.nio.ByteBuffer;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: og, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3576og extends AbstractC0360Bb {
    public Cipher a;

    public C3576og(String str) {
        this.a = Cipher.getInstance(str);
    }

    @Override // defpackage.AbstractC0360Bb
    public void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        this.a.doFinal(byteBuffer, byteBuffer2);
    }

    @Override // defpackage.AbstractC0360Bb
    public void b(byte[] bArr, int i, int i2, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        this.a.doFinal(bArr, i, i2, bArr2);
    }

    @Override // defpackage.AbstractC0360Bb
    public byte[] c(byte[] bArr) {
        return this.a.doFinal(bArr);
    }

    @Override // defpackage.AbstractC0360Bb
    public void e(int i, Key key) {
        e(i, key);
    }

    @Override // defpackage.AbstractC0360Bb
    public void f(int i, SecretKey secretKey) {
        f(i, secretKey);
    }

    @Override // defpackage.AbstractC0360Bb
    public void g(int i, SecretKeySpec secretKeySpec) {
        g(i, secretKeySpec);
    }

    @Override // defpackage.AbstractC0360Bb
    public void h(int i, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) {
        h(i, secretKeySpec, ivParameterSpec);
    }
}
