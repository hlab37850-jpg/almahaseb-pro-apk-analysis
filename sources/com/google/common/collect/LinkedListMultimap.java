package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC2444iV;
import defpackage.BG;
import defpackage.C0817Pd;
import defpackage.Y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends AbstractC1954d implements ListMultimap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient g head;
    private transient Map<K, f> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g tail;

    public class a extends AbstractSequentialList {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return new i(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.a);
            if (fVar == null) {
                return 0;
            }
            return fVar.c;
        }
    }

    public class b extends AbstractSequentialList {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return new h(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public class c extends Sets.k {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    public class d extends AbstractSequentialList {

        public class a extends AbstractC2444iV {
            public final /* synthetic */ h b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.b = hVar;
            }

            @Override // defpackage.AbstractC2362hV
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object a(Map.Entry entry) {
                return entry.getValue();
            }

            @Override // defpackage.AbstractC2444iV, java.util.ListIterator
            public void set(Object obj) {
                this.b.f(obj);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            h hVar = new h(i);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    public static class f {
        public g a;
        public g b;
        public int c;

        public f(g gVar) {
            this.a = gVar;
            this.b = gVar;
            gVar.f = null;
            gVar.e = null;
            this.c = 1;
        }
    }

    public static final class g extends Y {
        public final Object a;
        public Object b;
        public g c;
        public g d;
        public g e;
        public g f;

        public g(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }
    }

    public class h implements ListIterator {
        public int a;
        public g b;
        public g c;
        public g d;
        public int e;

        public h(int i) {
            this.e = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i, size);
            if (i < size / 2) {
                this.b = LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.d = LinkedListMultimap.this.tail;
                this.a = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.c = null;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g next() {
            b();
            g gVar = this.b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.c = gVar;
            this.d = gVar;
            this.b = gVar.c;
            this.a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g previous() {
            b();
            g gVar = this.d;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.c = gVar;
            this.b = gVar;
            this.d = gVar.d;
            this.a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public void f(Object obj) {
            Preconditions.checkState(this.c != null);
            this.c.b = obj;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            Preconditions.checkState(this.c != null, "no calls to next() since the last call to remove()");
            g gVar = this.c;
            if (gVar != this.b) {
                this.d = gVar.d;
                this.a--;
            } else {
                this.b = gVar.c;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.c = null;
            this.e = LinkedListMultimap.this.modCount;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public g addNode(K k, V v, g gVar) {
        g gVar2 = new g(k, v);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k, new f(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g gVar3 = this.tail;
            Objects.requireNonNull(gVar3);
            gVar3.c = gVar2;
            gVar2.d = this.tail;
            this.tail = gVar2;
            f fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f(gVar2));
                this.modCount++;
            } else {
                fVar.c++;
                g gVar4 = fVar.b;
                gVar4.e = gVar2;
                gVar2.f = gVar4;
                fVar.b = gVar2;
            }
        } else {
            f fVar2 = this.keyToKeyList.get(k);
            Objects.requireNonNull(fVar2);
            fVar2.c++;
            gVar2.d = gVar.d;
            gVar2.f = gVar.f;
            gVar2.c = gVar;
            gVar2.e = gVar;
            g gVar5 = gVar.f;
            if (gVar5 == null) {
                fVar2.a = gVar2;
            } else {
                gVar5.e = gVar2;
            }
            g gVar6 = gVar.d;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.c = gVar2;
            }
            gVar.d = gVar2;
            gVar.f = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(K k) {
        return Collections.unmodifiableList(Lists.newArrayList(new i(k)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = C0817Pd.c0();
        int i2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(K k) {
        Iterators.clear(new i(k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g gVar) {
        g gVar2 = gVar.d;
        if (gVar2 != null) {
            gVar2.c = gVar.c;
        } else {
            this.head = gVar.c;
        }
        g gVar3 = gVar.c;
        if (gVar3 != null) {
            gVar3.d = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f == null && gVar.e == null) {
            f fVarRemove = this.keyToKeyList.remove(gVar.a);
            Objects.requireNonNull(fVarRemove);
            fVarRemove.c = 0;
            this.modCount++;
        } else {
            f fVar = this.keyToKeyList.get(gVar.a);
            Objects.requireNonNull(fVar);
            fVar.c--;
            g gVar4 = gVar.f;
            if (gVar4 == null) {
                g gVar5 = gVar.e;
                Objects.requireNonNull(gVar5);
                fVar.a = gVar5;
            } else {
                gVar4.e = gVar.e;
            }
            g gVar6 = gVar.e;
            if (gVar6 == null) {
                g gVar7 = gVar.f;
                Objects.requireNonNull(gVar7);
                fVar.b = gVar7;
            } else {
                gVar6.f = gVar.f;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Multiset<K> createKeys() {
        return new Multimaps.g(this);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractC1954d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i2) {
        this.keyToKeyList = BG.c(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public List<V> get(K k) {
        return new a(k);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        i iVar = new i(k);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    public class e implements Iterator {
        public final Set a;
        public g b;
        public g c;
        public int d;

        public e() {
            this.a = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.b = LinkedListMultimap.this.head;
            this.d = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            g gVar;
            a();
            g gVar2 = this.b;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.c = gVar2;
            this.a.add(gVar2.a);
            do {
                gVar = this.b.c;
                this.b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.a.add(gVar.a));
            return this.c.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            Preconditions.checkState(this.c != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.c.a);
            this.c = null;
            this.d = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    public class i implements ListIterator {
        public final Object a;
        public int b;
        public g c;
        public g d;
        public g e;

        public i(Object obj) {
            this.a = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.c = fVar == null ? null : fVar.a;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.e = LinkedListMultimap.this.addNode(this.a, obj, this.c);
            this.b++;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            g gVar = this.c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.d = gVar;
            this.e = gVar;
            this.c = gVar.e;
            this.b++;
            return gVar.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            g gVar = this.e;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.d = gVar;
            this.c = gVar;
            this.e = gVar.f;
            this.b--;
            return gVar.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.d != null, "no calls to next() since the last call to remove()");
            g gVar = this.d;
            if (gVar != this.c) {
                this.e = gVar.f;
                this.b--;
            } else {
                this.c = gVar.e;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            Preconditions.checkState(this.d != null);
            this.d.b = obj;
        }

        public i(Object obj, int i) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = fVar == null ? 0 : fVar.c;
            Preconditions.checkPositionIndex(i, i2);
            if (i >= i2 / 2) {
                this.e = fVar == null ? null : fVar.b;
                this.b = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.c = fVar == null ? null : fVar.a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.a = obj;
            this.d = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
