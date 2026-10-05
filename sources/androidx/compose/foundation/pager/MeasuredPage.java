package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MeasuredPage implements PageInfo {
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, AbstractC0419Di abstractC0419Di) {
        this(i, i2, list, j, obj, orientation, horizontal, vertical, layoutDirection, z);
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m689copy4Tuh3kE(long j, InterfaceC3750qp interfaceC3750qp) {
        int iM5278getXimpl = this.isVertical ? IntOffset.m5278getXimpl(j) : ((Number) interfaceC3750qp.invoke(Integer.valueOf(IntOffset.m5278getXimpl(j)))).intValue();
        boolean z = this.isVertical;
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (z) {
            iM5279getYimpl = ((Number) interfaceC3750qp.invoke(Integer.valueOf(iM5279getYimpl))).intValue();
        }
        return IntOffsetKt.IntOffset(iM5278getXimpl, iM5279getYimpl);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m690getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final int getSize() {
        return this.size;
    }

    public final void place(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "scope");
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int size = this.placeables.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = this.placeables.get(i);
            long jM690getOffsetBjo55l4 = m690getOffsetBjo55l4(i);
            if (this.reverseLayout) {
                jM690getOffsetBjo55l4 = IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5278getXimpl(jM690getOffsetBjo55l4) : (this.mainAxisLayoutSize - IntOffset.m5278getXimpl(jM690getOffsetBjo55l4)) - getMainAxisSize(placeable), this.isVertical ? (this.mainAxisLayoutSize - IntOffset.m5279getYimpl(jM690getOffsetBjo55l4)) - getMainAxisSize(placeable) : IntOffset.m5279getYimpl(jM690getOffsetBjo55l4));
            }
            long j = this.visualOffset;
            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM690getOffsetBjo55l4) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jM690getOffsetBjo55l4) + IntOffset.m5279getYimpl(j));
            if (this.isVertical) {
                Placeable.PlacementScope.m4206placeWithLayeraW9wM$default(placementScope, placeable, jIntOffset, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m4205placeRelativeWithLayeraW9wM$default(placementScope, placeable, jIntOffset, 0.0f, null, 6, null);
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MeasuredPage(int i, int i2, List<? extends Placeable> list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z) {
        AbstractC4492zt.h(list, "placeables");
        AbstractC4492zt.h(obj, "key");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        this.index = i;
        this.size = i2;
        this.placeables = list;
        this.visualOffset = j;
        this.key = obj;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z;
        this.isVertical = orientation == Orientation.Vertical;
        int size = list.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            iMax = Math.max(iMax, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }
}
