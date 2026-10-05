package defpackage;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Dr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0428Dr implements InterfaceC0825Pl {
    public static final a g = new a(null);
    public static final List h = AbstractC3724qX.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", HtmlTags.ENCODING, "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List i = AbstractC3724qX.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", HtmlTags.ENCODING, "upgrade");
    public final CJ a;
    public final EJ b;
    public final C0402Cr c;
    public volatile C0528Fr d;
    public final EnumC4356yI e;
    public volatile boolean f;

    /* JADX INFO: renamed from: Dr$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final List a(C3873sL c3873sL) {
            AbstractC4492zt.h(c3873sL, "request");
            C3994tr c3994trE = c3873sL.e();
            ArrayList arrayList = new ArrayList(c3994trE.size() + 4);
            arrayList.add(new C3752qr(C3752qr.g, c3873sL.g()));
            arrayList.add(new C3752qr(C3752qr.h, C4197wL.a.c(c3873sL.i())));
            String strD = c3873sL.d(HttpHeaders.HOST);
            if (strD != null) {
                arrayList.add(new C3752qr(C3752qr.j, strD));
            }
            arrayList.add(new C3752qr(C3752qr.i, c3873sL.i().q()));
            int size = c3994trE.size();
            for (int i = 0; i < size; i++) {
                String strB = c3994trE.b(i);
                Locale locale = Locale.US;
                AbstractC4492zt.g(locale, "US");
                String lowerCase = strB.toLowerCase(locale);
                AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!C0428Dr.h.contains(lowerCase) || (AbstractC4492zt.d(lowerCase, "te") && AbstractC4492zt.d(c3994trE.e(i), "trailers"))) {
                    arrayList.add(new C3752qr(lowerCase, c3994trE.e(i)));
                }
            }
            return arrayList;
        }

        public final EL.a b(C3994tr c3994tr, EnumC4356yI enumC4356yI) throws ProtocolException {
            AbstractC4492zt.h(c3994tr, "headerBlock");
            AbstractC4492zt.h(enumC4356yI, "protocol");
            C3994tr.a aVar = new C3994tr.a();
            int size = c3994tr.size();
            C2113eS c2113eSA = null;
            for (int i = 0; i < size; i++) {
                String strB = c3994tr.b(i);
                String strE = c3994tr.e(i);
                if (AbstractC4492zt.d(strB, ":status")) {
                    c2113eSA = C2113eS.d.a("HTTP/1.1 " + strE);
                } else if (!C0428Dr.i.contains(strB)) {
                    aVar.c(strB, strE);
                }
            }
            if (c2113eSA != null) {
                return new EL.a().p(enumC4356yI).g(c2113eSA.b).m(c2113eSA.c).k(aVar.d());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public a() {
        }
    }

    public C0428Dr(C4271xE c4271xE, CJ cj, EJ ej, C0402Cr c0402Cr) {
        AbstractC4492zt.h(c4271xE, "client");
        AbstractC4492zt.h(cj, "connection");
        AbstractC4492zt.h(ej, "chain");
        AbstractC4492zt.h(c0402Cr, "http2Connection");
        this.a = cj;
        this.b = ej;
        this.c = c0402Cr;
        List listB = c4271xE.B();
        EnumC4356yI enumC4356yI = EnumC4356yI.H2_PRIOR_KNOWLEDGE;
        this.e = listB.contains(enumC4356yI) ? enumC4356yI : EnumC4356yI.HTTP_2;
    }

    @Override // defpackage.InterfaceC0825Pl
    public InterfaceC3309lR a(EL el) {
        AbstractC4492zt.h(el, "response");
        C0528Fr c0528Fr = this.d;
        AbstractC4492zt.e(c0528Fr);
        return c0528Fr.p();
    }

    @Override // defpackage.InterfaceC0825Pl
    public void b() {
        C0528Fr c0528Fr = this.d;
        AbstractC4492zt.e(c0528Fr);
        c0528Fr.n().close();
    }

    @Override // defpackage.InterfaceC0825Pl
    public EL.a c(boolean z) throws IOException {
        C0528Fr c0528Fr = this.d;
        if (c0528Fr == null) {
            throw new IOException("stream wasn't created");
        }
        EL.a aVarB = g.b(c0528Fr.C(), this.e);
        if (z && aVarB.h() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // defpackage.InterfaceC0825Pl
    public void cancel() {
        this.f = true;
        C0528Fr c0528Fr = this.d;
        if (c0528Fr != null) {
            c0528Fr.f(EnumC4069ul.CANCEL);
        }
    }

    @Override // defpackage.InterfaceC0825Pl
    public long d(EL el) {
        AbstractC4492zt.h(el, "response");
        if (AbstractC0632Jr.b(el)) {
            return AbstractC3724qX.v(el);
        }
        return 0L;
    }

    @Override // defpackage.InterfaceC0825Pl
    public void e() {
        this.c.flush();
    }

    @Override // defpackage.InterfaceC0825Pl
    public LQ f(C3873sL c3873sL, long j) {
        AbstractC4492zt.h(c3873sL, "request");
        C0528Fr c0528Fr = this.d;
        AbstractC4492zt.e(c0528Fr);
        return c0528Fr.n();
    }

    @Override // defpackage.InterfaceC0825Pl
    public void g(C3873sL c3873sL) throws IOException {
        AbstractC4492zt.h(c3873sL, "request");
        if (this.d != null) {
            return;
        }
        this.d = this.c.a0(g.a(c3873sL), c3873sL.a() != null);
        if (this.f) {
            C0528Fr c0528Fr = this.d;
            AbstractC4492zt.e(c0528Fr);
            c0528Fr.f(EnumC4069ul.CANCEL);
            throw new IOException("Canceled");
        }
        C0528Fr c0528Fr2 = this.d;
        AbstractC4492zt.e(c0528Fr2);
        JU juV = c0528Fr2.v();
        long jH = this.b.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        juV.g(jH, timeUnit);
        C0528Fr c0528Fr3 = this.d;
        AbstractC4492zt.e(c0528Fr3);
        c0528Fr3.E().g(this.b.j(), timeUnit);
    }

    @Override // defpackage.InterfaceC0825Pl
    public CJ getConnection() {
        return this.a;
    }
}
