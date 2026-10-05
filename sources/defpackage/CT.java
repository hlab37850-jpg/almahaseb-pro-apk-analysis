package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class CT extends AbstractC4124vT {
    public final /* synthetic */ InterfaceC3588op e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CT(String str, boolean z, InterfaceC3588op interfaceC3588op) {
        super(str, z);
        this.e = interfaceC3588op;
    }

    @Override // defpackage.AbstractC4124vT
    public long f() {
        this.e.invoke();
        return -1L;
    }
}
