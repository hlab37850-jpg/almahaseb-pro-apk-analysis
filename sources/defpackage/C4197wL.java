package defpackage;

import java.net.Proxy;

/* JADX INFO: renamed from: wL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4197wL {
    public static final C4197wL a = new C4197wL();

    public final String a(C3873sL c3873sL, Proxy.Type type) {
        AbstractC4492zt.h(c3873sL, "request");
        AbstractC4492zt.h(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(c3873sL.g());
        sb.append(' ');
        C4197wL c4197wL = a;
        if (c4197wL.b(c3873sL, type)) {
            sb.append(c3873sL.i());
        } else {
            sb.append(c4197wL.c(c3873sL.i()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean b(C3873sL c3873sL, Proxy.Type type) {
        return !c3873sL.f() && type == Proxy.Type.HTTP;
    }

    public final String c(C0779Nr c0779Nr) {
        AbstractC4492zt.h(c0779Nr, "url");
        String strD = c0779Nr.d();
        String strF = c0779Nr.f();
        if (strF == null) {
            return strD;
        }
        return strD + '?' + strF;
    }
}
