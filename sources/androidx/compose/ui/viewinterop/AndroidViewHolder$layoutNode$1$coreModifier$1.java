package androidx.compose.ui.viewinterop;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewHolder$layoutNode$1$coreModifier$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidViewHolder$layoutNode$1$coreModifier$1 INSTANCE = new AndroidViewHolder$layoutNode$1$coreModifier$1();

    public AndroidViewHolder$layoutNode$1$coreModifier$1() {
        super(1);
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }
}
