package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $size$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(float f) {
        super(1);
        this.$size$inlined = f;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$null");
        inspectorInfo.setName("requiredSize");
        inspectorInfo.setValue(Dp.m5158boximpl(this.$size$inlined));
    }
}
