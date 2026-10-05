package defpackage;

import android.graphics.Color;

/* JADX INFO: renamed from: mJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3383mJ extends AbstractC3297lF {
    @Override // defpackage.AbstractC3297lF
    public String d() {
        return "RGB";
    }

    @Override // defpackage.AbstractC3297lF
    public int e() {
        return 3;
    }

    @Override // defpackage.AbstractC3297lF
    public int g() {
        return 1;
    }

    @Override // defpackage.AbstractC3297lF
    public int h(float[] fArr) {
        return Color.rgb((int) (fArr[0] * 255.0f), (int) (fArr[1] * 255.0f), (int) (fArr[2] * 255.0f));
    }

    @Override // defpackage.AbstractC3297lF
    public int i(int[] iArr) {
        return Color.rgb(iArr[0], iArr[1], iArr[2]);
    }
}
