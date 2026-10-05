package defpackage;

/* JADX INFO: renamed from: eu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2150eu extends C3674pu implements InterfaceC1243ae {
    public final boolean b;

    public C2150eu(InterfaceC1830bu interfaceC1830bu) {
        super(true);
        Z(interfaceC1830bu);
        this.b = D0();
    }

    public final boolean D0() {
        C3674pu c3674puY;
        InterfaceC4214wb interfaceC4214wbV = V();
        C4295xb c4295xb = interfaceC4214wbV instanceof C4295xb ? (C4295xb) interfaceC4214wbV : null;
        if (c4295xb != null && (c3674puY = c4295xb.y()) != null) {
            while (!c3674puY.S()) {
                InterfaceC4214wb interfaceC4214wbV2 = c3674puY.V();
                C4295xb c4295xb2 = interfaceC4214wbV2 instanceof C4295xb ? (C4295xb) interfaceC4214wbV2 : null;
                if (c4295xb2 == null || (c3674puY = c4295xb2.y()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.C3674pu
    public boolean S() {
        return this.b;
    }

    @Override // defpackage.C3674pu
    public boolean T() {
        return true;
    }

    @Override // defpackage.InterfaceC1243ae
    public boolean complete() {
        return f0(FW.a);
    }

    @Override // defpackage.InterfaceC1243ae
    public boolean t(Throwable th) {
        return f0(new C2129ee(th, false, 2, null));
    }
}
