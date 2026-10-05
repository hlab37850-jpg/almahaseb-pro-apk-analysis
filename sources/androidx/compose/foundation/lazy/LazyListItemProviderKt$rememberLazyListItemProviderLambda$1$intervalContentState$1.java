package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<InterfaceC3750qp> $latestContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1(State<? extends InterfaceC3750qp> state) {
        super(0);
        this.$latestContent = state;
    }

    @Override // defpackage.InterfaceC3588op
    public final LazyListIntervalContent invoke() {
        return new LazyListIntervalContent(this.$latestContent.getValue());
    }
}
