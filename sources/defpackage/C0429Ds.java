package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: renamed from: Ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0429Ds extends AbstractC3297lF {
    public int[] e;
    public int f;

    public C0429Ds(AbstractC3297lF abstractC3297lF, int i, BF bf) {
        int i2 = i + 1;
        this.f = i2;
        byte[] bArrQ = bf.q();
        int iE = abstractC3297lF.e();
        int length = bArrQ.length / iE;
        this.e = new int[i2];
        float[] fArr = new float[iE];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < iE; i5++) {
                if (i3 < bArrQ.length) {
                    fArr[i5] = (bArrQ[i3] & UnsignedBytes.MAX_VALUE) / 255.0f;
                    i3++;
                } else {
                    fArr[i5] = 1.0f;
                }
            }
            this.e[i4] = abstractC3297lF.h(fArr);
        }
    }

    @Override // defpackage.AbstractC3297lF
    public String d() {
        return "I";
    }

    @Override // defpackage.AbstractC3297lF
    public int e() {
        return 1;
    }

    @Override // defpackage.AbstractC3297lF
    public int g() {
        return 4;
    }

    @Override // defpackage.AbstractC3297lF
    public int h(float[] fArr) {
        return this.e[(int) (fArr[0] * 255.0f)];
    }

    @Override // defpackage.AbstractC3297lF
    public int i(int[] iArr) {
        return this.e[iArr[0]];
    }
}
