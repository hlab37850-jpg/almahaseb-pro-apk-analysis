package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
final class LazyStaggeredGridSlotCache implements InterfaceC0526Fp {
    private long cachedConstraints;
    private float cachedDensity;
    private LazyStaggeredGridSlots cachedSizes;
    private final InterfaceC0526Fp calculation;

    public LazyStaggeredGridSlotCache(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "calculation");
        this.calculation = interfaceC0526Fp;
        this.cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m674invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public LazyStaggeredGridSlots m674invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "density");
        if (this.cachedSizes != null && Constraints.m5121equalsimpl0(this.cachedConstraints, j) && this.cachedDensity == density.getDensity()) {
            LazyStaggeredGridSlots lazyStaggeredGridSlots = this.cachedSizes;
            AbstractC4492zt.e(lazyStaggeredGridSlots);
            return lazyStaggeredGridSlots;
        }
        this.cachedConstraints = j;
        this.cachedDensity = density.getDensity();
        LazyStaggeredGridSlots lazyStaggeredGridSlots2 = (LazyStaggeredGridSlots) this.calculation.mo13invoke(density, Constraints.m5116boximpl(j));
        this.cachedSizes = lazyStaggeredGridSlots2;
        return lazyStaggeredGridSlots2;
    }
}
