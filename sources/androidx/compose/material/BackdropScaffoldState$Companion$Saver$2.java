package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ InterfaceC3750qp $confirmStateChange;
    final /* synthetic */ SnackbarHostState $snackbarHostState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState$Companion$Saver$2(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, SnackbarHostState snackbarHostState) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = interfaceC3750qp;
        this.$snackbarHostState = snackbarHostState;
    }

    @Override // defpackage.InterfaceC3750qp
    public final BackdropScaffoldState invoke(BackdropValue backdropValue) {
        AbstractC4492zt.h(backdropValue, "it");
        return new BackdropScaffoldState(backdropValue, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
    }
}
