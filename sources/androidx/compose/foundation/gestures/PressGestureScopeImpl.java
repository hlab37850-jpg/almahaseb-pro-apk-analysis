package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
final class PressGestureScopeImpl implements PressGestureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final GC mutex;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", l = {363}, m = "awaitRelease")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.awaitRelease(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", l = {357}, m = "reset")
    public static final class C13241 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13241(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", l = {370}, m = "tryAwaitRelease")
    public static final class C13251 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13251(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    public PressGestureScopeImpl(Density density) {
        AbstractC4492zt.h(density, "density");
        this.$$delegate_0 = density;
        this.mutex = IC.a(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object awaitRelease(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object objTryAwaitRelease = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(objTryAwaitRelease);
            anonymousClass1.label = 1;
            objTryAwaitRelease = tryAwaitRelease(anonymousClass1);
            if (objTryAwaitRelease == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objTryAwaitRelease);
        }
        if (((Boolean) objTryAwaitRelease).booleanValue()) {
            return FW.a;
        }
        throw new GestureCancellationException("The press gesture was canceled.");
    }

    public final void cancel() {
        this.isCanceled = true;
        GC.a.c(this.mutex, null, 1, null);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        GC.a.c(this.mutex, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reset(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13241 c13241;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (interfaceC0793Of instanceof C13241) {
            c13241 = (C13241) interfaceC0793Of;
            int i = c13241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13241.label = i - Integer.MIN_VALUE;
            } else {
                c13241 = new C13241(interfaceC0793Of);
            }
        } else {
            c13241 = new C13241(interfaceC0793Of);
        }
        Object obj = c13241.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13241.label;
        if (i2 == 0) {
            LL.b(obj);
            GC gc = this.mutex;
            c13241.L$0 = this;
            c13241.label = 1;
            if (GC.a.a(gc, null, c13241, 1, null) == objD) {
                return objD;
            }
            pressGestureScopeImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pressGestureScopeImpl = (PressGestureScopeImpl) c13241.L$0;
            LL.b(obj);
        }
        pressGestureScopeImpl.isReleased = false;
        pressGestureScopeImpl.isCanceled = false;
        return FW.a;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int mo326roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo326roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int mo327roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo327roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float mo328toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo328toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo329toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo329toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long mo331toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo331toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public float mo332toPxR2X_6o(long j) {
        return this.$$delegate_0.mo332toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public float mo333toPx0680j_4(float f) {
        return this.$$delegate_0.mo333toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    public Rect toRect(DpRect dpRect) {
        AbstractC4492zt.h(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long mo334toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo334toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public long mo335toSp0xMU5do(float f) {
        return this.$$delegate_0.mo335toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo336toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo336toSpkPz2Gy4(f);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    public Object tryAwaitRelease(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13251 c13251;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (interfaceC0793Of instanceof C13251) {
            c13251 = (C13251) interfaceC0793Of;
            int i = c13251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13251.label = i - Integer.MIN_VALUE;
            } else {
                c13251 = new C13251(interfaceC0793Of);
            }
        } else {
            c13251 = new C13251(interfaceC0793Of);
        }
        Object obj = c13251.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13251.label;
        if (i2 == 0) {
            LL.b(obj);
            if (this.isReleased || this.isCanceled) {
                pressGestureScopeImpl = this;
            } else {
                GC gc = this.mutex;
                c13251.L$0 = this;
                c13251.label = 1;
                if (GC.a.a(gc, null, c13251, 1, null) == objD) {
                    return objD;
                }
                pressGestureScopeImpl = this;
            }
            return E8.a(pressGestureScopeImpl.isReleased);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        pressGestureScopeImpl = (PressGestureScopeImpl) c13251.L$0;
        LL.b(obj);
        GC.a.c(pressGestureScopeImpl.mutex, null, 1, null);
        return E8.a(pressGestureScopeImpl.isReleased);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo330toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo330toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo337toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo337toSpkPz2Gy4(i);
    }
}
