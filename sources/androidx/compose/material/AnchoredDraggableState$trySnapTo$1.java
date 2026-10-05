package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.C2;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$trySnapTo$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$trySnapTo$1(AnchoredDraggableState<T> anchoredDraggableState, T t) {
        super(0);
        this.this$0 = anchoredDraggableState;
        this.$targetValue = t;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m970invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m970invoke() {
        AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
        AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
        Object obj = this.$targetValue;
        Float f = (Float) anchoredDraggableState.getAnchors$material_release().get(obj);
        if (f != null) {
            C2.a(anchoredDragScope, f.floatValue(), 0.0f, 2, null);
            anchoredDraggableState.setAnimationTarget(null);
        }
        anchoredDraggableState.setCurrentValue(obj);
    }
}
