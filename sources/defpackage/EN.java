package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class EN extends AbstractC1040Xf implements InterfaceC1017Wi {
    public final AN a;

    public EN(AN an) {
        this.a = an;
    }

    public static final void I(InterfaceC0624Jj interfaceC0624Jj) {
        interfaceC0624Jj.dispose();
    }

    public static final void J(InterfaceC4293xa interfaceC4293xa, EN en) {
        interfaceC4293xa.h(en, FW.a);
    }

    @Override // defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        final InterfaceC0624Jj interfaceC0624JjScheduleDirect = this.a.scheduleDirect(runnable, j, TimeUnit.MILLISECONDS);
        return new InterfaceC0745Mj() { // from class: CN
            @Override // defpackage.InterfaceC0745Mj
            public final void dispose() {
                EN.I(interfaceC0624JjScheduleDirect);
            }
        };
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        this.a.scheduleDirect(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof EN) && ((EN) obj).a == this.a;
    }

    @Override // defpackage.InterfaceC1017Wi
    public void g(long j, final InterfaceC4293xa interfaceC4293xa) {
        AM.c(interfaceC4293xa, this.a.scheduleDirect(new Runnable() { // from class: BN
            @Override // java.lang.Runnable
            public final void run() {
                EN.J(interfaceC4293xa, this);
            }
        }, j, TimeUnit.MILLISECONDS));
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        return this.a.toString();
    }
}
