package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
abstract class DragEvent {

    @StabilityInferred(parameters = 0)
    public static final class DragCancelled extends DragEvent {
        public static final int $stable = 0;
        public static final DragCancelled INSTANCE = new DragCancelled();

        private DragCancelled() {
            super(null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class DragDelta extends DragEvent {
        public static final int $stable = 0;
        private final long delta;

        public /* synthetic */ DragDelta(long j, AbstractC0419Di abstractC0419Di) {
            this(j);
        }

        /* JADX INFO: renamed from: getDelta-F1C5BW0, reason: not valid java name */
        public final long m264getDeltaF1C5BW0() {
            return this.delta;
        }

        private DragDelta(long j) {
            super(null);
            this.delta = j;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class DragStarted extends DragEvent {
        public static final int $stable = 0;
        private final long startPoint;

        public /* synthetic */ DragStarted(long j, AbstractC0419Di abstractC0419Di) {
            this(j);
        }

        /* JADX INFO: renamed from: getStartPoint-F1C5BW0, reason: not valid java name */
        public final long m265getStartPointF1C5BW0() {
            return this.startPoint;
        }

        private DragStarted(long j) {
            super(null);
            this.startPoint = j;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class DragStopped extends DragEvent {
        public static final int $stable = 0;
        private final long velocity;

        public /* synthetic */ DragStopped(long j, AbstractC0419Di abstractC0419Di) {
            this(j);
        }

        /* JADX INFO: renamed from: getVelocity-9UxMQ8M, reason: not valid java name */
        public final long m266getVelocity9UxMQ8M() {
            return this.velocity;
        }

        private DragStopped(long j) {
            super(null);
            this.velocity = j;
        }
    }

    public /* synthetic */ DragEvent(AbstractC0419Di abstractC0419Di) {
        this();
    }

    private DragEvent() {
    }
}
