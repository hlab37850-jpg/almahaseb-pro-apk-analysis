package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableState$latestNonEmptyAnchorsFlow$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$latestNonEmptyAnchorsFlow$1(SwipeableState<T> swipeableState) {
        super(0);
        this.this$0 = swipeableState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Map<Float, T> invoke() {
        return this.this$0.getAnchors$material3_release();
    }
}
