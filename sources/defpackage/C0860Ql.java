package defpackage;

import androidx.core.app.NotificationCompat;
import com.google.api.client.http.HttpMethods;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/* JADX INFO: renamed from: Ql, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0860Ql {
    public final DJ a;
    public final C3846s2 b;
    public final BJ c;
    public final AbstractC0396Cl d;
    public C3793rM.b e;
    public C3793rM f;
    public int g;
    public int h;
    public int i;
    public C3550oM j;

    public C0860Ql(DJ dj, C3846s2 c3846s2, BJ bj, AbstractC0396Cl abstractC0396Cl) {
        AbstractC4492zt.h(dj, "connectionPool");
        AbstractC4492zt.h(c3846s2, HTML.Tag.ADDRESS);
        AbstractC4492zt.h(bj, NotificationCompat.CATEGORY_CALL);
        AbstractC4492zt.h(abstractC0396Cl, "eventListener");
        this.a = dj;
        this.b = c3846s2;
        this.c = bj;
        this.d = abstractC0396Cl;
    }

    public final InterfaceC0825Pl a(C4271xE c4271xE, EJ ej) {
        AbstractC4492zt.h(c4271xE, "client");
        AbstractC4492zt.h(ej, "chain");
        try {
            return c(ej.f(), ej.h(), ej.j(), c4271xE.A(), c4271xE.G(), !AbstractC4492zt.d(ej.i().g(), HttpMethods.GET)).w(c4271xE, ej);
        } catch (IOException e) {
            h(e);
            throw new C3713qM(e);
        } catch (C3713qM e2) {
            h(e2.c());
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x012f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final CJ b(int i, int i2, int i3, int i4, boolean z) throws IOException {
        List listA;
        CJ cj;
        Socket socketW;
        if (this.c.s()) {
            throw new IOException("Canceled");
        }
        CJ cjL = this.c.l();
        if (cjL != null) {
            synchronized (cjL) {
                try {
                    socketW = (cjL.p() || !g(cjL.A().a().l())) ? this.c.w() : null;
                    FW fw = FW.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.c.l() != null) {
                if (socketW == null) {
                    return cjL;
                }
                throw new IllegalStateException("Check failed.");
            }
            if (socketW != null) {
                AbstractC3724qX.n(socketW);
            }
            this.d.k(this.c, cjL);
        }
        this.g = 0;
        this.h = 0;
        this.i = 0;
        if (this.a.a(this.b, this.c, null, false)) {
            CJ cjL2 = this.c.l();
            AbstractC4492zt.e(cjL2);
            this.d.j(this.c, cjL2);
            return cjL2;
        }
        C3550oM c3550oMC = this.j;
        try {
            if (c3550oMC == null) {
                C3793rM.b bVar = this.e;
                if (bVar != null) {
                    AbstractC4492zt.e(bVar);
                    if (bVar.b()) {
                        C3793rM.b bVar2 = this.e;
                        AbstractC4492zt.e(bVar2);
                        c3550oMC = bVar2.c();
                    }
                    cj = new CJ(this.a, c3550oMC);
                    this.c.y(cj);
                    cj.f(i, i2, i3, i4, z, this.c, this.d);
                    this.c.y(null);
                    this.c.k().u().a(cj.A());
                    if (this.a.a(this.b, this.c, listA, true)) {
                        CJ cjL3 = this.c.l();
                        AbstractC4492zt.e(cjL3);
                        this.j = c3550oMC;
                        AbstractC3724qX.n(cj.E());
                        this.d.j(this.c, cjL3);
                        return cjL3;
                    }
                    synchronized (cj) {
                        this.a.e(cj);
                        this.c.d(cj);
                        FW fw2 = FW.a;
                    }
                    this.d.j(this.c, cj);
                    return cj;
                }
                C3793rM c3793rM = this.f;
                if (c3793rM == null) {
                    c3793rM = new C3793rM(this.b, this.c.k().u(), this.c, this.d);
                    this.f = c3793rM;
                }
                C3793rM.b bVarC = c3793rM.c();
                this.e = bVarC;
                listA = bVarC.a();
                if (this.c.s()) {
                    throw new IOException("Canceled");
                }
                if (this.a.a(this.b, this.c, listA, false)) {
                    CJ cjL4 = this.c.l();
                    AbstractC4492zt.e(cjL4);
                    this.d.j(this.c, cjL4);
                    return cjL4;
                }
                c3550oMC = bVarC.c();
                cj = new CJ(this.a, c3550oMC);
                this.c.y(cj);
                cj.f(i, i2, i3, i4, z, this.c, this.d);
                this.c.y(null);
                this.c.k().u().a(cj.A());
                if (this.a.a(this.b, this.c, listA, true)) {
                    CJ cjL5 = this.c.l();
                    AbstractC4492zt.e(cjL5);
                    this.j = c3550oMC;
                    AbstractC3724qX.n(cj.E());
                    this.d.j(this.c, cjL5);
                    return cjL5;
                }
                synchronized (cj) {
                    this.a.e(cj);
                    this.c.d(cj);
                    FW fw3 = FW.a;
                    this.d.j(this.c, cj);
                    return cj;
                }
            }
            AbstractC4492zt.e(c3550oMC);
            this.j = null;
            cj.f(i, i2, i3, i4, z, this.c, this.d);
            this.c.y(null);
            this.c.k().u().a(cj.A());
            if (this.a.a(this.b, this.c, listA, true)) {
                CJ cjL6 = this.c.l();
                AbstractC4492zt.e(cjL6);
                this.j = c3550oMC;
                AbstractC3724qX.n(cj.E());
                this.d.j(this.c, cjL6);
                return cjL6;
            }
            synchronized (cj) {
                this.a.e(cj);
                this.c.d(cj);
                FW fw4 = FW.a;
                this.d.j(this.c, cj);
                return cj;
            }
        } catch (Throwable th2) {
            this.c.y(null);
            throw th2;
        }
        listA = null;
        cj = new CJ(this.a, c3550oMC);
        this.c.y(cj);
    }

    public final CJ c(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            CJ cjB = b(i, i2, i3, i4, z);
            if (cjB.u(z2)) {
                return cjB;
            }
            cjB.z();
            if (this.j == null) {
                C3793rM.b bVar = this.e;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    C3793rM c3793rM = this.f;
                    if (!(c3793rM != null ? c3793rM.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    public final C3846s2 d() {
        return this.b;
    }

    public final boolean e() {
        C3793rM c3793rM;
        if (this.g == 0 && this.h == 0 && this.i == 0) {
            return false;
        }
        if (this.j != null) {
            return true;
        }
        C3550oM c3550oMF = f();
        if (c3550oMF != null) {
            this.j = c3550oMF;
            return true;
        }
        C3793rM.b bVar = this.e;
        if ((bVar == null || !bVar.b()) && (c3793rM = this.f) != null) {
            return c3793rM.a();
        }
        return true;
    }

    public final C3550oM f() {
        CJ cjL;
        if (this.g > 1 || this.h > 1 || this.i > 0 || (cjL = this.c.l()) == null) {
            return null;
        }
        synchronized (cjL) {
            if (cjL.q() != 0) {
                return null;
            }
            if (AbstractC3724qX.j(cjL.A().a().l(), this.b.l())) {
                return cjL.A();
            }
            return null;
        }
    }

    public final boolean g(C0779Nr c0779Nr) {
        AbstractC4492zt.h(c0779Nr, "url");
        C0779Nr c0779NrL = this.b.l();
        return c0779Nr.m() == c0779NrL.m() && AbstractC4492zt.d(c0779Nr.h(), c0779NrL.h());
    }

    public final void h(IOException iOException) {
        AbstractC4492zt.h(iOException, "e");
        this.j = null;
        if ((iOException instanceof C2195fS) && ((C2195fS) iOException).a == EnumC4069ul.REFUSED_STREAM) {
            this.g++;
        } else if (iOException instanceof C0987Ve) {
            this.h++;
        } else {
            this.i++;
        }
    }
}
