package androidx.compose.ui.text.input;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class InputMethodManagerImpl$imm$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InputMethodManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputMethodManagerImpl$imm$2(InputMethodManagerImpl inputMethodManagerImpl) {
        super(0);
        this.this$0 = inputMethodManagerImpl;
    }

    @Override // defpackage.InterfaceC3588op
    public final android.view.inputmethod.InputMethodManager invoke() {
        Object systemService = this.this$0.view.getContext().getSystemService("input_method");
        AbstractC4492zt.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (android.view.inputmethod.InputMethodManager) systemService;
    }
}
