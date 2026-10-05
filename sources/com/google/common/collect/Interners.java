package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Interners {

    public static class InternerBuilder {
        private final MapMaker mapMaker;
        private boolean strong;

        public <E> Interner<E> build() {
            if (!this.strong) {
                this.mapMaker.weakKeys();
            }
            return new c(this.mapMaker);
        }

        public InternerBuilder concurrencyLevel(int i) {
            this.mapMaker.concurrencyLevel(i);
            return this;
        }

        public InternerBuilder strong() {
            this.strong = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.strong = false;
            return this;
        }

        private InternerBuilder() {
            this.mapMaker = new MapMaker();
            this.strong = true;
        }
    }

    public static class b implements Function {
        public final Interner a;

        public b(Interner interner) {
            this.a = interner;
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.a.intern(obj);
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class c implements Interner {
        public final v a;

        @Override // com.google.common.collect.Interner
        public Object intern(Object obj) {
            Object key;
            do {
                v.h hVarF = this.a.f(obj);
                if (hVarF != null && (key = hVarF.getKey()) != null) {
                    return key;
                }
            } while (((MapMaker.a) this.a.putIfAbsent(obj, MapMaker.a.VALUE)) != null);
            return obj;
        }

        public c(MapMaker mapMaker) {
            this.a = v.e(mapMaker.keyEquivalence(Equivalence.equals()));
        }
    }

    private Interners() {
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new b((Interner) Preconditions.checkNotNull(interner));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder();
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
