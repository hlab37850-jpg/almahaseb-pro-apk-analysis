package defpackage;

import com.google.common.net.HttpHeaders;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class F8 implements InterfaceC3996tt {
    public final InterfaceC0932Tf a;

    public F8(InterfaceC0932Tf interfaceC0932Tf) {
        AbstractC4492zt.h(interfaceC0932Tf, "cookieJar");
        this.a = interfaceC0932Tf;
    }

    @Override // defpackage.InterfaceC3996tt
    public EL a(InterfaceC3996tt.a aVar) {
        FL flC;
        AbstractC4492zt.h(aVar, "chain");
        C3873sL c3873sLB = aVar.b();
        C3873sL.a aVarH = c3873sLB.h();
        AbstractC3954tL abstractC3954tLA = c3873sLB.a();
        if (abstractC3954tLA != null) {
            IB ibB = abstractC3954tLA.b();
            if (ibB != null) {
                aVarH.c(HttpHeaders.CONTENT_TYPE, ibB.toString());
            }
            long jA = abstractC3954tLA.a();
            if (jA != -1) {
                aVarH.c(HttpHeaders.CONTENT_LENGTH, String.valueOf(jA));
                aVarH.f(HttpHeaders.TRANSFER_ENCODING);
            } else {
                aVarH.c(HttpHeaders.TRANSFER_ENCODING, "chunked");
                aVarH.f(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (c3873sLB.d(HttpHeaders.HOST) == null) {
            aVarH.c(HttpHeaders.HOST, AbstractC3724qX.T(c3873sLB.i(), false, 1, null));
        }
        if (c3873sLB.d(HttpHeaders.CONNECTION) == null) {
            aVarH.c(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        }
        if (c3873sLB.d(HttpHeaders.ACCEPT_ENCODING) == null && c3873sLB.d(HttpHeaders.RANGE) == null) {
            aVarH.c(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List listB = this.a.b(c3873sLB.i());
        if (!listB.isEmpty()) {
            aVarH.c(HttpHeaders.COOKIE, b(listB));
        }
        if (c3873sLB.d(HttpHeaders.USER_AGENT) == null) {
            aVarH.c(HttpHeaders.USER_AGENT, "okhttp/4.12.0");
        }
        EL elA = aVar.a(aVarH.b());
        AbstractC0632Jr.f(this.a, c3873sLB.i(), elA.z());
        EL.a aVarR = elA.G().r(c3873sLB);
        if (z && AbstractC3880sS.q("gzip", EL.x(elA, HttpHeaders.CONTENT_ENCODING, null, 2, null), true) && AbstractC0632Jr.b(elA) && (flC = elA.c()) != null) {
            C1025Wq c1025Wq = new C1025Wq(flC.i());
            aVarR.k(elA.z().c().f(HttpHeaders.CONTENT_ENCODING).f(HttpHeaders.CONTENT_LENGTH).d());
            aVarR.b(new FJ(EL.x(elA, HttpHeaders.CONTENT_TYPE, null, 2, null), -1L, AbstractC4443zE.b(c1025Wq)));
        }
        return aVarR.c();
    }

    public final String b(List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1886cc.w();
            }
            C0906Sf c0906Sf = (C0906Sf) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(c0906Sf.e());
            sb.append('=');
            sb.append(c0906Sf.g());
            i = i2;
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
