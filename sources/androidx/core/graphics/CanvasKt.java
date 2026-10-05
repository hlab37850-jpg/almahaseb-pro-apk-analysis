package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.AbstractC0703Ks;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withSave(Canvas canvas, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f, f2);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, InterfaceC3750qp interfaceC3750qp) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            interfaceC3750qp.invoke(canvas);
        } finally {
            AbstractC0703Ks.b(1);
            canvas.restoreToCount(iSave);
            AbstractC0703Ks.a(1);
        }
    }
}
