package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import defpackage.AbstractC4492zt;
import defpackage.RG;

/* JADX INFO: loaded from: classes.dex */
final class MouseWheelScrollNode extends DelegatingNode implements PointerInputModifierNode {
    private ScrollConfig mouseWheelScrollConfig;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private State<ScrollingLogic> scrollingLogicState;

    public MouseWheelScrollNode(State<ScrollingLogic> state, ScrollConfig scrollConfig) {
        AbstractC4492zt.h(state, "scrollingLogicState");
        AbstractC4492zt.h(scrollConfig, "mouseWheelScrollConfig");
        this.scrollingLogicState = state;
        this.mouseWheelScrollConfig = scrollConfig;
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new MouseWheelScrollNode$pointerInputNode$1(this, null)));
    }

    public final ScrollConfig getMouseWheelScrollConfig() {
        return this.mouseWheelScrollConfig;
    }

    public final State<ScrollingLogic> getScrollingLogicState() {
        return this.scrollingLogicState;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return RG.a(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        RG.b(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo150onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPass, "pass");
        this.pointerInputNode.mo150onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        RG.c(this);
    }

    public final void setMouseWheelScrollConfig(ScrollConfig scrollConfig) {
        AbstractC4492zt.h(scrollConfig, "<set-?>");
        this.mouseWheelScrollConfig = scrollConfig;
    }

    public final void setScrollingLogicState(State<ScrollingLogic> state) {
        AbstractC4492zt.h(state, "<set-?>");
        this.scrollingLogicState = state;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return RG.d(this);
    }
}
