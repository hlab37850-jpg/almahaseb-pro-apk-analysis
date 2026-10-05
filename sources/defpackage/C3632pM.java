package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: renamed from: pM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3632pM {
    public final Set a = new LinkedHashSet();

    public final synchronized void a(C3550oM c3550oM) {
        AbstractC4492zt.h(c3550oM, "route");
        this.a.remove(c3550oM);
    }

    public final synchronized void b(C3550oM c3550oM) {
        AbstractC4492zt.h(c3550oM, "failedRoute");
        this.a.add(c3550oM);
    }

    public final synchronized boolean c(C3550oM c3550oM) {
        AbstractC4492zt.h(c3550oM, "route");
        return this.a.contains(c3550oM);
    }
}
