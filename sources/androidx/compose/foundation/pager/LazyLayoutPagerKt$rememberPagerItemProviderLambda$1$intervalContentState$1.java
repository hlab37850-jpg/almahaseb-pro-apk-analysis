package androidx.compose.foundation.pager;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $key;
    final /* synthetic */ State<InterfaceC0578Hp> $latestContent;
    final /* synthetic */ InterfaceC3588op $pageCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(State<? extends InterfaceC0578Hp> state, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        super(0);
        this.$latestContent = state;
        this.$key = interfaceC3750qp;
        this.$pageCount = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3588op
    public final PagerLayoutIntervalContent invoke() {
        return new PagerLayoutIntervalContent(this.$latestContent.getValue(), this.$key, ((Number) this.$pageCount.invoke()).intValue());
    }
}
