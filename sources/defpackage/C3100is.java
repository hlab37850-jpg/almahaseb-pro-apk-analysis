package defpackage;

import android.graphics.RectF;

/* JADX INFO: renamed from: is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3100is {
    public int a;
    public int b;
    public RectF c;
    public int d;

    public C3100is(int i, int i2, RectF rectF, int i3) {
        this.a = i;
        this.b = i2;
        this.c = rectF;
        this.d = i3;
    }

    public boolean equals(Object obj) {
        RectF rectF;
        if (!(obj instanceof C3100is)) {
            return false;
        }
        C3100is c3100is = (C3100is) obj;
        if (this.a == c3100is.a && this.b == c3100is.b) {
            RectF rectF2 = this.c;
            if (rectF2 != null && (rectF = c3100is.c) != null) {
                return rectF2.equals(rectF);
            }
            if (rectF2 == null && c3100is.c == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.a ^ (this.b << 16);
        RectF rectF = this.c;
        if (rectF == null) {
            return i;
        }
        int iWidth = i ^ ((((int) rectF.width()) | ((int) this.c.height())) << 8);
        RectF rectF2 = this.c;
        return iWidth ^ (((int) rectF2.top) | ((int) rectF2.left));
    }
}
