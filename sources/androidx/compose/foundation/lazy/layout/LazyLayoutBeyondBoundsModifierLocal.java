package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final Companion Companion = new Companion(null);
    private static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, LayoutDirection layoutDirection, Orientation orientation) {
        AbstractC4492zt.h(lazyLayoutBeyondBoundsState, "state");
        AbstractC4492zt.h(lazyLayoutBeyondBoundsInfo, "beyondBoundsInfo");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(orientation, "orientation");
        this.state = lazyLayoutBeyondBoundsState;
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m633addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        int start = interval.getStart();
        int end = interval.getEnd();
        if (m635isForward4vf7U8o(i)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m634hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (m636isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        if (m635isForward4vf7U8o(i)) {
            if (interval.getEnd() >= this.state.getItemCount() - 1) {
                return false;
            }
        } else if (interval.getStart() <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m635isForward4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4145getBeforehoxUOeE())) {
            return false;
        }
        if (!BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4144getAfterhoxUOeE())) {
            if (BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4143getAbovehoxUOeE())) {
                return this.reverseLayout;
            }
            if (BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4146getBelowhoxUOeE())) {
                if (this.reverseLayout) {
                    return false;
                }
            } else if (BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4147getLefthoxUOeE())) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
                if (i2 == 1) {
                    return this.reverseLayout;
                }
                if (i2 != 2) {
                    throw new AD();
                }
                if (this.reverseLayout) {
                    return false;
                }
            } else {
                if (!BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4148getRighthoxUOeE())) {
                    LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                    throw new C1182Zu();
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        return this.reverseLayout;
                    }
                    throw new AD();
                }
                if (this.reverseLayout) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m636isOppositeToOrientation4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (!(BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4143getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4146getBelowhoxUOeE()))) {
            if (!(BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4147getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4148getRighthoxUOeE()))) {
                if (!(BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4145getBeforehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4139equalsimpl0(i, companion.m4144getAfterhoxUOeE()))) {
                    LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                    throw new C1182Zu();
                }
            } else if (this.orientation == Orientation.Vertical) {
                return true;
            }
        } else if (this.orientation == Orientation.Horizontal) {
            return true;
        }
        return false;
    }

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

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo637layouto7g1Pn8(final int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return (T) interfaceC3750qp.invoke(emptyBeyondBoundsScope);
        }
        int lastPlacedIndex = m635isForward4vf7U8o(i) ? this.state.getLastPlacedIndex() : this.state.getFirstPlacedIndex();
        final OJ oj = new OJ();
        oj.a = this.beyondBoundsInfo.addInterval(lastPlacedIndex, lastPlacedIndex);
        T t = null;
        while (t == null && m634hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) oj.a, i)) {
            LazyLayoutBeyondBoundsInfo.Interval intervalM633addNextIntervalFR3nfPY = m633addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) oj.a, i);
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) oj.a);
            oj.a = intervalM633addNextIntervalFR3nfPY;
            this.state.remeasure();
            t = (T) interfaceC3750qp.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m634hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) oj.a, i);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) oj.a);
        this.state.remeasure();
        return t;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }
}
