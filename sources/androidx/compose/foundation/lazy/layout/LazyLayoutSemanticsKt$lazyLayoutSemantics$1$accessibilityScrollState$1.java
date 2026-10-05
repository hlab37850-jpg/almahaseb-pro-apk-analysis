package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1(LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(0);
        this.$state = lazyLayoutSemanticState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.$state.getCurrentPosition());
    }
}
