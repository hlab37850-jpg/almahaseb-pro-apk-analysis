package defpackage;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface K8 extends LQ, WritableByteChannel {
    H8 a();

    K8 f();

    @Override // defpackage.LQ, java.io.Flushable
    void flush();

    K8 j();

    K8 l(String str);

    K8 n(W8 w8);

    K8 q(long j);

    K8 write(byte[] bArr);

    K8 write(byte[] bArr, int i, int i2);

    K8 writeByte(int i);

    K8 writeInt(int i);

    K8 writeShort(int i);
}
