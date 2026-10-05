package androidx.compose.foundation.text;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(TextFieldState textFieldState) {
        super(0);
        this.$state = textFieldState;
    }

    @Override // defpackage.InterfaceC3588op
    public final TextLayoutResultProxy invoke() {
        return this.$state.getLayoutResult();
    }
}
