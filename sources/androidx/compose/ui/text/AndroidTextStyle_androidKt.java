package androidx.compose.ui.text;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextStyle_androidKt {
    public static final boolean DefaultIncludeFontPadding = true;

    public static final PlatformTextStyle createPlatformTextStyle(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        return new PlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    public static final PlatformSpanStyle lerp(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        AbstractC4492zt.h(platformSpanStyle, HTML.Attribute.START);
        AbstractC4492zt.h(platformSpanStyle2, "stop");
        return platformSpanStyle;
    }

    public static final PlatformParagraphStyle lerp(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        AbstractC4492zt.h(platformParagraphStyle, HTML.Attribute.START);
        AbstractC4492zt.h(platformParagraphStyle2, "stop");
        return platformParagraphStyle.getIncludeFontPadding() == platformParagraphStyle2.getIncludeFontPadding() ? platformParagraphStyle : new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(EmojiSupportMatch.m4584boximpl(platformParagraphStyle.m4643getEmojiSupportMatch_3YsG6Y()), EmojiSupportMatch.m4584boximpl(platformParagraphStyle2.m4643getEmojiSupportMatch_3YsG6Y()), f)).m4590unboximpl(), ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(platformParagraphStyle.getIncludeFontPadding()), Boolean.valueOf(platformParagraphStyle2.getIncludeFontPadding()), f)).booleanValue(), (AbstractC0419Di) null);
    }
}
