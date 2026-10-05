package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomDrawerState$anchoredDraggableState$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ BottomDrawerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomDrawerState$anchoredDraggableState$1(BottomDrawerState bottomDrawerState) {
        super(1);
        this.this$0 = bottomDrawerState;
    }

    public final Float invoke(float f) {
        return Float.valueOf(this.this$0.requireDensity().mo333toPx0680j_4(DrawerKt.DrawerPositionalThreshold));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
