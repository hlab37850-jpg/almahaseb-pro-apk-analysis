package defpackage;

/* JADX INFO: renamed from: Br, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0376Br {
    public static final C0376Br a = new C0376Br();
    public static final W8 b = W8.d.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] d = new String[64];
    public static final String[] e;

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            AbstractC4492zt.g(binaryString, "toBinaryString(it)");
            strArr[i] = AbstractC3880sS.w(AbstractC3724qX.t("%8s", binaryString), ' ', '0', false, 4, null);
        }
        e = strArr;
        String[] strArr2 = d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = strArr2[i2] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = d;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + '|' + strArr3[i4] + "|PADDED";
        }
        int length = d.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = d;
            if (strArr4[i7] == null) {
                strArr4[i7] = e[i7];
            }
        }
    }

    public final String a(int i, int i2) {
        String str;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i == 4 || i == 6) {
                return i2 == 1 ? "ACK" : e[i2];
            }
            if (i != 7 && i != 8) {
                String[] strArr = d;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    AbstractC4492zt.e(str);
                } else {
                    str = e[i2];
                }
                String str2 = str;
                if (i != 5 || (i2 & 4) == 0) {
                    return (i != 0 || (i2 & 32) == 0) ? str2 : AbstractC3880sS.x(str2, "PRIORITY", "COMPRESSED", false, 4, null);
                }
                return AbstractC3880sS.x(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return e[i2];
    }

    public final String b(int i) {
        String[] strArr = c;
        return i < strArr.length ? strArr[i] : AbstractC3724qX.t("0x%02x", Integer.valueOf(i));
    }

    public final String c(boolean z, int i, int i2, int i3, int i4) {
        return AbstractC3724qX.t("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), b(i3), a(i3, i4));
    }
}
