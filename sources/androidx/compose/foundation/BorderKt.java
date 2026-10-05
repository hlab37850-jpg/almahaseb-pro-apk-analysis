package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BorderKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ContentDrawScope) obj);
            return FW.a;
        }

        public final void invoke(ContentDrawScope contentDrawScope) {
            AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
            contentDrawScope.drawContent();
        }
    }

    public static final Modifier border(Modifier modifier, BorderStroke borderStroke, Shape shape) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(borderStroke, "border");
        AbstractC4492zt.h(shape, "shape");
        return m180borderziNgDLE(modifier, borderStroke.m193getWidthD9Ej5fM(), borderStroke.getBrush(), shape);
    }

    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m178borderxT4_qwU(Modifier modifier, float f, long j, Shape shape) {
        AbstractC4492zt.h(modifier, "$this$border");
        AbstractC4492zt.h(shape, "shape");
        return m180borderziNgDLE(modifier, f, new SolidColor(j, null), shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m179borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m178borderxT4_qwU(modifier, f, j, shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m180borderziNgDLE(Modifier modifier, float f, Brush brush, Shape shape) {
        AbstractC4492zt.h(modifier, "$this$border");
        AbstractC4492zt.h(brush, "brush");
        AbstractC4492zt.h(shape, "shape");
        return modifier.then(new BorderModifierNodeElement(f, brush, shape, null));
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m182shrinkKibmq7A(roundRect.m2848getTopLeftCornerRadiuskKHJgLs(), f), m182shrinkKibmq7A(roundRect.m2849getTopRightCornerRadiuskKHJgLs(), f), m182shrinkKibmq7A(roundRect.m2847getBottomRightCornerRadiuskKHJgLs(), f), m182shrinkKibmq7A(roundRect.m2846getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f, roundRect));
            path.mo2932opN5in7k0(path, Path, PathOperation.Companion.m3295getDifferenceb3I0S0c());
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m181drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, Brush brush, long j, long j2, boolean z, float f) {
        return cacheDrawScope.onDrawWithContent(new BorderKt$drawRectBorder$1(brush, z ? Offset.Companion.m2814getZeroF1C5BW0() : j, z ? cacheDrawScope.m2701getSizeNHjbRc() : j2, z ? Fill.INSTANCE : new Stroke(f, 0.0f, 0, 0, null, 30, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m182shrinkKibmq7A(long j, float f) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m2773getXimpl(j) - f), Math.max(0.0f, CornerRadius.m2774getYimpl(j) - f));
    }
}
