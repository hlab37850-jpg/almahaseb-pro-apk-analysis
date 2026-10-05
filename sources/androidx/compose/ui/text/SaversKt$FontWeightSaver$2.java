package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontWeight;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$FontWeightSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$FontWeightSaver$2 INSTANCE = new SaversKt$FontWeightSaver$2();

    public SaversKt$FontWeightSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final FontWeight invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        return new FontWeight(((Integer) obj).intValue());
    }
}
