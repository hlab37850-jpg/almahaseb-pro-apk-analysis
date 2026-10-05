package defpackage;

/* JADX INFO: renamed from: bP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1790bP extends AbstractC3436n0 {
    public long a = -1;
    public InterfaceC0793Of b;

    @Override // defpackage.AbstractC3436n0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(ZO zo) {
        if (this.a >= 0) {
            return false;
        }
        this.a = zo.X();
        return true;
    }

    @Override // defpackage.AbstractC3436n0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC0793Of[] b(ZO zo) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return zo.W(j);
    }
}
