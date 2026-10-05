package defpackage;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: renamed from: qs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3753qs extends ImmutableCollection {
    public final ImmutableMap a;

    /* JADX INFO: renamed from: qs$a */
    public class a extends UnmodifiableIterator {
        public final UnmodifiableIterator a;

        public a() {
            this.a = C3753qs.this.a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.a.next()).getValue();
        }
    }

    /* JADX INFO: renamed from: qs$b */
    public class b extends ImmutableList {
        public final /* synthetic */ ImmutableList a;

        public b(C3753qs c3753qs, ImmutableList immutableList) {
            this.a = immutableList;
        }

        @Override // java.util.List
        public Object get(int i) {
            return ((Map.Entry) this.a.get(i)).getValue();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.a.size();
        }
    }

    /* JADX INFO: renamed from: qs$c */
    public static class c implements Serializable {
        public final ImmutableMap a;

        public c(ImmutableMap immutableMap) {
            this.a = immutableMap;
        }
    }

    public C3753qs(ImmutableMap immutableMap) {
        this.a = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList asList() {
        return new b(this, this.a.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return obj != null && Iterators.contains(iterator(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.a.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new c(this.a);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator iterator() {
        return new a();
    }
}
