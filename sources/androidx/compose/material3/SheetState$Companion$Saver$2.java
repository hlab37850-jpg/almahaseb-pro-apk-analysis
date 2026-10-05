package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SheetState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ boolean $skipPartiallyExpanded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheetState$Companion$Saver$2(boolean z, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$skipPartiallyExpanded = z;
        this.$confirmValueChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public final SheetState invoke(SheetValue sheetValue) {
        AbstractC4492zt.h(sheetValue, "savedValue");
        return new SheetState(this.$skipPartiallyExpanded, sheetValue, this.$confirmValueChange, false, 8, null);
    }
}
