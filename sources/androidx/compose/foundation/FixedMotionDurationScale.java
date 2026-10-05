package androidx.compose.foundation;

import androidx.compose.ui.MotionDurationScale;
import defpackage.AbstractC2261gC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;

/* JADX INFO: loaded from: classes.dex */
final class FixedMotionDurationScale implements MotionDurationScale {
    public static final FixedMotionDurationScale INSTANCE = new FixedMotionDurationScale();

    private FixedMotionDurationScale() {
    }

    @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) MotionDurationScale.DefaultImpls.get(this, cVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf.b
    public /* synthetic */ InterfaceC0988Vf.c getKey() {
        return AbstractC2261gC.a(this);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public float getScaleFactor() {
        return 1.0f;
    }

    @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return MotionDurationScale.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return MotionDurationScale.DefaultImpls.plus(this, interfaceC0988Vf);
    }
}
