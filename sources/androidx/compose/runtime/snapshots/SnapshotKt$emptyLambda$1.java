package androidx.compose.runtime.snapshots;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotKt$emptyLambda$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SnapshotKt$emptyLambda$1 INSTANCE = new SnapshotKt$emptyLambda$1();

    public SnapshotKt$emptyLambda$1() {
        super(1);
    }

    public final void invoke(SnapshotIdSet snapshotIdSet) {
        AbstractC4492zt.h(snapshotIdSet, "it");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SnapshotIdSet) obj);
        return FW.a;
    }
}
