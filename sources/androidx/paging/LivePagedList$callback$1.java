package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class LivePagedList$callback$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ LivePagedList<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePagedList$callback$1(LivePagedList<Key, Value> livePagedList) {
        super(0);
        this.this$0 = livePagedList;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m5430invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5430invoke() {
        this.this$0.invalidate(true);
    }
}
