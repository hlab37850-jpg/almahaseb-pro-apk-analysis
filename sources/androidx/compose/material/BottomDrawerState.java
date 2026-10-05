package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class BottomDrawerState {
    private final AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.compose.material.BottomDrawerState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(BottomDrawerValue bottomDrawerValue) {
            AbstractC4492zt.h(bottomDrawerValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(Density density, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(density, "density");
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return SaverKt.Saver(BottomDrawerState$Companion$Saver$1.INSTANCE, new BottomDrawerState$Companion$Saver$2(density, interfaceC3750qp));
        }

        private Companion() {
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return SaverKt.Saver(BottomDrawerState$Companion$Saver$3.INSTANCE, new BottomDrawerState$Companion$Saver$4(interfaceC3750qp));
        }
    }

    public BottomDrawerState(BottomDrawerValue bottomDrawerValue, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(bottomDrawerValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState = new AnchoredDraggableState<>(bottomDrawerValue, new BottomDrawerState$anchoredDraggableState$1(this), new BottomDrawerState$anchoredDraggableState$2(this), DrawerKt.AnimationSpec, interfaceC3750qp);
        this.anchoredDraggableState = anchoredDraggableState;
        this.nestedScrollConnection = DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(anchoredDraggableState);
    }

    public static /* synthetic */ Object animateTo$material_release$default(BottomDrawerState bottomDrawerState, BottomDrawerValue bottomDrawerValue, float f, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomDrawerState.anchoredDraggableState.getLastVelocity();
        }
        return bottomDrawerState.animateTo$material_release(bottomDrawerValue, f, interfaceC0793Of);
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getProgress$annotations() {
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.hasAnchorForValue(BottomDrawerValue.Open);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on BottomDrawerState (" + this + ") was not set. Did you use BottomDrawer with the BottomDrawer composable?").toString());
    }

    public final Object animateTo$material_release(BottomDrawerValue bottomDrawerValue, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, bottomDrawerValue, f, interfaceC0793Of);
        return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
    }

    public final Object close(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final boolean confirmStateChange$material_release(BottomDrawerValue bottomDrawerValue) {
        AbstractC4492zt.h(bottomDrawerValue, "value");
        return ((Boolean) this.anchoredDraggableState.getConfirmValueChange$material_release().invoke(bottomDrawerValue)).booleanValue();
    }

    public final Object expand(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final AnchoredDraggableState<BottomDrawerValue> getAnchoredDraggableState$material_release() {
        return this.anchoredDraggableState;
    }

    public final BottomDrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material_release() {
        return this.density;
    }

    public final float getLastVelocity$material_release() {
        return this.anchoredDraggableState.getLastVelocity();
    }

    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final BottomDrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning$material_release() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed;
    }

    public final boolean isExpanded() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Expanded;
    }

    public final boolean isOpen() {
        return this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed;
    }

    public final Object open(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, isOpenEnabled() ? BottomDrawerValue.Open : BottomDrawerValue.Expanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final float requireOffset$material_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material_release(Density density) {
        this.density = density;
    }

    public final Object snapTo$material_release(BottomDrawerValue bottomDrawerValue, InterfaceC0793Of interfaceC0793Of) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, bottomDrawerValue, interfaceC0793Of);
        return objSnapTo == AbstractC0378Bt.d() ? objSnapTo : FW.a;
    }

    public final boolean trySnapTo$material_release(BottomDrawerValue bottomDrawerValue) {
        AbstractC4492zt.h(bottomDrawerValue, TypedValues.AttributesType.S_TARGET);
        return this.anchoredDraggableState.trySnapTo$material_release(bottomDrawerValue);
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue bottomDrawerValue, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(bottomDrawerValue, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp);
    }
}
