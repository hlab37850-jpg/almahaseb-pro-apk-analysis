package defpackage;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: ps, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3672ps extends AbstractC0455Es {
    public final ImmutableMap a;

    /* JADX INFO: renamed from: ps$a */
    public static class a implements Serializable {
        public final ImmutableMap a;

        public a(ImmutableMap immutableMap) {
            this.a = immutableMap;
        }
    }

    public C3672ps(ImmutableMap immutableMap) {
        this.a = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // defpackage.AbstractC0455Es
    public Object get(int i) {
        return ((Map.Entry) this.a.entrySet().asList().get(i)).getKey();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.a.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new a(this.a);
    }

    @Override // defpackage.AbstractC0455Es, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator iterator() {
        return this.a.keyIterator();
    }
}
