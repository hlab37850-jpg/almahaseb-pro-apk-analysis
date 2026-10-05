package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$1$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ List<InterfaceC0552Gp> $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$2$1(ComposerImpl composerImpl, List<InterfaceC0552Gp> list, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = list;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2631invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2631invoke() {
        ComposerImpl composerImpl = this.this$0;
        List<InterfaceC0552Gp> list = this.$offsetChanges;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        List list2 = composerImpl.changes;
        try {
            composerImpl.changes = list;
            SlotReader slotReader2 = composerImpl.reader;
            int[] iArr = composerImpl.nodeCountOverrides;
            composerImpl.nodeCountOverrides = null;
            try {
                composerImpl.reader = slotReader;
                composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
                FW fw = FW.a;
                composerImpl.reader = slotReader2;
                composerImpl.nodeCountOverrides = iArr;
                composerImpl.changes = list2;
            } catch (Throwable th) {
                composerImpl.reader = slotReader2;
                composerImpl.nodeCountOverrides = iArr;
                throw th;
            }
        } catch (Throwable th2) {
            composerImpl.changes = list2;
            throw th2;
        }
    }
}
