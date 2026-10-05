package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ClickableTextKt$ClickableText$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ InterfaceC3750qp $onTextLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$2$1(MutableState<TextLayoutResult> mutableState, InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$layoutResult = mutableState;
        this.$onTextLayout = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return FW.a;
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        AbstractC4492zt.h(textLayoutResult, "it");
        this.$layoutResult.setValue(textLayoutResult);
        this.$onTextLayout.invoke(textLayoutResult);
    }
}
