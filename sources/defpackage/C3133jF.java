package defpackage;

import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: renamed from: jF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3133jF extends AbstractC3215kF {
    public float a = -1000.0f;
    public Paint.Cap d = JF.v;
    public Paint.Join e = JF.x;
    public float b = -1000.0f;
    public float[] f = JF.w;
    public float c = -1000.0f;

    @Override // defpackage.AbstractC3215kF
    public RectF a(JF jf) {
        jf.y(this.a, this.d, this.e, this.b, this.f, this.c);
        return null;
    }

    public void b(float[] fArr, float f) {
        if (fArr != null) {
            for (int i = 0; i < fArr.length - 1; i += 2) {
                if (fArr[i] == 0.0f) {
                    fArr[i] = 1.0E-5f;
                    break;
                }
            }
        }
        this.f = fArr;
        this.c = f;
    }

    public void c(Paint.Cap cap) {
        this.d = cap;
    }

    public void d(Paint.Join join) {
        this.e = join;
    }

    public void e(float f) {
        this.b = f;
    }

    public void f(float f) {
        this.a = f;
    }
}
