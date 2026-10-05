package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TouchExplorationStateProvider_androidKt$touchExplorationState$3$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Listener $listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchExplorationStateProvider_androidKt$touchExplorationState$3$1(Listener listener) {
        super(0);
        this.$listener = listener;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(this.$listener.isEnabled());
    }
}
