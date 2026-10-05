package androidx.compose.ui.node;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class DepthSortedSetsForDifferentPasses {
    private final DepthSortedSet lookaheadSet;
    private final DepthSortedSet set;

    public DepthSortedSetsForDifferentPasses(boolean z) {
        this.lookaheadSet = new DepthSortedSet(z);
        this.set = new DepthSortedSet(z);
    }

    public final void add(LayoutNode layoutNode, boolean z) {
        AbstractC4492zt.h(layoutNode, "node");
        if (z) {
            this.lookaheadSet.add(layoutNode);
        } else {
            if (this.lookaheadSet.contains(layoutNode)) {
                return;
            }
            this.set.add(layoutNode);
        }
    }

    public final boolean contains(LayoutNode layoutNode, boolean z) {
        AbstractC4492zt.h(layoutNode, "node");
        boolean zContains = this.lookaheadSet.contains(layoutNode);
        if (z) {
            return zContains;
        }
        return zContains || this.set.contains(layoutNode);
    }

    public final boolean isEmpty() {
        return this.set.isEmpty() && this.lookaheadSet.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final LayoutNode pop() {
        return !this.lookaheadSet.isEmpty() ? this.lookaheadSet.pop() : this.set.pop();
    }

    public final void popEach(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        while (isNotEmpty()) {
            boolean zIsEmpty = this.lookaheadSet.isEmpty();
            interfaceC0526Fp.mo13invoke((!zIsEmpty ? this.lookaheadSet : this.set).pop(), Boolean.valueOf(!zIsEmpty));
        }
    }

    public final boolean remove(LayoutNode layoutNode, boolean z) {
        AbstractC4492zt.h(layoutNode, "node");
        return z ? this.lookaheadSet.remove(layoutNode) : this.set.remove(layoutNode);
    }

    public final boolean contains(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        return this.lookaheadSet.contains(layoutNode) || this.set.contains(layoutNode);
    }

    public final boolean remove(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "node");
        return this.set.remove(layoutNode) || this.lookaheadSet.remove(layoutNode);
    }
}
