package defpackage;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class U8 extends OutputStream {
    public long a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.a += (long) i2;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.a++;
    }
}
