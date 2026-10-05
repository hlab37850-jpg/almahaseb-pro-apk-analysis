package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2State$targetValue$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2State$targetValue$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Override // defpackage.InterfaceC3588op
    public final T invoke() {
        ?? animationTarget = this.this$0.getAnimationTarget();
        if (animationTarget != 0) {
            return animationTarget;
        }
        SwipeableV2State<T> swipeableV2State = this.this$0;
        Float offset = swipeableV2State.getOffset();
        return offset != null ? swipeableV2State.computeTarget(offset.floatValue(), swipeableV2State.getCurrentValue(), 0.0f) : swipeableV2State.getCurrentValue();
    }
}
