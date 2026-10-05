package defpackage;

import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class R8 extends OutputStream {
    public static final byte[] f = new byte[0];
    public final J8 a;
    public final LinkedList b;
    public int c;
    public byte[] d;
    public int e;

    public R8(J8 j8) {
        this(j8, 500);
    }

    public final void c() {
        int length = this.c + this.d.length;
        this.c = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 262144) {
            iMax = 262144;
        }
        this.b.add(this.d);
        this.d = new byte[iMax];
        this.e = 0;
    }

    public void d(int i) {
        if (this.e >= this.d.length) {
            c();
        }
        byte[] bArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public byte[] g(int i) {
        this.e = i;
        return u();
    }

    public byte[] i() {
        c();
        return this.d;
    }

    public void r() {
        this.c = 0;
        this.e = 0;
        if (this.b.isEmpty()) {
            return;
        }
        this.b.clear();
    }

    public byte[] t() {
        r();
        return this.d;
    }

    public byte[] u() {
        int i = this.c + this.e;
        if (i == 0) {
            return f;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.b) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.d, 0, bArr, i2, this.e);
        int i3 = i2 + this.e;
        if (i3 == i) {
            if (!this.b.isEmpty()) {
                r();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public R8(J8 j8, int i) {
        this.b = new LinkedList();
        this.a = j8;
        if (j8 == null) {
            this.d = new byte[i];
        } else {
            this.d = j8.a(J8.a.WRITE_CONCAT_BUFFER);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int iMin = Math.min(this.d.length - this.e, i2);
            if (iMin > 0) {
                System.arraycopy(bArr, i, this.d, this.e, iMin);
                i += iMin;
                this.e += iMin;
                i2 -= iMin;
            }
            if (i2 <= 0) {
                return;
            } else {
                c();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        d(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
