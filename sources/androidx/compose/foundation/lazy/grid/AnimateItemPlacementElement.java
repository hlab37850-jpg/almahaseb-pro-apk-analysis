package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class AnimateItemPlacementElement extends ModifierNodeElement<AnimateItemPlacementNode> {
    private final FiniteAnimationSpec<IntOffset> animationSpec;

    public AnimateItemPlacementElement(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimateItemPlacementElement) {
            return !AbstractC4492zt.d(this.animationSpec, ((AnimateItemPlacementElement) obj).animationSpec);
        }
        return false;
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.animationSpec.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("animateItemPlacement");
        inspectorInfo.setValue(this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public AnimateItemPlacementNode create() {
        return new AnimateItemPlacementNode(this.animationSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(AnimateItemPlacementNode animateItemPlacementNode) {
        AbstractC4492zt.h(animateItemPlacementNode, "node");
        animateItemPlacementNode.getDelegatingNode().setPlacementAnimationSpec(this.animationSpec);
    }
}
