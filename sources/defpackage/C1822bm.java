package defpackage;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import java.util.Objects;

/* JADX INFO: renamed from: bm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1822bm {
    public final DataCharacter a;
    public final DataCharacter b;
    public final FinderPattern c;

    public C1822bm(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern) {
        this.a = dataCharacter;
        this.b = dataCharacter2;
        this.c = finderPattern;
    }

    public FinderPattern a() {
        return this.c;
    }

    public DataCharacter b() {
        return this.a;
    }

    public DataCharacter c() {
        return this.b;
    }

    public boolean d() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1822bm)) {
            return false;
        }
        C1822bm c1822bm = (C1822bm) obj;
        return Objects.equals(this.a, c1822bm.a) && Objects.equals(this.b, c1822bm.b) && Objects.equals(this.c, c1822bm.c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.a) ^ Objects.hashCode(this.b)) ^ Objects.hashCode(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        FinderPattern finderPattern = this.c;
        sb.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.getValue()));
        sb.append(" ]");
        return sb.toString();
    }
}
