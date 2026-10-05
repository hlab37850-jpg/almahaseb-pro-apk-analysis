package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PaddingKt$absolutePadding$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $bottom;
    final /* synthetic */ float $left;
    final /* synthetic */ float $right;
    final /* synthetic */ float $top;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingKt$absolutePadding$1(float f, float f2, float f3, float f4) {
        super(1);
        this.$left = f;
        this.$top = f2;
        this.$right = f3;
        this.$bottom = f4;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m5158boximpl(this.$left));
        inspectorInfo.getProperties().set("top", Dp.m5158boximpl(this.$top));
        inspectorInfo.getProperties().set("right", Dp.m5158boximpl(this.$right));
        inspectorInfo.getProperties().set("bottom", Dp.m5158boximpl(this.$bottom));
    }
}
