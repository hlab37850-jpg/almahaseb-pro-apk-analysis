package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
final class SizeTransformImpl implements SizeTransform {
    private final boolean clip;
    private final InterfaceC0526Fp sizeAnimationSpec;

    public SizeTransformImpl(boolean z, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "sizeAnimationSpec");
        this.clip = z;
        this.sizeAnimationSpec = interfaceC0526Fp;
    }

    @Override // androidx.compose.animation.SizeTransform
    /* JADX INFO: renamed from: createAnimationSpec-TemP2vQ */
    public FiniteAnimationSpec<IntSize> mo79createAnimationSpecTemP2vQ(long j, long j2) {
        return (FiniteAnimationSpec) this.sizeAnimationSpec.mo13invoke(IntSize.m5312boximpl(j), IntSize.m5312boximpl(j2));
    }

    @Override // androidx.compose.animation.SizeTransform
    public boolean getClip() {
        return this.clip;
    }

    public final InterfaceC0526Fp getSizeAnimationSpec() {
        return this.sizeAnimationSpec;
    }

    public /* synthetic */ SizeTransformImpl(boolean z, InterfaceC0526Fp interfaceC0526Fp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? true : z, interfaceC0526Fp);
    }
}
