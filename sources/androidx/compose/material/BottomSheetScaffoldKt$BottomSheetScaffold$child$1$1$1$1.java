package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4162vx;
import defpackage.AbstractC4243wx;
import defpackage.HV;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ float $peekHeightPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(int i, float f) {
        super(1);
        this.$layoutHeight = i;
        this.$peekHeightPx = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1013invokeozmzZPI(((IntSize) obj).m5324unboximpl());
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final Map<BottomSheetValue, Float> m1013invokeozmzZPI(long j) {
        float fM5319getHeightimpl = IntSize.m5319getHeightimpl(j);
        float f = this.$layoutHeight;
        float f2 = this.$peekHeightPx;
        float f3 = f - f2;
        return (fM5319getHeightimpl == 0.0f || fM5319getHeightimpl == f2) ? AbstractC4162vx.e(HV.a(BottomSheetValue.Collapsed, Float.valueOf(f3))) : AbstractC4243wx.j(HV.a(BottomSheetValue.Collapsed, Float.valueOf(f3)), HV.a(BottomSheetValue.Expanded, Float.valueOf(this.$layoutHeight - fM5319getHeightimpl)));
    }
}
