package defpackage;

import com.google.api.client.http.HttpMethods;

/* JADX INFO: renamed from: Kr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0702Kr {
    public static final C0702Kr a = new C0702Kr();

    public static final boolean a(String str) {
        AbstractC4492zt.h(str, "method");
        return (AbstractC4492zt.d(str, HttpMethods.GET) || AbstractC4492zt.d(str, HttpMethods.HEAD)) ? false : true;
    }

    public static final boolean d(String str) {
        AbstractC4492zt.h(str, "method");
        return AbstractC4492zt.d(str, HttpMethods.POST) || AbstractC4492zt.d(str, HttpMethods.PUT) || AbstractC4492zt.d(str, HttpMethods.PATCH) || AbstractC4492zt.d(str, "PROPPATCH") || AbstractC4492zt.d(str, "REPORT");
    }

    public final boolean b(String str) {
        AbstractC4492zt.h(str, "method");
        return !AbstractC4492zt.d(str, "PROPFIND");
    }

    public final boolean c(String str) {
        AbstractC4492zt.h(str, "method");
        return AbstractC4492zt.d(str, "PROPFIND");
    }
}
