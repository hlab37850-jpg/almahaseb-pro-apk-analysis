package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocale;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import defpackage.AbstractC4492zt;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, FontFamily.Resolver resolver) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(list, "spanStyles");
        AbstractC4492zt.h(list2, "placeholders");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        EmojiSupportMatch emojiSupportMatchM4584boximpl = (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m4584boximpl(paragraphStyle.m4643getEmojiSupportMatch_3YsG6Y());
        return !(emojiSupportMatchM4584boximpl == null ? false : EmojiSupportMatch.m4587equalsimpl0(emojiSupportMatchM4584boximpl.m4590unboximpl(), EmojiSupportMatch.Companion.m4592getNone_3YsG6Y()));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-9GRLPo0, reason: not valid java name */
    public static final int m4931resolveTextDirectionHeuristics9GRLPo0(TextDirection textDirection, LocaleList localeList) {
        Locale javaLocale;
        int iM5078unboximpl = textDirection != null ? textDirection.m5078unboximpl() : TextDirection.Companion.m5079getContents_7Xco();
        TextDirection.Companion companion = TextDirection.Companion;
        if (TextDirection.m5075equalsimpl0(iM5078unboximpl, companion.m5080getContentOrLtrs_7Xco())) {
            return 2;
        }
        if (!TextDirection.m5075equalsimpl0(iM5078unboximpl, companion.m5081getContentOrRtls_7Xco())) {
            if (TextDirection.m5075equalsimpl0(iM5078unboximpl, companion.m5082getLtrs_7Xco())) {
                return 0;
            }
            if (TextDirection.m5075equalsimpl0(iM5078unboximpl, companion.m5083getRtls_7Xco())) {
                return 1;
            }
            if (!TextDirection.m5075equalsimpl0(iM5078unboximpl, companion.m5079getContents_7Xco())) {
                throw new IllegalStateException("Invalid TextDirection.");
            }
            if (localeList != null) {
                PlatformLocale platformLocale$ui_text_release = localeList.get(0).getPlatformLocale$ui_text_release();
                AbstractC4492zt.f(platformLocale$ui_text_release, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
                javaLocale = ((AndroidLocale) platformLocale$ui_text_release).getJavaLocale();
                if (javaLocale == null) {
                    javaLocale = Locale.getDefault();
                }
            } else {
                javaLocale = Locale.getDefault();
            }
            int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(javaLocale);
            if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                return 2;
            }
        }
        return 3;
    }

    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-9GRLPo0$default, reason: not valid java name */
    public static /* synthetic */ int m4932resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            textDirection = null;
        }
        if ((i & 2) != 0) {
            localeList = null;
        }
        return m4931resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }
}
