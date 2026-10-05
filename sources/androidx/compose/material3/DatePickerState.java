package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class DatePickerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final MutableState displayMode$delegate;
    private final StateData stateData;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<DatePickerState, ?> Saver() {
            return SaverKt.Saver(DatePickerState$Companion$Saver$1.INSTANCE, DatePickerState$Companion$Saver$2.INSTANCE);
        }

        private Companion() {
        }
    }

    public /* synthetic */ DatePickerState(StateData stateData, AbstractC0419Di abstractC0419Di) {
        this(stateData);
    }

    /* JADX INFO: renamed from: getDisplayMode-jFl-4v0, reason: not valid java name */
    public final int m1512getDisplayModejFl4v0() {
        return ((DisplayMode) this.displayMode$delegate.getValue()).m1535unboximpl();
    }

    public final Long getSelectedDateMillis() {
        CalendarDate value = this.stateData.getSelectedStartDate().getValue();
        if (value != null) {
            return Long.valueOf(value.getUtcTimeMillis());
        }
        return null;
    }

    public final StateData getStateData$material3_release() {
        return this.stateData;
    }

    /* JADX INFO: renamed from: setDisplayMode-vCnGnXg, reason: not valid java name */
    public final void m1513setDisplayModevCnGnXg(int i) {
        this.displayMode$delegate.setValue(DisplayMode.m1529boximpl(i));
    }

    public final void setSelection(Long l) {
        this.stateData.setSelection(l, null);
    }

    public /* synthetic */ DatePickerState(Long l, Long l2, C1001Vs c1001Vs, int i, AbstractC0419Di abstractC0419Di) {
        this(l, l2, c1001Vs, i);
    }

    private DatePickerState(StateData stateData) {
        this.stateData = stateData;
        this.displayMode$delegate = stateData.getDisplayMode();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private DatePickerState(Long l, Long l2, C1001Vs c1001Vs, int i) {
        this(new StateData(l, null, l2, c1001Vs, i, null));
        AbstractC4492zt.h(c1001Vs, "yearRange");
    }
}
