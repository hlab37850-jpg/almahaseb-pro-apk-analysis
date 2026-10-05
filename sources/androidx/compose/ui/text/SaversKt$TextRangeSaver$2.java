package androidx.compose.ui.text;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextRangeSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$TextRangeSaver$2 INSTANCE = new SaversKt$TextRangeSaver$2();

    public SaversKt$TextRangeSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
    public final TextRange invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        AbstractC4492zt.e(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        AbstractC4492zt.e(num2);
        return TextRange.m4693boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }
}
