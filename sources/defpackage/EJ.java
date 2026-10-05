package defpackage;

import androidx.core.app.NotificationCompat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class EJ implements InterfaceC3996tt.a {
    public final BJ a;
    public final List b;
    public final int c;
    public final C0799Ol d;
    public final C3873sL e;
    public final int f;
    public final int g;
    public final int h;
    public int i;

    public EJ(BJ bj, List list, int i, C0799Ol c0799Ol, C3873sL c3873sL, int i2, int i3, int i4) {
        AbstractC4492zt.h(bj, NotificationCompat.CATEGORY_CALL);
        AbstractC4492zt.h(list, "interceptors");
        AbstractC4492zt.h(c3873sL, "request");
        this.a = bj;
        this.b = list;
        this.c = i;
        this.d = c0799Ol;
        this.e = c3873sL;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public static /* synthetic */ EJ d(EJ ej, int i, C0799Ol c0799Ol, C3873sL c3873sL, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = ej.c;
        }
        if ((i5 & 2) != 0) {
            c0799Ol = ej.d;
        }
        C0799Ol c0799Ol2 = c0799Ol;
        if ((i5 & 4) != 0) {
            c3873sL = ej.e;
        }
        C3873sL c3873sL2 = c3873sL;
        if ((i5 & 8) != 0) {
            i2 = ej.f;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = ej.g;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = ej.h;
        }
        return ej.c(i, c0799Ol2, c3873sL2, i6, i7, i4);
    }

    @Override // defpackage.InterfaceC3996tt.a
    public EL a(C3873sL c3873sL) {
        AbstractC4492zt.h(c3873sL, "request");
        if (this.c >= this.b.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.i++;
        C0799Ol c0799Ol = this.d;
        if (c0799Ol != null) {
            if (!c0799Ol.j().g(c3873sL.i())) {
                throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must retain the same host and port").toString());
            }
            if (this.i != 1) {
                throw new IllegalStateException(("network interceptor " + this.b.get(this.c - 1) + " must call proceed() exactly once").toString());
            }
        }
        EJ ejD = d(this, this.c + 1, null, c3873sL, 0, 0, 0, 58, null);
        InterfaceC3996tt interfaceC3996tt = (InterfaceC3996tt) this.b.get(this.c);
        EL elA = interfaceC3996tt.a(ejD);
        if (elA == null) {
            throw new NullPointerException("interceptor " + interfaceC3996tt + " returned null");
        }
        if (this.d != null && this.c + 1 < this.b.size() && ejD.i != 1) {
            throw new IllegalStateException(("network interceptor " + interfaceC3996tt + " must call proceed() exactly once").toString());
        }
        if (elA.c() != null) {
            return elA;
        }
        throw new IllegalStateException(("interceptor " + interfaceC3996tt + " returned a response with no body").toString());
    }

    @Override // defpackage.InterfaceC3996tt.a
    public C3873sL b() {
        return this.e;
    }

    public final EJ c(int i, C0799Ol c0799Ol, C3873sL c3873sL, int i2, int i3, int i4) {
        AbstractC4492zt.h(c3873sL, "request");
        return new EJ(this.a, this.b, i, c0799Ol, c3873sL, i2, i3, i4);
    }

    @Override // defpackage.InterfaceC3996tt.a
    public InterfaceC2121ea call() {
        return this.a;
    }

    public final BJ e() {
        return this.a;
    }

    public final int f() {
        return this.f;
    }

    public final C0799Ol g() {
        return this.d;
    }

    public final int h() {
        return this.g;
    }

    public final C3873sL i() {
        return this.e;
    }

    public final int j() {
        return this.h;
    }

    public int k() {
        return this.g;
    }
}
