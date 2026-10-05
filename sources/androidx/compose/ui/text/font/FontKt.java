package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.ExperimentalTextApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class FontKt {
    @ExperimentalTextApi
    /* JADX INFO: renamed from: Font-F3nL8kk, reason: not valid java name */
    public static final Font m4779FontF3nL8kk(int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings) {
        AbstractC4492zt.h(fontWeight, "weight");
        AbstractC4492zt.h(settings, "variationSettings");
        return new ResourceFont(i, fontWeight, i2, settings, i3, null);
    }

    /* JADX INFO: renamed from: Font-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ Font m4780FontF3nL8kk$default(int i, FontWeight fontWeight, int i2, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.Companion.m4806getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.Companion.m4793getBlockingPKNRLFQ();
        }
        if ((i4 & 16) != 0) {
            settings = FontVariation.INSTANCE.m4821Settings6EWAqTQ(fontWeight, i2, new FontVariation.Setting[0]);
        }
        return m4779FontF3nL8kk(i, fontWeight, i2, i3, settings);
    }

    @Stable
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m4781FontRetOiIg(int i, FontWeight fontWeight, int i2) {
        AbstractC4492zt.h(fontWeight, "weight");
        return new ResourceFont(i, fontWeight, i2, null, FontLoadingStrategy.Companion.m4793getBlockingPKNRLFQ(), 8, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m4782FontRetOiIg$default(int i, FontWeight fontWeight, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i3 & 4) != 0) {
            i2 = FontStyle.Companion.m4806getNormal_LCdwA();
        }
        return m4781FontRetOiIg(i, fontWeight, i2);
    }

    @Stable
    /* JADX INFO: renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m4783FontYpTlLL0(int i, FontWeight fontWeight, int i2, int i3) {
        AbstractC4492zt.h(fontWeight, "weight");
        return new ResourceFont(i, fontWeight, i2, new FontVariation.Settings(new FontVariation.Setting[0]), i3, null);
    }

    /* JADX INFO: renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m4784FontYpTlLL0$default(int i, FontWeight fontWeight, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.Companion.m4806getNormal_LCdwA();
        }
        if ((i4 & 8) != 0) {
            i3 = FontLoadingStrategy.Companion.m4793getBlockingPKNRLFQ();
        }
        return m4783FontYpTlLL0(i, fontWeight, i2, i3);
    }

    @Stable
    public static final FontFamily toFontFamily(Font font) {
        AbstractC4492zt.h(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
