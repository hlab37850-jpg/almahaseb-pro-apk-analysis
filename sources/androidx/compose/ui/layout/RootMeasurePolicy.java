package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC4492zt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        if (list.isEmpty()) {
            return MeasureScope.CC.q(measureScope, Constraints.m5130getMinWidthimpl(j), Constraints.m5129getMinHeightimpl(j), null, RootMeasurePolicy$measure$1.INSTANCE, 4, null);
        }
        if (list.size() == 1) {
            Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
            return MeasureScope.CC.q(measureScope, ConstraintsKt.m5142constrainWidthK40F9xA(j, placeableMo4159measureBRTryo0.getWidth()), ConstraintsKt.m5141constrainHeightK40F9xA(j, placeableMo4159measureBRTryo0.getHeight()), null, new RootMeasurePolicy$measure$2(placeableMo4159measureBRTryo0), 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).mo4159measureBRTryo0(j));
        }
        int size2 = arrayList.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Placeable placeable = (Placeable) arrayList.get(i2);
            iMax = Math.max(placeable.getWidth(), iMax);
            iMax2 = Math.max(placeable.getHeight(), iMax2);
        }
        return MeasureScope.CC.q(measureScope, ConstraintsKt.m5142constrainWidthK40F9xA(j, iMax), ConstraintsKt.m5141constrainHeightK40F9xA(j, iMax2), null, new RootMeasurePolicy$measure$4(arrayList), 4, null);
    }
}
