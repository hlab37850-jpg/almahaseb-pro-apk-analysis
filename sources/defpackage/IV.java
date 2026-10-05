package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class IV extends AbstractC3948tF {
    public AbstractC3948tF[] g;

    public IV(String str, BF bf, C4029uF c4029uF) {
        super(str, c4029uF);
        BF[] bfArrD = bf.j("DescendantFonts").d();
        this.g = new AbstractC3948tF[bfArrD.length];
        for (int i = 0; i < bfArrD.length; i++) {
            this.g[i] = AbstractC3948tF.d(bfArrD[i], null);
        }
    }

    @Override // defpackage.AbstractC3948tF
    public C4272xF e(char c, String str) {
        return k(0).e(c, str);
    }

    public AbstractC3948tF k(int i) {
        return this.g[i];
    }
}
