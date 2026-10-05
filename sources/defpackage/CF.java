package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CF {
    public static int h;
    public static int i;
    public final List a;
    public boolean b;
    public int c;
    public RectF d;
    public int e;
    public C3126j9 f;
    public final Map g;

    public CF(RectF rectF, int i2) {
        this(-1, rectF, i2, null);
    }

    public int A() {
        return this.e;
    }

    public float B() {
        return this.d.width();
    }

    public boolean C() {
        return this.b;
    }

    public void D() {
        h = this.a.size();
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            JF jf = (JF) ((C2283gY) it.next()).a();
            if (jf != null && jf.c() == 3) {
                jf.i(2);
            }
        }
    }

    public void a(AbstractC3215kF abstractC3215kF) {
        synchronized (this.a) {
            this.a.add(abstractC3215kF);
        }
        D();
    }

    public void b(CF cf) {
        c(cf, null);
    }

    public void c(CF cf, Matrix matrix) {
        synchronized (this.a) {
            try {
                m();
                if (matrix != null) {
                    q(matrix);
                }
                this.a.addAll(cf.v());
                l();
            } catch (Throwable th) {
                throw th;
            }
        }
        D();
    }

    public void d(float[] fArr, float f) {
        C3133jF c3133jF = new C3133jF();
        c3133jF.b(fArr, f);
        a(c3133jF);
    }

    public void e(int i2) {
        C3133jF c3133jF = new C3133jF();
        Paint.Cap cap = Paint.Cap.BUTT;
        if (i2 != 0) {
            if (i2 == 1) {
                cap = Paint.Cap.ROUND;
            } else if (i2 == 2) {
                cap = Paint.Cap.SQUARE;
            }
        }
        c3133jF.c(cap);
        a(c3133jF);
    }

    public void f(float f) {
        a(new C3786rF(f));
    }

    public void g(DF df) {
        a(new C3867sF(df));
    }

    public void h(C4353yF c4353yF) {
        a(new C4444zF(c4353yF));
    }

    public void i(int i2) {
        C3133jF c3133jF = new C3133jF();
        Paint.Join join = Paint.Join.MITER;
        if (i2 != 0) {
            if (i2 == 1) {
                join = Paint.Join.ROUND;
            } else if (i2 == 2) {
                join = Paint.Join.BEVEL;
            }
        }
        c3133jF.d(join);
        a(c3133jF);
    }

    public void j(float f) {
        C3133jF c3133jF = new C3133jF();
        c3133jF.e(f);
        a(c3133jF);
    }

    public void k(Path path, int i2) {
        a(new KF(path, i2));
    }

    public void l() {
        a(new HF());
    }

    public void m() {
        a(new IF());
    }

    public void n(float f) {
        a(new MF(f));
    }

    public void o(DF df) {
        a(new NF(df));
    }

    public void p(float f) {
        C3133jF c3133jF = new C3133jF();
        c3133jF.f(f);
        a(c3133jF);
    }

    public void q(Matrix matrix) {
        a(new PF(new Matrix(matrix)));
    }

    public synchronized void r() {
        this.b = true;
        notifyAll();
        D();
    }

    public RectF s() {
        return this.d;
    }

    public AbstractC3215kF t(int i2) {
        i = i2;
        return (AbstractC3215kF) this.a.get(i2);
    }

    public int u() {
        return this.a.size();
    }

    public List v() {
        return this.a;
    }

    public float w() {
        return this.d.height();
    }

    public Bitmap x(int i2, int i3, RectF rectF, boolean z, boolean z2) {
        C3100is c3100is = new C3100is(i2, i3, rectF, -1);
        if (z) {
            c3100is.d = -1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        JF jf = new JF(this, c3100is, bitmapCreateBitmap);
        this.g.put(c3100is, new C2283gY(jf));
        if (!jf.f()) {
            jf.d(z2);
        }
        return bitmapCreateBitmap;
    }

    public Matrix y(int i2, int i3, RectF rectF) {
        Matrix matrix = new Matrix();
        int iA = A();
        if (iA == 0) {
            AbstractC4128vX.c(matrix, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, i3);
        } else if (iA == 90) {
            AbstractC4128vX.c(matrix, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        } else if (iA == 180) {
            AbstractC4128vX.c(matrix, -1.0f, 0.0f, 0.0f, 1.0f, i2, 0.0f);
        } else if (iA == 270) {
            AbstractC4128vX.c(matrix, 0.0f, -1.0f, -1.0f, 0.0f, i2, i3);
        }
        if (rectF == null) {
            rectF = s();
        } else if (A() == 90 || A() == 270) {
            i3 = i2;
            i2 = i3;
        }
        matrix.preScale(i2 / rectF.width(), i3 / rectF.height());
        matrix.preTranslate(-rectF.left, -rectF.top);
        return matrix;
    }

    public int z() {
        return this.c;
    }

    public CF(int i2, RectF rectF, int i3, C3126j9 c3126j9) {
        this.a = Collections.synchronizedList(new ArrayList(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        this.b = false;
        this.g = Collections.synchronizedMap(new HashMap());
        this.c = i2;
        this.f = c3126j9;
        rectF = rectF == null ? new RectF(0.0f, 0.0f, 1.0f, 1.0f) : rectF;
        i3 = i3 < 0 ? i3 + 360 : i3;
        this.e = i3;
        if (i3 == 90 || i3 == 270) {
            float f = rectF.left;
            rectF = new RectF(f, rectF.top, rectF.height() + f, rectF.top + rectF.width());
        }
        this.d = rectF;
    }
}
