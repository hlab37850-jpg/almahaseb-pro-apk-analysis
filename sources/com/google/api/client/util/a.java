package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbstractMap {
    public final Object a;
    public final ClassInfo b;

    /* JADX INFO: renamed from: com.google.api.client.util.a$a, reason: collision with other inner class name */
    public final class C0202a implements Map.Entry {
        public Object a;
        public final FieldInfo b;

        public C0202a(FieldInfo fieldInfo, Object obj) {
            this.b = fieldInfo;
            this.a = Preconditions.checkNotNull(obj);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            String name = this.b.getName();
            return a.this.b.getIgnoreCase() ? name.toLowerCase() : name;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.a;
            this.a = Preconditions.checkNotNull(obj);
            this.b.setValue(a.this.a, obj);
            return obj2;
        }
    }

    public final class b implements Iterator {
        public int a = -1;
        public FieldInfo b;
        public Object c;
        public boolean d;
        public boolean e;
        public FieldInfo f;

        public b() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            FieldInfo fieldInfo = this.b;
            this.f = fieldInfo;
            Object obj = this.c;
            this.e = false;
            this.d = false;
            this.b = null;
            this.c = null;
            return a.this.new C0202a(fieldInfo, obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.e) {
                this.e = true;
                this.c = null;
                while (this.c == null) {
                    int i = this.a + 1;
                    this.a = i;
                    if (i >= a.this.b.names.size()) {
                        break;
                    }
                    ClassInfo classInfo = a.this.b;
                    FieldInfo fieldInfo = classInfo.getFieldInfo(classInfo.names.get(this.a));
                    this.b = fieldInfo;
                    this.c = fieldInfo.getValue(a.this.a);
                }
            }
            return this.c != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState((this.f == null || this.d) ? false : true);
            this.d = true;
            this.f.setValue(a.this.a, null);
        }
    }

    public final class c extends AbstractSet {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b iterator() {
            return a.this.new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<String> it = a.this.b.names.iterator();
            while (it.hasNext()) {
                a.this.b.getFieldInfo(it.next()).setValue(a.this.a, null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            Iterator<String> it = a.this.b.names.iterator();
            while (it.hasNext()) {
                if (a.this.b.getFieldInfo(it.next()).getValue(a.this.a) != null) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<String> it = a.this.b.names.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (a.this.b.getFieldInfo(it.next()).getValue(a.this.a) != null) {
                    i++;
                }
            }
            return i;
        }
    }

    public a(Object obj, boolean z) {
        this.a = obj;
        ClassInfo classInfoOf = ClassInfo.of(obj.getClass(), z);
        this.b = classInfoOf;
        Preconditions.checkArgument(!classInfoOf.isEnum());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        FieldInfo fieldInfo = this.b.getFieldInfo(str);
        Preconditions.checkNotNull(fieldInfo, "no field of key " + str);
        Object value = fieldInfo.getValue(this.a);
        fieldInfo.setValue(this.a, Preconditions.checkNotNull(obj));
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        FieldInfo fieldInfo;
        if ((obj instanceof String) && (fieldInfo = this.b.getFieldInfo((String) obj)) != null) {
            return fieldInfo.getValue(this.a);
        }
        return null;
    }
}
