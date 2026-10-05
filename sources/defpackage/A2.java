package defpackage;

import android.graphics.Color;

/* JADX INFO: loaded from: classes3.dex */
public class A2 extends AbstractC3297lF {
    public AbstractC3297lF e;
    public AbstractC4191wF f;

    public A2(AbstractC3297lF abstractC3297lF, AbstractC4191wF abstractC4191wF) {
        this.e = abstractC3297lF;
        this.f = abstractC4191wF;
    }

    @Override // defpackage.AbstractC3297lF
    public String d() {
        return "ALTERNATE";
    }

    @Override // defpackage.AbstractC3297lF
    public int e() {
        AbstractC4191wF abstractC4191wF = this.f;
        return abstractC4191wF != null ? abstractC4191wF.f() : this.e.e();
    }

    @Override // defpackage.AbstractC3297lF
    public int g() {
        return 5;
    }

    @Override // defpackage.AbstractC3297lF
    public int h(float[] fArr) {
        AbstractC4191wF abstractC4191wF = this.f;
        if (abstractC4191wF != null) {
            fArr = abstractC4191wF.a(fArr);
        }
        float f = (1.0f - fArr[3]) * 255.0f;
        return Color.rgb((int) ((1.0f - fArr[0]) * f), (int) ((1.0f - fArr[1]) * f), (int) (f * (1.0f - fArr[2])));
    }

    @Override // defpackage.AbstractC3297lF
    public int i(int[] iArr) {
        int length = iArr.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = iArr[i] / 255;
        }
        return h(fArr);
    }
}
