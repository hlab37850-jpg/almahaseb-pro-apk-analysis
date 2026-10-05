package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$rememberDraggableState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<InterfaceC3750qp> $onDeltaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DraggableKt$rememberDraggableState$1$1(State<? extends InterfaceC3750qp> state) {
        super(1);
        this.$onDeltaState = state;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        this.$onDeltaState.getValue().invoke(Float.valueOf(f));
    }
}
