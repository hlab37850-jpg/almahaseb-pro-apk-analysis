package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomDrawerState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final BottomDrawerState$Companion$Saver$1 INSTANCE = new BottomDrawerState$Companion$Saver$1();

    public BottomDrawerState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final BottomDrawerValue mo13invoke(SaverScope saverScope, BottomDrawerState bottomDrawerState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(bottomDrawerState, "it");
        return bottomDrawerState.getAnchoredDraggableState$material_release().getCurrentValue();
    }
}
