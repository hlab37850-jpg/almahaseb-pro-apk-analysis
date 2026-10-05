package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class SoftKeyboardInterceptionElement extends ModifierNodeElement<InterceptedKeyInputModifierNodeImpl> {
    private final InterfaceC3750qp onKeyEvent;
    private final InterfaceC3750qp onPreKeyEvent;

    public SoftKeyboardInterceptionElement(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        this.onKeyEvent = interfaceC3750qp;
        this.onPreKeyEvent = interfaceC3750qp2;
    }

    public static /* synthetic */ SoftKeyboardInterceptionElement copy$default(SoftKeyboardInterceptionElement softKeyboardInterceptionElement, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = softKeyboardInterceptionElement.onKeyEvent;
        }
        if ((i & 2) != 0) {
            interfaceC3750qp2 = softKeyboardInterceptionElement.onPreKeyEvent;
        }
        return softKeyboardInterceptionElement.copy(interfaceC3750qp, interfaceC3750qp2);
    }

    public final InterfaceC3750qp component1() {
        return this.onKeyEvent;
    }

    public final InterfaceC3750qp component2() {
        return this.onPreKeyEvent;
    }

    public final SoftKeyboardInterceptionElement copy(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        return new SoftKeyboardInterceptionElement(interfaceC3750qp, interfaceC3750qp2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoftKeyboardInterceptionElement)) {
            return false;
        }
        SoftKeyboardInterceptionElement softKeyboardInterceptionElement = (SoftKeyboardInterceptionElement) obj;
        return AbstractC4492zt.d(this.onKeyEvent, softKeyboardInterceptionElement.onKeyEvent) && AbstractC4492zt.d(this.onPreKeyEvent, softKeyboardInterceptionElement.onPreKeyEvent);
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
            inspectorInfo.setName("onKeyToSoftKeyboardInterceptedEvent");
            inspectorInfo.getProperties().set("onKeyToSoftKeyboardInterceptedEvent", interfaceC3750qp);
        }
        InterfaceC3750qp interfaceC3750qp2 = this.onPreKeyEvent;
        if (interfaceC3750qp2 != null) {
            inspectorInfo.setName("onPreKeyToSoftKeyboardInterceptedEvent");
            inspectorInfo.getProperties().set("onPreKeyToSoftKeyboardInterceptedEvent", interfaceC3750qp2);
        }
    }

    public String toString() {
        return "SoftKeyboardInterceptionElement(onKeyEvent=" + this.onKeyEvent + ", onPreKeyEvent=" + this.onPreKeyEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public InterceptedKeyInputModifierNodeImpl create() {
        return new InterceptedKeyInputModifierNodeImpl(this.onKeyEvent, this.onPreKeyEvent);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(InterceptedKeyInputModifierNodeImpl interceptedKeyInputModifierNodeImpl) {
        AbstractC4492zt.h(interceptedKeyInputModifierNodeImpl, "node");
        interceptedKeyInputModifierNodeImpl.setOnEvent(this.onKeyEvent);
        interceptedKeyInputModifierNodeImpl.setOnPreEvent(this.onPreKeyEvent);
    }
}
