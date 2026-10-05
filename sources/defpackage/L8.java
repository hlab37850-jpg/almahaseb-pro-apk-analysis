package defpackage;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface L8 extends InterfaceC3309lR, ReadableByteChannel {
    int B(XE xe);

    void D(long j);

    long E();

    H8 a();

    W8 e(long j);

    boolean h();

    String k(long j);

    void m(H8 h8, long j);

    String o(Charset charset);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    String s();

    void skip(long j);

    byte[] w(long j);
}
