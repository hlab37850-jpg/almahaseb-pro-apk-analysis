package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.O8;

/* JADX INFO: loaded from: classes.dex */
final class SizeAnimationModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final MutableState animData$delegate;
    private final AnimationSpec<IntSize> animSpec;
    private InterfaceC0526Fp listener;
    private final InterfaceC2052dg scope;

    @StabilityInferred(parameters = 0)
    public static final class AnimData {
        public static final int $stable = 8;
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;

        public /* synthetic */ AnimData(Animatable animatable, long j, AbstractC0419Di abstractC0419Di) {
            this(animatable, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
        public static /* synthetic */ AnimData m74copyO0kMr_c$default(AnimData animData, Animatable animatable, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable = animData.anim;
            }
            if ((i & 2) != 0) {
                j = animData.startSize;
            }
            return animData.m76copyO0kMr_c(animatable, j);
        }

        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        /* JADX INFO: renamed from: component2-YbymL2g, reason: not valid java name */
        public final long m75component2YbymL2g() {
            return this.startSize;
        }

        /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
        public final AnimData m76copyO0kMr_c(Animatable<IntSize, AnimationVector2D> animatable, long j) {
            AbstractC4492zt.h(animatable, "anim");
            return new AnimData(animatable, j, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) obj;
            return AbstractC4492zt.d(this.anim, animData.anim) && IntSize.m5318equalsimpl0(this.startSize, animData.startSize);
        }

        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        /* JADX INFO: renamed from: getStartSize-YbymL2g, reason: not valid java name */
        public final long m77getStartSizeYbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return (this.anim.hashCode() * 31) + IntSize.m5321hashCodeimpl(this.startSize);
        }

        /* JADX INFO: renamed from: setStartSize-ozmzZPI, reason: not valid java name */
        public final void m78setStartSizeozmzZPI(long j) {
            this.startSize = j;
        }

        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.m5323toStringimpl(this.startSize)) + ')';
        }

        private AnimData(Animatable<IntSize, AnimationVector2D> animatable, long j) {
            AbstractC4492zt.h(animatable, "anim");
            this.anim = animatable;
            this.startSize = j;
        }
    }

    public SizeAnimationModifier(AnimationSpec<IntSize> animationSpec, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(animationSpec, "animSpec");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        this.animSpec = animationSpec;
        this.scope = interfaceC2052dg;
        this.animData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* JADX INFO: renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m73animateTomzRDjE0(long j) {
        AnimData animData = getAnimData();
        if (animData == null) {
            animData = new AnimData(new Animatable(IntSize.m5312boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.m5312boximpl(IntSizeKt.IntSize(1, 1)), null, 8, null), j, null);
        } else if (!IntSize.m5318equalsimpl0(j, animData.getAnim().getTargetValue().m5324unboximpl())) {
            animData.m78setStartSizeozmzZPI(animData.getAnim().getValue().m5324unboximpl());
            O8.d(this.scope, null, null, new SizeAnimationModifier$animateTo$data$1$1(animData, j, this, null), 3, null);
        }
        setAnimData(animData);
        return animData.getAnim().getValue().m5324unboximpl();
    }

    public final AnimData getAnimData() {
        return (AnimData) this.animData$delegate.getValue();
    }

    public final AnimationSpec<IntSize> getAnimSpec() {
        return this.animSpec;
    }

    public final InterfaceC0526Fp getListener() {
        return this.listener;
    }

    public final InterfaceC2052dg getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        long jM73animateTomzRDjE0 = m73animateTomzRDjE0(IntSizeKt.IntSize(placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight()));
        return MeasureScope.CC.q(measureScope, IntSize.m5320getWidthimpl(jM73animateTomzRDjE0), IntSize.m5319getHeightimpl(jM73animateTomzRDjE0), null, new SizeAnimationModifier$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    public final void setAnimData(AnimData animData) {
        this.animData$delegate.setValue(animData);
    }

    public final void setListener(InterfaceC0526Fp interfaceC0526Fp) {
        this.listener = interfaceC0526Fp;
    }
}
