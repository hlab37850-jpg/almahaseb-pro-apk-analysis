package defpackage;

/* JADX INFO: renamed from: mG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3380mG {
    public final String a;
    public final int b;

    public C3380mG(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static C3380mG a(String str) {
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char cCharAt = str.charAt(0);
        int i = 16;
        if (str.startsWith("0x") || str.startsWith("0X")) {
            str = str.substring(2);
        } else if (cCharAt == '#') {
            str = str.substring(1);
        } else if (cCharAt != '0' || str.length() <= 1) {
            i = 10;
        } else {
            str = str.substring(1);
            i = 8;
        }
        return new C3380mG(str, i);
    }
}
