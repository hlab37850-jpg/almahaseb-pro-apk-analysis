package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0789Ob;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ProgressBarRangeInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final ProgressBarRangeInfo Indeterminate = new ProgressBarRangeInfo(0.0f, AbstractC3790rJ.b(0.0f, 0.0f), 0, 4, null);
    private final float current;
    private final InterfaceC0789Ob range;
    private final int steps;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final ProgressBarRangeInfo getIndeterminate() {
            return ProgressBarRangeInfo.Indeterminate;
        }

        private Companion() {
        }
    }

    public ProgressBarRangeInfo(float f, InterfaceC0789Ob interfaceC0789Ob, int i) {
        AbstractC4492zt.h(interfaceC0789Ob, "range");
        this.current = f;
        this.range = interfaceC0789Ob;
        this.steps = i;
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarRangeInfo)) {
            return false;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
        return this.current == progressBarRangeInfo.current && AbstractC4492zt.d(this.range, progressBarRangeInfo.range) && this.steps == progressBarRangeInfo.steps;
    }

    public final float getCurrent() {
        return this.current;
    }

    public final InterfaceC0789Ob getRange() {
        return this.range;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.current) * 31) + this.range.hashCode()) * 31) + this.steps;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.current + ", range=" + this.range + ", steps=" + this.steps + ')';
    }

    public /* synthetic */ ProgressBarRangeInfo(float f, InterfaceC0789Ob interfaceC0789Ob, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(f, interfaceC0789Ob, (i2 & 4) != 0 ? 0 : i);
    }
}
