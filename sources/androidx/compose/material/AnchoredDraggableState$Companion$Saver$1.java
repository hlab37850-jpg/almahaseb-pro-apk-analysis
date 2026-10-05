package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final AnchoredDraggableState$Companion$Saver$1 INSTANCE = new AnchoredDraggableState$Companion$Saver$1();

    public AnchoredDraggableState$Companion$Saver$1() {
        super(2);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final T mo13invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(anchoredDraggableState, "it");
        return anchoredDraggableState.getCurrentValue();
    }
}
