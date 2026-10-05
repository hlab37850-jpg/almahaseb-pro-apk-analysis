package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: Xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1035Xa extends AbstractC1162Za {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C1035Xa.class, "consumed");
    private volatile /* synthetic */ int consumed;
    public final IJ d;
    public final boolean e;

    public /* synthetic */ C1035Xa(IJ ij, boolean z, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(ij, z, (i2 & 4) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 8) != 0 ? -3 : i, (i2 & 16) != 0 ? I8.SUSPEND : i8);
    }

    @Override // defpackage.AbstractC1162Za, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        if (this.b != -3) {
            Object objCollect = super.collect(interfaceC0995Vm, interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
        n();
        Object objD = AbstractC1174Zm.d(interfaceC0995Vm, this.d, this.e, interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public String d() {
        return "channel=" + this.d;
    }

    @Override // defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objD = AbstractC1174Zm.d(new C4281xO(interfaceC2103eI), this.d, this.e, interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new C1035Xa(this.d, this.e, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.AbstractC1162Za
    public InterfaceC0939Tm j() {
        return new C1035Xa(this.d, this.e, null, 0, null, 28, null);
    }

    @Override // defpackage.AbstractC1162Za
    public IJ m(InterfaceC2052dg interfaceC2052dg) {
        n();
        return this.b == -3 ? this.d : super.m(interfaceC2052dg);
    }

    public final void n() {
        if (this.e && f.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    public C1035Xa(IJ ij, boolean z, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0988Vf, i, i8);
        this.d = ij;
        this.e = z;
        this.consumed = 0;
    }
}
