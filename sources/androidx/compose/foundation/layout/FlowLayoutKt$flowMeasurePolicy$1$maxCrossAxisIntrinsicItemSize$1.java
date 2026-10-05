package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1 INSTANCE = new FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1();

    public FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i, int i2) {
        AbstractC4492zt.h(intrinsicMeasurable, "$this$null");
        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
    }
}
