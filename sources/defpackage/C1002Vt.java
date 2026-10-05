package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: Vt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1002Vt extends EG {
    public static final b i = new b(null);
    public final Method d;
    public final Method e;
    public final Method f;
    public final Class g;
    public final Class h;

    /* JADX INFO: renamed from: Vt$a */
    public static final class a implements InvocationHandler {
        public final List a;
        public boolean b;
        public String c;

        public a(List list) {
            AbstractC4492zt.h(list, "protocols");
            this.a = list;
        }

        public final String a() {
            return this.c;
        }

        public final boolean b() {
            return this.b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            AbstractC4492zt.h(obj, "proxy");
            AbstractC4492zt.h(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (AbstractC4492zt.d(name, "supports") && AbstractC4492zt.d(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (AbstractC4492zt.d(name, "unsupported") && AbstractC4492zt.d(Void.TYPE, returnType)) {
                this.b = true;
                return null;
            }
            if (AbstractC4492zt.d(name, "protocols") && objArr.length == 0) {
                return this.a;
            }
            if ((AbstractC4492zt.d(name, "selectProtocol") || AbstractC4492zt.d(name, HTML.Tag.SELECT)) && AbstractC4492zt.d(String.class, returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj3 = list.get(i);
                            AbstractC4492zt.f(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj3;
                            if (this.a.contains(str)) {
                                this.c = str;
                                return str;
                            }
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    String str2 = (String) this.a.get(0);
                    this.c = str2;
                    return str2;
                }
            }
            if ((!AbstractC4492zt.d(name, "protocolSelected") && !AbstractC4492zt.d(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            AbstractC4492zt.f(obj4, "null cannot be cast to non-null type kotlin.String");
            this.c = (String) obj4;
            return null;
        }
    }

    /* JADX INFO: renamed from: Vt$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final EG a() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                AbstractC4492zt.g(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                AbstractC4492zt.g(method, "putMethod");
                AbstractC4492zt.g(method2, "getMethod");
                AbstractC4492zt.g(method3, "removeMethod");
                AbstractC4492zt.g(cls3, "clientProviderClass");
                AbstractC4492zt.g(cls4, "serverProviderClass");
                return new C1002Vt(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public b() {
        }
    }

    public C1002Vt(Method method, Method method2, Method method3, Class cls, Class cls2) {
        AbstractC4492zt.h(method, "putMethod");
        AbstractC4492zt.h(method2, "getMethod");
        AbstractC4492zt.h(method3, "removeMethod");
        AbstractC4492zt.h(cls, "clientProviderClass");
        AbstractC4492zt.h(cls2, "serverProviderClass");
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }

    @Override // defpackage.EG
    public void b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        try {
            this.f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // defpackage.EG
    public void e(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        try {
            this.d.invoke(null, sSLSocket, Proxy.newProxyInstance(EG.class.getClassLoader(), new Class[]{this.g, this.h}, new a(EG.a.b(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // defpackage.EG
    public String g(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.e.invoke(null, sSLSocket));
            AbstractC4492zt.f(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            a aVar = (a) invocationHandler;
            if (!aVar.b() && aVar.a() == null) {
                EG.k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.b()) {
                return null;
            }
            return aVar.a();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
