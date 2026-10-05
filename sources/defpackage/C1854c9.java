package defpackage;

import android.graphics.Color;

/* JADX INFO: renamed from: c9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1854c9 extends AbstractC3297lF {
    @Override // defpackage.AbstractC3297lF
    public String d() {
        return "CMYK";
    }

    @Override // defpackage.AbstractC3297lF
    public int e() {
        return 4;
    }

    @Override // defpackage.AbstractC3297lF
    public int g() {
        return 2;
    }

    @Override // defpackage.AbstractC3297lF
    public int h(float[] fArr) {
        float f = (1.0f - fArr[3]) * 255.0f;
        return Color.rgb((int) ((1.0f - fArr[0]) * f), (int) ((1.0f - fArr[1]) * f), (int) (f * (1.0f - fArr[2])));
    }

    @Override // defpackage.AbstractC3297lF
    public int i(int[] iArr) {
        int i = 255 - iArr[3];
        return Color.rgb(((255 - iArr[0]) * i) / 255, ((255 - iArr[1]) * i) / 255, (i * (255 - iArr[2])) / 255);
    }
}
