package androidx.compose.ui.draw;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class DrawBehindElement extends ModifierNodeElement<DrawBackgroundModifier> {
    private final InterfaceC3750qp onDraw;

    public DrawBehindElement(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onDraw");
        this.onDraw = interfaceC3750qp;
    }

    public static /* synthetic */ DrawBehindElement copy$default(DrawBehindElement drawBehindElement, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = drawBehindElement.onDraw;
        }
        return drawBehindElement.copy(interfaceC3750qp);
    }

    public final InterfaceC3750qp component1() {
        return this.onDraw;
    }

    public final DrawBehindElement copy(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onDraw");
        return new DrawBehindElement(interfaceC3750qp);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DrawBehindElement) && AbstractC4492zt.d(this.onDraw, ((DrawBehindElement) obj).onDraw);
    }

    public final InterfaceC3750qp getOnDraw() {
        return this.onDraw;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onDraw.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("drawBehind");
        inspectorInfo.getProperties().set("onDraw", this.onDraw);
    }

    public String toString() {
        return "DrawBehindElement(onDraw=" + this.onDraw + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public DrawBackgroundModifier create() {
        return new DrawBackgroundModifier(this.onDraw);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(DrawBackgroundModifier drawBackgroundModifier) {
        AbstractC4492zt.h(drawBackgroundModifier, "node");
        drawBackgroundModifier.setOnDraw(this.onDraw);
    }
}
