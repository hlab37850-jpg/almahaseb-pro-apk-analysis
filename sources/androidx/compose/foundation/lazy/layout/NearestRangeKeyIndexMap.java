package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.R5;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    private final Object[] keys;
    private final int keysStartIndex;
    private final Map<Object, Integer> map;

    public NearestRangeKeyIndexMap(C1001Vs c1001Vs, LazyLayoutIntervalContent<?> lazyLayoutIntervalContent) {
        AbstractC4492zt.h(c1001Vs, "nearestRange");
        AbstractC4492zt.h(lazyLayoutIntervalContent, "intervalContent");
        IntervalList<Interval> intervals = lazyLayoutIntervalContent.getIntervals();
        int iB = c1001Vs.b();
        if (iB < 0) {
            throw new IllegalStateException("Check failed.");
        }
        int iMin = Math.min(c1001Vs.c(), intervals.getSize() - 1);
        if (iMin < iB) {
            this.map = AbstractC4243wx.g();
            this.keys = new Object[0];
            this.keysStartIndex = 0;
        } else {
            this.keys = new Object[(iMin - iB) + 1];
            this.keysStartIndex = iB;
            HashMap map = new HashMap();
            intervals.forEach(iB, iMin, new NearestRangeKeyIndexMap$1$1(iB, iMin, map, this));
            this.map = map;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object obj) {
        AbstractC4492zt.h(obj, "key");
        Integer num = this.map.get(obj);
        if (num == null) {
            num = -1;
        }
        return num.intValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int i) {
        Object[] objArr = this.keys;
        int i2 = i - this.keysStartIndex;
        if (i2 < 0 || i2 > R5.O(objArr)) {
            return null;
        }
        return objArr[i2];
    }
}
