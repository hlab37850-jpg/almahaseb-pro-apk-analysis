package defpackage;

/* JADX INFO: renamed from: Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0529Fs {
    public final int a;
    public final Object b;

    public C0529Fs(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0529Fs)) {
            return false;
        }
        C0529Fs c0529Fs = (C0529Fs) obj;
        return this.a == c0529Fs.a && AbstractC4492zt.d(this.b, c0529Fs.b);
    }

    public int hashCode() {
        int i = this.a * 31;
        Object obj = this.b;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
