package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt$magnifier$4$isMagnifierShown$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$isMagnifierShown$2$1(State<Offset> state) {
        super(0);
        this.$sourceCenterInRoot$delegate = state;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(OffsetKt.m2817isSpecifiedk4lQ0M(MagnifierKt.AnonymousClass4.invoke$lambda$8(this.$sourceCenterInRoot$delegate)));
    }
}
