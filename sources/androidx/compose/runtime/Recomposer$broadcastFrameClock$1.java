package androidx.compose.runtime;

import defpackage.AbstractC0747Ml;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC4293xa;
import defpackage.KL;

/* JADX INFO: loaded from: classes.dex */
public final class Recomposer$broadcastFrameClock$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$broadcastFrameClock$1(Recomposer recomposer) {
        super(0);
        this.this$0 = recomposer;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2646invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2646invoke() {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            interfaceC4293xaDeriveStateLocked = recomposer.deriveStateLocked();
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                throw AbstractC0747Ml.a("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
            }
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }
}
