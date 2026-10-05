package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0437Ea;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3173jk;
import defpackage.AbstractC3876sO;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.HV;
import defpackage.InterfaceC3750qp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private InterfaceC3750qp onPlaceholderLayout;
    private InterfaceC3750qp onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private InterfaceC3750qp semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(List<TextLayoutResult> list) {
            AbstractC4492zt.h(list, "textLayoutResult");
            TextLayoutResult layoutOrNull = TextAnnotatedStringNode.this.getLayoutCache().getLayoutOrNull();
            if (layoutOrNull != null) {
                list.add(layoutOrNull);
            } else {
                layoutOrNull = null;
            }
            return Boolean.valueOf(layoutOrNull != null);
        }
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, interfaceC3750qp, i, z, i2, i3, list, interfaceC3750qp2, selectionController, colorProducer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        AbstractC4492zt.e(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "<this>");
        InterfaceC3750qp anonymousClass1 = this.semanticsTextLayoutResult;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AnonymousClass1();
            this.semanticsTextLayoutResult = anonymousClass1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, this.text);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, anonymousClass1, 1, null);
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (z2 || z3 || z4) {
            getLayoutCache().m858updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
            LayoutModifierNodeKt.invalidateMeasurement(this);
            DrawModifierNodeKt.invalidateDraw(this);
        }
        if (z) {
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "<this>");
        SelectionController selectionController = this.selectionController;
        if (selectionController != null) {
            selectionController.draw(contentDrawScope);
        }
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        TextLayoutResult textLayoutResult = getLayoutCache().getTextLayoutResult();
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5106equalsimpl0(this.overflow, TextOverflow.Companion.m5115getVisiblegIe3tQ8());
        if (z) {
            Rect rectM2838Recttz77jQw = RectKt.m2838Recttz77jQw(Offset.Companion.m2814getZeroF1C5BW0(), SizeKt.Size(IntSize.m5320getWidthimpl(textLayoutResult.m4678getSizeYbymL2g()), IntSize.m5319getHeightimpl(textLayoutResult.m4678getSizeYbymL2g())));
            canvas.save();
            AbstractC0437Ea.o(canvas, rectM2838Recttz77jQw, 0, 2, null);
        }
        try {
            TextDecoration textDecoration = this.style.getTextDecoration();
            if (textDecoration == null) {
                textDecoration = TextDecoration.Companion.getNone();
            }
            TextDecoration textDecoration2 = textDecoration;
            Shadow shadow = this.style.getShadow();
            if (shadow == null) {
                shadow = Shadow.Companion.getNone();
            }
            Shadow shadow2 = shadow;
            DrawStyle drawStyle = this.style.getDrawStyle();
            if (drawStyle == null) {
                drawStyle = Fill.INSTANCE;
            }
            DrawStyle drawStyle2 = drawStyle;
            Brush brush = this.style.getBrush();
            if (brush != null) {
                multiParagraph.m4600painthn5TExg(canvas, brush, (64 & 4) != 0 ? Float.NaN : this.style.getAlpha(), (64 & 8) != 0 ? null : shadow2, (64 & 16) != 0 ? null : textDecoration2, (64 & 32) != 0 ? null : drawStyle2, (64 & 64) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : 0);
            } else {
                ColorProducer colorProducer = this.overrideColor;
                long jMo1291invoke0d7_KjU = colorProducer != null ? colorProducer.mo1291invoke0d7_KjU() : Color.Companion.m3068getUnspecified0d7_KjU();
                Color.Companion companion = Color.Companion;
                if (jMo1291invoke0d7_KjU == companion.m3068getUnspecified0d7_KjU()) {
                    jMo1291invoke0d7_KjU = this.style.m4726getColor0d7_KjU() != companion.m3068getUnspecified0d7_KjU() ? this.style.m4726getColor0d7_KjU() : companion.m3058getBlack0d7_KjU();
                }
                multiParagraph.m4598paintLG529CI(canvas, (32 & 2) != 0 ? Color.Companion.m3068getUnspecified0d7_KjU() : jMo1291invoke0d7_KjU, (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z) {
                canvas.restore();
            }
            List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
            if (list == null || list.isEmpty()) {
                return;
            }
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            if (z) {
                canvas.restore();
            }
            throw th;
        }
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "contentDrawScope");
        draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return AbstractC3876sO.a(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return AbstractC3876sO.b(this);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "intrinsicMeasureScope");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "intrinsicMeasureScope");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        MultiParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean zM857layoutWithConstraintsK40F9xA = layoutCache.m857layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (zM857layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            InterfaceC3750qp interfaceC3750qp = this.onTextLayout;
            if (interfaceC3750qp != null) {
                interfaceC3750qp.invoke(textLayoutResult);
            }
            SelectionController selectionController = this.selectionController;
            if (selectionController != null) {
                selectionController.updateTextLayout(textLayoutResult);
            }
            this.baselineCache = AbstractC4243wx.j(HV.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(AbstractC1210aB.c(textLayoutResult.getFirstBaseline()))), HV.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(AbstractC1210aB.c(textLayoutResult.getLastBaseline()))));
        }
        InterfaceC3750qp interfaceC3750qp2 = this.onPlaceholderLayout;
        if (interfaceC3750qp2 != null) {
            interfaceC3750qp2.invoke(textLayoutResult.getPlaceholderRects());
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(IntSize.m5320getWidthimpl(textLayoutResult.m4678getSizeYbymL2g()), IntSize.m5319getHeightimpl(textLayoutResult.m4678getSizeYbymL2g())));
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(textLayoutResult.m4678getSizeYbymL2g());
        int iM5319getHeightimpl = IntSize.m5319getHeightimpl(textLayoutResult.m4678getSizeYbymL2g());
        Map<AlignmentLine, Integer> map = this.baselineCache;
        AbstractC4492zt.e(map);
        return measureScope.layout(iM5320getWidthimpl, iM5319getHeightimpl, map, new TextAnnotatedStringNode$measure$1(placeableMo4159measureBRTryo0));
    }

    /* JADX INFO: renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m875measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "measureScope");
        AbstractC4492zt.h(measurable, "measurable");
        return mo248measure3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "intrinsicMeasureScope");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "intrinsicMeasureScope");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        AbstractC3173jk.a(this);
    }

    public final boolean updateCallbacks(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController) {
        boolean z;
        if (AbstractC4492zt.d(this.onTextLayout, interfaceC3750qp)) {
            z = false;
        } else {
            this.onTextLayout = interfaceC3750qp;
            z = true;
        }
        if (!AbstractC4492zt.d(this.onPlaceholderLayout, interfaceC3750qp2)) {
            this.onPlaceholderLayout = interfaceC3750qp2;
            z = true;
        }
        if (AbstractC4492zt.d(this.selectionController, selectionController)) {
            return z;
        }
        this.selectionController = selectionController;
        return true;
    }

    public final boolean updateDraw(ColorProducer colorProducer, TextStyle textStyle) {
        AbstractC4492zt.h(textStyle, "style");
        boolean zD = AbstractC4492zt.d(colorProducer, this.overrideColor);
        this.overrideColor = colorProducer;
        return (zD && textStyle.hasSameDrawAffectingAttributes(this.style)) ? false : true;
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m876updateLayoutRelatedArgsMPT68mk(TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3) {
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        boolean z2 = !this.style.hasSameLayoutAffectingAttributes(textStyle);
        this.style = textStyle;
        if (!AbstractC4492zt.d(this.placeholders, list)) {
            this.placeholders = list;
            z2 = true;
        }
        if (this.minLines != i) {
            this.minLines = i;
            z2 = true;
        }
        if (this.maxLines != i2) {
            this.maxLines = i2;
            z2 = true;
        }
        if (this.softWrap != z) {
            this.softWrap = z;
            z2 = true;
        }
        if (!AbstractC4492zt.d(this.fontFamilyResolver, resolver)) {
            this.fontFamilyResolver = resolver;
            z2 = true;
        }
        if (TextOverflow.m5106equalsimpl0(this.overflow, i3)) {
            return z2;
        }
        this.overflow = i3;
        return true;
    }

    public final boolean updateText(AnnotatedString annotatedString) {
        AbstractC4492zt.h(annotatedString, "text");
        if (AbstractC4492zt.d(this.text, annotatedString)) {
            return false;
        }
        this.text = annotatedString;
        return true;
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, int i4, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : interfaceC3750qp, (i4 & 16) != 0 ? TextOverflow.Companion.m5113getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : interfaceC3750qp2, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, null);
    }

    private TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer) {
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = interfaceC3750qp;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.onPlaceholderLayout = interfaceC3750qp2;
        this.selectionController = selectionController;
        this.overrideColor = colorProducer;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache layoutCache = getLayoutCache();
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }
}
