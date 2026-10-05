package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import defpackage.C3922t;
import defpackage.IH;
import defpackage.S;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(serializable = true)
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static class a implements Iterable {
        public final /* synthetic */ Iterable a;

        /* JADX INFO: renamed from: com.google.api.client.repackaged.com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        public class C0199a extends S {
            public final Iterator c;

            public C0199a() {
                this.c = (Iterator) Preconditions.checkNotNull(a.this.a.iterator());
            }

            @Override // defpackage.S
            public Object a() {
                while (this.c.hasNext()) {
                    Optional optional = (Optional) this.c.next();
                    if (optional.isPresent()) {
                        return optional.get();
                    }
                }
                return b();
            }
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0199a();
        }
    }

    public static <T> Optional<T> absent() {
        return C3922t.a();
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new IH(t);
    }

    public static <T> Optional<T> of(T t) {
        return new IH(Preconditions.checkNotNull(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
