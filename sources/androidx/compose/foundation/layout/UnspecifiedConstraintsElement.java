package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class UnspecifiedConstraintsElement extends ModifierNodeElement<UnspecifiedConstraintsNode> {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsElement(float f, float f2, AbstractC0419Di abstractC0419Di) {
        this(f, f2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        return Dp.m5165equalsimpl0(this.minWidth, unspecifiedConstraintsElement.minWidth) && Dp.m5165equalsimpl0(this.minHeight, unspecifiedConstraintsElement.minHeight);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m549getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m550getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (Dp.m5166hashCodeimpl(this.minWidth) * 31) + Dp.m5166hashCodeimpl(this.minHeight);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("defaultMinSize");
        inspectorInfo.getProperties().set("minWidth", Dp.m5158boximpl(this.minWidth));
        inspectorInfo.getProperties().set("minHeight", Dp.m5158boximpl(this.minHeight));
    }

    public /* synthetic */ UnspecifiedConstraintsElement(float f, float f2, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m5180getUnspecifiedD9Ej5fM() : f2, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(UnspecifiedConstraintsNode unspecifiedConstraintsNode) {
        AbstractC4492zt.h(unspecifiedConstraintsNode, "node");
        unspecifiedConstraintsNode.m554setMinWidth0680j_4(this.minWidth);
        unspecifiedConstraintsNode.m553setMinHeight0680j_4(this.minHeight);
    }

    private UnspecifiedConstraintsElement(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }
}
