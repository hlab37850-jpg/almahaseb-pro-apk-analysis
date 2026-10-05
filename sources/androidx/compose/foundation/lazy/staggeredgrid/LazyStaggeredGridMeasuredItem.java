package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int sizeWithSpacings;
    private final int span;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2) {
        Integer numValueOf;
        AbstractC4492zt.h(obj, "key");
        AbstractC4492zt.h(list, "placeables");
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj2;
        int i7 = 1;
        this.isVisible = true;
        Integer num = null;
        if (!list.isEmpty()) {
            Placeable placeable = (Placeable) list.get(0);
            numValueOf = Integer.valueOf(z ? placeable.getHeight() : placeable.getWidth());
            int iO = AbstractC1886cc.o(list);
            if (1 <= iO) {
                int i8 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i8);
                    Integer numValueOf2 = Integer.valueOf(this.isVertical ? placeable2.getHeight() : placeable2.getWidth());
                    numValueOf = numValueOf2.compareTo(numValueOf) > 0 ? numValueOf2 : numValueOf;
                    if (i8 == iO) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        } else {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        this.mainAxisSize = iIntValue;
        this.sizeWithSpacings = AbstractC3871sJ.d(iIntValue + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            Integer numValueOf3 = Integer.valueOf(this.isVertical ? placeable3.getWidth() : placeable3.getHeight());
            int iO2 = AbstractC1886cc.o(list2);
            if (1 <= iO2) {
                while (true) {
                    Placeable placeable4 = list2.get(i7);
                    Integer numValueOf4 = Integer.valueOf(this.isVertical ? placeable4.getWidth() : placeable4.getHeight());
                    numValueOf3 = numValueOf4.compareTo(numValueOf3) > 0 ? numValueOf4 : numValueOf3;
                    if (i7 == iO2) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            num = numValueOf3;
        }
        int iIntValue2 = num != null ? num.intValue() : 0;
        this.crossAxisSize = iIntValue2;
        this.mainAxisLayoutSize = -1;
        this.size = this.isVertical ? IntSizeKt.IntSize(iIntValue2, this.mainAxisSize) : IntSizeKt.IntSize(this.mainAxisSize, iIntValue2);
        this.offset = IntOffset.Companion.m5288getZeronOccac();
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m672copy4Tuh3kE(long j, InterfaceC3750qp interfaceC3750qp) {
        int iM5278getXimpl = this.isVertical ? IntOffset.m5278getXimpl(j) : ((Number) interfaceC3750qp.invoke(Integer.valueOf(IntOffset.m5278getXimpl(j)))).intValue();
        boolean z = this.isVertical;
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (z) {
            iM5279getYimpl = ((Number) interfaceC3750qp.invoke(Integer.valueOf(iM5279getYimpl))).intValue();
        }
        return IntOffsetKt.IntOffset(iM5278getXimpl, iM5279getYimpl);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m673getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5279getYimpl(j) : IntOffset.m5278getXimpl(j);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5278getXimpl(mo657getOffsetnOccac()) : IntOffset.m5279getYimpl(mo657getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo657getOffsetnOccac() {
        return this.offset;
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo658getSizeYbymL2g() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getSpan() {
        return this.span;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void place(Placeable.PlacementScope placementScope, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        AbstractC4492zt.h(placementScope, "scope");
        AbstractC4492zt.h(lazyStaggeredGridMeasureContext, "context");
        if (this.mainAxisLayoutSize == -1) {
            throw new IllegalArgumentException("position() should be called first");
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
            int i2 = this.maxMainAxisOffset;
            long jMo657getOffsetnOccac = mo657getOffsetnOccac();
            Object parentData = getParentData(i);
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (lazyLayoutAnimateItemModifierNode != null) {
                long jM628getPlacementDeltanOccac = lazyLayoutAnimateItemModifierNode.m628getPlacementDeltanOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo657getOffsetnOccac) + IntOffset.m5278getXimpl(jM628getPlacementDeltanOccac), IntOffset.m5279getYimpl(jMo657getOffsetnOccac) + IntOffset.m5279getYimpl(jM628getPlacementDeltanOccac));
                if ((m673getMainAxisgyyYBs(jMo657getOffsetnOccac) <= height && m673getMainAxisgyyYBs(jIntOffset) <= height) || (m673getMainAxisgyyYBs(jMo657getOffsetnOccac) >= i2 && m673getMainAxisgyyYBs(jIntOffset) >= i2)) {
                    lazyLayoutAnimateItemModifierNode.cancelAnimation();
                }
                jMo657getOffsetnOccac = jIntOffset;
            }
            if (lazyStaggeredGridMeasureContext.getReverseLayout()) {
                jMo657getOffsetnOccac = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5278getXimpl(jMo657getOffsetnOccac) : (this.mainAxisLayoutSize - IntOffset.m5278getXimpl(jMo657getOffsetnOccac)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth()), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5279getYimpl(jMo657getOffsetnOccac)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth()) : IntOffset.m5279getYimpl(jMo657getOffsetnOccac));
            }
            long jM661getContentOffsetnOccac = lazyStaggeredGridMeasureContext.m661getContentOffsetnOccac();
            Placeable.PlacementScope.m4205placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo657getOffsetnOccac) + IntOffset.m5278getXimpl(jM661getContentOffsetnOccac), IntOffset.m5279getYimpl(jMo657getOffsetnOccac) + IntOffset.m5279getYimpl(jM661getContentOffsetnOccac)), 0.0f, null, 6, null);
        }
    }

    public final void position(int i, int i2, int i3) {
        this.mainAxisLayoutSize = i3;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = i3 + this.afterContentPadding;
        this.offset = this.isVertical ? IntOffsetKt.IntOffset(i2, i) : IntOffsetKt.IntOffset(i, i2);
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public String toString() {
        return super.toString();
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
