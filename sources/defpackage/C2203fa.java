package defpackage;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolException;

/* JADX INFO: renamed from: fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2203fa implements InterfaceC3996tt {
    public final boolean a;

    public C2203fa(boolean z) {
        this.a = z;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0098 A[Catch: IOException -> 0x0069, TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:17:0x0054, B:19:0x005a, B:30:0x0092, B:32:0x0098, B:22:0x006b, B:23:0x007a, B:25:0x0087), top: B:83:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ab  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v4, types: [EL$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5, types: [EL$a] */
    @Override // defpackage.InterfaceC3996tt
    public EL a(InterfaceC3996tt.a aVar) throws IllegalAccessException, IOException, InvocationTargetException {
        EL.a aVarR;
        boolean z;
        ?? r9;
        ?? R;
        EL.a aVar2;
        AbstractC4492zt.h(aVar, "chain");
        EJ ej = (EJ) aVar;
        C0799Ol c0799OlG = ej.g();
        AbstractC4492zt.e(c0799OlG);
        C3873sL c3873sLI = ej.i();
        AbstractC3954tL abstractC3954tLA = c3873sLI.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            c0799OlG.w(c3873sLI);
            ?? A = C0702Kr.a(c3873sLI.g());
            try {
                if (A == 0 || abstractC3954tLA == null) {
                    c0799OlG.p();
                    A = 0;
                    z = true;
                } else {
                    if (AbstractC3880sS.q("100-continue", c3873sLI.d(HttpHeaders.EXPECT), true)) {
                        c0799OlG.f();
                        aVarR = c0799OlG.r(true);
                        try {
                            c0799OlG.t();
                            z = false;
                            aVar2 = aVarR;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            r9 = aVarR;
                            if (!(e instanceof C0987Ve)) {
                                throw e;
                            }
                            if (!c0799OlG.k()) {
                                R = r9;
                                throw e;
                            }
                        }
                    } else {
                        aVar2 = null;
                        z = true;
                    }
                    if (aVar2 != null) {
                        c0799OlG.p();
                        if (!c0799OlG.h().v()) {
                            A = aVar2;
                            c0799OlG.o();
                            A = aVar2;
                        }
                    } else if (abstractC3954tLA.d()) {
                        c0799OlG.f();
                        abstractC3954tLA.f(AbstractC4443zE.a(c0799OlG.c(c3873sLI, true)));
                    } else {
                        K8 k8A = AbstractC4443zE.a(c0799OlG.c(c3873sLI, false));
                        abstractC3954tLA.f(k8A);
                        k8A.close();
                    }
                }
                if (abstractC3954tLA != null) {
                    A = aVar2;
                    if (!abstractC3954tLA.d()) {
                        A = aVar2;
                        A = aVar2;
                        A = aVar2;
                        c0799OlG.e();
                    }
                } else {
                    A = aVar2;
                    A = aVar2;
                    A = aVar2;
                    c0799OlG.e();
                }
                A = aVar2;
                e = null;
                R = A;
            } catch (IOException e2) {
                e = e2;
                r9 = A;
                if (!(e instanceof C0987Ve)) {
                    throw e;
                }
                if (!c0799OlG.k()) {
                    R = r9;
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            aVarR = null;
        }
        if (R == 0) {
            try {
                R = c0799OlG.r(false);
                AbstractC4492zt.e(R);
                if (z) {
                    c0799OlG.t();
                    z = false;
                }
            } catch (IOException e4) {
                if (e == null) {
                    throw e4;
                }
                AbstractC0773Nl.a(e, e4);
                throw e;
            }
        }
        EL elC = R.r(c3873sLI).i(c0799OlG.h().r()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
        int iR = elC.r();
        if (b(iR)) {
            EL.a aVarR2 = c0799OlG.r(false);
            AbstractC4492zt.e(aVarR2);
            if (z) {
                c0799OlG.t();
            }
            elC = aVarR2.r(c3873sLI).i(c0799OlG.h().r()).s(jCurrentTimeMillis).q(System.currentTimeMillis()).c();
            iR = elC.r();
        }
        c0799OlG.s(elC);
        EL elC2 = (this.a && iR == 101) ? elC.G().b(AbstractC3724qX.c).c() : elC.G().b(c0799OlG.q(elC)).c();
        if (AbstractC3880sS.q("close", elC2.K().d(HttpHeaders.CONNECTION), true) || AbstractC3880sS.q("close", EL.x(elC2, HttpHeaders.CONNECTION, null, 2, null), true)) {
            c0799OlG.o();
        }
        if (iR == 204 || iR == 205) {
            FL flC = elC2.c();
            if ((flC != null ? flC.d() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iR);
                sb.append(" had non-zero Content-Length: ");
                FL flC2 = elC2.c();
                sb.append(flC2 != null ? Long.valueOf(flC2.d()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return elC2;
    }

    public final boolean b(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }
}
