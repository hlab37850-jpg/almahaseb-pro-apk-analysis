package androidx.compose.ui.text;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.HV;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import defpackage.PO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class JvmAnnotatedString_jvmKt {

    /* JADX INFO: renamed from: androidx.compose.ui.text.JvmAnnotatedString_jvmKt$transform$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Map<Integer, Integer> $offsetMap;
        final /* synthetic */ OJ $resultStr;
        final /* synthetic */ AnnotatedString $this_transform;
        final /* synthetic */ InterfaceC0552Gp $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OJ oj, InterfaceC0552Gp interfaceC0552Gp, AnnotatedString annotatedString, Map<Integer, Integer> map) {
            super(1);
            this.$resultStr = oj;
            this.$transform = interfaceC0552Gp;
            this.$this_transform = annotatedString;
            this.$offsetMap = map;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(List<Integer> list) {
            AbstractC4492zt.h(list, "<name for destructuring parameter 0>");
            int iIntValue = list.get(0).intValue();
            int iIntValue2 = list.get(1).intValue();
            this.$resultStr.a = ((String) this.$resultStr.a) + ((String) this.$transform.invoke(this.$this_transform.getText(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)));
            return this.$offsetMap.put(Integer.valueOf(iIntValue2), Integer.valueOf(((String) this.$resultStr.a).length()));
        }
    }

    private static final void collectRangeTransitions(List<? extends AnnotatedString.Range<?>> list, SortedSet<Integer> sortedSet) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<?> range = list.get(i);
                sortedSet.add(Integer.valueOf(range.getStart()));
                sortedSet.add(Integer.valueOf(range.getEnd()));
            }
        }
    }

    public static final AnnotatedString transform(AnnotatedString annotatedString, InterfaceC0552Gp interfaceC0552Gp) {
        ArrayList arrayList;
        ArrayList arrayList2;
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, "transform");
        TreeSet treeSetD = PO.d(0, Integer.valueOf(annotatedString.getText().length()));
        collectRangeTransitions(annotatedString.getSpanStylesOrNull$ui_text_release(), treeSetD);
        collectRangeTransitions(annotatedString.getParagraphStylesOrNull$ui_text_release(), treeSetD);
        collectRangeTransitions(annotatedString.getAnnotations$ui_text_release(), treeSetD);
        OJ oj = new OJ();
        oj.a = "";
        Map mapK = AbstractC4243wx.k(HV.a(0, 0));
        AbstractC3240kc.J0(treeSetD, 2, 0, false, new AnonymousClass1(oj, interfaceC0552Gp, annotatedString, mapK), 6, null);
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        ArrayList arrayList3 = null;
        if (spanStylesOrNull$ui_text_release != null) {
            arrayList = new ArrayList(spanStylesOrNull$ui_text_release.size());
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i);
                SpanStyle item = range.getItem();
                Object obj = mapK.get(Integer.valueOf(range.getStart()));
                AbstractC4492zt.e(obj);
                int iIntValue = ((Number) obj).intValue();
                Object obj2 = mapK.get(Integer.valueOf(range.getEnd()));
                AbstractC4492zt.e(obj2);
                arrayList.add(new AnnotatedString.Range(item, iIntValue, ((Number) obj2).intValue()));
            }
        } else {
            arrayList = null;
        }
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = annotatedString.getParagraphStylesOrNull$ui_text_release();
        if (paragraphStylesOrNull$ui_text_release != null) {
            arrayList2 = new ArrayList(paragraphStylesOrNull$ui_text_release.size());
            int size2 = paragraphStylesOrNull$ui_text_release.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range<ParagraphStyle> range2 = paragraphStylesOrNull$ui_text_release.get(i2);
                ParagraphStyle item2 = range2.getItem();
                Object obj3 = mapK.get(Integer.valueOf(range2.getStart()));
                AbstractC4492zt.e(obj3);
                int iIntValue2 = ((Number) obj3).intValue();
                Object obj4 = mapK.get(Integer.valueOf(range2.getEnd()));
                AbstractC4492zt.e(obj4);
                arrayList2.add(new AnnotatedString.Range(item2, iIntValue2, ((Number) obj4).intValue()));
            }
        } else {
            arrayList2 = null;
        }
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
        if (annotations$ui_text_release != null) {
            arrayList3 = new ArrayList(annotations$ui_text_release.size());
            int size3 = annotations$ui_text_release.size();
            for (int i3 = 0; i3 < size3; i3++) {
                AnnotatedString.Range<? extends Object> range3 = annotations$ui_text_release.get(i3);
                Object item3 = range3.getItem();
                Object obj5 = mapK.get(Integer.valueOf(range3.getStart()));
                AbstractC4492zt.e(obj5);
                int iIntValue3 = ((Number) obj5).intValue();
                Object obj6 = mapK.get(Integer.valueOf(range3.getEnd()));
                AbstractC4492zt.e(obj6);
                arrayList3.add(new AnnotatedString.Range(item3, iIntValue3, ((Number) obj6).intValue()));
            }
        }
        return new AnnotatedString((String) oj.a, arrayList, arrayList2, arrayList3);
    }
}
