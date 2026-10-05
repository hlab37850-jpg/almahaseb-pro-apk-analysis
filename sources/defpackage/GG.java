package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GG {

    public static final class a {
        public static final a a = new a();
        public static final Method b;
        public static final Method c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            AbstractC4492zt.e(methods);
            int length = methods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i];
                if (AbstractC4492zt.d(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    AbstractC4492zt.g(parameterTypes, "getParameterTypes(...)");
                    if (AbstractC4492zt.d(R5.d0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i++;
            }
            b = method2;
            for (Method method3 : methods) {
                if (AbstractC4492zt.d(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            c = method;
        }
    }

    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        AbstractC4492zt.h(th, "cause");
        AbstractC4492zt.h(th2, "exception");
        Method method = a.b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public AbstractC3465nJ b() {
        return new C2388hm();
    }
}
