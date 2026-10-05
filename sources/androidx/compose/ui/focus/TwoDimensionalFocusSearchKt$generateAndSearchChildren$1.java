package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt$generateAndSearchChildren$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $direction;
    final /* synthetic */ FocusTargetNode $focusedItem;
    final /* synthetic */ InterfaceC3750qp $onFound;
    final /* synthetic */ FocusTargetNode $this_generateAndSearchChildren;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$this_generateAndSearchChildren = focusTargetNode;
        this.$focusedItem = focusTargetNode2;
        this.$direction = i;
        this.$onFound = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
        AbstractC4492zt.h(beyondBoundsScope, "$this$searchBeyondBounds");
        boolean zM2762searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m2762searchChildren4C6V_qg(this.$this_generateAndSearchChildren, this.$focusedItem, this.$direction, this.$onFound);
        Boolean boolValueOf = Boolean.valueOf(zM2762searchChildren4C6V_qg);
        if (zM2762searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
            return boolValueOf;
        }
        return null;
    }
}
