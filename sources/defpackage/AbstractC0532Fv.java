package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: renamed from: Fv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0532Fv {
    public StringBuilder a = new StringBuilder();
    public boolean b;

    /* JADX WARN: Code duplicated, block: B:12:0x001a  */
    public void a(char[] cArr, int i, int i2) {
        int i3;
        if (!this.b || i2 <= 0) {
            i3 = i;
        } else {
            if (c(cArr[i] == '\n')) {
                i3 = i + 1;
            } else {
                i3 = i;
            }
        }
        int i4 = i + i2;
        int i5 = i3;
        while (i3 < i4) {
            char c = cArr[i3];
            if (c != '\n') {
                if (c == '\r') {
                    this.a.append(cArr, i5, i3 - i5);
                    this.b = true;
                    int i6 = i3 + 1;
                    if (i6 < i4) {
                        if (c(cArr[i6] == '\n')) {
                            i3 = i6;
                        }
                    }
                }
                i3++;
            } else {
                this.a.append(cArr, i5, i3 - i5);
                c(true);
            }
            i5 = i3 + 1;
            i3++;
        }
        this.a.append(cArr, i5, i4 - i5);
    }

    public void b() {
        if (this.b || this.a.length() > 0) {
            c(false);
        }
    }

    public final boolean c(boolean z) {
        String str;
        if (this.b) {
            str = z ? StringUtilities.CRLF : "\r";
        } else {
            str = z ? StringUtilities.LF : "";
        }
        d(this.a.toString(), str);
        this.a = new StringBuilder();
        this.b = false;
        return z;
    }

    public abstract void d(String str, String str2);
}
