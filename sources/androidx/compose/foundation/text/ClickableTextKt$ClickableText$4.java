package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ClickableTextKt$ClickableText$4 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ClickableTextKt$ClickableText$4 INSTANCE = new ClickableTextKt$ClickableText$4();

    public ClickableTextKt$ClickableText$4() {
        super(1);
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        AbstractC4492zt.h(textLayoutResult, "it");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return FW.a;
    }
}
