package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutIdModifier extends Modifier.Node implements ParentDataModifierNode, LayoutIdParentData {
    private Object layoutId;

    public LayoutIdModifier(Object obj) {
        AbstractC4492zt.h(obj, "layoutId");
        this.layoutId = obj;
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    public Object getLayoutId() {
        return this.layoutId;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object modifyParentData(Density density, Object obj) {
        AbstractC4492zt.h(density, "<this>");
        return this;
    }

    public void setLayoutId$ui_release(Object obj) {
        AbstractC4492zt.h(obj, "<set-?>");
        this.layoutId = obj;
    }
}
