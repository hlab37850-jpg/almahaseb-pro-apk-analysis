package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.ExperimentalTextApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformTypefacesKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        return Build.VERSION.SDK_INT >= 28 ? new PlatformTypefacesApi28() : new PlatformTypefacesApi();
    }

    @VisibleForTesting
    public static final String getWeightSuffixForFallbackFamilyName(String str, FontWeight fontWeight) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(fontWeight, "fontWeight");
        int weight = fontWeight.getWeight() / 100;
        if (weight >= 0 && weight < 2) {
            return str + "-thin";
        }
        if (2 <= weight && weight < 4) {
            return str + "-light";
        }
        if (weight == 4) {
            return str;
        }
        if (weight == 5) {
            return str + "-medium";
        }
        if ((6 <= weight && weight < 8) || 8 > weight || weight >= 11) {
            return str;
        }
        return str + "-black";
    }

    @ExperimentalTextApi
    public static final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface typeface, FontVariation.Settings settings, Context context) {
        AbstractC4492zt.h(settings, "variationSettings");
        AbstractC4492zt.h(context, "context");
        return Build.VERSION.SDK_INT >= 26 ? TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, settings, context) : typeface;
    }
}
