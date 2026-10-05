package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AD;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1813bg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3347lu;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC3511nu;
import defpackage.AbstractC3566ob;
import defpackage.AbstractC3574of;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.EnumC2379hg;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;
import defpackage.O8;
import defpackage.PN;
import defpackage.XS;
import defpackage.YB;
import defpackage.ZB;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    private final UpdatableAnimationState animationState;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private LayoutCoordinates coordinates;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private final Modifier modifier;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final InterfaceC2052dg scope;
    private final ScrollableState scrollState;
    private boolean trackingFocusedChild;
    private long viewportSize;

    public static final class Request {
        private final InterfaceC4293xa continuation;
        private final InterfaceC3588op currentBounds;

        public Request(InterfaceC3588op interfaceC3588op, InterfaceC4293xa interfaceC4293xa) {
            AbstractC4492zt.h(interfaceC3588op, "currentBounds");
            AbstractC4492zt.h(interfaceC4293xa, "continuation");
            this.currentBounds = interfaceC3588op;
            this.continuation = interfaceC4293xa;
        }

        public final InterfaceC4293xa getContinuation() {
            return this.continuation;
        }

        public final InterfaceC3588op getCurrentBounds() {
            return this.currentBounds;
        }

        public String toString() {
            AbstractC3574of.a(this.continuation.getContext().get(AbstractC1813bg.a));
            StringBuilder sb = new StringBuilder();
            sb.append("Request@");
            String string = Integer.toString(hashCode(), AbstractC3566ob.a(16));
            AbstractC4492zt.g(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            sb.append("(");
            sb.append("currentBounds()=");
            sb.append(this.currentBounds.invoke());
            sb.append(", continuation=");
            sb.append(this.continuation);
            sb.append(')');
            return sb.toString();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", l = {193}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1", f = "ContentInViewModifier.kt", l = {198}, m = "invokeSuspend")
        public static final class C00321 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC1830bu $animationJob;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewModifier this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00331 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ ScrollScope $$this$scroll;
                final /* synthetic */ InterfaceC1830bu $animationJob;
                final /* synthetic */ ContentInViewModifier this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00331(ContentInViewModifier contentInViewModifier, ScrollScope scrollScope, InterfaceC1830bu interfaceC1830bu) {
                    super(1);
                    this.this$0 = contentInViewModifier;
                    this.$$this$scroll = scrollScope;
                    this.$animationJob = interfaceC1830bu;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return FW.a;
                }

                public final void invoke(float f) {
                    float f2 = this.this$0.reverseDirection ? 1.0f : -1.0f;
                    float fScrollBy = f2 * this.$$this$scroll.scrollBy(f2 * f);
                    if (fScrollBy < f) {
                        AbstractC3511nu.f(this.$animationJob, "Scroll animation cancelled because scroll was not consumed (" + fScrollBy + " < " + f + ')', null, 2, null);
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
                final /* synthetic */ ContentInViewModifier this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(ContentInViewModifier contentInViewModifier) {
                    super(0);
                    this.this$0 = contentInViewModifier;
                }

                @Override // defpackage.InterfaceC3588op
                public /* bridge */ /* synthetic */ Object invoke() {
                    m262invoke();
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m262invoke() {
                    BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = this.this$0.bringIntoViewRequests;
                    ContentInViewModifier contentInViewModifier = this.this$0;
                    while (true) {
                        if (!bringIntoViewRequestPriorityQueue.requests.isNotEmpty()) {
                            break;
                        }
                        Rect rect = (Rect) ((Request) bringIntoViewRequestPriorityQueue.requests.last()).getCurrentBounds().invoke();
                        if (!(rect == null ? true : ContentInViewModifier.m259isMaxVisibleO0kMr_c$default(contentInViewModifier, rect, 0L, 1, null))) {
                            break;
                        } else {
                            ((Request) bringIntoViewRequestPriorityQueue.requests.removeAt(bringIntoViewRequestPriorityQueue.requests.getSize() - 1)).getContinuation().resumeWith(KL.a(FW.a));
                        }
                    }
                    if (this.this$0.trackingFocusedChild) {
                        Rect focusedChildBounds = this.this$0.getFocusedChildBounds();
                        if (focusedChildBounds != null && ContentInViewModifier.m259isMaxVisibleO0kMr_c$default(this.this$0, focusedChildBounds, 0L, 1, null)) {
                            this.this$0.trackingFocusedChild = false;
                        }
                    }
                    this.this$0.animationState.setValue(this.this$0.calculateScrollDelta());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00321(ContentInViewModifier contentInViewModifier, InterfaceC1830bu interfaceC1830bu, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.this$0 = contentInViewModifier;
                this.$animationJob = interfaceC1830bu;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C00321 c00321 = new C00321(this.this$0, this.$animationJob, interfaceC0793Of);
                c00321.L$0 = obj;
                return c00321;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
                return ((C00321) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    ScrollScope scrollScope = (ScrollScope) this.L$0;
                    this.this$0.animationState.setValue(this.this$0.calculateScrollDelta());
                    UpdatableAnimationState updatableAnimationState = this.this$0.animationState;
                    C00331 c00331 = new C00331(this.this$0, scrollScope, this.$animationJob);
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0);
                    this.label = 1;
                    if (updatableAnimationState.animateToZero(c00331, anonymousClass2, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = ContentInViewModifier.this.new AnonymousClass1(interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        LL.b(obj);
                        InterfaceC1830bu interfaceC1830buL = AbstractC3347lu.l(((InterfaceC2052dg) this.L$0).getCoroutineContext());
                        ContentInViewModifier.this.isAnimationRunning = true;
                        ScrollableState scrollableState = ContentInViewModifier.this.scrollState;
                        C00321 c00321 = new C00321(ContentInViewModifier.this, interfaceC1830buL, null);
                        this.label = 1;
                        if (PN.e(scrollableState, null, c00321, this, 1, null) == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    ContentInViewModifier.this.bringIntoViewRequests.resumeAndRemoveAll();
                    ContentInViewModifier.this.isAnimationRunning = false;
                    ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(null);
                    ContentInViewModifier.this.trackingFocusedChild = false;
                    return FW.a;
                } catch (CancellationException e) {
                    throw e;
                }
            } catch (Throwable th) {
                ContentInViewModifier.this.isAnimationRunning = false;
                ContentInViewModifier.this.bringIntoViewRequests.cancelAndRemoveAll(null);
                ContentInViewModifier.this.trackingFocusedChild = false;
                throw th;
            }
        }
    }

    public ContentInViewModifier(InterfaceC2052dg interfaceC2052dg, Orientation orientation, ScrollableState scrollableState, boolean z) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(scrollableState, "scrollState");
        this.scope = interfaceC2052dg;
        this.orientation = orientation;
        this.scrollState = scrollableState;
        this.reverseDirection = z;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = IntSize.Companion.m5325getZeroYbymL2g();
        this.animationState = new UpdatableAnimationState();
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new ContentInViewModifier$modifier$1(this)), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta() {
        if (IntSize.m5318equalsimpl0(this.viewportSize, IntSize.Companion.m5325getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectFindBringIntoViewRequest = findBringIntoViewRequest();
        if (rectFindBringIntoViewRequest == null) {
            rectFindBringIntoViewRequest = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectFindBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long jM5330toSizeozmzZPI = IntSizeKt.m5330toSizeozmzZPI(this.viewportSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return relocationDistance(rectFindBringIntoViewRequest.getTop(), rectFindBringIntoViewRequest.getBottom(), Size.m2864getHeightimpl(jM5330toSizeozmzZPI));
        }
        if (i == 2) {
            return relocationDistance(rectFindBringIntoViewRequest.getLeft(), rectFindBringIntoViewRequest.getRight(), Size.m2867getWidthimpl(jM5330toSizeozmzZPI));
        }
        throw new AD();
    }

    /* JADX INFO: renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m255compareToTemP2vQ(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return AbstractC4492zt.j(IntSize.m5319getHeightimpl(j), IntSize.m5319getHeightimpl(j2));
        }
        if (i == 2) {
            return AbstractC4492zt.j(IntSize.m5320getWidthimpl(j), IntSize.m5320getWidthimpl(j2));
        }
        throw new AD();
    }

    /* JADX INFO: renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m256compareToiLBOSCw(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Float.compare(Size.m2864getHeightimpl(j), Size.m2864getHeightimpl(j2));
        }
        if (i == 2) {
            return Float.compare(Size.m2867getWidthimpl(j), Size.m2867getWidthimpl(j2));
        }
        throw new AD();
    }

    /* JADX INFO: renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m257computeDestinationO0kMr_c(Rect rect, long j) {
        return rect.m2835translatek4lQ0M(Offset.m2807unaryMinusF1C5BW0(m260relocationOffsetBMxPBkI(rect, j)));
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector mutableVector = this.bringIntoViewRequests.requests;
        int size = mutableVector.getSize();
        Rect rect = null;
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                Rect rect2 = (Rect) ((Request) content[i]).getCurrentBounds().invoke();
                if (rect2 != null) {
                    if (m256compareToiLBOSCw(rect2.m2831getSizeNHjbRc(), IntSizeKt.m5330toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect;
                    }
                    rect = rect2;
                }
                i--;
            } while (i >= 0);
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.coordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.focusedChild) != null) {
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, false);
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m258isMaxVisibleO0kMr_c(Rect rect, long j) {
        return Offset.m2795equalsimpl0(m260relocationOffsetBMxPBkI(rect, j), Offset.Companion.m2814getZeroF1C5BW0());
    }

    /* JADX INFO: renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ boolean m259isMaxVisibleO0kMr_c$default(ContentInViewModifier contentInViewModifier, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewModifier.viewportSize;
        }
        return contentInViewModifier.m258isMaxVisibleO0kMr_c(rect, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        if (this.isAnimationRunning) {
            throw new IllegalStateException("Check failed.");
        }
        O8.d(this.scope, null, EnumC2379hg.UNDISPATCHED, new AnonymousClass1(null), 1, null);
    }

    private final float relocationDistance(float f, float f2, float f3) {
        if ((f >= 0.0f && f2 <= f3) || (f < 0.0f && f2 > f3)) {
            return 0.0f;
        }
        float f4 = f2 - f3;
        return Math.abs(f) < Math.abs(f4) ? f : f4;
    }

    /* JADX INFO: renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m260relocationOffsetBMxPBkI(Rect rect, long j) {
        long jM5330toSizeozmzZPI = IntSizeKt.m5330toSizeozmzZPI(j);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return OffsetKt.Offset(0.0f, relocationDistance(rect.getTop(), rect.getBottom(), Size.m2864getHeightimpl(jM5330toSizeozmzZPI)));
        }
        if (i == 2) {
            return OffsetKt.Offset(relocationDistance(rect.getLeft(), rect.getRight(), Size.m2867getWidthimpl(jM5330toSizeozmzZPI)), 0.0f);
        }
        throw new AD();
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
        return ZB.a(this, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
        return ZB.b(this, interfaceC3750qp);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        Rect rect = (Rect) interfaceC3588op.invoke();
        if (rect == null || m259isMaxVisibleO0kMr_c$default(this, rect, 0L, 1, null)) {
            return FW.a;
        }
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        if (this.bringIntoViewRequests.enqueue(new Request(interfaceC3588op, c4374ya)) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect rect) {
        AbstractC4492zt.h(rect, "localRect");
        if (IntSize.m5318equalsimpl0(this.viewportSize, IntSize.Companion.m5325getZeroYbymL2g())) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return m257computeDestinationO0kMr_c(rect, this.viewportSize);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.c(this, obj, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.d(this, obj, interfaceC0526Fp);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "coordinates");
        this.coordinates = layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo261onRemeasuredozmzZPI(long j) {
        Rect focusedChildBounds;
        long j2 = this.viewportSize;
        this.viewportSize = j;
        if (m255compareToTemP2vQ(j, j2) < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m258isMaxVisibleO0kMr_c(rect, j2) && !m258isMaxVisibleO0kMr_c(focusedChildBounds, j)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }
}
