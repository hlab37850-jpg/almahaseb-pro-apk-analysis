package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class BackdropScaffoldState extends SwipeableState<BackdropValue> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final NestedScrollConnection nestedScrollConnection;
    private final SnackbarHostState snackbarHostState;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(BackdropValue backdropValue) {
            AbstractC4492zt.h(backdropValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<BackdropScaffoldState, ?> Saver(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            AbstractC4492zt.h(snackbarHostState, "snackbarHostState");
            return SaverKt.Saver(BackdropScaffoldState$Companion$Saver$1.INSTANCE, new BackdropScaffoldState$Companion$Saver$2(animationSpec, interfaceC3750qp, snackbarHostState));
        }

        private Companion() {
        }
    }

    public /* synthetic */ BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState, int i, AbstractC0419Di abstractC0419Di) {
        this(backdropValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp, (i & 8) != 0 ? new SnackbarHostState() : snackbarHostState);
    }

    public final Object conceal(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Concealed, null, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final boolean isConcealed() {
        return getCurrentValue() == BackdropValue.Concealed;
    }

    public final boolean isRevealed() {
        return getCurrentValue() == BackdropValue.Revealed;
    }

    public final Object reveal(InterfaceC0793Of interfaceC0793Of) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Revealed, null, interfaceC0793Of, 2, null);
        return objAnimateTo$default == AbstractC0378Bt.d() ? objAnimateTo$default : FW.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState) {
        super(backdropValue, animationSpec, interfaceC3750qp);
        AbstractC4492zt.h(backdropValue, "initialValue");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        AbstractC4492zt.h(snackbarHostState, "snackbarHostState");
        this.snackbarHostState = snackbarHostState;
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
