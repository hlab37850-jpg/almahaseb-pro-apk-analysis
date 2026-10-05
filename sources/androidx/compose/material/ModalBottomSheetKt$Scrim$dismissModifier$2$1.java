package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetKt$Scrim$dismissModifier$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ String $closeSheet;
    final /* synthetic */ InterfaceC3588op $onDismiss;

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $onDismiss;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$onDismiss = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            this.$onDismiss.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$Scrim$dismissModifier$2$1(String str, InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$closeSheet = str;
        this.$onDismiss = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.$closeSheet);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new AnonymousClass1(this.$onDismiss), 1, null);
    }
}
