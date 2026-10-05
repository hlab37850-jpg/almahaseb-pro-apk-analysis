package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.net.HttpHeaders;

/* JADX INFO: renamed from: n9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3454n9 implements InterfaceC3996tt {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: n9$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C3994tr c(C3994tr c3994tr, C3994tr c3994tr2) {
            C3994tr.a aVar = new C3994tr.a();
            int size = c3994tr.size();
            for (int i = 0; i < size; i++) {
                String strB = c3994tr.b(i);
                String strE = c3994tr.e(i);
                if ((!AbstractC3880sS.q(HttpHeaders.WARNING, strB, true) || !AbstractC3880sS.B(strE, "1", false, 2, null)) && (d(strB) || !e(strB) || c3994tr2.a(strB) == null)) {
                    aVar.c(strB, strE);
                }
            }
            int size2 = c3994tr2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strB2 = c3994tr2.b(i2);
                if (!d(strB2) && e(strB2)) {
                    aVar.c(strB2, c3994tr2.e(i2));
                }
            }
            return aVar.d();
        }

        public final boolean d(String str) {
            return AbstractC3880sS.q(HttpHeaders.CONTENT_LENGTH, str, true) || AbstractC3880sS.q(HttpHeaders.CONTENT_ENCODING, str, true) || AbstractC3880sS.q(HttpHeaders.CONTENT_TYPE, str, true);
        }

        public final boolean e(String str) {
            return (AbstractC3880sS.q(HttpHeaders.CONNECTION, str, true) || AbstractC3880sS.q(HttpHeaders.KEEP_ALIVE, str, true) || AbstractC3880sS.q(HttpHeaders.PROXY_AUTHENTICATE, str, true) || AbstractC3880sS.q(HttpHeaders.PROXY_AUTHORIZATION, str, true) || AbstractC3880sS.q(HttpHeaders.TE, str, true) || AbstractC3880sS.q("Trailers", str, true) || AbstractC3880sS.q(HttpHeaders.TRANSFER_ENCODING, str, true) || AbstractC3880sS.q(HttpHeaders.UPGRADE, str, true)) ? false : true;
        }

        public final EL f(EL el) {
            return (el != null ? el.c() : null) != null ? el.G().b(null).c() : el;
        }

        public a() {
        }
    }

    public C3454n9(AbstractC3208k9 abstractC3208k9) {
    }

    @Override // defpackage.InterfaceC3996tt
    public EL a(InterfaceC3996tt.a aVar) {
        AbstractC0396Cl abstractC0396ClM;
        AbstractC4492zt.h(aVar, "chain");
        InterfaceC2121ea interfaceC2121eaCall = aVar.call();
        C3618p9 c3618p9B = new C3618p9.b(System.currentTimeMillis(), aVar.b(), null).b();
        C3873sL c3873sLB = c3618p9B.b();
        EL elA = c3618p9B.a();
        BJ bj = interfaceC2121eaCall instanceof BJ ? (BJ) interfaceC2121eaCall : null;
        if (bj == null || (abstractC0396ClM = bj.m()) == null) {
            abstractC0396ClM = AbstractC0396Cl.b;
        }
        if (c3873sLB == null && elA == null) {
            EL elC = new EL.a().r(aVar.b()).p(EnumC4356yI.HTTP_1_1).g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).m("Unsatisfiable Request (only-if-cached)").b(AbstractC3724qX.c).s(-1L).q(System.currentTimeMillis()).c();
            abstractC0396ClM.z(interfaceC2121eaCall, elC);
            return elC;
        }
        if (c3873sLB == null) {
            AbstractC4492zt.e(elA);
            EL elC2 = elA.G().d(a.f(elA)).c();
            abstractC0396ClM.b(interfaceC2121eaCall, elC2);
            return elC2;
        }
        if (elA != null) {
            abstractC0396ClM.a(interfaceC2121eaCall, elA);
        }
        EL elA2 = aVar.a(c3873sLB);
        if (elA != null) {
            if (elA2 != null && elA2.r() == 304) {
                EL.a aVarG = elA.G();
                a aVar2 = a;
                aVarG.k(aVar2.c(elA.z(), elA2.z())).s(elA2.L()).q(elA2.J()).d(aVar2.f(elA)).n(aVar2.f(elA2)).c();
                FL flC = elA2.c();
                AbstractC4492zt.e(flC);
                flC.close();
                AbstractC4492zt.e(null);
                throw null;
            }
            FL flC2 = elA.c();
            if (flC2 != null) {
                AbstractC3724qX.m(flC2);
            }
        }
        AbstractC4492zt.e(elA2);
        EL.a aVarG2 = elA2.G();
        a aVar3 = a;
        return aVarG2.d(aVar3.f(elA)).n(aVar3.f(elA2)).c();
    }
}
