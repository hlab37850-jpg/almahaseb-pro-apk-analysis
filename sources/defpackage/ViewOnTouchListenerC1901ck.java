package defpackage;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: ck, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnTouchListenerC1901ck implements View.OnTouchListener {
    public e a = e.NONE;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public c g;
    public d h;
    public b i;
    public float j;
    public float k;
    public long l;

    /* JADX INFO: renamed from: ck$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.ZOOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.DRAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: ck$b */
    public interface b {
        void a(float f, float f2);
    }

    /* JADX INFO: renamed from: ck$c */
    public interface c {
        void c(float f, float f2);

        void d(float f, float f2);

        void e(float f, float f2);
    }

    /* JADX INFO: renamed from: ck$d */
    public interface d {
        void b(float f, PointF pointF);
    }

    /* JADX INFO: renamed from: ck$e */
    public enum e {
        NONE,
        ZOOM,
        DRAG
    }

    public final float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        return PointF.length(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
    }

    public final void b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        c cVar = this.g;
        if (cVar != null) {
            cVar.d(x - this.b, y - this.c);
        }
        this.b = x;
        this.c = y;
    }

    public final void c() {
        this.g.c(this.b, this.c);
    }

    public final boolean d(MotionEvent motionEvent, float f, float f2, float f3, float f4) {
        if (motionEvent == null) {
            return false;
        }
        return motionEvent.getEventTime() - motionEvent.getDownTime() < 500 && PointF.length(f - f3, f2 - f4) < 5.0f;
    }

    public void e(b bVar) {
        this.i = bVar;
    }

    public void f(c cVar) {
        this.g = cVar;
    }

    public void g(d dVar) {
        this.h = dVar;
    }

    public final void h(MotionEvent motionEvent) {
        this.b = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        this.c = y;
        this.g.e(this.b, y);
    }

    public final void i(MotionEvent motionEvent) {
        this.f = a(motionEvent);
    }

    public final void j(MotionEvent motionEvent) {
        float fA = a(motionEvent);
        d dVar = this.h;
        if (dVar != null) {
            dVar.b(fA / this.f, new PointF(motionEvent.getX(0), motionEvent.getY(0)));
        }
        this.f = fA;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            h(motionEvent);
            this.a = e.DRAG;
            this.j = motionEvent.getX();
            this.k = motionEvent.getY();
        } else if (action == 1) {
            this.a = e.NONE;
            c();
            if (d(motionEvent, this.j, this.k, motionEvent.getX(), motionEvent.getY())) {
                if (System.currentTimeMillis() - this.l < 280.0f) {
                    b bVar = this.i;
                    if (bVar != null) {
                        bVar.a(motionEvent.getX(), motionEvent.getY());
                    }
                    this.l = 0L;
                } else {
                    this.l = System.currentTimeMillis();
                }
            }
        } else if (action == 2) {
            int i = a.a[this.a.ordinal()];
            if (i == 1) {
                this.d = motionEvent.getX(1);
                this.e = motionEvent.getY(1);
                j(motionEvent);
            } else if (i == 2) {
            }
            b(motionEvent);
        } else if (action == 5) {
            this.d = motionEvent.getX(0);
            this.e = motionEvent.getY(0);
            h(motionEvent);
            i(motionEvent);
            this.a = e.ZOOM;
        } else if (action == 6) {
            this.b = this.d;
            this.c = this.e;
            this.a = e.DRAG;
        } else if (action == 261) {
            h(motionEvent);
            i(motionEvent);
            this.a = e.ZOOM;
        } else if (action == 262) {
            this.a = e.DRAG;
        }
        return true;
    }
}
