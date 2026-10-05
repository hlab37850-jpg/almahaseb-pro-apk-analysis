package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Un, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0966Un extends JU {
    public JU f;

    public C0966Un(JU ju) {
        AbstractC4492zt.h(ju, "delegate");
        this.f = ju;
    }

    @Override // defpackage.JU
    public JU a() {
        return this.f.a();
    }

    @Override // defpackage.JU
    public JU b() {
        return this.f.b();
    }

    @Override // defpackage.JU
    public long c() {
        return this.f.c();
    }

    @Override // defpackage.JU
    public JU d(long j) {
        return this.f.d(j);
    }

    @Override // defpackage.JU
    public boolean e() {
        return this.f.e();
    }

    @Override // defpackage.JU
    public void f() throws InterruptedIOException {
        this.f.f();
    }

    @Override // defpackage.JU
    public JU g(long j, TimeUnit timeUnit) {
        AbstractC4492zt.h(timeUnit, "unit");
        return this.f.g(j, timeUnit);
    }

    @Override // defpackage.JU
    public long h() {
        return this.f.h();
    }

    public final JU i() {
        return this.f;
    }

    public final C0966Un j(JU ju) {
        AbstractC4492zt.h(ju, "delegate");
        this.f = ju;
        return this;
    }
}
