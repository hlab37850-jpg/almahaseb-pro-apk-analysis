package androidx.compose.material3;

import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$clockDial$$inlined$debugInspectorInfo$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TimePickerState $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$clockDial$$inlined$debugInspectorInfo$1(TimePickerState timePickerState) {
        super(1);
        this.$state$inlined = timePickerState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$null");
        inspectorInfo.setName("clockDial");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
    }
}
