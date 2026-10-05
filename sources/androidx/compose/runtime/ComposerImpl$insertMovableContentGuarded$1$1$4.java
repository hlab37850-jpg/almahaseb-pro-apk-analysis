package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$1$4 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ MovableContentStateReference $from;
    final /* synthetic */ MovableContentState $resolvedState;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$4(MovableContentState movableContentState, ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        super(3);
        this.$resolvedState = movableContentState;
        this.this$0 = composerImpl;
        this.$from = movableContentStateReference;
        this.$to = movableContentStateReference2;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "<anonymous parameter 0>");
        AbstractC4492zt.h(slotWriter, "slots");
        AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
        MovableContentState movableContentStateMovableContentStateResolve$runtime_release = this.$resolvedState;
        if (movableContentStateMovableContentStateResolve$runtime_release == null && (movableContentStateMovableContentStateResolve$runtime_release = this.this$0.parentContext.movableContentStateResolve$runtime_release(this.$from)) == null) {
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new C1182Zu();
        }
        List<Anchor> listMoveIntoGroupFrom = slotWriter.moveIntoGroupFrom(1, movableContentStateMovableContentStateResolve$runtime_release.getSlotTable$runtime_release(), 2);
        RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.Companion;
        ControlledComposition composition$runtime_release = this.$to.getComposition$runtime_release();
        AbstractC4492zt.f(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
        companion.adoptAnchoredScopes$runtime_release(slotWriter, listMoveIntoGroupFrom, (RecomposeScopeOwner) composition$runtime_release);
    }
}
