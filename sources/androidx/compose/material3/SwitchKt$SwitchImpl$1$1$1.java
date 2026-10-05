package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$SwitchImpl$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $thumbOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$1$1$1(float f) {
        super(1);
        this.$thumbOffset = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5269boximpl(m1876invokeBjo55l4((Density) obj));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m1876invokeBjo55l4(Density density) {
        AbstractC4492zt.h(density, "$this$offset");
        return IntOffsetKt.IntOffset(AbstractC1210aB.c(this.$thumbOffset), 0);
    }
}
