package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC2289gc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    private final void forEachNode(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, InterfaceC3750qp interfaceC3750qp) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem.getParentData(i));
            if (node != null) {
                interfaceC3750qp.invoke(node);
            }
        }
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyStaggeredGridMeasuredItem.getParentData(i)) != null) {
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

    private final void initializeNode(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, int i) {
        long jMo657getOffsetnOccac = lazyStaggeredGridMeasuredItem.mo657getOffsetnOccac();
        long jM5274copyiSbpLlY$default = lazyStaggeredGridMeasuredItem.isVertical() ? IntOffset.m5274copyiSbpLlY$default(jMo657getOffsetnOccac, 0, i, 1, null) : IntOffset.m5274copyiSbpLlY$default(jMo657getOffsetnOccac, i, 0, 2, null);
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem.getParentData(i2));
            if (node != null) {
                long jMo657getOffsetnOccac2 = lazyStaggeredGridMeasuredItem.mo657getOffsetnOccac();
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo657getOffsetnOccac2) - IntOffset.m5278getXimpl(jMo657getOffsetnOccac), IntOffset.m5279getYimpl(jMo657getOffsetnOccac2) - IntOffset.m5279getYimpl(jMo657getOffsetnOccac));
                node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM5274copyiSbpLlY$default) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM5274copyiSbpLlY$default) + IntOffset.m5279getYimpl(jIntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem.getParentData(i));
            if (node != null) {
                long jMo657getOffsetnOccac = lazyStaggeredGridMeasuredItem.mo657getOffsetnOccac();
                long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                if (!IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac()) && !IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, jMo657getOffsetnOccac)) {
                    node.m627animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo657getOffsetnOccac) - IntOffset.m5278getXimpl(jM629getRawOffsetnOccac), IntOffset.m5279getYimpl(jMo657getOffsetnOccac) - IntOffset.m5279getYimpl(jM629getRawOffsetnOccac)));
                }
                node.m630setRawOffsetgyyYBs(jMo657getOffsetnOccac);
            }
        }
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyStaggeredGridMeasuredItem> list, LazyStaggeredGridMeasureProvider lazyStaggeredGridMeasureProvider, boolean z, int i4) {
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap2;
        int i5;
        List<LazyStaggeredGridMeasuredItem> list2 = list;
        AbstractC4492zt.h(list2, "positionedItems");
        AbstractC4492zt.h(lazyStaggeredGridMeasureProvider, "itemProvider");
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
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) AbstractC3240kc.d0(list);
        this.firstVisibleIndex = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : 0;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap3 = this.keyIndexMap;
        this.keyIndexMap = lazyStaggeredGridMeasureProvider.getKeyIndexMap();
        int i8 = z ? i3 : i2;
        long jIntOffset = z ? IntOffsetKt.IntOffset(0, i) : IntOffsetKt.IntOffset(i, 0);
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        int size2 = list.size();
        int i9 = 0;
        while (i9 < size2) {
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = list2.get(i9);
            this.movingAwayKeys.remove(lazyStaggeredGridMeasuredItem2.getKey());
            if (getHasAnimations(lazyStaggeredGridMeasuredItem2)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem2.getKey());
                if (itemInfo == null) {
                    this.keyToItemInfoMap.put(lazyStaggeredGridMeasuredItem2.getKey(), new ItemInfo(lazyStaggeredGridMeasuredItem2.getLane(), lazyStaggeredGridMeasuredItem2.getSpan(), lazyStaggeredGridMeasuredItem2.getCrossAxisOffset()));
                    int index = lazyLayoutKeyIndexMap3.getIndex(lazyStaggeredGridMeasuredItem2.getKey());
                    if (index == -1 || lazyStaggeredGridMeasuredItem2.getIndex() == index) {
                        long jMo657getOffsetnOccac = lazyStaggeredGridMeasuredItem2.mo657getOffsetnOccac();
                        initializeNode(lazyStaggeredGridMeasuredItem2, lazyStaggeredGridMeasuredItem2.isVertical() ? IntOffset.m5279getYimpl(jMo657getOffsetnOccac) : IntOffset.m5278getXimpl(jMo657getOffsetnOccac));
                    } else if (index < i7) {
                        this.movingInFromStartBound.add(lazyStaggeredGridMeasuredItem2);
                    } else {
                        this.movingInFromEndBound.add(lazyStaggeredGridMeasuredItem2);
                    }
                    lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                    i5 = i8;
                } else {
                    int placeablesCount = lazyStaggeredGridMeasuredItem2.getPlaceablesCount();
                    int i10 = 0;
                    while (i10 < placeablesCount) {
                        LazyLayoutAnimateItemModifierNode node = getNode(lazyStaggeredGridMeasuredItem2.getParentData(i10));
                        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap4 = lazyLayoutKeyIndexMap3;
                        int i11 = i8;
                        if (node != null && !IntOffset.m5277equalsimpl0(node.m629getRawOffsetnOccac(), LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac())) {
                            long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                            node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM629getRawOffsetnOccac) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM629getRawOffsetnOccac) + IntOffset.m5279getYimpl(jIntOffset)));
                        }
                        i10++;
                        i8 = i11;
                        lazyLayoutKeyIndexMap3 = lazyLayoutKeyIndexMap4;
                    }
                    lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                    i5 = i8;
                    itemInfo.setLane(lazyStaggeredGridMeasuredItem2.getLane());
                    itemInfo.setSpan(lazyStaggeredGridMeasuredItem2.getSpan());
                    itemInfo.setCrossAxisOffset(lazyStaggeredGridMeasuredItem2.getCrossAxisOffset());
                    startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem2);
                }
            } else {
                lazyLayoutKeyIndexMap2 = lazyLayoutKeyIndexMap3;
                i5 = i8;
                this.keyToItemInfoMap.remove(lazyStaggeredGridMeasuredItem2.getKey());
            }
            i9++;
            size2 = size2;
            i8 = i5;
            list2 = list;
            lazyLayoutKeyIndexMap3 = lazyLayoutKeyIndexMap2;
        }
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap5 = lazyLayoutKeyIndexMap3;
        int i12 = i8;
        int[] iArr = new int[i4];
        for (int i13 = 0; i13 < i4; i13++) {
            iArr[i13] = 0;
        }
        if (this.movingInFromStartBound.isEmpty()) {
            lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
        } else {
            List<LazyStaggeredGridMeasuredItem> list3 = this.movingInFromStartBound;
            if (list3.size() > 1) {
                lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
                AbstractC2289gc.B(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())));
                    }
                });
            } else {
                lazyLayoutKeyIndexMap = lazyLayoutKeyIndexMap5;
            }
            List<LazyStaggeredGridMeasuredItem> list4 = this.movingInFromStartBound;
            int size3 = list4.size();
            for (int i14 = 0; i14 < size3; i14++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = list4.get(i14);
                int lane = lazyStaggeredGridMeasuredItem3.getLane();
                iArr[lane] = iArr[lane] + lazyStaggeredGridMeasuredItem3.getMainAxisSize();
                initializeNode(lazyStaggeredGridMeasuredItem3, 0 - iArr[lazyStaggeredGridMeasuredItem3.getLane()]);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem3);
            }
            Q5.t(iArr, 0, 0, 0, 6, null);
        }
        if (!this.movingInFromEndBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list5 = this.movingInFromEndBound;
            if (list5.size() > 1) {
                AbstractC2289gc.B(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list6 = this.movingInFromEndBound;
            int size4 = list6.size();
            for (int i15 = 0; i15 < size4; i15++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = list6.get(i15);
                int i16 = i12 + iArr[lazyStaggeredGridMeasuredItem4.getLane()];
                int lane2 = lazyStaggeredGridMeasuredItem4.getLane();
                iArr[lane2] = iArr[lane2] + lazyStaggeredGridMeasuredItem4.getMainAxisSize();
                initializeNode(lazyStaggeredGridMeasuredItem4, i16);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem4);
            }
            Q5.t(iArr, 0, 0, 0, 6, null);
        }
        for (Object obj : this.movingAwayKeys) {
            ItemInfo itemInfo2 = (ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, obj);
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.keyToItemInfoMap.remove(obj);
            } else {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ = lazyStaggeredGridMeasureProvider.m671getAndMeasurejy6DScQ(index2, SpanRange.m676constructorimpl(itemInfo2.getLane(), itemInfo2.getSpan()));
                int placeablesCount2 = lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ.getPlaceablesCount();
                boolean z2 = false;
                for (int i17 = 0; i17 < placeablesCount2; i17++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ.getParentData(i17));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z2 = true;
                    }
                }
                if (!z2 && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.keyToItemInfoMap.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ);
                } else {
                    this.movingAwayToEndBound.add(lazyStaggeredGridMeasuredItemM671getAndMeasurejy6DScQ);
                }
            }
        }
        if (!this.movingAwayToStartBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list7 = this.movingAwayToStartBound;
            if (list7.size() > 1) {
                AbstractC2289gc.B(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list8 = this.movingAwayToStartBound;
            int size5 = list8.size();
            for (int i18 = 0; i18 < size5; i18++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = list8.get(i18);
                int lane3 = lazyStaggeredGridMeasuredItem5.getLane();
                iArr[lane3] = iArr[lane3] + lazyStaggeredGridMeasuredItem5.getMainAxisSize();
                lazyStaggeredGridMeasuredItem5.position(0 - iArr[lazyStaggeredGridMeasuredItem5.getLane()], ((ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, lazyStaggeredGridMeasuredItem5.getKey())).getCrossAxisOffset(), i12);
                list.add(lazyStaggeredGridMeasuredItem5);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem5);
            }
            Q5.t(iArr, 0, 0, 0, 6, null);
        }
        if (!this.movingAwayToEndBound.isEmpty()) {
            List<LazyStaggeredGridMeasuredItem> list9 = this.movingAwayToEndBound;
            if (list9.size() > 1) {
                AbstractC2289gc.B(list9, new Comparator() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyStaggeredGridMeasuredItem) t2).getKey())));
                    }
                });
            }
            List<LazyStaggeredGridMeasuredItem> list10 = this.movingAwayToEndBound;
            int size6 = list10.size();
            for (int i19 = 0; i19 < size6; i19++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = list10.get(i19);
                int i20 = i12 + iArr[lazyStaggeredGridMeasuredItem6.getLane()];
                int lane4 = lazyStaggeredGridMeasuredItem6.getLane();
                iArr[lane4] = iArr[lane4] + lazyStaggeredGridMeasuredItem6.getMainAxisSize();
                lazyStaggeredGridMeasuredItem6.position(i20, ((ItemInfo) AbstractC4243wx.h(this.keyToItemInfoMap, lazyStaggeredGridMeasuredItem6.getKey())).getCrossAxisOffset(), i12);
                list.add(lazyStaggeredGridMeasuredItem6);
                startAnimationsIfNeeded(lazyStaggeredGridMeasuredItem6);
            }
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
