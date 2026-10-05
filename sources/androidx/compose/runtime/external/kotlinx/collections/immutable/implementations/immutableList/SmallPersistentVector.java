package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import defpackage.R5;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {
    public static final Companion Companion = new Companion(null);
    private static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);
    private final Object[] buffer;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.EMPTY;
        }

        private Companion() {
        }
    }

    public SmallPersistentVector(Object[] objArr) {
        AbstractC4492zt.h(objArr, "buffer");
        this.buffer = objArr;
        CommonFunctionsKt.m2673assert(objArr.length <= 32);
    }

    private final Object[] bufferOfSize(int i) {
        return new Object[i];
    }

    @Override // defpackage.V, java.util.List
    public E get(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        return (E) this.buffer[i];
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.buffer.length;
    }

    @Override // defpackage.V, java.util.List
    public int indexOf(Object obj) {
        return R5.S(this.buffer, obj);
    }

    @Override // defpackage.V, java.util.List
    public int lastIndexOf(Object obj) {
        return R5.X(this.buffer, obj);
    }

    @Override // defpackage.V, java.util.List
    public ListIterator<E> listIterator(int i) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        return new BufferIterator(this.buffer, i, size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> removeAt(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        if (size() == 1) {
            return EMPTY;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() - 1);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        Q5.i(this.buffer, objArrCopyOf, i, i + 1, size());
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // defpackage.V, java.util.List
    public PersistentList<E> set(int i, E e) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i] = e;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> add(E e) {
        if (size() >= 32) {
            return new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(e), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + 1);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[size()] = e;
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> addAll(Collection<? extends E> collection) {
        AbstractC4492zt.h(collection, "elements");
        if (size() + collection.size() > 32) {
            PersistentList.Builder<E> builder = builder();
            builder.addAll(collection);
            return builder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + collection.size());
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new SmallPersistentVector(objArrCopyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        Object[] objArrCopyOf = this.buffer;
        int size = size();
        int size2 = size();
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Object obj = this.buffer[i];
            if (((Boolean) interfaceC3750qp.invoke(obj)).booleanValue()) {
                if (!z) {
                    Object[] objArr = this.buffer;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
                    z = true;
                    size = i;
                }
            } else if (z) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        if (size == size()) {
            return this;
        }
        return size == 0 ? EMPTY : new SmallPersistentVector(Q5.o(objArrCopyOf, 0, size));
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> add(int i, E e) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            return add((Object) e);
        }
        if (size() < 32) {
            Object[] objArrBufferOfSize = bufferOfSize(size() + 1);
            Q5.m(this.buffer, objArrBufferOfSize, 0, 0, i, 6, null);
            Q5.i(this.buffer, objArrBufferOfSize, i + 1, i, size());
            objArrBufferOfSize[i] = e;
            return new SmallPersistentVector(objArrBufferOfSize);
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
        Q5.i(this.buffer, objArrCopyOf, i + 1, i, size() - 1);
        objArrCopyOf[i] = e;
        return new PersistentVector(objArrCopyOf, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList<E> addAll(int i, Collection<? extends E> collection) {
        AbstractC4492zt.h(collection, "c");
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (size() + collection.size() <= 32) {
            Object[] objArrBufferOfSize = bufferOfSize(size() + collection.size());
            Q5.m(this.buffer, objArrBufferOfSize, 0, 0, i, 6, null);
            Q5.i(this.buffer, objArrBufferOfSize, collection.size() + i, i, size());
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                objArrBufferOfSize[i] = it.next();
                i++;
            }
            return new SmallPersistentVector(objArrBufferOfSize);
        }
        PersistentList.Builder<E> builder = builder();
        builder.addAll(i, collection);
        return builder.build();
    }
}
