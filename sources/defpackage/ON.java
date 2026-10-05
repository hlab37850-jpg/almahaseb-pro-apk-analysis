package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ON extends G implements InterfaceC2297gg {
    public final InterfaceC0793Of c;

    public ON(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0988Vf, true, true);
        this.c = interfaceC0793Of;
    }

    @Override // defpackage.G
    public void D0(Object obj) {
        InterfaceC0793Of interfaceC0793Of = this.c;
        interfaceC0793Of.resumeWith(AbstractC2457ie.a(obj, interfaceC0793Of));
    }

    public final InterfaceC1830bu H0() {
        InterfaceC4214wb interfaceC4214wbV = V();
        if (interfaceC4214wbV != null) {
            return interfaceC4214wbV.getParent();
        }
        return null;
    }

    @Override // defpackage.C3674pu
    public final boolean b0() {
        return true;
    }

    @Override // defpackage.InterfaceC2297gg
    public final InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.c;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.C3674pu
    public void w(Object obj) {
        AbstractC4067uj.c(AbstractC0352At.c(this.c), AbstractC2457ie.a(obj, this.c), null, 2, null);
    }
}
