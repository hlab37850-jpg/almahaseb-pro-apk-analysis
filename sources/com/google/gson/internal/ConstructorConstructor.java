package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public class a implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new TreeSet();
        }
    }

    public class b implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new LinkedHashSet();
        }
    }

    public class c implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new ArrayDeque();
        }
    }

    public class d implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new ArrayList();
        }
    }

    public class e implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new ConcurrentSkipListMap();
        }
    }

    public class f implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new ConcurrentHashMap();
        }
    }

    public class g implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new TreeMap();
        }
    }

    public class h implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new LinkedHashMap();
        }
    }

    public class i implements ObjectConstructor {
        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return new LinkedTreeMap();
        }
    }

    public class j implements ObjectConstructor {
        public final UnsafeAllocator a = UnsafeAllocator.create();
        public final /* synthetic */ Class b;

        public j(Class cls) {
            this.b = cls;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            try {
                return this.a.newInstance(this.b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.b + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    public class k implements ObjectConstructor {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public k(InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return this.a.createInstance(this.b);
        }
    }

    public class l implements ObjectConstructor {
        public final /* synthetic */ String a;

        public l(String str) {
            this.a = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            throw new JsonIOException(this.a);
        }
    }

    public class m implements ObjectConstructor {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public m(InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            return this.a.createInstance(this.b);
        }
    }

    public class n implements ObjectConstructor {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            throw new JsonIOException(this.a);
        }
    }

    public class o implements ObjectConstructor {
        public final /* synthetic */ String a;

        public o(String str) {
            this.a = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            throw new JsonIOException(this.a);
        }
    }

    public class p implements ObjectConstructor {
        public final /* synthetic */ Type a;

        public p(Type type) {
            this.a = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    public class q implements ObjectConstructor {
        public final /* synthetic */ Type a;

        public q(Type type) {
            this.a = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
        }
    }

    public class r implements ObjectConstructor {
        public final /* synthetic */ String a;

        public r(String str) {
            this.a = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            throw new JsonIOException(this.a);
        }
    }

    public class s implements ObjectConstructor {
        public final /* synthetic */ String a;

        public s(String str) {
            this.a = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            throw new JsonIOException(this.a);
        }
    }

    public class t implements ObjectConstructor {
        public final /* synthetic */ Constructor a;

        public t(Constructor constructor) {
            this.a = constructor;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public Object construct() {
            try {
                return this.a.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3.getTargetException());
            }
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
        this.reflectionFilters = list;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String strTryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult == filterResult2 || (ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (filterResult != filterResult2 || (strTryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) == null) ? new t(declaredConstructor) : new s(strTryMakeAccessible);
            }
            return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new i() : new h();
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new k(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new m(instanceCreator2, type);
        }
        ObjectConstructor<T> objectConstructorNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (objectConstructorNewSpecialCollectionConstructor != null) {
            return objectConstructorNewSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (objectConstructorNewDefaultImplementationConstructor != null) {
            return objectConstructorNewDefaultImplementationConstructor;
        }
        String strCheckInstantiable = UnsafeAllocator.checkInstantiable(rawType);
        if (strCheckInstantiable != null) {
            return new n(strCheckInstantiable);
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
