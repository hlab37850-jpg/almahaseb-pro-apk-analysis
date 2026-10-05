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
import androidx.compose.ui.text.Paragraph;
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
import defpackage.AbstractC2347hG;
import defpackage.AbstractC3173jk;
import defpackage.AbstractC3876sO;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private ParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private InterfaceC3750qp semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(List<TextLayoutResult> list) {
            AbstractC4492zt.h(list, "textLayoutResult");
            TextLayoutResult textLayoutResultSlowCreateTextLayoutResultOrNull = TextStringSimpleNode.this.getLayoutCache().slowCreateTextLayoutResultOrNull();
            if (textLayoutResultSlowCreateTextLayoutResultOrNull != null) {
                list.add(textLayoutResultSlowCreateTextLayoutResultOrNull);
            }
            return Boolean.FALSE;
        }
    }

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer, AbstractC0419Di abstractC0419Di) {
        this(str, textStyle, resolver, i, z, i2, i3, colorProducer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        AbstractC4492zt.e(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "<this>");
        InterfaceC3750qp anonymousClass1 = this.semanticsTextLayoutResult;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AnonymousClass1();
            this.semanticsTextLayoutResult = anonymousClass1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(this.text, null, null, 6, null));
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, anonymousClass1, 1, null);
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3) {
        if (z2) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (z2 || z3) {
            getLayoutCache().m864updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
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
        Paragraph paragraph$foundation_release = getLayoutCache().getParagraph$foundation_release();
        if (paragraph$foundation_release == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        boolean didOverflow$foundation_release = getLayoutCache().getDidOverflow$foundation_release();
        if (didOverflow$foundation_release) {
            Rect rectM2838Recttz77jQw = RectKt.m2838Recttz77jQw(Offset.Companion.m2814getZeroF1C5BW0(), SizeKt.Size(IntSize.m5320getWidthimpl(getLayoutCache().m861getLayoutSizeYbymL2g$foundation_release()), IntSize.m5319getHeightimpl(getLayoutCache().m861getLayoutSizeYbymL2g$foundation_release())));
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
                AbstractC2347hG.d(paragraph$foundation_release, canvas, brush, this.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                ColorProducer colorProducer = this.overrideColor;
                long jMo1291invoke0d7_KjU = colorProducer != null ? colorProducer.mo1291invoke0d7_KjU() : Color.Companion.m3068getUnspecified0d7_KjU();
                Color.Companion companion = Color.Companion;
                if (jMo1291invoke0d7_KjU == companion.m3068getUnspecified0d7_KjU()) {
                    jMo1291invoke0d7_KjU = this.style.m4726getColor0d7_KjU() != companion.m3068getUnspecified0d7_KjU() ? this.style.m4726getColor0d7_KjU() : companion.m3058getBlack0d7_KjU();
                }
                AbstractC2347hG.b(paragraph$foundation_release, canvas, jMo1291invoke0d7_KjU, shadow2, textDecoration2, drawStyle2, 0, 32, null);
            }
        } finally {
            if (didOverflow$foundation_release) {
                canvas.restore();
            }
        }
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

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        ParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean zM862layoutWithConstraintsK40F9xA = layoutCache.m862layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
        layoutCache.getObserveFontChanges$foundation_release();
        Paragraph paragraph$foundation_release = layoutCache.getParagraph$foundation_release();
        AbstractC4492zt.e(paragraph$foundation_release);
        long jM861getLayoutSizeYbymL2g$foundation_release = layoutCache.m861getLayoutSizeYbymL2g$foundation_release();
        if (zM862layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map<AlignmentLine, Integer> linkedHashMap = this.baselineCache;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>(2);
            }
            linkedHashMap.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(AbstractC1210aB.c(paragraph$foundation_release.getFirstBaseline())));
            linkedHashMap.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(AbstractC1210aB.c(paragraph$foundation_release.getLastBaseline())));
            this.baselineCache = linkedHashMap;
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(IntSize.m5320getWidthimpl(jM861getLayoutSizeYbymL2g$foundation_release), IntSize.m5319getHeightimpl(jM861getLayoutSizeYbymL2g$foundation_release)));
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(jM861getLayoutSizeYbymL2g$foundation_release);
        int iM5319getHeightimpl = IntSize.m5319getHeightimpl(jM861getLayoutSizeYbymL2g$foundation_release);
        Map<AlignmentLine, Integer> map = this.baselineCache;
        AbstractC4492zt.e(map);
        return measureScope.layout(iM5320getWidthimpl, iM5319getHeightimpl, map, new TextStringSimpleNode$measure$1(placeableMo4159measureBRTryo0));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        AbstractC3173jk.a(this);
    }

    public final boolean updateDraw(ColorProducer colorProducer, TextStyle textStyle) {
        AbstractC4492zt.h(textStyle, "style");
        boolean zD = AbstractC4492zt.d(colorProducer, this.overrideColor);
        this.overrideColor = colorProducer;
        return (zD && textStyle.hasSameDrawAffectingAttributes(this.style)) ? false : true;
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-HuAbxIM, reason: not valid java name */
    public final boolean m877updateLayoutRelatedArgsHuAbxIM(TextStyle textStyle, int i, int i2, boolean z, FontFamily.Resolver resolver, int i3) {
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        boolean z2 = !this.style.hasSameLayoutAffectingAttributes(textStyle);
        this.style = textStyle;
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

    public final boolean updateText(String str) {
        AbstractC4492zt.h(str, "text");
        if (AbstractC4492zt.d(this.text, str)) {
            return false;
        }
        this.text = str;
        return true;
    }

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer, int i4, AbstractC0419Di abstractC0419Di) {
        this(str, textStyle, resolver, (i4 & 8) != 0 ? TextOverflow.Companion.m5113getClipgIe3tQ8() : i, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? Integer.MAX_VALUE : i2, (i4 & 64) != 0 ? 1 : i3, (i4 & 128) != 0 ? null : colorProducer, null);
    }

    private TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.overrideColor = colorProducer;
    }

    private final ParagraphLayoutCache getLayoutCache(Density density) {
        ParagraphLayoutCache layoutCache = getLayoutCache();
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }
}
