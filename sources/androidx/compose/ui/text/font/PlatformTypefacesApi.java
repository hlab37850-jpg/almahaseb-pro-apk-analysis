package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
final class PlatformTypefacesApi implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (FontStyle.m4801equalsimpl0(i, FontStyle.Companion.m4806getNormal_LCdwA()) && AbstractC4492zt.d(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
            AbstractC4492zt.g(typeface, "DEFAULT");
            return typeface;
        }
        int iM4756getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m4756getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
        if (str == null || str.length() == 0) {
            android.graphics.Typeface typefaceDefaultFromStyle = android.graphics.Typeface.defaultFromStyle(iM4756getAndroidTypefaceStyleFO1MlWM);
            AbstractC4492zt.g(typefaceDefaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return typefaceDefaultFromStyle;
        }
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(str, iM4756getAndroidTypefaceStyleFO1MlWM);
        AbstractC4492zt.g(typefaceCreate, "{\n            Typeface.c…y, targetStyle)\n        }");
        return typefaceCreate;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ android.graphics.Typeface m4828createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi platformTypefacesApi, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4806getNormal_LCdwA();
        }
        return platformTypefacesApi.m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m4829loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM4827createAndroidTypefaceUsingTypefaceStyleRetOiIg = m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
        if (AbstractC4492zt.d(typefaceM4827createAndroidTypefaceUsingTypefaceStyleRetOiIg, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.m4756getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) || AbstractC4492zt.d(typefaceM4827createAndroidTypefaceUsingTypefaceStyleRetOiIg, m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM4827createAndroidTypefaceUsingTypefaceStyleRetOiIg;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo4824createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        return m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo4825createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        AbstractC4492zt.h(genericFontFamily, "name");
        AbstractC4492zt.h(fontWeight, "fontWeight");
        android.graphics.Typeface typefaceM4829loadNamedFromTypefaceCacheOrNullRetOiIg = m4829loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefacesKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i);
        return typefaceM4829loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m4827createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i) : typefaceM4829loadNamedFromTypefaceCacheOrNullRetOiIg;
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
            typefaceMo4825createNamedRetOiIg = AbstractC4492zt.d(str, companion.getCursive().getName()) ? mo4825createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m4829loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefacesKt.setFontVariationSettings(typefaceMo4825createNamedRetOiIg, settings, context);
    }
}
