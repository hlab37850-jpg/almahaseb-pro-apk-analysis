package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.MV;
import defpackage.PV;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeToken<T> extends MV implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private transient TypeResolver covariantTypeResolver;
    private transient TypeResolver invariantTypeResolver;
    private final Type runtimeType;

    public class a extends Invokable.b {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(super.getGenericExceptionTypes());
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(super.getGenericParameterTypes());
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            return TypeToken.this.getCovariantTypeResolver().resolveType(super.getGenericReturnType());
        }

        @Override // com.google.common.reflect.Invokable
        public TypeToken getOwnerType() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            String strValueOf = String.valueOf(getOwnerType());
            String string = super.toString();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(string).length());
            sb.append(strValueOf);
            sb.append(".");
            sb.append(string);
            return sb.toString();
        }
    }

    public class b extends Invokable.a {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] getGenericExceptionTypes() {
            return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(super.getGenericExceptionTypes());
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] getGenericParameterTypes() {
            return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(super.getGenericParameterTypes());
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type getGenericReturnType() {
            return TypeToken.this.getCovariantTypeResolver().resolveType(super.getGenericReturnType());
        }

        @Override // com.google.common.reflect.Invokable
        public TypeToken getOwnerType() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            String strValueOf = String.valueOf(getOwnerType());
            String strJoin = Joiner.on(", ").join(getGenericParameterTypes());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2 + String.valueOf(strJoin).length());
            sb.append(strValueOf);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            return sb.toString();
        }
    }

    public class c extends PV {
        public c() {
        }

        @Override // defpackage.PV
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // defpackage.PV
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // defpackage.PV
        public void e(TypeVariable typeVariable) {
            String strValueOf = String.valueOf(TypeToken.this.runtimeType);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 58);
            sb.append(strValueOf);
            sb.append("contains a type variable and is not safe for the operation");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // defpackage.PV
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    public class d extends PV {
        public final /* synthetic */ ImmutableSet.Builder b;

        public d(TypeToken typeToken, ImmutableSet.Builder builder) {
            this.b = builder;
        }

        @Override // defpackage.PV
        public void b(Class cls) {
            this.b.add(cls);
        }

        @Override // defpackage.PV
        public void c(GenericArrayType genericArrayType) {
            this.b.add(com.google.common.reflect.a.h(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // defpackage.PV
        public void d(ParameterizedType parameterizedType) {
            this.b.add((Class) parameterizedType.getRawType());
        }

        @Override // defpackage.PV
        public void e(TypeVariable typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // defpackage.PV
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static class e {
        public final Type[] a;
        public final boolean b;

        public e(Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        public boolean a(Type type) {
            for (Type type2 : this.a) {
                boolean zIsSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.b;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }

        public boolean b(Type type) {
            TypeToken<?> typeTokenOf = TypeToken.of(type);
            for (Type type2 : this.a) {
                boolean zIsSubtypeOf = typeTokenOf.isSubtypeOf(type2);
                boolean z = this.b;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }
    }

    public final class f extends TypeSet {
        public transient ImmutableSet a;

        public f() {
            super();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set rawTypes() {
            return ImmutableSet.copyOf((Collection) i.b.a().c(TypeToken.this.getRawTypes()));
        }

        public /* synthetic */ f(TypeToken typeToken, a aVar) {
            this();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            ImmutableSet immutableSet = this.a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet set = FluentIterable.from(i.a.a().d(TypeToken.this)).filter(j.a).toSet();
            this.a = set;
            return set;
        }
    }

    public static final class h extends TypeToken {
        public h(Type type) {
            super(type, null);
        }
    }

    public static abstract class i {
        public static final i a = new a();
        public static final i b = new b();

        public class a extends i {
            public a() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable e(TypeToken typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class f(TypeToken typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken g(TypeToken typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        public class b extends i {
            public b() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable e(Class cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class f(Class cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.i
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class g(Class cls) {
                return cls.getSuperclass();
            }
        }

        public class c extends e {
            public c(i iVar, i iVar2) {
                super(iVar2);
            }

            @Override // com.google.common.reflect.TypeToken.i
            public ImmutableList c(Iterable iterable) {
                ImmutableList.Builder builder = ImmutableList.builder();
                for (T t : iterable) {
                    if (!f(t).isInterface()) {
                        builder.add(t);
                    }
                }
                return super.c(builder.build());
            }

            @Override // com.google.common.reflect.TypeToken.i
            public Iterable e(Object obj) {
                return ImmutableSet.of();
            }
        }

        public class d extends Ordering {
            public final /* synthetic */ Comparator a;
            public final /* synthetic */ Map b;

            public d(Comparator comparator, Map map) {
                this.a = comparator;
                this.b = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(Object obj, Object obj2) {
                Comparator comparator = this.a;
                Object obj3 = this.b.get(obj);
                Objects.requireNonNull(obj3);
                Object obj4 = this.b.get(obj2);
                Objects.requireNonNull(obj4);
                return comparator.compare(obj3, obj4);
            }
        }

        public static class e extends i {
            public final i c;

            public e(i iVar) {
                super(null);
                this.c = iVar;
            }

            @Override // com.google.common.reflect.TypeToken.i
            public Class f(Object obj) {
                return this.c.f(obj);
            }

            @Override // com.google.common.reflect.TypeToken.i
            public Object g(Object obj) {
                return this.c.g(obj);
            }
        }

        public i() {
        }

        public static ImmutableList h(Map map, Comparator comparator) {
            return new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final i a() {
            return new c(this, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int b(Object obj, Map map) {
            Integer num = (Integer) map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(obj).isInterface();
            Iterator<T> it = e(obj).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            Object objG = g(obj);
            int iMax2 = iMax;
            if (objG != null) {
                iMax2 = Math.max(iMax, b(objG, map));
            }
            int i = iMax2 + 1;
            map.put(obj, Integer.valueOf(i));
            return i;
        }

        public ImmutableList c(Iterable iterable) {
            HashMap mapNewHashMap = Maps.newHashMap();
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapNewHashMap);
            }
            return h(mapNewHashMap, Ordering.natural().reverse());
        }

        public final ImmutableList d(Object obj) {
            return c(ImmutableList.of(obj));
        }

        public abstract Iterable e(Object obj);

        public abstract Class f(Object obj);

        public abstract Object g(Object obj);

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class j implements Predicate {
        public static final j a = new a("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
        public static final j b = new b("INTERFACE_ONLY", 1);
        public static final /* synthetic */ j[] c = a();

        public final enum a extends j {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(TypeToken typeToken) {
                return ((typeToken.runtimeType instanceof TypeVariable) || (typeToken.runtimeType instanceof WildcardType)) ? false : true;
            }
        }

        public final enum b extends j {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(TypeToken typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }

        public j(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ j[] a() {
            return new j[]{a, b};
        }

        public static j valueOf(String str) {
            return (j) Enum.valueOf(j.class, str);
        }

        public static j[] values() {
            return (j[]) c.clone();
        }

        public /* synthetic */ j(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.getRawType().isInterface()) {
                builder.add(typeTokenOf);
            }
        }
        return builder.build();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? canonicalizeWildcardType(typeVariable, (WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new com.google.common.reflect.a.i(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            actualTypeArguments[i2] = canonicalizeTypeArg(typeParameters[i2], actualTypeArguments[i2]);
        }
        return com.google.common.reflect.a.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? com.google.common.reflect.a.j(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" does not appear to be a subtype of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 23 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a super type of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeResolver getCovariantTypeResolver() {
        TypeResolver typeResolver = this.covariantTypeResolver;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver typeResolverCovariantly = TypeResolver.covariantly(this.runtimeType);
        this.covariantTypeResolver = typeResolverCovariantly;
        return typeResolverCovariantly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeResolver getInvariantTypeResolver() {
        TypeResolver typeResolver = this.invariantTypeResolver;
        if (typeResolver != null) {
            return typeResolver;
        }
        TypeResolver typeResolverInvariantly = TypeResolver.invariantly(this.runtimeType);
        this.invariantTypeResolver = typeResolverInvariantly;
        return typeResolverInvariantly;
    }

    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        new d(this, builder).a(this.runtimeType);
        return builder.build();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 21 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a subclass of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) typeTokenOf.getSupertype(cls);
            }
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 23 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a super type of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType wildcardTypeCanonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        return every(wildcardTypeCanonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(wildcardTypeCanonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < typeParameters.length; i2++) {
            if (!of(getCovariantTypeResolver().resolveType(typeParameters[i2])).is(actualTypeArguments[i2], typeParameters[i2])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return com.google.common.reflect.a.d.b.c(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new h(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> typeTokenOf = of(getCovariantTypeResolver().resolveType(type));
        typeTokenOf.covariantTypeResolver = this.covariantTypeResolver;
        typeTokenOf.invariantTypeResolver = this.invariantTypeResolver;
        return typeTokenOf;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new TypeResolver().where(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        UnmodifiableIterator<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(com.google.common.reflect.a.j(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(com.google.common.reflect.a.m(type, cls, typeParameters)) : of((Class) cls);
    }

    @Beta
    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type typeI = com.google.common.reflect.a.i(this.runtimeType);
        if (typeI == null) {
            return null;
        }
        return of(typeI);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.add(resolveSupertype(type2));
        }
        return builder.build();
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        Preconditions.checkArgument(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    @Beta
    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return of(getInvariantTypeResolver().resolveType(type));
    }

    public String toString() {
        return com.google.common.reflect.a.s(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(Primitives.unwrap((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new h(new TypeResolver().where(ImmutableMap.of(new TypeResolver.d(typeParameter.typeVariable), typeToken.runtimeType)).resolveType(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(Primitives.wrap((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new TypeResolver().resolveType(this.runtimeType));
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new f(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new g(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) i.b.c(TypeToken.this.getRawTypes()));
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(i.a.d(TypeToken.this)).filter(j.a).toSet();
            this.types = set;
            return set;
        }
    }

    public final class g extends TypeSet {
        public final transient TypeSet a;
        public transient ImmutableSet b;

        public g(TypeSet typeSet) {
            super();
            this.a = typeSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set rawTypes() {
            return FluentIterable.from(i.b.c(TypeToken.this.getRawTypes())).filter(new Predicate() { // from class: OV
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            ImmutableSet immutableSet = this.b;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet set = FluentIterable.from(this.a).filter(j.b).toSet();
            this.b = set;
            return set;
        }
    }

    public TypeToken() {
        Type typeCapture = capture();
        this.runtimeType = typeCapture;
        Preconditions.checkState(!(typeCapture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeCapture);
    }

    public static TypeToken<?> of(Type type) {
        return new h(type);
    }

    public final boolean isSubtypeOf(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> cls) {
        Type typeCapture = super.capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = TypeResolver.covariantly(cls).resolveType(typeCapture);
        }
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.checkNotNull(type);
    }
}
