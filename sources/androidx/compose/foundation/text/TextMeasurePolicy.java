package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.InterfaceC3588op;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class TextMeasurePolicy implements MeasurePolicy {
    private final InterfaceC3588op placements;

    public TextMeasurePolicy(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "placements");
        this.placements = interfaceC3588op;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        List list2 = (List) this.placements.invoke();
        ArrayList arrayList = null;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                Rect rect = (Rect) list2.get(i);
                C2020dG c2020dG = rect != null ? new C2020dG(list.get(i).mo4159measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m5269boximpl(IntOffsetKt.IntOffset(AbstractC1210aB.c(rect.getLeft()), AbstractC1210aB.c(rect.getTop())))) : null;
                if (c2020dG != null) {
                    arrayList2.add(c2020dG);
                }
            }
            arrayList = arrayList2;
        }
        return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j), null, new TextMeasurePolicy$measure$1(arrayList), 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i);
    }
}
