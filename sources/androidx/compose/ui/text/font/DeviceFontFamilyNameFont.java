package androidx.compose.ui.text.font;

import android.content.Context;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class DeviceFontFamilyNameFont extends AndroidFont {
    private final String familyName;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, AbstractC0419Di abstractC0419Di) {
        this(str, fontWeight, i, settings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m4770equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && AbstractC4492zt.d(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m4801equalsimpl0(mo4757getStyle_LCdwA(), deviceFontFamilyNameFont.mo4757getStyle_LCdwA()) && AbstractC4492zt.d(getVariationSettings(), deviceFontFamilyNameFont.getVariationSettings());
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo4757getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m4771hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m4802hashCodeimpl(mo4757getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    public final android.graphics.Typeface loadCached(Context context) {
        AbstractC4492zt.h(context, "context");
        return PlatformTypefacesKt.PlatformTypefaces().mo4826optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), mo4757getStyle_LCdwA(), getVariationSettings(), context);
    }

    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m4772toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4803toStringimpl(mo4757getStyle_LCdwA())) + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m4794getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, settings, null);
        AbstractC4492zt.h(str, "familyName");
        AbstractC4492zt.h(fontWeight, "weight");
        AbstractC4492zt.h(settings, "variationSettings");
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }
}
