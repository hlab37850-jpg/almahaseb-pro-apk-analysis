package defpackage;

/* JADX INFO: renamed from: mF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3379mF {
    public static T8 a(BF bf, T8 t8) {
        BF[] bfArrD;
        BF[] bfArrD2;
        BF bfJ;
        BF bfJ2 = bf.j("Filter");
        if (bfJ2 == null) {
            return bf.h().a(null, bf, t8);
        }
        if (bfJ2.t() == 4) {
            bfArrD = new BF[]{bfJ2};
            bfArrD2 = new BF[]{bf.j("DecodeParms")};
        } else {
            bfArrD = bfJ2.d();
            BF bfJ3 = bf.j("DecodeParms");
            bfArrD2 = bfJ3 != null ? bfJ3.d() : new BF[bfArrD.length];
        }
        if (bfArrD.length == 0 || !bfArrD[0].s().equals("Crypt")) {
            t8 = bf.h().a(null, bf, t8);
        }
        for (int i = 0; i < bfArrD.length; i++) {
            String strS = bfArrD[i].s();
            if (strS != null) {
                if (strS.equals("FlateDecode") || strS.equals("Fl")) {
                    t8 = AbstractC0697Km.a(bf, t8, bfArrD2[i]);
                } else if (strS.equals("LZWDecode") || strS.equals("LZW")) {
                    t8 = C2069dv.b(t8, bfArrD2[i]);
                } else if (strS.equals("ASCII85Decode") || strS.equals("A85")) {
                    t8 = C3517o.b(t8, bfArrD2[i]);
                } else if (strS.equals("ASCIIHexDecode") || strS.equals("AHx")) {
                    t8 = C3680q.b(t8, bfArrD2[i]);
                } else if (strS.equals("RunLengthDecode") || strS.equals("RL")) {
                    t8 = C4117vM.b(t8, bfArrD2[i]);
                } else if (strS.equals("DCTDecode") || strS.equals("DCT")) {
                    t8 = AbstractC2381hh.a(bf, t8, bfArrD2[i]);
                } else if (strS.equals("CCITTFaxDecode") || strS.equals("CCF")) {
                    t8 = Z8.a(bf, t8, bfArrD2[i]);
                } else {
                    if (!strS.equals("Crypt")) {
                        throw new EF("Unknown coding method:" + bfArrD[i].s());
                    }
                    BF bf2 = bfArrD2[i];
                    t8 = bf.h().a((bf2 == null || (bfJ = bf2.j("Name")) == null || bfJ.t() != 4) ? "Identity" : bfJ.s(), null, t8);
                }
            }
        }
        return t8;
    }
}
