package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DH {
    public int a;
    public int b = 1;
    public int c = 8;
    public int d = 1;

    public DH(int i) {
        this.a = i;
    }

    public static DH d(BF bf) throws EF {
        int iN;
        BF bfJ = bf.j("Predictor");
        if (bfJ == null || (iN = bfJ.n()) == 1) {
            return null;
        }
        if (iN == 2) {
            throw new EF("Tiff Predictor not supported");
        }
        switch (iN) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                RF rf = new RF();
                BF bfJ2 = bf.j("Colors");
                if (bfJ2 != null) {
                    rf.f(bfJ2.n());
                }
                BF bfJ3 = bf.j("BitsPerComponent");
                if (bfJ3 != null) {
                    rf.e(bfJ3.n());
                }
                BF bfJ4 = bf.j("Columns");
                if (bfJ4 != null) {
                    rf.g(bfJ4.n());
                }
                return rf;
            default:
                throw new EF("Unknown predictor: " + iN);
        }
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public void e(int i) {
        this.c = i;
    }

    public void f(int i) {
        this.b = i;
    }

    public void g(int i) {
        this.d = i;
    }

    public abstract T8 h(T8 t8);
}
