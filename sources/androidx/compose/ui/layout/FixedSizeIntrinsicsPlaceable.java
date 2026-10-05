package androidx.compose.ui.layout;

import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FixedSizeIntrinsicsPlaceable extends Placeable {
    public FixedSizeIntrinsicsPlaceable(int i, int i2) {
        m4201setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo4160placeAtf8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp) {
    }
}
