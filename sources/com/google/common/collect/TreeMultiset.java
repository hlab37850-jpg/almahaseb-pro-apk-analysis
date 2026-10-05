package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1163Zb;
import defpackage.C2146eq;
import defpackage.WD;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractC1958h implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient f header;
    private final transient C2146eq range;
    private final transient g rootReference;

    public class a extends Multisets.f {
        public final /* synthetic */ f a;

        public a(f fVar) {
            this.a = fVar;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            int iW = this.a.w();
            return iW == 0 ? TreeMultiset.this.count(getElement()) : iW;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public Object getElement() {
            return this.a.x();
        }
    }

    public class b implements Iterator {
        public f a;
        public Multiset.Entry b;

        public b() {
            this.a = TreeMultiset.this.firstNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeMultiset treeMultiset = TreeMultiset.this;
            f fVar = this.a;
            Objects.requireNonNull(fVar);
            Multiset.Entry entryWrapEntry = treeMultiset.wrapEntry(fVar);
            this.b = entryWrapEntry;
            if (this.a.L() == TreeMultiset.this.header) {
                this.a = null;
            } else {
                this.a = this.a.L();
            }
            return entryWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.n(this.a.x())) {
                return true;
            }
            this.a = null;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    public class c implements Iterator {
        public f a;
        public Multiset.Entry b = null;

        public c() {
            this.a = TreeMultiset.this.lastNode();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Objects.requireNonNull(this.a);
            Multiset.Entry entryWrapEntry = TreeMultiset.this.wrapEntry(this.a);
            this.b = entryWrapEntry;
            if (this.a.z() == TreeMultiset.this.header) {
                this.a = null;
            } else {
                this.a = this.a.z();
            }
            return entryWrapEntry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.o(this.a.x())) {
                return true;
            }
            this.a = null;
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class e {
        public static final e a = new a("SIZE", 0);
        public static final e b = new b("DISTINCT", 1);
        public static final /* synthetic */ e[] c = a();

        public final enum a extends e {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public int b(f fVar) {
                return fVar.b;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public long c(f fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return fVar.d;
            }
        }

        public final enum b extends e {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public int b(f fVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.e
            public long c(f fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return fVar.c;
            }
        }

        public e(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ e[] a() {
            return new e[]{a, b};
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) c.clone();
        }

        public abstract int b(f fVar);

        public abstract long c(f fVar);

        public /* synthetic */ e(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public static final class g {
        public Object a;

        public g() {
        }

        public void a(Object obj, Object obj2) {
            if (this.a != obj) {
                throw new ConcurrentModificationException();
            }
            this.a = obj2;
        }

        public void b() {
            this.a = null;
        }

        public Object c() {
            return this.a;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public TreeMultiset(g gVar, C2146eq c2146eq, f fVar) {
        super(c2146eq.b());
        this.rootReference = gVar;
        this.range = c2146eq;
        this.header = fVar;
    }

    private long aggregateAboveRange(e eVar, f fVar) {
        long jC;
        long jAggregateAboveRange;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(WD.a(this.range.j()), fVar.x());
        if (iCompare > 0) {
            return aggregateAboveRange(eVar, fVar.g);
        }
        if (iCompare == 0) {
            int i = d.a[this.range.i().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return eVar.c(fVar.g);
                }
                throw new AssertionError();
            }
            jC = eVar.b(fVar);
            jAggregateAboveRange = eVar.c(fVar.g);
        } else {
            jC = eVar.c(fVar.g) + ((long) eVar.b(fVar));
            jAggregateAboveRange = aggregateAboveRange(eVar, fVar.f);
        }
        return jC + jAggregateAboveRange;
    }

    private long aggregateBelowRange(e eVar, f fVar) {
        long jC;
        long jAggregateBelowRange;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(WD.a(this.range.h()), fVar.x());
        if (iCompare < 0) {
            return aggregateBelowRange(eVar, fVar.f);
        }
        if (iCompare == 0) {
            int i = d.a[this.range.f().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return eVar.c(fVar.f);
                }
                throw new AssertionError();
            }
            jC = eVar.b(fVar);
            jAggregateBelowRange = eVar.c(fVar.f);
        } else {
            jC = eVar.c(fVar.f) + ((long) eVar.b(fVar));
            jAggregateBelowRange = aggregateBelowRange(eVar, fVar.g);
        }
        return jC + jAggregateBelowRange;
    }

    private long aggregateForEntries(e eVar) {
        f fVar = (f) this.rootReference.c();
        long jC = eVar.c(fVar);
        if (this.range.k()) {
            jC -= aggregateBelowRange(eVar, fVar);
        }
        return this.range.l() ? jC - aggregateAboveRange(eVar, fVar) : jC;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f firstNode() {
        f fVarL;
        f fVar = (f) this.rootReference.c();
        if (fVar == null) {
            return null;
        }
        if (this.range.k()) {
            Object objA = WD.a(this.range.h());
            fVarL = fVar.s(comparator(), objA);
            if (fVarL == null) {
                return null;
            }
            if (this.range.f() == BoundType.OPEN && comparator().compare(objA, fVarL.x()) == 0) {
                fVarL = fVarL.L();
            }
        } else {
            fVarL = this.header.L();
        }
        if (fVarL == this.header || !this.range.c(fVarL.x())) {
            return null;
        }
        return fVarL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f lastNode() {
        f fVarZ;
        f fVar = (f) this.rootReference.c();
        if (fVar == null) {
            return null;
        }
        if (this.range.l()) {
            Object objA = WD.a(this.range.j());
            fVarZ = fVar.v(comparator(), objA);
            if (fVarZ == null) {
                return null;
            }
            if (this.range.i() == BoundType.OPEN && comparator().compare(objA, fVarZ.x()) == 0) {
                fVarZ = fVarZ.z();
            }
        } else {
            fVarZ = this.header.z();
        }
        if (fVarZ == this.header || !this.range.c(fVarZ.x())) {
            return null;
        }
        return fVarZ;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        G.a(AbstractC1958h.class, "comparator").b(this, comparator);
        G.a(TreeMultiset.class, "range").b(this, C2146eq.a(comparator));
        G.a(TreeMultiset.class, "rootReference").b(this, new g(null));
        f fVar = new f();
        G.a(TreeMultiset.class, HTML.Tag.HEADER).b(this, fVar);
        successor(fVar, fVar);
        G.f(this, objectInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(f fVar, f fVar2) {
        fVar.i = fVar2;
        fVar2.h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(f fVar) {
        return new a(fVar);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        G.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e2, int i) {
        AbstractC1163Zb.b(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        Preconditions.checkArgument(this.range.c(e2));
        f fVar = (f) this.rootReference.c();
        if (fVar != null) {
            int[] iArr = new int[1];
            this.rootReference.a(fVar, fVar.o(comparator(), e2, i, iArr));
            return iArr[0];
        }
        comparator().compare(e2, e2);
        f fVar2 = new f(e2, i);
        f fVar3 = this.header;
        successor(fVar3, fVar2, fVar3);
        this.rootReference.a(fVar, fVar2);
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.k() || this.range.l()) {
            Iterators.clear(entryIterator());
            return;
        }
        f fVarL = this.header.L();
        while (true) {
            f fVar = this.header;
            if (fVarL == fVar) {
                successor(fVar, fVar);
                this.rootReference.b();
                return;
            }
            f fVarL2 = fVarL.L();
            fVarL.b = 0;
            fVarL.f = null;
            fVarL.g = null;
            fVarL.h = null;
            fVarL.i = null;
            fVarL = fVarL2;
        }
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset, defpackage.InterfaceC2276gR
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        try {
            f fVar = (f) this.rootReference.c();
            if (this.range.c(obj) && fVar != null) {
                return fVar.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC1958h
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractC1955e
    public int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(e.b));
    }

    @Override // com.google.common.collect.AbstractC1955e
    public Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractC1955e
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.m(C2146eq.p(comparator(), e2, boundType)), this.header);
    }

    @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        AbstractC1163Zb.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        f fVar = (f) this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.c(obj) && fVar != null) {
                this.rootReference.a(fVar, fVar.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e2, int i) {
        AbstractC1163Zb.b(i, "count");
        if (!this.range.c(e2)) {
            Preconditions.checkArgument(i == 0);
            return 0;
        }
        f fVar = (f) this.rootReference.c();
        if (fVar == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(fVar, fVar.K(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(e.a));
    }

    @Override // com.google.common.collect.AbstractC1958h, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.m(C2146eq.e(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(f fVar) {
        if (fVar == null) {
            return 0;
        }
        return fVar.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(f fVar, f fVar2, f fVar3) {
        successor(fVar, fVar2);
        successor(fVar2, fVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> treeMultisetCreate = create();
        Iterables.addAll(treeMultisetCreate, iterable);
        return treeMultisetCreate;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = C2146eq.a(comparator);
        f fVar = new f();
        this.header = fVar;
        successor(fVar, fVar);
        this.rootReference = new g(null);
    }

    public static final class f {
        public final Object a;
        public int b;
        public int c;
        public long d;
        public int e;
        public f f;
        public f g;
        public f h;
        public f i;

        public f(Object obj, int i) {
            Preconditions.checkArgument(i > 0);
            this.a = obj;
            this.b = i;
            this.d = i;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        public static long M(f fVar) {
            if (fVar == null) {
                return 0L;
            }
            return fVar.d;
        }

        public static int y(f fVar) {
            if (fVar == null) {
                return 0;
            }
            return fVar.e;
        }

        public final f A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.g);
                if (this.g.r() > 0) {
                    this.g = this.g.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f);
            if (this.f.r() < 0) {
                this.f = this.f.H();
            }
            return I();
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.e = Math.max(y(this.f), y(this.g)) + 1;
        }

        public final void D() {
            this.c = TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g);
            this.d = ((long) this.b) + M(this.f) + M(this.g);
        }

        public f E(Comparator comparator, Object obj, int i, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = fVar.E(comparator, obj, i, iArr);
                int i2 = iArr[0];
                if (i2 > 0) {
                    if (i >= i2) {
                        this.c--;
                        this.d -= (long) i2;
                    } else {
                        this.d -= (long) i;
                    }
                }
                return i2 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                if (i >= i3) {
                    return u();
                }
                this.b = i3 - i;
                this.d -= (long) i;
                return this;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.g = fVar2.E(comparator, obj, i, iArr);
            int i4 = iArr[0];
            if (i4 > 0) {
                if (i >= i4) {
                    this.c--;
                    this.d -= (long) i4;
                } else {
                    this.d -= (long) i;
                }
            }
            return A();
        }

        public final f F(f fVar) {
            f fVar2 = this.g;
            if (fVar2 == null) {
                return this.f;
            }
            this.g = fVar2.F(fVar);
            this.c--;
            this.d -= (long) fVar.b;
            return A();
        }

        public final f G(f fVar) {
            f fVar2 = this.f;
            if (fVar2 == null) {
                return this.g;
            }
            this.f = fVar2.G(fVar);
            this.c--;
            this.d -= (long) fVar.b;
            return A();
        }

        public final f H() {
            Preconditions.checkState(this.g != null);
            f fVar = this.g;
            this.g = fVar.f;
            fVar.f = this;
            fVar.d = this.d;
            fVar.c = this.c;
            B();
            fVar.C();
            return fVar;
        }

        public final f I() {
            Preconditions.checkState(this.f != null);
            f fVar = this.f;
            this.f = fVar.g;
            fVar.g = this;
            fVar.d = this.d;
            fVar.c = this.c;
            B();
            fVar.C();
            return fVar;
        }

        public f J(Comparator comparator, Object obj, int i, int i2, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : p(obj, i2);
                }
                this.f = fVar.J(comparator, obj, i, i2, iArr);
                int i3 = iArr[0];
                if (i3 == i) {
                    if (i2 == 0 && i3 != 0) {
                        this.c--;
                    } else if (i2 > 0 && i3 == 0) {
                        this.c++;
                    }
                    this.d += (long) (i2 - i3);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i4 = this.b;
                iArr[0] = i4;
                if (i == i4) {
                    if (i2 == 0) {
                        return u();
                    }
                    this.d += (long) (i2 - i4);
                    this.b = i2;
                }
                return this;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : q(obj, i2);
            }
            this.g = fVar2.J(comparator, obj, i, i2, iArr);
            int i5 = iArr[0];
            if (i5 == i) {
                if (i2 == 0 && i5 != 0) {
                    this.c--;
                } else if (i2 > 0 && i5 == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - i5);
            }
            return A();
        }

        public f K(Comparator comparator, Object obj, int i, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return i > 0 ? p(obj, i) : this;
                }
                this.f = fVar.K(comparator, obj, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i2 = this.b;
                iArr[0] = i2;
                if (i == 0) {
                    return u();
                }
                this.d += (long) (i - i2);
                this.b = i;
                return this;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return i > 0 ? q(obj, i) : this;
            }
            this.g = fVar2.K(comparator, obj, i, iArr);
            if (i == 0 && iArr[0] != 0) {
                this.c--;
            } else if (i > 0 && iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) (i - iArr[0]);
            return A();
        }

        public final f L() {
            f fVar = this.i;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        public f o(Comparator comparator, Object obj, int i, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return p(obj, i);
                }
                int i2 = fVar.e;
                f fVarO = fVar.o(comparator, obj, i, iArr);
                this.f = fVarO;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i;
                return fVarO.e == i2 ? this : A();
            }
            if (iCompare <= 0) {
                int i3 = this.b;
                iArr[0] = i3;
                long j = i;
                Preconditions.checkArgument(((long) i3) + j <= 2147483647L);
                this.b += i;
                this.d += j;
                return this;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return q(obj, i);
            }
            int i4 = fVar2.e;
            f fVarO2 = fVar2.o(comparator, obj, i, iArr);
            this.g = fVarO2;
            if (iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) i;
            return fVarO2.e == i4 ? this : A();
        }

        public final f p(Object obj, int i) {
            this.f = new f(obj, i);
            TreeMultiset.successor(z(), this.f, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i;
            return this;
        }

        public final f q(Object obj, int i) {
            f fVar = new f(obj, i);
            this.g = fVar;
            TreeMultiset.successor(this, fVar, L());
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i;
            return this;
        }

        public final int r() {
            return y(this.f) - y(this.g);
        }

        public final f s(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                return fVar == null ? this : (f) MoreObjects.firstNonNull(fVar.s(comparator, obj), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.s(comparator, obj);
        }

        public int t(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                f fVar = this.f;
                if (fVar == null) {
                    return 0;
                }
                return fVar.t(comparator, obj);
            }
            if (iCompare <= 0) {
                return this.b;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                return 0;
            }
            return fVar2.t(comparator, obj);
        }

        public String toString() {
            return Multisets.immutableEntry(x(), w()).toString();
        }

        public final f u() {
            int i = this.b;
            this.b = 0;
            TreeMultiset.successor(z(), L());
            f fVar = this.f;
            if (fVar == null) {
                return this.g;
            }
            f fVar2 = this.g;
            if (fVar2 == null) {
                return fVar;
            }
            if (fVar.e >= fVar2.e) {
                f fVarZ = z();
                fVarZ.f = this.f.F(fVarZ);
                fVarZ.g = this.g;
                fVarZ.c = this.c - 1;
                fVarZ.d = this.d - ((long) i);
                return fVarZ.A();
            }
            f fVarL = L();
            fVarL.g = this.g.G(fVarL);
            fVarL.f = this.f;
            fVarL.c = this.c - 1;
            fVarL.d = this.d - ((long) i);
            return fVarL.A();
        }

        public final f v(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare > 0) {
                f fVar = this.g;
                return fVar == null ? this : (f) MoreObjects.firstNonNull(fVar.v(comparator, obj), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f fVar2 = this.f;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.v(comparator, obj);
        }

        public int w() {
            return this.b;
        }

        public Object x() {
            return WD.a(this.a);
        }

        public final f z() {
            f fVar = this.h;
            Objects.requireNonNull(fVar);
            return fVar;
        }

        public f() {
            this.a = null;
            this.b = 1;
        }
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        AbstractC1163Zb.b(i2, "newCount");
        AbstractC1163Zb.b(i, "oldCount");
        Preconditions.checkArgument(this.range.c(e2));
        f fVar = (f) this.rootReference.c();
        if (fVar != null) {
            int[] iArr = new int[1];
            this.rootReference.a(fVar, fVar.J(comparator(), e2, i, i2, iArr));
            return iArr[0] == i;
        }
        if (i != 0) {
            return false;
        }
        if (i2 > 0) {
            add(e2, i2);
        }
        return true;
    }
}
