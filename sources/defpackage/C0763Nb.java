package defpackage;

/* JADX INFO: renamed from: Nb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0763Nb implements InterfaceC0789Ob {
    public final float a;
    public final float b;

    public C0763Nb(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC0789Ob
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return e(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean b(float f) {
        return f >= this.a && f <= this.b;
    }

    @Override // defpackage.InterfaceC0815Pb
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC0789Ob
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // defpackage.InterfaceC0815Pb
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.a);
    }

    public boolean e(float f, float f2) {
        return f <= f2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0763Nb) {
            if (!isEmpty() || !((C0763Nb) obj).isEmpty()) {
                C0763Nb c0763Nb = (C0763Nb) obj;
                if (this.a != c0763Nb.a || this.b != c0763Nb.b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    @Override // defpackage.InterfaceC0789Ob, defpackage.InterfaceC0815Pb
    public boolean isEmpty() {
        return this.a > this.b;
    }

    public String toString() {
        return this.a + ".." + this.b;
    }
}
