package androidx.compose.ui.focus;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.OJ;

/* JADX INFO: loaded from: classes.dex */
public final class FocusTargetNode$invalidateFocus$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ OJ $focusProperties;
    final /* synthetic */ FocusTargetNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusTargetNode$invalidateFocus$1(OJ oj, FocusTargetNode focusTargetNode) {
        super(0);
        this.$focusProperties = oj;
        this.this$0 = focusTargetNode;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2744invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2744invoke() {
        this.$focusProperties.a = this.this$0.fetchFocusProperties$ui_release();
    }
}
