package defpackage;

import java.nio.ByteBuffer;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: renamed from: lJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3301lJ extends AbstractC0360Bb {
    public RC4Engine a;

    @Override // defpackage.AbstractC0360Bb
    public void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        while (byteBuffer.hasRemaining()) {
            byteBuffer2.put(this.a.returnByte(byteBuffer.get()));
        }
    }

    @Override // defpackage.AbstractC0360Bb
    public void b(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.a.processBytes(bArr, i, i2, bArr2, 0);
    }

    @Override // defpackage.AbstractC0360Bb
    public byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        this.a.processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    @Override // defpackage.AbstractC0360Bb
    public void e(int i, Key key) {
        RC4Engine rC4Engine = new RC4Engine();
        this.a = rC4Engine;
        rC4Engine.init(i == 1, new KeyParameter(key.getEncoded()));
    }

    @Override // defpackage.AbstractC0360Bb
    public void f(int i, SecretKey secretKey) {
        RC4Engine rC4Engine = new RC4Engine();
        this.a = rC4Engine;
        rC4Engine.init(i == 1, new KeyParameter(secretKey.getEncoded()));
    }

    @Override // defpackage.AbstractC0360Bb
    public void g(int i, SecretKeySpec secretKeySpec) {
        RC4Engine rC4Engine = new RC4Engine();
        this.a = rC4Engine;
        rC4Engine.init(i == 1, new KeyParameter(secretKeySpec.getEncoded()));
    }

    @Override // defpackage.AbstractC0360Bb
    public void h(int i, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) {
        throw new RuntimeException("not yet supported");
    }
}
