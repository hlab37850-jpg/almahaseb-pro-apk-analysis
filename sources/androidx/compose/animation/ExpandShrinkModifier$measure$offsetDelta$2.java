package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandShrinkModifier$measure$offsetDelta$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ ExpandShrinkModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandShrinkModifier$measure$offsetDelta$2(ExpandShrinkModifier expandShrinkModifier, long j) {
        super(1);
        this.this$0 = expandShrinkModifier;
        this.$measuredSize = j;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m5269boximpl(m65invokeBjo55l4((EnterExitState) obj));
    }

    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m65invokeBjo55l4(EnterExitState enterExitState) {
        AbstractC4492zt.h(enterExitState, "it");
        return this.this$0.m63targetOffsetByStateoFUgxo0(enterExitState, this.$measuredSize);
    }
}
