package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextAnnotatedStringElement extends ModifierNodeElement<TextAnnotatedStringNode> {
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final InterfaceC3750qp onPlaceholderLayout;
    private final InterfaceC3750qp onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, interfaceC3750qp, i, z, i2, i3, list, interfaceC3750qp2, selectionController, colorProducer);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return AbstractC4492zt.d(this.color, textAnnotatedStringElement.color) && AbstractC4492zt.d(this.text, textAnnotatedStringElement.text) && AbstractC4492zt.d(this.style, textAnnotatedStringElement.style) && AbstractC4492zt.d(this.placeholders, textAnnotatedStringElement.placeholders) && AbstractC4492zt.d(this.fontFamilyResolver, textAnnotatedStringElement.fontFamilyResolver) && AbstractC4492zt.d(this.onTextLayout, textAnnotatedStringElement.onTextLayout) && TextOverflow.m5106equalsimpl0(this.overflow, textAnnotatedStringElement.overflow) && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines && AbstractC4492zt.d(this.onPlaceholderLayout, textAnnotatedStringElement.onPlaceholderLayout) && AbstractC4492zt.d(this.selectionController, textAnnotatedStringElement.selectionController);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31;
        InterfaceC3750qp interfaceC3750qp = this.onTextLayout;
        int iHashCode2 = (((((((((iHashCode + (interfaceC3750qp != null ? interfaceC3750qp.hashCode() : 0)) * 31) + TextOverflow.m5107hashCodeimpl(this.overflow)) * 31) + AbstractC0564Hb.a(this.softWrap)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp2 = this.onPlaceholderLayout;
        int iHashCode4 = (iHashCode3 + (interfaceC3750qp2 != null ? interfaceC3750qp2.hashCode() : 0)) * 31;
        SelectionController selectionController = this.selectionController;
        int iHashCode5 = (iHashCode4 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.color;
        return iHashCode5 + (colorProducer != null ? colorProducer.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
    }

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, int i4, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : interfaceC3750qp, (i4 & 16) != 0 ? TextOverflow.Companion.m5113getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : interfaceC3750qp2, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public TextAnnotatedStringNode create() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(TextAnnotatedStringNode textAnnotatedStringNode) {
        AbstractC4492zt.h(textAnnotatedStringNode, "node");
        textAnnotatedStringNode.doInvalidations(textAnnotatedStringNode.updateDraw(this.color, this.style), textAnnotatedStringNode.updateText(this.text), textAnnotatedStringNode.m876updateLayoutRelatedArgsMPT68mk(this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), textAnnotatedStringNode.updateCallbacks(this.onTextLayout, this.onPlaceholderLayout, this.selectionController));
    }

    private TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer) {
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
        this.color = colorProducer;
    }
}
