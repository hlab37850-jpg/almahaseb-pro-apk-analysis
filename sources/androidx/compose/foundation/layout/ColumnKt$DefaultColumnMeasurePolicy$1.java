package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0604Ip;

/* JADX INFO: loaded from: classes.dex */
public final class ColumnKt$DefaultColumnMeasurePolicy$1 extends AbstractC2233fv implements InterfaceC0604Ip {
    public static final ColumnKt$DefaultColumnMeasurePolicy$1 INSTANCE = new ColumnKt$DefaultColumnMeasurePolicy$1();

    public ColumnKt$DefaultColumnMeasurePolicy$1() {
        super(5);
    }

    @Override // defpackage.InterfaceC0604Ip
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
        return FW.a;
    }

    public final void invoke(int i, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(layoutDirection, "<anonymous parameter 2>");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(iArr2, "outPosition");
        Arrangement.INSTANCE.getTop().arrange(density, i, iArr, iArr2);
    }
}
