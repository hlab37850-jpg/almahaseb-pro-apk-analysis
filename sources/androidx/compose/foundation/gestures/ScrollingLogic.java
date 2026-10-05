package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.LL;
import defpackage.NJ;
import defpackage.PN;

/* JADX INFO: loaded from: classes.dex */
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation, boolean z, State<NestedScrollDispatcher> state, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(state, "nestedScrollDispatcher");
        AbstractC4492zt.h(scrollableState, "scrollableState");
        AbstractC4492zt.h(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = state;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        this.isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m344dispatchScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        AbstractC4492zt.h(scrollScope, "$this$dispatchScroll");
        long jM349singleAxisOffsetMKHz9U = m349singleAxisOffsetMKHz9U(j);
        ScrollingLogic$dispatchScroll$performScroll$1 scrollingLogic$dispatchScroll$performScroll$1 = new ScrollingLogic$dispatchScroll$performScroll$1(this, i, scrollScope);
        return (this.overscrollEffect == null || !getShouldDispatchOverscroll()) ? ((Offset) scrollingLogic$dispatchScroll$performScroll$1.invoke(Offset.m2787boximpl(jM349singleAxisOffsetMKHz9U))).m2808unboximpl() : this.overscrollEffect.mo162applyToScrollRhakbz0(jM349singleAxisOffsetMKHz9U, i, scrollingLogic$dispatchScroll$performScroll$1);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m345doFlingAnimationQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        NJ nj;
        if (interfaceC0793Of instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) interfaceC0793Of;
            int i = scrollingLogic$doFlingAnimation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, interfaceC0793Of);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, interfaceC0793Of);
        }
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$2 = scrollingLogic$doFlingAnimation$1;
        Object obj = scrollingLogic$doFlingAnimation$2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = scrollingLogic$doFlingAnimation$2.label;
        if (i2 == 0) {
            LL.b(obj);
            NJ nj2 = new NJ();
            nj2.a = j;
            ScrollableState scrollableState = this.scrollableState;
            ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$3 = new ScrollingLogic$doFlingAnimation$2(this, nj2, j, null);
            scrollingLogic$doFlingAnimation$2.L$0 = nj2;
            scrollingLogic$doFlingAnimation$2.label = 1;
            if (PN.e(scrollableState, null, scrollingLogic$doFlingAnimation$3, scrollingLogic$doFlingAnimation$2, 1, null) == objD) {
                return objD;
            }
            nj = nj2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nj = (NJ) scrollingLogic$doFlingAnimation$2.L$0;
            LL.b(obj);
        }
        return Velocity.m5376boximpl(nj.a);
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m346onDragStoppedsFctU(long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        ScrollingLogic$onDragStopped$1 scrollingLogic$onDragStopped$1;
        ScrollingLogic scrollingLogic;
        if (interfaceC0793Of instanceof ScrollingLogic$onDragStopped$1) {
            scrollingLogic$onDragStopped$1 = (ScrollingLogic$onDragStopped$1) interfaceC0793Of;
            int i = scrollingLogic$onDragStopped$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollingLogic$onDragStopped$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollingLogic$onDragStopped$1 = new ScrollingLogic$onDragStopped$1(this, interfaceC0793Of);
            }
        } else {
            scrollingLogic$onDragStopped$1 = new ScrollingLogic$onDragStopped$1(this, interfaceC0793Of);
        }
        Object obj = scrollingLogic$onDragStopped$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = scrollingLogic$onDragStopped$1.label;
        if (i2 == 0) {
            LL.b(obj);
            registerNestedFling(true);
            long jM350singleAxisVelocityAH228Gc = m350singleAxisVelocityAH228Gc(j);
            ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
            if (this.overscrollEffect == null || !getShouldDispatchOverscroll()) {
                Velocity velocityM5376boximpl = Velocity.m5376boximpl(jM350singleAxisVelocityAH228Gc);
                scrollingLogic$onDragStopped$1.L$0 = this;
                scrollingLogic$onDragStopped$1.label = 2;
                if (scrollingLogic$onDragStopped$performFling$1.mo13invoke(velocityM5376boximpl, scrollingLogic$onDragStopped$1) == objD) {
                    return objD;
                }
            } else {
                OverscrollEffect overscrollEffect = this.overscrollEffect;
                scrollingLogic$onDragStopped$1.L$0 = this;
                scrollingLogic$onDragStopped$1.label = 1;
                if (overscrollEffect.mo161applyToFlingBMRW4eQ(jM350singleAxisVelocityAH228Gc, scrollingLogic$onDragStopped$performFling$1, scrollingLogic$onDragStopped$1) == objD) {
                    return objD;
                }
            }
            scrollingLogic = this;
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scrollingLogic = (ScrollingLogic) scrollingLogic$onDragStopped$1.L$0;
            LL.b(obj);
        }
        scrollingLogic.registerNestedFling(false);
        return FW.a;
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m347performRawScrollMKHz9U(long j) {
        return this.scrollableState.isScrollInProgress() ? Offset.Companion.m2814getZeroF1C5BW0() : m353toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m352toFloatk4lQ0M(j)))));
    }

    public final void registerNestedFling(boolean z) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z));
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m348reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m2805timestuRUvjQ(j, -1.0f) : j;
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m349singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2792copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m2792copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m350singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5381copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m5381copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m351toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5385getXimpl(j) : Velocity.m5386getYimpl(j);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m352toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2798getXimpl(j) : Offset.m2799getYimpl(j);
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m353toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m354updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5381copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m5381copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }
}
