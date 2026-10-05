package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureKt$measureLazyList$5 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ LazyListMeasuredItem $headerItem;
    final /* synthetic */ List<LazyListMeasuredItem> $positionedItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListMeasureKt$measureLazyList$5(List<LazyListMeasuredItem> list, LazyListMeasuredItem lazyListMeasuredItem) {
        super(1);
        this.$positionedItems = list;
        this.$headerItem = lazyListMeasuredItem;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$invoke");
        List<LazyListMeasuredItem> list = this.$positionedItems;
        LazyListMeasuredItem lazyListMeasuredItem = this.$headerItem;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i);
            if (lazyListMeasuredItem2 != lazyListMeasuredItem) {
                lazyListMeasuredItem2.place(placementScope);
            }
        }
        LazyListMeasuredItem lazyListMeasuredItem3 = this.$headerItem;
        if (lazyListMeasuredItem3 != null) {
            lazyListMeasuredItem3.place(placementScope);
        }
    }
}
