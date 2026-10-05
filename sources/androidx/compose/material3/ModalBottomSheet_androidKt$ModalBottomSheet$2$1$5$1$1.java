package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3588op $animateToDismiss;
    final /* synthetic */ String $collapseActionLabel;
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ SheetState $sheetState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1(SheetState sheetState, String str, String str2, String str3, InterfaceC3588op interfaceC3588op, InterfaceC2052dg interfaceC2052dg) {
        super(1);
        this.$sheetState = sheetState;
        this.$dismissActionLabel = str;
        this.$expandActionLabel = str2;
        this.$collapseActionLabel = str3;
        this.$animateToDismiss = interfaceC3588op;
        this.$scope = interfaceC2052dg;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SheetState sheetState = this.$sheetState;
        String str = this.$dismissActionLabel;
        String str2 = this.$expandActionLabel;
        String str3 = this.$collapseActionLabel;
        InterfaceC3588op interfaceC3588op = this.$animateToDismiss;
        InterfaceC2052dg interfaceC2052dg = this.$scope;
        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1$1$1(interfaceC3588op));
        if (sheetState.getCurrentValue() == SheetValue.PartiallyExpanded) {
            SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1$1$2(sheetState, interfaceC2052dg, sheetState));
        } else if (sheetState.getHasPartiallyExpandedState()) {
            SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1$1$3(sheetState, interfaceC2052dg));
        }
    }
}
