package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class CacheTextLayoutInput {
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput) {
        AbstractC4492zt.h(textLayoutInput, "textLayoutInput");
        this.textLayoutInput = textLayoutInput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) obj;
        return AbstractC4492zt.d(textLayoutInput.getText(), cacheTextLayoutInput.textLayoutInput.getText()) && textLayoutInput.getStyle().hasSameLayoutAffectingAttributes(cacheTextLayoutInput.textLayoutInput.getStyle()) && AbstractC4492zt.d(textLayoutInput.getPlaceholders(), cacheTextLayoutInput.textLayoutInput.getPlaceholders()) && textLayoutInput.getMaxLines() == cacheTextLayoutInput.textLayoutInput.getMaxLines() && textLayoutInput.getSoftWrap() == cacheTextLayoutInput.textLayoutInput.getSoftWrap() && TextOverflow.m5106equalsimpl0(textLayoutInput.m4674getOverflowgIe3tQ8(), cacheTextLayoutInput.textLayoutInput.m4674getOverflowgIe3tQ8()) && AbstractC4492zt.d(textLayoutInput.getDensity(), cacheTextLayoutInput.textLayoutInput.getDensity()) && textLayoutInput.getLayoutDirection() == cacheTextLayoutInput.textLayoutInput.getLayoutDirection() && textLayoutInput.getFontFamilyResolver() == cacheTextLayoutInput.textLayoutInput.getFontFamilyResolver() && Constraints.m5128getMaxWidthimpl(textLayoutInput.m4673getConstraintsmsEJaDk()) == Constraints.m5128getMaxWidthimpl(cacheTextLayoutInput.textLayoutInput.m4673getConstraintsmsEJaDk()) && Constraints.m5127getMaxHeightimpl(textLayoutInput.m4673getConstraintsmsEJaDk()) == Constraints.m5127getMaxHeightimpl(cacheTextLayoutInput.textLayoutInput.m4673getConstraintsmsEJaDk());
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput = this.textLayoutInput;
        return (((((((((((((((((((textLayoutInput.getText().hashCode() * 31) + textLayoutInput.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + textLayoutInput.getPlaceholders().hashCode()) * 31) + textLayoutInput.getMaxLines()) * 31) + AbstractC0564Hb.a(textLayoutInput.getSoftWrap())) * 31) + TextOverflow.m5107hashCodeimpl(textLayoutInput.m4674getOverflowgIe3tQ8())) * 31) + textLayoutInput.getDensity().hashCode()) * 31) + textLayoutInput.getLayoutDirection().hashCode()) * 31) + textLayoutInput.getFontFamilyResolver().hashCode()) * 31) + Constraints.m5128getMaxWidthimpl(textLayoutInput.m4673getConstraintsmsEJaDk())) * 31) + Constraints.m5127getMaxHeightimpl(textLayoutInput.m4673getConstraintsmsEJaDk());
    }
}
