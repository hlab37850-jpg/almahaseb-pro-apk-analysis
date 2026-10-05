package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableElement extends ModifierNodeElement<DraggableNode> {
    private final InterfaceC3750qp canDrag;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final InterfaceC0552Gp onDragStarted;
    private final InterfaceC0552Gp onDragStopped;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final InterfaceC3588op startDragImmediately;
    private final DraggableState state;

    public DraggableElement(DraggableState draggableState, InterfaceC3750qp interfaceC3750qp, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC3588op interfaceC3588op, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, boolean z2) {
        AbstractC4492zt.h(draggableState, "state");
        AbstractC4492zt.h(interfaceC3750qp, "canDrag");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC3588op, "startDragImmediately");
        AbstractC4492zt.h(interfaceC0552Gp, "onDragStarted");
        AbstractC4492zt.h(interfaceC0552Gp2, "onDragStopped");
        this.state = draggableState;
        this.canDrag = interfaceC3750qp;
        this.orientation = orientation;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = interfaceC3588op;
        this.onDragStarted = interfaceC0552Gp;
        this.onDragStopped = interfaceC0552Gp2;
        this.reverseDirection = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(DraggableElement.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DraggableElement");
        DraggableElement draggableElement = (DraggableElement) obj;
        return AbstractC4492zt.d(this.state, draggableElement.state) && AbstractC4492zt.d(this.canDrag, draggableElement.canDrag) && this.orientation == draggableElement.orientation && this.enabled == draggableElement.enabled && AbstractC4492zt.d(this.interactionSource, draggableElement.interactionSource) && AbstractC4492zt.d(this.startDragImmediately, draggableElement.startDragImmediately) && AbstractC4492zt.d(this.onDragStarted, draggableElement.onDragStarted) && AbstractC4492zt.d(this.onDragStopped, draggableElement.onDragStopped) && this.reverseDirection == draggableElement.reverseDirection;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((((((this.state.hashCode() * 31) + this.canDrag.hashCode()) * 31) + this.orientation.hashCode()) * 31) + AbstractC0564Hb.a(this.enabled)) * 31;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return ((((((((iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31) + this.startDragImmediately.hashCode()) * 31) + this.onDragStarted.hashCode()) * 31) + this.onDragStopped.hashCode()) * 31) + AbstractC0564Hb.a(this.reverseDirection);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("draggable");
        inspectorInfo.getProperties().set("canDrag", this.canDrag);
        inspectorInfo.getProperties().set("orientation", this.orientation);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        inspectorInfo.getProperties().set("interactionSource", this.interactionSource);
        inspectorInfo.getProperties().set("startDragImmediately", this.startDragImmediately);
        inspectorInfo.getProperties().set("onDragStarted", this.onDragStarted);
        inspectorInfo.getProperties().set("onDragStopped", this.onDragStopped);
        inspectorInfo.getProperties().set("state", this.state);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public DraggableNode create() {
        return new DraggableNode(this.state, this.canDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(DraggableNode draggableNode) {
        AbstractC4492zt.h(draggableNode, "node");
        draggableNode.update(this.state, this.canDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }
}
