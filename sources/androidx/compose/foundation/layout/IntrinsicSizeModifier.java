package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
interface IntrinsicSizeModifier extends LayoutModifier {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static boolean a(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        public static int b(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }

        public static int c(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }

        public static MeasureResult d(IntrinsicSizeModifier intrinsicSizeModifier, MeasureScope measureScope, Measurable measurable, long j) {
            AbstractC4492zt.h(measureScope, "$this$measure");
            AbstractC4492zt.h(measurable, "measurable");
            long jMo439calculateContentConstraintsl58MMJ0 = intrinsicSizeModifier.mo439calculateContentConstraintsl58MMJ0(measureScope, measurable, j);
            if (intrinsicSizeModifier.getEnforceIncoming()) {
                jMo439calculateContentConstraintsl58MMJ0 = ConstraintsKt.m5140constrainN9IONVI(j, jMo439calculateContentConstraintsl58MMJ0);
            }
            Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(jMo439calculateContentConstraintsl58MMJ0);
            return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new IntrinsicSizeModifier$measure$1(placeableMo4159measureBRTryo0), 4, null);
        }

        public static int e(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }

        public static int f(IntrinsicSizeModifier intrinsicSizeModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
    }

    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    long mo439calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j);

    boolean getEnforceIncoming();

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo41measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);
}
