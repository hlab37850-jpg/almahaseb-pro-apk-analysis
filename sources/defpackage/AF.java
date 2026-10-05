package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class AF extends AbstractC3215kF {
    public RectF a;
    public Matrix b;
    public float c;
    public float d;
    public float e;
    public float f;
    public String g;

    public AF(String str, Matrix matrix) {
        this.g = str;
        this.b = matrix;
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        this.c = fArr[2];
        this.d = fArr[5];
        this.e = fArr[0];
        this.f = fArr[4];
        float f = this.c;
        float f2 = this.d;
        this.a = new RectF(f, f2, this.e + f, this.f + f2);
    }

    @Override // defpackage.AbstractC3215kF
    public RectF a(JF jf) {
        return jf.n(this.g, this.a);
    }
}
