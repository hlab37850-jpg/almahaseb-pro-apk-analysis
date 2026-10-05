package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<InterfaceC3588op> $currentItemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1(State<? extends InterfaceC3588op> state) {
        super(0);
        this.$currentItemProvider = state;
    }

    @Override // defpackage.InterfaceC3588op
    public final LazyLayoutItemProvider invoke() {
        return (LazyLayoutItemProvider) this.$currentItemProvider.getValue().invoke();
    }
}
