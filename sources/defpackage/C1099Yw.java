package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: Yw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1099Yw extends DS implements Serializable, InterfaceC0979Uw {
    @Override // defpackage.InterfaceC0979Uw
    public void a() {
        add(1L);
    }

    @Override // defpackage.InterfaceC0979Uw
    public void add(long j) {
        int length;
        DS.b bVar;
        DS.b[] bVarArr = this.a;
        if (bVarArr == null) {
            long j2 = this.b;
            if (e(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = (int[]) DS.d.get();
        boolean zA = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = bVar.a;
            zA = bVar.a(j3, j3 + j);
            if (zA) {
                return;
            }
        }
        j(j, iArr, zA);
    }

    @Override // defpackage.InterfaceC0979Uw
    public long b() {
        long j = this.b;
        DS.b[] bVarArr = this.a;
        if (bVarArr != null) {
            for (DS.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.a;
                }
            }
        }
        return j;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return b();
    }

    @Override // defpackage.DS
    public final long h(long j, long j2) {
        return j + j2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) b();
    }

    @Override // java.lang.Number
    public long longValue() {
        return b();
    }

    public String toString() {
        return Long.toString(b());
    }
}
