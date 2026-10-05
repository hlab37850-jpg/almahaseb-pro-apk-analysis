package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class Z6 {
    public final byte[] a;
    public int b = 0;

    public Z6(int i) {
        this.a = new byte[i];
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            d(i3, z);
        }
    }

    public byte[] b(int i) {
        int length = this.a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.a[i2 / i];
        }
        return bArr;
    }

    public void c(int i, byte b) {
        this.a[i] = b;
    }

    public final void d(int i, boolean z) {
        this.a[i] = z ? (byte) 1 : (byte) 0;
    }
}
