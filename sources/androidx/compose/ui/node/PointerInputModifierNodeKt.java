package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputModifierNodeKt {
    public static final LayoutCoordinates getLayoutCoordinates(PointerInputModifierNode pointerInputModifierNode) {
        AbstractC4492zt.h(pointerInputModifierNode, "<this>");
        return DelegatableNodeKt.m4263requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m4378constructorimpl(16));
    }

    public static final boolean isAttached(PointerInputModifierNode pointerInputModifierNode) {
        AbstractC4492zt.h(pointerInputModifierNode, "<this>");
        return pointerInputModifierNode.getNode().isAttached();
    }
}
