package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$OffsetSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$OffsetSaver$2 INSTANCE = new SaversKt$OffsetSaver$2();

    public SaversKt$OffsetSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    /* JADX INFO: renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Offset invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        if (AbstractC4492zt.d(obj, Boolean.FALSE)) {
            return Offset.m2787boximpl(Offset.Companion.m2813getUnspecifiedF1C5BW0());
        }
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        AbstractC4492zt.e(f);
        float fFloatValue = f.floatValue();
        Object obj3 = list.get(1);
        Float f2 = obj3 != null ? (Float) obj3 : null;
        AbstractC4492zt.e(f2);
        return Offset.m2787boximpl(OffsetKt.Offset(fFloatValue, f2.floatValue()));
    }
}
