package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ String $partialExpandActionLabel;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(SheetState sheetState, boolean z, String str, String str2, String str3, InterfaceC2052dg interfaceC2052dg) {
        super(1);
        this.$state = sheetState;
        this.$sheetSwipeEnabled = z;
        this.$expandActionLabel = str;
        this.$partialExpandActionLabel = str2;
        this.$dismissActionLabel = str3;
        this.$scope = interfaceC2052dg;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SheetState sheetState = this.$state;
        boolean z = this.$sheetSwipeEnabled;
        String str = this.$expandActionLabel;
        String str2 = this.$partialExpandActionLabel;
        String str3 = this.$dismissActionLabel;
        InterfaceC2052dg interfaceC2052dg = this.$scope;
        if (sheetState.getSwipeableState$material3_release().getAnchors$material3_release().size() <= 1 || !z) {
            return;
        }
        SheetValue currentValue = sheetState.getCurrentValue();
        SheetValue sheetValue = SheetValue.PartiallyExpanded;
        if (currentValue == sheetValue) {
            if (((Boolean) sheetState.getSwipeableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded)).booleanValue()) {
                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1(interfaceC2052dg, sheetState));
            }
        } else if (((Boolean) sheetState.getSwipeableState$material3_release().getConfirmValueChange$material3_release().invoke(sheetValue)).booleanValue()) {
            SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$2(interfaceC2052dg, sheetState));
        }
        if (sheetState.getSkipHiddenState$material3_release()) {
            return;
        }
        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$3(interfaceC2052dg, sheetState));
    }
}
