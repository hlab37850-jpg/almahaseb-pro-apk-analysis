package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.Graphs;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K implements InterfaceC3459nD {
    public final Map a;
    public final Map b;
    public int c;

    public class a extends AbstractSet {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return Iterators.unmodifiableIterator((K.this.c == 0 ? Iterables.concat(K.this.a.keySet(), K.this.b.keySet()) : Sets.union(K.this.a.keySet(), K.this.b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return K.this.a.containsKey(obj) || K.this.b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.saturatedAdd(K.this.a.size(), K.this.b.size() - K.this.c);
        }
    }

    public K(Map map, Map map2, int i) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = (Map) Preconditions.checkNotNull(map2);
        this.c = Graphs.checkNonNegative(i);
        Preconditions.checkState(i <= map.size() && i <= map2.size());
    }

    @Override // defpackage.InterfaceC3459nD
    public Set a() {
        return Sets.union(c(), b());
    }

    @Override // defpackage.InterfaceC3459nD
    public Object d(Object obj, boolean z) {
        if (z) {
            int i = this.c - 1;
            this.c = i;
            Graphs.checkNonNegative(i);
        }
        Object objRemove = this.a.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // defpackage.InterfaceC3459nD
    public Set e() {
        return new a();
    }

    @Override // defpackage.InterfaceC3459nD
    public Object f(Object obj) {
        Object obj2 = this.b.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // defpackage.InterfaceC3459nD
    public Set g() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // defpackage.InterfaceC3459nD
    public Object h(Object obj) {
        Object objRemove = this.b.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // defpackage.InterfaceC3459nD
    public Set i() {
        return Collections.unmodifiableSet(this.b.keySet());
    }

    @Override // defpackage.InterfaceC3459nD
    public void j(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Preconditions.checkState(this.b.put(obj, obj2) == null);
    }

    @Override // defpackage.InterfaceC3459nD
    public void l(Object obj, Object obj2, boolean z) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        if (z) {
            int i = this.c + 1;
            this.c = i;
            Graphs.checkPositive(i);
        }
        Preconditions.checkState(this.a.put(obj, obj2) == null);
    }
}
