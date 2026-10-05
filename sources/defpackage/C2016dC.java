package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: dC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2016dC {
    public static final C2016dC a = new C2016dC();
    public static final a b = new a(null, null, null);
    public static a c;

    /* JADX INFO: renamed from: dC$a */
    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    public final a a(AbstractC2171f7 abstractC2171f7) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC2171f7.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC2171f7.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }

    public final String b(AbstractC2171f7 abstractC2171f7) {
        AbstractC4492zt.h(abstractC2171f7, "continuation");
        a aVarA = c;
        if (aVarA == null) {
            aVarA = a(abstractC2171f7);
        }
        if (aVarA == b) {
            return null;
        }
        Method method = aVarA.a;
        Object objInvoke = method != null ? method.invoke(abstractC2171f7.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
