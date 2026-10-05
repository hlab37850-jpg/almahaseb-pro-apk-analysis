package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: Jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0616Jb {
    public static final a d = new a(null);
    public final Method a;
    public final Method b;
    public final Method c;

    /* JADX INFO: renamed from: Jb$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C0616Jb a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new C0616Jb(method, method3, method2);
        }

        public a() {
        }
    }

    public C0616Jb(Method method, Method method2, Method method3) {
        this.a = method;
        this.b = method2;
        this.c = method3;
    }

    public final Object a(String str) {
        AbstractC4492zt.h(str, "closer");
        Method method = this.a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.b;
                AbstractC4492zt.e(method2);
                method2.invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.c;
            AbstractC4492zt.e(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
