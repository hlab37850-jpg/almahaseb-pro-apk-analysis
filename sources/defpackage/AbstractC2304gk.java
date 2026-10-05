package defpackage;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;

/* JADX INFO: renamed from: gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2304gk {
    public static /* synthetic */ Object a(DraggableState draggableState, MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drag");
        }
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return draggableState.drag(mutatePriority, interfaceC0526Fp, interfaceC0793Of);
    }
}
