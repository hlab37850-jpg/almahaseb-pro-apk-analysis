package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1$dispatchToView$3 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ PointerInteropFilter$pointerInputFilter$1 this$0;
    final /* synthetic */ PointerInteropFilter this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerInteropFilter$pointerInputFilter$1$dispatchToView$3(PointerInteropFilter$pointerInputFilter$1 pointerInteropFilter$pointerInputFilter$1, PointerInteropFilter pointerInteropFilter) {
        super(1);
        this.this$0 = pointerInteropFilter$pointerInputFilter$1;
        this.this$1 = pointerInteropFilter;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MotionEvent) obj);
        return FW.a;
    }

    public final void invoke(MotionEvent motionEvent) {
        AbstractC4492zt.h(motionEvent, "motionEvent");
        if (motionEvent.getActionMasked() != 0) {
            this.this$1.getOnTouchEvent().invoke(motionEvent);
        } else {
            this.this$0.state = ((Boolean) this.this$1.getOnTouchEvent().invoke(motionEvent)).booleanValue() ? PointerInteropFilter.DispatchToViewState.Dispatching : PointerInteropFilter.DispatchToViewState.NotDispatching;
        }
    }
}
