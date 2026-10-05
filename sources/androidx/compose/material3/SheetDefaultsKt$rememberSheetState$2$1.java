package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SheetDefaultsKt$rememberSheetState$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $confirmValueChange;
    final /* synthetic */ SheetValue $initialValue;
    final /* synthetic */ boolean $skipHiddenState;
    final /* synthetic */ boolean $skipPartiallyExpanded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheetDefaultsKt$rememberSheetState$2$1(boolean z, SheetValue sheetValue, InterfaceC3750qp interfaceC3750qp, boolean z2) {
        super(0);
        this.$skipPartiallyExpanded = z;
        this.$initialValue = sheetValue;
        this.$confirmValueChange = interfaceC3750qp;
        this.$skipHiddenState = z2;
    }

    @Override // defpackage.InterfaceC3588op
    public final SheetState invoke() {
        return new SheetState(this.$skipPartiallyExpanded, this.$initialValue, this.$confirmValueChange, this.$skipHiddenState);
    }
}
