package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public class OF implements Cloneable {
    public float a;
    public float b;
    public float c;
    public float e;
    public int f;
    public float g;
    public AbstractC3948tF j;
    public float d = 0.0f;
    public float k = 1.0f;
    public boolean l = false;
    public StringBuffer n = new StringBuffer();
    public final Matrix h = new Matrix();
    public Matrix i = new Matrix();
    public PointF p = new PointF(-100.0f, -100.0f);
    public final PointF q = new PointF(-100.0f, -100.0f);

    public OF() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 1.0f;
        this.e = 0.0f;
        this.f = 2;
        this.g = 0.0f;
        this.g = 0.0f;
        this.e = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
        this.f = 2;
        this.c = 1.0f;
    }

    public void A(float f) {
        this.b = f;
    }

    public void a() {
        b(0.0f, -this.d);
    }

    public void b(float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f2);
        this.i.preConcat(matrix);
        this.h.set(this.i);
    }

    public Object clone() {
        OF of = new OF();
        of.s(j());
        of.A(q());
        of.u(m());
        of.v(n());
        of.z(o());
        of.y(p());
        of.t(k(), l());
        return of;
    }

    public void d(CF cf, String str) {
        if (AbstractC3948tF.f) {
            f(cf, str);
        } else {
            g(cf, str);
        }
    }

    public void e(CF cf, Object[] objArr) {
        for (Object obj : objArr) {
            if (obj instanceof String) {
                d(cf, (String) obj);
            } else {
                if (!(obj instanceof Double)) {
                    throw new EF("Bad element in TJ array");
                }
                this.h.preTranslate((-(((Double) obj).floatValue() / 1000.0f)) * this.k * this.c, 0.0f);
            }
        }
    }

    public final void f(CF cf, String str) {
        PointF pointF = new PointF();
        Matrix matrix = new Matrix();
        float f = this.k;
        AbstractC4128vX.c(matrix, f, 0.0f, 0.0f, f * this.c, 0.0f, this.e);
        Matrix matrix2 = new Matrix();
        matrix2.set(this.h);
        matrix2.preConcat(matrix);
        cf.a(new AF(str, matrix2));
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(0);
            AbstractC3948tF abstractC3948tF = this.j;
            float fP = ((abstractC3948tF instanceof AbstractC1214aF ? ((AbstractC1214aF) abstractC3948tF).p(cCharAt, null) : 0.6f) * this.k) + this.a;
            if (cCharAt == ' ') {
                fP += this.b;
            }
            this.h.preTranslate(fP * this.c, 0.0f);
        }
        float[] fArr = new float[2];
        this.h.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        this.q.set(fArr[0], fArr[1]);
    }

    public final void g(CF cf, String str) {
        PointF pointF = new PointF();
        Matrix matrix = new Matrix();
        float f = this.k;
        AbstractC4128vX.c(matrix, f, 0.0f, 0.0f, f * this.c, 0.0f, this.e);
        Matrix matrix2 = new Matrix();
        for (C4272xF c4272xF : this.j.f(str)) {
            matrix2.set(this.h);
            matrix2.preConcat(matrix);
            PointF pointFA = c4272xF.a(cf, matrix2, this.f);
            float f2 = (pointFA.x * this.k) + this.a;
            if (c4272xF.b() == ' ') {
                f2 += this.b;
            }
            this.h.preTranslate(f2 * this.c, pointFA.y);
        }
        float[] fArr = new float[2];
        this.h.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        this.q.set(fArr[0], fArr[1]);
    }

    public void h() {
        this.l = false;
    }

    public float j() {
        return this.a;
    }

    public AbstractC3948tF k() {
        return this.j;
    }

    public float l() {
        return this.k;
    }

    public float m() {
        return this.c * 100.0f;
    }

    public float n() {
        return this.d;
    }

    public int o() {
        return this.f;
    }

    public float p() {
        return this.e;
    }

    public float q() {
        return this.b;
    }

    public void r() {
        this.h.reset();
        this.i.reset();
        this.l = true;
        this.n.setLength(0);
    }

    public void s(float f) {
        this.a = f;
    }

    public void t(AbstractC3948tF abstractC3948tF, float f) {
        this.j = abstractC3948tF;
        this.k = f;
    }

    public void u(float f) {
        this.c = f / 100.0f;
    }

    public void v(float f) {
        this.d = f;
    }

    public void w(float[] fArr) {
        Matrix matrix = new Matrix();
        this.i = matrix;
        AbstractC4128vX.d(matrix, fArr);
        this.h.set(this.i);
    }

    public void x(int i) {
        int i2 = i & 1;
        int i3 = i2 == 0 ? 2 : 0;
        if ((i & 4) != 0) {
            i3 |= 4;
        }
        if ((((i & 2) >> 1) ^ i2) != 0) {
            i3 |= 1;
        }
        this.f = i3;
    }

    public void y(float f) {
        this.e = f;
    }

    public void z(int i) {
        this.f = i;
    }

    public void i() {
    }
}
