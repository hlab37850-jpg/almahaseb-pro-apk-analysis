package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: dv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2069dv {
    public static int g = 257;
    public static int h = 256;
    public T8 a;
    public int b;
    public int c;
    public byte[][] d = new byte[4096][];
    public int e;
    public int f;

    public C2069dv(T8 t8) {
        this.e = 0;
        this.f = 9;
        for (int i = 0; i < 256; i++) {
            this.d[i] = new byte[]{(byte) i};
        }
        this.e = 258;
        this.f = 9;
        this.a = t8;
        this.b = 0;
        this.c = 0;
    }

    public static T8 b(T8 t8, BF bf) throws EF {
        DH dhD;
        T8 t8A = new C2069dv(t8).a();
        return (bf == null || !bf.k().containsKey("Predictor") || (dhD = DH.d(bf)) == null) ? t8A : dhD.h(t8A);
    }

    public final T8 a() throws EF {
        int i = h;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int iC = c();
            if (iC == -1) {
                throw new EF("Missed the stop code in LZWDecode!");
            }
            if (iC == g) {
                return T8.K(byteArrayOutputStream.toByteArray());
            }
            int i2 = h;
            if (iC == i2) {
                d();
            } else if (i == i2) {
                byte[] bArr = this.d[iC];
                byteArrayOutputStream.write(bArr, 0, bArr.length);
            } else {
                if (iC < this.e) {
                    byte[] bArr2 = this.d[iC];
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    byte[] bArr3 = this.d[i];
                    byte[] bArr4 = new byte[bArr3.length + 1];
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    byte[][] bArr5 = this.d;
                    bArr4[bArr5[i].length] = bArr5[iC][0];
                    int i3 = this.e;
                    this.e = i3 + 1;
                    bArr5[i3] = bArr4;
                } else {
                    byte[] bArr6 = this.d[i];
                    int length = bArr6.length + 1;
                    byte[] bArr7 = new byte[length];
                    System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
                    bArr7[this.d[i].length] = bArr7[0];
                    byteArrayOutputStream.write(bArr7, 0, length);
                    byte[][] bArr8 = this.d;
                    int i4 = this.e;
                    this.e = i4 + 1;
                    bArr8[i4] = bArr7;
                }
                int i5 = this.e;
                int i6 = this.f;
                if (i5 >= (1 << i6) - 1 && i6 < 12) {
                    this.f = i6 + 1;
                }
            }
            i = iC;
        }
    }

    public final int c() {
        int i = this.f;
        if (this.b >= this.a.s() - 1) {
            return -1;
        }
        int i2 = 0;
        while (i > 0) {
            byte bI = this.a.i(this.b);
            int i3 = this.c;
            int i4 = 8 - i3;
            if (i4 > i) {
                i4 = i;
            }
            i -= i4;
            i2 |= ((bI >> ((8 - i3) - i4)) & (255 >> (8 - i4))) << i;
            int i5 = i3 + i4;
            this.c = i5;
            if (i5 >= 8) {
                this.c = 0;
                this.b++;
            }
        }
        return i2;
    }

    public final void d() {
        this.e = 258;
        this.f = 9;
    }
}
