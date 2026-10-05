package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangePickerKt$VerticalMonthsList$1$2$1$1$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ String $scrollToNextMonthLabel;
    final /* synthetic */ String $scrollToPreviousMonthLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateRangePickerKt$VerticalMonthsList$1$2$1$1$2(LazyListState lazyListState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
        super(1);
        this.$lazyListState = lazyListState;
        this.$coroutineScope = interfaceC2052dg;
        this.$scrollToPreviousMonthLabel = str;
        this.$scrollToNextMonthLabel = str2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, DateRangePickerKt.customScrollActions(this.$lazyListState, this.$coroutineScope, this.$scrollToPreviousMonthLabel, this.$scrollToNextMonthLabel));
    }
}
