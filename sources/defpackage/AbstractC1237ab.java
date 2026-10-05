package defpackage;

/* JADX INFO: renamed from: ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1237ab extends AbstractC1162Za {
    public final InterfaceC0526Fp d;

    public AbstractC1237ab(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0988Vf, i, i8);
        this.d = interfaceC0526Fp;
    }

    public static /* synthetic */ Object n(AbstractC1237ab abstractC1237ab, InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
        Object objMo13invoke = abstractC1237ab.d.mo13invoke(interfaceC2103eI, interfaceC0793Of);
        return objMo13invoke == AbstractC0378Bt.d() ? objMo13invoke : FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
        return n(this, interfaceC2103eI, interfaceC0793Of);
    }

    @Override // defpackage.AbstractC1162Za
    public String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }
}
