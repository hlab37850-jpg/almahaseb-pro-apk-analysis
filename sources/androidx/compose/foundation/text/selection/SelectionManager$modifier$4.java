package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.key.KeyEvent;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager$modifier$4 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ SelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionManager$modifier$4(SelectionManager selectionManager) {
        super(1);
        this.this$0 = selectionManager;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m934invokeZmokQxo(((KeyEvent) obj).m3928unboximpl());
    }

    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m934invokeZmokQxo(android.view.KeyEvent keyEvent) {
        boolean z;
        AbstractC4492zt.h(keyEvent, "it");
        if (SelectionManager_androidKt.m939isCopyKeyEventZmokQxo(keyEvent)) {
            this.this$0.copy$foundation_release();
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
