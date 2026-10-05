package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import defpackage.YD;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
public final class Functions {

    public static class b implements Function, Serializable {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.a;
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return Objects.equal(this.a, ((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Functions.constant(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class c implements Function, Serializable {
        public final Map a;
        public final Object b;

        public c(Map map, Object obj) {
            this.a = (Map) Preconditions.checkNotNull(map);
            this.b = obj;
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            Object obj2 = this.a.get(obj);
            return (obj2 != null || this.a.containsKey(obj)) ? YD.a(obj2) : this.b;
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && Objects.equal(this.b, cVar.b);
        }

        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 33 + strValueOf2.length());
            sb.append("Functions.forMap(");
            sb.append(strValueOf);
            sb.append(", defaultValue=");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class d implements Function, Serializable {
        public final Function a;
        public final Function b;

        public d(Function function, Function function2) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.a.apply(this.b.apply(obj));
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.b.equals(dVar.b) && this.a.equals(dVar.a);
        }

        public int hashCode() {
            return this.b.hashCode() ^ this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append("(");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class e implements Function, Serializable {
        public final Map a;

        public e(Map map) {
            this.a = (Map) Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            Object obj2 = this.a.get(obj);
            Preconditions.checkArgument(obj2 != null || this.a.containsKey(obj), "Key '%s' not present in map", obj);
            return YD.a(obj2);
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.a.equals(((e) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
            sb.append("Functions.forMap(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public enum f implements Function {
        INSTANCE;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return obj;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class g implements Function, Serializable {
        public final Predicate a;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Object obj) {
            return Boolean.valueOf(this.a.apply(obj));
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof g) {
                return this.a.equals(((g) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("Functions.forPredicate(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public g(Predicate predicate) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
        }
    }

    public static class h implements Function, Serializable {
        public final Supplier a;

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.a.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof h) {
                return this.a.equals(((h) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("Functions.forSupplier(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public h(Supplier supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }
    }

    public enum i implements Function {
        INSTANCE;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    private Functions() {
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new d(function, function2);
    }

    public static <E> Function<Object, E> constant(E e2) {
        return new b(e2);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new e(map);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new g(predicate);
    }

    public static <F, T> Function<F, T> forSupplier(Supplier<T> supplier) {
        return new h(supplier);
    }

    public static <E> Function<E, E> identity() {
        return f.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return i.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, V v) {
        return new c(map, v);
    }
}
