package androidx.compose.ui;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalMapInjectionElement extends ModifierNodeElement<CompositionLocalMapInjectionNode> {
    private final CompositionLocalMap map;

    public CompositionLocalMapInjectionElement(CompositionLocalMap compositionLocalMap) {
        AbstractC4492zt.h(compositionLocalMap, HTML.Tag.MAP);
        this.map = compositionLocalMap;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        return (obj instanceof CompositionLocalMapInjectionElement) && AbstractC4492zt.d(((CompositionLocalMapInjectionElement) obj).map, this.map);
    }

    public final CompositionLocalMap getMap() {
        return this.map;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName("<Injected CompositionLocalMap>");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public CompositionLocalMapInjectionNode create() {
        return new CompositionLocalMapInjectionNode(this.map);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(CompositionLocalMapInjectionNode compositionLocalMapInjectionNode) {
        AbstractC4492zt.h(compositionLocalMapInjectionNode, "node");
        compositionLocalMapInjectionNode.setMap(this.map);
    }
}
