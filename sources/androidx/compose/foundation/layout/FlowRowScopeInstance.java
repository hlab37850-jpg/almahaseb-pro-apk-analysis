package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class FlowRowScopeInstance implements RowScope, FlowRowScope {
    public static final FlowRowScopeInstance INSTANCE = new FlowRowScopeInstance();
    private final /* synthetic */ RowScopeInstance $$delegate_0 = RowScopeInstance.INSTANCE;

    private FlowRowScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier align(Modifier modifier, Alignment.Vertical vertical) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(vertical, CellUtil.ALIGNMENT);
        return this.$$delegate_0.align(modifier, vertical);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignBy(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "alignmentLineBlock");
        return this.$$delegate_0.alignBy(modifier, interfaceC3750qp);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignByBaseline(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return this.$$delegate_0.alignByBaseline(modifier);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier weight(Modifier modifier, float f, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        return this.$$delegate_0.weight(modifier, f, z);
    }

    @Override // androidx.compose.foundation.layout.RowScope
    @Stable
    public Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(horizontalAlignmentLine, "alignmentLine");
        return this.$$delegate_0.alignBy(modifier, horizontalAlignmentLine);
    }
}
