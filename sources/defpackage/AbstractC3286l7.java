package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: renamed from: l7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3286l7 extends Reader {
    public final C0918Sr a;
    public InputStream b;
    public byte[] c;
    public int d;
    public int e;
    public char[] f = null;

    public AbstractC3286l7(C0918Sr c0918Sr, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.a = c0918Sr;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    public final void c() {
        byte[] bArr = this.c;
        if (bArr != null) {
            this.c = null;
            this.a.k(bArr);
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            this.b = null;
            c();
            inputStream.close();
        }
    }

    public void d(char[] cArr, int i, int i2) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    public void g() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader
    public int read() {
        if (this.f == null) {
            this.f = new char[1];
        }
        if (read(this.f, 0, 1) < 1) {
            return -1;
        }
        return this.f[0];
    }
}
