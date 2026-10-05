package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class NQ implements Comparable {
    public final int a;
    public final int b;

    public NQ(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(NQ nq) {
        int i = this.b * this.a;
        int i2 = nq.b * nq.a;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public NQ b() {
        return new NQ(this.b, this.a);
    }

    public NQ c(NQ nq) {
        int i = this.a;
        int i2 = nq.b;
        int i3 = i * i2;
        int i4 = nq.a;
        int i5 = this.b;
        return i3 <= i4 * i5 ? new NQ(i4, (i5 * i4) / i) : new NQ((i * i2) / i5, i2);
    }

    public NQ d(NQ nq) {
        int i = this.a;
        int i2 = nq.b;
        int i3 = i * i2;
        int i4 = nq.a;
        int i5 = this.b;
        return i3 >= i4 * i5 ? new NQ(i4, (i5 * i4) / i) : new NQ((i * i2) / i5, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NQ nq = (NQ) obj;
        return this.a == nq.a && this.b == nq.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
