package defpackage;

/* JADX INFO: renamed from: wR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4203wR extends C1763b4 {
    public static final a j = new a(null);
    public final Class h;
    public final Class i;

    /* JADX INFO: renamed from: wR$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ WQ b(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final WQ a(String str) {
            AbstractC4492zt.h(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                AbstractC4492zt.f(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                AbstractC4492zt.f(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                AbstractC4492zt.g(cls3, "paramsClass");
                return new C4203wR(cls, cls2, cls3);
            } catch (Exception e) {
                EG.a.g().j("unable to load android socket classes", 5, e);
                return null;
            }
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4203wR(Class cls, Class cls2, Class cls3) {
        super(cls);
        AbstractC4492zt.h(cls, "sslSocketClass");
        AbstractC4492zt.h(cls2, "sslSocketFactoryClass");
        AbstractC4492zt.h(cls3, "paramClass");
        this.h = cls2;
        this.i = cls3;
    }
}
