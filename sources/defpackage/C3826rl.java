package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: rl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3826rl extends V implements InterfaceC3665pl, Serializable {
    public final Enum[] a;

    public C3826rl(Enum[] enumArr) {
        AbstractC4492zt.h(enumArr, "entries");
        this.a = enumArr;
    }

    public boolean a(Enum r3) {
        AbstractC4492zt.h(r3, "element");
        return ((Enum) R5.Q(this.a, r3.ordinal())) == r3;
    }

    @Override // defpackage.V, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Enum get(int i) {
        V.Companion.b(i, this.a.length);
        return this.a[i];
    }

    public int c(Enum r3) {
        AbstractC4492zt.h(r3, "element");
        int iOrdinal = r3.ordinal();
        if (((Enum) R5.Q(this.a, iOrdinal)) == r3) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // defpackage.D, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return a((Enum) obj);
        }
        return false;
    }

    public int e(Enum r2) {
        AbstractC4492zt.h(r2, "element");
        return indexOf(r2);
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.a.length;
    }

    @Override // defpackage.V, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return c((Enum) obj);
        }
        return -1;
    }

    @Override // defpackage.V, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return -1;
    }
}
