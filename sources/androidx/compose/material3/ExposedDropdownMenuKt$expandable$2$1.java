package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt$expandable$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ String $menuDescription;
    final /* synthetic */ InterfaceC3588op $onExpandedChange;

    /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $onExpandedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$onExpandedChange = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            this.$onExpandedChange.invoke();
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$expandable$2$1(boolean z, String str, String str2, String str3, InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$expanded = z;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$menuDescription = str3;
        this.$onExpandedChange = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.$expanded ? this.$expandedDescription : this.$collapsedDescription);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.$menuDescription);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new AnonymousClass1(this.$onExpandedChange), 1, null);
    }
}
