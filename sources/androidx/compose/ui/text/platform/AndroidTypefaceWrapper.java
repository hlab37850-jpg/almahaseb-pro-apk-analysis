package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTypefaceWrapper implements AndroidTypeface {
    private final FontFamily fontFamily;
    private final Typeface typeface;

    public AndroidTypefaceWrapper(Typeface typeface) {
        AbstractC4492zt.h(typeface, "typeface");
        this.typeface = typeface;
    }

    @Override // androidx.compose.ui.text.font.Typeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo4925getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        return this.typeface;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }
}
