package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MeasurePolicy {

    public static final class DefaultImpls {
        @Deprecated
        public static int maxIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "$receiver");
            AbstractC4492zt.h(list, "measurables");
            return AbstractC2260gB.a(measurePolicy, intrinsicMeasureScope, list, i);
        }

        @Deprecated
        public static int maxIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "$receiver");
            AbstractC4492zt.h(list, "measurables");
            return AbstractC2260gB.b(measurePolicy, intrinsicMeasureScope, list, i);
        }

        @Deprecated
        public static int minIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "$receiver");
            AbstractC4492zt.h(list, "measurables");
            return AbstractC2260gB.c(measurePolicy, intrinsicMeasureScope, list, i);
        }

        @Deprecated
        public static int minIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "$receiver");
            AbstractC4492zt.h(list, "measurables");
            return AbstractC2260gB.d(measurePolicy, intrinsicMeasureScope, list, i);
        }
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i);
}
