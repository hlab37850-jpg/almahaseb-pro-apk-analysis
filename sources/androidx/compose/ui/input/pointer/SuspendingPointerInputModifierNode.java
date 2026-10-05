package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.PointerInputModifierNode;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public interface SuspendingPointerInputModifierNode extends PointerInputModifierNode {
    InterfaceC0526Fp getPointerInputHandler();

    void resetPointerInputHandler();

    void setPointerInputHandler(InterfaceC0526Fp interfaceC0526Fp);
}
