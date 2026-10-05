package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ViewfinderView extends View {
    public static final int[] n = {0, 64, 128, 192, 255, 192, 128, 64};
    public final Paint a;
    public Bitmap b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public int g;
    public List h;
    public List i;
    public CameraPreview j;
    public Rect k;
    public Rect l;

    public class a implements CameraPreview.f {
        public a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        typedArrayObtainStyledAttributes.recycle();
        this.g = 0;
        this.h = new ArrayList(20);
        this.i = new ArrayList(20);
    }

    public void a(ResultPoint resultPoint) {
        if (this.h.size() < 20) {
            this.h.add(resultPoint);
        }
    }

    public void b() {
        CameraPreview cameraPreview = this.j;
        if (cameraPreview == null) {
            return;
        }
        Rect framingRect = cameraPreview.getFramingRect();
        Rect previewFramingRect = this.j.getPreviewFramingRect();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }
        this.k = framingRect;
        this.l = previewFramingRect;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        b();
        Rect rect2 = this.k;
        if (rect2 == null || (rect = this.l) == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.a.setColor(this.b != null ? this.d : this.c);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect2.top, this.a);
        canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom + 1, this.a);
        canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.a);
        canvas.drawRect(0.0f, rect2.bottom + 1, f, height, this.a);
        if (this.b != null) {
            this.a.setAlpha(160);
            canvas.drawBitmap(this.b, (Rect) null, rect2, this.a);
            return;
        }
        this.a.setColor(this.e);
        Paint paint = this.a;
        int[] iArr = n;
        paint.setAlpha(iArr[this.g]);
        this.g = (this.g + 1) % iArr.length;
        int iHeight = (rect2.height() / 2) + rect2.top;
        canvas.drawRect(rect2.left + 2, iHeight - 1, rect2.right - 1, iHeight + 2, this.a);
        float fWidth = rect2.width() / rect.width();
        float fHeight = rect2.height() / rect.height();
        int i = rect2.left;
        int i2 = rect2.top;
        if (!this.i.isEmpty()) {
            this.a.setAlpha(80);
            this.a.setColor(this.f);
            for (ResultPoint resultPoint : this.i) {
                canvas.drawCircle(((int) (resultPoint.getX() * fWidth)) + i, ((int) (resultPoint.getY() * fHeight)) + i2, 3.0f, this.a);
            }
            this.i.clear();
        }
        if (!this.h.isEmpty()) {
            this.a.setAlpha(160);
            this.a.setColor(this.f);
            for (ResultPoint resultPoint2 : this.h) {
                canvas.drawCircle(((int) (resultPoint2.getX() * fWidth)) + i, ((int) (resultPoint2.getY() * fHeight)) + i2, 6.0f, this.a);
            }
            List list = this.h;
            List list2 = this.i;
            this.h = list2;
            this.i = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect2.left - 6, rect2.top - 6, rect2.right + 6, rect2.bottom + 6);
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.j = cameraPreview;
        cameraPreview.i(new a());
    }
}
