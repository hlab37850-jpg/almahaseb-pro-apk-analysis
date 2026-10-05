package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import defpackage.AG;
import defpackage.AbstractC0714Ld;
import defpackage.C1748au;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true)
public final class Predicates {

    public static class b implements Predicate, Serializable {
        public final List a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i = 0; i < this.a.size(); i++) {
                if (!((Predicate) this.a.get(i)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.toStringHelper("and", this.a);
        }

        public b(List list) {
            this.a = list;
        }
    }

    public static class c implements Predicate, Serializable {
        public final Predicate a;
        public final Function b;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.a.apply(this.b.apply(obj));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.a.equals(cVar.a);
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

        public c(Predicate predicate, Function function) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
            this.b = (Function) Preconditions.checkNotNull(function);
        }
    }

    public static class d extends e {
        public d(String str) {
            super(AG.a(str));
        }

        @Override // com.google.common.base.Predicates.e
        public String toString() {
            String strC = this.a.c();
            StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 28);
            sb.append("Predicates.containsPattern(");
            sb.append(strC);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class e implements Predicate, Serializable {
        public final AbstractC0714Ld a;

        public e(AbstractC0714Ld abstractC0714Ld) {
            this.a = (AbstractC0714Ld) Preconditions.checkNotNull(abstractC0714Ld);
        }

        @Override // com.google.common.base.Predicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(CharSequence charSequence) {
            return this.a.b(charSequence).b();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Objects.equal(this.a.c(), eVar.a.c()) && this.a.a() == eVar.a.a();
        }

        public int hashCode() {
            return Objects.hashCode(this.a.c(), Integer.valueOf(this.a.a()));
        }

        public String toString() {
            String string = MoreObjects.toStringHelper(this.a).add("pattern", this.a.c()).add("pattern.flags", this.a.a()).toString();
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 21);
            sb.append("Predicates.contains(");
            sb.append(string);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class f implements Predicate, Serializable {
        public final Collection a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            try {
                return this.a.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 15);
            sb.append("Predicates.in(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public f(Collection collection) {
            this.a = (Collection) Preconditions.checkNotNull(collection);
        }
    }

    public static class g implements Predicate, Serializable {
        public final Class a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.a.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof g) && this.a == ((g) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String name = this.a.getName();
            StringBuilder sb = new StringBuilder(name.length() + 23);
            sb.append("Predicates.instanceOf(");
            sb.append(name);
            sb.append(")");
            return sb.toString();
        }

        public g(Class cls) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }
    }

    public static class h implements Predicate, Serializable {
        public final Object a;

        public Predicate a() {
            return this;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return this.a.equals(obj);
        }

        @Override // com.google.common.base.Predicate
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
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Predicates.equalTo(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public h(Object obj) {
            this.a = obj;
        }
    }

    public static class i implements Predicate, Serializable {
        public final Predicate a;

        public i(Predicate predicate) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return !this.a.apply(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof i) {
                return this.a.equals(((i) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16);
            sb.append("Predicates.not(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class j implements Predicate {
        public static final j a = new a("ALWAYS_TRUE", 0);
        public static final j b = new b("ALWAYS_FALSE", 1);
        public static final j c = new c("IS_NULL", 2);
        public static final j d = new d("NOT_NULL", 3);
        public static final /* synthetic */ j[] e = a();

        public final enum a extends j {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        public final enum b extends j {
            public b(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        public final enum c extends j {
            public c(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        public final enum d extends j {
            public d(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        public j(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ j[] a() {
            return new j[]{a, b, c, d};
        }

        public static j valueOf(String str) {
            return (j) Enum.valueOf(j.class, str);
        }

        public static j[] values() {
            return (j[]) e.clone();
        }

        public Predicate b() {
            return this;
        }
    }

    public static class k implements Predicate, Serializable {
        public final List a;

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            for (int i = 0; i < this.a.size(); i++) {
                if (((Predicate) this.a.get(i)).apply(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            if (obj instanceof k) {
                return this.a.equals(((k) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.toStringHelper("or", this.a);
        }

        public k(List list) {
            this.a = list;
        }
    }

    public static class l implements Predicate, Serializable {
        public final Class a;

        @Override // com.google.common.base.Predicate
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(Class cls) {
            return this.a.isAssignableFrom(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(Object obj) {
            return (obj instanceof l) && this.a == ((l) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String name = this.a.getName();
            StringBuilder sb = new StringBuilder(name.length() + 22);
            sb.append("Predicates.subtypeOf(");
            sb.append(name);
            sb.append(")");
            return sb.toString();
        }

        public l(Class cls) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }
    }

    private Predicates() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return j.b.b();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return j.a.b();
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new b(defensiveCopy(iterable));
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new c(predicate, function);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new e(new C1748au(pattern));
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String str) {
        return new d(str);
    }

    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    public static <T> Predicate<T> equalTo(T t) {
        return t == null ? isNull() : new h(t).a();
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new f(collection);
    }

    @GwtIncompatible
    public static <T> Predicate<T> instanceOf(Class<?> cls) {
        return new g(cls);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return j.c.b();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new i(predicate);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return j.d.b();
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new k(defensiveCopy(iterable));
    }

    @Beta
    @GwtIncompatible
    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new l(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toStringHelper(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new b(defensiveCopy(predicateArr));
    }

    public static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new k(defensiveCopy(predicateArr));
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new b(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new k(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }
}
