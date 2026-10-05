package androidx.compose.runtime;

import defpackage.AbstractC0747Ml;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class Recomposer$effectJob$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$effectJob$1$1(Recomposer recomposer) {
        super(1);
        this.this$0 = recomposer;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return FW.a;
    }

    public final void invoke(Throwable th) {
        InterfaceC4293xa interfaceC4293xa;
        InterfaceC4293xa interfaceC4293xa2;
        CancellationException cancellationExceptionA = AbstractC0747Ml.a("Recomposer effect job completed", th);
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            try {
                InterfaceC1830bu interfaceC1830bu = recomposer.runnerJob;
                interfaceC4293xa = null;
                if (interfaceC1830bu != null) {
                    recomposer._state.setValue(Recomposer.State.ShuttingDown);
                    if (recomposer.isClosed) {
                        if (recomposer.workContinuation != null) {
                            interfaceC4293xa2 = recomposer.workContinuation;
                        }
                        recomposer.workContinuation = null;
                        interfaceC1830bu.C(new Recomposer$effectJob$1$1$1$1(recomposer, th));
                        interfaceC4293xa = interfaceC4293xa2;
                    } else {
                        interfaceC1830bu.cancel(cancellationExceptionA);
                    }
                    interfaceC4293xa2 = null;
                    recomposer.workContinuation = null;
                    interfaceC1830bu.C(new Recomposer$effectJob$1$1$1$1(recomposer, th));
                    interfaceC4293xa = interfaceC4293xa2;
                } else {
                    recomposer.closeCause = cancellationExceptionA;
                    recomposer._state.setValue(Recomposer.State.ShutDown);
                    FW fw = FW.a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (interfaceC4293xa != null) {
            KL.a aVar = KL.a;
            interfaceC4293xa.resumeWith(KL.a(FW.a));
        }
    }
}
