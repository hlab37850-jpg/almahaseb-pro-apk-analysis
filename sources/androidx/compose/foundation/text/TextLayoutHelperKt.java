package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutHelperKt {
    /* JADX INFO: renamed from: canReuse-7_7YC6M, reason: not valid java name */
    public static final boolean m840canReuse7_7YC6M(TextLayoutResult textLayoutResult, AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j) {
        AbstractC4492zt.h(textLayoutResult, "$this$canReuse");
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(list, "placeholders");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
        if (textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || !AbstractC4492zt.d(layoutInput.getText(), annotatedString) || !layoutInput.getStyle().hasSameLayoutAffectingAttributes(textStyle) || !AbstractC4492zt.d(layoutInput.getPlaceholders(), list) || layoutInput.getMaxLines() != i || layoutInput.getSoftWrap() != z || !TextOverflow.m5106equalsimpl0(layoutInput.m4674getOverflowgIe3tQ8(), i2) || !AbstractC4492zt.d(layoutInput.getDensity(), density) || layoutInput.getLayoutDirection() != layoutDirection || !AbstractC4492zt.d(layoutInput.getFontFamilyResolver(), resolver) || Constraints.m5130getMinWidthimpl(j) != Constraints.m5130getMinWidthimpl(layoutInput.m4673getConstraintsmsEJaDk())) {
            return false;
        }
        if (z || TextOverflow.m5106equalsimpl0(i2, TextOverflow.Companion.m5114getEllipsisgIe3tQ8())) {
            return Constraints.m5128getMaxWidthimpl(j) == Constraints.m5128getMaxWidthimpl(layoutInput.m4673getConstraintsmsEJaDk()) && Constraints.m5127getMaxHeightimpl(j) == Constraints.m5127getMaxHeightimpl(layoutInput.m4673getConstraintsmsEJaDk());
        }
        return true;
    }
}
