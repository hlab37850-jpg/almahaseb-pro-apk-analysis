package ru.nikartm.support;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.C4392yk;
import defpackage.HE;

/* JADX INFO: loaded from: classes4.dex */
public class ImageBadgeView extends AppCompatImageView {
    public C4392yk a;

    public ImageBadgeView(Context context) {
        super(context);
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        this.a = new C4392yk(this, attributeSet);
    }

    public ImageBadgeView b(int i) {
        this.a.b().L(i);
        invalidate();
        return this;
    }

    public int getBadgeBackground() {
        return this.a.b().b();
    }

    public Drawable getBadgeBackgroundDrawable() {
        return this.a.b().a();
    }

    public int getBadgeColor() {
        return this.a.b().c();
    }

    public float getBadgePadding() {
        return this.a.b().i();
    }

    public int getBadgePosition() {
        return this.a.b().j();
    }

    public float getBadgeRadius() {
        return this.a.b().k();
    }

    public int getBadgeTextColor() {
        return this.a.b().d();
    }

    public Typeface getBadgeTextFont() {
        return this.a.b().e();
    }

    public float getBadgeTextSize() {
        return this.a.b().f();
    }

    public int getBadgeTextStyle() {
        return this.a.b().l();
    }

    public int getBadgeValue() {
        return this.a.b().n();
    }

    public int getMaxBadgeValue() {
        return this.a.b().h();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas);
    }

    public ImageBadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ImageBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    public void setOnBadgeCountChangeListener(HE he) {
    }
}
