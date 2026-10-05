package androidx.compose.animation.core;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Transition$totalDurationNanos$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Transition<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transition$totalDurationNanos$2(Transition<S> transition) {
        super(0);
        this.this$0 = transition;
    }

    @Override // defpackage.InterfaceC3588op
    public final Long invoke() {
        Iterator<T> it = ((Transition) this.this$0)._animations.iterator();
        long jMax = 0;
        while (it.hasNext()) {
            jMax = Math.max(jMax, ((Transition.TransitionAnimationState) it.next()).getDurationNanos$animation_core_release());
        }
        Iterator<T> it2 = ((Transition) this.this$0)._transitions.iterator();
        while (it2.hasNext()) {
            jMax = Math.max(jMax, ((Transition) it2.next()).getTotalDurationNanos());
        }
        return Long.valueOf(jMax);
    }
}
