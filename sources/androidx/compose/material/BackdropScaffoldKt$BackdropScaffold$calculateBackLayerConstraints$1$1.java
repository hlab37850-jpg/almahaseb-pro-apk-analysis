package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $headerHeightPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f) {
        super(1);
        this.$headerHeightPx = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Constraints.m5116boximpl(m991invokeZezNO4M(((Constraints) obj).m5134unboximpl()));
    }

    /* JADX INFO: renamed from: invoke-ZezNO4M, reason: not valid java name */
    public final long m991invokeZezNO4M(long j) {
        return ConstraintsKt.m5145offsetNN6EwU$default(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null), 0, -AbstractC1210aB.c(this.$headerHeightPx), 1, null);
    }
}
