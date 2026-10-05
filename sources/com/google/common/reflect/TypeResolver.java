package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import defpackage.PV;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeResolver {
    private final c typeTable;

    public class a extends PV {
        public final /* synthetic */ Map b;
        public final /* synthetic */ Type c;

        public a(Map map, Type type) {
            this.b = map;
            this.c = type;
        }

        @Override // defpackage.PV
        public void b(Class cls) {
            if (this.c instanceof WildcardType) {
                return;
            }
            String strValueOf = String.valueOf(cls);
            String strValueOf2 = String.valueOf(this.c);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25 + strValueOf2.length());
            sb.append("No type mapping from ");
            sb.append(strValueOf);
            sb.append(" to ");
            sb.append(strValueOf2);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // defpackage.PV
        public void c(GenericArrayType genericArrayType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeI = com.google.common.reflect.a.i(type);
            Preconditions.checkArgument(typeI != null, "%s is not an array type.", this.c);
            TypeResolver.populateTypeMappings(this.b, genericArrayType.getGenericComponentType(), typeI);
        }

        @Override // defpackage.PV
        public void d(ParameterizedType parameterizedType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) TypeResolver.expectArgument(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                TypeResolver.populateTypeMappings(this.b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            Preconditions.checkArgument(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                TypeResolver.populateTypeMappings(this.b, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // defpackage.PV
        public void e(TypeVariable typeVariable) {
            this.b.put(new d(typeVariable), this.c);
        }

        @Override // defpackage.PV
        public void f(WildcardType wildcardType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                Preconditions.checkArgument(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.c);
                for (int i = 0; i < upperBounds.length; i++) {
                    TypeResolver.populateTypeMappings(this.b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    TypeResolver.populateTypeMappings(this.b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    public static final class b extends PV {
        public final Map b = Maps.newHashMap();

        public static ImmutableMap g(Type type) {
            Preconditions.checkNotNull(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf(bVar.b);
        }

        @Override // defpackage.PV
        public void b(Class cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // defpackage.PV
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // defpackage.PV
        public void e(TypeVariable typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // defpackage.PV
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = (Type) this.b.remove(d.c(type));
                    }
                    return;
                }
                type2 = (Type) this.b.get(d.c(type2));
            }
            this.b.put(dVar, type);
        }
    }

    public static final class d {
        public final TypeVariable a;

        public d(TypeVariable typeVariable) {
            this.a = (TypeVariable) Preconditions.checkNotNull(typeVariable);
        }

        public static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.a.getGenericDeclaration(), this.a.getName());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public static class e {
        public static final e b = new e();
        public final AtomicInteger a;

        public class a extends e {
            public final /* synthetic */ TypeVariable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.c = typeVariable;
            }

            @Override // com.google.common.reflect.TypeResolver.e
            public TypeVariable b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            Preconditions.checkNotNull(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return com.google.common.reflect.a.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
            }
            return com.google.common.reflect.a.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable b(Type[] typeArr) {
            int iIncrementAndGet = this.a.incrementAndGet();
            String strJoin = Joiner.on('&').join(typeArr);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 33);
            sb.append("capture#");
            sb.append(iIncrementAndGet);
            sb.append("-of ? extends ");
            sb.append(strJoin);
            return com.google.common.reflect.a.k(e.class, sb.toString(), typeArr);
        }

        public final Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable typeVariable) {
            return new a(this, this.a, typeVariable);
        }

        public final e e() {
            return new e(this.a);
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }
    }

    public /* synthetic */ TypeResolver(c cVar, a aVar) {
        this(cVar);
    }

    public static TypeResolver covariantly(Type type) {
        return new TypeResolver().where(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T expectArgument(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            String strValueOf = String.valueOf(obj);
            String simpleName = cls.getSimpleName();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 10 + simpleName.length());
            sb.append(strValueOf);
            sb.append(" is not a ");
            sb.append(simpleName);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static TypeResolver invariantly(Type type) {
        return new TypeResolver().where(b.g(e.b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void populateTypeMappings(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    private Type resolveGenericArrayType(GenericArrayType genericArrayType) {
        return com.google.common.reflect.a.j(resolveType(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return com.google.common.reflect.a.m(ownerType == null ? null : resolveType(ownerType), (Class) resolveType(parameterizedType.getRawType()), resolveTypes(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] resolveTypes(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = resolveType(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType resolveWildcardType(WildcardType wildcardType) {
        return new com.google.common.reflect.a.i(resolveTypes(wildcardType.getLowerBounds()), resolveTypes(wildcardType.getUpperBounds()));
    }

    public Type resolveType(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            return this.typeTable.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return resolveParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return resolveGenericArrayType((GenericArrayType) type);
        }
        return type instanceof WildcardType ? resolveWildcardType((WildcardType) type) : type;
    }

    public Type[] resolveTypesInPlace(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]);
        }
        return typeArr;
    }

    public TypeResolver where(Type type, Type type2) {
        HashMap mapNewHashMap = Maps.newHashMap();
        populateTypeMappings(mapNewHashMap, (Type) Preconditions.checkNotNull(type), (Type) Preconditions.checkNotNull(type2));
        return where(mapNewHashMap);
    }

    public static class c {
        public final ImmutableMap a;

        public class a extends c {
            public final /* synthetic */ TypeVariable b;
            public final /* synthetic */ c c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.b = typeVariable;
                this.c = cVar2;
            }

            @Override // com.google.common.reflect.TypeResolver.c
            public Type b(TypeVariable typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration()) ? typeVariable : this.c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.a = ImmutableMap.of();
        }

        public final Type a(TypeVariable typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        public Type b(TypeVariable typeVariable, c cVar) {
            Type type = (Type) this.a.get(new d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new TypeResolver(cVar, aVar).resolveType(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] typeArrResolveTypes = new TypeResolver(cVar, aVar).resolveTypes(bounds);
            return (com.google.common.reflect.a.e.a && Arrays.equals(bounds, typeArrResolveTypes)) ? typeVariable : com.google.common.reflect.a.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrResolveTypes);
        }

        public final c c(Map map) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(this.a);
            for (Map.Entry entry : map.entrySet()) {
                d dVar = (d) entry.getKey();
                Type type = (Type) entry.getValue();
                Preconditions.checkArgument(!dVar.a(type), "Type variable %s bound to itself", dVar);
                builder.put(dVar, type);
            }
            return new c(builder.buildOrThrow());
        }

        public c(ImmutableMap immutableMap) {
            this.a = immutableMap;
        }
    }

    public TypeResolver() {
        this.typeTable = new c();
    }

    private TypeResolver(c cVar) {
        this.typeTable = cVar;
    }

    public TypeResolver where(Map<d, ? extends Type> map) {
        return new TypeResolver(this.typeTable.c(map));
    }
}
