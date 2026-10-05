package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AD;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation;
    private final State<Slide> slideIn;
    private final State<Slide> slideOut;
    private final InterfaceC3750qp transitionSpec;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SlideModifier(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation, State<Slide> state, State<Slide> state2) {
        AbstractC4492zt.h(deferredAnimation, "lazyAnimation");
        AbstractC4492zt.h(state, "slideIn");
        AbstractC4492zt.h(state2, "slideOut");
        this.lazyAnimation = deferredAnimation;
        this.slideIn = state;
        this.slideOut = state2;
        this.transitionSpec = new SlideModifier$transitionSpec$1(this);
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getLazyAnimation() {
        return this.lazyAnimation;
    }

    public final State<Slide> getSlideIn() {
        return this.slideIn;
    }

    public final State<Slide> getSlideOut() {
        return this.slideOut;
    }

    public final InterfaceC3750qp getTransitionSpec() {
        return this.transitionSpec;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new SlideModifier$measure$1(this, placeableMo4159measureBRTryo0, IntSizeKt.IntSize(placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight())), 4, null);
    }

    /* JADX INFO: renamed from: targetValueByState-oFUgxo0, reason: not valid java name */
    public final long m80targetValueByStateoFUgxo0(EnterExitState enterExitState, long j) {
        InterfaceC3750qp slideOffset;
        InterfaceC3750qp slideOffset2;
        AbstractC4492zt.h(enterExitState, "targetState");
        Slide value = this.slideIn.getValue();
        long jM5288getZeronOccac = (value == null || (slideOffset2 = value.getSlideOffset()) == null) ? IntOffset.Companion.m5288getZeronOccac() : ((IntOffset) slideOffset2.invoke(IntSize.m5312boximpl(j))).m5287unboximpl();
        Slide value2 = this.slideOut.getValue();
        long jM5288getZeronOccac2 = (value2 == null || (slideOffset = value2.getSlideOffset()) == null) ? IntOffset.Companion.m5288getZeronOccac() : ((IntOffset) slideOffset.invoke(IntSize.m5312boximpl(j))).m5287unboximpl();
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        if (i == 2) {
            return jM5288getZeronOccac;
        }
        if (i == 3) {
            return jM5288getZeronOccac2;
        }
        throw new AD();
    }
}
