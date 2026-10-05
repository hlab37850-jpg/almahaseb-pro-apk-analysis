package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2261gC;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.M8;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public final class SnapFlingBehavior implements FlingBehavior {
    private final float DefaultScrollMotionDurationScaleFactor;
    private final float MinFlingVelocityDp;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final LazyListState lazyListState;
    private SnapFlingBehavior$motionScaleDuration$1 motionScaleDuration;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final float velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$animateDecay$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {MetaDo.META_SETRELABS}, m = "animateDecay")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.animateDecay(null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$animateDecay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LJ $previousValue;
        final /* synthetic */ float $targetOffset;
        final /* synthetic */ ScrollScope $this_animateDecay;
        final /* synthetic */ SnapFlingBehavior this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, SnapFlingBehavior snapFlingBehavior, LJ lj, ScrollScope scrollScope) {
            super(1);
            this.$targetOffset = f;
            this.this$0 = snapFlingBehavior;
            this.$previousValue = lj;
            this.$this_animateDecay = scrollScope;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Float, AnimationVector1D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animateDecay");
            if (Math.abs(animationScope.getValue().floatValue()) >= Math.abs(this.$targetOffset)) {
                SnapFlingBehavior.animateDecay$consumeDelta(animationScope, this.$this_animateDecay, this.this$0.coerceToTarget(animationScope.getValue().floatValue(), this.$targetOffset) - this.$previousValue.a);
                animationScope.cancelAnimation();
            } else {
                SnapFlingBehavior.animateDecay$consumeDelta(animationScope, this.$this_animateDecay, animationScope.getValue().floatValue() - this.$previousValue.a);
                this.$previousValue.a = animationScope.getValue().floatValue();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$animateSnap$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {MetaDo.META_PAINTREGION}, m = "animateSnap")
    public static final class C15591 extends AbstractC0819Pf {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C15591(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.animateSnap(null, 0.0f, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$animateSnap$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15602 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $cancelOffset;
        final /* synthetic */ LJ $consumedUpToNow;
        final /* synthetic */ ScrollScope $this_animateSnap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15602(float f, LJ lj, ScrollScope scrollScope) {
            super(1);
            this.$cancelOffset = f;
            this.$consumedUpToNow = lj;
            this.$this_animateSnap = scrollScope;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Float, AnimationVector1D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animateTo");
            float fCoerceToTarget = SnapFlingBehavior.this.coerceToTarget(animationScope.getValue().floatValue(), this.$cancelOffset);
            float f = fCoerceToTarget - this.$consumedUpToNow.a;
            float fScrollBy = this.$this_animateSnap.scrollBy(f);
            if (Math.abs(f - fScrollBy) > 0.5f || fCoerceToTarget != animationScope.getValue().floatValue()) {
                animationScope.cancelAnimation();
            }
            this.$consumedUpToNow.a += fScrollBy;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$fling$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {95}, m = "fling")
    public static final class C15611 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;

        public C15611(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.fling(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$longSnap$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {ShapeTypes.FLOW_CHART_PREDEFINED_PROCESS, ShapeTypes.FLOW_CHART_PREPARATION}, m = "longSnap")
    public static final class C15621 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C15621(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.longSnap(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$performFling$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {83}, m = "performFling")
    public static final class C15631 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;

        public C15631(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnapFlingBehavior$runApproach$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", l = {ShapeTypes.FLOW_CHART_MAGNETIC_TAPE}, m = "runApproach")
    public static final class C15641 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C15641(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehavior.this.runApproach(null, 0.0f, 0.0f, this);
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1] */
    public SnapFlingBehavior(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Density density) {
        AbstractC4492zt.h(lazyListState, "lazyListState");
        AbstractC4492zt.h(decayAnimationSpec, "decayAnimationSpec");
        AbstractC4492zt.h(animationSpec, "snapAnimationSpec");
        AbstractC4492zt.h(density, "density");
        this.lazyListState = lazyListState;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = animationSpec;
        this.density = density;
        this.velocityThreshold = density.mo333toPx0680j_4(this.MinFlingVelocityDp);
        this.motionScaleDuration = new MotionDurationScale() { // from class: androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1
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
                return this.this$0.DefaultScrollMotionDurationScaleFactor;
            }

            @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
            public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
                return MotionDurationScale.DefaultImpls.minusKey(this, cVar);
            }

            @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
            public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
                return MotionDurationScale.DefaultImpls.plus(this, interfaceC0988Vf);
            }
        };
        this.DefaultScrollMotionDurationScaleFactor = 1.0f;
        this.MinFlingVelocityDp = Dp.m5160constructorimpl(400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object animateDecay(ScrollScope scrollScope, float f, AnimationState<Float, AnimationVector1D> animationState, DecayAnimationSpec<Float> decayAnimationSpec, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        LJ lj;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            boolean z = animationState.getVelocity().floatValue() == 0.0f;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(f, this, lj2, scrollScope);
            anonymousClass1.L$0 = animationState;
            anonymousClass1.L$1 = lj2;
            anonymousClass1.F$0 = f;
            anonymousClass1.label = 1;
            if (SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec, !z, anonymousClass2, anonymousClass1) == objD) {
                return objD;
            }
            lj = lj2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = anonymousClass1.F$0;
            lj = (LJ) anonymousClass1.L$1;
            animationState = (AnimationState) anonymousClass1.L$0;
            LL.b(obj);
        }
        return new AnimationResult(E8.b(f - lj.a), animationState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope scrollScope, float f) {
        if (Math.abs(f - scrollScope.scrollBy(f)) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    public final Object animateSnap(ScrollScope scrollScope, float f, float f2, AnimationState<Float, AnimationVector1D> animationState, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15591 c15591;
        float f3;
        SnapFlingBehavior snapFlingBehavior;
        LJ lj;
        float f4;
        AnimationState<Float, AnimationVector1D> animationState2;
        if (interfaceC0793Of instanceof C15591) {
            c15591 = (C15591) interfaceC0793Of;
            int i = c15591.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15591.label = i - Integer.MIN_VALUE;
            } else {
                c15591 = new C15591(interfaceC0793Of);
            }
        } else {
            c15591 = new C15591(interfaceC0793Of);
        }
        C15591 c15592 = c15591;
        Object obj = c15592.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15592.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            float fFloatValue = animationState.getVelocity().floatValue();
            Float fB = E8.b(f);
            boolean z = animationState.getVelocity().floatValue() == 0.0f;
            C15602 c15602 = new C15602(f2, lj2, scrollScope);
            c15592.L$0 = this;
            c15592.L$1 = animationState;
            c15592.L$2 = lj2;
            f3 = f;
            c15592.F$0 = f3;
            c15592.F$1 = fFloatValue;
            c15592.label = 1;
            if (SuspendAnimationKt.animateTo(animationState, fB, animationSpec, !z, c15602, c15592) == objD) {
                return objD;
            }
            snapFlingBehavior = this;
            lj = lj2;
            f4 = fFloatValue;
            animationState2 = animationState;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f4 = c15592.F$1;
            float f5 = c15592.F$0;
            lj = (LJ) c15592.L$2;
            AnimationState<Float, AnimationVector1D> animationState3 = (AnimationState) c15592.L$1;
            snapFlingBehavior = (SnapFlingBehavior) c15592.L$0;
            LL.b(obj);
            f3 = f5;
            animationState2 = animationState3;
        }
        return new AnimationResult(E8.b(f3 - lj.a), AnimationStateKt.copy$default((AnimationState) animationState2, 0.0f, snapFlingBehavior.coerceToTarget(animationState2.getVelocity().floatValue(), f4), 0L, 0L, false, 29, (Object) null));
    }

    private final float calculateDistanceToDesiredSnapPosition(LazyListLayoutInfo lazyListLayoutInfo, LazyListItemInfo lazyListItemInfo) {
        float f = 2;
        return lazyListItemInfo.getOffset() - ((((getSingleAxisViewportSize(lazyListLayoutInfo) - lazyListLayoutInfo.getBeforeContentPadding()) - lazyListLayoutInfo.getAfterContentPadding()) / f) - (lazyListItemInfo.getSize() / f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float coerceToTarget(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? AbstractC3871sJ.f(f, f2) : AbstractC3871sJ.c(f, f2);
    }

    private final <T extends Comparable<? super T>> T component1(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "<this>");
        return (T) interfaceC0789Ob.getStart();
    }

    private final <T extends Comparable<? super T>> T component2(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "<this>");
        return (T) interfaceC0789Ob.getEndInclusive();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0034  */
    private final float findClosestOffset(float f, LazyListState lazyListState) {
        InterfaceC0789Ob interfaceC0789ObFindClosestOffset$calculateSnappingOffsetBounds = findClosestOffset$calculateSnappingOffsetBounds(lazyListState, this);
        float fFloatValue = ((Number) component1(interfaceC0789ObFindClosestOffset$calculateSnappingOffsetBounds)).floatValue();
        float fFloatValue2 = ((Number) component2(interfaceC0789ObFindClosestOffset$calculateSnappingOffsetBounds)).floatValue();
        float fSignum = Math.signum(f);
        if (fSignum == 0.0f) {
            if (Math.abs(fFloatValue2) <= Math.abs(fFloatValue)) {
                fFloatValue = fFloatValue2;
            }
        } else if (fSignum == 1.0f) {
            fFloatValue = fFloatValue2;
        } else if (fSignum != -1.0f) {
            fFloatValue = 0.0f;
        }
        if (findClosestOffset$isValidDistance(fFloatValue)) {
            return fFloatValue;
        }
        return 0.0f;
    }

    private static final InterfaceC0789Ob findClosestOffset$calculateSnappingOffsetBounds(LazyListState lazyListState, SnapFlingBehavior snapFlingBehavior) {
        LazyListLayoutInfo layoutInfo = lazyListState.getLayoutInfo();
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            float fCalculateDistanceToDesiredSnapPosition = snapFlingBehavior.calculateDistanceToDesiredSnapPosition(layoutInfo, visibleItemsInfo.get(i));
            if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f) {
                f = fCalculateDistanceToDesiredSnapPosition;
            }
            if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f2) {
                f2 = fCalculateDistanceToDesiredSnapPosition;
            }
        }
        return AbstractC3790rJ.b(f, f2);
    }

    private static final boolean findClosestOffset$isValidDistance(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fling(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15611 c15611;
        if (interfaceC0793Of instanceof C15611) {
            c15611 = (C15611) interfaceC0793Of;
            int i = c15611.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15611.label = i - Integer.MIN_VALUE;
            } else {
                c15611 = new C15611(interfaceC0793Of);
            }
        } else {
            c15611 = new C15611(interfaceC0793Of);
        }
        Object objG = c15611.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15611.label;
        if (i2 == 0) {
            LL.b(objG);
            SnapFlingBehavior$motionScaleDuration$1 snapFlingBehavior$motionScaleDuration$1 = this.motionScaleDuration;
            SnapFlingBehavior$fling$result$1 snapFlingBehavior$fling$result$1 = new SnapFlingBehavior$fling$result$1(f, this, scrollScope, null);
            c15611.label = 1;
            objG = M8.g(snapFlingBehavior$motionScaleDuration$1, snapFlingBehavior$fling$result$1, c15611);
            if (objG == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objG);
        }
        return (AnimationResult) objG;
    }

    private final float getItemSize() {
        if (getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        List<LazyListItemInfo> visibleItemsInfo = getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int size2 = 0;
        for (int i = 0; i < size; i++) {
            size2 += visibleItemsInfo.get(i).getSize();
        }
        return size2 / getVisibleItemsInfo().size();
    }

    private final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        return lazyListLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m5319getHeightimpl(lazyListLayoutInfo.mo587getViewportSizeYbymL2g()) : IntSize.m5320getWidthimpl(lazyListLayoutInfo.mo587getViewportSizeYbymL2g());
    }

    private final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object longSnap(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15621 c15621;
        SnapFlingBehavior snapFlingBehavior;
        ScrollScope scrollScope2 = scrollScope;
        if (interfaceC0793Of instanceof C15621) {
            c15621 = (C15621) interfaceC0793Of;
            int i = c15621.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15621.label = i - Integer.MIN_VALUE;
            } else {
                c15621 = new C15621(interfaceC0793Of);
            }
        } else {
            c15621 = new C15621(interfaceC0793Of);
        }
        C15621 c15622 = c15621;
        Object objRunApproach = c15622.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15622.label;
        if (i2 != 0) {
            if (i2 == 1) {
                scrollScope2 = (ScrollScope) c15622.L$1;
                SnapFlingBehavior snapFlingBehavior2 = (SnapFlingBehavior) c15622.L$0;
                LL.b(objRunApproach);
                snapFlingBehavior = snapFlingBehavior2;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(objRunApproach);
            }
        }
        LL.b(objRunApproach);
        float fC = AbstractC3871sJ.c(Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0.0f, f)) - getItemSize(), 0.0f);
        if (fC != 0.0f) {
            fC *= Math.signum(f);
        }
        c15622.L$0 = this;
        c15622.L$1 = scrollScope2;
        c15622.label = 1;
        objRunApproach = runApproach(scrollScope2, fC, f, c15622);
        if (objRunApproach == objD) {
            return objD;
        }
        snapFlingBehavior = this;
        AnimationResult animationResult = (AnimationResult) objRunApproach;
        float fFloatValue = ((Number) animationResult.component1()).floatValue();
        AnimationState<Float, AnimationVector1D> animationStateCopy$default = AnimationStateKt.copy$default(animationResult.component2(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        AnimationSpec<Float> animationSpec = snapFlingBehavior.snapAnimationSpec;
        c15622.L$0 = null;
        c15622.L$1 = null;
        c15622.label = 2;
        objRunApproach = snapFlingBehavior.animateSnap(scrollScope2, fFloatValue, fFloatValue, animationStateCopy$default, animationSpec, c15622);
        return objRunApproach == objD ? objD : objRunApproach;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object runApproach(ScrollScope scrollScope, float f, float f2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15641 c15641;
        SnapFlingBehavior snapFlingBehavior;
        if (interfaceC0793Of instanceof C15641) {
            c15641 = (C15641) interfaceC0793Of;
            int i = c15641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15641.label = i - Integer.MIN_VALUE;
            } else {
                c15641 = new C15641(interfaceC0793Of);
            }
        } else {
            c15641 = new C15641(interfaceC0793Of);
        }
        C15641 c15642 = c15641;
        Object objAnimateDecay = c15642.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15642.label;
        if (i2 == 0) {
            LL.b(objAnimateDecay);
            AnimationState<Float, AnimationVector1D> animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, f2, 0L, 0L, false, 28, null);
            DecayAnimationSpec<Float> decayAnimationSpec = this.decayAnimationSpec;
            c15642.L$0 = this;
            c15642.label = 1;
            objAnimateDecay = animateDecay(scrollScope, f, animationStateAnimationState$default, decayAnimationSpec, c15642);
            if (objAnimateDecay == objD) {
                return objD;
            }
            snapFlingBehavior = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            snapFlingBehavior = (SnapFlingBehavior) c15642.L$0;
            LL.b(objAnimateDecay);
        }
        AnimationState animationStateComponent2 = ((AnimationResult) objAnimateDecay).component2();
        return new AnimationResult(E8.b(snapFlingBehavior.findClosestOffset(((Number) animationStateComponent2.getVelocity()).floatValue(), snapFlingBehavior.lazyListState)), animationStateComponent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) {
        float fFindClosestOffset = findClosestOffset(0.0f, this.lazyListState);
        return animateSnap(scrollScope, fFindClosestOffset, fFindClosestOffset, AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null), this.snapAnimationSpec, interfaceC0793Of);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SnapFlingBehavior)) {
            return false;
        }
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
        return AbstractC4492zt.d(snapFlingBehavior.snapAnimationSpec, this.snapAnimationSpec) && AbstractC4492zt.d(snapFlingBehavior.decayAnimationSpec, this.decayAnimationSpec) && AbstractC4492zt.d(snapFlingBehavior.lazyListState, this.lazyListState) && AbstractC4492zt.d(snapFlingBehavior.density, this.density);
    }

    public int hashCode() {
        return (((((this.snapAnimationSpec.hashCode() * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.lazyListState.hashCode()) * 31) + this.density.hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15631 c15631;
        if (interfaceC0793Of instanceof C15631) {
            c15631 = (C15631) interfaceC0793Of;
            int i = c15631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15631.label = i - Integer.MIN_VALUE;
            } else {
                c15631 = new C15631(interfaceC0793Of);
            }
        } else {
            c15631 = new C15631(interfaceC0793Of);
        }
        Object objFling = c15631.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15631.label;
        if (i2 == 0) {
            LL.b(objFling);
            c15631.label = 1;
            objFling = fling(scrollScope, f, c15631);
            if (objFling == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objFling);
        }
        AnimationResult animationResult = (AnimationResult) objFling;
        return E8.b(((Number) animationResult.component1()).floatValue() != 0.0f ? ((Number) animationResult.component2().getVelocity()).floatValue() : 0.0f);
    }
}
