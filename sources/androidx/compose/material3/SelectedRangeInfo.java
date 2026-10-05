package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class SelectedRangeInfo {
    public static final Companion Companion = new Companion(null);
    private final boolean firstIsSelectionStart;
    private final C2020dG gridCoordinates;
    private final boolean lastIsSelectionEnd;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final SelectedRangeInfo calculateRangeInfo(CalendarMonth calendarMonth, CalendarDate calendarDate, CalendarDate calendarDate2) {
            AbstractC4492zt.h(calendarMonth, "month");
            if (calendarDate == null || calendarDate2 == null || calendarDate.getUtcTimeMillis() > calendarMonth.getEndUtcTimeMillis() || calendarDate2.getUtcTimeMillis() < calendarMonth.getStartUtcTimeMillis()) {
                return null;
            }
            boolean z = calendarDate.getUtcTimeMillis() >= calendarMonth.getStartUtcTimeMillis();
            boolean z2 = calendarDate2.getUtcTimeMillis() <= calendarMonth.getEndUtcTimeMillis();
            int daysFromStartOfWeekToFirstOfMonth = z ? (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarDate.getDayOfMonth()) - 1 : calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
            int daysFromStartOfWeekToFirstOfMonth2 = z2 ? (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarDate2.getDayOfMonth()) - 1 : (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) - 1;
            return new SelectedRangeInfo(new C2020dG(IntOffset.m5269boximpl(IntOffsetKt.IntOffset(daysFromStartOfWeekToFirstOfMonth % 7, daysFromStartOfWeekToFirstOfMonth / 7)), IntOffset.m5269boximpl(IntOffsetKt.IntOffset(daysFromStartOfWeekToFirstOfMonth2 % 7, daysFromStartOfWeekToFirstOfMonth2 / 7))), z, z2);
        }

        private Companion() {
        }
    }

    public SelectedRangeInfo(C2020dG c2020dG, boolean z, boolean z2) {
        AbstractC4492zt.h(c2020dG, "gridCoordinates");
        this.gridCoordinates = c2020dG;
        this.firstIsSelectionStart = z;
        this.lastIsSelectionEnd = z2;
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    public final C2020dG getGridCoordinates() {
        return this.gridCoordinates;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }
}
