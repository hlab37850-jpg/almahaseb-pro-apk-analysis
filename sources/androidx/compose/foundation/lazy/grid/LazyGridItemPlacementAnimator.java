package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC2289gc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    private final void forEachNode(LazyGridMeasuredItem lazyGridMeasuredItem, InterfaceC3750qp interfaceC3750qp) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i));
            if (node != null) {
                interfaceC3750qp.invoke(node);
            }
        }
    }

    private final boolean getHasAnimations(LazyGridMeasuredItem lazyGridMeasuredItem) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyGridMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object obj) {
        if (obj instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) obj;
        }
        return null;
    }

    private final void initializeNode(LazyGridMeasuredItem lazyGridMeasuredItem, int i) {
        long jMo615getOffsetnOccac = lazyGridMeasuredItem.mo615getOffsetnOccac();
        long jM5274copyiSbpLlY$default = lazyGridMeasuredItem.isVertical() ? IntOffset.m5274copyiSbpLlY$default(jMo615getOffsetnOccac, 0, i, 1, null) : IntOffset.m5274copyiSbpLlY$default(jMo615getOffsetnOccac, i, 0, 2, null);
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i2));
            if (node != null) {
                long jMo615getOffsetnOccac2 = lazyGridMeasuredItem.mo615getOffsetnOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo615getOffsetnOccac2) - IntOffset.m5278getXimpl(jMo615getOffsetnOccac), IntOffset.m5279getYimpl(jMo615getOffsetnOccac2) - IntOffset.m5279getYimpl(jMo615getOffsetnOccac));
                node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM5274copyiSbpLlY$default) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM5274copyiSbpLlY$default) + IntOffset.m5279getYimpl(jIntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem lazyGridMeasuredItem) {
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem.getParentData(i));
            if (node != null) {
                long jMo615getOffsetnOccac = lazyGridMeasuredItem.mo615getOffsetnOccac();
                long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                if (!IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac()) && !IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, jMo615getOffsetnOccac)) {
                    node.m627animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo615getOffsetnOccac) - IntOffset.m5278getXimpl(jM629getRawOffsetnOccac), IntOffset.m5279getYimpl(jMo615getOffsetnOccac) - IntOffset.m5279getYimpl(jM629getRawOffsetnOccac)));
                }
                node.m630setRawOffsetgyyYBs(jMo615getOffsetnOccac);
            }
        }
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyGridMeasuredItem> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, boolean z) {
        int i4;
        int i5;
        List<LazyGridMeasuredItem> list2 = list;
        AbstractC4492zt.h(list2, "positionedItems");
        AbstractC4492zt.h(lazyGridMeasuredItemProvider, "itemProvider");
        AbstractC4492zt.h(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        int size = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                if (!this.keyToItemInfoMap.isEmpty()) {
                    break;
                }
                reset();
                return;
            } else if (getHasAnimations(list2.get(i6))) {
                break;
            } else {
                i6++;
            }
        }
        int i7 = this.firstVisibleIndex;
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) AbstractC3240kc.d0(list);
        this.firstVisibleIndex = lazyGridMeasuredItem != null ? lazyGridMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = lazyGridMeasuredItemProvider.getKeyIndexMap();
        int i8 = z ? i3 : i2;
        long jIntOffset = z ? IntOffsetKt.IntOffset(0, i) : IntOffsetKt.IntOffset(i, 0);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = list.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyGridMeasuredItem lazyGridMeasuredItem2 = list2.get(i9);
            this.movingAwayKeys.remove(lazyGridMeasuredItem2.getKey());
            if (getHasAnimations(lazyGridMeasuredItem2)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyGridMeasuredItem2.getKey());
                if (itemInfo == null) {
                    i4 = size2;
                    this.keyToItemInfoMap.put(lazyGridMeasuredItem2.getKey(), new ItemInfo(lazyGridMeasuredItem2.getCrossAxisSize(), lazyGridMeasuredItem2.getCrossAxisOffset()));
                    int index = lazyLayoutKeyIndexMap.getIndex(lazyGridMeasuredItem2.getKey());
                    if (index == -1 || lazyGridMeasuredItem2.getIndex() == index) {
                        long jMo615getOffsetnOccac = lazyGridMeasuredItem2.mo615getOffsetnOccac();
                        initializeNode(lazyGridMeasuredItem2, lazyGridMeasuredItem2.isVertical() ? IntOffset.m5279getYimpl(jMo615getOffsetnOccac) : IntOffset.m5278getXimpl(jMo615getOffsetnOccac));
                    } else if (index < i7) {
                        this.movingInFromStartBound.add(lazyGridMeasuredItem2);
                    } else {
                        this.movingInFromEndBound.add(lazyGridMeasuredItem2);
                    }
                } else {
                    i4 = size2;
                    int placeablesCount = lazyGridMeasuredItem2.getPlaceablesCount();
                    int i10 = 0;
                    while (i10 < placeablesCount) {
                        LazyLayoutAnimateItemModifierNode node = getNode(lazyGridMeasuredItem2.getParentData(i10));
                        if (node != null) {
                            i5 = placeablesCount;
                            if (!IntOffset.m5277equalsimpl0(node.m629getRawOffsetnOccac(), LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac())) {
                                long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                                node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM629getRawOffsetnOccac) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM629getRawOffsetnOccac) + IntOffset.m5279getYimpl(jIntOffset)));
                            }
                        } else {
                            i5 = placeablesCount;
                        }
                        i10++;
                        placeablesCount = i5;
                    }
                    itemInfo.setCrossAxisSize(lazyGridMeasuredItem2.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(lazyGridMeasuredItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyGridMeasuredItem2);
                }
            } else {
                i4 = size2;
                this.keyToItemInfoMap.remove(lazyGridMeasuredItem2.getKey());
            }
            i9++;
            list2 = list;
            size2 = i4;
        }
        List<LazyGridMeasuredItem> list3 = this.movingInFromStartBound;
        if (list3.size() > 1) {
            AbstractC2289gc.B(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyGridMeasuredItem) t2).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyGridMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list4 = this.movingInFromStartBound;
        int size3 = list4.size();
        int i11 = -1;
        int i12 = 0;
        int mainAxisSize = 0;
        for (int i13 = 0; i13 < size3; i13++) {
            LazyGridMeasuredItem lazyGridMeasuredItem3 = list4.get(i13);
            int row = z ? lazyGridMeasuredItem3.getRow() : lazyGridMeasuredItem3.getColumn();
            if (row == -1 || row != i11) {
                i12 += mainAxisSize;
                mainAxisSize = lazyGridMeasuredItem3.getMainAxisSize();
                i11 = row;
            } else {
                mainAxisSize = Math.max(mainAxisSize, lazyGridMeasuredItem3.getMainAxisSize());
            }
            initializeNode(lazyGridMeasuredItem3, (0 - i12) - lazyGridMeasuredItem3.getMainAxisSize());
            startAnimationsIfNeeded(lazyGridMeasuredItem3);
        }
        List<LazyGridMeasuredItem> list5 = this.movingInFromEndBound;
        if (list5.size() > 1) {
            AbstractC2289gc.B(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyGridMeasuredItem) t).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyGridMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list6 = this.movingInFromEndBound;
        int size4 = list6.size();
        int i14 = 0;
        int mainAxisSize2 = 0;
        int i15 = -1;
        for (int i16 = 0; i16 < size4; i16++) {
            LazyGridMeasuredItem lazyGridMeasuredItem4 = list6.get(i16);
            int row2 = z ? lazyGridMeasuredItem4.getRow() : lazyGridMeasuredItem4.getColumn();
            if (row2 == -1 || row2 != i15) {
                i14 += mainAxisSize2;
                mainAxisSize2 = lazyGridMeasuredItem4.getMainAxisSize();
                i15 = row2;
            } else {
                mainAxisSize2 = Math.max(mainAxisSize2, lazyGridMeasuredItem4.getMainAxisSize());
            }
            initializeNode(lazyGridMeasuredItem4, i8 + i14);
            startAnimationsIfNeeded(lazyGridMeasuredItem4);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, obj);
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyGridMeasuredItem lazyGridMeasuredItemM621getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m621getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, index2, 0, z ? Constraints.Companion.m5138fixedWidthOenEA2s(itemInfo2.getCrossAxisSize()) : Constraints.Companion.m5137fixedHeightOenEA2s(itemInfo2.getCrossAxisSize()), 2, null);
                int placeablesCount2 = lazyGridMeasuredItemM621getAndMeasure3p2s80s$default.getPlaceablesCount();
                boolean z2 = false;
                for (int i17 = 0; i17 < placeablesCount2; i17++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default.getParentData(i17));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z2 = true;
                    }
                }
                if (!z2 && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.keyToItemInfoMap.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default);
                } else {
                    this.movingAwayToEndBound.add(lazyGridMeasuredItemM621getAndMeasure3p2s80s$default);
                }
            }
        }
        List<LazyGridMeasuredItem> list7 = this.movingAwayToStartBound;
        if (list7.size() > 1) {
            AbstractC2289gc.B(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyGridMeasuredItem) t2).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyGridMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list8 = this.movingAwayToStartBound;
        int size5 = list8.size();
        int i18 = 0;
        int mainAxisSize3 = 0;
        int i19 = -1;
        for (int i20 = 0; i20 < size5; i20++) {
            LazyGridMeasuredItem lazyGridMeasuredItem5 = list8.get(i20);
            int lineIndexOfItem = lazyGridSpanLayoutProvider.getLineIndexOfItem(lazyGridMeasuredItem5.getIndex());
            if (lineIndexOfItem == -1 || lineIndexOfItem != i19) {
                i18 += mainAxisSize3;
                mainAxisSize3 = lazyGridMeasuredItem5.getMainAxisSize();
                i19 = lineIndexOfItem;
            } else {
                mainAxisSize3 = Math.max(mainAxisSize3, lazyGridMeasuredItem5.getMainAxisSize());
            }
            lazyGridMeasuredItem5.position((0 - i18) - lazyGridMeasuredItem5.getMainAxisSize(), ((ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, lazyGridMeasuredItem5.getKey())).getCrossAxisOffset(), i2, i3, (48 & 16) != 0 ? -1 : 0, (48 & 32) != 0 ? -1 : 0);
            list.add(lazyGridMeasuredItem5);
            startAnimationsIfNeeded(lazyGridMeasuredItem5);
        }
        List<LazyGridMeasuredItem> list9 = this.movingAwayToEndBound;
        if (list9.size() > 1) {
            AbstractC2289gc.B(list9, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyGridMeasuredItem) t).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyGridMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyGridMeasuredItem> list10 = this.movingAwayToEndBound;
        int size6 = list10.size();
        int mainAxisSize4 = 0;
        int i21 = -1;
        int i22 = 0;
        for (int i23 = 0; i23 < size6; i23++) {
            LazyGridMeasuredItem lazyGridMeasuredItem6 = list10.get(i23);
            int lineIndexOfItem2 = lazyGridSpanLayoutProvider.getLineIndexOfItem(lazyGridMeasuredItem6.getIndex());
            if (lineIndexOfItem2 == -1 || lineIndexOfItem2 != i21) {
                i22 += mainAxisSize4;
                mainAxisSize4 = lazyGridMeasuredItem6.getMainAxisSize();
                i21 = lineIndexOfItem2;
            } else {
                mainAxisSize4 = Math.max(mainAxisSize4, lazyGridMeasuredItem6.getMainAxisSize());
            }
            lazyGridMeasuredItem6.position(i8 + i22, ((ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, lazyGridMeasuredItem6.getKey())).getCrossAxisOffset(), i2, i3, (48 & 16) != 0 ? -1 : 0, (48 & 32) != 0 ? -1 : 0);
            list.add(lazyGridMeasuredItem6);
            startAnimationsIfNeeded(lazyGridMeasuredItem6);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }
}
