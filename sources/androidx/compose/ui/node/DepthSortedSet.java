package androidx.compose.ui.node;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.EnumC4322xv;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3750qp;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DepthSortedSet {
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;
    private final InterfaceC3430mv mapOfOriginalDepth$delegate = AbstractC3756qv.b(EnumC4322xv.NONE, DepthSortedSet$mapOfOriginalDepth$2.INSTANCE);
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet(boolean z) {
        this.extraAssertions = z;
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                AbstractC4492zt.h(layoutNode, "l1");
                AbstractC4492zt.h(layoutNode2, "l2");
                int iJ = AbstractC4492zt.j(layoutNode.getDepth$ui_release(), layoutNode2.getDepth$ui_release());
                return iJ != 0 ? iJ : AbstractC4492zt.j(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        };
        this.DepthComparator = comparator;
        this.set = new TreeSet<>(comparator);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final void add(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        if (!layoutNode.isAttached()) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.extraAssertions) {
            Integer num = getMapOfOriginalDepth().get(layoutNode);
            if (num == null) {
                getMapOfOriginalDepth().put(layoutNode, Integer.valueOf(layoutNode.getDepth$ui_release()));
            } else {
                if (num.intValue() != layoutNode.getDepth$ui_release()) {
                    throw new IllegalStateException("Check failed.");
                }
            }
        }
        this.set.add(layoutNode);
    }

    public final boolean contains(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        boolean zContains = this.set.contains(layoutNode);
        if (!this.extraAssertions || zContains == getMapOfOriginalDepth().containsKey(layoutNode)) {
            return zContains;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final LayoutNode pop() {
        LayoutNode layoutNodeFirst = this.set.first();
        AbstractC4492zt.g(layoutNodeFirst, "node");
        remove(layoutNodeFirst);
        return layoutNodeFirst;
    }

    public final void popEach(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        while (!isEmpty()) {
            interfaceC3750qp.invoke(pop());
        }
    }

    public final boolean remove(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        if (!layoutNode.isAttached()) {
            throw new IllegalStateException("Check failed.");
        }
        boolean zRemove = this.set.remove(layoutNode);
        if (this.extraAssertions) {
            Integer numRemove = getMapOfOriginalDepth().remove(layoutNode);
            if (zRemove) {
                int depth$ui_release = layoutNode.getDepth$ui_release();
                if (numRemove == null || numRemove.intValue() != depth$ui_release) {
                    throw new IllegalStateException("Check failed.");
                }
            } else if (numRemove != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        return zRemove;
    }

    public String toString() {
        String string = this.set.toString();
        AbstractC4492zt.g(string, "set.toString()");
        return string;
    }
}
