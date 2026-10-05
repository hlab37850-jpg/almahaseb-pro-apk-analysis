package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class KeyInputElement extends ModifierNodeElement<KeyInputNode> {
    private final InterfaceC3750qp onKeyEvent;
    private final InterfaceC3750qp onPreKeyEvent;

    public KeyInputElement(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        this.onKeyEvent = interfaceC3750qp;
        this.onPreKeyEvent = interfaceC3750qp2;
    }

    public static /* synthetic */ KeyInputElement copy$default(KeyInputElement keyInputElement, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = keyInputElement.onKeyEvent;
        }
        if ((i & 2) != 0) {
            interfaceC3750qp2 = keyInputElement.onPreKeyEvent;
        }
        return keyInputElement.copy(interfaceC3750qp, interfaceC3750qp2);
    }

    public final InterfaceC3750qp component1() {
        return this.onKeyEvent;
    }

    public final InterfaceC3750qp component2() {
        return this.onPreKeyEvent;
    }

    public final KeyInputElement copy(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        return new KeyInputElement(interfaceC3750qp, interfaceC3750qp2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return AbstractC4492zt.d(this.onKeyEvent, keyInputElement.onKeyEvent) && AbstractC4492zt.d(this.onPreKeyEvent, keyInputElement.onPreKeyEvent);
    }

    public final InterfaceC3750qp getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final InterfaceC3750qp getOnPreKeyEvent() {
        return this.onPreKeyEvent;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        InterfaceC3750qp interfaceC3750qp = this.onKeyEvent;
        int iHashCode = (interfaceC3750qp == null ? 0 : interfaceC3750qp.hashCode()) * 31;
        InterfaceC3750qp interfaceC3750qp2 = this.onPreKeyEvent;
        return iHashCode + (interfaceC3750qp2 != null ? interfaceC3750qp2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        InterfaceC3750qp interfaceC3750qp = this.onKeyEvent;
        if (interfaceC3750qp != null) {
            inspectorInfo.setName("onKeyEvent");
            inspectorInfo.getProperties().set("onKeyEvent", interfaceC3750qp);
        }
        InterfaceC3750qp interfaceC3750qp2 = this.onPreKeyEvent;
        if (interfaceC3750qp2 != null) {
            inspectorInfo.setName("onPreviewKeyEvent");
            inspectorInfo.getProperties().set("onPreviewKeyEvent", interfaceC3750qp2);
        }
    }

    public String toString() {
        return "KeyInputElement(onKeyEvent=" + this.onKeyEvent + ", onPreKeyEvent=" + this.onPreKeyEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public KeyInputNode create() {
        return new KeyInputNode(this.onKeyEvent, this.onPreKeyEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(KeyInputNode keyInputNode) {
        AbstractC4492zt.h(keyInputNode, "node");
        keyInputNode.setOnEvent(this.onKeyEvent);
        keyInputNode.setOnPreEvent(this.onPreKeyEvent);
    }
}
