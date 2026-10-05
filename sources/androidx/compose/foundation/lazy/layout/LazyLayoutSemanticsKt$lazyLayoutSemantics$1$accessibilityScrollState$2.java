package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2(InterfaceC3588op interfaceC3588op, LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(0);
        this.$itemProviderLambda = interfaceC3588op;
        this.$state = lazyLayoutSemanticState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.$state.getCanScrollForward() ? ((LazyLayoutItemProvider) this.$itemProviderLambda.invoke()).getItemCount() + 1.0f : this.$state.getCurrentPosition());
    }
}
