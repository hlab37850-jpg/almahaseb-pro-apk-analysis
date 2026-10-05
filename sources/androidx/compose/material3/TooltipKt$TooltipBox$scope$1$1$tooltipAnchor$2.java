package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ String $longPressLabel;
    final /* synthetic */ InterfaceC3588op $onLongPress;

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $onLongPress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$onLongPress = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            this.$onLongPress.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$2(String str, InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$longPressLabel = str;
        this.$onLongPress = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.$longPressLabel, new AnonymousClass1(this.$onLongPress));
    }
}
