package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LayerMatrixCache<T> {
    private Matrix androidMatrixCache;
    private final InterfaceC0526Fp getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty;
    private boolean isInverseDirty;
    private boolean isInverseValid;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;

    public LayerMatrixCache(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "getMatrix");
        this.getMatrix = interfaceC0526Fp;
        this.isDirty = true;
        this.isInverseDirty = true;
        this.isInverseValid = true;
    }

    /* JADX INFO: renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m4498calculateInverseMatrixbWbORWo(T t) {
        float[] fArrM3237constructorimpl$default = this.inverseMatrixCache;
        if (fArrM3237constructorimpl$default == null) {
            fArrM3237constructorimpl$default = androidx.compose.ui.graphics.Matrix.m3237constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM3237constructorimpl$default;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m4496invertToJiSxe2E(m4499calculateMatrixGrdbGEg(t), fArrM3237constructorimpl$default);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArrM3237constructorimpl$default;
        }
        return null;
    }

    /* JADX INFO: renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m4499calculateMatrixGrdbGEg(T t) {
        float[] fArrM3237constructorimpl$default = this.matrixCache;
        if (fArrM3237constructorimpl$default == null) {
            fArrM3237constructorimpl$default = androidx.compose.ui.graphics.Matrix.m3237constructorimpl$default(null, 1, null);
            this.matrixCache = fArrM3237constructorimpl$default;
        }
        if (!this.isDirty) {
            return fArrM3237constructorimpl$default;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.mo13invoke(t, matrix);
        Matrix matrix2 = this.previousAndroidMatrix;
        if (matrix2 == null || !AbstractC4492zt.d(matrix, matrix2)) {
            AndroidMatrixConversions_androidKt.m2911setFromtUYjHk(fArrM3237constructorimpl$default, matrix);
            this.androidMatrixCache = matrix2;
            this.previousAndroidMatrix = matrix;
        }
        this.isDirty = false;
        return fArrM3237constructorimpl$default;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }
}
