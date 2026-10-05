package defpackage;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: oF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3543oF {
    public static InterfaceC3461nF a(BF bf, BF bf2, GF gf, int i) throws C3338ll, EF {
        Object objC;
        BF bfJ = bf.j("EncryptMetadata");
        boolean zF = true;
        if (bfJ != null && bfJ.t() == 1) {
            zF = bfJ.f();
        }
        HashMap map = new HashMap();
        BF bfJ2 = bf.j("CF");
        if (bfJ2 == null) {
            throw new EF("No CF value present in Encrypt dict for V4 encryption");
        }
        Iterator itI = bfJ2.i();
        while (itI.hasNext()) {
            String str = (String) itI.next();
            BF bfJ3 = bfJ2.j(str);
            BF bfJ4 = bfJ3.j("Length");
            Integer numValueOf = bfJ4 != null ? Integer.valueOf(bfJ4.n() * 8) : null;
            BF bfJ5 = bfJ3.j("CFM");
            String strS = bfJ5 != null ? bfJ5.s() : "None";
            if ("None".equals(strS)) {
                objC = C2066ds.d();
            } else if ("V2".equals(strS)) {
                objC = c(bf, bf2, gf, numValueOf, zF, C4284xR.a.RC4);
            } else {
                if (!"AESV2".equals(strS)) {
                    throw new UnsupportedOperationException("Unknown CryptFilter method: " + strS);
                }
                objC = c(bf, bf2, gf, numValueOf, zF, C4284xR.a.AESV2);
            }
            map.put(str, objC);
        }
        map.put("Identity", C2066ds.d());
        BF bfJ6 = bf.j("StmF");
        String strS2 = bfJ6 != null ? bfJ6.s() : "Identity";
        BF bfJ7 = bf.j("StrF");
        return new C3494ng(map, strS2, bfJ7 != null ? bfJ7.s() : "Identity");
    }

    public static InterfaceC3461nF b(BF bf, BF bf2, GF gf) {
        GF gfD = GF.d(gf);
        if (bf == null) {
            return C2066ds.d();
        }
        BF bfJ = bf.j("Filter");
        if (bfJ == null || !"Standard".equals(bfJ.s())) {
            if (bfJ == null) {
                throw new EF("No Filter specified in Encrypt dictionary");
            }
            throw new C3338ll("Unsupported encryption Filter: " + bfJ + "; only Standard is supported.");
        }
        BF bfJ2 = bf.j("V");
        int iN = bfJ2 != null ? bfJ2.n() : 0;
        if (iN == 1 || iN == 2) {
            BF bfJ3 = bf.j("Length");
            return c(bf, bf2, gfD, bfJ3 != null ? Integer.valueOf(bfJ3.n()) : null, false, C4284xR.a.RC4);
        }
        if (iN == 4) {
            return a(bf, bf2, gfD, iN);
        }
        throw new C3338ll("Unsupported encryption version: " + iN);
    }

    public static InterfaceC3461nF c(BF bf, BF bf2, GF gf, Integer num, boolean z, C4284xR.a aVar) throws C3338ll, EF {
        Integer num2 = num == null ? 40 : num;
        BF bfJ = bf.j("R");
        if (bfJ == null) {
            throw new EF("No R entry present in Encrypt dictionary");
        }
        int iN = bfJ.n();
        if (iN < 2 || iN > 4) {
            throw new C3338ll("Unsupported Standard security handler revision; R=" + iN);
        }
        BF bfJ2 = bf.j("O");
        if (bfJ2 == null) {
            throw new EF("No O entry present in Encrypt dictionary");
        }
        byte[] bArrQ = bfJ2.q();
        if (bArrQ.length != 32) {
            throw new EF("Expected owner key O value of 32 bytes; found " + bArrQ.length);
        }
        BF bfJ3 = bf.j("U");
        if (bfJ3 == null) {
            throw new EF("No U entry present in Encrypt dictionary");
        }
        byte[] bArrQ2 = bfJ3.q();
        if (bArrQ2.length != 32) {
            throw new EF("Expected user key U value of 32 bytes; found " + bArrQ.length);
        }
        BF bfJ4 = bf.j("P");
        if (bfJ4 != null) {
            return new C4284xR(aVar, bf2, num2.intValue(), iN, bArrQ, bArrQ2, bfJ4.n(), z, gf);
        }
        throw new EF("Required P entry in Encrypt dictionary not found");
    }
}
