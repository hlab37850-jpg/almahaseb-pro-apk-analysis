package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $block$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$block$inlined = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return FW.a;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "$this$null");
        inspectorInfo.setName("onConsumedWindowInsetsChanged");
        inspectorInfo.getProperties().set(CSS.Value.BLOCK, this.$block$inlined);
    }
}
