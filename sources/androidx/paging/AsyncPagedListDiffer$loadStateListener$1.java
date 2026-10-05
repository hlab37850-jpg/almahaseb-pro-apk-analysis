package androidx.paging;

import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class AsyncPagedListDiffer$loadStateListener$1 extends C0916Sp implements InterfaceC0526Fp {
    public AsyncPagedListDiffer$loadStateListener$1(Object obj) {
        super(2, obj, PagedList.LoadStateManager.class, "setState", "setState(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", 0);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((LoadType) obj, (LoadState) obj2);
        return FW.a;
    }

    public final void invoke(LoadType loadType, LoadState loadState) {
        AbstractC4492zt.h(loadType, "p0");
        AbstractC4492zt.h(loadState, "p1");
        ((PagedList.LoadStateManager) this.receiver).setState(loadType, loadState);
    }
}
