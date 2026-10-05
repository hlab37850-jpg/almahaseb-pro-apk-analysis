package defpackage;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: renamed from: oa0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3565oa0 extends AbstractCollection {
    public final /* synthetic */ V90 a;

    public C3565oa0(V90 v90) {
        this.a = v90;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.a.w();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.size();
    }
}
