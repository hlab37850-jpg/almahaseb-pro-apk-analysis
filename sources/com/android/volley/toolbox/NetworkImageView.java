package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.AbstractC3181js;
import defpackage.C2119eY;
import defpackage.DL;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkImageView extends ImageView {
    public String a;
    public int b;
    public int c;

    public class a implements DL.a {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            if (NetworkImageView.this.c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.c);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public final void b(boolean z) {
        int width = getWidth();
        int height = getHeight();
        boolean z2 = getLayoutParams() != null && getLayoutParams().height == -2 && getLayoutParams().width == -2;
        if (width == 0 && height == 0 && !z2) {
            return;
        }
        if (TextUtils.isEmpty(this.a)) {
            c();
        } else {
            new a(z);
            throw null;
        }
    }

    public final void c() {
        int i = this.b;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b(true);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    public void setImageUrl(String str, AbstractC3181js abstractC3181js) {
        this.a = str;
        b(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
