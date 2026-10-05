package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.PN;
import defpackage.XS;
import defpackage.YB;
import defpackage.ZB;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private final MutableIntState animationTargetPage$delegate;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final State currentPageOffsetFraction$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int indexToPrefetch;
    private final int initialPage;
    private final float initialPageOffsetFraction;
    private final MutableInteractionSource internalInteractionSource;
    private int numMeasurePasses;
    private MutableState<PagerLayoutInfo> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final MutableFloatState snapRemainingScrollOffset$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasScrollingForward;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", l = {453, 478, 490}, m = "animateScrollToPage")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        float F$0;
        int I$0;
        int I$1;
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
            return PagerState.this.animateScrollToPage(0, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", l = {502, 503}, m = "scroll$suspendImpl")
    public static final class C13881 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13881(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.scroll$suspendImpl(PagerState.this, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scrollToPage$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", l = {TypedValues.CycleType.TYPE_WAVE_SHAPE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ int $page;
        final /* synthetic */ float $pageOffsetFraction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, int i, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$pageOffsetFraction = f;
            this.$page = i;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return PagerState.this.new AnonymousClass2(this.$pageOffsetFraction, this.$page, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PagerState pagerState = PagerState.this;
                this.label = 1;
                if (pagerState.awaitScrollDependencies(this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            float f = this.$pageOffsetFraction;
            double d = f;
            if (-0.5d <= d && d <= 0.5d) {
                PagerState.this.scrollPosition.requestPosition(PagerState.this.coerceInPageRange(this.$page), AbstractC1210aB.c(PagerState.this.getPageAvailableSpace() * this.$pageOffsetFraction));
                Remeasurement remeasurement$foundation_release = PagerState.this.getRemeasurement$foundation_release();
                if (remeasurement$foundation_release != null) {
                    remeasurement$foundation_release.forceRemeasure();
                }
                return FW.a;
            }
            throw new IllegalArgumentException(("pageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
    }

    public PagerState() {
        this(0, 0.0f, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i2, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitScrollDependencies(InterfaceC0793Of interfaceC0793Of) {
        Object objWaitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(interfaceC0793Of);
        return objWaitForFirstLayout == AbstractC0378Bt.d() ? objWaitForFirstLayout : FW.a;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo pagerLayoutInfo) {
        if (this.indexToPrefetch == -1 || pagerLayoutInfo.getVisiblePagesInfo().isEmpty()) {
            return;
        }
        if (this.indexToPrefetch != (this.wasScrollingForward ? ((PageInfo) AbstractC3240kc.k0(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() + 1 : ((PageInfo) AbstractC3240kc.b0(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() - 1)) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return AbstractC3871sJ.l(i, 0, getPageCount() - 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAnimationTargetPage() {
        return this.animationTargetPage$delegate.getIntValue();
    }

    private final float getDistanceToSnapPosition() {
        PageInfo closestPageToSnapPosition = getLayoutInfo$foundation_release().getClosestPageToSnapPosition();
        if (closestPageToSnapPosition != null) {
            return SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(this.density, PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo$foundation_release()), getLayoutInfo$foundation_release().getBeforeContentPadding(), getLayoutInfo$foundation_release().getAfterContentPadding(), getLayoutInfo$foundation_release().getPageSize(), closestPageToSnapPosition.getOffset(), closestPageToSnapPosition.getIndex(), PagerStateKt.getSnapAlignmentStartToStart());
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPageAvailableSpace() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getPositionThresholdFraction() {
        return Math.min(this.density.mo333toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    private final List<PageInfo> getVisiblePages() {
        return this.pagerLayoutInfoState.getValue().getVisiblePagesInfo();
    }

    private final void notifyPrefetch(float f) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled) {
            PagerLayoutInfo layoutInfo$foundation_release = getLayoutInfo$foundation_release();
            if (layoutInfo$foundation_release.getVisiblePagesInfo().isEmpty()) {
                return;
            }
            boolean z = f < 0.0f;
            int index = z ? ((PageInfo) AbstractC3240kc.k0(layoutInfo$foundation_release.getVisiblePagesInfo())).getIndex() + 1 : ((PageInfo) AbstractC3240kc.b0(layoutInfo$foundation_release.getVisiblePagesInfo())).getIndex() - 1;
            if (index == this.indexToPrefetch || index < 0 || index >= layoutInfo$foundation_release.getPagesCount()) {
                return;
            }
            if (this.wasScrollingForward != z && (prefetchHandle = this.currentPrefetchHandle) != null) {
                prefetchHandle.cancel();
            }
            this.wasScrollingForward = z;
            this.indexToPrefetch = index;
            this.currentPrefetchHandle = this.prefetchState.m642schedulePrefetch0kLqBqw(index, this.premeasureConstraints);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float performScroll(float f) {
        if ((f < 0.0f && !getCanScrollForward()) || (f > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
        }
        float f2 = this.scrollToBeConsumed + f;
        this.scrollToBeConsumed = f2;
        if (Math.abs(f2) > 0.5f) {
            float f3 = this.scrollToBeConsumed;
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            if (this.prefetchingEnabled) {
                notifyPrefetch(f3 - this.scrollToBeConsumed);
            }
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            return f;
        }
        float f4 = f - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return f4;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object scroll$suspendImpl(PagerState pagerState, MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13881 c13881;
        if (interfaceC0793Of instanceof C13881) {
            c13881 = (C13881) interfaceC0793Of;
            int i = c13881.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13881.label = i - Integer.MIN_VALUE;
            } else {
                c13881 = pagerState.new C13881(interfaceC0793Of);
            }
        } else {
            c13881 = pagerState.new C13881(interfaceC0793Of);
        }
        Object obj = c13881.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13881.label;
        if (i2 != 0) {
            if (i2 == 1) {
                interfaceC0526Fp = (InterfaceC0526Fp) c13881.L$2;
                mutatePriority = (MutatePriority) c13881.L$1;
                pagerState = (PagerState) c13881.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        c13881.L$0 = pagerState;
        c13881.L$1 = mutatePriority;
        c13881.L$2 = interfaceC0526Fp;
        c13881.label = 1;
        if (pagerState.awaitScrollDependencies(c13881) == objD) {
            return objD;
        }
        ScrollableState scrollableState = pagerState.scrollableState;
        c13881.L$0 = null;
        c13881.L$1 = null;
        c13881.L$2 = null;
        c13881.label = 2;
        if (scrollableState.scroll(mutatePriority, interfaceC0526Fp, c13881) == objD) {
            return objD;
        }
        return FW.a;
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, InterfaceC0793Of interfaceC0793Of, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, interfaceC0793Of);
    }

    private final void setAnimationTargetPage(int i) {
        this.animationTargetPage$delegate.setIntValue(i);
    }

    private final void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setIntValue(i);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0143 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object animateScrollToPage(int i, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        PagerState pagerState;
        int currentPage;
        int iCoerceInPageRange;
        PagerState pagerState2;
        int iD;
        AnimationSpec<Float> animationSpec2;
        PagerState pagerState3;
        float f2;
        int i2;
        int pageAvailableSpace;
        int pageAvailableSpace2;
        float distanceToSnapPosition;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i4 = anonymousClass1.label;
        if (i4 != 0) {
            if (i4 == 1) {
                f = anonymousClass1.F$0;
                i = anonymousClass1.I$0;
                animationSpec = (AnimationSpec) anonymousClass1.L$1;
                PagerState pagerState4 = (PagerState) anonymousClass1.L$0;
                LL.b(obj);
                pagerState = pagerState4;
            } else if (i4 == 2) {
                iD = anonymousClass1.I$1;
                i2 = anonymousClass1.I$0;
                f2 = anonymousClass1.F$0;
                animationSpec2 = (AnimationSpec) anonymousClass1.L$1;
                pagerState3 = (PagerState) anonymousClass1.L$0;
                LL.b(obj);
                iCoerceInPageRange = i2;
                f = f2;
                animationSpec = animationSpec2;
                currentPage = iD;
                pagerState2 = pagerState3;
                pageAvailableSpace = iCoerceInPageRange * pagerState2.getPageAvailableSpace();
                pageAvailableSpace2 = currentPage * pagerState2.getPageAvailableSpace();
                distanceToSnapPosition = pagerState2.getDistanceToSnapPosition() + (f * pagerState2.getPageAvailableSpace());
                anonymousClass1.L$0 = pagerState2;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                if (ScrollExtensionsKt.animateScrollBy(pagerState2, (pageAvailableSpace - pageAvailableSpace2) + distanceToSnapPosition, animationSpec, anonymousClass1) == objD) {
                    return objD;
                }
            } else {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pagerState2 = (PagerState) anonymousClass1.L$0;
                LL.b(obj);
            }
            pagerState2.setAnimationTargetPage(-1);
            return FW.a;
        }
        LL.b(obj);
        if (i == getCurrentPage() && getCurrentPageOffsetFraction() == f) {
            return FW.a;
        }
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = animationSpec;
        anonymousClass1.I$0 = i;
        anonymousClass1.F$0 = f;
        anonymousClass1.label = 1;
        if (awaitScrollDependencies(anonymousClass1) == objD) {
            return objD;
        }
        pagerState = this;
        double d = f;
        if (-0.5d > d || d > 0.5d) {
            throw new IllegalArgumentException(("pageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
        currentPage = pagerState.getCurrentPage();
        iCoerceInPageRange = pagerState.coerceInPageRange(i);
        pagerState.setAnimationTargetPage(iCoerceInPageRange);
        int index = ((PageInfo) AbstractC3240kc.b0(pagerState.getVisiblePages())).getIndex();
        int index2 = ((PageInfo) AbstractC3240kc.k0(pagerState.getVisiblePages())).getIndex();
        if (((i <= pagerState.getCurrentPage() || i <= index2) && (i >= pagerState.getCurrentPage() || i >= index)) || Math.abs(i - pagerState.getCurrentPage()) < 3) {
            pagerState2 = pagerState;
        } else {
            iD = i > pagerState.getCurrentPage() ? AbstractC3871sJ.d(i - pagerState.getVisiblePages().size(), currentPage) : i + AbstractC3871sJ.g(pagerState.getVisiblePages().size(), currentPage);
            anonymousClass1.L$0 = pagerState;
            anonymousClass1.L$1 = animationSpec;
            anonymousClass1.F$0 = f;
            anonymousClass1.I$0 = iCoerceInPageRange;
            anonymousClass1.I$1 = iD;
            anonymousClass1.label = 2;
            if (scrollToPage$default(pagerState, iD, 0.0f, anonymousClass1, 2, null) == objD) {
                return objD;
            }
            animationSpec2 = animationSpec;
            pagerState3 = pagerState;
            f2 = f;
            i2 = iCoerceInPageRange;
            iCoerceInPageRange = i2;
            f = f2;
            animationSpec = animationSpec2;
            currentPage = iD;
            pagerState2 = pagerState3;
        }
        pageAvailableSpace = iCoerceInPageRange * pagerState2.getPageAvailableSpace();
        pageAvailableSpace2 = currentPage * pagerState2.getPageAvailableSpace();
        distanceToSnapPosition = pagerState2.getDistanceToSnapPosition() + (f * pagerState2.getPageAvailableSpace());
        anonymousClass1.L$0 = pagerState2;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 3;
        if (ScrollExtensionsKt.animateScrollBy(pagerState2, (pageAvailableSpace - pageAvailableSpace2) + distanceToSnapPosition, animationSpec, anonymousClass1) == objD) {
            return objD;
        }
        pagerState2.setAnimationTargetPage(-1);
        return FW.a;
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult pagerMeasureResult) {
        AbstractC4492zt.h(pagerMeasureResult, "result");
        this.scrollPosition.updateFromMeasureResult(pagerMeasureResult);
        this.scrollToBeConsumed -= pagerMeasureResult.getConsumedScroll();
        this.pagerLayoutInfoState.setValue(pagerMeasureResult);
        setCanScrollForward(pagerMeasureResult.getCanScrollForward());
        MeasuredPage firstVisiblePage = pagerMeasureResult.getFirstVisiblePage();
        setCanScrollBackward(((firstVisiblePage != null ? firstVisiblePage.getIndex() : 0) == 0 && pagerMeasureResult.getFirstVisiblePageOffset() == 0) ? false : true);
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(pagerMeasureResult);
        if (isScrollInProgress()) {
            return;
        }
        setSettledPageState(getCurrentPage());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return ((Number) this.currentPageOffsetFraction$delegate.getValue()).floatValue();
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.scrollPosition.getFirstVisiblePage();
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.scrollPosition.getScrollOffset();
    }

    public final int getInitialPage() {
        return this.initialPage;
    }

    public final float getInitialPageOffsetFraction() {
        return this.initialPageOffsetFraction;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final PagerLayoutInfo getLayoutInfo$foundation_release() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final C1001Vs getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final float getOffsetFractionForPage(int i) {
        if (i >= 0 && i <= getPageCount()) {
            return (getCurrentPage() - i) + getCurrentPageOffsetFraction();
        }
        throw new IllegalArgumentException(("page " + i + " is not within the range 0 to pageCount").toString());
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    /* JADX INFO: renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name */
    public final long m703getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final float getSnapRemainingScrollOffset$foundation_release() {
        return this.snapRemainingScrollOffset$delegate.getFloatValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    /* JADX INFO: renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m704getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).m2808unboximpl();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return scroll$suspendImpl(this, mutatePriority, interfaceC0526Fp, interfaceC0793Of);
    }

    public final Object scrollToPage(int i, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objE = PN.e(this, null, new AnonymousClass2(f, i, null), interfaceC0793Of, 1, null);
        return objE == AbstractC0378Bt.d() ? objE : FW.a;
    }

    public final void setDensity$foundation_release(Density density) {
        AbstractC4492zt.h(density, "<set-?>");
        this.density = density;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    /* JADX INFO: renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m705setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    public final void setSnapRemainingScrollOffset$foundation_release(float f) {
        this.snapRemainingScrollOffset$delegate.setFloatValue(f);
    }

    /* JADX INFO: renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m706setUpDownDifferencek4lQ0M$foundation_release(long j) {
        this.upDownDifference$delegate.setValue(Offset.m2787boximpl(j));
    }

    public PagerState(int i, float f) {
        this.initialPage = i;
        this.initialPageOffsetFraction = f;
        double d = f;
        if (-0.5d > d || d > 0.5d) {
            throw new IllegalArgumentException(("initialPageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
        this.upDownDifference$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2787boximpl(Offset.Companion.m2814getZeroF1C5BW0()), null, 2, null);
        this.snapRemainingScrollOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i, 0);
        this.scrollPosition = pagerScrollPosition;
        this.scrollableState = ScrollableStateKt.ScrollableState(new PagerState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PagerStateKt.getEmptyLayoutInfo(), null, 2, null);
        this.density = PagerStateKt.UnitDensity;
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.animationTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$settledPage$2(this));
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$targetPage$2(this));
        this.currentPageOffsetFraction$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$currentPageOffsetFraction$2(this));
        this.prefetchState = new LazyLayoutPrefetchState();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
            public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
                return ZB.a(this, interfaceC3750qp);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
            public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
                return ZB.b(this, interfaceC3750qp);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
            public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
                return ZB.c(this, obj, interfaceC0526Fp);
            }

            @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
            public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
                return ZB.d(this, obj, interfaceC0526Fp);
            }

            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                AbstractC4492zt.h(remeasurement, "remeasurement");
                this.this$0.setRemeasurement(remeasurement);
            }

            @Override // androidx.compose.ui.Modifier
            public /* synthetic */ Modifier then(Modifier modifier) {
                return YB.a(this, modifier);
            }
        };
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        pagerScrollPosition.getNearestRangeState();
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }

    public /* synthetic */ PagerState(int i, float f, int i2, AbstractC0419Di abstractC0419Di) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }
}
