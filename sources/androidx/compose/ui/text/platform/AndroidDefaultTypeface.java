package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidDefaultTypeface implements AndroidTypeface {
    private final FontFamily fontFamily = FontFamily.Companion.getDefault();

    @Override // androidx.compose.ui.text.font.Typeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface mo4925getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        if (Build.VERSION.SDK_INT < 28) {
            Typeface typefaceDefaultFromStyle = Typeface.defaultFromStyle(AndroidFontUtils_androidKt.m4756getAndroidTypefaceStyleFO1MlWM(fontWeight, i));
            AbstractC4492zt.g(typefaceDefaultFromStyle, "{\n            Typeface.d…)\n            )\n        }");
            return typefaceDefaultFromStyle;
        }
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface typeface = Typeface.DEFAULT;
        AbstractC4492zt.g(typeface, "DEFAULT");
        return typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), FontStyle.m4801equalsimpl0(i, FontStyle.Companion.m4805getItalic_LCdwA()));
    }
}
