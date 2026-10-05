package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.VelocityKt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator = Offset.Companion.m2814getZeroF1C5BW0();
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    /* JADX WARN: Multi-variable type inference failed */
    public VelocityTracker() {
        boolean z = false;
        int i = 3;
        this.xVelocityTracker = new VelocityTracker1D(z, null, i, 0 == true ? 1 : 0);
        this.yVelocityTracker = new VelocityTracker1D(z, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m4132addPositionUv8p0NA(long j, long j2) {
        this.xVelocityTracker.addDataPoint(j, Offset.m2798getXimpl(j2));
        this.yVelocityTracker.addDataPoint(j, Offset.m2799getYimpl(j2));
    }

    /* JADX INFO: renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m4133calculateVelocity9UxMQ8M() {
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(), this.yVelocityTracker.calculateVelocity());
    }

    /* JADX INFO: renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name */
    public final long m4134getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
    }

    /* JADX INFO: renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m4135setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }
}
