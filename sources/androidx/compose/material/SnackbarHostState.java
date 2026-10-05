package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
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

    @Stable
    public static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final InterfaceC4293xa continuation;
        private final SnackbarDuration duration;
        private final String message;

        public SnackbarDataImpl(String str, String str2, SnackbarDuration snackbarDuration, InterfaceC4293xa interfaceC4293xa) {
            AbstractC4492zt.h(str, "message");
            AbstractC4492zt.h(snackbarDuration, TypedValues.TransitionType.S_DURATION);
            AbstractC4492zt.h(interfaceC4293xa, "continuation");
            this.message = str;
            this.actionLabel = str2;
            this.duration = snackbarDuration;
            this.continuation = interfaceC4293xa;
        }

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                InterfaceC4293xa interfaceC4293xa = this.continuation;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(SnackbarResult.Dismissed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                InterfaceC4293xa interfaceC4293xa = this.continuation;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(SnackbarResult.ActionPerformed));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostState$showSnackbar$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", l = {379, 382}, m = "showSnackbar")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SnackbarHostState.this.showSnackbar(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, interfaceC0793Of);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object showSnackbar(String str, String str2, SnackbarDuration snackbarDuration, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        GC gc;
        SnackbarDuration snackbarDuration2;
        String str3;
        SnackbarHostState snackbarHostState;
        String str4;
        GC gc2;
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
        try {
            try {
                if (i2 == 0) {
                    LL.b(obj);
                    gc = this.mutex;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = str;
                    anonymousClass1.L$2 = str2;
                    anonymousClass1.L$3 = snackbarDuration;
                    anonymousClass1.L$4 = gc;
                    anonymousClass1.label = 1;
                    if (gc.c(null, anonymousClass1) == objD) {
                        return objD;
                    }
                    snackbarDuration2 = snackbarDuration;
                    str3 = str2;
                    snackbarHostState = this;
                    str4 = str;
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        gc2 = (GC) anonymousClass1.L$4;
                        snackbarHostState = (SnackbarHostState) anonymousClass1.L$0;
                        try {
                            LL.b(obj);
                            snackbarHostState.setCurrentSnackbarData(null);
                            gc2.b(null);
                            return obj;
                        } catch (Throwable th) {
                            th = th;
                            snackbarHostState.setCurrentSnackbarData(null);
                            throw th;
                        }
                    }
                    GC gc3 = (GC) anonymousClass1.L$4;
                    SnackbarDuration snackbarDuration3 = (SnackbarDuration) anonymousClass1.L$3;
                    String str5 = (String) anonymousClass1.L$2;
                    String str6 = (String) anonymousClass1.L$1;
                    SnackbarHostState snackbarHostState2 = (SnackbarHostState) anonymousClass1.L$0;
                    LL.b(obj);
                    gc = gc3;
                    str4 = str6;
                    snackbarDuration2 = snackbarDuration3;
                    str3 = str5;
                    snackbarHostState = snackbarHostState2;
                }
                anonymousClass1.L$0 = snackbarHostState;
                anonymousClass1.L$1 = str4;
                anonymousClass1.L$2 = str3;
                anonymousClass1.L$3 = snackbarDuration2;
                anonymousClass1.L$4 = gc;
                anonymousClass1.L$5 = anonymousClass1;
                anonymousClass1.label = 2;
                C4374ya c4374ya = new C4374ya(AbstractC0352At.c(anonymousClass1), 1);
                c4374ya.A();
                snackbarHostState.setCurrentSnackbarData(new SnackbarDataImpl(str4, str3, snackbarDuration2, c4374ya));
                Object objX = c4374ya.x();
                if (objX == AbstractC0378Bt.d()) {
                    AbstractC3416mi.c(anonymousClass1);
                }
                if (objX == objD) {
                    return objD;
                }
                GC gc4 = gc;
                obj = objX;
                gc2 = gc4;
                snackbarHostState.setCurrentSnackbarData(null);
                gc2.b(null);
                return obj;
            } catch (Throwable th2) {
                th = th2;
                snackbarHostState.setCurrentSnackbarData(null);
                throw th;
            }
        } catch (Throwable th3) {
            str.b(null);
            throw th3;
        }
    }
}
