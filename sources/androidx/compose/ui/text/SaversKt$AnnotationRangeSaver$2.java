package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$AnnotationRangeSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$AnnotationRangeSaver$2 INSTANCE = new SaversKt$AnnotationRangeSaver$2();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SaversKt$AnnotationRangeSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final AnnotatedString.Range<? extends Object> invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        ParagraphStyle paragraphStyleRestore = null;
        AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
        AbstractC4492zt.e(annotationType);
        Object obj3 = list.get(2);
        Integer num = obj3 != null ? (Integer) obj3 : null;
        AbstractC4492zt.e(num);
        int iIntValue = num.intValue();
        Object obj4 = list.get(3);
        Integer num2 = obj4 != null ? (Integer) obj4 : null;
        AbstractC4492zt.e(num2);
        int iIntValue2 = num2.intValue();
        Object obj5 = list.get(4);
        String str = obj5 != null ? (String) obj5 : null;
        AbstractC4492zt.e(str);
        int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i == 1) {
            Object obj6 = list.get(1);
            Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
            if (!AbstractC4492zt.d(obj6, Boolean.FALSE) && obj6 != null) {
                paragraphStyleRestore = paragraphStyleSaver.restore(obj6);
            }
            AbstractC4492zt.e(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        if (i == 2) {
            Object obj7 = list.get(1);
            Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
            if (!AbstractC4492zt.d(obj7, Boolean.FALSE) && obj7 != null) {
                paragraphStyleRestore = spanStyleSaver.restore(obj7);
            }
            AbstractC4492zt.e(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        if (i == 3) {
            Object obj8 = list.get(1);
            Saver saver = SaversKt.VerbatimTtsAnnotationSaver;
            if (!AbstractC4492zt.d(obj8, Boolean.FALSE) && obj8 != null) {
                paragraphStyleRestore = (VerbatimTtsAnnotation) saver.restore(obj8);
            }
            AbstractC4492zt.e(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        if (i != 4) {
            if (i != 5) {
                throw new AD();
            }
            Object obj9 = list.get(1);
            paragraphStyleRestore = obj9 != null ? (String) obj9 : null;
            AbstractC4492zt.e(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        Object obj10 = list.get(1);
        Saver saver2 = SaversKt.UrlAnnotationSaver;
        if (!AbstractC4492zt.d(obj10, Boolean.FALSE) && obj10 != null) {
            paragraphStyleRestore = (UrlAnnotation) saver2.restore(obj10);
        }
        AbstractC4492zt.e(paragraphStyleRestore);
        return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
    }
}
