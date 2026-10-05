package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class PF extends AbstractC3215kF {
    public Matrix a;

    public PF(Matrix matrix) {
        if (matrix == null) {
            throw new RuntimeException("Null transform in PDFXformCmd");
        }
        this.a = matrix;
    }

    @Override // defpackage.AbstractC3215kF
    public RectF a(JF jf) {
        jf.C(this.a);
        return null;
    }
}
