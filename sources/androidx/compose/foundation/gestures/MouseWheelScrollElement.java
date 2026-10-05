package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class MouseWheelScrollElement extends ModifierNodeElement<MouseWheelScrollNode> {
    private final ScrollConfig mouseWheelScrollConfig;
    private final State<ScrollingLogic> scrollingLogicState;

    public MouseWheelScrollElement(State<ScrollingLogic> state, ScrollConfig scrollConfig) {
        AbstractC4492zt.h(state, "scrollingLogicState");
        AbstractC4492zt.h(scrollConfig, "mouseWheelScrollConfig");
        this.scrollingLogicState = state;
        this.mouseWheelScrollConfig = scrollConfig;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MouseWheelScrollElement)) {
            return false;
        }
        MouseWheelScrollElement mouseWheelScrollElement = (MouseWheelScrollElement) obj;
        return AbstractC4492zt.d(this.scrollingLogicState, mouseWheelScrollElement.scrollingLogicState) && AbstractC4492zt.d(this.mouseWheelScrollConfig, mouseWheelScrollElement.mouseWheelScrollConfig);
    }

    public final ScrollConfig getMouseWheelScrollConfig() {
        return this.mouseWheelScrollConfig;
    }

    public final State<ScrollingLogic> getScrollingLogicState() {
        return this.scrollingLogicState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (this.scrollingLogicState.hashCode() * 31) + this.mouseWheelScrollConfig.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public MouseWheelScrollNode create() {
        return new MouseWheelScrollNode(this.scrollingLogicState, this.mouseWheelScrollConfig);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(MouseWheelScrollNode mouseWheelScrollNode) {
        AbstractC4492zt.h(mouseWheelScrollNode, "node");
        mouseWheelScrollNode.setScrollingLogicState(this.scrollingLogicState);
        mouseWheelScrollNode.setMouseWheelScrollConfig(this.mouseWheelScrollConfig);
    }
}
