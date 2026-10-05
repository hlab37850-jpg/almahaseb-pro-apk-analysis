package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation = new int[2];
    private final float[] tmpMatrix = Matrix.m3237constructorimpl$default(null, 1, null);

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m4471preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m2911setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m4468preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m4472preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        Matrix.m3246resetimpl(this.tmpMatrix);
        Matrix.m3257translateimpl$default(this.tmpMatrix, f, f2, 0.0f, 4, null);
        AndroidComposeView_androidKt.m4468preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m4473transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m4473transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m4472preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m4472preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            m4472preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m4472preTranslate3XD1CNM(fArr, iArr[0], iArr[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        AbstractC4492zt.g(matrix, "viewMatrix");
        m4471preConcattUYjHk(fArr, matrix);
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo4470calculateMatrixToWindowEL8BTi8(View view, float[] fArr) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(fArr, "matrix");
        Matrix.m3246resetimpl(fArr);
        m4473transformMatrixToWindowEL8BTi8(view, fArr);
    }
}
