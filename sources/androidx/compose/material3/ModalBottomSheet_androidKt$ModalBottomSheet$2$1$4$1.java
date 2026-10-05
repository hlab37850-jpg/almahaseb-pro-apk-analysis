package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3750qp $settleToDismiss;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1(InterfaceC3750qp interfaceC3750qp) {
        super(2);
        this.$settleToDismiss = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(InterfaceC2052dg interfaceC2052dg, float f) {
        AbstractC4492zt.h(interfaceC2052dg, "$this$modalBottomSheetSwipeable");
        this.$settleToDismiss.invoke(Float.valueOf(f));
    }
}
