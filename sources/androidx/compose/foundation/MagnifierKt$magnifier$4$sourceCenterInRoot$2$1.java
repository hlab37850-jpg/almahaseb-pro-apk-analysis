package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt$magnifier$4$sourceCenterInRoot$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ State<InterfaceC3750qp> $updatedSourceCenter$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(Density density, State<? extends InterfaceC3750qp> state, MutableState<Offset> mutableState) {
        super(0);
        this.$density = density;
        this.$updatedSourceCenter$delegate = state;
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m2787boximpl(m228invokeF1C5BW0());
    }

    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m228invokeF1C5BW0() {
        long jM2808unboximpl = ((Offset) MagnifierKt.AnonymousClass4.invoke$lambda$3(this.$updatedSourceCenter$delegate).invoke(this.$density)).m2808unboximpl();
        return (OffsetKt.m2817isSpecifiedk4lQ0M(MagnifierKt.AnonymousClass4.invoke$lambda$1(this.$anchorPositionInRoot$delegate)) && OffsetKt.m2817isSpecifiedk4lQ0M(jM2808unboximpl)) ? Offset.m2803plusMKHz9U(MagnifierKt.AnonymousClass4.invoke$lambda$1(this.$anchorPositionInRoot$delegate), jM2808unboximpl) : Offset.Companion.m2813getUnspecifiedF1C5BW0();
    }
}
