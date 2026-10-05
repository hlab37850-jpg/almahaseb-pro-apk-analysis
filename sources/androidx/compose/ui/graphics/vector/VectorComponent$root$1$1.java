package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComponent$root$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ VectorComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorComponent$root$1$1(VectorComponent vectorComponent) {
        super(0);
        this.this$0 = vectorComponent;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m3585invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3585invoke() {
        this.this$0.doInvalidate();
    }
}
