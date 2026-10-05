package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.itextpdf.xmp.XMPConst;
import defpackage.MV;
import defpackage.PV;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final Joiner a = Joiner.on(", ").useForNull("null");

    /* JADX INFO: renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    public class C0257a extends PV {
        public final /* synthetic */ AtomicReference b;

        public C0257a(AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        @Override // defpackage.PV
        public void b(Class cls) {
            this.b.set(cls.getComponentType());
        }

        @Override // defpackage.PV
        public void c(GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        @Override // defpackage.PV
        public void e(TypeVariable typeVariable) {
            this.b.set(a.p(typeVariable.getBounds()));
        }

        @Override // defpackage.PV
        public void f(WildcardType wildcardType) {
            this.b.set(a.p(wildcardType.getUpperBounds()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b {
        public static final b a = new C0258a("OWNED_BY_ENCLOSING_CLASS", 0);
        public static final b b = new c("LOCAL_CLASS_HAS_NO_OWNER", 1);
        public static final /* synthetic */ b[] d = a();
        public static final b c = b();

        /* JADX INFO: renamed from: com.google.common.reflect.a$b$a, reason: collision with other inner class name */
        public final enum C0258a extends b {
            public C0258a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.b
            public Class c(Class cls) {
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.a$b$b, reason: collision with other inner class name */
        public class C0259b {
        }

        public final enum c extends b {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.b
            public Class c(Class cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        public class d extends C0259b {
        }

        public b(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b b() {
            new d();
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (b bVar : values()) {
                if (bVar.c(C0259b.class) == parameterizedType2.getOwnerType()) {
                    return bVar;
                }
            }
            throw new AssertionError();
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        public abstract Class c(Class cls);

        public /* synthetic */ b(String str, int i, C0257a c0257a) {
            this(str, i);
        }
    }

    public static final class c implements GenericArrayType, Serializable {
        public final Type a;

        public c(Type type) {
            this.a = d.e.h(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.common.base.Objects.equal(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return String.valueOf(a.s(this.a)).concat(XMPConst.ARRAY_ITEM_NAME);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class d {
        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final /* synthetic */ d[] f;

        /* JADX INFO: renamed from: com.google.common.reflect.a$d$a, reason: collision with other inner class name */
        public final enum C0260a extends d {
            public C0260a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.d
            public Type h(Type type) {
                Preconditions.checkNotNull(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new c(cls.getComponentType()) : type;
            }

            @Override // com.google.common.reflect.a.d
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public GenericArrayType c(Type type) {
                return new c(type);
            }
        }

        public final enum b extends d {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.d
            public Type c(Type type) {
                return type instanceof Class ? a.h((Class) type) : new c(type);
            }

            @Override // com.google.common.reflect.a.d
            public Type h(Type type) {
                return (Type) Preconditions.checkNotNull(type);
            }
        }

        public final enum c extends d {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.d
            public Type c(Type type) {
                return d.b.c(type);
            }

            @Override // com.google.common.reflect.a.d
            public String e(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            }

            @Override // com.google.common.reflect.a.d
            public Type h(Type type) {
                return d.b.h(type);
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.a$d$d, reason: collision with other inner class name */
        public final enum C0261d extends d {
            public C0261d(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.a.d
            public boolean b() {
                return false;
            }

            @Override // com.google.common.reflect.a.d
            public Type c(Type type) {
                return d.c.c(type);
            }

            @Override // com.google.common.reflect.a.d
            public String e(Type type) {
                return d.c.e(type);
            }

            @Override // com.google.common.reflect.a.d
            public Type h(Type type) {
                return d.c.h(type);
            }
        }

        public class e extends MV {
        }

        public class f extends MV {
        }

        static {
            C0260a c0260a = new C0260a("JAVA6", 0);
            a = c0260a;
            b bVar = new b("JAVA7", 1);
            b = bVar;
            c cVar = new c("JAVA8", 2);
            c = cVar;
            C0261d c0261d = new C0261d("JAVA9", 3);
            d = c0261d;
            f = a();
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new e().capture().toString().contains("java.util.Map.java.util.Map")) {
                    e = cVar;
                    return;
                } else {
                    e = c0261d;
                    return;
                }
            }
            if (new f().capture() instanceof Class) {
                e = bVar;
            } else {
                e = c0260a;
            }
        }

        public d(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ d[] a() {
            return new d[]{a, b, c, d};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f.clone();
        }

        public boolean b() {
            return true;
        }

        public abstract Type c(Type type);

        public String e(Type type) {
            return a.s(type);
        }

        public final ImmutableList f(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.add(h(type));
            }
            return builder.build();
        }

        public abstract Type h(Type type);

        public /* synthetic */ d(String str, int i, C0257a c0257a) {
            this(str, i);
        }
    }

    public static final class e {
        public static final boolean a = !e.class.getTypeParameters()[0].equals(a.k(e.class, "X", new Type[0]));
    }

    public static final class f implements ParameterizedType, Serializable {
        public final Type a;
        public final ImmutableList b;
        public final Class c;

        public f(Type type, Class cls, Type[] typeArr) {
            Preconditions.checkNotNull(cls);
            Preconditions.checkArgument(typeArr.length == cls.getTypeParameters().length);
            a.f(typeArr, "type parameter");
            this.a = type;
            this.c = cls;
            this.b = d.e.f(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.common.base.Objects.equal(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return a.r(this.b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.c;
        }

        public int hashCode() {
            Type type = this.a;
            return ((type == null ? 0 : type.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                d dVar = d.e;
                if (dVar.b()) {
                    sb.append(dVar.e(this.a));
                    sb.append('.');
                }
            }
            sb.append(this.c.getName());
            sb.append('<');
            Joiner joiner = a.a;
            ImmutableList immutableList = this.b;
            final d dVar2 = d.e;
            Objects.requireNonNull(dVar2);
            sb.append(joiner.join(Iterables.transform(immutableList, new Function() { // from class: iW
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return dVar2.e((Type) obj);
                }
            })));
            sb.append('>');
            return sb.toString();
        }
    }

    public static final class g {
        public final GenericDeclaration a;
        public final String b;
        public final ImmutableList c;

        public g(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
            a.f(typeArr, "bound for type variable");
            this.a = (GenericDeclaration) Preconditions.checkNotNull(genericDeclaration);
            this.b = (String) Preconditions.checkNotNull(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        public GenericDeclaration a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (!e.a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof h)) {
                return false;
            }
            g gVar = ((h) Proxy.getInvocationHandler(obj)).a;
            return this.b.equals(gVar.b()) && this.a.equals(gVar.a()) && this.c.equals(gVar.c);
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    public static final class h implements InvocationHandler {
        public static final ImmutableMap b;
        public final g a;

        static {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (Method method : g.class.getMethods()) {
                if (method.getDeclaringClass().equals(g.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.put(method.getName(), method);
                }
            }
            b = builder.buildKeepingLast();
        }

        public h(g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = (Method) b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.a, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    public static final class i implements WildcardType, Serializable {
        public final ImmutableList a;
        public final ImmutableList b;

        public i(Type[] typeArr, Type[] typeArr2) {
            a.f(typeArr, "lower bound for wildcard");
            a.f(typeArr2, "upper bound for wildcard");
            d dVar = d.e;
            this.a = dVar.f(typeArr);
            this.b = dVar.f(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.b.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return a.r(this.a);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return a.r(this.b);
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableIterator it = this.a.iterator();
            while (it.hasNext()) {
                Type type = (Type) it.next();
                sb.append(" super ");
                sb.append(d.e.e(type));
            }
            for (Type type2 : a.g(this.b)) {
                sb.append(" extends ");
                sb.append(d.e.e(type2));
            }
            return sb.toString();
        }
    }

    public static void f(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                Preconditions.checkArgument(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    public static Iterable g(Iterable iterable) {
        return Iterables.filter(iterable, Predicates.not(Predicates.equalTo(Object.class)));
    }

    public static Class h(Class cls) {
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    public static Type i(Type type) {
        Preconditions.checkNotNull(type);
        AtomicReference atomicReference = new AtomicReference();
        new C0257a(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    public static Type j(Type type) {
        if (!(type instanceof WildcardType)) {
            return d.e.c(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return q(j(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        Preconditions.checkArgument(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return o(j(upperBounds[0]));
    }

    public static TypeVariable k(GenericDeclaration genericDeclaration, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(genericDeclaration, str, typeArr);
    }

    public static ParameterizedType l(Class cls, Type... typeArr) {
        return new f(b.c.c(cls), cls, typeArr);
    }

    public static ParameterizedType m(Type type, Class cls, Type... typeArr) {
        if (type == null) {
            return l(cls, typeArr);
        }
        Preconditions.checkNotNull(typeArr);
        Preconditions.checkArgument(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new f(type, cls, typeArr);
    }

    public static TypeVariable n(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new h(new g(genericDeclaration, str, typeArr)));
    }

    public static WildcardType o(Type type) {
        return new i(new Type[0], new Type[]{type});
    }

    public static Type p(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeI = i(type);
            if (typeI != null) {
                if (typeI instanceof Class) {
                    Class cls = (Class) typeI;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(typeI);
            }
        }
        return null;
    }

    public static WildcardType q(Type type) {
        return new i(new Type[]{type}, new Type[]{Object.class});
    }

    public static Type[] r(Collection collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
