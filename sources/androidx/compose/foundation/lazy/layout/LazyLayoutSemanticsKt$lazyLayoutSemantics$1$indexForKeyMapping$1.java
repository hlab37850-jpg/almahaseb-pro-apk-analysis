package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3588op $itemProviderLambda;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$itemProviderLambda = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Integer invoke(Object obj) {
        AbstractC4492zt.h(obj, "needle");
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.$itemProviderLambda.invoke();
        int itemCount = lazyLayoutItemProvider.getItemCount();
        int i = 0;
        while (i < itemCount) {
            if (AbstractC4492zt.d(lazyLayoutItemProvider.getKey(i), obj)) {
                return Integer.valueOf(i);
            }
            i++;
        }
        i = -1;
        return Integer.valueOf(i);
    }
}
