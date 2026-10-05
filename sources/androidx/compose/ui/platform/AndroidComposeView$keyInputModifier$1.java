package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$keyInputModifier$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$keyInputModifier$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m4458invokeZmokQxo(((KeyEvent) obj).m3928unboximpl());
    }

    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m4458invokeZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "it");
        FocusDirection focusDirectionMo4432getFocusDirectionP8AzH3I = this.this$0.mo4432getFocusDirectionP8AzH3I(keyEvent);
        return (focusDirectionMo4432getFocusDirectionP8AzH3I == null || !KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3936getKeyDownCS__XNY())) ? Boolean.FALSE : Boolean.valueOf(this.this$0.getFocusOwner().mo2733moveFocus3ESFkO8(focusDirectionMo4432getFocusDirectionP8AzH3I.m2717unboximpl()));
    }
}
