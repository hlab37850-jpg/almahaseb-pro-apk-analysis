package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC2289gc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Set<Object> activeKeys = new LinkedHashSet();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    private final void forEachNode(LazyListMeasuredItem lazyListMeasuredItem, InterfaceC0526Fp interfaceC0526Fp) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                interfaceC0526Fp.mo13invoke(Integer.valueOf(i), node);
            }
        }
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyListMeasuredItem.getParentData(i)) != null) {
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

    private final void initializeNode(LazyListMeasuredItem lazyListMeasuredItem, int i) {
        long jM593getOffsetBjo55l4 = lazyListMeasuredItem.m593getOffsetBjo55l4(0);
        long jM5274copyiSbpLlY$default = lazyListMeasuredItem.isVertical() ? IntOffset.m5274copyiSbpLlY$default(jM593getOffsetBjo55l4, 0, i, 1, null) : IntOffset.m5274copyiSbpLlY$default(jM593getOffsetBjo55l4, i, 0, 2, null);
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i2));
            if (node != null) {
                long jM593getOffsetBjo55l5 = lazyListMeasuredItem.m593getOffsetBjo55l4(i2);
                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM593getOffsetBjo55l5) - IntOffset.m5278getXimpl(jM593getOffsetBjo55l4), IntOffset.m5279getYimpl(jM593getOffsetBjo55l5) - IntOffset.m5279getYimpl(jM593getOffsetBjo55l4));
                node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM5274copyiSbpLlY$default) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM5274copyiSbpLlY$default) + IntOffset.m5279getYimpl(jIntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                long jM593getOffsetBjo55l4 = lazyListMeasuredItem.m593getOffsetBjo55l4(i);
                long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                if (!IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac()) && !IntOffset.m5277equalsimpl0(jM629getRawOffsetnOccac, jM593getOffsetBjo55l4)) {
                    node.m627animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM593getOffsetBjo55l4) - IntOffset.m5278getXimpl(jM629getRawOffsetnOccac), IntOffset.m5279getYimpl(jM593getOffsetBjo55l4) - IntOffset.m5279getYimpl(jM629getRawOffsetnOccac)));
                }
                node.m630setRawOffsetgyyYBs(jM593getOffsetBjo55l4);
            }
        }
    }

    public final void onMeasured(int i, int i2, int i3, List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, boolean z) {
        int i4;
        List<LazyListMeasuredItem> list2 = list;
        AbstractC4492zt.h(list2, "positionedItems");
        AbstractC4492zt.h(lazyListMeasuredItemProvider, "itemProvider");
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                if (!this.activeKeys.isEmpty()) {
                    break;
                }
                reset();
                return;
            } else if (getHasAnimations(list2.get(i5))) {
                break;
            } else {
                i5++;
            }
        }
        int i6 = this.firstVisibleIndex;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) AbstractC3240kc.d0(list);
        this.firstVisibleIndex = lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = lazyListMeasuredItemProvider.getKeyIndexMap();
        int i7 = z ? i3 : i2;
        long jIntOffset = z ? IntOffsetKt.IntOffset(0, i) : IntOffsetKt.IntOffset(i, 0);
        this.movingAwayKeys.addAll(this.activeKeys);
        int size2 = list.size();
        int i8 = 0;
        while (i8 < size2) {
            LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i8);
            this.movingAwayKeys.remove(lazyListMeasuredItem2.getKey());
            if (!getHasAnimations(lazyListMeasuredItem2)) {
                i4 = size2;
                this.activeKeys.remove(lazyListMeasuredItem2.getKey());
            } else if (this.activeKeys.contains(lazyListMeasuredItem2.getKey())) {
                int placeablesCount = lazyListMeasuredItem2.getPlaceablesCount();
                int i9 = 0;
                while (i9 < placeablesCount) {
                    LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem2.getParentData(i9));
                    int i10 = size2;
                    if (node != null && !IntOffset.m5277equalsimpl0(node.m629getRawOffsetnOccac(), LazyLayoutAnimateItemModifierNode.Companion.m631getNotInitializednOccac())) {
                        long jM629getRawOffsetnOccac = node.m629getRawOffsetnOccac();
                        node.m630setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM629getRawOffsetnOccac) + IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jM629getRawOffsetnOccac) + IntOffset.m5279getYimpl(jIntOffset)));
                    }
                    i9++;
                    size2 = i10;
                }
                i4 = size2;
                startAnimationsIfNeeded(lazyListMeasuredItem2);
            } else {
                this.activeKeys.add(lazyListMeasuredItem2.getKey());
                int index = lazyLayoutKeyIndexMap.getIndex(lazyListMeasuredItem2.getKey());
                if (index == -1 || lazyListMeasuredItem2.getIndex() == index) {
                    long jM593getOffsetBjo55l4 = lazyListMeasuredItem2.m593getOffsetBjo55l4(0);
                    initializeNode(lazyListMeasuredItem2, lazyListMeasuredItem2.isVertical() ? IntOffset.m5279getYimpl(jM593getOffsetBjo55l4) : IntOffset.m5278getXimpl(jM593getOffsetBjo55l4));
                } else if (index < i6) {
                    this.movingInFromStartBound.add(lazyListMeasuredItem2);
                } else {
                    this.movingInFromEndBound.add(lazyListMeasuredItem2);
                }
                i4 = size2;
            }
            i8++;
            size2 = i4;
            list2 = list;
        }
        List<LazyListMeasuredItem> list3 = this.movingInFromStartBound;
        if (list3.size() > 1) {
            AbstractC2289gc.B(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list4 = this.movingInFromStartBound;
        int size3 = list4.size();
        int size4 = 0;
        for (int i11 = 0; i11 < size3; i11++) {
            LazyListMeasuredItem lazyListMeasuredItem3 = list4.get(i11);
            size4 += lazyListMeasuredItem3.getSize();
            initializeNode(lazyListMeasuredItem3, 0 - size4);
            startAnimationsIfNeeded(lazyListMeasuredItem3);
        }
        List<LazyListMeasuredItem> list5 = this.movingInFromEndBound;
        if (list5.size() > 1) {
            AbstractC2289gc.B(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())), Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list6 = this.movingInFromEndBound;
        int size5 = list6.size();
        int size6 = 0;
        for (int i12 = 0; i12 < size5; i12++) {
            LazyListMeasuredItem lazyListMeasuredItem4 = list6.get(i12);
            int i13 = i7 + size6;
            size6 += lazyListMeasuredItem4.getSize();
            initializeNode(lazyListMeasuredItem4, i13);
            startAnimationsIfNeeded(lazyListMeasuredItem4);
        }
        for (Object obj : this.movingAwayKeys) {
            int index2 = this.keyIndexMap.getIndex(obj);
            if (index2 == -1) {
                this.activeKeys.remove(obj);
            } else {
                LazyListMeasuredItem andMeasure = lazyListMeasuredItemProvider.getAndMeasure(index2);
                int placeablesCount2 = andMeasure.getPlaceablesCount();
                boolean z2 = false;
                for (int i14 = 0; i14 < placeablesCount2; i14++) {
                    LazyLayoutAnimateItemModifierNode node2 = getNode(andMeasure.getParentData(i14));
                    if (node2 != null && node2.isAnimationInProgress()) {
                        z2 = true;
                    }
                }
                if (!z2 && index2 == lazyLayoutKeyIndexMap.getIndex(obj)) {
                    this.activeKeys.remove(obj);
                } else if (index2 < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(andMeasure);
                } else {
                    this.movingAwayToEndBound.add(andMeasure);
                }
            }
        }
        List<LazyListMeasuredItem> list7 = this.movingAwayToStartBound;
        if (list7.size() > 1) {
            AbstractC2289gc.B(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list8 = this.movingAwayToStartBound;
        int size7 = list8.size();
        int size8 = 0;
        for (int i15 = 0; i15 < size7; i15++) {
            LazyListMeasuredItem lazyListMeasuredItem5 = list8.get(i15);
            size8 += lazyListMeasuredItem5.getSize();
            lazyListMeasuredItem5.position(0 - size8, i2, i3);
            list.add(lazyListMeasuredItem5);
            startAnimationsIfNeeded(lazyListMeasuredItem5);
        }
        List<LazyListMeasuredItem> list9 = this.movingAwayToEndBound;
        if (list9.size() > 1) {
            AbstractC2289gc.B(list9, new Comparator() { // from class: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return AbstractC0956Ud.d(Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t).getKey())), Integer.valueOf(this.this$0.keyIndexMap.getIndex(((LazyListMeasuredItem) t2).getKey())));
                }
            });
        }
        List<LazyListMeasuredItem> list10 = this.movingAwayToEndBound;
        int size9 = list10.size();
        int size10 = 0;
        for (int i16 = 0; i16 < size9; i16++) {
            LazyListMeasuredItem lazyListMeasuredItem6 = list10.get(i16);
            int i17 = i7 + size10;
            size10 += lazyListMeasuredItem6.getSize();
            lazyListMeasuredItem6.position(i17, i2, i3);
            list.add(lazyListMeasuredItem6);
            startAnimationsIfNeeded(lazyListMeasuredItem6);
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }
}
