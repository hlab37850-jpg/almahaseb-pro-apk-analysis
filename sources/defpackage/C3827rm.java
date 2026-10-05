package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractC1954d;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: rm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3827rm extends AbstractC1954d implements InterfaceC3989tm {
    public final Multimap a;
    public final Predicate b;

    /* JADX INFO: renamed from: rm$a */
    public static class a extends ForwardingList {
        public final Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            add(0, obj);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            addAll(0, collection);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i, Object obj) {
            Preconditions.checkPositionIndex(i, 0);
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public boolean addAll(int i, Collection collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i, 0);
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public List delegate() {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: renamed from: rm$c */
    public class c extends ForwardingCollection {
        public c() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (C3827rm.this.a.containsKey(entry.getKey()) && C3827rm.this.b.apply(entry.getKey())) {
                return C3827rm.this.a.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection delegate() {
            return Collections2.filter(C3827rm.this.a.entries(), C3827rm.this.b());
        }
    }

    public C3827rm(Multimap multimap, Predicate predicate) {
        this.a = (Multimap) Preconditions.checkNotNull(multimap);
        this.b = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public Multimap a() {
        return this.a;
    }

    @Override // defpackage.InterfaceC3989tm
    public Predicate b() {
        return Maps.keyPredicateOnEntries(this.b);
    }

    public Collection c() {
        return this.a instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        if (this.a.containsKey(obj)) {
            return this.b.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Map createAsMap() {
        return Maps.filterKeys(this.a.asMap(), this.b);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection createEntries() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Set createKeySet() {
        return Sets.filter(this.a.keySet(), this.b);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Multiset createKeys() {
        return Multisets.filter(this.a.keys(), this.b);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection createValues() {
        return new C4070um(this);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Iterator entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        if (this.b.apply(obj)) {
            return this.a.get(obj);
        }
        return this.a instanceof SetMultimap ? new b(obj) : new a(obj);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection removeAll(Object obj) {
        return containsKey(obj) ? this.a.removeAll(obj) : c();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator it = asMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    /* JADX INFO: renamed from: rm$b */
    public static class b extends ForwardingSet {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Key does not satisfy predicate: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            return Collections.emptySet();
        }
    }
}
