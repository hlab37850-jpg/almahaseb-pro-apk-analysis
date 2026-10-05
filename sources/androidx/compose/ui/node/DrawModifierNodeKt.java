package androidx.compose.ui.node;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        AbstractC4492zt.h(drawModifierNode, "<this>");
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m4263requireCoordinator64DMado(drawModifierNode, NodeKind.m4378constructorimpl(1)).invalidateLayer();
        }
    }
}
