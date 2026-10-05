package com.kyanogen.signatureview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import defpackage.AbstractC2104eJ;
import defpackage.AbstractC2186fJ;
import defpackage.AbstractC3219kJ;
import defpackage.PG;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureView extends View {
    public Canvas a;
    public boolean b;
    public PG c;
    public PG d;
    public PG e;
    public float f;
    public float g;
    public Paint h;
    public Paint i;
    public Bitmap j;
    public int k;
    public int l;
    public int n;
    public int p;
    public Rect q;
    public int t;
    public int u;
    public boolean v;
    public float w;
    public Context x;

    public SignatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = context;
        setWillNotDraw(false);
        setDrawingCacheEnabled(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC3219kJ.signature, 0, 0);
        try {
            this.u = typedArrayObtainStyledAttributes.getColor(AbstractC3219kJ.signature_backgroundColor, context.getResources().getColor(AbstractC2104eJ.white));
            this.t = typedArrayObtainStyledAttributes.getColor(AbstractC3219kJ.signature_penColor, context.getResources().getColor(AbstractC2104eJ.penRoyalBlue));
            this.w = typedArrayObtainStyledAttributes.getDimension(AbstractC3219kJ.signature_penSize, context.getResources().getDimension(AbstractC2186fJ.pen_size));
            this.v = typedArrayObtainStyledAttributes.getBoolean(AbstractC3219kJ.signature_enableSignature, true);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.h = paint;
            paint.setColor(this.t);
            this.h.setAntiAlias(true);
            this.h.setStyle(Paint.Style.FILL_AND_STROKE);
            Paint paint2 = this.h;
            Paint.Join join = Paint.Join.ROUND;
            paint2.setStrokeJoin(join);
            Paint paint3 = this.h;
            Paint.Cap cap = Paint.Cap.ROUND;
            paint3.setStrokeCap(cap);
            this.h.setStrokeWidth(this.w);
            Paint paint4 = new Paint(1);
            this.i = paint4;
            paint4.setAntiAlias(true);
            this.i.setStyle(Paint.Style.STROKE);
            this.i.setStrokeJoin(join);
            this.i.setStrokeCap(cap);
            this.i.setColor(ViewCompat.MEASURED_STATE_MASK);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void a() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0f;
        this.g = 0.0f;
        h(this.k, this.l, this.n, this.p);
        postInvalidate();
    }

    public final void b(PG pg, PG pg2, PG pg3, float f, float f2, float f3) {
        if (this.a == null) {
            return;
        }
        float f4 = (f3 <= 1.6f || f3 >= 15.0f) ? 0.01f : 0.0085f - (f3 * 5.0E-4f);
        float f5 = 0.0f;
        while (true) {
            float f6 = 1.0f;
            if (f5 >= 1.0f) {
                return;
            }
            float fD = d(pg.a, pg2.a, f5);
            float fD2 = d(pg.b, pg2.b, f5);
            float fD3 = d(pg2.a, pg3.a, f5);
            float fD4 = d(pg2.b, pg3.b, f5);
            float fD5 = d(fD, fD3, f5);
            float fD6 = d(fD2, fD4, f5);
            float f7 = ((f2 - f) * f5) + f;
            Paint paint = this.h;
            if (f7 >= 1.0f) {
                f6 = f7;
            }
            paint.setStrokeWidth(f6);
            this.a.drawPoint(fD5, fD6, this.h);
            f5 += f4;
        }
    }

    public final void c(float f, float f2, float f3) {
        b(g(this.c, this.d), this.c, g(this.e, this.c), f, f2, f3);
    }

    public final float d(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public final float e(float f) {
        return this.w - (f * 1.0f);
    }

    public boolean f() {
        return this.v;
    }

    public final PG g(PG pg, PG pg2) {
        return new PG((pg.a + pg2.a) / 2.0f, (pg.b + pg2.b) / 2.0f, (pg.c + pg2.c) / 2);
    }

    public int getBackgroundColor() {
        return this.u;
    }

    public int getPenColor() {
        return this.t;
    }

    public float getPenSize() {
        return this.w;
    }

    public Bitmap getSignatureBitmap() {
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), this.j.getHeight(), true);
        }
        return null;
    }

    public String getVersionName() {
        return "1.2";
    }

    public final void h(int i, int i2, int i3, int i4) {
        int i5;
        this.j = null;
        this.a = null;
        int i6 = i3 - i;
        if (i6 <= 0 || (i5 = i4 - i2) <= 0) {
            return;
        }
        this.j = Bitmap.createBitmap(i6, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.j);
        this.a = canvas;
        canvas.drawColor(this.u);
    }

    public final void i(float f, float f2) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0.0f;
        this.g = this.w;
        PG pg = new PG(f, f2, System.currentTimeMillis());
        this.e = pg;
        this.c = pg;
        this.d = pg;
        postInvalidate();
    }

    public final void j(float f, float f2) {
        PG pg = this.c;
        if (pg == null) {
            return;
        }
        this.d = pg;
        this.c = this.e;
        PG pg2 = new PG(f, f2, System.currentTimeMillis());
        this.e = pg2;
        float fB = (pg2.b(this.c) * 0.2f) + (this.f * 0.8f);
        float fE = e(fB);
        c(this.g, fE, fB);
        this.f = fB;
        this.g = fE;
        postInvalidate();
    }

    public final void k(float f, float f2) {
        PG pg = this.c;
        if (pg == null) {
            return;
        }
        this.d = pg;
        this.c = this.e;
        this.e = new PG(f, f2, System.currentTimeMillis());
        c(this.g, 0.0f, this.f);
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.j, 0.0f, 0.0f, this.i);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.k = i;
        this.l = i2;
        this.n = i3;
        this.p = i4;
        if (this.j == null) {
            h(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!f() || motionEvent.getPointerCount() > 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = false;
            this.q = new Rect(getLeft(), getTop(), getRight(), getBottom());
            i(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            k(motionEvent.getX(), motionEvent.getY());
        } else if (action != 2) {
            if (action == 3) {
                k(motionEvent.getX(), motionEvent.getY());
            }
        } else if (this.q.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY()))) {
            if (this.b) {
                this.b = false;
                i(motionEvent.getX(), motionEvent.getY());
            } else {
                j(motionEvent.getX(), motionEvent.getY());
            }
        } else if (!this.b) {
            this.b = true;
            k(motionEvent.getX(), motionEvent.getY());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.u = i;
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.j = bitmap;
            this.a = new Canvas(bitmap);
            postInvalidate();
        }
    }

    public void setEnableSignature(boolean z) {
        this.v = z;
    }

    public void setPenColor(int i) {
        this.t = i;
        this.h.setColor(i);
    }

    public void setPenSize(float f) {
        this.w = f;
    }
}
