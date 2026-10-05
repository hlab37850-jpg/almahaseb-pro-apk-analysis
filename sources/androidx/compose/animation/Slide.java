package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Slide {
    private final FiniteAnimationSpec<IntOffset> animationSpec;
    private final InterfaceC3750qp slideOffset;

    public Slide(InterfaceC3750qp interfaceC3750qp, FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(interfaceC3750qp, "slideOffset");
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        this.slideOffset = interfaceC3750qp;
        this.animationSpec = finiteAnimationSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Slide copy$default(Slide slide, InterfaceC3750qp interfaceC3750qp, FiniteAnimationSpec finiteAnimationSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = slide.slideOffset;
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = slide.animationSpec;
        }
        return slide.copy(interfaceC3750qp, finiteAnimationSpec);
    }

    public final InterfaceC3750qp component1() {
        return this.slideOffset;
    }

    public final FiniteAnimationSpec<IntOffset> component2() {
        return this.animationSpec;
    }

    public final Slide copy(InterfaceC3750qp interfaceC3750qp, FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(interfaceC3750qp, "slideOffset");
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return new Slide(interfaceC3750qp, finiteAnimationSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Slide)) {
            return false;
        }
        Slide slide = (Slide) obj;
        return AbstractC4492zt.d(this.slideOffset, slide.slideOffset) && AbstractC4492zt.d(this.animationSpec, slide.animationSpec);
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec() {
        return this.animationSpec;
    }

    public final InterfaceC3750qp getSlideOffset() {
        return this.slideOffset;
    }

    public int hashCode() {
        return (this.slideOffset.hashCode() * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Slide(slideOffset=" + this.slideOffset + ", animationSpec=" + this.animationSpec + ')';
    }
}
