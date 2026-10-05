package defpackage;

/* JADX INFO: renamed from: yJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4357yJ implements CR, InterfaceC0939Tm, InterfaceC1826bq {
    public final InterfaceC1830bu a;
    public final /* synthetic */ CR b;

    public C4357yJ(CR cr, InterfaceC1830bu interfaceC1830bu) {
        this.a = interfaceC1830bu;
        this.b = cr;
    }

    @Override // defpackage.InterfaceC1826bq
    public InterfaceC0939Tm a(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return ER.d(this, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.YO, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return this.b.collect(interfaceC0995Vm, interfaceC0793Of);
    }

    @Override // defpackage.CR
    public Object getValue() {
        return this.b.getValue();
    }
}
