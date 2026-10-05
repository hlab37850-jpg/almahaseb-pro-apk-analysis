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
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {
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

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, interfaceC3750qp, i, z, i2, i3, list, interfaceC3750qp2, selectionController, colorProducer);
    }

    private final AnnotatedString component1() {
        return this.text;
    }

    private final InterfaceC3750qp component10() {
        return this.onPlaceholderLayout;
    }

    private final SelectionController component11() {
        return this.selectionController;
    }

    private final ColorProducer component12() {
        return this.color;
    }

    private final TextStyle component2() {
        return this.style;
    }

    private final FontFamily.Resolver component3() {
        return this.fontFamilyResolver;
    }

    private final InterfaceC3750qp component4() {
        return this.onTextLayout;
    }

    /* JADX INFO: renamed from: component5-gIe3tQ8, reason: not valid java name */
    private final int m865component5gIe3tQ8() {
        return this.overflow;
    }

    private final boolean component6() {
        return this.softWrap;
    }

    private final int component7() {
        return this.maxLines;
    }

    private final int component8() {
        return this.minLines;
    }

    private final List<AnnotatedString.Range<Placeholder>> component9() {
        return this.placeholders;
    }

    /* JADX INFO: renamed from: copy-VhcvRP8, reason: not valid java name */
    public final SelectableTextAnnotatedStringElement m867copyVhcvRP8(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer) {
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        return new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, interfaceC3750qp, i, z, i2, i3, list, interfaceC3750qp2, selectionController, colorProducer, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) obj;
        return AbstractC4492zt.d(this.color, selectableTextAnnotatedStringElement.color) && AbstractC4492zt.d(this.text, selectableTextAnnotatedStringElement.text) && AbstractC4492zt.d(this.style, selectableTextAnnotatedStringElement.style) && AbstractC4492zt.d(this.placeholders, selectableTextAnnotatedStringElement.placeholders) && AbstractC4492zt.d(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver) && AbstractC4492zt.d(this.onTextLayout, selectableTextAnnotatedStringElement.onTextLayout) && TextOverflow.m5106equalsimpl0(this.overflow, selectableTextAnnotatedStringElement.overflow) && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && AbstractC4492zt.d(this.onPlaceholderLayout, selectableTextAnnotatedStringElement.onPlaceholderLayout) && AbstractC4492zt.d(this.selectionController, selectableTextAnnotatedStringElement.selectionController);
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

    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.text) + ", style=" + this.style + ", fontFamilyResolver=" + this.fontFamilyResolver + ", onTextLayout=" + this.onTextLayout + ", overflow=" + ((Object) TextOverflow.m5108toStringimpl(this.overflow)) + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", placeholders=" + this.placeholders + ", onPlaceholderLayout=" + this.onPlaceholderLayout + ", selectionController=" + this.selectionController + ", color=" + this.color + ')';
    }

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer, int i4, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? null : interfaceC3750qp, (i4 & 16) != 0 ? TextOverflow.Companion.m5113getClipgIe3tQ8() : i, (i4 & 32) != 0 ? true : z, (i4 & 64) != 0 ? Integer.MAX_VALUE : i2, (i4 & 128) != 0 ? 1 : i3, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : interfaceC3750qp2, (i4 & 1024) != 0 ? null : selectionController, (i4 & 2048) != 0 ? null : colorProducer, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SelectableTextAnnotatedStringNode create() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SelectableTextAnnotatedStringNode selectableTextAnnotatedStringNode) {
        AbstractC4492zt.h(selectableTextAnnotatedStringNode, "node");
        selectableTextAnnotatedStringNode.m868updateL09Iy8E(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color);
    }

    private SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, InterfaceC3750qp interfaceC3750qp, int i, boolean z, int i2, int i3, List<AnnotatedString.Range<Placeholder>> list, InterfaceC3750qp interfaceC3750qp2, SelectionController selectionController, ColorProducer colorProducer) {
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
