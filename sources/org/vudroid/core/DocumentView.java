package org.vudroid.core;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import defpackage.AbstractC3574of;
import defpackage.AbstractC3658pg;
import defpackage.InterfaceC3662pi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DocumentView extends View {
    public final HashMap a;
    public boolean b;
    public float c;
    public float d;
    public VelocityTracker e;
    public final Scroller f;
    public RectF g;
    public boolean h;
    public long i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentView.a(DocumentView.this);
            DocumentView.this.getCurrentPage();
            throw null;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentView.this.h();
        }
    }

    public static /* synthetic */ AbstractC3658pg a(DocumentView documentView) {
        documentView.getClass();
        return null;
    }

    private int getBottomLimit() {
        HashMap map = this.a;
        AbstractC3574of.a(map.get(Integer.valueOf(map.size() - 1)));
        throw null;
    }

    private int getLeftLimit() {
        return 0;
    }

    private int getRightLimit() {
        getWidth();
        throw null;
    }

    private float getScrollScaleRatio() {
        AbstractC3574of.a(this.a.get(0));
        return 0.0f;
    }

    private int getTopLimit() {
        return 0;
    }

    private void setLastPosition(MotionEvent motionEvent) {
        this.c = motionEvent.getX();
        this.d = motionEvent.getY();
    }

    public void c() {
        Iterator it = this.a.values().iterator();
        if (it.hasNext()) {
            AbstractC3574of.a(it.next());
            throw null;
        }
        this.h = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f.computeScrollOffset()) {
            scrollTo(this.f.getCurrX(), this.f.getCurrY());
        }
    }

    public void d() {
        if (this.b) {
            getWidth();
            throw null;
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    i(-1);
                    return true;
                case 20:
                    i(1);
                    return true;
                case 21:
                    f(-1);
                    return true;
                case 22:
                    f(1);
                    return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void e(float f) {
        if (this.b) {
            g();
            AbstractC3574of.a(this.a.get(0));
        }
    }

    public final void f(int i) {
        if (i != 1 ? getScrollX() != getLeftLimit() : getScrollX() != getRightLimit()) {
            this.f.startScroll(getScrollX(), getScrollY(), (i * getWidth()) / 2, 0);
            invalidate();
            return;
        }
        getScrollX();
        getScrollY();
        getLeftLimit();
        getRightLimit();
        AbstractC3574of.a(this.a.get(Integer.valueOf(getCurrentPage())));
        throw null;
    }

    public final void g() {
        if (this.f.isFinished()) {
            return;
        }
        this.f.abortAnimation();
    }

    public int getCurrentPage() {
        Iterator it = this.a.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        AbstractC3574of.a(((Map.Entry) it.next()).getValue());
        throw null;
    }

    public RectF getViewRect() {
        if (this.g == null) {
            this.g = new RectF(getScrollX(), getScrollY(), getScrollX() + getWidth(), getScrollY() + getHeight());
        }
        return this.g;
    }

    public final void h() {
        Iterator it = this.a.values().iterator();
        if (it.hasNext()) {
            AbstractC3574of.a(it.next());
            throw null;
        }
    }

    public final void i(int i) {
        this.f.startScroll(getScrollX(), getScrollY(), 0, (i * getHeight()) / 2);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator it = this.a.values().iterator();
        if (it.hasNext()) {
            AbstractC3574of.a(it.next());
            throw null;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float scrollScaleRatio = getScrollScaleRatio();
        d();
        e(scrollScaleRatio);
        c();
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        post(new a());
        if (this.h) {
            return;
        }
        post(new b());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        this.e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            g();
            setLastPosition(motionEvent);
            if (motionEvent.getEventTime() - this.i < 500) {
                throw null;
            }
            this.i = motionEvent.getEventTime();
        } else if (action == 1) {
            this.e.computeCurrentVelocity(1000);
            this.f.fling(getScrollX(), getScrollY(), (int) (-this.e.getXVelocity()), (int) (-this.e.getYVelocity()), getLeftLimit(), getRightLimit(), getTopLimit(), getBottomLimit());
            this.e.recycle();
            this.e = null;
        } else if (action == 2) {
            scrollBy((int) (this.c - motionEvent.getX()), (int) (this.d - motionEvent.getY()));
            setLastPosition(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(Math.min(Math.max(i, getLeftLimit()), getRightLimit()), Math.min(Math.max(i2, getTopLimit()), getBottomLimit()));
        this.g = null;
    }

    public void setDecodeService(InterfaceC3662pi interfaceC3662pi) {
    }
}
