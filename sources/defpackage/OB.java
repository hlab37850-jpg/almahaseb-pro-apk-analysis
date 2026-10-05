package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class OB extends InputStream {
    public final C0918Sr a;
    public final InputStream b;
    public byte[] c;
    public int d;
    public final int e;

    public OB(C0918Sr c0918Sr, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.a = c0918Sr;
        this.b = inputStream;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.c != null ? this.e - this.d : this.b.available();
    }

    public final void c() {
        byte[] bArr = this.c;
        if (bArr != null) {
            this.c = null;
            C0918Sr c0918Sr = this.a;
            if (c0918Sr != null) {
                c0918Sr.k(bArr);
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c();
        this.b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.c == null) {
            this.b.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.c == null && this.b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this.c;
        if (bArr == null) {
            return this.b.read();
        }
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        int i3 = bArr[i] & UnsignedBytes.MAX_VALUE;
        if (i2 >= this.e) {
            c();
        }
        return i3;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.c == null) {
            this.b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2;
        if (this.c != null) {
            int i = this.e;
            int i2 = this.d;
            j2 = i - i2;
            if (j2 > j) {
                this.d = i2 + ((int) j);
                return j;
            }
            c();
            j -= j2;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this.b.skip(j) : j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            int i3 = this.e;
            int i4 = this.d;
            int i5 = i3 - i4;
            if (i2 > i5) {
                i2 = i5;
            }
            System.arraycopy(bArr2, i4, bArr, i, i2);
            int i6 = this.d + i2;
            this.d = i6;
            if (i6 >= this.e) {
                c();
            }
            return i2;
        }
        return this.b.read(bArr, i, i2);
    }
}
