package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsModifierNodeKt {
    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration semanticsConfiguration) {
        AbstractC4492zt.h(semanticsConfiguration, "<this>");
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        AbstractC4492zt.h(semanticsModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui_release();
    }

    public static final Rect touchBoundsInRoot(Modifier.Node node, boolean z) {
        AbstractC4492zt.h(node, "<this>");
        if (node.getNode().isAttached()) {
            return !z ? LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m4263requireCoordinator64DMado(node, NodeKind.m4378constructorimpl(8))) : DelegatableNodeKt.m4263requireCoordinator64DMado(node, NodeKind.m4378constructorimpl(8)).touchBoundsInRoot();
        }
        return Rect.Companion.getZero();
    }
}
