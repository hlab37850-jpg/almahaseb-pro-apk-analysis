package androidx.compose.ui.text.font;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceFontFamilyNameFontKt {
    /* JADX INFO: renamed from: Font-vxs03AY, reason: not valid java name */
    public static final Font m4774Fontvxs03AY(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        AbstractC4492zt.h(str, "familyName");
        AbstractC4492zt.h(fontWeight, "weight");
        AbstractC4492zt.h(settings, "variationSettings");
        return new DeviceFontFamilyNameFont(str, fontWeight, i, settings, null);
    }

    /* JADX INFO: renamed from: Font-vxs03AY$default, reason: not valid java name */
    public static /* synthetic */ Font m4775Fontvxs03AY$default(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4806getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        }
        return m4774Fontvxs03AY(str, fontWeight, i, settings);
    }
}
