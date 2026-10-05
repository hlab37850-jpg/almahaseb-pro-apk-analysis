package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
final class GridSlotCache implements InterfaceC0526Fp {
    private long cachedConstraints;
    private float cachedDensity;
    private LazyGridSlots cachedSizes;
    private final InterfaceC0526Fp calculation;

    public GridSlotCache(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "calculation");
        this.calculation = interfaceC0526Fp;
        this.cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m606invoke0kLqBqw((Density) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public LazyGridSlots m606invoke0kLqBqw(Density density, long j) {
        AbstractC4492zt.h(density, "density");
        if (this.cachedSizes != null && Constraints.m5121equalsimpl0(this.cachedConstraints, j) && this.cachedDensity == density.getDensity()) {
            LazyGridSlots lazyGridSlots = this.cachedSizes;
            AbstractC4492zt.e(lazyGridSlots);
            return lazyGridSlots;
        }
        this.cachedConstraints = j;
        this.cachedDensity = density.getDensity();
        LazyGridSlots lazyGridSlots2 = (LazyGridSlots) this.calculation.mo13invoke(density, Constraints.m5116boximpl(j));
        this.cachedSizes = lazyGridSlots2;
        return lazyGridSlots2;
    }
}
