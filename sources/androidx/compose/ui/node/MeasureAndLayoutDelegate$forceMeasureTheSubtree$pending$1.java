package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MeasureAndLayoutDelegate$forceMeasureTheSubtree$pending$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ boolean $affectsLookahead;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasureAndLayoutDelegate$forceMeasureTheSubtree$pending$1(boolean z) {
        super(1);
        this.$affectsLookahead = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "it");
        return Boolean.valueOf(this.$affectsLookahead ? layoutNode.getLookaheadMeasurePending$ui_release() : layoutNode.getMeasurePending$ui_release());
    }
}
