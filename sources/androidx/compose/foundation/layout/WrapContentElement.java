package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {
    public static final Companion Companion = new Companion(null);
    private final Object align;
    private final InterfaceC0526Fp alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        public final WrapContentElement height(Alignment.Vertical vertical, boolean z) {
            AbstractC4492zt.h(vertical, "align");
            return new WrapContentElement(Direction.Vertical, z, new WrapContentElement$Companion$height$1(vertical), vertical, "wrapContentHeight");
        }

        @Stable
        public final WrapContentElement size(Alignment alignment, boolean z) {
            AbstractC4492zt.h(alignment, "align");
            return new WrapContentElement(Direction.Both, z, new WrapContentElement$Companion$size$1(alignment), alignment, "wrapContentSize");
        }

        @Stable
        public final WrapContentElement width(Alignment.Horizontal horizontal, boolean z) {
            AbstractC4492zt.h(horizontal, "align");
            return new WrapContentElement(Direction.Horizontal, z, new WrapContentElement$Companion$width$1(horizontal), horizontal, "wrapContentWidth");
        }

        private Companion() {
        }
    }

    public WrapContentElement(Direction direction, boolean z, InterfaceC0526Fp interfaceC0526Fp, Object obj, String str) {
        AbstractC4492zt.h(direction, CSS.Property.DIRECTION);
        AbstractC4492zt.h(interfaceC0526Fp, "alignmentCallback");
        AbstractC4492zt.h(obj, "align");
        AbstractC4492zt.h(str, "inspectorName");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = interfaceC0526Fp;
        this.align = obj;
        this.inspectorName = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(WrapContentElement.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.foundation.layout.WrapContentElement");
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.direction == wrapContentElement.direction && this.unbounded == wrapContentElement.unbounded && AbstractC4492zt.d(this.align, wrapContentElement.align);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((this.direction.hashCode() * 31) + AbstractC0564Hb.a(this.unbounded)) * 31) + this.align.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        inspectorInfo.setName(this.inspectorName);
        inspectorInfo.getProperties().set("align", this.align);
        inspectorInfo.getProperties().set("unbounded", Boolean.valueOf(this.unbounded));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(WrapContentNode wrapContentNode) {
        AbstractC4492zt.h(wrapContentNode, "node");
        wrapContentNode.setDirection(this.direction);
        wrapContentNode.setUnbounded(this.unbounded);
        wrapContentNode.setAlignmentCallback(this.alignmentCallback);
    }
}
