package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class StateData {
    public static final Companion Companion = new Companion(null);
    private final CalendarModel calendarModel;
    private MutableState<DisplayMode> displayMode;
    private final MutableState displayedMonth$delegate;
    private MutableState<CalendarDate> selectedEndDate;
    private MutableState<CalendarDate> selectedStartDate;
    private final C1001Vs yearRange;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<StateData, Object> Saver() {
            return ListSaverKt.listSaver(StateData$Companion$Saver$1.INSTANCE, StateData$Companion$Saver$2.INSTANCE);
        }

        private Companion() {
        }
    }

    public /* synthetic */ StateData(Long l, Long l2, Long l3, C1001Vs c1001Vs, int i, AbstractC0419Di abstractC0419Di) {
        this(l, l2, l3, c1001Vs, i);
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final CalendarMonth getCurrentMonth() {
        CalendarModel calendarModel = this.calendarModel;
        return calendarModel.getMonth(calendarModel.getToday());
    }

    public final MutableState<DisplayMode> getDisplayMode() {
        return this.displayMode;
    }

    public final CalendarMonth getDisplayedMonth() {
        return (CalendarMonth) this.displayedMonth$delegate.getValue();
    }

    public final int getDisplayedMonthIndex() {
        return getDisplayedMonth().indexIn(this.yearRange);
    }

    public final MutableState<CalendarDate> getSelectedEndDate() {
        return this.selectedEndDate;
    }

    public final MutableState<CalendarDate> getSelectedStartDate() {
        return this.selectedStartDate;
    }

    public final int getTotalMonthsInRange() {
        return ((this.yearRange.c() - this.yearRange.b()) + 1) * 12;
    }

    public final C1001Vs getYearRange() {
        return this.yearRange;
    }

    public final void setDisplayMode(MutableState<DisplayMode> mutableState) {
        AbstractC4492zt.h(mutableState, "<set-?>");
        this.displayMode = mutableState;
    }

    public final void setDisplayedMonth(CalendarMonth calendarMonth) {
        AbstractC4492zt.h(calendarMonth, "<set-?>");
        this.displayedMonth$delegate.setValue(calendarMonth);
    }

    public final void setSelectedEndDate(MutableState<CalendarDate> mutableState) {
        AbstractC4492zt.h(mutableState, "<set-?>");
        this.selectedEndDate = mutableState;
    }

    public final void setSelectedStartDate(MutableState<CalendarDate> mutableState) {
        AbstractC4492zt.h(mutableState, "<set-?>");
        this.selectedStartDate = mutableState;
    }

    public final void setSelection(Long l, Long l2) {
        CalendarDate canonicalDate = l != null ? this.calendarModel.getCanonicalDate(l.longValue()) : null;
        CalendarDate canonicalDate2 = l2 != null ? this.calendarModel.getCanonicalDate(l2.longValue()) : null;
        if (canonicalDate != null && !this.yearRange.g(canonicalDate.getYear())) {
            throw new IllegalArgumentException(("The provided start date year (" + canonicalDate.getYear() + ") is out of the years range of " + this.yearRange + '.').toString());
        }
        if (canonicalDate2 != null && !this.yearRange.g(canonicalDate2.getYear())) {
            throw new IllegalArgumentException(("The provided end date year (" + canonicalDate2.getYear() + ") is out of the years range of " + this.yearRange + '.').toString());
        }
        if (canonicalDate2 != null) {
            if (canonicalDate == null) {
                throw new IllegalArgumentException("An end date was provided without a start date.");
            }
            if (canonicalDate.getUtcTimeMillis() > canonicalDate2.getUtcTimeMillis()) {
                throw new IllegalArgumentException("The provided end date appears before the start date.");
            }
        }
        this.selectedStartDate.setValue(canonicalDate);
        this.selectedEndDate.setValue(canonicalDate2);
    }

    /* JADX INFO: renamed from: switchDisplayMode-vCnGnXg, reason: not valid java name */
    public final void m1769switchDisplayModevCnGnXg(int i) {
        CalendarDate value = this.selectedStartDate.getValue();
        if (value != null) {
            setDisplayedMonth(this.calendarModel.getMonth(value));
        }
        if (this.selectedStartDate.getValue() == null && this.selectedEndDate.getValue() != null) {
            this.selectedEndDate.setValue(null);
        }
        this.displayMode.setValue(DisplayMode.m1529boximpl(i));
    }

    private StateData(Long l, Long l2, Long l3, C1001Vs c1001Vs, int i) {
        CalendarMonth currentMonth;
        AbstractC4492zt.h(c1001Vs, "yearRange");
        this.yearRange = c1001Vs;
        CalendarModel CalendarModel = CalendarModel_androidKt.CalendarModel();
        this.calendarModel = CalendarModel;
        this.selectedStartDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.selectedEndDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        setSelection(l, l2);
        if (l3 != null) {
            currentMonth = CalendarModel.getMonth(l3.longValue());
            if (!c1001Vs.g(currentMonth.getYear())) {
                throw new IllegalArgumentException(("The initial display month's year (" + currentMonth.getYear() + ") is out of the years range of " + c1001Vs + '.').toString());
            }
        } else {
            currentMonth = getCurrentMonth();
        }
        this.displayedMonth$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currentMonth, null, 2, null);
        this.displayMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DisplayMode.m1529boximpl(i), null, 2, null);
    }
}
