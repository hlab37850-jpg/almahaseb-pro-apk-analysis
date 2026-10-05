package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Ue, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0957Ue {
    public final DJ a;

    public C0957Ue(DJ dj) {
        AbstractC4492zt.h(dj, "delegate");
        this.a = dj;
    }

    public final DJ a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0957Ue(int i, long j, TimeUnit timeUnit) {
        this(new DJ(ET.i, i, j, timeUnit));
        AbstractC4492zt.h(timeUnit, "timeUnit");
    }

    public C0957Ue() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
