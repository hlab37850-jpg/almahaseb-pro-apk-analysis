package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import org.apache.poi.ss.usermodel.ShapeTypes;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes3.dex */
public class JV extends AbstractC1214aF {
    public static int I = 0;
    public static int J = 1;
    public static int K = 2;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String[] j;
    public byte[] k;
    public int l;
    public float[] m;
    public int n;
    public String[] o;
    public int[] p;
    public int[] q;
    public String r;
    public Matrix s;
    public int t;
    public float u;
    public int v;
    public int w;
    public float[] x;
    public int y;
    public int z;

    public class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a + this.b;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.a;
        }

        public String toString() {
            return "Range: start: " + this.a + ", len: " + this.b;
        }
    }

    public JV(String str, BF bf, C4029uF c4029uF) {
        super(str, bf, c4029uF);
        this.j = new String[256];
        this.m = new float[100];
        this.n = 0;
        this.q = new int[256];
        this.s = AbstractC4128vX.a(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        this.w = 2;
        this.x = new float[32];
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 1;
        if (!AbstractC3948tF.f) {
            this.k = c4029uF.d().q();
        }
        this.l = 0;
        if (AbstractC3948tF.f) {
            return;
        }
        w();
    }

    public final int A(boolean z) {
        while (true) {
            int I2 = I(z);
            if (I2 == I) {
                return this.t;
            }
            float[] fArr = this.m;
            int i = this.n;
            this.n = i + 1;
            fArr[i] = I2 == J ? this.t : this.u;
        }
    }

    public final void B(a aVar) {
        this.l = aVar.c();
        while (this.l < aVar.a()) {
            int iA = A(false);
            if (iA == 1006) {
                this.w = (int) this.m[0];
            } else if (iA == 1007) {
                if (this.n == 4) {
                    float[] fArr = this.m;
                    this.s = AbstractC4128vX.a(fArr[0], fArr[1], fArr[2], fArr[3], 0.0f, 0.0f);
                } else {
                    float[] fArr2 = this.m;
                    this.s = AbstractC4128vX.a(fArr2[0], fArr2[1], fArr2[2], fArr2[3], fArr2[4], fArr2[5]);
                }
            } else if (iA == 15) {
                this.y = (int) this.m[0];
            } else if (iA == 16) {
                this.z = (int) this.m[0];
            } else if (iA == 17) {
                this.A = (int) this.m[0];
            } else if (iA == 18) {
                float[] fArr3 = this.m;
                this.C = (int) fArr3[0];
                this.B = (int) fArr3[1];
            } else if (iA == 19) {
                int i = this.B + ((int) this.m[0]);
                this.E = i;
                this.G = r(i);
            }
            this.n = 0;
        }
    }

    public final void C(int i) {
        if (i == 0) {
            int[] iArr = AbstractC0424Dn.i;
            System.arraycopy(iArr, 0, this.q, 0, iArr.length);
            return;
        }
        if (i == 1) {
            System.out.println("**** EXPERT ENCODING!");
            return;
        }
        this.l = i;
        int iZ = z();
        int i2 = iZ & ShapeTypes.VERTICAL_SCROLL;
        if (i2 == 0) {
            int iZ2 = z();
            for (int i3 = 1; i3 < iZ2 + 1; i3++) {
                this.q[z() & 255] = i3;
            }
            return;
        }
        if (i2 != 1) {
            System.out.println("Bad encoding type: " + iZ);
            return;
        }
        int iZ3 = z();
        int i4 = 1;
        for (int i5 = 0; i5 < iZ3; i5++) {
            int iZ4 = z();
            int iZ5 = z();
            int i6 = iZ4;
            while (i6 < iZ4 + iZ5 + 1) {
                this.q[i6] = i4;
                i6++;
                i4++;
            }
        }
    }

    public void D() {
        byte[] bArr = this.k;
        int i = this.l;
        this.l = i + 1;
        byte b = bArr[i];
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        float f2 = 1.0f;
        while (true) {
            if (b == -35) {
                byte[] bArr2 = this.k;
                int i4 = this.l;
                this.l = i4 + 1;
                b = bArr2[i4];
            }
            int i5 = (b >> 4) & 15;
            b = (byte) ((b << 4) | 13);
            if (i5 >= 10) {
                if (i5 != 10) {
                    if (i5 != 11) {
                        if (i5 != 12) {
                            if (i5 != 14) {
                                break;
                            } else {
                                z = true;
                            }
                        } else {
                            i2 = -1;
                        }
                    } else {
                        i2 = 1;
                    }
                } else {
                    f2 = 0.1f;
                }
            } else if (i2 != 0) {
                i3 = (i3 * 10) + i5;
            } else if (f2 == 1.0f) {
                f = (f * 10.0f) + i5;
            } else {
                f += i5 * f2;
                f2 /= 10.0f;
            }
        }
        this.u = (z ? -1 : 1) * f * ((float) Math.pow(10.0d, i3 * i2));
    }

    public final synchronized Path E(int i, int i2) {
        Path path;
        C0627Jm c0627Jm = new C0627Jm();
        a aVarS = s(i, i2);
        path = new Path();
        int i3 = this.l;
        this.n = 0;
        x(aVarS, path, c0627Jm);
        this.l = i3;
        path.transform(this.s);
        return path;
    }

    public final void F(int i) {
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                this.p = AbstractC0424Dn.c;
                return;
            }
            if (i == 2) {
                this.p = AbstractC0424Dn.d;
                return;
            }
            int[] iArr = new int[this.H];
            this.p = iArr;
            iArr[0] = 0;
            this.l = i;
            int iZ = z();
            if (iZ == 0) {
                for (int i3 = 1; i3 < this.H; i3++) {
                    this.p[i3] = G(2);
                }
                return;
            }
            if (iZ == 1) {
                int i4 = 1;
                while (i4 < this.H) {
                    int iG = G(2);
                    int iZ2 = z() + 1;
                    int i5 = 0;
                    while (i5 < iZ2) {
                        this.p[i4] = iG;
                        i5++;
                        i4++;
                        iG++;
                    }
                }
                return;
            }
            if (iZ == 2) {
                int i6 = 1;
                while (i6 < this.H) {
                    int iG2 = G(2);
                    int iG3 = G(2) + 1;
                    int i7 = 0;
                    while (i7 < iG3) {
                        this.p[i6] = iG2;
                        i7++;
                        i6++;
                        iG2++;
                    }
                }
                return;
            }
            return;
        }
        this.p = new int[229];
        while (true) {
            int[] iArr2 = this.p;
            if (i2 >= iArr2.length) {
                return;
            }
            iArr2[i2] = i2;
            i2++;
        }
    }

    public final int G(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr = this.k;
            int i4 = this.l;
            this.l = i4 + 1;
            i2 = (i2 << 8) | (bArr[i4] & UnsignedBytes.MAX_VALUE);
        }
        return i2;
    }

    public final void H(int i) {
        this.l = i;
        int iG = G(2);
        this.o = new String[iG];
        for (int i2 = 0; i2 < iG; i2++) {
            a aVarS = s(i, i2);
            this.o[i2] = new String(this.k, aVarS.c(), aVarS.b());
        }
    }

    public final int I(boolean z) {
        byte[] bArr = this.k;
        int i = this.l;
        int i2 = i + 1;
        this.l = i2;
        int i3 = bArr[i] & UnsignedBytes.MAX_VALUE;
        this.t = i3;
        if (i3 == 30 && !z) {
            D();
            int i4 = K;
            this.v = i4;
            return i4;
        }
        if (i3 == 28) {
            this.t = (bArr[i2] << 8) + (bArr[i + 2] & UnsignedBytes.MAX_VALUE);
            this.l = i + 3;
            int i5 = J;
            this.v = i5;
            return i5;
        }
        if (i3 == 29 && !z) {
            this.t = ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i + 4] & UnsignedBytes.MAX_VALUE);
            this.l = i + 5;
            int i6 = J;
            this.v = i6;
            return i6;
        }
        if (i3 == 12) {
            this.l = i + 2;
            this.t = (bArr[i2] & UnsignedBytes.MAX_VALUE) + 1000;
            int i7 = I;
            this.v = i7;
            return i7;
        }
        if (i3 < 32) {
            int i8 = I;
            this.v = i8;
            return i8;
        }
        if (i3 < 247) {
            this.t = i3 - 139;
            int i9 = J;
            this.v = i9;
            return i9;
        }
        if (i3 < 251) {
            int i10 = (i3 - MetaDo.META_CREATEPALETTE) * 256;
            this.l = i + 2;
            this.t = i10 + (bArr[i2] & UnsignedBytes.MAX_VALUE) + 108;
            int i11 = J;
            this.v = i11;
            return i11;
        }
        if (i3 < 255) {
            this.l = i + 2;
            this.t = (((-(i3 - 251)) * 256) - (bArr[i2] & UnsignedBytes.MAX_VALUE)) - 108;
            int i12 = J;
            this.v = i12;
            return i12;
        }
        if (!z) {
            y();
            throw new RuntimeException("Got a 255 code while reading dict");
        }
        this.u = (((((bArr[i2] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16)) | ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 8)) | (bArr[i + 4] & UnsignedBytes.MAX_VALUE)) / 65536.0f;
        this.l = i + 5;
        int i13 = K;
        this.v = i13;
        return i13;
    }

    @Override // defpackage.AbstractC1214aF
    public Path n(char c, float f) {
        int i = c & 255;
        int i2 = this.z;
        if (i2 == 0 || i2 == 1) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.p;
                if (i3 < iArr.length) {
                    if (iArr[i3] == this.q[i]) {
                        return E(this.A, i3);
                    }
                    i3++;
                }
            }
        } else if (i > 0) {
            int[] iArr2 = this.q;
            if (i < iArr2.length) {
                return E(this.A, iArr2[i]);
            }
        }
        return E(this.A, 0);
    }

    @Override // defpackage.AbstractC1214aF
    public Path o(String str, float f) {
        int iU = u(str);
        int i = 0;
        while (true) {
            int[] iArr = this.p;
            if (i >= iArr.length) {
                return E(this.A, 0);
            }
            if (iArr[i] == iU) {
                return E(this.A, i);
            }
            i++;
        }
    }

    public final void q(float f, float f2, char c, char c2, Path path) {
        Path pathN = n(c2, p(c2, null));
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f2);
        Matrix matrix2 = new Matrix(this.s);
        if (this.s.invert(matrix2)) {
            matrix.preConcat(matrix2);
        }
        pathN.transform(matrix);
        Path pathN2 = n(c, p(c, null));
        Matrix matrix3 = new Matrix();
        if (this.s.invert(matrix3)) {
            pathN2.transform(matrix3);
        }
        path.addPath(pathN2);
        path.addPath(pathN);
    }

    public int r(int i) {
        int iV = v(i);
        if (iV < 1240) {
            return 107;
        }
        return iV < 33900 ? 1131 : 32768;
    }

    public a s(int i, int i2) {
        int i3 = this.l;
        this.l = i;
        int iG = G(2);
        int iZ = z();
        if (iZ < 1 || iZ > 4) {
            throw new RuntimeException("Offsize: " + iZ + ", must be in range 1-4.");
        }
        this.l += i2 * iZ;
        int iG2 = G(iZ);
        a aVar = new a(iG2 + 2 + i + ((iG + 1) * iZ), G(iZ) - iG2);
        this.l = i3;
        return aVar;
    }

    public int t(int i) {
        int i2 = this.l;
        this.l = i;
        int iG = G(2);
        if (iG <= 0) {
            return 2;
        }
        int iZ = z();
        if (iZ < 1 || iZ > 4) {
            throw new RuntimeException("Offsize: " + iZ + ", must be in range 1-4.");
        }
        this.l += iG * iZ;
        int iG2 = G(iZ);
        this.l = i2;
        return ((iG + 1) * iZ) + 2 + iG2;
    }

    public final int u(String str) {
        String[] strArr = AbstractC0424Dn.a;
        int iA = AbstractC0424Dn.a(str, strArr);
        if (iA == -1) {
            iA = AbstractC0424Dn.a(str, this.o) + strArr.length;
        }
        if (iA == -1) {
            return 0;
        }
        return iA;
    }

    public int v(int i) {
        int i2 = this.l;
        this.l = i;
        int iG = G(2);
        if (iG <= 0) {
            return 2;
        }
        this.l = i2;
        return iG;
    }

    public final void w() {
        z();
        z();
        int iZ = z();
        z();
        int iT = t(iZ) + iZ;
        int iT2 = t(iT) + iT;
        int iT3 = t(iT2) + iT2;
        this.D = iT3;
        this.F = r(iT3);
        H(iT2);
        this.l = iT;
        if (G(2) != 1) {
            y();
            throw new RuntimeException("More than one font in this file!");
        }
        a aVarS = s(iZ, 0);
        this.r = new String(this.k, aVarS.c(), aVarS.b());
        B(s(iT, 0));
        B(new a(this.B, this.C));
        this.l = this.A;
        this.H = G(2);
        F(this.y);
        C(this.z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:103:0x03be  */
    /* JADX WARN: Code duplicated, block: B:104:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:107:0x03cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:109:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:110:0x03de  */
    /* JADX WARN: Code duplicated, block: B:238:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x037d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0383  */
    /* JADX WARN: Code duplicated, block: B:88:0x0385  */
    /* JADX WARN: Code duplicated, block: B:91:0x038a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0391  */
    /* JADX WARN: Code duplicated, block: B:95:0x0399  */
    /* JADX WARN: Code duplicated, block: B:96:0x039b  */
    /* JADX WARN: Code duplicated, block: B:99:0x03b2  */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public void x(a aVar, Path path, C0627Jm c0627Jm) {
        ?? r7;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        float f;
        float f2;
        float[] fArr;
        int i9;
        float f3;
        float f4;
        int i10;
        float f5;
        float f6;
        int i11;
        this.l = aVar.c();
        boolean z2 = false;
        int i12 = 0;
        while (this.l < aVar.a()) {
            int i13 = 1;
            int iA = A(true);
            if (iA == 10) {
                int i14 = this.l;
                float[] fArr2 = this.m;
                int i15 = this.n - 1;
                this.n = i15;
                x(s(this.E, ((int) fArr2[i15]) + this.G), path, c0627Jm);
                this.l = i14;
            } else {
                if (iA == 11) {
                    return;
                }
                if (iA == 1014) {
                    float[] fArr3 = this.m;
                    int i16 = this.n;
                    fArr3[i16 - 1] = -fArr3[i16 - 1];
                } else if (iA != 1015) {
                    switch (iA) {
                        case 1:
                            this.n = 0;
                            break;
                        case 14:
                            if (this.n == 5) {
                                float[] fArr4 = this.m;
                                r7 = 0;
                                q(fArr4[1], fArr4[2], (char) fArr4[3], (char) fArr4[4], path);
                            } else {
                                r7 = 0;
                            }
                            if (c0627Jm.c) {
                                path.close();
                            }
                            c0627Jm.c = r7;
                            this.n = r7;
                            break;
                        case 18:
                            i12 += this.n / 2;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 19:
                        case 20:
                            i12 += this.n / 2;
                            this.l += ((i12 - 1) / 8) + 1;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 21:
                            if (this.n > 2) {
                                float[] fArr5 = this.m;
                                fArr5[z2 ? 1 : 0] = fArr5[1];
                                fArr5[1] = fArr5[2];
                            }
                            float f7 = c0627Jm.a;
                            float[] fArr6 = this.m;
                            c0627Jm.a = f7 + fArr6[z2 ? 1 : 0];
                            c0627Jm.b += fArr6[1];
                            if (c0627Jm.c) {
                                path.close();
                            }
                            path.moveTo(c0627Jm.a, c0627Jm.b);
                            c0627Jm.c = z2;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 22:
                            if (this.n > 1) {
                                float[] fArr7 = this.m;
                                fArr7[z2 ? 1 : 0] = fArr7[1];
                            }
                            c0627Jm.a += this.m[z2 ? 1 : 0];
                            if (c0627Jm.c) {
                                path.close();
                            }
                            path.moveTo(c0627Jm.a, c0627Jm.b);
                            c0627Jm.c = z2;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 23:
                            i12 += this.n / 2;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 24:
                            int i17 = 0;
                            for (int i18 = 2; i17 < this.n - i18; i18 = 2) {
                                float f8 = c0627Jm.a;
                                float[] fArr8 = this.m;
                                float f9 = f8 + fArr8[i17];
                                float f10 = c0627Jm.b + fArr8[i17 + 1];
                                float f11 = f9 + fArr8[i17 + 2];
                                float f12 = f10 + fArr8[i17 + 3];
                                int i19 = i17 + 5;
                                float f13 = fArr8[i17 + 4] + f11;
                                c0627Jm.a = f13;
                                i17 += 6;
                                float f14 = f12 + fArr8[i19];
                                c0627Jm.b = f14;
                                path.cubicTo(f9, f10, f11, f12, f13, f14);
                            }
                            float f15 = c0627Jm.a;
                            float[] fArr9 = this.m;
                            float f16 = f15 + fArr9[i17];
                            c0627Jm.a = f16;
                            float f17 = c0627Jm.b + fArr9[i17 + 1];
                            c0627Jm.b = f17;
                            path.lineTo(f16, f17);
                            c0627Jm.c = true;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 25:
                            int i20 = 0;
                            while (i20 < this.n - 6) {
                                float f18 = c0627Jm.a;
                                float[] fArr10 = this.m;
                                int i21 = i20 + 1;
                                float f19 = f18 + fArr10[i20];
                                c0627Jm.a = f19;
                                i20 += 2;
                                float f20 = c0627Jm.b + fArr10[i21];
                                c0627Jm.b = f20;
                                path.lineTo(f19, f20);
                            }
                            float f21 = c0627Jm.a;
                            float[] fArr11 = this.m;
                            float f22 = f21 + fArr11[i20];
                            float f23 = c0627Jm.b + fArr11[i20 + 1];
                            float f24 = f22 + fArr11[i20 + 2];
                            float f25 = f23 + fArr11[i20 + 3];
                            float f26 = f24 + fArr11[i20 + 4];
                            c0627Jm.a = f26;
                            float f27 = f25 + fArr11[i20 + 5];
                            c0627Jm.b = f27;
                            path.cubicTo(f22, f23, f24, f25, f26, f27);
                            c0627Jm.c = true;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 26:
                            if ((this.n & 1) == 1) {
                                c0627Jm.a += this.m[z2 ? 1 : 0];
                                i = 1;
                            } else {
                                i = 0;
                            }
                            while (i < this.n) {
                                float f28 = c0627Jm.a;
                                float f29 = c0627Jm.b;
                                float[] fArr12 = this.m;
                                float f30 = f29 + fArr12[i];
                                float f31 = f28 + fArr12[i + 1];
                                int i22 = i + 3;
                                float f32 = f30 + fArr12[i + 2];
                                c0627Jm.a = f31;
                                i += 4;
                                float f33 = f32 + fArr12[i22];
                                c0627Jm.b = f33;
                                path.cubicTo(f28, f30, f31, f32, f31, f33);
                            }
                            c0627Jm.c = true;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 27:
                            if ((this.n & 1) == 1) {
                                c0627Jm.b += this.m[z2 ? 1 : 0];
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            while (i2 < this.n) {
                                float f34 = c0627Jm.a;
                                float[] fArr13 = this.m;
                                float f35 = f34 + fArr13[i2];
                                float f36 = c0627Jm.b;
                                float f37 = f35 + fArr13[i2 + 1];
                                int i23 = i2 + 3;
                                float f38 = f36 + fArr13[i2 + 2];
                                i2 += 4;
                                float f39 = f37 + fArr13[i23];
                                c0627Jm.a = f39;
                                c0627Jm.b = f38;
                                path.cubicTo(f35, f36, f37, f38, f39, f38);
                            }
                            c0627Jm.c = true;
                            this.n = z2 ? 1 : 0;
                            break;
                        case 1000:
                            this.n = z2 ? 1 : 0;
                            break;
                        case PointerIconCompat.TYPE_ZOOM_IN /* 1018 */:
                            this.n--;
                            break;
                        default:
                            switch (iA) {
                                case 3:
                                    this.n = 0;
                                    break;
                                case 4:
                                    if (this.n > 1) {
                                        float[] fArr14 = this.m;
                                        fArr14[z2 ? 1 : 0] = fArr14[1];
                                    }
                                    c0627Jm.b += this.m[z2 ? 1 : 0];
                                    if (c0627Jm.c) {
                                        path.close();
                                    }
                                    c0627Jm.c = z2;
                                    path.moveTo(c0627Jm.a, c0627Jm.b);
                                    this.n = z2 ? 1 : 0;
                                    break;
                                case 5:
                                    int i24 = 0;
                                    while (i24 < this.n) {
                                        float f40 = c0627Jm.a;
                                        float[] fArr15 = this.m;
                                        int i25 = i24 + 1;
                                        float f41 = f40 + fArr15[i24];
                                        c0627Jm.a = f41;
                                        i24 += 2;
                                        float f42 = c0627Jm.b + fArr15[i25];
                                        c0627Jm.b = f42;
                                        path.lineTo(f41, f42);
                                    }
                                    c0627Jm.c = true;
                                    this.n = z2 ? 1 : 0;
                                    break;
                                case 6:
                                    int i26 = 0;
                                    while (i26 < this.n) {
                                        if ((i26 & 1) == 0) {
                                            i3 = i26 + 1;
                                            c0627Jm.a += this.m[i26];
                                        } else {
                                            i3 = i26 + 1;
                                            c0627Jm.b += this.m[i26];
                                        }
                                        i26 = i3;
                                        path.lineTo(c0627Jm.a, c0627Jm.b);
                                    }
                                    c0627Jm.c = true;
                                    this.n = z2 ? 1 : 0;
                                    break;
                                case 7:
                                    int i27 = 0;
                                    while (i27 < this.n) {
                                        if ((i27 & 1) == 0) {
                                            i4 = i27 + 1;
                                            c0627Jm.b += this.m[i27];
                                        } else {
                                            i4 = i27 + 1;
                                            c0627Jm.a += this.m[i27];
                                        }
                                        i27 = i4;
                                        path.lineTo(c0627Jm.a, c0627Jm.b);
                                    }
                                    c0627Jm.c = true;
                                    this.n = z2 ? 1 : 0;
                                    break;
                                case 8:
                                    int i28 = 0;
                                    while (i28 < this.n) {
                                        float f43 = c0627Jm.a;
                                        float[] fArr16 = this.m;
                                        float f44 = f43 + fArr16[i28];
                                        float f45 = c0627Jm.b + fArr16[i28 + 1];
                                        float f46 = f44 + fArr16[i28 + 2];
                                        float f47 = f45 + fArr16[i28 + 3];
                                        int i29 = i28 + 5;
                                        float f48 = f46 + fArr16[i28 + 4];
                                        c0627Jm.a = f48;
                                        i28 += 6;
                                        float f49 = f47 + fArr16[i29];
                                        c0627Jm.b = f49;
                                        path.cubicTo(f44, f45, f46, f47, f48, f49);
                                    }
                                    c0627Jm.c = true;
                                    this.n = z2 ? 1 : 0;
                                    break;
                                default:
                                    switch (iA) {
                                        case 29:
                                            int i30 = this.l;
                                            float[] fArr17 = this.m;
                                            int i31 = this.n - 1;
                                            this.n = i31;
                                            x(s(this.D, ((int) fArr17[i31]) + this.F), path, c0627Jm);
                                            this.l = i30;
                                            break;
                                        case 30:
                                            i5 = 4;
                                            i6 = 0;
                                            while (true) {
                                                i7 = this.n;
                                                if (i6 >= i7) {
                                                    c0627Jm.c = true;
                                                    this.n = z2 ? 1 : 0;
                                                } else {
                                                    if (((i6 + i5) & 4) == 0) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    float f50 = c0627Jm.a;
                                                    if (z) {
                                                        i8 = i6 + 1;
                                                        f = this.m[i6];
                                                    } else {
                                                        i8 = i6;
                                                        f = 0.0f;
                                                    }
                                                    float f51 = f50 + f;
                                                    float f52 = c0627Jm.b;
                                                    if (z) {
                                                        f2 = 0.0f;
                                                    } else {
                                                        f2 = this.m[i8];
                                                        i8++;
                                                    }
                                                    float f53 = f52 + f2;
                                                    fArr = this.m;
                                                    float f54 = fArr[i8] + f51;
                                                    i9 = i8 + 2;
                                                    float f55 = f53 + fArr[i8 + 1];
                                                    if (z) {
                                                        f3 = 0.0f;
                                                    } else {
                                                        f3 = fArr[i9];
                                                        i9 = i8 + 3;
                                                    }
                                                    f4 = f3 + f54;
                                                    c0627Jm.a = f4;
                                                    if (z) {
                                                        i10 = i9 + 1;
                                                        f5 = fArr[i9];
                                                    } else {
                                                        i10 = i9;
                                                        f5 = 0.0f;
                                                    }
                                                    f6 = f5 + f55;
                                                    c0627Jm.b = f6;
                                                    if (i10 == i7 - 1) {
                                                        i11 = i10;
                                                    } else if (z) {
                                                        i11 = i10 + 1;
                                                        c0627Jm.a = f4 + fArr[i10];
                                                    } else {
                                                        i11 = i10 + 1;
                                                        c0627Jm.b = f6 + fArr[i10];
                                                    }
                                                    path.cubicTo(f51, f53, f54, f55, c0627Jm.a, c0627Jm.b);
                                                    i6 = i11;
                                                }
                                                break;
                                            }
                                            break;
                                        case 31:
                                            i5 = 0;
                                            i6 = 0;
                                            while (true) {
                                                i7 = this.n;
                                                if (i6 >= i7) {
                                                    c0627Jm.c = true;
                                                    this.n = z2 ? 1 : 0;
                                                } else {
                                                    if (((i6 + i5) & 4) == 0) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    float f56 = c0627Jm.a;
                                                    if (z) {
                                                        i8 = i6 + 1;
                                                        f = this.m[i6];
                                                    } else {
                                                        i8 = i6;
                                                        f = 0.0f;
                                                    }
                                                    float f57 = f56 + f;
                                                    float f58 = c0627Jm.b;
                                                    if (z) {
                                                        f2 = 0.0f;
                                                    } else {
                                                        f2 = this.m[i8];
                                                        i8++;
                                                    }
                                                    float f59 = f58 + f2;
                                                    fArr = this.m;
                                                    float f510 = fArr[i8] + f57;
                                                    i9 = i8 + 2;
                                                    float f511 = f59 + fArr[i8 + 1];
                                                    if (z) {
                                                        f3 = 0.0f;
                                                    } else {
                                                        f3 = fArr[i9];
                                                        i9 = i8 + 3;
                                                    }
                                                    f4 = f3 + f510;
                                                    c0627Jm.a = f4;
                                                    if (z) {
                                                        i10 = i9 + 1;
                                                        f5 = fArr[i9];
                                                    } else {
                                                        i10 = i9;
                                                        f5 = 0.0f;
                                                    }
                                                    f6 = f5 + f511;
                                                    c0627Jm.b = f6;
                                                    if (i10 == i7 - 1) {
                                                        i11 = i10;
                                                    } else if (z) {
                                                        i11 = i10 + 1;
                                                        c0627Jm.a = f4 + fArr[i10];
                                                    } else {
                                                        i11 = i10 + 1;
                                                        c0627Jm.b = f6 + fArr[i10];
                                                    }
                                                    path.cubicTo(f57, f59, f510, f511, c0627Jm.a, c0627Jm.b);
                                                    i6 = i11;
                                                }
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (iA) {
                                                case PointerIconCompat.TYPE_HELP /* 1003 */:
                                                    float[] fArr18 = this.m;
                                                    int i32 = this.n;
                                                    int i33 = i32 - 1;
                                                    this.n = i33;
                                                    float f60 = fArr18[i33];
                                                    int i34 = i32 - 2;
                                                    this.n = i34;
                                                    float f61 = fArr18[i34];
                                                    this.n = i32 - 1;
                                                    fArr18[i34] = (f60 == 0.0f || f61 == 0.0f) ? 0 : 1;
                                                    break;
                                                case 1004:
                                                    float[] fArr19 = this.m;
                                                    int i35 = this.n;
                                                    int i36 = i35 - 1;
                                                    this.n = i36;
                                                    float f62 = fArr19[i36];
                                                    int i37 = i35 - 2;
                                                    this.n = i37;
                                                    float f63 = fArr19[i37];
                                                    this.n = i35 - 1;
                                                    if (f62 == 0.0f && f63 == 0.0f) {
                                                        i13 = 0;
                                                    }
                                                    fArr19[i37] = i13;
                                                    break;
                                                case GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT /* 1005 */:
                                                    float[] fArr20 = this.m;
                                                    int i38 = this.n;
                                                    int i39 = i38 - 1;
                                                    this.n = i39;
                                                    float f64 = fArr20[i39];
                                                    this.n = i38;
                                                    fArr20[i39] = f64 != 0.0f ? 0 : 1;
                                                    break;
                                                default:
                                                    switch (iA) {
                                                        case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                                                            float[] fArr21 = this.m;
                                                            int i40 = this.n;
                                                            fArr21[i40 - 1] = Math.abs(fArr21[i40 - 1]);
                                                            break;
                                                        case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                                                            float[] fArr22 = this.m;
                                                            int i41 = this.n;
                                                            int i42 = i41 - 1;
                                                            this.n = i42;
                                                            float f65 = fArr22[i42];
                                                            int i43 = i41 - 2;
                                                            this.n = i43;
                                                            float f66 = fArr22[i43];
                                                            this.n = i41 - 1;
                                                            fArr22[i43] = f65 + f66;
                                                            break;
                                                        case PointerIconCompat.TYPE_COPY /* 1011 */:
                                                            float[] fArr23 = this.m;
                                                            int i44 = this.n;
                                                            int i45 = i44 - 1;
                                                            this.n = i45;
                                                            float f67 = fArr23[i45];
                                                            int i46 = i44 - 2;
                                                            this.n = i46;
                                                            float f68 = fArr23[i46];
                                                            this.n = i44 - 1;
                                                            fArr23[i46] = f68 - f67;
                                                            break;
                                                        case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                                                            float[] fArr24 = this.m;
                                                            int i47 = this.n;
                                                            int i48 = i47 - 1;
                                                            this.n = i48;
                                                            float f69 = fArr24[i48];
                                                            int i49 = i47 - 2;
                                                            this.n = i49;
                                                            float f70 = fArr24[i49];
                                                            this.n = i47 - 1;
                                                            fArr24[i49] = f70 / f69;
                                                            break;
                                                        default:
                                                            switch (iA) {
                                                                case PointerIconCompat.TYPE_GRAB /* 1020 */:
                                                                    float[] fArr25 = this.m;
                                                                    int i50 = this.n;
                                                                    int i51 = i50 - 1;
                                                                    this.n = i51;
                                                                    int i52 = (int) fArr25[i51];
                                                                    int i53 = i50 - 2;
                                                                    this.n = i53;
                                                                    this.x[i52] = fArr25[i53];
                                                                    break;
                                                                case PointerIconCompat.TYPE_GRABBING /* 1021 */:
                                                                    float[] fArr26 = this.m;
                                                                    int i54 = this.n;
                                                                    int i55 = i54 - 1;
                                                                    this.n = i55;
                                                                    int i56 = (int) fArr26[i55];
                                                                    this.n = i54;
                                                                    fArr26[i55] = this.x[i56];
                                                                    break;
                                                                case 1022:
                                                                    float[] fArr27 = this.m;
                                                                    int i57 = this.n;
                                                                    if (fArr27[i57 - 2] > fArr27[i57 - 1]) {
                                                                        fArr27[i57 - 4] = fArr27[i57 - 3];
                                                                    }
                                                                    this.n = i57 - 3;
                                                                    break;
                                                                case IEEEDouble.EXPONENT_BIAS /* 1023 */:
                                                                    float[] fArr28 = this.m;
                                                                    int i58 = this.n;
                                                                    this.n = i58 + 1;
                                                                    fArr28[i58] = (float) Math.random();
                                                                    break;
                                                                case 1024:
                                                                    float[] fArr29 = this.m;
                                                                    int i59 = this.n;
                                                                    int i60 = i59 - 1;
                                                                    this.n = i60;
                                                                    float f71 = fArr29[i60];
                                                                    int i61 = i59 - 2;
                                                                    this.n = i61;
                                                                    float f72 = fArr29[i61];
                                                                    this.n = i59 - 1;
                                                                    fArr29[i61] = f72 * f71;
                                                                    break;
                                                                default:
                                                                    switch (iA) {
                                                                        case 1026:
                                                                            float[] fArr30 = this.m;
                                                                            int i62 = this.n;
                                                                            fArr30[i62 - 1] = (float) Math.sqrt(fArr30[i62 - 1]);
                                                                            break;
                                                                        case 1027:
                                                                            float[] fArr31 = this.m;
                                                                            int i63 = this.n;
                                                                            float f73 = fArr31[i63 - 1];
                                                                            this.n = i63 + 1;
                                                                            fArr31[i63] = f73;
                                                                            break;
                                                                        case 1028:
                                                                            float[] fArr32 = this.m;
                                                                            int i64 = this.n;
                                                                            float f74 = fArr32[i64 - 1];
                                                                            fArr32[i64 - 1] = fArr32[i64 - 2];
                                                                            fArr32[i64 - 2] = f74;
                                                                            break;
                                                                        case 1029:
                                                                            float[] fArr33 = this.m;
                                                                            int i65 = this.n;
                                                                            int i66 = (int) fArr33[i65 - 1];
                                                                            if (i66 < 0) {
                                                                                i66 = 0;
                                                                            }
                                                                            fArr33[i65 - 1] = fArr33[(i65 - 2) - i66];
                                                                            break;
                                                                        case 1030:
                                                                            float[] fArr34 = this.m;
                                                                            int i67 = this.n;
                                                                            int i68 = i67 - 1;
                                                                            this.n = i68;
                                                                            int i69 = (int) fArr34[i68];
                                                                            int i70 = i67 - 2;
                                                                            this.n = i70;
                                                                            int i71 = (int) fArr34[i70];
                                                                            int i72 = i69 > 0 ? i69 % i71 : i71 - ((-i69) % i71);
                                                                            if (i72 > 0) {
                                                                                float[] fArr35 = new float[i71];
                                                                                System.arraycopy(fArr34, (i67 - 3) - i72, fArr35, z2 ? 1 : 0, i72);
                                                                                System.arraycopy(this.m, (this.n - 1) - i71, fArr35, i72, i71 - i72);
                                                                                System.arraycopy(fArr35, z2 ? 1 : 0, this.m, (this.n - 1) - i71, i71);
                                                                            }
                                                                            break;
                                                                        default:
                                                                            switch (iA) {
                                                                                case 1034:
                                                                                    float f75 = c0627Jm.a;
                                                                                    float[] fArr36 = this.m;
                                                                                    float f76 = f75 + fArr36[z2 ? 1 : 0];
                                                                                    float f77 = c0627Jm.b;
                                                                                    float f78 = f76 + fArr36[1];
                                                                                    float f79 = f77 + fArr36[2];
                                                                                    float f80 = f78 + fArr36[3];
                                                                                    c0627Jm.a = f80;
                                                                                    c0627Jm.b = f79;
                                                                                    path.cubicTo(f76, f77, f78, f79, f80, f79);
                                                                                    float f81 = c0627Jm.a;
                                                                                    float[] fArr37 = this.m;
                                                                                    float f82 = f81 + fArr37[4];
                                                                                    float f83 = c0627Jm.b;
                                                                                    float f84 = f82 + fArr37[5];
                                                                                    float f85 = f84 + fArr37[6];
                                                                                    c0627Jm.a = f85;
                                                                                    c0627Jm.b = f77;
                                                                                    path.cubicTo(f82, f83, f84, f77, f85, f77);
                                                                                    c0627Jm.c = true;
                                                                                    this.n = z2 ? 1 : 0;
                                                                                    break;
                                                                                case 1035:
                                                                                    float f86 = c0627Jm.a;
                                                                                    float[] fArr38 = this.m;
                                                                                    float f87 = f86 + fArr38[z2 ? 1 : 0];
                                                                                    float f88 = c0627Jm.b + fArr38[1];
                                                                                    float f89 = fArr38[2] + f87;
                                                                                    float f90 = f88 + fArr38[3];
                                                                                    float f91 = f89 + fArr38[4];
                                                                                    c0627Jm.a = f91;
                                                                                    float f92 = fArr38[5] + f90;
                                                                                    c0627Jm.b = f92;
                                                                                    path.cubicTo(f87, f88, f89, f90, f91, f92);
                                                                                    float f93 = c0627Jm.a;
                                                                                    float[] fArr39 = this.m;
                                                                                    float f94 = fArr39[6] + f93;
                                                                                    float f95 = fArr39[7] + c0627Jm.b;
                                                                                    float f96 = f94 + fArr39[8];
                                                                                    float f97 = f95 + fArr39[9];
                                                                                    float f98 = f96 + fArr39[10];
                                                                                    c0627Jm.a = f98;
                                                                                    float f99 = f97 + fArr39[11];
                                                                                    c0627Jm.b = f99;
                                                                                    path.cubicTo(f94, f95, f96, f97, f98, f99);
                                                                                    c0627Jm.c = true;
                                                                                    this.n = z2 ? 1 : 0;
                                                                                    break;
                                                                                case 1036:
                                                                                    float f100 = c0627Jm.b;
                                                                                    float f101 = c0627Jm.a;
                                                                                    float[] fArr40 = this.m;
                                                                                    float f102 = fArr40[z2 ? 1 : 0] + f101;
                                                                                    float f103 = f100 + fArr40[1];
                                                                                    float f104 = f102 + fArr40[2];
                                                                                    float f105 = fArr40[3] + f103;
                                                                                    float f106 = f104 + fArr40[4];
                                                                                    c0627Jm.a = f106;
                                                                                    c0627Jm.b = f105;
                                                                                    path.cubicTo(f102, f103, f104, f105, f106, f105);
                                                                                    float f107 = c0627Jm.a;
                                                                                    float[] fArr41 = this.m;
                                                                                    float f108 = f107 + fArr41[5];
                                                                                    float f109 = c0627Jm.b;
                                                                                    float f110 = f108 + fArr41[6];
                                                                                    float f111 = f109 + fArr41[7];
                                                                                    float f112 = f110 + fArr41[8];
                                                                                    c0627Jm.a = f112;
                                                                                    c0627Jm.b = f100;
                                                                                    path.cubicTo(f108, f109, f110, f111, f112, f100);
                                                                                    c0627Jm.c = true;
                                                                                    this.n = z2 ? 1 : 0;
                                                                                    break;
                                                                                case 1037:
                                                                                    float f113 = c0627Jm.b;
                                                                                    float f114 = c0627Jm.a;
                                                                                    float[] fArr42 = this.m;
                                                                                    float f115 = fArr42[z2 ? 1 : 0] + f114;
                                                                                    float f116 = fArr42[1] + f113;
                                                                                    float f117 = fArr42[2] + f115;
                                                                                    float f118 = f116 + fArr42[3];
                                                                                    float f119 = fArr42[4] + f117;
                                                                                    c0627Jm.a = f119;
                                                                                    float f120 = f118 + fArr42[5];
                                                                                    c0627Jm.b = f120;
                                                                                    path.cubicTo(f115, f116, f117, f118, f119, f120);
                                                                                    float f121 = c0627Jm.a;
                                                                                    float[] fArr43 = this.m;
                                                                                    float f122 = fArr43[6] + f121;
                                                                                    float f123 = fArr43[7] + c0627Jm.b;
                                                                                    float f124 = fArr43[8] + f122;
                                                                                    float f125 = f123 + fArr43[9];
                                                                                    if (Math.abs(f124 - f114) > Math.abs(f125 - f113)) {
                                                                                        c0627Jm.a = this.m[10] + f124;
                                                                                        c0627Jm.b = f113;
                                                                                    } else {
                                                                                        c0627Jm.a = f114;
                                                                                        c0627Jm.b = this.m[10] + f125;
                                                                                    }
                                                                                    path.cubicTo(f122, f123, f124, f125, c0627Jm.a, c0627Jm.b);
                                                                                    c0627Jm.c = true;
                                                                                    this.n = z2 ? 1 : 0;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("ERROR! TYPE1C CHARSTRING CMD IS " + iA);
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    float[] fArr44 = this.m;
                    int i73 = this.n;
                    int i74 = i73 - 1;
                    this.n = i74;
                    float f126 = fArr44[i74];
                    int i75 = i73 - 2;
                    this.n = i75;
                    float f127 = fArr44[i75];
                    this.n = i73 - 1;
                    fArr44[i75] = f126 == f127 ? 1 : 0;
                }
            }
            z2 = false;
        }
    }

    public final void y() {
        int i;
        char[] cArr = new char[17];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.k;
            if (i2 >= bArr.length) {
                System.out.println();
                return;
            }
            int i4 = bArr[i2] & UnsignedBytes.MAX_VALUE;
            if (i4 == 0) {
                i = i3 + 1;
                cArr[i3] = '.';
            } else if (i4 < 32 || i4 >= 127) {
                i = i3 + 1;
                cArr[i3] = '?';
            } else {
                i = i3 + 1;
                cArr[i3] = (char) i4;
            }
            if (i4 < 16) {
                System.out.print("0" + Integer.toHexString(i4));
            } else {
                System.out.print(Integer.toHexString(i4));
            }
            if ((i2 & 15) == 15) {
                System.out.println("      " + new String(cArr));
                i3 = 0;
            } else if ((i2 & 7) == 7) {
                System.out.print("  ");
                i3 = i + 1;
                cArr[i] = ' ';
            } else {
                if ((i2 & 1) == 1) {
                    System.out.print(" ");
                }
                i3 = i;
            }
            i2++;
        }
    }

    public final int z() {
        byte[] bArr = this.k;
        int i = this.l;
        this.l = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }
}
