package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceholderExtensions_androidKt {
    /* JADX INFO: renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m4942getSpanUnitR2X_6o(long j) {
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA()) ? 1 : 2;
    }

    /* JADX INFO: renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m4943getSpanUnitR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m4944getSpanVerticalAligndo9XGg(int i) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4636getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4642getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4637getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4638getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4641getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4639getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m4632equalsimpl0(i, companion.m4640getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign");
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m4945getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        Object[] spans = spannable.getSpans(i, i2, EmojiSpan.class);
        AbstractC4492zt.g(spans, "getSpans(start, end, EmojiSpan::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m5341getValueimpl(placeholder.m4628getWidthXSAIIZE()), m4942getSpanUnitR2X_6o(placeholder.m4628getWidthXSAIIZE()), TextUnit.m5341getValueimpl(placeholder.m4626getHeightXSAIIZE()), m4942getSpanUnitR2X_6o(placeholder.m4626getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m4944getSpanVerticalAligndo9XGg(placeholder.m4627getPlaceholderVerticalAlignJ6kI3mc())), i, i2);
    }

    public static final void setPlaceholders(Spannable spannable, List<AnnotatedString.Range<Placeholder>> list, Density density) {
        AbstractC4492zt.h(spannable, "<this>");
        AbstractC4492zt.h(list, "placeholders");
        AbstractC4492zt.h(density, "density");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }
}
