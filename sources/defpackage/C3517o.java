package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3517o {
    public T8 a;

    public C3517o(T8 t8) {
        this.a = t8;
    }

    public static T8 b(T8 t8, BF bf) {
        return new C3517o(t8).a();
    }

    public final T8 a() {
        this.a.H();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (c(byteArrayOutputStream)) {
        }
        return T8.K(byteArrayOutputStream.toByteArray());
    }

    public final boolean c(ByteArrayOutputStream byteArrayOutputStream) throws EF {
        int[] iArr = new int[5];
        int i = 0;
        while (i < 5) {
            int iD = d();
            iArr[i] = iD;
            if (iD == 126) {
                if (d() == 62) {
                    break;
                }
                throw new EF("Bad character in ASCII85Decode: not ~>");
            }
            if (iD >= 33 && iD <= 117) {
                iArr[i] = iD - 33;
            } else {
                if (iD != 122) {
                    throw new EF("Bad character in ASCII85Decode: " + iArr[i] + " (" + ((char) iArr[i]) + ")");
                }
                if (i != 0) {
                    throw new EF("Inappropriate 'z' in ASCII85Decode");
                }
                iArr[i] = 0;
                i = 4;
            }
            i++;
        }
        if (i > 0) {
            i--;
        }
        int i2 = (iArr[0] * 52200625) + (iArr[1] * 614125) + (iArr[2] * 7225) + (iArr[3] * 85) + iArr[4];
        for (int i3 = 0; i3 < i; i3++) {
            byteArrayOutputStream.write((byte) ((i2 >> ((3 - i3) * 8)) & 255));
        }
        return i == 4;
    }

    public final int d() {
        while (this.a.F() > 0) {
            char cH = (char) this.a.h();
            if (!C3706qF.k(cH)) {
                return cH;
            }
        }
        return -1;
    }
}
