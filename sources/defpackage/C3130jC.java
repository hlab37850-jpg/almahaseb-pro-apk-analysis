package defpackage;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: jC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3130jC extends V implements RandomAccess {
    public final List a;
    public int b;
    public int c;

    public C3130jC(List list) {
        AbstractC4492zt.h(list, "list");
        this.a = list;
    }

    public final void a(int i, int i2) {
        V.Companion.d(i, i2, this.a.size());
        this.b = i;
        this.c = i2 - i;
    }

    @Override // defpackage.V, java.util.List
    public Object get(int i) {
        V.Companion.b(i, this.c);
        return this.a.get(this.b + i);
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.c;
    }
}
