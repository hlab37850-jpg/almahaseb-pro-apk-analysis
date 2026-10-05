package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TextFieldState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(TextFieldState textFieldState) {
        super(1);
        this.$state = textFieldState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return FW.a;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "it");
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult == null) {
            return;
        }
        layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
    }
}
