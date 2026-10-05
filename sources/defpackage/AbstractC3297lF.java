package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: lF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3297lF {
    public static AbstractC3297lF a = new C3383mJ();
    public static AbstractC3297lF b = new C1854c9();
    public static AbstractC3297lF c = new C3383mJ();
    public static AbstractC3297lF d = new C0891Rq();

    public static AbstractC3297lF a(int i) {
        if (i == 0) {
            return d;
        }
        if (i == 1) {
            return a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        throw new IllegalArgumentException("Unknown Color Space name: " + i);
    }

    public static AbstractC3297lF b(BF bf, Map map) throws EF {
        AbstractC3297lF a2;
        BF bf2 = map != null ? (BF) map.get("ColorSpace") : null;
        if (bf.t() == 4) {
            String strS = bf.s();
            if (strS.equals("DeviceGray") || strS.equals("G")) {
                return a(0);
            }
            if (strS.equals("DeviceRGB") || strS.equals("RGB")) {
                return a(1);
            }
            if (strS.equals("DeviceCMYK") || strS.equals("CMYK")) {
                return a(2);
            }
            if (strS.equals("Pattern")) {
                return a(3);
            }
            if (bf2 != null) {
                bf = bf2.j(strS);
            }
        }
        if (bf == null) {
            return null;
        }
        if (bf.g() != null) {
            return (AbstractC3297lF) bf.g();
        }
        BF[] bfArrD = bf.d();
        String strS2 = bfArrD[0].s();
        if (strS2.equals("CalGray")) {
            a2 = d;
        } else if (strS2.equals("CalRGB") || strS2.equals("Lab") || strS2.equals("ICCBased")) {
            a2 = a;
        } else if (strS2.equals("Separation") || strS2.equals("DeviceN")) {
            a2 = new A2(b(bfArrD[2], map), AbstractC4191wF.e(bfArrD[3]));
        } else {
            if (!strS2.equals("Indexed") && !strS2.equals("I")) {
                if (strS2.equals("Pattern")) {
                    return a;
                }
                throw new EF("Unknown color space: " + strS2 + " with " + bfArrD[1]);
            }
            a2 = new C0429Ds(b(bfArrD[1], map), bfArrD[2].n(), bfArrD[3]);
        }
        bf.v(a2);
        return a2;
    }

    public DF c(float[] fArr) {
        return DF.c(h(fArr));
    }

    public abstract String d();

    public abstract int e();

    public DF f(float[] fArr) {
        return DF.b(h(fArr));
    }

    public abstract int g();

    public abstract int h(float[] fArr);

    public abstract int i(int[] iArr);

    public String toString() {
        return "ColorSpace[" + d() + "]";
    }
}
