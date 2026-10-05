package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class PlainTooltipState implements TooltipState {
    public static final int $stable = 0;
    private final MutableState isVisible$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    @Override // androidx.compose.material3.TooltipState
    public Object dismiss(InterfaceC0793Of interfaceC0793Of) {
        Object objDismissCurrentTooltip = TooltipSync.INSTANCE.dismissCurrentTooltip(this, interfaceC0793Of);
        return objDismissCurrentTooltip == AbstractC0378Bt.d() ? objDismissCurrentTooltip : FW.a;
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    public void setVisible$material3_release(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.material3.TooltipState
    public Object show(InterfaceC0793Of interfaceC0793Of) {
        Object objShow = TooltipSync.INSTANCE.show(this, false, interfaceC0793Of);
        return objShow == AbstractC0378Bt.d() ? objShow : FW.a;
    }
}
