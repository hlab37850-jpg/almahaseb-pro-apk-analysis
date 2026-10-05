package androidx.compose.ui.input.pointer;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2$onSetIcon$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ PointerIconService $pointerIconService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2$onSetIcon$1(PointerIconService pointerIconService) {
        super(1);
        this.$pointerIconService = pointerIconService;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerIcon) obj);
        return FW.a;
    }

    public final void invoke(PointerIcon pointerIcon) {
        this.$pointerIconService.setIcon(pointerIcon);
    }
}
