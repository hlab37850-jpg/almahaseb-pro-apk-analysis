package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScopeKt {
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo3477clipPathmtrdDE(Path path, int i) {
                AbstractC4492zt.h(path, "path");
                drawContext.getCanvas().mo2892clipPathmtrdDE(path, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo3478clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
                drawContext.getCanvas().mo2893clipRectN_I0leg(f, f2, f3, f4, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo3479getCenterF1C5BW0() {
                return SizeKt.m2877getCenteruvyYCjk(mo3480getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo3480getSizeNHjbRc() {
                return drawContext.mo3475getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float f, float f2, float f3, float f4) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jSize = SizeKt.Size(Size.m2867getWidthimpl(mo3480getSizeNHjbRc()) - (f3 + f), Size.m2864getHeightimpl(mo3480getSizeNHjbRc()) - (f4 + f2));
                if (Size.m2867getWidthimpl(jSize) < 0.0f || Size.m2864getHeightimpl(jSize) < 0.0f) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo3476setSizeuvyYCjk(jSize);
                canvas.translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo3481rotateUv8p0NA(float f, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
                canvas.rotate(f);
                canvas.translate(-Offset.m2798getXimpl(j), -Offset.m2799getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo3482scale0AR0LA0(float f, float f2, long j) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
                canvas.scale(f, f2);
                canvas.translate(-Offset.m2798getXimpl(j), -Offset.m2799getYimpl(j));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo3483transform58bKbWc(float[] fArr) {
                AbstractC4492zt.h(fArr, "matrix");
                drawContext.getCanvas().mo2895concat58bKbWc(fArr);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float f, float f2) {
                drawContext.getCanvas().translate(f, f2);
            }
        };
    }
}
