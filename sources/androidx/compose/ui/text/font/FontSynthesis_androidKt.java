package androidx.compose.ui.text.font;

import android.os.Build;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis_androidKt {
    /* JADX WARN: Code duplicated, block: B:14:0x0042  */
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m4820synthesizeTypefaceFxwP2eA(int i, Object obj, Font font, FontWeight fontWeight, int i2) {
        boolean z;
        android.graphics.Typeface typefaceCreate;
        AbstractC4492zt.h(obj, "typeface");
        AbstractC4492zt.h(font, "font");
        AbstractC4492zt.h(fontWeight, "requestedWeight");
        if (!(obj instanceof android.graphics.Typeface)) {
            return obj;
        }
        boolean z2 = false;
        if (!FontSynthesis.m4813isWeightOnimpl$ui_text_release(i) || AbstractC4492zt.d(font.getWeight(), fontWeight)) {
            z = false;
        } else {
            FontWeight.Companion companion = FontWeight.Companion;
            if (fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) < 0 || font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) >= 0) {
                z = false;
            } else {
                z = true;
            }
        }
        boolean z3 = FontSynthesis.m4812isStyleOnimpl$ui_text_release(i) && !FontStyle.m4801equalsimpl0(i2, font.mo4757getStyle_LCdwA());
        if (!z3 && !z) {
            return obj;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (z3 && FontStyle.m4801equalsimpl0(i2, FontStyle.Companion.m4805getItalic_LCdwA())) {
                z2 = true;
            }
            typefaceCreate = android.graphics.Typeface.create((android.graphics.Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2));
        } else {
            typefaceCreate = TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) obj, z ? fontWeight.getWeight() : font.getWeight().getWeight(), z3 ? FontStyle.m4801equalsimpl0(i2, FontStyle.Companion.m4805getItalic_LCdwA()) : FontStyle.m4801equalsimpl0(font.mo4757getStyle_LCdwA(), FontStyle.Companion.m4805getItalic_LCdwA()));
        }
        AbstractC4492zt.g(typefaceCreate, "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }");
        return typefaceCreate;
    }
}
