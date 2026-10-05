package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1 INSTANCE = new LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1();

    public LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4179invoke0kLqBqw((SubcomposeIntermediateMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m4179invoke0kLqBqw(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, long j) {
        AbstractC4492zt.h(subcomposeIntermediateMeasureScope, "$this$null");
        return (MeasureResult) subcomposeIntermediateMeasureScope.getLookaheadMeasurePolicy().mo13invoke(subcomposeIntermediateMeasureScope, Constraints.m5116boximpl(j));
    }
}
