package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver {
    private final SnapshotStateObserver observer;
    private final InterfaceC3750qp onCommitAffectingLayout;
    private final InterfaceC3750qp onCommitAffectingLayoutModifier;
    private final InterfaceC3750qp onCommitAffectingLayoutModifierInLookahead;
    private final InterfaceC3750qp onCommitAffectingLookaheadLayout;
    private final InterfaceC3750qp onCommitAffectingLookaheadMeasure;
    private final InterfaceC3750qp onCommitAffectingMeasure;
    private final InterfaceC3750qp onCommitAffectingSemantics;

    public OwnerSnapshotObserver(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(interfaceC3750qp);
        this.onCommitAffectingLookaheadMeasure = OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1.INSTANCE;
        this.onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;
        this.onCommitAffectingSemantics = OwnerSnapshotObserver$onCommitAffectingSemantics$1.INSTANCE;
        this.onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
        this.onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
        this.onCommitAffectingLayoutModifierInLookahead = OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1.INSTANCE;
        this.onCommitAffectingLookaheadLayout = OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1.INSTANCE;
    }

    public static /* synthetic */ void observeLayoutModifierSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, z, interfaceC3588op);
    }

    public static /* synthetic */ void observeLayoutSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutSnapshotReads$ui_release(layoutNode, z, interfaceC3588op);
    }

    public static /* synthetic */ void observeMeasureSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeMeasureSnapshotReads$ui_release(layoutNode, z, interfaceC3588op);
    }

    public final void clear$ui_release(Object obj) {
        AbstractC4492zt.h(obj, TypedValues.AttributesType.S_TARGET);
        this.observer.clear(obj);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(layoutNode, "node");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        if (!z || layoutNode.getLookaheadRoot$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifier, interfaceC3588op);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifierInLookahead, interfaceC3588op);
        }
    }

    public final void observeLayoutSnapshotReads$ui_release(LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(layoutNode, "node");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        if (!z || layoutNode.getLookaheadRoot$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayout, interfaceC3588op);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadLayout, interfaceC3588op);
        }
    }

    public final void observeMeasureSnapshotReads$ui_release(LayoutNode layoutNode, boolean z, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(layoutNode, "node");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        if (!z || layoutNode.getLookaheadRoot$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingMeasure, interfaceC3588op);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadMeasure, interfaceC3588op);
        }
    }

    public final <T extends OwnerScope> void observeReads$ui_release(T t, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(t, TypedValues.AttributesType.S_TARGET);
        AbstractC4492zt.h(interfaceC3750qp, "onChanged");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        this.observer.observeReads(t, interfaceC3750qp, interfaceC3588op);
    }

    public final void observeSemanticsReads$ui_release(LayoutNode layoutNode, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(layoutNode, "node");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        observeReads$ui_release(layoutNode, this.onCommitAffectingSemantics, interfaceC3588op);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
