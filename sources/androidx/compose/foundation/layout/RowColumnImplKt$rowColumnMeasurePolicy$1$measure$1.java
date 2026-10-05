package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ RowColumnMeasureHelperResult $measureResult;
    final /* synthetic */ RowColumnMeasurementHelper $rowColumnMeasureHelper;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1(RowColumnMeasurementHelper rowColumnMeasurementHelper, RowColumnMeasureHelperResult rowColumnMeasureHelperResult, MeasureScope measureScope) {
        super(1);
        this.$rowColumnMeasureHelper = rowColumnMeasurementHelper;
        this.$measureResult = rowColumnMeasureHelperResult;
        this.$this_measure = measureScope;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        this.$rowColumnMeasureHelper.placeHelper(placementScope, this.$measureResult, 0, this.$this_measure.getLayoutDirection());
    }
}
