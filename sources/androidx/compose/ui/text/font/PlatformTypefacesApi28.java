package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@VisibleForTesting
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4830createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m4801equalsimpl0(i, companion.m4806getNormal_LCdwA()) && AbstractC4492zt.d(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
            AbstractC4492zt.g(typeface, "DEFAULT");
            return typeface;
        }
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(str == null ? android.graphics.Typeface.DEFAULT : android.graphics.Typeface.create(str, 0), fontWeight.getWeight(), FontStyle.m4801equalsimpl0(i, companion.m4805getItalic_LCdwA()));
        AbstractC4492zt.g(typefaceCreate, "create(\n            fami…ontStyle.Italic\n        )");
        return typefaceCreate;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ android.graphics.Typeface m4831createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m4830createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4832loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM4830createAndroidTypefaceApi28RetOiIg = m4830createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        boolean zM4801equalsimpl0 = FontStyle.m4801equalsimpl0(i, FontStyle.Companion.m4805getItalic_LCdwA());
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
        AbstractC4492zt.g(typeface, "DEFAULT");
        if (AbstractC4492zt.d(typefaceM4830createAndroidTypefaceApi28RetOiIg, typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), zM4801equalsimpl0)) || AbstractC4492zt.d(typefaceM4830createAndroidTypefaceApi28RetOiIg, m4830createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM4830createAndroidTypefaceApi28RetOiIg;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo4824createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        return m4830createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo4825createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        AbstractC4492zt.h(genericFontFamily, "name");
        AbstractC4492zt.h(fontWeight, "fontWeight");
        return m4830createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo4826optionalOnDeviceFontFamilyByName78DK7lM(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, Context context) {
        android.graphics.Typeface typefaceMo4825createNamedRetOiIg;
        AbstractC4492zt.h(str, "familyName");
        AbstractC4492zt.h(fontWeight, "weight");
        AbstractC4492zt.h(settings, "variationSettings");
        AbstractC4492zt.h(context, "context");
        FontFamily.Companion companion = FontFamily.Companion;
        if (AbstractC4492zt.d(str, companion.getSansSerif().getName())) {
            typefaceMo4825createNamedRetOiIg = mo4825createNamedRetOiIg(companion.getSansSerif(), fontWeight, i);
        } else if (AbstractC4492zt.d(str, companion.getSerif().getName())) {
            typefaceMo4825createNamedRetOiIg = mo4825createNamedRetOiIg(companion.getSerif(), fontWeight, i);
        } else if (AbstractC4492zt.d(str, companion.getMonospace().getName())) {
            typefaceMo4825createNamedRetOiIg = mo4825createNamedRetOiIg(companion.getMonospace(), fontWeight, i);
        } else {
            typefaceMo4825createNamedRetOiIg = AbstractC4492zt.d(str, companion.getCursive().getName()) ? mo4825createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m4832loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefacesKt.setFontVariationSettings(typefaceMo4825createNamedRetOiIg, settings, context);
    }
}
