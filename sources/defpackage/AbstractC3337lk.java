package defpackage;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawTransform;

/* JADX INFO: renamed from: lk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3337lk {
    public static long a(DrawTransform drawTransform) {
        float f = 2;
        return OffsetKt.Offset(Size.m2867getWidthimpl(drawTransform.mo3480getSizeNHjbRc()) / f, Size.m2864getHeightimpl(drawTransform.mo3480getSizeNHjbRc()) / f);
    }

    public static /* synthetic */ void c(DrawTransform drawTransform, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        drawTransform.mo3477clipPathmtrdDE(path, i);
    }

    public static /* synthetic */ void d(DrawTransform drawTransform, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 1) != 0) {
            f = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = Size.m2867getWidthimpl(drawTransform.mo3480getSizeNHjbRc());
        }
        if ((i2 & 8) != 0) {
            f4 = Size.m2864getHeightimpl(drawTransform.mo3480getSizeNHjbRc());
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        drawTransform.mo3478clipRectN_I0leg(f, f2, f3, f4, i);
    }

    public static /* synthetic */ void e(DrawTransform drawTransform, float f, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = drawTransform.mo3479getCenterF1C5BW0();
        }
        drawTransform.mo3481rotateUv8p0NA(f, j);
    }

    public static /* synthetic */ void f(DrawTransform drawTransform, float f, float f2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
        }
        if ((i & 4) != 0) {
            j = drawTransform.mo3479getCenterF1C5BW0();
        }
        drawTransform.mo3482scale0AR0LA0(f, f2, j);
    }

    public static /* synthetic */ void g(DrawTransform drawTransform, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawTransform.translate(f, f2);
    }
}
