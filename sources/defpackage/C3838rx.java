package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: rx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3838rx {
    public final Map a;
    public volatile transient Map.Entry b;

    /* JADX INFO: renamed from: rx$a */
    public class a extends AbstractSet {

        /* JADX INFO: renamed from: rx$a$a, reason: collision with other inner class name */
        public class C0329a extends UnmodifiableIterator {
            public final /* synthetic */ Iterator a;

            public C0329a(Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.a.next();
                C3838rx.this.b = entry;
                return entry.getKey();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return new C0329a(C3838rx.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C3838rx.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C3838rx.this.a.size();
        }
    }

    public C3838rx(Map map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    public void c() {
        this.b = null;
    }

    public final boolean d(Object obj) {
        return f(obj) != null || this.a.containsKey(obj);
    }

    public Object e(Object obj) {
        Preconditions.checkNotNull(obj);
        Object objF = f(obj);
        return objF == null ? g(obj) : objF;
    }

    public Object f(Object obj) {
        Map.Entry entry = this.b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final Object g(Object obj) {
        Preconditions.checkNotNull(obj);
        return this.a.get(obj);
    }

    public final Object h(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        c();
        return this.a.put(obj, obj2);
    }

    public final Object i(Object obj) {
        Preconditions.checkNotNull(obj);
        c();
        return this.a.remove(obj);
    }

    public final Set j() {
        return new a();
    }
}
