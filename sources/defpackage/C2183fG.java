package defpackage;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* JADX INFO: renamed from: fG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2183fG extends DataCharacter {
    public final FinderPattern a;
    public int b;

    public C2183fG(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.a = finderPattern;
    }

    public int a() {
        return this.b;
    }

    public FinderPattern b() {
        return this.a;
    }

    public void c() {
        this.b++;
    }
}
