package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponderNode$bringChildIntoView$parentRect$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3588op $boundsProvider;
    final /* synthetic */ LayoutCoordinates $childCoordinates;
    final /* synthetic */ BringIntoViewResponderNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderNode$bringChildIntoView$parentRect$1(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, InterfaceC3588op interfaceC3588op) {
        super(0);
        this.this$0 = bringIntoViewResponderNode;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3588op
    public final Rect invoke() {
        Rect rectBringChildIntoView$localRect = BringIntoViewResponderNode.bringChildIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
        if (rectBringChildIntoView$localRect != null) {
            return this.this$0.getResponder().calculateRectForParent(rectBringChildIntoView$localRect);
        }
        return null;
    }
}
