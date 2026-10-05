package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends ImmutableMap.b {
    public final transient EnumMap a;

    public static class a implements Serializable {
        public final EnumMap a;

        public a(EnumMap enumMap) {
            this.a = enumMap;
        }
    }

    public r(EnumMap enumMap) {
        this.a = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    public static ImmutableMap b(EnumMap enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new r(enumMap);
        }
        Map.Entry entry = (Map.Entry) Iterables.getOnlyElement(enumMap.entrySet());
        return ImmutableMap.of((Enum) entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap.b
    public UnmodifiableIterator a() {
        return Maps.unmodifiableEntryIterator(this.a.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            obj = ((r) obj).a;
        }
        return this.a.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        return this.a.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public UnmodifiableIterator keyIterator() {
        return Iterators.unmodifiableIterator(this.a.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.a.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new a(this.a);
    }
}
