package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import defpackage.AG;
import defpackage.YD;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
public final class Suppliers {

    public static class a implements Supplier, Serializable {
        public final Supplier a;
        public final long b;
        public volatile transient Object c;
        public volatile transient long d;

        public a(Supplier supplier, long j, TimeUnit timeUnit) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
            this.b = timeUnit.toNanos(j);
            Preconditions.checkArgument(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            long j = this.d;
            long jI = AG.i();
            if (j == 0 || jI - j >= 0) {
                synchronized (this) {
                    try {
                        if (j == this.d) {
                            Object obj = this.a.get();
                            this.c = obj;
                            long j2 = jI + this.b;
                            if (j2 == 0) {
                                j2 = 1;
                            }
                            this.d = j2;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return YD.a(this.c);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            long j = this.b;
            StringBuilder sb = new StringBuilder(strValueOf.length() + 62);
            sb.append("Suppliers.memoizeWithExpiration(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(j);
            sb.append(", NANOS)");
            return sb.toString();
        }
    }

    public static class b implements Supplier, Serializable {
        public final Supplier a;
        public volatile transient boolean b;
        public transient Object c;

        public b(Supplier supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            if (!this.b) {
                synchronized (this) {
                    try {
                        if (!this.b) {
                            Object obj = this.a.get();
                            this.c = obj;
                            this.b = true;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return YD.a(this.c);
        }

        public String toString() {
            Object string;
            if (this.b) {
                String strValueOf = String.valueOf(this.c);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(strValueOf);
                sb.append(">");
                string = sb.toString();
            } else {
                string = this.a;
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(strValueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class c implements Supplier {
        public volatile Supplier a;
        public volatile boolean b;
        public Object c;

        public c(Supplier supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            if (!this.b) {
                synchronized (this) {
                    try {
                        if (!this.b) {
                            Supplier supplier = this.a;
                            java.util.Objects.requireNonNull(supplier);
                            Object obj = supplier.get();
                            this.c = obj;
                            this.b = true;
                            this.a = null;
                            return obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return YD.a(this.c);
        }

        public String toString() {
            Object string = this.a;
            if (string == null) {
                String strValueOf = String.valueOf(this.c);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(strValueOf);
                sb.append(">");
                string = sb.toString();
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(strValueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class d implements Supplier, Serializable {
        public final Function a;
        public final Supplier b;

        public d(Function function, Supplier supplier) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a.equals(dVar.a) && this.b.equals(dVar.b);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return this.a.apply(this.b.get());
        }

        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 21 + strValueOf2.length());
            sb.append("Suppliers.compose(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public enum e implements Function {
        INSTANCE;

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object apply(Supplier supplier) {
            return supplier.get();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    public static class f implements Supplier, Serializable {
        public final Object a;

        public f(Object obj) {
            this.a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return Objects.equal(this.a, ((f) obj).a);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return this.a;
        }

        public int hashCode() {
            return Objects.hashCode(this.a);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class g implements Supplier, Serializable {
        public final Supplier a;

        public g(Supplier supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            Object obj;
            synchronized (this.a) {
                obj = this.a.get();
            }
            return obj;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Suppliers.synchronizedSupplier(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new d(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if ((supplier instanceof c) || (supplier instanceof b)) {
            return supplier;
        }
        return supplier instanceof Serializable ? new b(supplier) : new c(supplier);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j, TimeUnit timeUnit) {
        return new a(supplier, j, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(T t) {
        return new f(t);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return e.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new g(supplier);
    }
}
