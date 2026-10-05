package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver$onCommitAffectingSemantics$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final OwnerSnapshotObserver$onCommitAffectingSemantics$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingSemantics$1();

    public OwnerSnapshotObserver$onCommitAffectingSemantics$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "layoutNode");
        if (layoutNode.isValidOwnerScope()) {
            layoutNode.invalidateSemantics$ui_release();
        }
    }
}
