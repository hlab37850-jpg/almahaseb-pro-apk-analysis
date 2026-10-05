package androidx.activity.compose;

import defpackage.C0916Sp;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ReportDrawnComposition$checkReporter$1 extends C0916Sp implements InterfaceC3750qp {
    public ReportDrawnComposition$checkReporter$1(Object obj) {
        super(1, obj, ReportDrawnComposition.class, "observeReporter", "observeReporter(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InterfaceC3588op) obj);
        return FW.a;
    }

    public final void invoke(InterfaceC3588op interfaceC3588op) {
        ((ReportDrawnComposition) this.receiver).observeReporter(interfaceC3588op);
    }
}
