package defpackage;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4418z extends ForwardingMap implements BiMap, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient Map<Object, Object> delegate;
    private transient Set<Map.Entry<Object, Object>> entrySet;

    @RetainedWith
    transient AbstractC4418z inverse;
    private transient Set<Object> keySet;
    private transient Set<Object> valueSet;

    /* JADX INFO: renamed from: z$a */
    public class a implements Iterator {
        public Map.Entry a;
        public final /* synthetic */ Iterator b;

        public a(Iterator it) {
            this.b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.b.next();
            this.a = entry;
            return AbstractC4418z.this.new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry entry = this.a;
            if (entry == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            Object value = entry.getValue();
            this.b.remove();
            AbstractC4418z.this.f(value);
            this.a = null;
        }
    }

    /* JADX INFO: renamed from: z$b */
    public class b extends ForwardingMapEntry {
        public final Map.Entry a;

        public b(Map.Entry entry) {
            this.a = entry;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            AbstractC4418z.this.checkValue(obj);
            Preconditions.checkState(AbstractC4418z.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(obj, getValue())) {
                return obj;
            }
            Preconditions.checkArgument(!AbstractC4418z.this.containsValue(obj), "value already present: %s", obj);
            Object value = this.a.setValue(obj);
            Preconditions.checkState(Objects.equal(obj, AbstractC4418z.this.get(getKey())), "entry no longer in map");
            AbstractC4418z.this.h(getKey(), true, value, obj);
            return value;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry delegate() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: z$c */
    public class c extends ForwardingSet {
        public final Set a;

        public c() {
            this.a = AbstractC4418z.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public void clear() {
            AbstractC4418z.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC4418z.this.entrySetIterator();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.a.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractC4418z.this.inverse.delegate.remove(entry.getValue());
            this.a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return standardToArray(objArr);
        }

        public /* synthetic */ c(AbstractC4418z abstractC4418z, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: z$d */
    public static class d extends AbstractC4418z {
        public d(Map map, AbstractC4418z abstractC4418z) {
            super(map, abstractC4418z, null);
        }

        @Override // defpackage.AbstractC4418z
        public Object checkKey(Object obj) {
            return this.inverse.checkValue(obj);
        }

        @Override // defpackage.AbstractC4418z
        public Object checkValue(Object obj) {
            return this.inverse.checkKey(obj);
        }

        @Override // defpackage.AbstractC4418z, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @Override // defpackage.AbstractC4418z, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: renamed from: z$e */
    public class e extends ForwardingSet {
        public e() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public void clear() {
            AbstractC4418z.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Maps.keyIterator(AbstractC4418z.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractC4418z.this.e(obj);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            return standardRetainAll(collection);
        }

        public /* synthetic */ e(AbstractC4418z abstractC4418z, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            return AbstractC4418z.this.delegate.keySet();
        }
    }

    /* JADX INFO: renamed from: z$f */
    public class f extends ForwardingSet {
        public final Set a;

        public f() {
            this.a = AbstractC4418z.this.inverse.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Maps.valueIterator(AbstractC4418z.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return standardToArray(objArr);
        }

        public /* synthetic */ f(AbstractC4418z abstractC4418z, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            return this.a;
        }
    }

    public /* synthetic */ AbstractC4418z(Map map, AbstractC4418z abstractC4418z, a aVar) {
        this(map, abstractC4418z);
    }

    public final Object c(Object obj, Object obj2, boolean z) {
        checkKey(obj);
        checkValue(obj2);
        boolean zContainsKey = containsKey(obj);
        if (zContainsKey && Objects.equal(obj2, get(obj))) {
            return obj2;
        }
        if (z) {
            inverse().remove(obj2);
        } else {
            Preconditions.checkArgument(!containsValue(obj2), "value already present: %s", obj2);
        }
        Object objPut = this.delegate.put(obj, obj2);
        h(obj, zContainsKey, objPut, obj2);
        return objPut;
    }

    public abstract Object checkKey(Object obj);

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    public final Object e(Object obj) {
        Object objA = WD.a(this.delegate.remove(obj));
        f(objA);
        return objA;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set entrySet() {
        Set<Map.Entry<Object, Object>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<Object, Object>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator());
    }

    public final void f(Object obj) {
        this.inverse.delegate.remove(obj);
    }

    public Object forcePut(Object obj, Object obj2) {
        return c(obj, obj2, true);
    }

    public final void h(Object obj, boolean z, Object obj2, Object obj3) {
        if (z) {
            f(WD.a(obj2));
        }
        this.inverse.delegate.put(obj3, obj);
    }

    public BiMap inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set keySet() {
        Set<Object> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.keySet = eVar;
        return eVar;
    }

    public AbstractC4418z makeInverse(Map<Object, Object> map) {
        return new d(map, this);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Object put(Object obj, Object obj2) {
        return c(obj, obj2, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Object remove(Object obj) {
        if (containsKey(obj)) {
            return e(obj);
        }
        return null;
    }

    public void setDelegates(Map<Object, Object> map, Map<Object, Object> map2) {
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        Preconditions.checkArgument(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractC4418z abstractC4418z) {
        this.inverse = abstractC4418z;
    }

    public AbstractC4418z(Map map, Map map2) {
        setDelegates(map, map2);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Object, Object> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Set values() {
        Set<Object> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f(this, null);
        this.valueSet = fVar;
        return fVar;
    }

    public AbstractC4418z(Map map, AbstractC4418z abstractC4418z) {
        this.delegate = map;
        this.inverse = abstractC4418z;
    }

    @CanIgnoreReturnValue
    public Object checkValue(Object obj) {
        return obj;
    }
}
