package androidx.paging.rxjava3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class RxPagedListBuilder$PagingObservableOnSubscribe$callback$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxPagedListBuilder$PagingObservableOnSubscribe$callback$1(RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> pagingObservableOnSubscribe) {
        super(0);
        this.this$0 = pagingObservableOnSubscribe;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m5438invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5438invoke() {
        this.this$0.invalidate(true);
    }
}
