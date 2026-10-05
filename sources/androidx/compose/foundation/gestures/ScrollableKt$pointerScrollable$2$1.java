package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt$pointerScrollable$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<ScrollingLogic> $scrollLogic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableKt$pointerScrollable$2$1(State<ScrollingLogic> state) {
        super(0);
        this.$scrollLogic = state;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(this.$scrollLogic.getValue().shouldScrollImmediately());
    }
}
