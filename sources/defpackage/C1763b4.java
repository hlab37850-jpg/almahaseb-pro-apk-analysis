package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: b4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1763b4 implements WQ {
    public static final a f;
    public static final C0961Ui.a g;
    public final Class a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Method e;

    /* JADX INFO: renamed from: b4$a */
    public static final class a {

        /* JADX INFO: renamed from: b4$a$a, reason: collision with other inner class name */
        public static final class C0165a implements C0961Ui.a {
            public final /* synthetic */ String a;

            public C0165a(String str) {
                this.a = str;
            }

            @Override // defpackage.C0961Ui.a
            public boolean a(SSLSocket sSLSocket) {
                AbstractC4492zt.h(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                AbstractC4492zt.g(name, "sslSocket.javaClass.name");
                return AbstractC3880sS.B(name, this.a + '.', false, 2, null);
            }

            @Override // defpackage.C0961Ui.a
            public WQ b(SSLSocket sSLSocket) {
                AbstractC4492zt.h(sSLSocket, "sslSocket");
                return C1763b4.f.b(sSLSocket.getClass());
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C1763b4 b(Class cls) {
            Class superclass = cls;
            while (superclass != null && !AbstractC4492zt.d(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            AbstractC4492zt.e(superclass);
            return new C1763b4(superclass);
        }

        public final C0961Ui.a c(String str) {
            AbstractC4492zt.h(str, "packageName");
            return new C0165a(str);
        }

        public final C0961Ui.a d() {
            return C1763b4.g;
        }

        public a() {
        }
    }

    static {
        a aVar = new a(null);
        f = aVar;
        g = aVar.c("com.google.android.gms.org.conscrypt");
    }

    public C1763b4(Class cls) throws NoSuchMethodException {
        AbstractC4492zt.h(cls, "sslSocketClass");
        this.a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        AbstractC4492zt.g(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.b = declaredMethod;
        this.c = cls.getMethod("setHostname", String.class);
        this.d = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // defpackage.WQ
    public boolean a(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        return this.a.isInstance(sSLSocket);
    }

    @Override // defpackage.WQ
    public String b(SSLSocket sSLSocket) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.d.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, C3809rb.b);
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if ((cause instanceof NullPointerException) && AbstractC4492zt.d(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e2);
        }
    }

    @Override // defpackage.WQ
    public void c(SSLSocket sSLSocket, String str, List list) {
        AbstractC4492zt.h(sSLSocket, "sslSocket");
        AbstractC4492zt.h(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.c.invoke(sSLSocket, str);
                }
                this.e.invoke(sSLSocket, EG.a.c(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // defpackage.WQ
    public boolean isSupported() {
        return W3.f.b();
    }
}
