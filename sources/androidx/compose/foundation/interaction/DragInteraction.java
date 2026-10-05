package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface DragInteraction extends Interaction {

    @StabilityInferred(parameters = 0)
    public static final class Cancel implements DragInteraction {
        public static final int $stable = 0;
        private final Start start;

        public Cancel(Start start) {
            AbstractC4492zt.h(start, HTML.Attribute.START);
            this.start = start;
        }

        public final Start getStart() {
            return this.start;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Start implements DragInteraction {
        public static final int $stable = 0;
    }

    @StabilityInferred(parameters = 0)
    public static final class Stop implements DragInteraction {
        public static final int $stable = 0;
        private final Start start;

        public Stop(Start start) {
            AbstractC4492zt.h(start, HTML.Attribute.START);
            this.start = start;
        }

        public final Start getStart() {
            return this.start;
        }
    }
}
