package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BottomDrawerState$anchoredDraggableState$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ BottomDrawerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomDrawerState$anchoredDraggableState$2(BottomDrawerState bottomDrawerState) {
        super(0);
        this.this$0 = bottomDrawerState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.this$0.requireDensity().mo333toPx0680j_4(DrawerKt.DrawerVelocityThreshold));
    }
}
