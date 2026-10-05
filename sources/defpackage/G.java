package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G extends C3674pu implements InterfaceC1830bu, InterfaceC0793Of, InterfaceC2052dg {
    public final InterfaceC0988Vf b;

    public G(InterfaceC0988Vf interfaceC0988Vf, boolean z, boolean z2) {
        super(z2);
        if (z) {
            Z((InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s));
        }
        this.b = interfaceC0988Vf.plus(this);
    }

    public void D0(Object obj) {
        w(obj);
    }

    public final void G0(EnumC2379hg enumC2379hg, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        enumC2379hg.b(interfaceC0526Fp, obj, this);
    }

    @Override // defpackage.C3674pu
    public String J() {
        return AbstractC3498ni.a(this) + " was cancelled";
    }

    @Override // defpackage.C3674pu
    public final void Y(Throwable th) {
        AbstractC1247ag.a(this.b, th);
    }

    @Override // defpackage.InterfaceC0793Of
    public final InterfaceC0988Vf getContext() {
        return this.b;
    }

    @Override // defpackage.InterfaceC2052dg
    public InterfaceC0988Vf getCoroutineContext() {
        return this.b;
    }

    @Override // defpackage.C3674pu
    public String i0() {
        String strB = AbstractC1014Wf.b(this.b);
        if (strB == null) {
            return super.i0();
        }
        return '\"' + strB + "\":" + super.i0();
    }

    @Override // defpackage.C3674pu, defpackage.InterfaceC1830bu
    public boolean isActive() {
        return super.isActive();
    }

    @Override // defpackage.C3674pu
    public final void n0(Object obj) {
        if (!(obj instanceof C2129ee)) {
            F0(obj);
        } else {
            C2129ee c2129ee = (C2129ee) obj;
            E0(c2129ee.a, c2129ee.a());
        }
    }

    @Override // defpackage.InterfaceC0793Of
    public final void resumeWith(Object obj) {
        Object objG0 = g0(AbstractC2457ie.d(obj, null, 1, null));
        if (objG0 == AbstractC3755qu.b) {
            return;
        }
        D0(objG0);
    }

    public void F0(Object obj) {
    }

    public void E0(Throwable th, boolean z) {
    }
}
