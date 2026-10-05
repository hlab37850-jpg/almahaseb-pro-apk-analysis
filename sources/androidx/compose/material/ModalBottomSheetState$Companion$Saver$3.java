package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetState$Companion$Saver$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ModalBottomSheetState$Companion$Saver$3 INSTANCE = new ModalBottomSheetState$Companion$Saver$3();

    public ModalBottomSheetState$Companion$Saver$3() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ModalBottomSheetValue mo13invoke(SaverScope saverScope, ModalBottomSheetState modalBottomSheetState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(modalBottomSheetState, "it");
        return modalBottomSheetState.getCurrentValue();
    }
}
