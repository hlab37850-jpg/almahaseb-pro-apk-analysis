package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final Canvas Canvas(ImageBitmap imageBitmap) {
        AbstractC4492zt.h(imageBitmap, "image");
        return AndroidCanvas_androidKt.ActualCanvas(imageBitmap);
    }

    public static final void rotate(Canvas canvas, float f, float f2, float f3) {
        AbstractC4492zt.h(canvas, "<this>");
        if (f == 0.0f) {
            return;
        }
        canvas.translate(f2, f3);
        canvas.rotate(f);
        canvas.translate(-f2, -f3);
    }

    public static final void rotateRad(Canvas canvas, float f, float f2, float f3) {
        AbstractC4492zt.h(canvas, "<this>");
        rotate(canvas, DegreesKt.degrees(f), f2, f3);
    }

    public static /* synthetic */ void rotateRad$default(Canvas canvas, float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        rotateRad(canvas, f, f2, f3);
    }

    public static final void scale(Canvas canvas, float f, float f2, float f3, float f4) {
        AbstractC4492zt.h(canvas, "<this>");
        if (f == 1.0f && f2 == 1.0f) {
            return;
        }
        canvas.translate(f3, f4);
        canvas.scale(f, f2);
        canvas.translate(-f3, -f4);
    }

    public static /* synthetic */ void scale$default(Canvas canvas, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        scale(canvas, f, f2, f3, f4);
    }

    public static final void withSave(Canvas canvas, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(canvas, "<this>");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        try {
            canvas.save();
            interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restore();
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withSaveLayer(Canvas canvas, Rect rect, Paint paint, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(canvas, "<this>");
        AbstractC4492zt.h(rect, "bounds");
        AbstractC4492zt.h(paint, "paint");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        try {
            canvas.saveLayer(rect, paint);
            interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restore();
            AbstractC0703Ks.a(1);
        }
    }
}
