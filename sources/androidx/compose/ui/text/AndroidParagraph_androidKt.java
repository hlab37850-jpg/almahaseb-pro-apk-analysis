package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m5338equalsimpl0(textStyle.m4731getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5338equalsimpl0(textStyle.m4731getLetterSpacingXSAIIZE(), TextUnit.Companion.m5352getUnspecifiedXSAIIZE()) || textStyle.m4734getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign textAlignM4734getTextAlignbuA522U = textStyle.m4734getTextAlignbuA522U();
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlignM4734getTextAlignbuA522U == null ? false : TextAlign.m5062equalsimpl0(textAlignM4734getTextAlignbuA522U.m5065unboximpl(), companion.m5071getStarte0LSkKk())) {
            return false;
        }
        TextAlign textAlignM4734getTextAlignbuA522U2 = textStyle.m4734getTextAlignbuA522U();
        return !(textAlignM4734getTextAlignbuA522U2 == null ? false : TextAlign.m5062equalsimpl0(textAlignM4734getTextAlignbuA522U2.m5065unboximpl(), companion.m5068getJustifye0LSkKk()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m4578toLayoutAlignAMY3VfE(TextAlign textAlign) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlign == null ? false : TextAlign.m5062equalsimpl0(textAlign.m5065unboximpl(), companion.m5069getLefte0LSkKk())) {
            return 3;
        }
        if (textAlign == null ? false : TextAlign.m5062equalsimpl0(textAlign.m5065unboximpl(), companion.m5070getRighte0LSkKk())) {
            return 4;
        }
        if (textAlign == null ? false : TextAlign.m5062equalsimpl0(textAlign.m5065unboximpl(), companion.m5066getCentere0LSkKk())) {
            return 2;
        }
        if (textAlign == null ? false : TextAlign.m5062equalsimpl0(textAlign.m5065unboximpl(), companion.m5071getStarte0LSkKk())) {
            return 0;
        }
        return textAlign == null ? false : TextAlign.m5062equalsimpl0(textAlign.m5065unboximpl(), companion.m5067getEnde0LSkKk()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m4579toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        if (strategy == null ? false : LineBreak.Strategy.m5006equalsimpl0(strategy.m5009unboximpl(), companion.m5012getSimplefcGXIks())) {
            return 0;
        }
        if (strategy == null ? false : LineBreak.Strategy.m5006equalsimpl0(strategy.m5009unboximpl(), companion.m5011getHighQualityfcGXIks())) {
            return 1;
        }
        return strategy == null ? false : LineBreak.Strategy.m5006equalsimpl0(strategy.m5009unboximpl(), companion.m5010getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency-0_XeFpE, reason: not valid java name */
    public static final int m4580toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        Hyphens.Companion companion = Hyphens.Companion;
        if (hyphens == null ? false : Hyphens.m4981equalsimpl0(hyphens.m4984unboximpl(), companion.m4985getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        int iM4986getNonevmbZdU8 = companion.m4986getNonevmbZdU8();
        if (hyphens == null) {
            return 0;
        }
        Hyphens.m4981equalsimpl0(hyphens.m4984unboximpl(), iM4986getNonevmbZdU8);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-4a2g8L8, reason: not valid java name */
    public static final int m4581toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        if (strictness == null ? false : LineBreak.Strictness.m5016equalsimpl0(strictness.m5019unboximpl(), companion.m5020getDefaultusljTpc())) {
            return 0;
        }
        if (strictness == null ? false : LineBreak.Strictness.m5016equalsimpl0(strictness.m5019unboximpl(), companion.m5021getLooseusljTpc())) {
            return 1;
        }
        if (strictness == null ? false : LineBreak.Strictness.m5016equalsimpl0(strictness.m5019unboximpl(), companion.m5022getNormalusljTpc())) {
            return 2;
        }
        return strictness == null ? false : LineBreak.Strictness.m5016equalsimpl0(strictness.m5019unboximpl(), companion.m5023getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m4582toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        if (wordBreak == null ? false : LineBreak.WordBreak.m5027equalsimpl0(wordBreak.m5030unboximpl(), companion.m5031getDefaultjp8hJ3c())) {
            return 0;
        }
        return wordBreak == null ? false : LineBreak.WordBreak.m5027equalsimpl0(wordBreak.m5030unboximpl(), companion.m5032getPhrasejp8hJ3c()) ? 1 : 0;
    }
}
