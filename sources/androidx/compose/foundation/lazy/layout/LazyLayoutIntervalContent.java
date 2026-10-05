package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval;
import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
public abstract class LazyLayoutIntervalContent<Interval extends Interval> {
    public static final int $stable = 0;

    @ExperimentalFoundationApi
    public interface Interval {

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval$-CC, reason: invalid class name */
        public abstract /* synthetic */ class CC {
            public static InterfaceC3750qp a(Interval interval) {
                return null;
            }

            public static InterfaceC3750qp b(Interval interval) {
                return LazyLayoutIntervalContent$Interval$type$1.INSTANCE;
            }
        }

        InterfaceC3750qp getKey();

        InterfaceC3750qp getType();
    }

    public final Object getContentType(int i) {
        IntervalList.Interval<Interval> interval = getIntervals().get(i);
        return interval.getValue().getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }

    public abstract IntervalList<Interval> getIntervals();

    public final int getItemCount() {
        return getIntervals().getSize();
    }

    public final Object getKey(int i) {
        Object objInvoke;
        IntervalList.Interval<Interval> interval = getIntervals().get(i);
        int startIndex = i - interval.getStartIndex();
        InterfaceC3750qp key = interval.getValue().getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(startIndex))) == null) ? Lazy_androidKt.getDefaultLazyLayoutKey(i) : objInvoke;
    }

    public final <T> T withInterval(int i, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        IntervalList.Interval<Interval> interval = getIntervals().get(i);
        return (T) interfaceC0526Fp.mo13invoke(Integer.valueOf(i - interval.getStartIndex()), interval.getValue());
    }
}
