package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    @ExperimentalFoundationApi
    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, AbstractC0419Di abstractC0419Di) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2);
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m591copy4Tuh3kE(long j, InterfaceC3750qp interfaceC3750qp) {
        int iM5278getXimpl = this.isVertical ? IntOffset.m5278getXimpl(j) : ((Number) interfaceC3750qp.invoke(Integer.valueOf(IntOffset.m5278getXimpl(j)))).intValue();
        boolean z = this.isVertical;
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (z) {
            iM5279getYimpl = ((Number) interfaceC3750qp.invoke(Integer.valueOf(iM5279getYimpl))).intValue();
        }
        return IntOffsetKt.IntOffset(iM5278getXimpl, iM5279getYimpl);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m592getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m5279getYimpl(j) : IntOffset.m5278getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m593getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
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
            long jM593getOffsetBjo55l4 = m593getOffsetBjo55l4(i);
            Object parentData = getParentData(i);
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (lazyLayoutAnimateItemModifierNode != null) {
                long jM628getPlacementDeltanOccac = lazyLayoutAnimateItemModifierNode.m628getPlacementDeltanOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM593getOffsetBjo55l4) + IntOffset.m5278getXimpl(jM628getPlacementDeltanOccac), IntOffset.m5279getYimpl(jM593getOffsetBjo55l4) + IntOffset.m5279getYimpl(jM628getPlacementDeltanOccac));
                if ((m592getMainAxisgyyYBs(jM593getOffsetBjo55l4) <= mainAxisSize && m592getMainAxisgyyYBs(jIntOffset) <= mainAxisSize) || (m592getMainAxisgyyYBs(jM593getOffsetBjo55l4) >= i2 && m592getMainAxisgyyYBs(jIntOffset) >= i2)) {
                    lazyLayoutAnimateItemModifierNode.cancelAnimation();
                }
                jM593getOffsetBjo55l4 = jIntOffset;
            }
            if (this.reverseLayout) {
                jM593getOffsetBjo55l4 = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5278getXimpl(jM593getOffsetBjo55l4) : (this.mainAxisLayoutSize - IntOffset.m5278getXimpl(jM593getOffsetBjo55l4)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5279getYimpl(jM593getOffsetBjo55l4)) - getMainAxisSize(placeable) : IntOffset.m5279getYimpl(jM593getOffsetBjo55l4));
            }
            long j = this.visualOffset;
            long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM593getOffsetBjo55l4) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jM593getOffsetBjo55l4) + IntOffset.m5279getYimpl(j));
            if (this.isVertical) {
                Placeable.PlacementScope.m4206placeWithLayeraW9wM$default(placementScope, placeable, jIntOffset2, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m4205placeRelativeWithLayeraW9wM$default(placementScope, placeable, jIntOffset2, 0.0f, null, 6, null);
            }
        }
    }

    public final void position(int i, int i2, int i3) {
        int width;
        this.offset = i;
        this.mainAxisLayoutSize = this.isVertical ? i3 : i2;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = list.get(i4);
            int i5 = i4 * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iArr[i5] = horizontal.align(placeable.getWidth(), i2, this.layoutDirection);
                this.placeableOffsets[i5 + 1] = i;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i5] = i;
                int i6 = i5 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                iArr2[i6] = vertical.align(placeable.getHeight(), i3);
                width = placeable.getWidth();
            }
            i += width;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2) {
        AbstractC4492zt.h(list, "placeables");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(obj, "key");
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            height += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.sizeWithSpacings = AbstractC3871sJ.d(getSize() + this.spacing, 0);
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }
}
