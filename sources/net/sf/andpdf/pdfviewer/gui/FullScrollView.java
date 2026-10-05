package net.sf.andpdf.pdfviewer.gui;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Scroller;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class FullScrollView extends FrameLayout {
    public int a;
    public int b;
    public long c;
    public final Rect d;
    public Scroller e;
    public boolean f;
    public float g;
    public float h;
    public boolean i;
    public View j;
    public boolean k;
    public boolean l;
    public VelocityTracker n;
    public boolean p;
    public boolean q;
    public boolean t;

    public FullScrollView(Context context) {
        this(context, null);
    }

    public boolean a(int i) {
        int right;
        int bottom;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmountX = getMaxScrollAmountX();
        int maxScrollAmountY = getMaxScrollAmountY();
        if (viewFindNextFocus != null && t(viewFindNextFocus, maxScrollAmountX) && u(viewFindNextFocus, maxScrollAmountY)) {
            viewFindNextFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.d);
            g(e(this.d));
            h(f(this.d));
            viewFindNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollX() < maxScrollAmountX) {
                maxScrollAmountX = getScrollX();
            } else if (i == 130 && (right = getChildAt(getChildCount() - 1).getRight() - (getScrollX() + getWidth())) < maxScrollAmountX) {
                maxScrollAmountX = right;
            }
            if (i == 33 && getScrollY() < maxScrollAmountY) {
                maxScrollAmountY = getScrollY();
            } else if (i == 130 && (bottom = getChildAt(getChildCount() - 1).getBottom() - (getScrollY() + getHeight())) < maxScrollAmountY) {
                maxScrollAmountY = bottom;
            }
            if (maxScrollAmountX == 0 && maxScrollAmountY == 0) {
                return false;
            }
            if (maxScrollAmountX == 0) {
                if (i != 130) {
                    maxScrollAmountY = -maxScrollAmountY;
                }
                h(maxScrollAmountY);
            } else if (maxScrollAmountY == 0) {
                if (i != 130) {
                    maxScrollAmountX = -maxScrollAmountX;
                }
                g(maxScrollAmountX);
            }
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && r(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public final boolean b() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getWidth() < (childAt.getWidth() + getPaddingLeft()) + getPaddingRight();
        }
        return false;
    }

    public final boolean c() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return getChildCount() == 0 ? getWidth() : getChildAt(0).getRight();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.computeScrollOffset()) {
            int i = this.a;
            int i2 = this.b;
            int currX = this.e.getCurrX();
            int currY = this.e.getCurrY();
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                this.a = d(currX, getWidth(), childAt.getWidth());
                this.b = d(currY, getHeight(), childAt.getHeight());
            } else {
                this.a = currX;
                this.b = currY;
            }
            int i3 = this.a;
            if (i != i3 || i2 != this.b) {
                onScrollChanged(i3, this.b, i, i2);
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return getChildCount() == 0 ? getHeight() : getChildAt(0).getBottom();
    }

    public final int d(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return i(keyEvent);
    }

    public int e(Rect rect) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (rect.left > 0) {
            scrollX += horizontalFadingEdgeLength;
        }
        if (rect.right < getChildAt(0).getWidth()) {
            i -= horizontalFadingEdgeLength;
        }
        int i2 = rect.right;
        if (i2 > i && rect.left > scrollX) {
            return Math.min(rect.width() > width ? rect.left - scrollX : rect.right - i, getChildAt(getChildCount() - 1).getRight() - i);
        }
        if (rect.left >= scrollX || i2 >= i) {
            return 0;
        }
        return Math.max(rect.width() > width ? 0 - (i - rect.right) : 0 - (scrollX - rect.left), -getScrollX());
    }

    public int f(Rect rect) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        int i2 = rect.bottom;
        if (i2 > i && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i, getChildAt(getChildCount() - 1).getBottom() - i);
        }
        if (rect.top >= scrollY || i2 >= i) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public final void g(int i) {
        if (i != 0) {
            if (this.t) {
                z(i, 0);
            } else {
                scrollBy(i, 0);
            }
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - this.b) - getHeight();
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i = this.a;
        if (i < horizontalFadingEdgeLength) {
            return i / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmountX() {
        return (int) ((getRight() - getLeft()) * 0.5f);
    }

    public int getMaxScrollAmountY() {
        return (int) ((getBottom() - getTop()) * 0.5f);
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int right = (getChildAt(0).getRight() - this.a) - getWidth();
        if (right < horizontalFadingEdgeLength) {
            return right / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i = this.b;
        if (i < verticalFadingEdgeLength) {
            return i / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final void h(int i) {
        if (i != 0) {
            if (this.t) {
                z(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    public boolean i(KeyEvent keyEvent) {
        this.d.setEmpty();
        boolean zB = b();
        boolean zA = false;
        int i = ShapeTypes.DOUBLE_WAVE;
        if (!zB || !c()) {
            if (isFocused()) {
                View viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, ShapeTypes.DOUBLE_WAVE);
                if (viewFindNextFocus != null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(ShapeTypes.DOUBLE_WAVE)) {
                    return true;
                }
            }
            return false;
        }
        if (c() && keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                zA = !keyEvent.isAltPressed() ? a(33) : p(33);
            } else if (keyCode == 20) {
                zA = !keyEvent.isAltPressed() ? a(ShapeTypes.DOUBLE_WAVE) : p(ShapeTypes.DOUBLE_WAVE);
            } else if (keyCode == 62) {
                if (keyEvent.isShiftPressed()) {
                    i = 33;
                }
                v(i);
            }
        }
        if (!b() || keyEvent.getAction() != 0) {
            return zA;
        }
        int keyCode2 = keyEvent.getKeyCode();
        if (keyCode2 == 21) {
            return !keyEvent.isAltPressed() ? a(17) : p(17);
        }
        if (keyCode2 != 22) {
            return zA;
        }
        return !keyEvent.isAltPressed() ? a(66) : p(66);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0051  */
    public final View j(boolean z, int i, int i2) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = focusables.get(i3);
            int left = view2.getLeft();
            int right = view2.getRight();
            if (i < right && left < i2) {
                boolean z3 = i < left && right < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && left < view.getLeft()) || (!z && right > view.getRight());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0051  */
    public final View k(boolean z, int i, int i2) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    public final View l(boolean z, int i, View view) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int i2 = i + horizontalFadingEdgeLength;
        int width = (i + getWidth()) - horizontalFadingEdgeLength;
        return (view == null || view.getLeft() >= width || view.getRight() <= i2) ? j(z, i2, width) : view;
    }

    public final View m(boolean z, int i, View view) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int i2 = i + verticalFadingEdgeLength;
        int height = (i + getHeight()) - verticalFadingEdgeLength;
        return (view == null || view.getTop() >= height || view.getBottom() <= i2) ? k(z, i2, height) : view;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, 0), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(int i) {
        this.e.fling(this.a, this.b, i, 0, 0, 0, 0, getChildAt(getChildCount() - 1).getRight() - getWidth());
        boolean z = i > 0;
        View viewL = l(z, this.e.getFinalX(), findFocus());
        if (viewL == null) {
            viewL = this;
        }
        if (viewL != findFocus()) {
            if (viewL.requestFocus(z ? ShapeTypes.DOUBLE_WAVE : 33)) {
                this.f = false;
            }
        }
        invalidate();
    }

    public void o(int i) {
        this.e.fling(this.a, this.b, 0, i, 0, 0, 0, getChildAt(getChildCount() - 1).getBottom() - getHeight());
        boolean z = i > 0;
        View viewM = m(z, this.e.getFinalY(), findFocus());
        if (viewM == null) {
            viewM = this;
        }
        if (viewM != findFocus()) {
            if (viewM.requestFocus(z ? ShapeTypes.DOUBLE_WAVE : 33)) {
                this.f = false;
            }
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && (this.k || this.l)) {
            return true;
        }
        if (!b()) {
            this.k = false;
        }
        if (!c()) {
            this.l = false;
        }
        if (!c() && !b()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.g = x;
            this.h = y;
            this.k = !this.e.isFinished();
            this.l = !this.e.isFinished();
        } else if (action == 1) {
            this.k = false;
            this.l = false;
        } else if (action == 2) {
            if (((int) Math.abs(x - this.g)) > ViewConfiguration.getTouchSlop()) {
                this.k = true;
            }
            if (((int) Math.abs(y - this.h)) > ViewConfiguration.getTouchSlop()) {
                this.l = true;
            }
        } else if (action == 3) {
            this.k = false;
            this.l = false;
        }
        return this.k || this.l;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.i = false;
        View view = this.j;
        if (view != null && s(view, this)) {
            x(this.j);
        }
        this.j = null;
        scrollTo(this.a, this.b);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.p || this.q) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == 0 && mode == 0) {
                return;
            }
            View childAt = getChildAt(0);
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredWidth() < measuredWidth && childAt.getMeasuredHeight() < measuredHeight && mode2 != 0 && mode != 0 && this.p && this.q) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
                return;
            }
            if (childAt.getMeasuredHeight() < measuredHeight && mode2 != 0 && this.q) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            } else {
                if (childAt.getMeasuredWidth() >= measuredWidth || mode == 0 || !this.p) {
                    return;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - getPaddingLeft()) - getPaddingRight(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = ShapeTypes.DOUBLE_WAVE;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || r(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus) {
            return;
        }
        int right = getRight() - getLeft();
        int bottom = getBottom() - getTop();
        if (t(viewFindFocus, right)) {
            viewFindFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(viewFindFocus, this.d);
            g(e(this.d));
        }
        if (u(viewFindFocus, bottom)) {
            viewFindFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(viewFindFocus, this.d);
            h(f(this.d));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (!b() && !c()) {
            return false;
        }
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            if (!this.e.isFinished()) {
                this.e.abortAnimation();
            }
            this.g = x;
            this.h = y;
        } else if (action == 1) {
            VelocityTracker velocityTracker = this.n;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(xVelocity) > ViewConfiguration.getMinimumFlingVelocity() && getChildCount() > 0) {
                n(-xVelocity);
            }
            if (Math.abs(yVelocity) > ViewConfiguration.getMinimumFlingVelocity() && getChildCount() > 0) {
                o(-yVelocity);
            }
            VelocityTracker velocityTracker2 = this.n;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.n = null;
            }
        } else if (action == 2) {
            int i = (int) (this.g - x);
            this.g = x;
            int i2 = (int) (this.h - y);
            this.h = y;
            if (i < 0) {
                if (this.a >= 0) {
                    scrollBy(i, 0);
                }
            } else if (i > 0) {
                int right = (getChildAt(0).getRight() - this.a) - (getWidth() - getPaddingRight());
                if (right > 0) {
                    scrollBy(Math.min(right, i), 0);
                }
            }
            if (i2 < 0) {
                if (this.b >= 0) {
                    scrollBy(0, i2);
                }
            } else if (i2 > 0) {
                int bottom = (getChildAt(0).getBottom() - this.b) - (getHeight() - getPaddingBottom());
                if (bottom > 0) {
                    scrollBy(0, Math.min(bottom, i2));
                }
            }
        }
        return true;
    }

    public boolean p(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.d;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.d.bottom = getChildAt(childCount - 1).getBottom();
            Rect rect2 = this.d;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.d;
        return w(i, rect3.top, rect3.bottom);
    }

    public final void q() {
        this.e = new Scroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
    }

    public final boolean r(View view) {
        return (t(view, 0) || u(view, 0)) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f) {
            if (this.i) {
                this.j = view2;
            } else {
                x(view2);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return y(rect, z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    public final boolean s(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && s((View) parent, view2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int iD = d(i, getWidth(), childAt.getWidth());
            int iD2 = d(i2, getHeight(), childAt.getHeight());
            if (iD == this.a && iD2 == this.b) {
                return;
            }
            super.scrollTo(iD, iD2);
            this.a = iD;
            this.b = iD2;
        }
    }

    public void setFillViewportX(boolean z) {
        if (z != this.p) {
            this.p = z;
            requestLayout();
        }
    }

    public void setFillViewportY(boolean z) {
        if (z != this.q) {
            this.q = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.t = z;
    }

    public final boolean t(View view, int i) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        return this.d.right + i >= getScrollX() && this.d.left - i <= getScrollX() + getWidth();
    }

    public final boolean u(View view, int i) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        return this.d.bottom + i >= getScrollY() && this.d.top - i <= getScrollY() + getHeight();
    }

    public boolean v(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.d.top + height > childAt.getBottom()) {
                    this.d.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.d.top = getScrollY() - height;
            Rect rect = this.d;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.d;
        int i2 = rect2.top;
        int i3 = height + i2;
        rect2.bottom = i3;
        return w(i, i2, i3);
    }

    public final boolean w(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = true;
        boolean z2 = i == 33;
        View viewK = k(z2, i2, i3);
        if (viewK == null) {
            viewK = this;
        }
        if (i2 < scrollY || i3 > i4) {
            h(z2 ? i2 - scrollY : i3 - i4);
        } else {
            z = false;
        }
        if (viewK != findFocus() && viewK.requestFocus(i)) {
            this.f = false;
        }
        return z;
    }

    public final void x(View view) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        int iE = e(this.d);
        int iF = f(this.d);
        if (iF == 0 && iE == 0) {
            return;
        }
        scrollBy(iE, iF);
    }

    public final boolean y(Rect rect, boolean z) {
        int iE = e(rect);
        int iF = f(rect);
        boolean z2 = (iE == 0 && iF == 0) ? false : true;
        if (z2) {
            if (z) {
                scrollBy(iE, iF);
            } else {
                z(iE, iF);
            }
        }
        return z2;
    }

    public final void z(int i, int i2) {
        if (AnimationUtils.currentAnimationTimeMillis() - this.c > 250) {
            this.e.startScroll(this.a, this.b, i, i2);
            invalidate();
        } else {
            if (!this.e.isFinished()) {
                this.e.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.c = AnimationUtils.currentAnimationTimeMillis();
    }

    public FullScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollViewStyle);
    }

    public FullScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
        this.i = true;
        this.j = null;
        this.k = false;
        this.l = false;
        this.t = true;
        q();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
