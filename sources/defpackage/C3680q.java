package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3680q {
    public T8 a;

    public C3680q(T8 t8) {
        this.a = t8;
    }

    public static T8 b(T8 t8, BF bf) {
        return new C3680q(t8).a();
    }

    public final T8 a() throws EF {
        this.a.H();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int iC = c();
            int iC2 = c();
            if (iC == -1) {
                break;
            }
            if (iC2 == -1) {
                byteArrayOutputStream.write((byte) (iC << 4));
                break;
            }
            byteArrayOutputStream.write((byte) ((iC << 4) + iC2));
        }
        return T8.K(byteArrayOutputStream.toByteArray());
    }

    public final int c() throws EF {
        while (this.a.F() > 0) {
            byte bH = this.a.h();
            if (!C3706qF.k((char) bH)) {
                if (bH >= 48 && bH <= 57) {
                    return bH - 48;
                }
                if (bH >= 97 && bH <= 102) {
                    return bH - 87;
                }
                if (bH >= 65 && bH <= 70) {
                    return bH - 55;
                }
                if (bH == 62) {
                    return -1;
                }
                throw new EF("Bad character " + ((int) bH) + "in ASCIIHex decode");
            }
        }
        throw new EF("Short stream in ASCIIHex decode");
    }
}
