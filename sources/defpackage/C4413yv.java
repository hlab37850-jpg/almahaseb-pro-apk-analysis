package defpackage;

import java.io.OutputStream;

/* JADX INFO: renamed from: yv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4413yv extends OutputStream {
    public long a = 0;

    public long c() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i >= 0 && i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
            this.a += (long) i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
