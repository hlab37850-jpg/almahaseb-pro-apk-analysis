package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class NearestRangeKeyIndexMap$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ HashMap<Object, Integer> $map;
    final /* synthetic */ NearestRangeKeyIndexMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearestRangeKeyIndexMap$1$1(int i, int i2, HashMap<Object, Integer> map, NearestRangeKeyIndexMap nearestRangeKeyIndexMap) {
        super(1);
        this.$first = i;
        this.$last = i2;
        this.$map = map;
        this.this$0 = nearestRangeKeyIndexMap;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval>) obj);
        return FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x003e  */
    public final void invoke(IntervalList.Interval<? extends LazyLayoutIntervalContent.Interval> interval) {
        Object defaultLazyLayoutKey;
        AbstractC4492zt.h(interval, "it");
        InterfaceC3750qp key = interval.getValue().getKey();
        int iMax = Math.max(this.$first, interval.getStartIndex());
        int iMin = Math.min(this.$last, (interval.getStartIndex() + interval.getSize()) - 1);
        if (iMax > iMin) {
            return;
        }
        while (true) {
            if (key == null) {
                defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(iMax);
            } else {
                defaultLazyLayoutKey = key.invoke(Integer.valueOf(iMax - interval.getStartIndex()));
                if (defaultLazyLayoutKey == null) {
                    defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(iMax);
                }
            }
            this.$map.put(defaultLazyLayoutKey, Integer.valueOf(iMax));
            this.this$0.keys[iMax - this.this$0.keysStartIndex] = defaultLazyLayoutKey;
            if (iMax == iMin) {
                return;
            } else {
                iMax++;
            }
        }
    }
}
