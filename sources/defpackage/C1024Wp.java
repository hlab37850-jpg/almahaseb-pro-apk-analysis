package defpackage;

/* JADX INFO: renamed from: Wp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1024Wp extends AbstractC4191wF {
    public C1024Wp() {
        super(3);
    }

    @Override // defpackage.AbstractC4191wF
    public void c(float[] fArr, int i, float[] fArr2, int i2) {
        float[] fArr3 = new float[f()];
        for (int i3 = 0; i3 < g(); i3++) {
        }
    }

    @Override // defpackage.AbstractC4191wF
    public void i(BF bf) throws EF {
        BF bfJ = bf.j("Functions");
        if (bfJ == null) {
            throw new EF("Functions required for function type 3!");
        }
        BF[] bfArrD = bfJ.d();
        int[] iArr = new int[bfArrD.length];
        for (int i = 0; i < bfArrD.length; i++) {
            iArr[i] = bfArrD[i].n();
        }
        BF bfJ2 = bf.j("Bounds");
        if (bfJ2 == null) {
            throw new EF("Bounds required for function type 3!");
        }
        BF[] bfArrD2 = bfJ2.d();
        int[] iArr2 = new int[bfArrD2.length];
        for (int i2 = 0; i2 < bfArrD2.length; i2++) {
            iArr2[i2] = bfArrD2[i2].n();
        }
        BF bfJ3 = bf.j("Encode");
        if (bfJ3 != null) {
            throw new EF("Encode required for function type 3!");
        }
        BF[] bfArrD3 = bfJ3.d();
        float[] fArr = new float[bfArrD3.length];
        for (int i3 = 0; i3 < bfArrD3.length; i3++) {
            fArr[i3] = bfArrD3[i3].m();
        }
        throw new EF("Unsupported function type 3.");
    }
}
