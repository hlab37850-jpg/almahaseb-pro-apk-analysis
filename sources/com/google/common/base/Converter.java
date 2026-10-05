package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import defpackage.YD;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @RetainedWith
    @LazyInit
    private transient Converter<B, A> reverse;

    public class a implements Iterable {
        public final /* synthetic */ Iterable a;

        /* JADX INFO: renamed from: com.google.common.base.Converter$a$a, reason: collision with other inner class name */
        public class C0203a implements Iterator {
            public final Iterator a;

            public C0203a() {
                this.a = a.this.a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public Object next() {
                return Converter.this.convert(this.a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
            }
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new C0203a();
        }
    }

    public static final class b extends Converter implements Serializable {
        public final Converter a;
        public final Converter b;

        public b(Converter converter, Converter converter2) {
            this.a = converter;
            this.b = converter2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Converter
        public Object correctedDoBackward(Object obj) {
            return this.a.correctedDoBackward(this.b.correctedDoBackward(obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Converter
        public Object correctedDoForward(Object obj) {
            return this.b.correctedDoForward(this.a.correctedDoForward(obj));
        }

        @Override // com.google.common.base.Converter
        public Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && this.b.equals(bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 10 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append(".andThen(");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c extends Converter implements Serializable {
        public final Function a;
        public final Function b;

        public /* synthetic */ c(Function function, Function function2, a aVar) {
            this(function, function2);
        }

        @Override // com.google.common.base.Converter
        public Object doBackward(Object obj) {
            return this.b.apply(obj);
        }

        @Override // com.google.common.base.Converter
        public Object doForward(Object obj) {
            return this.a.apply(obj);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 18 + strValueOf2.length());
            sb.append("Converter.from(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }

        public c(Function function, Function function2) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Function) Preconditions.checkNotNull(function2);
        }
    }

    public static final class d extends Converter implements Serializable {
        public static final d a = new d();

        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d reverse() {
            return this;
        }

        @Override // com.google.common.base.Converter
        public Converter doAndThen(Converter converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public Object doBackward(Object obj) {
            return obj;
        }

        @Override // com.google.common.base.Converter
        public Object doForward(Object obj) {
            return obj;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    public static final class e extends Converter implements Serializable {
        public final Converter a;

        public e(Converter converter) {
            this.a = converter;
        }

        @Override // com.google.common.base.Converter
        public Object correctedDoBackward(Object obj) {
            return this.a.correctedDoForward(obj);
        }

        @Override // com.google.common.base.Converter
        public Object correctedDoForward(Object obj) {
            return this.a.correctedDoBackward(obj);
        }

        @Override // com.google.common.base.Converter
        public Object doBackward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public Object doForward(Object obj) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.a.equals(((e) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.a.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter reverse() {
            return this.a;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 10);
            sb.append(strValueOf);
            sb.append(".reverse()");
            return sb.toString();
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new c(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return d.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private A unsafeDoBackward(B b2) {
        return (A) doBackward(YD.a(b2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private B unsafeDoForward(A a2) {
        return (B) doForward(YD.a(a2));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a2) {
        return convert(a2);
    }

    @CanIgnoreReturnValue
    public final B convert(A a2) {
        return correctedDoForward(a2);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new a(iterable);
    }

    public A correctedDoBackward(B b2) {
        if (!this.handleNullAutomatically) {
            return unsafeDoBackward(b2);
        }
        if (b2 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b2));
    }

    public B correctedDoForward(A a2) {
        if (!this.handleNullAutomatically) {
            return unsafeDoForward(a2);
        }
        if (a2 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a2));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new b(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @ForOverride
    public abstract A doBackward(B b2);

    @ForOverride
    public abstract B doForward(A a2);

    @Override // com.google.common.base.Function
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        e eVar = new e(this);
        this.reverse = eVar;
        return eVar;
    }

    public Converter(boolean z) {
        this.handleNullAutomatically = z;
    }
}
