package androidx.compose.ui.platform;

import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$rotaryInputModifier$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidComposeView$rotaryInputModifier$1 INSTANCE = new AndroidComposeView$rotaryInputModifier$1();

    public AndroidComposeView$rotaryInputModifier$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
        AbstractC4492zt.h(rotaryScrollEvent, "it");
        return Boolean.FALSE;
    }
}
