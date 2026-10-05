package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class FontFeatureSpan extends MetricAffectingSpan {
    private final String fontFeatureSettings;

    public FontFeatureSpan(String str) {
        AbstractC4492zt.h(str, "fontFeatureSettings");
        this.fontFeatureSettings = str;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC4492zt.h(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        AbstractC4492zt.h(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }
}
