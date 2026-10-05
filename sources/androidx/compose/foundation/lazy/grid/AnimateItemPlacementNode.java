package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class AnimateItemPlacementNode extends DelegatingNode implements ParentDataModifierNode {
    private final LazyLayoutAnimateItemModifierNode delegatingNode;

    public AnimateItemPlacementNode(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        this.delegatingNode = (LazyLayoutAnimateItemModifierNode) delegate(new LazyLayoutAnimateItemModifierNode(finiteAnimationSpec));
    }

    public final LazyLayoutAnimateItemModifierNode getDelegatingNode() {
        return this.delegatingNode;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object modifyParentData(Density density, Object obj) {
        AbstractC4492zt.h(density, "<this>");
        return this.delegatingNode;
    }
}
