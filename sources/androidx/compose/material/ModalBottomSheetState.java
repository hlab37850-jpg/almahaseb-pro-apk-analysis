package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ModalBottomSheetState {
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private Density density;
    private final boolean isSkipHalfExpanded;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z, Density density) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            AbstractC4492zt.h(density, "density");
            return SaverKt.Saver(ModalBottomSheetState$Companion$Saver$1.INSTANCE, new ModalBottomSheetState$Companion$Saver$2(density, animationSpec, interfaceC3750qp, z));
        }

        private Companion() {
        }

        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            return SaverKt.Saver(ModalBottomSheetState$Companion$Saver$3.INSTANCE, new ModalBottomSheetState$Companion$Saver$4(animationSpec, interfaceC3750qp, z));
        }

        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return Saver(animationSpec, interfaceC3750qp, z);
        }
    }

    public ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = z;
        this.anchoredDraggableState = new AnchoredDraggableState<>(modalBottomSheetValue, new ModalBottomSheetState$anchoredDraggableState$1(this), new ModalBottomSheetState$anchoredDraggableState$2(this), animationSpec, interfaceC3750qp);
        if (z && modalBottomSheetValue == ModalBottomSheetValue.HalfExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.");
        }
    }

    public static /* synthetic */ Object animateTo$material_release$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            f = modalBottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material_release(modalBottomSheetValue, f, interfaceC0793Of);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getProgress$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on ModalBottomSheetState (" + this + ") was not set. Did you use ModalBottomSheetState with the ModalBottomSheetLayout composable?").toString());
    }

    public final Object animateTo$material_release(ModalBottomSheetValue modalBottomSheetValue, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, modalBottomSheetValue, f, interfaceC0793Of);
        return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
    }

    public final Object expand$material_release(InterfaceC0793Of interfaceC0793Of) {
        AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState = this.anchoredDraggableState;
        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Expanded;
        if (!anchoredDraggableState.hasAnchorForValue(modalBottomSheetValue)) {
            return FW.a;
        }
        Object objAnimateTo$material_release$default = animateTo$material_release$default(this, modalBottomSheetValue, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material_release$default == AbstractC0378Bt.d() ? objAnimateTo$material_release$default : FW.a;
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return this.anchoredDraggableState.hasAnchorForValue(ModalBottomSheetValue.HalfExpanded);
    }

    public final float getLastVelocity$material_release() {
        return this.anchoredDraggableState.getLastVelocity();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final Object halfExpand$material_release(InterfaceC0793Of interfaceC0793Of) {
        if (!getHasHalfExpandedState$material_release()) {
            return FW.a;
        }
        Object objAnimateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material_release$default == AbstractC0378Bt.d() ? objAnimateTo$material_release$default : FW.a;
    }

    public final Object hide(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material_release$default == AbstractC0378Bt.d() ? objAnimateTo$material_release$default : FW.a;
    }

    public final boolean isAnimationRunning$material_release() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isSkipHalfExpanded$material_release() {
        return this.isSkipHalfExpanded;
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material_release(Density density) {
        this.density = density;
    }

    public final Object show(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$material_release$default = animateTo$material_release$default(this, getHasHalfExpandedState$material_release() ? ModalBottomSheetValue.HalfExpanded : ModalBottomSheetValue.Expanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material_release$default == AbstractC0378Bt.d() ? objAnimateTo$material_release$default : FW.a;
    }

    public final Object snapTo$material_release(ModalBottomSheetValue modalBottomSheetValue, InterfaceC0793Of interfaceC0793Of) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, modalBottomSheetValue, interfaceC0793Of);
        return objSnapTo == AbstractC0378Bt.d() ? objSnapTo : FW.a;
    }

    public final boolean trySnapTo$material_release(ModalBottomSheetValue modalBottomSheetValue) {
        AbstractC4492zt.h(modalBottomSheetValue, TypedValues.AttributesType.S_TARGET);
        return this.anchoredDraggableState.trySnapTo$material_release(modalBottomSheetValue);
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(modalBottomSheetValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? false : z, interfaceC3750qp);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
        this(modalBottomSheetValue, animationSpec, false, interfaceC3750qp);
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
    }
}
