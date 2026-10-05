package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3596ox extends X {
    public final C3514nx a;

    public C3596ox(C3514nx c3514nx) {
        AbstractC4492zt.h(c3514nx, "backing");
        this.a = c3514nx;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        return this.a.q(collection);
    }

    @Override // defpackage.X
    public boolean containsEntry(Map.Entry entry) {
        AbstractC4492zt.h(entry, "element");
        return this.a.r(entry);
    }

    @Override // defpackage.AbstractC1994d0
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.a.v();
    }

    @Override // defpackage.X
    public boolean remove(Map.Entry entry) {
        AbstractC4492zt.h(entry, "element");
        return this.a.L(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        this.a.o();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        this.a.o();
        return super.retainAll(collection);
    }

    @Override // defpackage.AbstractC1994d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry entry) {
        AbstractC4492zt.h(entry, "element");
        throw new UnsupportedOperationException();
    }
}
