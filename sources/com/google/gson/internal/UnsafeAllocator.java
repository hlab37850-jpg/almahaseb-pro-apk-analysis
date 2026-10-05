package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UnsafeAllocator {

    public class a extends UnsafeAllocator {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Object b;

        public a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.a.invoke(this.b, cls);
        }
    }

    public class b extends UnsafeAllocator {
        public final /* synthetic */ Method a;
        public final /* synthetic */ int b;

        public b(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    public class c extends UnsafeAllocator {
        public final /* synthetic */ Method a;

        public c(Method method) {
            this.a = method;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.a.invoke(null, cls, Object.class);
        }
    }

    public class d extends UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public Object newInstance(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertInstantiable(Class<?> cls) {
        String strCheckInstantiable = checkInstantiable(cls);
        if (strCheckInstantiable == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strCheckInstantiable);
    }

    public static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    public static UnsafeAllocator create() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new c(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new b(declaredMethod3, iIntValue);
            }
        } catch (Exception unused3) {
            return new d();
        }
    }

    public abstract <T> T newInstance(Class<T> cls);
}
