package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class RotaryInputElement extends ModifierNodeElement<RotaryInputNode> {
    private final InterfaceC3750qp onPreRotaryScrollEvent;
    private final InterfaceC3750qp onRotaryScrollEvent;

    public RotaryInputElement(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        this.onRotaryScrollEvent = interfaceC3750qp;
        this.onPreRotaryScrollEvent = interfaceC3750qp2;
    }

    public static /* synthetic */ RotaryInputElement copy$default(RotaryInputElement rotaryInputElement, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = rotaryInputElement.onRotaryScrollEvent;
        }
        if ((i & 2) != 0) {
            interfaceC3750qp2 = rotaryInputElement.onPreRotaryScrollEvent;
        }
        return rotaryInputElement.copy(interfaceC3750qp, interfaceC3750qp2);
    }

    public final InterfaceC3750qp component1() {
        return this.onRotaryScrollEvent;
    }

    public final InterfaceC3750qp component2() {
        return this.onPreRotaryScrollEvent;
    }

    public final RotaryInputElement copy(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        return new RotaryInputElement(interfaceC3750qp, interfaceC3750qp2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotaryInputElement)) {
            return false;
        }
        RotaryInputElement rotaryInputElement = (RotaryInputElement) obj;
        return AbstractC4492zt.d(this.onRotaryScrollEvent, rotaryInputElement.onRotaryScrollEvent) && AbstractC4492zt.d(this.onPreRotaryScrollEvent, rotaryInputElement.onPreRotaryScrollEvent);
    }

    public final InterfaceC3750qp getOnPreRotaryScrollEvent() {
        return this.onPreRotaryScrollEvent;
    }

    public final InterfaceC3750qp getOnRotaryScrollEvent() {
        return this.onRotaryScrollEvent;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        InterfaceC3750qp interfaceC3750qp = this.onRotaryScrollEvent;
        int iHashCode = (interfaceC3750qp == null ? 0 : interfaceC3750qp.hashCode()) * 31;
        InterfaceC3750qp interfaceC3750qp2 = this.onPreRotaryScrollEvent;
        return iHashCode + (interfaceC3750qp2 != null ? interfaceC3750qp2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        InterfaceC3750qp interfaceC3750qp = this.onRotaryScrollEvent;
        if (interfaceC3750qp != null) {
            inspectorInfo.setName("onRotaryScrollEvent");
            inspectorInfo.getProperties().set("onRotaryScrollEvent", interfaceC3750qp);
        }
        InterfaceC3750qp interfaceC3750qp2 = this.onPreRotaryScrollEvent;
        if (interfaceC3750qp2 != null) {
            inspectorInfo.setName("onPreRotaryScrollEvent");
            inspectorInfo.getProperties().set("onPreRotaryScrollEvent", interfaceC3750qp2);
        }
    }

    public String toString() {
        return "RotaryInputElement(onRotaryScrollEvent=" + this.onRotaryScrollEvent + ", onPreRotaryScrollEvent=" + this.onPreRotaryScrollEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public RotaryInputNode create() {
        return new RotaryInputNode(this.onRotaryScrollEvent, this.onPreRotaryScrollEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(RotaryInputNode rotaryInputNode) {
        AbstractC4492zt.h(rotaryInputNode, "node");
        rotaryInputNode.setOnEvent(this.onRotaryScrollEvent);
        rotaryInputNode.setOnPreEvent(this.onPreRotaryScrollEvent);
    }
}
