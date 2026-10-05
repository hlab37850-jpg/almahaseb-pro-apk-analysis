package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {
    private final MutableState inputMode$delegate;
    private final InterfaceC3750qp onRequestInputModeChange;

    public /* synthetic */ InputModeManagerImpl(int i, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(i, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.input.InputModeManager
    /* JADX INFO: renamed from: getInputMode-aOaMEAU */
    public int mo3623getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m3620unboximpl();
    }

    @Override // androidx.compose.ui.input.InputModeManager
    @ExperimentalComposeUiApi
    /* JADX INFO: renamed from: requestInputMode-iuPiT84 */
    public boolean mo3624requestInputModeiuPiT84(int i) {
        return ((Boolean) this.onRequestInputModeChange.invoke(InputMode.m3614boximpl(i))).booleanValue();
    }

    /* JADX INFO: renamed from: setInputMode-iuPiT84, reason: not valid java name */
    public void m3625setInputModeiuPiT84(int i) {
        this.inputMode$delegate.setValue(InputMode.m3614boximpl(i));
    }

    private InputModeManagerImpl(int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onRequestInputModeChange");
        this.onRequestInputModeChange = interfaceC3750qp;
        this.inputMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m3614boximpl(i), null, 2, null);
    }
}
