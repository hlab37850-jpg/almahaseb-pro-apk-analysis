package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ LazyLayoutPinnableItem $pinnableItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1(LazyLayoutPinnableItem lazyLayoutPinnableItem) {
        super(1);
        this.$pinnableItem = lazyLayoutPinnableItem;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
        final LazyLayoutPinnableItem lazyLayoutPinnableItem = this.$pinnableItem;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lazyLayoutPinnableItem.onDisposed();
            }
        };
    }
}
