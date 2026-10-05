package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
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
public final class DrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final SwipeableState<DrawerValue> swipeableState;

    /* JADX INFO: renamed from: androidx.compose.material3.DrawerState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DrawerValue drawerValue) {
            AbstractC4492zt.h(drawerValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<DrawerState, DrawerValue> Saver(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return SaverKt.Saver(DrawerState$Companion$Saver$1.INSTANCE, new DrawerState$Companion$Saver$2(interfaceC3750qp));
        }

        private Companion() {
        }
    }

    public DrawerState(DrawerValue drawerValue, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawerValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        this.swipeableState = new SwipeableState<>(drawerValue, NavigationDrawerKt.AnimationSpec, interfaceC3750qp);
    }

    public static /* synthetic */ void getCurrentValue$annotations() {
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getSwipeableState$material3_release$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public static /* synthetic */ void isAnimationRunning$annotations() {
    }

    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$material3_release = this.swipeableState.animateTo$material3_release(drawerValue, animationSpec, interfaceC0793Of);
        return objAnimateTo$material3_release == AbstractC0378Bt.d() ? objAnimateTo$material3_release : FW.a;
    }

    public final Object close(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo = animateTo(DrawerValue.Closed, NavigationDrawerKt.AnimationSpec, interfaceC0793Of);
        return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
    }

    public final DrawerValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final State<Float> getOffset() {
        return this.swipeableState.getOffset();
    }

    public final SwipeableState<DrawerValue> getSwipeableState$material3_release() {
        return this.swipeableState;
    }

    public final DrawerValue getTargetValue() {
        return this.swipeableState.getTargetValue$material3_release();
    }

    public final boolean isAnimationRunning() {
        return this.swipeableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final Object open(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo = animateTo(DrawerValue.Open, NavigationDrawerKt.AnimationSpec, interfaceC0793Of);
        return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
    }

    public final Object snapTo(DrawerValue drawerValue, InterfaceC0793Of interfaceC0793Of) {
        Object objSnapTo$material3_release = this.swipeableState.snapTo$material3_release(drawerValue, interfaceC0793Of);
        return objSnapTo$material3_release == AbstractC0378Bt.d() ? objSnapTo$material3_release : FW.a;
    }

    public /* synthetic */ DrawerState(DrawerValue drawerValue, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(drawerValue, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp);
    }
}
