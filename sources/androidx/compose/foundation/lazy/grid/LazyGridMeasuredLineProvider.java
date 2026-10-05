package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridMeasuredLineProvider {
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyGridMeasuredLineProvider(boolean z, LazyGridSlots lazyGridSlots, int i, int i2, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        AbstractC4492zt.h(lazyGridSlots, "slots");
        AbstractC4492zt.h(lazyGridMeasuredItemProvider, "measuredItemProvider");
        AbstractC4492zt.h(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        this.isVertical = z;
        this.slots = lazyGridSlots;
        this.gridItemsCount = i;
        this.spaceBetweenLines = i2;
        this.measuredItemProvider = lazyGridMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m623childConstraintsJhjzzOo$foundation_release(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = this.slots.getSizes()[i];
        } else {
            int i4 = (i2 + i) - 1;
            i3 = (this.slots.getPositions()[i4] + this.slots.getSizes()[i4]) - this.slots.getPositions()[i];
        }
        int iD = AbstractC3871sJ.d(i3, 0);
        return this.isVertical ? Constraints.Companion.m5138fixedWidthOenEA2s(iD) : Constraints.Companion.m5137fixedHeightOenEA2s(iD);
    }

    public abstract LazyGridMeasuredLine createLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i2);

    public final LazyGridMeasuredLine getAndMeasure(int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i);
        int size = lineConfiguration.getSpans().size();
        int i2 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int iM602getCurrentLineSpanimpl = GridItemSpan.m602getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i4).m605unboximpl());
            LazyGridMeasuredItem lazyGridMeasuredItemM622getAndMeasure3p2s80s = this.measuredItemProvider.m622getAndMeasure3p2s80s(lineConfiguration.getFirstItemIndex() + i4, i2, m623childConstraintsJhjzzOo$foundation_release(i3, iM602getCurrentLineSpanimpl));
            i3 += iM602getCurrentLineSpanimpl;
            FW fw = FW.a;
            lazyGridMeasuredItemArr[i4] = lazyGridMeasuredItemM622getAndMeasure3p2s80s;
        }
        return createLine(i, lazyGridMeasuredItemArr, lineConfiguration.getSpans(), i2);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }

    /* JADX INFO: renamed from: itemConstraints-OenEA2s, reason: not valid java name */
    public final long m624itemConstraintsOenEA2s(int i) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return m623childConstraintsJhjzzOo$foundation_release(0, lazyGridSpanLayoutProvider.spanOf(i, lazyGridSpanLayoutProvider.getSlotsPerLine()));
    }
}
