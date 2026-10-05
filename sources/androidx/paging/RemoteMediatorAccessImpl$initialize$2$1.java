package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteMediatorAccessImpl$initialize$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final RemoteMediatorAccessImpl$initialize$2$1 INSTANCE = new RemoteMediatorAccessImpl$initialize$2$1();

    public RemoteMediatorAccessImpl$initialize$2$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AccessorState) obj);
        return FW.a;
    }

    public final void invoke(AccessorState<Key, Value> accessorState) {
        AbstractC4492zt.h(accessorState, "it");
        LoadType loadType = LoadType.APPEND;
        AccessorState.BlockState blockState = AccessorState.BlockState.REQUIRES_REFRESH;
        accessorState.setBlockState(loadType, blockState);
        accessorState.setBlockState(LoadType.PREPEND, blockState);
    }
}
