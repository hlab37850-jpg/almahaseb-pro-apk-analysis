package defpackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: xx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4324xx extends InputStream {
    public final InputStream a;
    public long b;
    public long c;
    public long d;
    public long e;

    public C4324xx(InputStream inputStream) {
        this(inputStream, 4096);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    public void c(long j) throws IOException {
        if (this.b > this.d || j < this.c) {
            throw new IOException("Cannot reset");
        }
        this.a.reset();
        i(this.c, j);
        this.b = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public long d(int i) {
        long j = this.b + ((long) i);
        if (this.d < j) {
            g(j);
        }
        return this.b;
    }

    public final void g(long j) {
        try {
            long j2 = this.c;
            long j3 = this.b;
            if (j2 >= j3 || j3 > this.d) {
                this.c = j3;
                this.a.mark((int) (j - j3));
            } else {
                this.a.reset();
                this.a.mark((int) (j - this.c));
                i(this.c, this.b);
            }
            this.d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public final void i(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.e = d(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.a.read();
        if (i != -1) {
            this.b++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        c(this.e);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.a.skip(j);
        this.b += jSkip;
        return jSkip;
    }

    public C4324xx(InputStream inputStream, int i) {
        this.e = -1L;
        this.a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.a.read(bArr);
        if (i != -1) {
            this.b += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += (long) i3;
        }
        return i3;
    }
}
