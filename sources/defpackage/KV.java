package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.BaseFont;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class KV extends AbstractC1214aF {
    public String[] j;
    public int k;
    public byte[][] l;
    public int m;
    public Map n;
    public Map o;
    public Matrix p;
    public float[] q;
    public int r;
    public float[] s;
    public int t;
    public int u;

    public class a {
        public byte[] a;
        public int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public byte[] b(int i, int i2, int i3) {
            KV kv = KV.this;
            byte[] bArr = this.a;
            int i4 = this.b;
            byte[] bArrS = kv.s(bArr, i4, i4 + i, i2, i3);
            this.b += i;
            return bArrS;
        }

        public float[] c(int i) {
            float[] fArr = new float[i];
            int i2 = 0;
            while (i2 < i) {
                String strD = d();
                if (strD.charAt(0) == '[') {
                    strD = strD.substring(1);
                }
                if (strD.endsWith("]")) {
                    strD = strD.substring(0, strD.length() - 1);
                }
                if (strD.length() > 0) {
                    fArr[i2] = Float.valueOf(strD).floatValue();
                    i2++;
                }
            }
            return fArr;
        }

        public String d() {
            while (C3706qF.k(this.a[this.b])) {
                this.b++;
            }
            int i = this.b;
            while (!C3706qF.k(this.a[this.b])) {
                int i2 = this.b + 1;
                this.b = i2;
                if (!C3706qF.j(this.a[i2])) {
                    break;
                }
            }
            return new String(this.a, i, this.b - i);
        }

        public void e(int i) {
            this.b = i;
        }
    }

    public KV(String str, BF bf, C4029uF c4029uF) {
        super(str, bf, c4029uF);
        this.q = new float[100];
        this.r = 0;
        this.s = new float[3];
        this.t = 0;
        this.u = 0;
        if (c4029uF == null || c4029uF.b() == null) {
            return;
        }
        w(c4029uF.b().q(), c4029uF.b().j("Length1").n(), c4029uF.b().j("Length2").n());
    }

    private void r(float f, float f2, char c, char c2, Path path) {
        Path path2 = new Path(n(c, p(c, null)));
        Matrix matrix = new Matrix();
        if (this.p.invert(matrix)) {
            path2.transform(matrix);
            Matrix matrix2 = new Matrix();
            matrix2.setTranslate(0.0f, f2);
            path2.transform(matrix2);
        } else {
            Matrix matrix3 = new Matrix();
            matrix3.setTranslate(0.0f, f2);
            path2.transform(matrix3);
        }
        Path path3 = new Path(n(c2, p(c2, null)));
        Matrix matrix4 = new Matrix();
        if (this.p.invert(matrix4)) {
            path3.transform(matrix4);
        }
        path.addPath(path3);
        path.addPath(path2);
    }

    public final byte[][] A(byte[] bArr, String str, String str2) {
        int iT = t(bArr, str);
        if (iT < 0) {
            return new byte[0][];
        }
        a aVar = new a(bArr, iT);
        aVar.d();
        String strD = aVar.d();
        if (strD.equals("StandardEncoding")) {
            int length = AbstractC0424Dn.i.length;
            byte[][] bArr2 = new byte[length][];
            for (int i = 0; i < length; i++) {
                bArr2[i] = AbstractC0424Dn.b(AbstractC0424Dn.i[i]).getBytes();
            }
            return bArr2;
        }
        byte[][] bArr3 = new byte[Integer.parseInt(strD)][];
        while (true) {
            String strD2 = aVar.d();
            if (!strD2.equals("dup")) {
                if (strD2.equals(str2)) {
                    break;
                }
            } else {
                try {
                    int i2 = Integer.parseInt(aVar.d());
                    String strD3 = aVar.d();
                    byte[] bytes = strD3.getBytes();
                    if (Character.isDigit(strD3.charAt(0))) {
                        int i3 = Integer.parseInt(strD3);
                        String strD4 = aVar.d();
                        if (strD4.equals("-|") || strD4.equals("RD")) {
                            aVar.e(aVar.a() + 1);
                            bytes = aVar.b(i3, this.k, this.m);
                        }
                    }
                    bArr3[i2] = bytes;
                } catch (Exception unused) {
                }
            }
        }
        return bArr3;
    }

    public final HashMap B(byte[] bArr) {
        HashMap map = new HashMap();
        int iT = t(bArr, "CharStrings");
        if (iT < 0) {
            return map;
        }
        a aVar = new a(bArr, iT);
        while (true) {
            String strD = aVar.d();
            if (strD.charAt(0) == '/') {
                int i = Integer.parseInt(aVar.d());
                String strD2 = aVar.d();
                if (strD2.equals("-|") || strD2.equals("RD")) {
                    aVar.e(aVar.a() + 1);
                    map.put(strD.substring(1), aVar.b(i, this.k, this.m));
                }
            } else if (strD.equals("end")) {
                return map;
            }
        }
    }

    public final String[] C(byte[] bArr) {
        byte[][] bArrA = A(bArr, "Encoding", "def");
        String[] strArr = new String[256];
        for (int i = 0; i < bArrA.length; i++) {
            byte[] bArr2 = bArrA[i];
            if (bArr2 == null) {
                strArr[i] = null;
            } else if (bArr2[0] == 47) {
                strArr[i] = new String(bArr2).substring(1);
            } else {
                strArr[i] = new String(bArr2);
            }
        }
        return strArr;
    }

    public final byte[][] D(byte[] bArr) {
        return A(bArr, "Subrs", "index");
    }

    @Override // defpackage.AbstractC1214aF
    public Path n(char c, float f) {
        return o(this.j[c & 255], f);
    }

    @Override // defpackage.AbstractC1214aF
    public Path o(String str, float f) {
        if (str == null || !this.n.containsKey(str)) {
            str = BaseFont.notdef;
        }
        Object obj = this.n.get(str);
        if (obj instanceof Path) {
            return (Path) obj;
        }
        C0627Jm c0627Jm = new C0627Jm();
        Path pathX = x((byte[]) obj, c0627Jm, this.p);
        if (f != 0.0f && c0627Jm.a != 0.0f) {
            PointF pointF = new PointF(c0627Jm.a, c0627Jm.b);
            float[] fArr = {pointF.x, pointF.y};
            this.p.mapPoints(fArr);
            float f2 = fArr[0];
            pointF.x = f2;
            pointF.y = fArr[1];
            Matrix matrix = new Matrix();
            matrix.setScale(f / f2, 1.0f);
            pathX.transform(matrix);
        }
        this.n.put(str, pathX);
        this.o.put(str, c0627Jm);
        return pathX;
    }

    @Override // defpackage.AbstractC1214aF
    public float p(char c, String str) {
        if (l() != -1 && m() != -1) {
            return super.p(c, str);
        }
        String str2 = this.j[c & 255];
        if (str == null) {
            str = str2;
        }
        if (str == null || !this.n.containsKey(str)) {
            return 0.0f;
        }
        if (!this.o.containsKey(str)) {
            o(str, 0.0f);
        }
        C0627Jm c0627Jm = (C0627Jm) this.o.get(str);
        if (c0627Jm != null) {
            return c0627Jm.a / k();
        }
        return 0.0f;
    }

    public final byte[] s(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i2 - i;
        if (i5 - i4 < 0) {
            i4 = 0;
        }
        byte[] bArr2 = new byte[i5 - i4];
        for (int i6 = i; i6 < i2; i6++) {
            int i7 = bArr[i6] & 255;
            int i8 = ((i3 >> 8) ^ i7) & 255;
            i3 = 65535 & (((i7 + i3) * 52845) + 22719);
            int i9 = (i6 - i) - i4;
            if (i9 >= 0) {
                bArr2[i9] = (byte) i8;
            }
        }
        return bArr2;
    }

    public final int t(byte[] bArr, String str) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 47) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    if (bArr[i + i2 + 1] == str.charAt(i2)) {
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public final boolean u(byte[] bArr, int i) {
        for (int i2 = i; i2 < i + 4; i2++) {
            char c = (char) (bArr[i2] & UnsignedBytes.MAX_VALUE);
            if ((c < '0' || c > '9') && ((c < 'a' || c > 'f') && (c < 'A' || c > 'F'))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void v(byte[] bArr, Path path, C0627Jm c0627Jm, C0627Jm c0627Jm2) {
        C0627Jm c0627Jm3;
        C0627Jm c0627Jm4;
        C0627Jm c0627Jm5;
        C0627Jm c0627Jm6 = c0627Jm;
        C0627Jm c0627Jm7 = c0627Jm2;
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & UnsignedBytes.MAX_VALUE;
            if (i4 == 255) {
                float[] fArr = this.q;
                int i5 = this.r;
                this.r = i5 + 1;
                fArr[i5] = ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) << 8) + (255 & bArr[i2 + 4]);
                i2 += 5;
            } else {
                if (i4 >= 251) {
                    float[] fArr2 = this.q;
                    int i6 = this.r;
                    this.r = i6 + 1;
                    fArr2[i6] = ((-((i4 - 251) << 8)) - (bArr[i3] & UnsignedBytes.MAX_VALUE)) - 108;
                } else if (i4 >= 247) {
                    float[] fArr3 = this.q;
                    int i7 = this.r;
                    this.r = i7 + 1;
                    fArr3[i7] = ((i4 - 247) << 8) + (bArr[i3] & UnsignedBytes.MAX_VALUE) + 108;
                } else {
                    if (i4 < 32) {
                        switch (i4) {
                            case 0:
                                throw new RuntimeException("Bad command (" + i4 + ")");
                            case 1:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 2:
                                throw new RuntimeException("Bad command (" + i4 + ")");
                            case 3:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 4:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                float fY = c0627Jm3.b + y();
                                c0627Jm3.b = fY;
                                path.moveTo(c0627Jm3.a, fY);
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 5:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                c0627Jm3.b += y();
                                float fY2 = c0627Jm3.a + y();
                                c0627Jm3.a = fY2;
                                path.lineTo(fY2, c0627Jm3.b);
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 6:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                float fY3 = c0627Jm3.a + y();
                                c0627Jm3.a = fY3;
                                path.lineTo(fY3, c0627Jm3.b);
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 7:
                                i3 = i3;
                                c0627Jm3 = c0627Jm6;
                                float fY4 = c0627Jm3.b + y();
                                c0627Jm3.b = fY4;
                                path.lineTo(c0627Jm3.a, fY4);
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 8:
                                c0627Jm3 = c0627Jm6;
                                float fY5 = y();
                                float fY6 = y();
                                float fY7 = y();
                                float fY8 = y();
                                float fY9 = y();
                                float fY10 = y();
                                float f = c0627Jm3.a;
                                float f2 = c0627Jm3.b;
                                i3 = i3;
                                path.cubicTo(f + fY10, f2 + fY9, f + fY10 + fY8, f2 + fY9 + fY7, f + fY10 + fY8 + fY6, f2 + fY9 + fY7 + fY5);
                                c0627Jm3.a += fY10 + fY8 + fY6;
                                c0627Jm3.b += fY9 + fY7 + fY5;
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 9:
                                c0627Jm3 = c0627Jm6;
                                path.close();
                                this.r = 0;
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 10:
                                C0627Jm c0627Jm8 = c0627Jm7;
                                c0627Jm3 = c0627Jm6;
                                int iY = (int) y();
                                byte[] bArr2 = this.l[iY];
                                if (bArr2 == null) {
                                    System.out.println("No subroutine #" + iY);
                                } else {
                                    int i8 = this.u + 1;
                                    this.u = i8;
                                    if (i8 > 10) {
                                        System.out.println("Call stack too large");
                                    } else {
                                        v(bArr2, path, c0627Jm3, c0627Jm8);
                                    }
                                    this.u--;
                                }
                                c0627Jm7 = c0627Jm2;
                                c0627Jm6 = c0627Jm3;
                                i2 = i3;
                                i = 0;
                                break;
                            case 11:
                                return;
                            case 12:
                                int i9 = i2 + 2;
                                int i10 = bArr[i3] & UnsignedBytes.MAX_VALUE;
                                if (i10 == 6) {
                                    c0627Jm4 = c0627Jm7;
                                    r(y(), y(), (char) y(), (char) y(), path);
                                    this.r = 0;
                                    c0627Jm5 = c0627Jm;
                                } else {
                                    c0627Jm4 = c0627Jm7;
                                    c0627Jm5 = c0627Jm6;
                                    if (i10 == 7) {
                                        c0627Jm4.b = y();
                                        c0627Jm4.a = y();
                                        c0627Jm5.b = y();
                                        c0627Jm5.a = y();
                                        this.r = 0;
                                    } else if (i10 == 12) {
                                        float fY11 = y();
                                        float fY12 = y();
                                        float[] fArr4 = this.q;
                                        int i11 = this.r;
                                        this.r = i11 + 1;
                                        fArr4[i11] = fY12 / fY11;
                                    } else if (i10 == 33) {
                                        c0627Jm5.b = y();
                                        float fY13 = y();
                                        c0627Jm5.a = fY13;
                                        path.moveTo(fY13, c0627Jm5.b);
                                        this.r = 0;
                                    } else if (i10 == 0 || i10 == 1 || i10 == 2) {
                                        this.r = 0;
                                    } else if (i10 == 16) {
                                        int iY2 = (int) y();
                                        int iY3 = (int) y();
                                        if (iY2 == 0) {
                                            float[] fArr5 = this.s;
                                            int i12 = this.t;
                                            this.t = i12 + 1;
                                            fArr5[i12] = y();
                                            float[] fArr6 = this.s;
                                            int i13 = this.t;
                                            this.t = i13 + 1;
                                            fArr6[i13] = y();
                                            y();
                                        } else if (iY2 != 3) {
                                            for (int i14 = 0; i14 > iY3; i14--) {
                                                float[] fArr7 = this.s;
                                                int i15 = this.t;
                                                this.t = i15 + 1;
                                                fArr7[i15] = y();
                                            }
                                        } else {
                                            float[] fArr8 = this.s;
                                            int i16 = this.t;
                                            this.t = i16 + 1;
                                            fArr8[i16] = 3.0f;
                                        }
                                    } else {
                                        if (i10 != 17) {
                                            throw new RuntimeException("Bad command (" + i10 + ")");
                                        }
                                        float[] fArr9 = this.q;
                                        int i17 = this.r;
                                        this.r = i17 + 1;
                                        float[] fArr10 = this.s;
                                        int i18 = this.t;
                                        fArr9[i17] = fArr10[i18 - 1];
                                        this.t = i18 - 1;
                                    }
                                }
                                c0627Jm6 = c0627Jm5;
                                c0627Jm7 = c0627Jm4;
                                i2 = i9;
                                i = 0;
                                break;
                            case 13:
                                c0627Jm7.a = y();
                                c0627Jm7.b = 0.0f;
                                c0627Jm6.a = y();
                                c0627Jm6.b = 0.0f;
                                this.r = i;
                                break;
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                                throw new RuntimeException("Bad command (" + i4 + ")");
                            case 21:
                                c0627Jm6.b += y();
                                float fY14 = c0627Jm6.a + y();
                                c0627Jm6.a = fY14;
                                path.moveTo(fY14, c0627Jm6.b);
                                this.r = i;
                                break;
                            case 22:
                                float fY15 = c0627Jm6.a + y();
                                c0627Jm6.a = fY15;
                                path.moveTo(fY15, c0627Jm6.b);
                                this.r = i;
                                break;
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                throw new RuntimeException("Bad command (" + i4 + ")");
                            case 30:
                                float fY16 = y();
                                float fY17 = y();
                                float fY18 = y();
                                float fY19 = y();
                                float f3 = c0627Jm6.a;
                                float f4 = c0627Jm6.b;
                                path.cubicTo(f3, f4 + fY19, f3 + fY18, f4 + fY19 + fY17, f3 + fY18 + fY16, f4 + fY19 + fY17);
                                c0627Jm6.a += fY18 + fY16;
                                c0627Jm6.b += fY19 + fY17;
                                this.r = i;
                                break;
                            case 31:
                                float fY20 = y();
                                float fY21 = y();
                                float fY22 = y();
                                float fY23 = y();
                                float f5 = c0627Jm6.a;
                                float f6 = c0627Jm6.b;
                                path.cubicTo(f5 + fY23, f6, f5 + fY23 + fY22, f6 + fY21, f5 + fY23 + fY22, f6 + fY21 + fY20);
                                c0627Jm6.a += fY23 + fY22;
                                c0627Jm6.b += fY21 + fY20;
                                this.r = i;
                                break;
                        }
                    } else {
                        float[] fArr11 = this.q;
                        int i19 = this.r;
                        this.r = i19 + 1;
                        fArr11[i19] = i4 - 139;
                    }
                    c0627Jm3 = c0627Jm6;
                    c0627Jm7 = c0627Jm2;
                    c0627Jm6 = c0627Jm3;
                    i2 = i3;
                    i = 0;
                }
                i2 += 2;
            }
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        byte[] bArrS;
        this.o = new HashMap();
        if (u(bArr, i)) {
            byte[] bArrZ = z(bArr, i, i2 + i);
            bArrS = s(bArrZ, 0, bArrZ.length, 55665, 4);
        } else {
            bArrS = s(bArr, i, i + i2, 55665, 4);
        }
        this.j = C(bArr);
        int iT = t(bArrS, "lenIV");
        a aVar = new a(bArrS, 0);
        if (iT < 0) {
            this.m = 4;
        } else {
            aVar.e(iT + 6);
            this.m = Integer.parseInt(aVar.d());
        }
        this.k = 4330;
        int iT2 = t(bArr, "FontMatrix");
        if (iT2 < 0) {
            System.out.println("No FontMatrix!");
            this.p = AbstractC4128vX.a(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        } else {
            this.p = AbstractC4128vX.b(new a(bArr, iT2 + 11).c(6));
        }
        this.l = D(bArrS);
        this.n = new TreeMap(B(bArrS));
    }

    public final synchronized Path x(byte[] bArr, C0627Jm c0627Jm, Matrix matrix) {
        Path path;
        path = new Path();
        C0627Jm c0627Jm2 = new C0627Jm();
        this.r = 0;
        v(bArr, path, c0627Jm2, c0627Jm);
        path.transform(matrix);
        return path;
    }

    public final float y() {
        int i = this.r;
        if (i <= 0) {
            return 0.0f;
        }
        float[] fArr = this.q;
        int i2 = i - 1;
        this.r = i2;
        return fArr[i2];
    }

    public final byte[] z(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[(i2 - i) / 2];
        int i4 = 0;
        int i5 = 0;
        while (i < i2) {
            char c = (char) (bArr[i] & UnsignedBytes.MAX_VALUE);
            if (c >= '0' && c <= '9') {
                i3 = c - '0';
            } else if (c < 'a' || c > 'f') {
                if (c >= 'A' && c <= 'F') {
                    i3 = c - '7';
                }
                i++;
            } else {
                i3 = c - 'W';
            }
            byte b = (byte) i3;
            int i6 = i4 + 1;
            if (i4 % 2 == 0) {
                bArr2[i5] = (byte) (b << 4);
            } else {
                bArr2[i5] = (byte) (b | bArr2[i5]);
                i5++;
            }
            i4 = i6;
            i++;
        }
        return bArr2;
    }
}
