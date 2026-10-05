package defpackage;

import java.nio.ByteBuffer;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: Bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0360Bb {
    public static AbstractC0360Bb d(String str) {
        return str.equals("RC4") ? new C3301lJ() : new C3576og(str);
    }

    public abstract void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public abstract void b(byte[] bArr, int i, int i2, byte[] bArr2);

    public abstract byte[] c(byte[] bArr);

    public abstract void e(int i, Key key);

    public abstract void f(int i, SecretKey secretKey);

    public abstract void g(int i, SecretKeySpec secretKeySpec);

    public abstract void h(int i, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec);
}
