package androidx.compose.foundation.pager;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasureKt$measurePager$6 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<MeasuredPage> $positionedPages;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerMeasureKt$measurePager$6(List<MeasuredPage> list) {
        super(1);
        this.$positionedPages = list;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$invoke");
        List<MeasuredPage> list = this.$positionedPages;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).place(placementScope);
        }
    }
}
