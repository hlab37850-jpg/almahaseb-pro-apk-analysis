package defpackage;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes3.dex */
public final class D8 {
    public final BitMatrix a;
    public final ResultPoint b;
    public final ResultPoint c;
    public final ResultPoint d;
    public final ResultPoint e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public D8(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = resultPoint == null || resultPoint2 == null;
        boolean z2 = resultPoint3 == null || resultPoint4 == null;
        if (z && z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z) {
            resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
            resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
        } else if (z2) {
            resultPoint3 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint.getY());
            resultPoint4 = new ResultPoint(bitMatrix.getWidth() - 1, resultPoint2.getY());
        }
        this.a = bitMatrix;
        this.b = resultPoint;
        this.c = resultPoint2;
        this.d = resultPoint3;
        this.e = resultPoint4;
        this.f = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
        this.g = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
        this.h = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
        this.i = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
    }

    public static D8 j(D8 d8, D8 d9) {
        if (d8 == null) {
            return d9;
        }
        return d9 == null ? d8 : new D8(d8.a, d8.b, d8.c, d9.d, d9.e);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    public D8 a(int i, int i2, boolean z) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        int y;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7 = this.b;
        ResultPoint resultPoint8 = this.c;
        ResultPoint resultPoint9 = this.d;
        ResultPoint resultPoint10 = this.e;
        if (i > 0) {
            ResultPoint resultPoint11 = z ? resultPoint7 : resultPoint9;
            int y2 = ((int) resultPoint11.getY()) - i;
            if (y2 < 0) {
                y2 = 0;
            }
            ResultPoint resultPoint12 = new ResultPoint(resultPoint11.getX(), y2);
            if (z) {
                resultPoint = resultPoint12;
            } else {
                resultPoint2 = resultPoint12;
                resultPoint = resultPoint7;
            }
            if (i2 > 0) {
                if (z) {
                    resultPoint5 = this.c;
                } else {
                    resultPoint5 = this.e;
                }
                y = ((int) resultPoint5.getY()) + i2;
                if (y >= this.a.getHeight()) {
                    y = this.a.getHeight() - 1;
                }
                resultPoint6 = new ResultPoint(resultPoint5.getX(), y);
                if (z) {
                    resultPoint3 = resultPoint6;
                } else {
                    resultPoint4 = resultPoint6;
                    resultPoint3 = resultPoint8;
                }
                return new D8(this.a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
            }
            resultPoint3 = resultPoint8;
            resultPoint4 = resultPoint10;
            return new D8(this.a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint = resultPoint7;
        resultPoint2 = resultPoint9;
        if (i2 > 0) {
            if (z) {
                resultPoint5 = this.c;
            } else {
                resultPoint5 = this.e;
            }
            y = ((int) resultPoint5.getY()) + i2;
            if (y >= this.a.getHeight()) {
                y = this.a.getHeight() - 1;
            }
            resultPoint6 = new ResultPoint(resultPoint5.getX(), y);
            if (z) {
                resultPoint3 = resultPoint6;
            } else {
                resultPoint4 = resultPoint6;
                resultPoint3 = resultPoint8;
            }
            return new D8(this.a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
        }
        resultPoint3 = resultPoint8;
        resultPoint4 = resultPoint10;
        return new D8(this.a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
    }

    public ResultPoint b() {
        return this.c;
    }

    public ResultPoint c() {
        return this.e;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.h;
    }

    public ResultPoint h() {
        return this.b;
    }

    public ResultPoint i() {
        return this.d;
    }

    public D8(D8 d8) {
        this.a = d8.a;
        this.b = d8.h();
        this.c = d8.b();
        this.d = d8.i();
        this.e = d8.c();
        this.f = d8.f();
        this.g = d8.d();
        this.h = d8.g();
        this.i = d8.e();
    }
}
