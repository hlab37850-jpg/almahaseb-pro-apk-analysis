package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: qx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3758qx extends AbstractC1189a0 implements Collection, InterfaceC0782Nu {
    public final C3514nx a;

    public C3758qx(C3514nx c3514nx) {
        AbstractC4492zt.h(c3514nx, "backing");
        this.a = c3514nx;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // defpackage.AbstractC1189a0
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.a.R();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.a.P(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        this.a.o();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        this.a.o();
        return super.retainAll(collection);
    }
}
