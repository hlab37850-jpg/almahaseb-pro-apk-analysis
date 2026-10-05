package androidx.collection;

import defpackage.AbstractC1833bx;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0756Mu;
import defpackage.InterfaceC3588op;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12611<T> implements Iterator<T>, InterfaceC0756Mu {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        public C12611(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) longSparseArray.valueAt(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        AbstractC4492zt.i(interfaceC0526Fp, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            interfaceC0526Fp.mo13invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return longSparseArray.get(j, t);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        AbstractC4492zt.i(interfaceC3588op, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : (T) interfaceC3588op.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return !longSparseArray.isEmpty();
    }

    public static final <T> AbstractC1833bx keyIterator(final LongSparseArray<T> longSparseArray) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return new AbstractC1833bx() { // from class: androidx.collection.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // defpackage.AbstractC1833bx
            public long nextLong() {
                LongSparseArray longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        AbstractC4492zt.i(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return longSparseArray.remove(j, t);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        longSparseArray.put(j, t);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        AbstractC4492zt.i(longSparseArray, "receiver$0");
        return new C12611(longSparseArray);
    }
}
