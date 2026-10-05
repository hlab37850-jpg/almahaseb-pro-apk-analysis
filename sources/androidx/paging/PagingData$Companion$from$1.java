package androidx.paging;

import defpackage.AbstractC1805bc;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingData$Companion$from$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ List<T> $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PagingData$Companion$from$1(List<? extends T> list) {
        super(0);
        this.$data = list;
    }

    @Override // defpackage.InterfaceC3588op
    public final PageEvent.Insert<T> invoke() {
        return PageEvent.Insert.Companion.Refresh(AbstractC1805bc.e(new TransformablePage(0, this.$data)), 0, 0, LoadStates.Companion.getIDLE(), null);
    }
}
