package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC0558Gv;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC3590or;
import defpackage.BG;
import defpackage.C3427ms;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends AbstractC0558Gv {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;

    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private transient b multimapHeaderEntry;

    @VisibleForTesting
    transient int valueSetCapacity;

    public class a implements Iterator {
        public b a;
        public b b;

        public a() {
            this.a = LinkedHashMultimap.this.multimapHeaderEntry.h();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b bVar = this.a;
            this.b = bVar;
            this.a = bVar.h();
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            LinkedHashMultimap.this.remove(this.b.getKey(), this.b.getValue());
            this.b = null;
        }
    }

    public static final class b extends C3427ms implements d {
        public final int c;
        public b d;
        public d e;
        public d f;
        public b g;
        public b h;

        public b(Object obj, Object obj2, int i, b bVar) {
            super(obj, obj2);
            this.c = i;
            this.d = bVar;
        }

        public static b j() {
            return new b(null, null, 0, null);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d dVar) {
            this.f = dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d b() {
            d dVar = this.e;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d c() {
            d dVar = this.f;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void e(d dVar) {
            this.e = dVar;
        }

        public b f() {
            b bVar = this.g;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public b h() {
            b bVar = this.h;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        public boolean i(Object obj, int i) {
            return this.c == i && com.google.common.base.Objects.equal(getValue(), obj);
        }

        public void k(b bVar) {
            this.g = bVar;
        }

        public void l(b bVar) {
            this.h = bVar;
        }
    }

    public final class c extends Sets.k implements d {
        public final Object a;
        public b[] b;
        public int c = 0;
        public int d = 0;
        public d e = this;
        public d f = this;

        public class a implements Iterator {
            public d a;
            public b b;
            public int c;

            public a() {
                this.a = c.this.e;
                this.c = c.this.d;
            }

            public final void a() {
                if (c.this.d != this.c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.a != c.this;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                b bVar = (b) this.a;
                Object value = bVar.getValue();
                this.b = bVar;
                this.a = bVar.c();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
                c.this.remove(this.b.getValue());
                this.c = c.this.d;
                this.b = null;
            }
        }

        public c(Object obj, int i) {
            this.a = obj;
            this.b = new b[AbstractC3590or.a(i, 1.0d)];
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void a(d dVar) {
            this.e = dVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            int iD = AbstractC3590or.d(obj);
            int iG = g() & iD;
            b bVar = this.b[iG];
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.i(obj, iD)) {
                    return false;
                }
            }
            b bVar3 = new b(this.a, obj, iD, bVar);
            LinkedHashMultimap.succeedsInValueSet(this.f, bVar3);
            LinkedHashMultimap.succeedsInValueSet(bVar3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.f(), bVar3);
            LinkedHashMultimap.succeedsInMultimap(bVar3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.b[iG] = bVar3;
            this.c++;
            this.d++;
            h();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d b() {
            return this.f;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public d c() {
            return this.e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.b, (Object) null);
            this.c = 0;
            for (d dVarC = this.e; dVarC != this; dVarC = dVarC.c()) {
                LinkedHashMultimap.deleteFromMultimap((b) dVarC);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = AbstractC3590or.d(obj);
            for (b bVar = this.b[g() & iD]; bVar != null; bVar = bVar.d) {
                if (bVar.i(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.d
        public void e(d dVar) {
            this.f = dVar;
        }

        public final int g() {
            return this.b.length - 1;
        }

        public final void h() {
            if (AbstractC3590or.b(this.c, this.b.length, 1.0d)) {
                int length = this.b.length * 2;
                b[] bVarArr = new b[length];
                this.b = bVarArr;
                int i = length - 1;
                for (d dVarC = this.e; dVarC != this; dVarC = dVarC.c()) {
                    b bVar = (b) dVarC;
                    int i2 = bVar.c & i;
                    bVar.d = bVarArr[i2];
                    bVarArr[i2] = bVar;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = AbstractC3590or.d(obj);
            int iG = g() & iD;
            b bVar = null;
            for (b bVar2 = this.b[iG]; bVar2 != null; bVar2 = bVar2.d) {
                if (bVar2.i(obj, iD)) {
                    if (bVar == null) {
                        this.b[iG] = bVar2.d;
                    } else {
                        bVar.d = bVar2.d;
                    }
                    LinkedHashMultimap.deleteFromValueSet(bVar2);
                    LinkedHashMultimap.deleteFromMultimap(bVar2);
                    this.c--;
                    this.d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c;
        }
    }

    public interface d {
        void a(d dVar);

        d b();

        d c();

        void e(d dVar);
    }

    private LinkedHashMultimap(int i, int i2) {
        super(BG.e(i));
        this.valueSetCapacity = 2;
        AbstractC1163Zb.b(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        b bVarJ = b.j();
        this.multimapHeaderEntry = bVarJ;
        succeedsInMultimap(bVarJ, bVarJ);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(b bVar) {
        succeedsInMultimap(bVar.f(), bVar.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(d dVar) {
        succeedsInValueSet(dVar.b(), dVar.c());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        b bVarJ = b.j();
        this.multimapHeaderEntry = bVarJ;
        succeedsInMultimap(bVarJ, bVarJ);
        this.valueSetCapacity = 2;
        int i = objectInputStream.readInt();
        Map<Object, Collection<Object>> mapE = BG.e(12);
        for (int i2 = 0; i2 < i; i2++) {
            Object object = objectInputStream.readObject();
            mapE.put(object, createCollection(object));
        }
        int i3 = objectInputStream.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            Object object2 = objectInputStream.readObject();
            Object object3 = objectInputStream.readObject();
            Collection<Object> collection = mapE.get(object2);
            Objects.requireNonNull(collection);
            collection.add(object3);
        }
        setMap(mapE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(b bVar, b bVar2) {
        bVar.l(bVar2);
        bVar2.k(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(d dVar, d dVar2) {
        dVar.a(dVar2);
        dVar2.e(dVar);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        b bVar = this.multimapHeaderEntry;
        succeedsInMultimap(bVar, bVar);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
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

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
    public Iterator<V> valueIterator() {
        return Maps.valueIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(Maps.capacity(i), Maps.capacity(i2));
    }

    @Override // com.google.common.collect.AbstractC1952b
    public Set<V> createCollection() {
        return BG.f(this.valueSetCapacity);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractC1952b
    public Collection<V> createCollection(K k) {
        return new c(k, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> linkedHashMultimapCreate = create(multimap.keySet().size(), 2);
        linkedHashMultimapCreate.putAll(multimap);
        return linkedHashMultimapCreate;
    }
}
