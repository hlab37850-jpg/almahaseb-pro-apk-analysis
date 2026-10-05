package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.b;
import defpackage.InterfaceC0778Nq;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements InterfaceC0778Nq {
    public static final Object e = new Object();
    public final Map a;
    public final List b;
    public int c;
    public int d;

    public class a extends AbstractSet {

        /* JADX INFO: renamed from: com.google.common.graph.b$a$a, reason: collision with other inner class name */
        public class C0247a extends AbstractIterator {
            public final /* synthetic */ Iterator a;
            public final /* synthetic */ Set b;

            public C0247a(a aVar, Iterator it, Set set) {
                this.a = it;
                this.b = set;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    f fVar = (f) this.a.next();
                    if (this.b.add(fVar.a)) {
                        return fVar.a;
                    }
                }
                return endOfData();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return new C0247a(this, b.this.b.iterator(), new HashSet());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b.this.a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b.this.a.size();
        }
    }

    /* JADX INFO: renamed from: com.google.common.graph.b$b, reason: collision with other inner class name */
    public class C0248b extends AbstractSet {

        /* JADX INFO: renamed from: com.google.common.graph.b$b$a */
        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public a(C0248b c0248b, Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.a.next();
                    if (b.s(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.b$b$b, reason: collision with other inner class name */
        public class C0249b extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public C0249b(C0248b c0248b, Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    f fVar = (f) this.a.next();
                    if (fVar instanceof f.a) {
                        return fVar.a;
                    }
                }
                return endOfData();
            }
        }

        public C0248b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return b.this.b == null ? new a(this, b.this.a.entrySet().iterator()) : new C0249b(this, b.this.b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b.s(b.this.a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b.this.c;
        }
    }

    public class c extends AbstractSet {

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public a(c cVar, Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.a.next();
                    if (b.t(entry.getValue())) {
                        return entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.b$c$b, reason: collision with other inner class name */
        public class C0250b extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public C0250b(c cVar, Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    f fVar = (f) this.a.next();
                    if (fVar instanceof f.C0251b) {
                        return fVar.a;
                    }
                }
                return endOfData();
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return b.this.b == null ? new a(this, b.this.a.entrySet().iterator()) : new C0250b(this, b.this.b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b.t(b.this.a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b.this.d;
        }
    }

    public class d extends AbstractIterator {
        public final /* synthetic */ Iterator a;
        public final /* synthetic */ AtomicBoolean b;

        public d(b bVar, Iterator it, AtomicBoolean atomicBoolean) {
            this.a = it;
            this.b = atomicBoolean;
        }

        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair computeNext() {
            while (this.a.hasNext()) {
                EndpointPair endpointPair = (EndpointPair) this.a.next();
                if (!endpointPair.nodeU().equals(endpointPair.nodeV()) || !this.b.getAndSet(true)) {
                    return endpointPair;
                }
            }
            return (EndpointPair) endOfData();
        }
    }

    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class f {
        public final Object a;

        public static final class a extends f {
            public a(Object obj) {
                super(obj);
            }

            public boolean equals(Object obj) {
                if (obj instanceof a) {
                    return this.a.equals(((a) obj).a);
                }
                return false;
            }

            public int hashCode() {
                return a.class.hashCode() + this.a.hashCode();
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.b$f$b, reason: collision with other inner class name */
        public static final class C0251b extends f {
            public C0251b(Object obj) {
                super(obj);
            }

            public boolean equals(Object obj) {
                if (obj instanceof C0251b) {
                    return this.a.equals(((C0251b) obj).a);
                }
                return false;
            }

            public int hashCode() {
                return C0251b.class.hashCode() + this.a.hashCode();
            }
        }

        public f(Object obj) {
            this.a = Preconditions.checkNotNull(obj);
        }
    }

    public static final class g {
        public final Object a;

        public g(Object obj) {
            this.a = obj;
        }
    }

    public b(Map map, List list, int i, int i2) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = list;
        this.c = Graphs.checkNonNegative(i);
        this.d = Graphs.checkNonNegative(i2);
        Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    public static boolean s(Object obj) {
        return obj == e || (obj instanceof g);
    }

    public static boolean t(Object obj) {
        return (obj == e || obj == null) ? false : true;
    }

    public static /* synthetic */ EndpointPair u(Object obj, Object obj2) {
        return EndpointPair.ordered(obj2, obj);
    }

    public static /* synthetic */ EndpointPair w(Object obj, f fVar) {
        return fVar instanceof f.C0251b ? EndpointPair.ordered(obj, fVar.a) : EndpointPair.ordered(fVar.a, obj);
    }

    public static b x(ElementOrder elementOrder) {
        ArrayList arrayList;
        int i = e.a[elementOrder.type().ordinal()];
        if (i == 1) {
            arrayList = null;
        } else {
            if (i != 2) {
                throw new AssertionError(elementOrder.type());
            }
            arrayList = new ArrayList();
        }
        return new b(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    public static b y(Object obj, Iterable iterable, Function function) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(function);
        HashMap map = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        Iterator it = iterable.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            EndpointPair endpointPair = (EndpointPair) it.next();
            if (endpointPair.nodeU().equals(obj) && endpointPair.nodeV().equals(obj)) {
                map.put(obj, new g(function.apply(obj)));
                builder.add(new f.a(obj));
                builder.add(new f.C0251b(obj));
                i++;
            } else if (endpointPair.nodeV().equals(obj)) {
                Object objNodeU = endpointPair.nodeU();
                Object objPut = map.put(objNodeU, e);
                if (objPut != null) {
                    map.put(objNodeU, new g(objPut));
                }
                builder.add(new f.a(objNodeU));
                i++;
            } else {
                Preconditions.checkArgument(endpointPair.nodeU().equals(obj));
                Object objNodeV = endpointPair.nodeV();
                Object objApply = function.apply(objNodeV);
                Object objPut2 = map.put(objNodeV, objApply);
                if (objPut2 != null) {
                    Preconditions.checkArgument(objPut2 == e);
                    map.put(objNodeV, new g(objApply));
                }
                builder.add(new f.C0251b(objNodeV));
            }
            i2++;
        }
        return new b(map, builder.build(), i, i2);
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set a() {
        return this.b == null ? Collections.unmodifiableSet(this.a.keySet()) : new a();
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set b() {
        return new c();
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set c() {
        return new C0248b();
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object d(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        Object obj3 = this.a.get(obj);
        if (obj3 == null || obj3 == (obj2 = e)) {
            obj3 = null;
        } else if (obj3 instanceof g) {
            this.a.put(obj, obj2);
            obj3 = ((g) obj3).a;
        } else {
            this.a.remove(obj);
        }
        if (obj3 != null) {
            int i = this.d - 1;
            this.d = i;
            Graphs.checkNonNegative(i);
            List list = this.b;
            if (list != null) {
                list.remove(new f.C0251b(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return obj3;
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object e(Object obj) {
        Preconditions.checkNotNull(obj);
        Object obj2 = this.a.get(obj);
        if (obj2 == e) {
            return null;
        }
        return obj2 instanceof g ? ((g) obj2).a : obj2;
    }

    @Override // defpackage.InterfaceC0778Nq
    public void f(Object obj) {
        Preconditions.checkNotNull(obj);
        Object obj2 = this.a.get(obj);
        if (obj2 == e) {
            this.a.remove(obj);
        } else if (!(obj2 instanceof g)) {
            return;
        } else {
            this.a.put(obj, ((g) obj2).a);
        }
        int i = this.c - 1;
        this.c = i;
        Graphs.checkNonNegative(i);
        List list = this.b;
        if (list != null) {
            list.remove(new f.a(obj));
        }
    }

    @Override // defpackage.InterfaceC0778Nq
    public Iterator g(final Object obj) {
        Preconditions.checkNotNull(obj);
        List list = this.b;
        return new d(this, list == null ? Iterators.concat(Iterators.transform(c().iterator(), new Function() { // from class: mj
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return b.u(obj, obj2);
            }
        }), Iterators.transform(b().iterator(), new Function() { // from class: nj
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.ordered(obj, obj2);
            }
        })) : Iterators.transform(list.iterator(), new Function() { // from class: oj
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return b.w(obj, (b.f) obj2);
            }
        }), new AtomicBoolean(false));
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object h(Object obj, Object obj2) {
        Object objPut = this.a.put(obj, obj2);
        if (objPut == null) {
            objPut = null;
        } else if (objPut instanceof g) {
            this.a.put(obj, new g(obj2));
            objPut = ((g) objPut).a;
        } else if (objPut == e) {
            this.a.put(obj, new g(obj2));
            objPut = null;
        }
        if (objPut == null) {
            int i = this.d + 1;
            this.d = i;
            Graphs.checkPositive(i);
            List list = this.b;
            if (list != null) {
                list.add(new f.C0251b(obj));
            }
        }
        if (objPut == null) {
            return null;
        }
        return objPut;
    }

    @Override // defpackage.InterfaceC0778Nq
    public void i(Object obj, Object obj2) {
        Map map = this.a;
        Object obj3 = e;
        Object objPut = map.put(obj, obj3);
        if (objPut != null) {
            if (objPut instanceof g) {
                this.a.put(obj, objPut);
                return;
            } else if (objPut == obj3) {
                return;
            } else {
                this.a.put(obj, new g(objPut));
            }
        }
        int i = this.c + 1;
        this.c = i;
        Graphs.checkPositive(i);
        List list = this.b;
        if (list != null) {
            list.add(new f.a(obj));
        }
    }
}
