package defpackage;

/* JADX INFO: renamed from: vT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4124vT {
    public final String a;
    public final boolean b;
    public DT c;
    public long d;

    public AbstractC4124vT(String str, boolean z) {
        AbstractC4492zt.h(str, "name");
        this.a = str;
        this.b = z;
        this.d = -1L;
    }

    public final boolean a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.d;
    }

    public final DT d() {
        return this.c;
    }

    public final void e(DT dt) {
        AbstractC4492zt.h(dt, "queue");
        DT dt2 = this.c;
        if (dt2 == dt) {
            return;
        }
        if (dt2 != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.c = dt;
    }

    public abstract long f();

    public final void g(long j) {
        this.d = j;
    }

    public String toString() {
        return this.a;
    }

    public /* synthetic */ AbstractC4124vT(String str, boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
