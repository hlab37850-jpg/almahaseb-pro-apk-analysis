package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final GC mutex = IC.b(false, 1, null);
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public static final class SnackbarDataImpl implements SnackbarData {
        private final InterfaceC4293xa continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals snackbarVisuals, InterfaceC4293xa interfaceC4293xa) {
            AbstractC4492zt.h(snackbarVisuals, "visuals");
            AbstractC4492zt.h(interfaceC4293xa, "continuation");
            this.visuals = snackbarVisuals;
            this.continuation = interfaceC4293xa;
        }

        @Override // androidx.compose.material3.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                InterfaceC4293xa interfaceC4293xa = this.continuation;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarDataImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            return AbstractC4492zt.d(getVisuals(), snackbarDataImpl.getVisuals()) && AbstractC4492zt.d(this.continuation, snackbarDataImpl.continuation);
        }

        @Override // androidx.compose.material3.SnackbarData
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }

        @Override // androidx.compose.material3.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                InterfaceC4293xa interfaceC4293xa = this.continuation;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(SnackbarResult.ActionPerformed));
            }
        }
    }

    public static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String str, String str2, boolean z, SnackbarDuration snackbarDuration) {
            AbstractC4492zt.h(str, "message");
            AbstractC4492zt.h(snackbarDuration, TypedValues.TransitionType.S_DURATION);
            this.message = str;
            this.actionLabel = str2;
            this.withDismissAction = z;
            this.duration = snackbarDuration;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SnackbarVisualsImpl.class != obj.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            return AbstractC4492zt.d(getMessage(), snackbarVisualsImpl.getMessage()) && AbstractC4492zt.d(getActionLabel(), snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration();
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material3.SnackbarVisuals
        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public int hashCode() {
            int iHashCode = getMessage().hashCode() * 31;
            String actionLabel = getActionLabel();
            return ((((iHashCode + (actionLabel != null ? actionLabel.hashCode() : 0)) * 31) + AbstractC0564Hb.a(getWithDismissAction())) * 31) + getDuration().hashCode();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarHostState$showSnackbar$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.SnackbarHostState", f = "SnackbarHost.kt", l = {462, 465}, m = "showSnackbar")
    public static final class AnonymousClass2 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z, SnackbarDuration snackbarDuration, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            snackbarDuration = str3 == null ? SnackbarDuration.Short : SnackbarDuration.Indefinite;
        }
        return snackbarHostState.showSnackbar(str, str3, z2, snackbarDuration, interfaceC0793Of);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public final Object showSnackbar(String str, String str2, boolean z, SnackbarDuration snackbarDuration, InterfaceC0793Of interfaceC0793Of) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z, snackbarDuration), interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object showSnackbar(SnackbarVisuals snackbarVisuals, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass2 anonymousClass2;
        GC gc;
        SnackbarHostState snackbarHostState;
        SnackbarVisuals snackbarVisuals2;
        SnackbarHostState snackbarHostState2;
        Throwable th;
        GC gc2;
        if (interfaceC0793Of instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) interfaceC0793Of;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(interfaceC0793Of);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(interfaceC0793Of);
        }
        Object obj = anonymousClass2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass2.label;
        try {
            try {
                if (i2 == 0) {
                    LL.b(obj);
                    gc = this.mutex;
                    anonymousClass2.L$0 = this;
                    anonymousClass2.L$1 = snackbarVisuals;
                    anonymousClass2.L$2 = gc;
                    anonymousClass2.label = 1;
                    if (gc.c(null, anonymousClass2) == objD) {
                        return objD;
                    }
                    snackbarHostState = this;
                    snackbarVisuals2 = snackbarVisuals;
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        gc2 = (GC) anonymousClass2.L$2;
                        snackbarHostState2 = (SnackbarHostState) anonymousClass2.L$0;
                        try {
                            LL.b(obj);
                            snackbarHostState2.setCurrentSnackbarData(null);
                            gc2.b(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            snackbarHostState2.setCurrentSnackbarData(null);
                            throw th;
                        }
                    }
                    GC gc3 = (GC) anonymousClass2.L$2;
                    SnackbarVisuals snackbarVisuals3 = (SnackbarVisuals) anonymousClass2.L$1;
                    snackbarHostState = (SnackbarHostState) anonymousClass2.L$0;
                    LL.b(obj);
                    gc = gc3;
                    snackbarVisuals2 = snackbarVisuals3;
                }
                anonymousClass2.L$0 = snackbarHostState;
                anonymousClass2.L$1 = snackbarVisuals2;
                anonymousClass2.L$2 = gc;
                anonymousClass2.L$3 = anonymousClass2;
                anonymousClass2.label = 2;
                C4374ya c4374ya = new C4374ya(AbstractC0352At.c(anonymousClass2), 1);
                c4374ya.A();
                snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(snackbarVisuals2, c4374ya));
                Object objX = c4374ya.x();
                if (objX == AbstractC0378Bt.d()) {
                    AbstractC3416mi.c(anonymousClass2);
                }
                if (objX == objD) {
                    return objD;
                }
                snackbarHostState2 = snackbarHostState;
                GC gc4 = gc;
                obj = objX;
                gc2 = gc4;
                snackbarHostState2.setCurrentSnackbarData(null);
                gc2.b(null);
                return obj;
            } catch (Throwable th3) {
                snackbarHostState2 = snackbarHostState;
                th = th3;
                snackbarHostState2.setCurrentSnackbarData(null);
                throw th;
            }
        } catch (Throwable th4) {
            snackbarVisuals.b(null);
            throw th4;
        }
    }
}
