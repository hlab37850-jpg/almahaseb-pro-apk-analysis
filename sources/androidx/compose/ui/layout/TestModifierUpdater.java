package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class TestModifierUpdater {
    public static final int $stable = 8;
    private final LayoutNode node;

    public TestModifierUpdater(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        this.node = layoutNode;
    }

    public final void updateModifier(Modifier modifier) {
        AbstractC4492zt.h(modifier, "modifier");
        this.node.setModifier(modifier);
    }
}
