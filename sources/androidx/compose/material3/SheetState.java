package androidx.compose.material3;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;
    private SwipeableV2State<SheetValue> swipeableState;

    /* JADX INFO: renamed from: androidx.compose.material3.SheetState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(SheetValue sheetValue) {
            AbstractC4492zt.h(sheetValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<SheetState, SheetValue> Saver(boolean z, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            return SaverKt.Saver(SheetState$Companion$Saver$1.INSTANCE, new SheetState$Companion$Saver$2(z, interfaceC3750qp));
        }

        private Companion() {
        }
    }

    public SheetState(boolean z, SheetValue sheetValue, InterfaceC3750qp interfaceC3750qp, boolean z2) {
        AbstractC4492zt.h(sheetValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
        this.skipPartiallyExpanded = z;
        this.skipHiddenState = z2;
        if (z && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.");
        }
        if (z2 && sheetValue == SheetValue.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.");
        }
        this.swipeableState = new SwipeableV2State<>(sheetValue, SwipeableV2Defaults.INSTANCE.getAnimationSpec(), interfaceC3750qp, null, 0.0f, 24, null);
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SheetState sheetState, SheetValue sheetValue, float f, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            f = sheetState.swipeableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue, f, interfaceC0793Of);
    }

    public final Object animateTo$material3_release(SheetValue sheetValue, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objAnimateTo = this.swipeableState.animateTo(sheetValue, f, interfaceC0793Of);
        return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
    }

    public final Object expand(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, SheetValue.Expanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final SheetValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.swipeableState.hasAnchorForValue(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.swipeableState.hasAnchorForValue(SheetValue.PartiallyExpanded);
    }

    public final Float getOffset$material3_release() {
        return this.swipeableState.getOffset();
    }

    public final boolean getSkipHiddenState$material3_release() {
        return this.skipHiddenState;
    }

    public final boolean getSkipPartiallyExpanded$material3_release() {
        return this.skipPartiallyExpanded;
    }

    public final SwipeableV2State<SheetValue> getSwipeableState$material3_release() {
        return this.swipeableState;
    }

    public final SheetValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final Object hide(InterfaceC0793Of interfaceC0793Of) {
        if (this.skipHiddenState) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.");
        }
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.Hidden, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material3_release$default == AbstractC0378Bt.d() ? objAnimateTo$material3_release$default : FW.a;
    }

    public final boolean isVisible() {
        return this.swipeableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final Object partialExpand(InterfaceC0793Of interfaceC0793Of) {
        if (this.skipPartiallyExpanded) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.");
        }
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material3_release$default == AbstractC0378Bt.d() ? objAnimateTo$material3_release$default : FW.a;
    }

    public final float requireOffset() {
        return this.swipeableState.requireOffset();
    }

    public final void setSwipeableState$material3_release(SwipeableV2State<SheetValue> swipeableV2State) {
        AbstractC4492zt.h(swipeableV2State, "<set-?>");
        this.swipeableState = swipeableV2State;
    }

    public final Object settle$material3_release(float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object obj = this.swipeableState.settle(f, interfaceC0793Of);
        return obj == AbstractC0378Bt.d() ? obj : FW.a;
    }

    public final Object show(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded, 0.0f, interfaceC0793Of, 2, null);
        return objAnimateTo$material3_release$default == AbstractC0378Bt.d() ? objAnimateTo$material3_release$default : FW.a;
    }

    public final Object snapTo$material3_release(SheetValue sheetValue, InterfaceC0793Of interfaceC0793Of) {
        Object objSnapTo = this.swipeableState.snapTo(sheetValue, interfaceC0793Of);
        return objSnapTo == AbstractC0378Bt.d() ? objSnapTo : FW.a;
    }

    public final boolean trySnapTo$material3_release(SheetValue sheetValue) {
        AbstractC4492zt.h(sheetValue, "targetValue");
        return this.swipeableState.trySnapTo$material3_release(sheetValue);
    }

    public /* synthetic */ SheetState(boolean z, SheetValue sheetValue, InterfaceC3750qp interfaceC3750qp, boolean z2, int i, AbstractC0419Di abstractC0419Di) {
        this(z, (i & 2) != 0 ? SheetValue.Hidden : sheetValue, (i & 4) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp, (i & 8) != 0 ? false : z2);
    }
}
