package defpackage;

/* JADX INFO: renamed from: ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3593ou extends AbstractC2293ge implements InterfaceC0745Mj, InterfaceC0377Bs {
    public C3674pu d;

    @Override // defpackage.InterfaceC0377Bs
    public BD c() {
        return null;
    }

    @Override // defpackage.InterfaceC0745Mj
    public void dispose() {
        y().r0(this);
    }

    @Override // defpackage.InterfaceC0377Bs
    public boolean isActive() {
        return true;
    }

    @Override // defpackage.C0533Fw
    public String toString() {
        return AbstractC3498ni.a(this) + '@' + AbstractC3498ni.b(this) + "[job@" + AbstractC3498ni.b(y()) + ']';
    }

    public final C3674pu y() {
        C3674pu c3674pu = this.d;
        if (c3674pu != null) {
            return c3674pu;
        }
        AbstractC4492zt.x("job");
        return null;
    }

    public final void z(C3674pu c3674pu) {
        this.d = c3674pu;
    }
}
