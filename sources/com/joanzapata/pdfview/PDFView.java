package com.joanzapata.pdfview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import androidx.core.view.ViewCompat;
import defpackage.AbstractC1781bG;
import defpackage.C2059dk;
import defpackage.C2329h4;
import defpackage.C3536o9;
import defpackage.IE;
import defpackage.InterfaceC3662pi;
import defpackage.LE;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PDFView extends SurfaceView {
    public Paint A;
    public Paint B;
    public boolean C;
    public RectF D;
    public RectF E;
    public int F;
    public boolean G;
    public boolean H;
    public C3536o9 a;
    public C2329h4 b;
    public C2059dk c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float n;
    public float p;
    public float q;
    public RectF t;
    public RectF u;
    public boolean v;
    public a w;
    public Paint x;
    public Paint y;
    public Paint z;

    public enum a {
        DEFAULT,
        LOADED,
        SHOWN
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0.0f;
        this.p = 0.0f;
        this.q = 1.0f;
        this.v = true;
        this.w = a.DEFAULT;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.C = false;
        this.a = new C3536o9();
        this.b = new C2329h4(this);
        this.c = new C2059dk(this);
        this.x = new Paint();
        Paint paint = new Paint();
        this.z = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.A = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.A.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.A.setAlpha(50);
        Paint paint3 = new Paint();
        this.B = paint3;
        paint3.setStyle(style);
        this.B.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.B.setAlpha(50);
        setWillNotDraw(false);
    }

    private void setDefaultPage(int i) {
        this.F = i;
    }

    private void setUserWantsMinimap(boolean z) {
        this.G = z;
    }

    public final float a(int i) {
        float f;
        float width;
        float f2;
        if (this.H) {
            f = -(i * this.l);
            width = getHeight() / 2;
            f2 = this.l;
        } else {
            f = -(i * this.k);
            width = getWidth() / 2;
            f2 = this.k;
        }
        return f + (width - (f2 / 2.0f));
    }

    public final void b() {
        this.t = new RectF(0.0f, 0.0f, (getWidth() / 2) - (r(this.k) / 2.0f), getHeight());
        this.u = new RectF((getWidth() / 2) + (r(this.k) / 2.0f), 0.0f, getWidth(), getHeight());
    }

    public final void c() {
        if (this.D == null) {
            return;
        }
        if (this.q == 1.0f) {
            this.C = false;
            return;
        }
        float fR = (((-this.n) - r(this.h * this.k)) / r(this.k)) * this.D.width();
        float width = (getWidth() / r(this.k)) * this.D.width();
        float fR2 = ((-this.p) / r(this.l)) * this.D.height();
        float height = (getHeight() / r(this.l)) * this.D.height();
        RectF rectF = this.D;
        float f = rectF.left;
        float f2 = rectF.top;
        RectF rectF2 = new RectF(f + fR, f2 + fR2, f + fR + width, f2 + fR2 + height);
        this.E = rectF2;
        rectF2.intersect(this.D);
        this.C = true;
    }

    public final void d() {
        float fMin = Math.min(200.0f / this.k, 200.0f / this.l);
        this.D = new RectF((getWidth() - 5) - (this.k * fMin), 5.0f, getWidth() - 5, (this.l * fMin) + 5.0f);
        c();
    }

    public final void e() {
        if (this.w == a.DEFAULT || getWidth() == 0) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        float f = this.i / this.j;
        float fFloor = (float) Math.floor(width / f);
        if (fFloor > height) {
            width = (float) Math.floor(f * height);
        } else {
            height = fFloor;
        }
        this.k = width;
        this.l = height;
        b();
        d();
    }

    public final int f(int i) {
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.d;
        if (iArr == null) {
            int i2 = this.f;
            if (i >= i2) {
                return i2 - 1;
            }
        } else if (i >= iArr.length) {
            return iArr.length - 1;
        }
        return i;
    }

    public final void g(Canvas canvas) {
        canvas.drawRect(this.D, this.A);
        canvas.drawRect(this.E, this.B);
    }

    public int getCurrentPage() {
        return this.g;
    }

    public float getCurrentXOffset() {
        return this.n;
    }

    public float getCurrentYOffset() {
        return this.p;
    }

    public InterfaceC3662pi getDecodeService() {
        return null;
    }

    public float getOptimalPageWidth() {
        return this.k;
    }

    public int getPageCount() {
        int[] iArr = this.d;
        return iArr != null ? iArr.length : this.f;
    }

    public float getZoom() {
        return this.q;
    }

    public final void h(Canvas canvas, AbstractC1781bG abstractC1781bG) {
        float fR;
        float fR2;
        RectF rectFB = abstractC1781bG.b();
        Bitmap bitmapC = abstractC1781bG.c();
        if (this.H) {
            fR2 = r(abstractC1781bG.d() * this.l);
            fR = 0.0f;
        } else {
            fR = r(abstractC1781bG.d() * this.k);
            fR2 = 0.0f;
        }
        canvas.translate(fR, fR2);
        Rect rect = new Rect(0, 0, bitmapC.getWidth(), bitmapC.getHeight());
        float fR3 = r(rectFB.left * this.k);
        float fR4 = r(rectFB.top * this.l);
        RectF rectF = new RectF((int) fR3, (int) fR4, (int) (fR3 + r(rectFB.width() * this.k)), (int) (fR4 + r(rectFB.height() * this.l)));
        float f = this.n + fR;
        float f2 = this.p + fR2;
        if (rectF.left + f >= getWidth() || f + rectF.right <= 0.0f || rectF.top + f2 >= getHeight() || f2 + rectF.bottom <= 0.0f) {
            canvas.translate(-fR, -fR2);
        } else {
            canvas.drawBitmap(bitmapC, rect, rectF, this.x);
            canvas.translate(-fR, -fR2);
        }
    }

    public boolean i() {
        return this.H;
    }

    public boolean j() {
        return this.q != 1.0f;
    }

    public void k() {
        if (this.k != 0.0f && this.l != 0.0f) {
            throw null;
        }
    }

    public void l(float f, float f2) {
        m(this.n + f, this.p + f2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x0079  */
    /* JADX WARN: Code duplicated, block: B:22:0x008b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00af  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00da  */
    /* JADX WARN: Code duplicated, block: B:44:0x0124  */
    /* JADX WARN: Code duplicated, block: B:46:0x0133  */
    /* JADX WARN: Code duplicated, block: B:48:0x014a  */
    /* JADX WARN: Code duplicated, block: B:50:0x015c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0169  */
    /* JADX WARN: Code duplicated, block: B:53:0x017f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0191  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a9  */
    public void m(float f, float f2) {
        float height;
        float fR;
        float fA;
        float fA2;
        float width;
        float fR2;
        float width2;
        float fR3;
        float fA3;
        float fA4;
        float height2;
        float fR4;
        if (this.H) {
            if (r(this.k) < getWidth()) {
                width2 = getWidth() / 2;
                fR3 = r(this.k) / 2.0f;
            } else {
                if (f > 0.0f) {
                    f = 0.0f;
                } else if (r(this.k) + f < getWidth()) {
                    width2 = getWidth();
                    fR3 = r(this.k);
                }
                if (j()) {
                    if (r(this.l) < getHeight()) {
                        this.C = false;
                        height2 = getHeight() / 2;
                        fR4 = r((this.h + 0.5f) * this.l);
                    } else {
                        this.C = true;
                        if (r(this.h * this.l) + f2 > 0.0f) {
                            f2 = -r(this.h * this.l);
                        } else if (r((this.h + 1) * this.l) + f2 < getHeight()) {
                            height2 = getHeight();
                            fR4 = r((this.h + 1) * this.l);
                        }
                    }
                    f2 = height2 - fR4;
                } else {
                    fA3 = a(this.h + 1);
                    fA4 = a(this.h - 1);
                    if (f2 < fA3) {
                        f2 = fA3;
                    } else if (f2 > fA4) {
                        f2 = fA4;
                    }
                }
            }
            f = width2 - fR3;
            if (j()) {
                if (r(this.l) < getHeight()) {
                    this.C = false;
                    height2 = getHeight() / 2;
                    fR4 = r((this.h + 0.5f) * this.l);
                } else {
                    this.C = true;
                    if (r(this.h * this.l) + f2 > 0.0f) {
                        f2 = -r(this.h * this.l);
                    } else if (r((this.h + 1) * this.l) + f2 < getHeight()) {
                        height2 = getHeight();
                        fR4 = r((this.h + 1) * this.l);
                    }
                }
                f2 = height2 - fR4;
            } else {
                fA3 = a(this.h + 1);
                fA4 = a(this.h - 1);
                if (f2 < fA3) {
                    f2 = fA3;
                } else if (f2 > fA4) {
                    f2 = fA4;
                }
            }
        } else {
            if (r(this.l) < getHeight()) {
                height = getHeight() / 2;
                fR = r(this.l) / 2.0f;
            } else {
                if (f2 > 0.0f) {
                    f2 = 0.0f;
                } else if (r(this.l) + f2 < getHeight()) {
                    height = getHeight();
                    fR = r(this.l);
                }
                if (j()) {
                    if (r(this.k) < getWidth()) {
                        this.C = false;
                        width = getWidth() / 2;
                        fR2 = r((this.h + 0.5f) * this.k);
                    } else {
                        this.C = true;
                        if (r(this.h * this.k) + f > 0.0f) {
                            f = -r(this.h * this.k);
                        } else if (r((this.h + 1) * this.k) + f < getWidth()) {
                            width = getWidth();
                            fR2 = r((this.h + 1) * this.k);
                        }
                    }
                    f = width - fR2;
                } else {
                    fA = a(this.h + 1);
                    fA2 = a(this.h - 1);
                    if (f < fA) {
                        f = fA;
                    } else if (f > fA2) {
                        f = fA2;
                    }
                }
            }
            f2 = height - fR;
            if (j()) {
                if (r(this.k) < getWidth()) {
                    this.C = false;
                    width = getWidth() / 2;
                    fR2 = r((this.h + 0.5f) * this.k);
                } else {
                    this.C = true;
                    if (r(this.h * this.k) + f > 0.0f) {
                        f = -r(this.h * this.k);
                    } else if (r((this.h + 1) * this.k) + f < getWidth()) {
                        width = getWidth();
                        fR2 = r((this.h + 1) * this.k);
                    }
                }
                f = width - fR2;
            } else {
                fA = a(this.h + 1);
                fA2 = a(this.h - 1);
                if (f < fA) {
                    f = fA;
                } else if (f > fA2) {
                    f = fA2;
                }
            }
        }
        this.n = f;
        this.p = f2;
        c();
        invalidate();
    }

    public void n() {
        this.a.c();
        this.v = true;
        this.w = a.DEFAULT;
    }

    public void o() {
        u(1.0f);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        n();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(-1);
        if (this.w != a.SHOWN) {
            return;
        }
        float f = this.n;
        float f2 = this.p;
        canvas.translate(f, f2);
        Iterator it = this.a.b().iterator();
        while (it.hasNext()) {
            h(canvas, (AbstractC1781bG) it.next());
        }
        Iterator it2 = this.a.a().iterator();
        while (it2.hasNext()) {
            h(canvas, (AbstractC1781bG) it2.next());
        }
        canvas.translate(-f, -f2);
        canvas.drawRect(this.t, this.y);
        canvas.drawRect(this.u, this.y);
        if (this.G && this.C) {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.b.e();
        e();
        k();
        if (this.H) {
            m(this.n, a(this.h));
        } else {
            m(a(this.h), this.p);
        }
    }

    public void p() {
        this.b.d(this.q, 1.0f);
    }

    public void q(int i) {
        this.w = a.SHOWN;
        int iF = f(i);
        this.g = iF;
        this.h = iF;
        int[] iArr = this.e;
        if (iArr != null && iF >= 0 && iF < iArr.length) {
            iF = iArr[iF];
            this.h = iF;
        }
        o();
        if (this.H) {
            this.b.c(this.p, a(iF));
        } else {
            this.b.b(this.n, a(iF));
        }
        k();
    }

    public float r(float f) {
        return f * this.q;
    }

    public void s(float f, PointF pointF) {
        t(this.q * f, pointF);
    }

    public void setSwipeVertical(boolean z) {
        this.H = z;
    }

    public void t(float f, PointF pointF) {
        float f2 = f / this.q;
        u(f);
        float f3 = this.n * f2;
        float f4 = this.p * f2;
        float f5 = pointF.x;
        float f6 = pointF.y;
        m(f3 + (f5 - (f5 * f2)), f4 + (f6 - (f2 * f6)));
    }

    public void u(float f) {
        this.q = f;
        b();
    }

    private void setOnDrawListener(IE ie) {
    }

    private void setOnPageChangeListener(LE le) {
    }
}
