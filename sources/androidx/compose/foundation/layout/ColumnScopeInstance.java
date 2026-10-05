package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class ColumnScopeInstance implements ColumnScope {
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    private ColumnScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    public Modifier align(Modifier modifier, Alignment.Horizontal horizontal) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(horizontal, CellUtil.ALIGNMENT);
        return modifier.then(new HorizontalAlignElement(horizontal));
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    public Modifier alignBy(Modifier modifier, VerticalAlignmentLine verticalAlignmentLine) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(verticalAlignmentLine, "alignmentLine");
        return modifier.then(new WithAlignmentLineElement(verticalAlignmentLine));
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    public Modifier weight(Modifier modifier, float f, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        if (f > 0.0d) {
            return modifier.then(new LayoutWeightElement(f, z));
        }
        throw new IllegalArgumentException(("invalid weight " + f + "; must be greater than zero").toString());
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    @Stable
    public Modifier alignBy(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "alignmentLineBlock");
        return modifier.then(new WithAlignmentLineBlockElement(interfaceC3750qp));
    }
}
