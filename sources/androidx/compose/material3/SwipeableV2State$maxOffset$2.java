package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2State$maxOffset$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2State$maxOffset$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        Float fMaxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material3_release());
        return Float.valueOf(fMaxOrNull != null ? fMaxOrNull.floatValue() : Float.POSITIVE_INFINITY);
    }
}
