package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3173jk;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, AbstractC0419Di abstractC0419Di) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m2702calculateScaledSizeE7KxVPU(long j) {
        if (!getUseIntrinsicSize()) {
            return j;
        }
        long jSize = SizeKt.Size(!m2704hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo3562getIntrinsicSizeNHjbRc()) ? Size.m2867getWidthimpl(j) : Size.m2867getWidthimpl(this.painter.mo3562getIntrinsicSizeNHjbRc()), !m2703hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo3562getIntrinsicSizeNHjbRc()) ? Size.m2864getHeightimpl(j) : Size.m2864getHeightimpl(this.painter.mo3562getIntrinsicSizeNHjbRc()));
        return (Size.m2867getWidthimpl(j) == 0.0f || Size.m2864getHeightimpl(j) == 0.0f) ? Size.Companion.m2876getZeroNHjbRc() : ScaleFactorKt.m4237timesUQTWf7w(jSize, this.contentScale.mo4150computeScaleFactorH7hwNQA(jSize, j));
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo3562getIntrinsicSizeNHjbRc() != Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m2703hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m2863equalsimpl0(j, Size.Companion.m2875getUnspecifiedNHjbRc())) {
            float fM2864getHeightimpl = Size.m2864getHeightimpl(j);
            if (!Float.isInfinite(fM2864getHeightimpl) && !Float.isNaN(fM2864getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m2704hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m2863equalsimpl0(j, Size.Companion.m2875getUnspecifiedNHjbRc())) {
            float fM2867getWidthimpl = Size.m2867getWidthimpl(j);
            if (!Float.isInfinite(fM2867getWidthimpl) && !Float.isNaN(fM2867getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m2705modifyConstraintsZezNO4M(long j) {
        boolean z = false;
        boolean z2 = Constraints.m5124getHasBoundedWidthimpl(j) && Constraints.m5123getHasBoundedHeightimpl(j);
        if (Constraints.m5126getHasFixedWidthimpl(j) && Constraints.m5125getHasFixedHeightimpl(j)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m5119copyZbe2FdA$default(j, Constraints.m5128getMaxWidthimpl(j), 0, Constraints.m5127getMaxHeightimpl(j), 0, 10, null);
        }
        long jMo3562getIntrinsicSizeNHjbRc = this.painter.mo3562getIntrinsicSizeNHjbRc();
        long jM2702calculateScaledSizeE7KxVPU = m2702calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m5142constrainWidthK40F9xA(j, m2704hasSpecifiedAndFiniteWidthuvyYCjk(jMo3562getIntrinsicSizeNHjbRc) ? AbstractC1210aB.c(Size.m2867getWidthimpl(jMo3562getIntrinsicSizeNHjbRc)) : Constraints.m5130getMinWidthimpl(j)), ConstraintsKt.m5141constrainHeightK40F9xA(j, m2703hasSpecifiedAndFiniteHeightuvyYCjk(jMo3562getIntrinsicSizeNHjbRc) ? AbstractC1210aB.c(Size.m2864getHeightimpl(jMo3562getIntrinsicSizeNHjbRc)) : Constraints.m5129getMinHeightimpl(j))));
        return Constraints.m5119copyZbe2FdA$default(j, ConstraintsKt.m5142constrainWidthK40F9xA(j, AbstractC1210aB.c(Size.m2867getWidthimpl(jM2702calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5141constrainHeightK40F9xA(j, AbstractC1210aB.c(Size.m2864getHeightimpl(jM2702calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "<this>");
        long jMo3562getIntrinsicSizeNHjbRc = this.painter.mo3562getIntrinsicSizeNHjbRc();
        long jSize = SizeKt.Size(m2704hasSpecifiedAndFiniteWidthuvyYCjk(jMo3562getIntrinsicSizeNHjbRc) ? Size.m2867getWidthimpl(jMo3562getIntrinsicSizeNHjbRc) : Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()), m2703hasSpecifiedAndFiniteHeightuvyYCjk(jMo3562getIntrinsicSizeNHjbRc) ? Size.m2864getHeightimpl(jMo3562getIntrinsicSizeNHjbRc) : Size.m2864getHeightimpl(contentDrawScope.mo3469getSizeNHjbRc()));
        long jM2876getZeroNHjbRc = (Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) == 0.0f || Size.m2864getHeightimpl(contentDrawScope.mo3469getSizeNHjbRc()) == 0.0f) ? Size.Companion.m2876getZeroNHjbRc() : ScaleFactorKt.m4237timesUQTWf7w(jSize, this.contentScale.mo4150computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo3469getSizeNHjbRc()));
        long jMo2684alignKFBX0sM = this.alignment.mo2684alignKFBX0sM(IntSizeKt.IntSize(AbstractC1210aB.c(Size.m2867getWidthimpl(jM2876getZeroNHjbRc)), AbstractC1210aB.c(Size.m2864getHeightimpl(jM2876getZeroNHjbRc))), IntSizeKt.IntSize(AbstractC1210aB.c(Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc())), AbstractC1210aB.c(Size.m2864getHeightimpl(contentDrawScope.mo3469getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM5278getXimpl = IntOffset.m5278getXimpl(jMo2684alignKFBX0sM);
        float fM5279getYimpl = IntOffset.m5279getYimpl(jMo2684alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(fM5278getXimpl, fM5279getYimpl);
        this.painter.m3568drawx_KDEd0(contentDrawScope, jM2876getZeroNHjbRc, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-fM5278getXimpl, -fM5279getYimpl);
        contentDrawScope.drawContent();
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long jM2705modifyConstraintsZezNO4M = m2705modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5129getMinHeightimpl(jM2705modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long jM2705modifyConstraintsZezNO4M = m2705modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5130getMinWidthimpl(jM2705modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(m2705modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new PainterNode$measure$1(placeableMo4159measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long jM2705modifyConstraintsZezNO4M = m2705modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5129getMinHeightimpl(jM2705modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long jM2705modifyConstraintsZezNO4M = m2705modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5130getMinWidthimpl(jM2705modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        AbstractC3173jk.a(this);
    }

    public final void setAlignment(Alignment alignment) {
        AbstractC4492zt.h(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        AbstractC4492zt.h(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        AbstractC4492zt.h(painter, "<set-?>");
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        AbstractC4492zt.h(painter, "painter");
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        AbstractC4492zt.h(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }
}
