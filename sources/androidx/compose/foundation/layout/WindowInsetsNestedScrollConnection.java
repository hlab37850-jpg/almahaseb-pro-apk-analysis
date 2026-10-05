package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4049uZ;
import defpackage.AbstractC4211wZ;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.LJ;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private InterfaceC1830bu animationJob;
    private final CancellationSignal cancellationSignal;
    private InterfaceC4293xa continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$animationEnded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(Throwable th) {
            AbstractC4492zt.h(th, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$dispose$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13491 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13491 INSTANCE = new C13491();

        public C13491() {
            super(1);
        }

        public final void invoke(Throwable th) {
            AbstractC4492zt.h(th, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$onReady$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13501 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13501 INSTANCE = new C13501();

        public C13501() {
            super(1);
        }

        public final void invoke(Throwable th) {
            AbstractC4492zt.h(th, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }
    }

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view, SideCalculator sideCalculator, Density density) {
        AbstractC4492zt.h(androidWindowInsets, "windowInsets");
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(sideCalculator, "sideCalculator");
        AbstractC4492zt.h(density, "density");
        this.windowInsets = androidWindowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
        this.cancellationSignal = new CancellationSignal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float f) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
            AbstractC4492zt.g(currentInsets, "it.currentInsets");
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, AbstractC1210aB.c(f)), 1.0f, 0.0f);
        }
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if (windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady() && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        InterfaceC4293xa interfaceC4293xa = this.continuation;
        if (interfaceC4293xa != null) {
            interfaceC4293xa.k(null, AnonymousClass1.INSTANCE);
        }
        this.continuation = null;
        InterfaceC1830bu interfaceC1830bu = this.animationJob;
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(new WindowInsetsAnimationCancelledException());
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX INFO: renamed from: fling-huYlsQE, reason: not valid java name */
    public final Object m560flinghuYlsQE(long j, float f, boolean z, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        WindowInsetsNestedScrollConnection$fling$1 windowInsetsNestedScrollConnection$fling$1;
        long j2;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2;
        LJ lj;
        long j3;
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection3;
        long j4;
        float f2 = f;
        if (interfaceC0793Of instanceof WindowInsetsNestedScrollConnection$fling$1) {
            windowInsetsNestedScrollConnection$fling$1 = (WindowInsetsNestedScrollConnection$fling$1) interfaceC0793Of;
            int i = windowInsetsNestedScrollConnection$fling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                windowInsetsNestedScrollConnection$fling$1.label = i - Integer.MIN_VALUE;
            } else {
                windowInsetsNestedScrollConnection$fling$1 = new WindowInsetsNestedScrollConnection$fling$1(this, interfaceC0793Of);
            }
        } else {
            windowInsetsNestedScrollConnection$fling$1 = new WindowInsetsNestedScrollConnection$fling$1(this, interfaceC0793Of);
        }
        Object obj = windowInsetsNestedScrollConnection$fling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = windowInsetsNestedScrollConnection$fling$1.label;
        if (i2 == 0) {
            LL.b(obj);
            InterfaceC1830bu interfaceC1830bu = this.animationJob;
            if (interfaceC1830bu != null) {
                interfaceC1830bu.cancel(new WindowInsetsAnimationCancelledException());
            }
            this.animationJob = null;
            this.partialConsumption = 0.0f;
            if ((f2 == 0.0f && !z) || (this.animationController == null && this.windowInsets.isVisible() == z)) {
                return Velocity.m5376boximpl(Velocity.Companion.m5396getZero9UxMQ8M());
            }
            windowInsetsNestedScrollConnection$fling$1.L$0 = this;
            windowInsetsNestedScrollConnection$fling$1.J$0 = j;
            windowInsetsNestedScrollConnection$fling$1.F$0 = f2;
            windowInsetsNestedScrollConnection$fling$1.label = 1;
            Object animationController = getAnimationController(windowInsetsNestedScrollConnection$fling$1);
            if (animationController == objD) {
                return objD;
            }
            j2 = j;
            obj = animationController;
            windowInsetsNestedScrollConnection = this;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    j3 = windowInsetsNestedScrollConnection$fling$1.J$0;
                    lj = (LJ) windowInsetsNestedScrollConnection$fling$1.L$1;
                    windowInsetsNestedScrollConnection2 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                    LL.b(obj);
                    return Velocity.m5376boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo514consumedVelocityQWom1Mo(j3, lj.a));
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j4 = windowInsetsNestedScrollConnection$fling$1.J$0;
                windowInsetsNestedScrollConnection3 = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
                LL.b(obj);
                return Velocity.m5376boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo514consumedVelocityQWom1Mo(j4, 0.0f));
            }
            f2 = windowInsetsNestedScrollConnection$fling$1.F$0;
            j2 = windowInsetsNestedScrollConnection$fling$1.J$0;
            windowInsetsNestedScrollConnection = (WindowInsetsNestedScrollConnection) windowInsetsNestedScrollConnection$fling$1.L$0;
            LL.b(obj);
        }
        WindowInsetsAnimationController windowInsetsAnimationControllerA = AbstractC4211wZ.a(obj);
        if (windowInsetsAnimationControllerA == null) {
            return Velocity.m5376boximpl(Velocity.Companion.m5396getZero9UxMQ8M());
        }
        SideCalculator sideCalculator = windowInsetsNestedScrollConnection.sideCalculator;
        Insets hiddenStateInsets = windowInsetsAnimationControllerA.getHiddenStateInsets();
        AbstractC4492zt.g(hiddenStateInsets, "animationController.hiddenStateInsets");
        int iValueOf = sideCalculator.valueOf(hiddenStateInsets);
        SideCalculator sideCalculator2 = windowInsetsNestedScrollConnection.sideCalculator;
        Insets shownStateInsets = windowInsetsAnimationControllerA.getShownStateInsets();
        AbstractC4492zt.g(shownStateInsets, "animationController.shownStateInsets");
        int iValueOf2 = sideCalculator2.valueOf(shownStateInsets);
        Insets currentInsets = windowInsetsAnimationControllerA.getCurrentInsets();
        AbstractC4492zt.g(currentInsets, "animationController.currentInsets");
        int iValueOf3 = windowInsetsNestedScrollConnection.sideCalculator.valueOf(currentInsets);
        if ((f2 <= 0.0f && iValueOf3 == iValueOf) || (f2 >= 0.0f && iValueOf3 == iValueOf2)) {
            windowInsetsAnimationControllerA.finish(iValueOf3 == iValueOf2);
            windowInsetsNestedScrollConnection.animationController = null;
            return Velocity.m5376boximpl(Velocity.Companion.m5396getZero9UxMQ8M());
        }
        SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = new SplineBasedFloatDecayAnimationSpec(windowInsetsNestedScrollConnection.density);
        float fFlingDistance = iValueOf3 + splineBasedFloatDecayAnimationSpec.flingDistance(f2);
        float f3 = iValueOf;
        boolean z2 = (fFlingDistance - f3) / ((float) (iValueOf2 - iValueOf)) > 0.5f;
        int i3 = z2 ? iValueOf2 : iValueOf;
        if (fFlingDistance <= iValueOf2 && fFlingDistance >= f3) {
            WindowInsetsNestedScrollConnection$fling$3 windowInsetsNestedScrollConnection$fling$3 = new WindowInsetsNestedScrollConnection$fling$3(windowInsetsNestedScrollConnection, iValueOf3, i3, f2, windowInsetsAnimationControllerA, z2, null);
            windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
            windowInsetsNestedScrollConnection$fling$1.J$0 = j2;
            windowInsetsNestedScrollConnection$fling$1.label = 3;
            if (AbstractC2133eg.d(windowInsetsNestedScrollConnection$fling$3, windowInsetsNestedScrollConnection$fling$1) == objD) {
                return objD;
            }
            windowInsetsNestedScrollConnection3 = windowInsetsNestedScrollConnection;
            j4 = j2;
            return Velocity.m5376boximpl(windowInsetsNestedScrollConnection3.sideCalculator.mo514consumedVelocityQWom1Mo(j4, 0.0f));
        }
        LJ lj2 = new LJ();
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(windowInsetsNestedScrollConnection, iValueOf3, f2, splineBasedFloatDecayAnimationSpec, iValueOf, iValueOf2, lj2, windowInsetsAnimationControllerA, z2, null);
        windowInsetsNestedScrollConnection$fling$1.L$0 = windowInsetsNestedScrollConnection;
        windowInsetsNestedScrollConnection$fling$1.L$1 = lj2;
        windowInsetsNestedScrollConnection$fling$1.J$0 = j2;
        windowInsetsNestedScrollConnection$fling$1.label = 2;
        if (AbstractC2133eg.d(windowInsetsNestedScrollConnection$fling$2, windowInsetsNestedScrollConnection$fling$1) == objD) {
            return objD;
        }
        windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
        lj = lj2;
        j3 = j2;
        return Velocity.m5376boximpl(windowInsetsNestedScrollConnection2.sideCalculator.mo514consumedVelocityQWom1Mo(j3, lj.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(InterfaceC0793Of interfaceC0793Of) {
        Object objX = this.animationController;
        if (objX == null) {
            C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
            c4374ya.A();
            this.continuation = c4374ya;
            requestAnimationController();
            objX = c4374ya.x();
            if (objX == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
        }
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (this.isControllerRequested) {
            return;
        }
        this.isControllerRequested = true;
        WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1L, null, this.cancellationSignal, AbstractC4049uZ.a(this));
        }
    }

    /* JADX INFO: renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m561scroll8S9VItk(long j, float f) {
        InterfaceC1830bu interfaceC1830bu = this.animationJob;
        if (interfaceC1830bu != null) {
            interfaceC1830bu.cancel(new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (f != 0.0f) {
            if (this.windowInsets.isVisible() != (f > 0.0f) || windowInsetsAnimationController != null) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo513consumedOffsetsMKHz9U(j);
                }
                SideCalculator sideCalculator = this.sideCalculator;
                Insets hiddenStateInsets = windowInsetsAnimationController.getHiddenStateInsets();
                AbstractC4492zt.g(hiddenStateInsets, "animationController.hiddenStateInsets");
                int iValueOf = sideCalculator.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets shownStateInsets = windowInsetsAnimationController.getShownStateInsets();
                AbstractC4492zt.g(shownStateInsets, "animationController.shownStateInsets");
                int iValueOf2 = sideCalculator2.valueOf(shownStateInsets);
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                AbstractC4492zt.g(currentInsets, "animationController.currentInsets");
                int iValueOf3 = this.sideCalculator.valueOf(currentInsets);
                if (iValueOf3 == (f > 0.0f ? iValueOf2 : iValueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m2814getZeroF1C5BW0();
                }
                float f2 = iValueOf3 + f + this.partialConsumption;
                int iL = AbstractC3871sJ.l(AbstractC1210aB.c(f2), iValueOf, iValueOf2);
                this.partialConsumption = f2 - AbstractC1210aB.c(f2);
                if (iL != iValueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, iL), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo513consumedOffsetsMKHz9U(j);
            }
        }
        return Offset.Companion.m2814getZeroF1C5BW0();
    }

    public final void dispose() {
        InterfaceC4293xa interfaceC4293xa = this.continuation;
        if (interfaceC4293xa != null) {
            interfaceC4293xa.k(null, C13491.INSTANCE);
        }
        InterfaceC1830bu interfaceC1830bu = this.animationJob;
        if (interfaceC1830bu != null) {
            InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!AbstractC4492zt.d(windowInsetsAnimationController.getCurrentInsets(), windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    public final Density getDensity() {
        return this.density;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final View getView() {
        return this.view;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        AbstractC4492zt.h(windowInsetsAnimationController, "controller");
        animationEnded();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
        return m560flinghuYlsQE(j2, this.sideCalculator.showMotion(Velocity.m5385getXimpl(j2), Velocity.m5386getYimpl(j2)), true, interfaceC0793Of);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        return m561scroll8S9VItk(j2, this.sideCalculator.showMotion(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2)));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
        return m560flinghuYlsQE(j, this.sideCalculator.hideMotion(Velocity.m5385getXimpl(j), Velocity.m5386getYimpl(j)), false, interfaceC0793Of);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo343onPreScrollOzD1aCk(long j, int i) {
        return m561scroll8S9VItk(j, this.sideCalculator.hideMotion(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j)));
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        AbstractC4492zt.h(windowInsetsAnimationController, "controller");
        this.animationController = windowInsetsAnimationController;
        this.isControllerRequested = false;
        InterfaceC4293xa interfaceC4293xa = this.continuation;
        if (interfaceC4293xa != null) {
            interfaceC4293xa.k(windowInsetsAnimationController, C13501.INSTANCE);
        }
        this.continuation = null;
    }
}
