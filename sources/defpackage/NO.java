package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class NO extends AbstractC1994d0 implements Set, Serializable, InterfaceC0947Tu {
    public static final a b = new a(null);
    public static final NO c = new NO(C3514nx.p.e());
    public final C3514nx a;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public NO(C3514nx c3514nx) {
        AbstractC4492zt.h(c3514nx, "backing");
        this.a = c3514nx;
    }

    public final Set a() {
        this.a.n();
        return size() > 0 ? this : c;
    }

    @Override // defpackage.AbstractC1994d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.a.l(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        this.a.o();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
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
        return this.a.F();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.a.O(obj);
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

    public NO() {
        this(new C3514nx());
    }
}
