package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;

/* JADX INFO: renamed from: Lk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0721Lk extends AbstractSet {
    public final Map a;
    public final Object b;

    public C0721Lk(Map map, Object obj) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = Preconditions.checkNotNull(obj);
    }

    public final Object a() {
        return this.a.get(this.b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator iterator() {
        Object objA = a();
        return objA == null ? ImmutableSet.of().iterator() : Iterators.singletonIterator(objA);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object objA = a();
        return objA != null && objA.equals(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
