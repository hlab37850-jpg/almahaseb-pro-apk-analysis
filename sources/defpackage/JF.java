package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import androidx.core.view.ViewCompat;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class JF extends AbstractRunnableC3450n7 implements Runnable {
    public static final Paint.Cap v = null;
    public static final float[] w = null;
    public static final Paint.Join x = null;
    public CF g;
    public int h;
    public C2283gY i;
    public Canvas j;
    public a k;
    public Stack l;
    public RectF n;
    public Path p;
    public C3100is q;
    public RectF u;
    public long t = 0;
    public int f = 0;

    public class a implements Cloneable {
        public Rect a;
        public Paint.Cap b;
        public Paint.Join c;
        public float d;
        public float e;
        public DF f;
        public DF g;
        public Matrix h;

        public a() {
        }

        public Object clone() {
            a aVar = JF.this.new a();
            aVar.a = null;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.f = this.f;
            aVar.g = this.g;
            aVar.h = new Matrix(this.h);
            aVar.d = this.d;
            aVar.e = this.e;
            return aVar;
        }
    }

    public JF(CF cf, C3100is c3100is, Bitmap bitmap) {
        this.g = cf;
        this.q = c3100is;
        this.i = new C2283gY(new C4261x7(bitmap, this.j));
    }

    public final void A(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.q.d);
        C3100is c3100is = this.q;
        canvas.drawRect(0.0f, 0.0f, c3100is.a, c3100is.b, paint);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.setMatrix(p());
        a aVar = new a();
        this.k = aVar;
        aVar.a = null;
        aVar.f = DF.b(ViewCompat.MEASURED_STATE_MASK);
        this.k.g = DF.c(ViewCompat.MEASURED_STATE_MASK);
        this.k.h = canvas.getMatrix();
        this.l = new Stack();
        this.h = 0;
    }

    public RectF B(Path path) {
        return this.k.f.a(this, this.j, path);
    }

    public void C(Matrix matrix) {
        this.k.h.preConcat(matrix);
        this.j.setMatrix(this.k.h);
    }

    @Override // defpackage.AbstractRunnableC3450n7
    public void a() {
        this.g = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.p = null;
    }

    @Override // defpackage.AbstractRunnableC3450n7
    public int g() throws EF {
        RectF rectFA;
        if (this.g == null) {
            return 6;
        }
        C2283gY c2283gY = this.i;
        if (c2283gY != null) {
            C4261x7 c4261x7 = (C4261x7) c2283gY.a();
            if (c4261x7 == null) {
                System.out.println("Image went away.  Stopping");
                return 5;
            }
            this.j = c4261x7.a();
        }
        if (this.h >= this.g.u()) {
            return this.g.C() ? 6 : 3;
        }
        CF cf = this.g;
        int i = this.h;
        this.h = i + 1;
        AbstractC3215kF abstractC3215kFT = cf.t(i);
        if (abstractC3215kFT == null) {
            throw new EF("Command not found!");
        }
        try {
            rectFA = abstractC3215kFT.a(this);
        } catch (Exception e) {
            Log.e("APV.PDFRenderer", e.getMessage(), e);
            rectFA = null;
        }
        this.n = k(rectFA, this.n);
        this.u = k(rectFA, this.u);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis > this.t || t()) {
            this.u = null;
            this.t = jCurrentTimeMillis + 200;
        }
        if (this.i == null) {
            return 4;
        }
        this.j = null;
        return 4;
    }

    @Override // defpackage.AbstractRunnableC3450n7
    public void j() {
        Canvas canvasA;
        C2283gY c2283gY = this.i;
        if (c2283gY != null) {
            C4261x7 c4261x7 = (C4261x7) c2283gY.a();
            canvasA = c4261x7 != null ? c4261x7.a() : null;
        } else {
            canvasA = this.j;
        }
        if (canvasA != null) {
            A(canvasA);
        }
    }

    public final RectF k(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return rectF2;
        }
        if (rectF2 == null) {
            return rectF;
        }
        rectF2.union(rectF);
        return rectF2;
    }

    public void l(Path path) {
        this.j.clipPath(path);
    }

    public RectF m(C4353yF c4353yF) {
        Matrix matrix = new Matrix();
        AbstractC4128vX.c(matrix, 1.0f / c4353yF.f(), 0.0f, 0.0f, (-1.0f) / c4353yF.d(), 0.0f, 1.0f);
        Bitmap bitmapE = c4353yF.e();
        if (c4353yF.g()) {
            bitmapE = q(bitmapE);
        }
        this.j.drawBitmap(bitmapE, matrix, null);
        Matrix matrix2 = new Matrix(this.j.getMatrix());
        matrix2.preConcat(matrix);
        float[] fArr = {0.0f, 0.0f, bitmapE.getWidth() + 0.0f, bitmapE.getHeight() + 0.0f};
        matrix2.mapPoints(fArr, 0, fArr, 0, 2);
        float f = fArr[0];
        float f2 = fArr[1];
        return new RectF(f, f2, fArr[2] - f, fArr[3] - f2);
    }

    public RectF n(String str, RectF rectF) {
        Paint paintD = this.k.g.d();
        this.j.save();
        Matrix matrix = new Matrix(this.j.getMatrix());
        matrix.preScale(1.0f, -1.0f, rectF.left, rectF.top);
        this.j.setMatrix(matrix);
        this.j.drawText(str, rectF.left, rectF.top, paintD);
        this.j.restore();
        return rectF;
    }

    public RectF o(Path path) {
        return this.k.g.a(this, this.j, path);
    }

    public Matrix p() {
        CF cf = this.g;
        C3100is c3100is = this.q;
        return cf.y(c3100is.a, c3100is.b, c3100is.c);
    }

    public final Bitmap q(Bitmap bitmap) {
        int color = this.k.g.d().getColor();
        int iBlue = Color.blue(color) | (Color.alpha(color) << 24) | (Color.red(color) << 16) | (Color.green(color) << 8);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < height; i++) {
            int[] iArr = new int[width];
            int[] iArr2 = new int[width];
            bitmap.getPixels(iArr, 0, 0, 0, i, width, 1);
            for (int i2 = 0; i2 < width; i2++) {
                if (iArr[i2] == -16777216) {
                    iArr2[i2] = iBlue;
                } else {
                    iArr2[i2] = 0;
                }
            }
            bitmapCreateBitmap.setPixels(iArr2, 0, 0, 0, i, width, 1);
        }
        return bitmapCreateBitmap;
    }

    public void r() {
        a aVar = (a) this.l.pop();
        this.k = aVar;
        z(aVar.h);
        u(this.k.a);
    }

    public void s() {
        this.k.a = this.j.getClipBounds();
        this.l.push(this.k);
        this.k = (a) this.k.clone();
    }

    public final boolean t() {
        CF cf = this.g;
        if (cf == null) {
            return true;
        }
        return cf.C() && this.h == this.g.u();
    }

    public final void u(Rect rect) {
        this.k.a = rect;
        this.j.clipRect(rect, Region.Op.REPLACE);
    }

    public void v(DF df) {
        this.k.g = df;
    }

    public void w(Path path) {
        this.p = path;
    }

    public void x(DF df) {
        this.k.f = df;
    }

    public void y(float f, Paint.Cap cap, Paint.Join join, float f2, float[] fArr, float f3) {
        if (f == -1000.0f) {
            f = this.k.d;
        }
        if (cap == v) {
            cap = this.k.b;
        }
        if (join == x) {
            join = this.k.c;
        }
        if (f2 == -1000.0f) {
            f2 = this.k.e;
        }
        a aVar = this.k;
        aVar.d = f;
        aVar.b = cap;
        aVar.c = join;
        aVar.e = f2;
    }

    public void z(Matrix matrix) {
        this.k.h = matrix;
        this.j.setMatrix(matrix);
    }
}
