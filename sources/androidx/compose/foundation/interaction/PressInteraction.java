package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    @StabilityInferred(parameters = 0)
    public static final class Cancel implements PressInteraction {
        public static final int $stable = 0;
        private final Press press;

        public Cancel(Press press) {
            AbstractC4492zt.h(press, "press");
            this.press = press;
        }

        public final Press getPress() {
            return this.press;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Press implements PressInteraction {
        public static final int $stable = 0;
        private final long pressPosition;

        public /* synthetic */ Press(long j, AbstractC0419Di abstractC0419Di) {
            this(j);
        }

        /* JADX INFO: renamed from: getPressPosition-F1C5BW0, reason: not valid java name */
        public final long m366getPressPositionF1C5BW0() {
            return this.pressPosition;
        }

        private Press(long j) {
            this.pressPosition = j;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Release implements PressInteraction {
        public static final int $stable = 0;
        private final Press press;

        public Release(Press press) {
            AbstractC4492zt.h(press, "press");
            this.press = press;
        }

        public final Press getPress() {
            return this.press;
        }
    }
}
