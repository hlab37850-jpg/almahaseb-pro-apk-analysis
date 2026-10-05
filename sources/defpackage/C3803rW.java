package defpackage;

/* JADX INFO: renamed from: rW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3803rW extends AbstractC1040Xf {
    public static final C3803rW a = new C3803rW();

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        YZ yz = (YZ) interfaceC0988Vf.get(YZ.b);
        if (yz == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        yz.a = true;
    }

    @Override // defpackage.AbstractC1040Xf
    public boolean isDispatchNeeded(InterfaceC0988Vf interfaceC0988Vf) {
        return false;
    }

    @Override // defpackage.AbstractC1040Xf
    public AbstractC1040Xf limitedParallelism(int i) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
