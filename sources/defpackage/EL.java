package defpackage;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class EL implements Closeable {
    public final C3873sL a;
    public final EnumC4356yI b;
    public final String c;
    public final int d;
    public final C2311gr e;
    public final C3994tr f;
    public final FL g;
    public final EL h;
    public final EL i;
    public final EL j;
    public final long k;
    public final long l;
    public final C0799Ol n;
    public C3290l9 p;

    public EL(C3873sL c3873sL, EnumC4356yI enumC4356yI, String str, int i, C2311gr c2311gr, C3994tr c3994tr, FL fl, EL el, EL el2, EL el3, long j, long j2, C0799Ol c0799Ol) {
        AbstractC4492zt.h(c3873sL, "request");
        AbstractC4492zt.h(enumC4356yI, "protocol");
        AbstractC4492zt.h(str, "message");
        AbstractC4492zt.h(c3994tr, "headers");
        this.a = c3873sL;
        this.b = enumC4356yI;
        this.c = str;
        this.d = i;
        this.e = c2311gr;
        this.f = c3994tr;
        this.g = fl;
        this.h = el;
        this.i = el2;
        this.j = el3;
        this.k = j;
        this.l = j2;
        this.n = c0799Ol;
    }

    public static /* synthetic */ String x(EL el, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return el.v(str, str2);
    }

    public final boolean A() {
        int i = this.d;
        return 200 <= i && i < 300;
    }

    public final String C() {
        return this.c;
    }

    public final EL F() {
        return this.h;
    }

    public final a G() {
        return new a(this);
    }

    public final EL H() {
        return this.j;
    }

    public final EnumC4356yI I() {
        return this.b;
    }

    public final long J() {
        return this.l;
    }

    public final C3873sL K() {
        return this.a;
    }

    public final long L() {
        return this.k;
    }

    public final FL c() {
        return this.g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        FL fl = this.g;
        if (fl == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        fl.close();
    }

    public final C3290l9 d() {
        C3290l9 c3290l9 = this.p;
        if (c3290l9 != null) {
            return c3290l9;
        }
        C3290l9 c3290l9B = C3290l9.n.b(this.f);
        this.p = c3290l9B;
        return c3290l9B;
    }

    public final EL g() {
        return this.i;
    }

    public final List i() {
        String str;
        C3994tr c3994tr = this.f;
        int i = this.d;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else {
            if (i != 407) {
                return AbstractC1886cc.m();
            }
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return AbstractC0632Jr.a(c3994tr, str);
    }

    public final int r() {
        return this.d;
    }

    public final C0799Ol t() {
        return this.n;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.d + ", message=" + this.c + ", url=" + this.a.i() + '}';
    }

    public final C2311gr u() {
        return this.e;
    }

    public final String v(String str, String str2) {
        AbstractC4492zt.h(str, "name");
        String strA = this.f.a(str);
        return strA == null ? str2 : strA;
    }

    public final C3994tr z() {
        return this.f;
    }

    public static class a {
        public C3873sL a;
        public EnumC4356yI b;
        public int c;
        public String d;
        public C2311gr e;
        public C3994tr.a f;
        public FL g;
        public EL h;
        public EL i;
        public EL j;
        public long k;
        public long l;
        public C0799Ol m;

        public a() {
            this.c = -1;
            this.f = new C3994tr.a();
        }

        public a a(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            this.f.a(str, str2);
            return this;
        }

        public a b(FL fl) {
            this.g = fl;
            return this;
        }

        public EL c() {
            int i = this.c;
            if (i < 0) {
                throw new IllegalStateException(("code < 0: " + this.c).toString());
            }
            C3873sL c3873sL = this.a;
            if (c3873sL == null) {
                throw new IllegalStateException("request == null");
            }
            EnumC4356yI enumC4356yI = this.b;
            if (enumC4356yI == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.d;
            if (str != null) {
                return new EL(c3873sL, enumC4356yI, str, i, this.e, this.f.d(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null");
        }

        public a d(EL el) {
            f("cacheResponse", el);
            this.i = el;
            return this;
        }

        public final void e(EL el) {
            if (el != null && el.c() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, EL el) {
            if (el != null) {
                if (el.c() != null) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (el.F() != null) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (el.g() != null) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (el.H() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        public a g(int i) {
            this.c = i;
            return this;
        }

        public final int h() {
            return this.c;
        }

        public a i(C2311gr c2311gr) {
            this.e = c2311gr;
            return this;
        }

        public a j(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            this.f.g(str, str2);
            return this;
        }

        public a k(C3994tr c3994tr) {
            AbstractC4492zt.h(c3994tr, "headers");
            this.f = c3994tr.c();
            return this;
        }

        public final void l(C0799Ol c0799Ol) {
            AbstractC4492zt.h(c0799Ol, "deferredTrailers");
            this.m = c0799Ol;
        }

        public a m(String str) {
            AbstractC4492zt.h(str, "message");
            this.d = str;
            return this;
        }

        public a n(EL el) {
            f("networkResponse", el);
            this.h = el;
            return this;
        }

        public a o(EL el) {
            e(el);
            this.j = el;
            return this;
        }

        public a p(EnumC4356yI enumC4356yI) {
            AbstractC4492zt.h(enumC4356yI, "protocol");
            this.b = enumC4356yI;
            return this;
        }

        public a q(long j) {
            this.l = j;
            return this;
        }

        public a r(C3873sL c3873sL) {
            AbstractC4492zt.h(c3873sL, "request");
            this.a = c3873sL;
            return this;
        }

        public a s(long j) {
            this.k = j;
            return this;
        }

        public a(EL el) {
            AbstractC4492zt.h(el, "response");
            this.c = -1;
            this.a = el.K();
            this.b = el.I();
            this.c = el.r();
            this.d = el.C();
            this.e = el.u();
            this.f = el.z().c();
            this.g = el.c();
            this.h = el.F();
            this.i = el.g();
            this.j = el.H();
            this.k = el.L();
            this.l = el.J();
            this.m = el.t();
        }
    }
}
