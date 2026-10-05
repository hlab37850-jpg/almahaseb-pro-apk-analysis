package defpackage;

import com.google.zxing.FormatException;

/* JADX INFO: renamed from: wi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4228wi extends AbstractC4309xi {
    public final int b;
    public final int c;

    public C4228wi(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.b = i2;
        this.c = i3;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.b == 10;
    }

    public boolean e() {
        return this.c == 10;
    }
}
