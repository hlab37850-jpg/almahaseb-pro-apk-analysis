package androidx.compose.foundation;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class ExcludeFromSystemGestureElement extends ModifierNodeElement<ExcludeFromSystemGestureNode> {
    private final InterfaceC3750qp exclusion;

    public ExcludeFromSystemGestureElement(InterfaceC3750qp interfaceC3750qp) {
        this.exclusion = interfaceC3750qp;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (obj instanceof ExcludeFromSystemGestureElement) {
            return AbstractC4492zt.d(this.exclusion, ((ExcludeFromSystemGestureElement) obj).exclusion);
        }
        return false;
    }

    public final InterfaceC3750qp getExclusion() {
        return this.exclusion;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        InterfaceC3750qp interfaceC3750qp = this.exclusion;
        if (interfaceC3750qp != null) {
            return interfaceC3750qp.hashCode();
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("systemGestureExclusion");
        if (this.exclusion != null) {
            inspectorInfo.getProperties().set("exclusion", this.exclusion);
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    @SuppressLint({"NewApi"})
    public ExcludeFromSystemGestureNode create() {
        return new ExcludeFromSystemGestureNode(this.exclusion);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ExcludeFromSystemGestureNode excludeFromSystemGestureNode) {
        AbstractC4492zt.h(excludeFromSystemGestureNode, "node");
        excludeFromSystemGestureNode.setExclusion(this.exclusion);
    }
}
