package defpackage;

import com.google.api.client.http.HttpMethods;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: sL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3873sL {
    public final C0779Nr a;
    public final String b;
    public final C3994tr c;
    public final AbstractC3954tL d;
    public final Map e;
    public C3290l9 f;

    public C3873sL(C0779Nr c0779Nr, String str, C3994tr c3994tr, AbstractC3954tL abstractC3954tL, Map map) {
        AbstractC4492zt.h(c0779Nr, "url");
        AbstractC4492zt.h(str, "method");
        AbstractC4492zt.h(c3994tr, "headers");
        AbstractC4492zt.h(map, "tags");
        this.a = c0779Nr;
        this.b = str;
        this.c = c3994tr;
        this.d = abstractC3954tL;
        this.e = map;
    }

    public final AbstractC3954tL a() {
        return this.d;
    }

    public final C3290l9 b() {
        C3290l9 c3290l9 = this.f;
        if (c3290l9 != null) {
            return c3290l9;
        }
        C3290l9 c3290l9B = C3290l9.n.b(this.c);
        this.f = c3290l9B;
        return c3290l9B;
    }

    public final Map c() {
        return this.e;
    }

    public final String d(String str) {
        AbstractC4492zt.h(str, "name");
        return this.c.a(str);
    }

    public final C3994tr e() {
        return this.c;
    }

    public final boolean f() {
        return this.a.i();
    }

    public final String g() {
        return this.b;
    }

    public final a h() {
        return new a(this);
    }

    public final C0779Nr i() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        if (this.c.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC1886cc.w();
                }
                C2020dG c2020dG = (C2020dG) obj;
                String str = (String) c2020dG.a();
                String str2 = (String) c2020dG.b();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.e.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.e);
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: sL$a */
    public static class a {
        public C0779Nr a;
        public String b;
        public C3994tr.a c;
        public AbstractC3954tL d;
        public Map e;

        public a() {
            this.e = new LinkedHashMap();
            this.b = HttpMethods.GET;
            this.c = new C3994tr.a();
        }

        public a a(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            this.c.a(str, str2);
            return this;
        }

        public C3873sL b() {
            C0779Nr c0779Nr = this.a;
            if (c0779Nr != null) {
                return new C3873sL(c0779Nr, this.b, this.c.d(), this.d, AbstractC3724qX.V(this.e));
            }
            throw new IllegalStateException("url == null");
        }

        public a c(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            this.c.g(str, str2);
            return this;
        }

        public a d(C3994tr c3994tr) {
            AbstractC4492zt.h(c3994tr, "headers");
            this.c = c3994tr.c();
            return this;
        }

        public a e(String str, AbstractC3954tL abstractC3954tL) {
            AbstractC4492zt.h(str, "method");
            if (str.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (abstractC3954tL == null) {
                if (C0702Kr.d(str)) {
                    throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                }
            } else if (!C0702Kr.a(str)) {
                throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
            }
            this.b = str;
            this.d = abstractC3954tL;
            return this;
        }

        public a f(String str) {
            AbstractC4492zt.h(str, "name");
            this.c.f(str);
            return this;
        }

        public a g(C0779Nr c0779Nr) {
            AbstractC4492zt.h(c0779Nr, "url");
            this.a = c0779Nr;
            return this;
        }

        public a h(String str) {
            AbstractC4492zt.h(str, "url");
            if (AbstractC3880sS.z(str, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String strSubstring = str.substring(3);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                str = sb.toString();
            } else if (AbstractC3880sS.z(str, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String strSubstring2 = str.substring(4);
                AbstractC4492zt.g(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                str = sb2.toString();
            }
            return g(C0779Nr.k.d(str));
        }

        public a(C3873sL c3873sL) {
            Map mapV;
            AbstractC4492zt.h(c3873sL, "request");
            this.e = new LinkedHashMap();
            this.a = c3873sL.i();
            this.b = c3873sL.g();
            this.d = c3873sL.a();
            if (c3873sL.c().isEmpty()) {
                mapV = new LinkedHashMap();
            } else {
                mapV = AbstractC4243wx.v(c3873sL.c());
            }
            this.e = mapV;
            this.c = c3873sL.e().c();
        }
    }
}
