package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1239ac;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class IdentityArraySet<T> implements Set<T>, InterfaceC0756Mu {
    private int size;
    private Object[] values = new Object[16];

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.IdentityArraySet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, InterfaceC0756Mu {
        private int index;
        final /* synthetic */ IdentityArraySet<T> this$0;

        public AnonymousClass1(IdentityArraySet<T> identityArraySet) {
            this.this$0 = identityArraySet;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.this$0.size();
        }

        @Override // java.util.Iterator
        public T next() {
            Object[] values = this.this$0.getValues();
            int i = this.index;
            this.index = i + 1;
            T t = (T) values[i];
            AbstractC4492zt.f(t, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.IdentityArraySet$toString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16411 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C16411 INSTANCE = new C16411();

        public C16411() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final CharSequence invoke(T t) {
            AbstractC4492zt.h(t, "it");
            return t.toString();
        }
    }

    private final void checkIndexBounds(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index " + i + ", size " + size());
        }
    }

    private final int find(Object obj) {
        int size = size() - 1;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        Object[] objArr = this.values;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            Object obj2 = objArr[i2];
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i = i2 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return obj2 == obj ? i2 : findExactIndex(i2, obj, iIdentityHashCode);
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object obj2;
        Object[] objArr = this.values;
        int size = size();
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj3 = objArr[i3];
            if (obj3 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= size) {
                return -(size + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T t) {
        int iFind;
        AbstractC4492zt.h(t, "value");
        int size = size();
        Object[] objArr = this.values;
        if (size > 0) {
            iFind = find(t);
            if (iFind >= 0) {
                return false;
            }
        } else {
            iFind = -1;
        }
        int i = -(iFind + 1);
        if (size == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            Q5.i(objArr, objArr2, i + 1, i, size);
            Q5.m(objArr, objArr2, 0, 0, i, 6, null);
            this.values = objArr2;
        } else {
            Q5.i(objArr, objArr, i + 1, i, size);
        }
        this.values[i] = t;
        this.size = size() + 1;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        Q5.u(this.values, null, 0, 0, 6, null);
        this.size = 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && find(obj) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        AbstractC4492zt.h(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void fastForEach(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        Object[] values = getValues();
        int size = size();
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            interfaceC3750qp.invoke(obj);
        }
    }

    public final T get(int i) {
        checkIndexBounds(i);
        T t = (T) this.values[i];
        AbstractC4492zt.f(t, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return t;
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T t) {
        if (t == null) {
            return false;
        }
        int iFind = find(t);
        Object[] objArr = this.values;
        int size = size();
        if (iFind < 0) {
            return false;
        }
        int i = size - 1;
        if (iFind < i) {
            Q5.i(objArr, objArr, iFind, iFind + 1, size);
        }
        objArr[i] = null;
        this.size = size() - 1;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void removeValueIf(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        Object[] values = getValues();
        int size = size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = values[i2];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (!((Boolean) interfaceC3750qp.invoke(obj)).booleanValue()) {
                if (i != i2) {
                    values[i] = obj;
                }
                i++;
            }
        }
        for (int i3 = i; i3 < size; i3++) {
            values[i3] = null;
        }
        this.size = i;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return AbstractC1239ac.a(this);
    }

    public String toString() {
        return AbstractC3240kc.j0(this, null, "[", "]", 0, null, C16411.INSTANCE, 25, null);
    }

    @Override // java.util.Set, java.util.Collection
    public final void addAll(Collection<? extends T> collection) {
        Object[] objArr;
        int i;
        Object obj;
        AbstractC4492zt.h(collection, "collection");
        if (collection.isEmpty()) {
            return;
        }
        if (!(collection instanceof IdentityArraySet)) {
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return;
        }
        Object[] objArr2 = this.values;
        IdentityArraySet identityArraySet = (IdentityArraySet) collection;
        Object[] objArr3 = identityArraySet.values;
        int size = size();
        int size2 = identityArraySet.size();
        int i2 = size + size2;
        boolean z = this.values.length < i2;
        boolean z2 = size == 0 || ActualJvm_jvmKt.identityHashCode(objArr2[size + (-1)]) < ActualJvm_jvmKt.identityHashCode(objArr3[0]);
        if (!z && z2) {
            Q5.i(objArr3, objArr2, size, 0, size2);
            this.size = size() + size2;
            return;
        }
        if (z) {
            objArr = new Object[size > size2 ? size * 2 : size2 * 2];
        } else {
            objArr = objArr2;
        }
        int i3 = size - 1;
        int i4 = size2 - 1;
        int i5 = i2 - 1;
        while (true) {
            if (i3 < 0 && i4 < 0) {
                break;
            }
            if (i3 < 0) {
                i = i4 - 1;
                obj = objArr3[i4];
            } else if (i4 < 0) {
                i = i4;
                obj = objArr2[i3];
                i3--;
            } else {
                Object obj2 = objArr2[i3];
                Object obj3 = objArr3[i4];
                int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj2);
                int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj3);
                if (iIdentityHashCode > iIdentityHashCode2) {
                    i3--;
                } else {
                    if (iIdentityHashCode >= iIdentityHashCode2) {
                        if (obj2 == obj3) {
                            i3--;
                            i4--;
                        } else {
                            int i6 = i3 - 1;
                            while (true) {
                                if (i6 >= 0) {
                                    int i7 = i6 - 1;
                                    Object obj4 = objArr2[i6];
                                    if (ActualJvm_jvmKt.identityHashCode(obj4) == iIdentityHashCode2) {
                                        if (obj3 == obj4) {
                                            i4--;
                                        } else {
                                            i6 = i7;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i = i4 - 1;
                    obj = obj3;
                }
                i = i4;
                obj = obj2;
            }
            objArr[i5] = obj;
            i4 = i;
            i5--;
        }
        if (i5 >= 0) {
            Q5.i(objArr, objArr, 0, i5 + 1, i2);
        }
        int i8 = i2 - (i5 + 1);
        Q5.r(objArr, null, i8, i2);
        this.values = objArr;
        this.size = i8;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        AbstractC4492zt.h(tArr, "array");
        return (T[]) AbstractC1239ac.b(this, tArr);
    }
}
