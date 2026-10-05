package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogKt$AlertDialogFlowRow$1$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<Integer> $crossAxisPositions;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ List<List<Placeable>> $sequences;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogFlowRow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f, int i, List<Integer> list2) {
        super(1);
        this.$sequences = list;
        this.$this_Layout = measureScope;
        this.$mainAxisSpacing = f;
        this.$mainAxisLayoutSize = i;
        this.$crossAxisPositions = list2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        List<List<Placeable>> list = this.$sequences;
        MeasureScope measureScope = this.$this_Layout;
        float f = this.$mainAxisSpacing;
        int i = this.$mainAxisLayoutSize;
        List<Integer> list2 = this.$crossAxisPositions;
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC1886cc.w();
            }
            List list3 = (List) obj;
            int size = list3.size();
            int[] iArr = new int[size];
            int i4 = 0;
            while (i4 < size) {
                iArr[i4] = ((Placeable) list3.get(i4)).getWidth() + (i4 < AbstractC1886cc.o(list3) ? measureScope.mo327roundToPx0680j_4(f) : 0);
                i4++;
            }
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            int[] iArr2 = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr2[i5] = 0;
            }
            end.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
            int i6 = 0;
            for (Object obj2 : list3) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    AbstractC1886cc.w();
                }
                Placeable.PlacementScope.place$default(placementScope, (Placeable) obj2, iArr2[i6], list2.get(i2).intValue(), 0.0f, 4, null);
                i6 = i7;
            }
            i2 = i3;
        }
    }
}
