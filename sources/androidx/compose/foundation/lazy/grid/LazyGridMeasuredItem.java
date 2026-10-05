package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasuredItem implements LazyGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private int column;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List list, long j, Object obj2, AbstractC0419Di abstractC0419Di) {
        this(i, obj, z, i2, i3, z2, layoutDirection, i4, i5, list, j, obj2);
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m619copy4Tuh3kE(long j, InterfaceC3750qp interfaceC3750qp) {
        int iM5278getXimpl = this.isVertical ? IntOffset.m5278getXimpl(j) : ((Number) interfaceC3750qp.invoke(Integer.valueOf(IntOffset.m5278getXimpl(j)))).intValue();
        boolean z = this.isVertical;
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (z) {
            iM5279getYimpl = ((Number) interfaceC3750qp.invoke(Integer.valueOf(iM5279getYimpl))).intValue();
        }
        return IntOffsetKt.IntOffset(iM5278getXimpl, iM5279getYimpl);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m620getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5279getYimpl(j) : IntOffset.m5278getXimpl(j);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5278getXimpl(mo615getOffsetnOccac()) : IntOffset.m5279getYimpl(mo615getOffsetnOccac());
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo615getOffsetnOccac() {
        return this.offset;
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo616getSizeYbymL2g() {
        return this.size;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void place(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "scope");
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            long jMo615getOffsetnOccac = mo615getOffsetnOccac();
            Object parentData = getParentData(i);
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (lazyLayoutAnimateItemModifierNode != null) {
                long jM628getPlacementDeltanOccac = lazyLayoutAnimateItemModifierNode.m628getPlacementDeltanOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo615getOffsetnOccac) + IntOffset.m5278getXimpl(jM628getPlacementDeltanOccac), IntOffset.m5279getYimpl(jMo615getOffsetnOccac) + IntOffset.m5279getYimpl(jM628getPlacementDeltanOccac));
                if ((m620getMainAxisgyyYBs(jMo615getOffsetnOccac) <= mainAxisSize && m620getMainAxisgyyYBs(jIntOffset) <= mainAxisSize) || (m620getMainAxisgyyYBs(jMo615getOffsetnOccac) >= i2 && m620getMainAxisgyyYBs(jIntOffset) >= i2)) {
                    lazyLayoutAnimateItemModifierNode.cancelAnimation();
                }
                jMo615getOffsetnOccac = jIntOffset;
            }
            if (this.reverseLayout) {
                jMo615getOffsetnOccac = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5278getXimpl(jMo615getOffsetnOccac) : (this.mainAxisLayoutSize - IntOffset.m5278getXimpl(jMo615getOffsetnOccac)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5279getYimpl(jMo615getOffsetnOccac)) - getMainAxisSize(placeable) : IntOffset.m5279getYimpl(jMo615getOffsetnOccac));
            }
            long j = this.visualOffset;
            long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo615getOffsetnOccac) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jMo615getOffsetnOccac) + IntOffset.m5279getYimpl(j));
            if (this.isVertical) {
                Placeable.PlacementScope.m4206placeWithLayeraW9wM$default(placementScope, placeable, jIntOffset2, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m4205placeRelativeWithLayeraW9wM$default(placementScope, placeable, jIntOffset2, 0.0f, null, 6, null);
            }
        }
    }

    public final void position(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = this.isVertical;
        this.mainAxisLayoutSize = z ? i4 : i3;
        if (!z) {
            i3 = i4;
        }
        if (z && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (i3 - i2) - this.crossAxisSize;
        }
        this.offset = z ? IntOffsetKt.IntOffset(i2, i) : IntOffsetKt.IntOffset(i, i2);
        this.row = i5;
        this.column = i6;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List<? extends Placeable> list, long j, Object obj2) {
        AbstractC4492zt.h(obj, "key");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(list, "placeables");
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.reverseLayout = z2;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.visualOffset = j;
        this.contentType = obj2;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            iMax = Math.max(iMax, this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = iMax;
        this.mainAxisSizeWithSpacings = AbstractC3871sJ.d(i3 + iMax, 0);
        this.size = this.isVertical ? IntSizeKt.IntSize(this.crossAxisSize, iMax) : IntSizeKt.IntSize(iMax, this.crossAxisSize);
        this.offset = IntOffset.Companion.m5288getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
