package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2State$trySnapTo$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2State$trySnapTo$1(SwipeableV2State<T> swipeableV2State, T t) {
        super(0);
        this.this$0 = swipeableV2State;
        this.$targetValue = t;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1870invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1870invoke() {
        this.this$0.snap(this.$targetValue);
    }
}
