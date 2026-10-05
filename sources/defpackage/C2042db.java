package defpackage;

/* JADX INFO: renamed from: db, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2042db extends AbstractC1884cb {
    public /* synthetic */ C2042db(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0939Tm, (i2 & 2) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? I8.SUSPEND : i8);
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new C2042db(this.d, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.AbstractC1162Za
    public InterfaceC0939Tm j() {
        return this.d;
    }

    @Override // defpackage.AbstractC1884cb
    public Object q(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.d.collect(interfaceC0995Vm, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public C2042db(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0939Tm, interfaceC0988Vf, i, i8);
    }
}
