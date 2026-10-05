package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$capitalize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final String invoke(String str, int i, int i2) {
            AbstractC4492zt.h(str, "str");
            if (i == 0) {
                String strSubstring = str.substring(i, i2);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.capitalize(strSubstring, this.$localeList);
            }
            String strSubstring2 = str.substring(i, i2);
            AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$decapitalize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16631 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16631(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final String invoke(String str, int i, int i2) {
            AbstractC4492zt.h(str, "str");
            if (i == 0) {
                String strSubstring = str.substring(i, i2);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.decapitalize(strSubstring, this.$localeList);
            }
            String strSubstring2 = str.substring(i, i2);
            AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$toLowerCase$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16641 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16641(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final String invoke(String str, int i, int i2) {
            AbstractC4492zt.h(str, "str");
            String strSubstring = str.substring(i, i2);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return StringKt.toLowerCase(strSubstring, this.$localeList);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$toUpperCase$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16651 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16651(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final String invoke(String str, int i, int i2) {
            AbstractC4492zt.h(str, "str");
            String strSubstring = str.substring(i, i2);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return StringKt.toUpperCase(strSubstring, this.$localeList);
        }
    }

    public static final AnnotatedString AnnotatedString(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(spanStyle, "spanStyle");
        return new AnnotatedString(str, AbstractC1805bc.e(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? AbstractC1886cc.m() : AbstractC1805bc.e(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    public static final AnnotatedString buildAnnotatedString(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "builder");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        interfaceC3750qp.invoke(builder);
        return builder.toAnnotatedString();
    }

    public static final AnnotatedString capitalize(AnnotatedString annotatedString, LocaleList localeList) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnonymousClass1(localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i > i3 || i4 > i2) {
            return false;
        }
        if (i2 == i4) {
            if ((i3 == i4) != (i == i2)) {
                return false;
            }
        }
        return true;
    }

    public static final AnnotatedString decapitalize(AnnotatedString annotatedString, LocaleList localeList) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C16631(localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + ')').toString());
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends T> range = list.get(i3);
            AnnotatedString.Range<? extends T> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), Math.max(i, range3.getStart()) - i, Math.min(i2, range3.getEnd()) - i, range3.getTag()));
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends Object>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release;
        if (i == i2 || (annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotations$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(annotations$ui_text_release.size());
        int size = annotations$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<? extends Object> range = annotations$ui_text_release.get(i3);
            AnnotatedString.Range<? extends Object> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), AbstractC3871sJ.l(range3.getStart(), i, i2) - i, AbstractC3871sJ.l(range3.getEnd(), i, i2) - i, range3.getTag()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release;
        if (i == i2 || (paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return paragraphStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
        int size = paragraphStylesOrNull$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i3);
            AnnotatedString.Range<ParagraphStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), AbstractC3871sJ.l(range3.getStart(), i, i2) - i, AbstractC3871sJ.l(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<SpanStyle>> getLocalSpanStyles(AnnotatedString annotatedString, int i, int i2) {
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release;
        if (i == i2 || (spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release()) == null) {
            return null;
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return spanStylesOrNull$ui_text_release;
        }
        ArrayList arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
        int size = spanStylesOrNull$ui_text_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i3);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i4);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), AbstractC3871sJ.l(range3.getStart(), i, i2) - i, AbstractC3871sJ.l(range3.getEnd(), i, i2) - i));
        }
        return arrayList2;
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return Math.max(i, i3) < Math.min(i2, i4) || contains(i, i2, i3, i4) || contains(i3, i4, i, i2);
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString annotatedString, ParagraphStyle paragraphStyle, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(paragraphStyle, "defaultParagraphStyle");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        List<AnnotatedString.Range<ParagraphStyle>> listNormalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(listNormalizedParagraphStyles.size());
        int size = listNormalizedParagraphStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<ParagraphStyle> range = listNormalizedParagraphStyles.get(i);
            arrayList.add(interfaceC0526Fp.mo13invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(paragraphStyle, "defaultParagraphStyle");
        int length = annotatedString.getText().length();
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release == null) {
            paragraphStylesOrNull$ui_text_release = AbstractC1886cc.m();
        }
        ArrayList arrayList = new ArrayList();
        int size = paragraphStylesOrNull$ui_text_release.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text_release.get(i);
            ParagraphStyle paragraphStyleComponent1 = range.component1();
            int iComponent2 = range.component2();
            int iComponent3 = range.component3();
            if (iComponent2 != i2) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, iComponent2));
            }
            arrayList.add(new AnnotatedString.Range(paragraphStyle.merge(paragraphStyleComponent1), iComponent2, iComponent3));
            i++;
            i2 = iComponent3;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String strSubstring;
        if (i != i2) {
            strSubstring = annotatedString.getText().substring(i, i2);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = "";
        }
        return new AnnotatedString(strSubstring, getLocalSpanStyles(annotatedString, i, i2), null, null, 12, null);
    }

    public static final AnnotatedString toLowerCase(AnnotatedString annotatedString, LocaleList localeList) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C16641(localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString annotatedString, LocaleList localeList) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C16651(localeList));
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, String str, String str2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(str, "tag");
        AbstractC4492zt.h(str2, "annotation");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iPushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return (R) interfaceC3750qp.invoke(builder);
        } finally {
            AbstractC0703Ks.b(1);
            builder.pop(iPushStringAnnotation);
            AbstractC0703Ks.a(1);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, SpanStyle spanStyle, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(spanStyle, "style");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iPushStyle = builder.pushStyle(spanStyle);
        try {
            return (R) interfaceC3750qp.invoke(builder);
        } finally {
            AbstractC0703Ks.b(1);
            builder.pop(iPushStyle);
            AbstractC0703Ks.a(1);
        }
    }

    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, TtsAnnotation ttsAnnotation, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(ttsAnnotation, "ttsAnnotation");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iPushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return (R) interfaceC3750qp.invoke(builder);
        } finally {
            AbstractC0703Ks.b(1);
            builder.pop(iPushTtsAnnotation);
            AbstractC0703Ks.a(1);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, ParagraphStyle paragraphStyle, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(paragraphStyle, "style");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iPushStyle = builder.pushStyle(paragraphStyle);
        try {
            return (R) interfaceC3750qp.invoke(builder);
        } finally {
            AbstractC0703Ks.b(1);
            builder.pop(iPushStyle);
            AbstractC0703Ks.a(1);
        }
    }

    public static final AnnotatedString AnnotatedString(String str, ParagraphStyle paragraphStyle) {
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(paragraphStyle, "paragraphStyle");
        return new AnnotatedString(str, AbstractC1886cc.m(), AbstractC1805bc.e(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, UrlAnnotation urlAnnotation, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(urlAnnotation, "urlAnnotation");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iPushUrlAnnotation = builder.pushUrlAnnotation(urlAnnotation);
        try {
            return (R) interfaceC3750qp.invoke(builder);
        } finally {
            AbstractC0703Ks.b(1);
            builder.pop(iPushUrlAnnotation);
            AbstractC0703Ks.a(1);
        }
    }
}
