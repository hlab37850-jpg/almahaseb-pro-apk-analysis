package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class TextFieldSize {
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection layoutDirection;
    private long minSize;
    private TextStyle resolvedStyle;
    private Object typeface;

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        AbstractC4492zt.h(textStyle, "resolvedStyle");
        AbstractC4492zt.h(obj, "typeface");
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = textStyle;
        this.typeface = obj;
        this.minSize = m833computeMinSizeYbymL2g();
    }

    /* JADX INFO: renamed from: computeMinSize-YbymL2g, reason: not valid java name */
    private final long m833computeMinSizeYbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(this.resolvedStyle, this.density, this.fontFamilyResolver, null, 0, 24, null);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    /* JADX INFO: renamed from: getMinSize-YbymL2g, reason: not valid java name */
    public final long m834getMinSizeYbymL2g() {
        return this.minSize;
    }

    public final TextStyle getResolvedStyle() {
        return this.resolvedStyle;
    }

    public final Object getTypeface() {
        return this.typeface;
    }

    public final void setDensity(Density density) {
        AbstractC4492zt.h(density, "<set-?>");
        this.density = density;
    }

    public final void setFontFamilyResolver(FontFamily.Resolver resolver) {
        AbstractC4492zt.h(resolver, "<set-?>");
        this.fontFamilyResolver = resolver;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void setResolvedStyle(TextStyle textStyle) {
        AbstractC4492zt.h(textStyle, "<set-?>");
        this.resolvedStyle = textStyle;
    }

    public final void setTypeface(Object obj) {
        AbstractC4492zt.h(obj, "<set-?>");
        this.typeface = obj;
    }

    public final void update(LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        AbstractC4492zt.h(textStyle, "resolvedStyle");
        AbstractC4492zt.h(obj, "typeface");
        if (layoutDirection == this.layoutDirection && AbstractC4492zt.d(density, this.density) && AbstractC4492zt.d(resolver, this.fontFamilyResolver) && AbstractC4492zt.d(textStyle, this.resolvedStyle) && AbstractC4492zt.d(obj, this.typeface)) {
            return;
        }
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.resolvedStyle = textStyle;
        this.typeface = obj;
        this.minSize = m833computeMinSizeYbymL2g();
    }
}
