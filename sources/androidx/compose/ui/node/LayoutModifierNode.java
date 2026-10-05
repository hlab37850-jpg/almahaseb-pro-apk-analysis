package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutModifierNode extends DelegatableNode {

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutModifierNode$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static int a(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicHeight.1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    AbstractC4492zt.h(measureScope, "$this$maxHeight");
                    AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo248measure3p2s80s(measureScope, measurable, j);
                }
            }, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int b(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicWidth.1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    AbstractC4492zt.h(measureScope, "$this$maxWidth");
                    AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo248measure3p2s80s(measureScope, measurable, j);
                }
            }, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int c(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicHeight.1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    AbstractC4492zt.h(measureScope, "$this$minHeight");
                    AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo248measure3p2s80s(measureScope, measurable, j);
                }
            }, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        public static int d(final LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
            AbstractC4492zt.h(intrinsicMeasurable, "measurable");
            return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicWidth.1
                @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    AbstractC4492zt.h(measureScope, "$this$minWidth");
                    AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                    return LayoutModifierNode.this.mo248measure3p2s80s(measureScope, measurable, j);
                }
            }, intrinsicMeasureScope, intrinsicMeasurable, i);
        }
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j);

    int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i);
}
