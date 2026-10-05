package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt$magnifier$4$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4$2$1(MutableState<Offset> mutableState) {
        super(1);
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return FW.a;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "it");
        MagnifierKt.AnonymousClass4.invoke$lambda$2(this.$anchorPositionInRoot$delegate, LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
    }
}
