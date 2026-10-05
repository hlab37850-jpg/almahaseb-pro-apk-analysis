package androidx.compose.ui.input.nestedscroll;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollDispatcher$calculateNestedScrollScope$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ NestedScrollDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollDispatcher$calculateNestedScrollScope$1(NestedScrollDispatcher nestedScrollDispatcher) {
        super(0);
        this.this$0 = nestedScrollDispatcher;
    }

    @Override // defpackage.InterfaceC3588op
    public final InterfaceC2052dg invoke() {
        return this.this$0.getScope$ui_release();
    }
}
