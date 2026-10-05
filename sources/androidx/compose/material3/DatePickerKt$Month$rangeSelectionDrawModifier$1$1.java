package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$Month$rangeSelectionDrawModifier$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ State<SelectedRangeInfo> $rangeSelectionInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$Month$rangeSelectionDrawModifier$1$1(State<SelectedRangeInfo> state, DatePickerColors datePickerColors) {
        super(1);
        this.$rangeSelectionInfo = state;
        this.$colors = datePickerColors;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return FW.a;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "$this$drawWithContent");
        SelectedRangeInfo value = this.$rangeSelectionInfo.getValue();
        if (value != null) {
            DateRangePickerKt.m1514drawRangeBackgroundmxwnekA(contentDrawScope, value, this.$colors.m1490getDayInSelectionRangeContainerColor0d7_KjU$material3_release());
        }
        contentDrawScope.drawContent();
    }
}
