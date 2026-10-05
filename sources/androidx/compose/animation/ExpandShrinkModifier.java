package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AD;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final State<Alignment> alignment;
    private Alignment currentAlignment;
    private final State<ChangeSize> expand;
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private final State<ChangeSize> shrink;
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private final InterfaceC3750qp sizeTransitionSpec;

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

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandShrinkModifier(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, State<ChangeSize> state, State<ChangeSize> state2, State<? extends Alignment> state3) {
        AbstractC4492zt.h(deferredAnimation, "sizeAnimation");
        AbstractC4492zt.h(deferredAnimation2, "offsetAnimation");
        AbstractC4492zt.h(state, "expand");
        AbstractC4492zt.h(state2, "shrink");
        AbstractC4492zt.h(state3, CellUtil.ALIGNMENT);
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.expand = state;
        this.shrink = state2;
        this.alignment = state3;
        this.sizeTransitionSpec = new ExpandShrinkModifier$sizeTransitionSpec$1(this);
    }

    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final State<ChangeSize> getExpand() {
        return this.expand;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final State<ChangeSize> getShrink() {
        return this.shrink;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final InterfaceC3750qp getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        long jIntSize = IntSizeKt.IntSize(placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight());
        long jM5324unboximpl = this.sizeAnimation.animate(this.sizeTransitionSpec, new ExpandShrinkModifier$measure$currentSize$1(this, jIntSize)).getValue().m5324unboximpl();
        long jM5287unboximpl = this.offsetAnimation.animate(ExpandShrinkModifier$measure$offsetDelta$1.INSTANCE, new ExpandShrinkModifier$measure$offsetDelta$2(this, jIntSize)).getValue().m5287unboximpl();
        Alignment alignment = this.currentAlignment;
        return MeasureScope.CC.q(measureScope, IntSize.m5320getWidthimpl(jM5324unboximpl), IntSize.m5319getHeightimpl(jM5324unboximpl), null, new ExpandShrinkModifier$measure$1(placeableMo4159measureBRTryo0, alignment != null ? alignment.mo2684alignKFBX0sM(jIntSize, jM5324unboximpl, LayoutDirection.Ltr) : IntOffset.Companion.m5288getZeronOccac(), jM5287unboximpl), 4, null);
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    /* JADX INFO: renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m62sizeByStateUzc_VyU(EnterExitState enterExitState, long j) {
        AbstractC4492zt.h(enterExitState, "targetState");
        ChangeSize value = this.expand.getValue();
        long jM5324unboximpl = value != null ? ((IntSize) value.getSize().invoke(IntSize.m5312boximpl(j))).m5324unboximpl() : j;
        ChangeSize value2 = this.shrink.getValue();
        long jM5324unboximpl2 = value2 != null ? ((IntSize) value2.getSize().invoke(IntSize.m5312boximpl(j))).m5324unboximpl() : j;
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return j;
        }
        if (i == 2) {
            return jM5324unboximpl;
        }
        if (i == 3) {
            return jM5324unboximpl2;
        }
        throw new AD();
    }

    /* JADX INFO: renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m63targetOffsetByStateoFUgxo0(EnterExitState enterExitState, long j) {
        AbstractC4492zt.h(enterExitState, "targetState");
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        if (this.alignment.getValue() == null) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        if (AbstractC4492zt.d(this.currentAlignment, this.alignment.getValue())) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        if (i == 2) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        if (i != 3) {
            throw new AD();
        }
        ChangeSize value = this.shrink.getValue();
        if (value == null) {
            return IntOffset.Companion.m5288getZeronOccac();
        }
        long jM5324unboximpl = ((IntSize) value.getSize().invoke(IntSize.m5312boximpl(j))).m5324unboximpl();
        Alignment value2 = this.alignment.getValue();
        AbstractC4492zt.e(value2);
        Alignment alignment = value2;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        long jMo2684alignKFBX0sM = alignment.mo2684alignKFBX0sM(j, jM5324unboximpl, layoutDirection);
        Alignment alignment2 = this.currentAlignment;
        AbstractC4492zt.e(alignment2);
        long jMo2684alignKFBX0sM2 = alignment2.mo2684alignKFBX0sM(j, jM5324unboximpl, layoutDirection);
        return IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo2684alignKFBX0sM) - IntOffset.m5278getXimpl(jMo2684alignKFBX0sM2), IntOffset.m5279getYimpl(jMo2684alignKFBX0sM) - IntOffset.m5279getYimpl(jMo2684alignKFBX0sM2));
    }
}
