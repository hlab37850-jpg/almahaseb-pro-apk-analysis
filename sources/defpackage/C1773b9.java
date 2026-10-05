package defpackage;

import android.graphics.Path;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1773b9 extends C3800rT {
    public Map l;
    public Map m;
    public int n;
    public int o;
    public T8 p;

    public C1773b9(String str, BF bf, C4029uF c4029uF) {
        super(str, bf, c4029uF);
        this.l = null;
        this.m = null;
        this.n = 1000;
        this.o = 1000;
        w(bf);
        bf.j("CIDSystemInfo");
        BF bfJ = bf.j("CIDToGIDMap");
        if (bfJ == null || bfJ.t() != 7) {
            return;
        }
        this.p = bfJ.r();
    }

    @Override // defpackage.AbstractC1214aF
    public int k() {
        return this.n;
    }

    @Override // defpackage.C3800rT, defpackage.AbstractC1214aF
    public synchronized Path n(char c, float f) {
        int iM;
        iM = c & 65535;
        try {
            T8 t8 = this.p;
            if (t8 != null) {
                iM = t8.m(iM * 2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return s(iM, f);
    }

    @Override // defpackage.AbstractC1214aF
    public float p(char c, String str) {
        Float f;
        Map map = this.l;
        if (map == null || (f = (Float) map.get(new Character(c))) == null) {
            return 1.0f;
        }
        return f.floatValue() / k();
    }

    public final void w(BF bf) {
        BF bfJ = bf.j("DW");
        if (bfJ != null) {
            this.n = bfJ.n();
        }
        BF bfJ2 = bf.j("W");
        if (bfJ2 != null) {
            this.l = new HashMap();
            BF[] bfArrD = bfJ2.d();
            int i = 0;
            int iN = 0;
            int iN2 = 0;
            for (int i2 = 0; i2 < bfArrD.length; i2++) {
                if (i == 0) {
                    iN = bfArrD[i2].n();
                } else {
                    if (i != 1) {
                        int iN3 = bfArrD[i2].n();
                        for (int i3 = iN; i3 <= iN2; i3++) {
                            this.l.put(new Character((char) i3), new Float(iN3));
                        }
                    } else if (bfArrD[i2].t() == 5) {
                        BF[] bfArrD2 = bfArrD[i2].d();
                        for (int i4 = 0; i4 < bfArrD2.length; i4++) {
                            this.l.put(new Character((char) (i4 + iN)), new Float(bfArrD2[i4].n()));
                        }
                    } else {
                        iN2 = bfArrD[i2].n();
                    }
                    i = -1;
                }
                i++;
            }
        }
        BF bfJ3 = bf.j("DW2");
        if (bfJ3 != null) {
            this.o = bfJ3.n();
        }
        BF bfJ4 = bf.j("W2");
        if (bfJ4 != null) {
            this.m = new HashMap();
            BF[] bfArrD3 = bfJ4.d();
            int i5 = 0;
            int iN4 = 0;
            int iN5 = 0;
            for (int i6 = 0; i6 < bfArrD3.length; i6++) {
                if (i5 == 0) {
                    iN4 = bfArrD3[i6].n();
                } else {
                    if (i5 != 1) {
                        int iN6 = bfArrD3[i6].n();
                        for (int i7 = iN4; i7 <= iN5; i7++) {
                            this.m.put(new Character((char) i7), new Float(iN6));
                        }
                    } else if (bfArrD3[i6].t() == 5) {
                        BF[] bfArrD4 = bfArrD3[i6].d();
                        for (int i8 = 0; i8 < bfArrD4.length; i8++) {
                            this.m.put(new Character((char) (i8 + iN4)), new Float(bfArrD4[i8].n()));
                        }
                    } else {
                        iN5 = bfArrD3[i6].n();
                    }
                    i5 = -1;
                }
                i5++;
            }
        }
    }
}
