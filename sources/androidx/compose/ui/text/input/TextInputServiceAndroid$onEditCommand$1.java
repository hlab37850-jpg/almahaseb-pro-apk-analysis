package androidx.compose.ui.text.input;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid$onEditCommand$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TextInputServiceAndroid$onEditCommand$1 INSTANCE = new TextInputServiceAndroid$onEditCommand$1();

    public TextInputServiceAndroid$onEditCommand$1() {
        super(1);
    }

    public final void invoke(List<? extends EditCommand> list) {
        AbstractC4492zt.h(list, "it");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends EditCommand>) obj);
        return FW.a;
    }
}
