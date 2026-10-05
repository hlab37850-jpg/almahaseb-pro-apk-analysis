package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$AnnotatedStringSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    public SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final AnnotatedString invoke(Object obj) {
        List list;
        List list2;
        AbstractC4492zt.h(obj, "it");
        List list3 = (List) obj;
        Object obj2 = list3.get(1);
        Saver saver = SaversKt.AnnotationRangeListSaver;
        Boolean bool = Boolean.FALSE;
        List list4 = null;
        List list5 = (AbstractC4492zt.d(obj2, bool) || obj2 == null) ? null : (List) saver.restore(obj2);
        Object obj3 = list3.get(2);
        List list6 = (AbstractC4492zt.d(obj3, bool) || obj3 == null) ? null : (List) SaversKt.AnnotationRangeListSaver.restore(obj3);
        Object obj4 = list3.get(0);
        String str = obj4 != null ? (String) obj4 : null;
        AbstractC4492zt.e(str);
        if (list5 != null) {
            List list7 = list5;
            if (list7.isEmpty()) {
                list7 = null;
            }
            list = list7;
        } else {
            list = null;
        }
        if (list6 != null) {
            List list8 = list6;
            if (list8.isEmpty()) {
                list8 = null;
            }
            list2 = list8;
        } else {
            list2 = null;
        }
        Object obj5 = list3.get(3);
        Saver saver2 = SaversKt.AnnotationRangeListSaver;
        if (!AbstractC4492zt.d(obj5, bool) && obj5 != null) {
            list4 = (List) saver2.restore(obj5);
        }
        return new AnnotatedString(str, list, list2, list4);
    }
}
