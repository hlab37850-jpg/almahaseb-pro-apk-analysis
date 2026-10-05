package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollableStateKt$rememberScrollableState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<InterfaceC3750qp> $lambdaState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScrollableStateKt$rememberScrollableState$1$1(State<? extends InterfaceC3750qp> state) {
        super(1);
        this.$lambdaState = state;
    }

    public final Float invoke(float f) {
        return (Float) this.$lambdaState.getValue().invoke(Float.valueOf(f));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
