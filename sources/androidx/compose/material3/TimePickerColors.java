package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
public final class TimePickerColors {
    public static final int $stable = 0;
    private final long clockDialColor;
    private final long clockDialSelectedContentColor;
    private final long clockDialUnselectedContentColor;
    private final long containerColor;
    private final long periodSelectorBorderColor;
    private final long periodSelectorSelectedContainerColor;
    private final long periodSelectorSelectedContentColor;
    private final long periodSelectorUnselectedContainerColor;
    private final long periodSelectorUnselectedContentColor;
    private final long selectorColor;
    private final long timeSelectorSelectedContainerColor;
    private final long timeSelectorSelectedContentColor;
    private final long timeSelectorUnselectedContainerColor;
    private final long timeSelectorUnselectedContentColor;

    public /* synthetic */ TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    /* JADX INFO: renamed from: clockDialContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1933clockDialContentColorvNxB06k$material3_release(boolean z) {
        return z ? this.clockDialSelectedContentColor : this.clockDialUnselectedContentColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(TimePickerColors.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.material3.TimePickerColors");
        TimePickerColors timePickerColors = (TimePickerColors) obj;
        return Color.m3033equalsimpl0(this.clockDialColor, timePickerColors.clockDialColor) && Color.m3033equalsimpl0(this.selectorColor, timePickerColors.selectorColor) && Color.m3033equalsimpl0(this.containerColor, timePickerColors.containerColor) && Color.m3033equalsimpl0(this.periodSelectorBorderColor, timePickerColors.periodSelectorBorderColor) && Color.m3033equalsimpl0(this.periodSelectorSelectedContainerColor, timePickerColors.periodSelectorSelectedContainerColor) && Color.m3033equalsimpl0(this.periodSelectorUnselectedContainerColor, timePickerColors.periodSelectorUnselectedContainerColor) && Color.m3033equalsimpl0(this.periodSelectorSelectedContentColor, timePickerColors.periodSelectorSelectedContentColor) && Color.m3033equalsimpl0(this.periodSelectorUnselectedContentColor, timePickerColors.periodSelectorUnselectedContentColor) && Color.m3033equalsimpl0(this.timeSelectorSelectedContainerColor, timePickerColors.timeSelectorSelectedContainerColor) && Color.m3033equalsimpl0(this.timeSelectorUnselectedContainerColor, timePickerColors.timeSelectorUnselectedContainerColor) && Color.m3033equalsimpl0(this.timeSelectorSelectedContentColor, timePickerColors.timeSelectorSelectedContentColor) && Color.m3033equalsimpl0(this.timeSelectorUnselectedContentColor, timePickerColors.timeSelectorUnselectedContentColor);
    }

    /* JADX INFO: renamed from: getClockDialColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1934getClockDialColor0d7_KjU$material3_release() {
        return this.clockDialColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1935getContainerColor0d7_KjU$material3_release() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorBorderColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1936getPeriodSelectorBorderColor0d7_KjU$material3_release() {
        return this.periodSelectorBorderColor;
    }

    /* JADX INFO: renamed from: getSelectorColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1937getSelectorColor0d7_KjU$material3_release() {
        return this.selectorColor;
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m3039hashCodeimpl(this.clockDialColor) * 31) + Color.m3039hashCodeimpl(this.selectorColor)) * 31) + Color.m3039hashCodeimpl(this.containerColor)) * 31) + Color.m3039hashCodeimpl(this.periodSelectorBorderColor)) * 31) + Color.m3039hashCodeimpl(this.periodSelectorSelectedContainerColor)) * 31) + Color.m3039hashCodeimpl(this.periodSelectorUnselectedContainerColor)) * 31) + Color.m3039hashCodeimpl(this.periodSelectorSelectedContentColor)) * 31) + Color.m3039hashCodeimpl(this.periodSelectorUnselectedContentColor)) * 31) + Color.m3039hashCodeimpl(this.timeSelectorSelectedContainerColor)) * 31) + Color.m3039hashCodeimpl(this.timeSelectorUnselectedContainerColor)) * 31) + Color.m3039hashCodeimpl(this.timeSelectorSelectedContentColor)) * 31) + Color.m3039hashCodeimpl(this.timeSelectorUnselectedContentColor);
    }

    /* JADX INFO: renamed from: periodSelectorContainerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1938periodSelectorContainerColorvNxB06k$material3_release(boolean z) {
        return z ? this.periodSelectorSelectedContainerColor : this.periodSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: periodSelectorContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1939periodSelectorContentColorvNxB06k$material3_release(boolean z) {
        return z ? this.periodSelectorSelectedContentColor : this.periodSelectorUnselectedContentColor;
    }

    /* JADX INFO: renamed from: timeSelectorContainerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1940timeSelectorContainerColorvNxB06k$material3_release(boolean z) {
        return z ? this.timeSelectorSelectedContainerColor : this.timeSelectorUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: timeSelectorContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1941timeSelectorContentColorvNxB06k$material3_release(boolean z) {
        return z ? this.timeSelectorSelectedContentColor : this.timeSelectorUnselectedContentColor;
    }

    private TimePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.clockDialColor = j;
        this.selectorColor = j2;
        this.containerColor = j3;
        this.periodSelectorBorderColor = j4;
        this.clockDialSelectedContentColor = j5;
        this.clockDialUnselectedContentColor = j6;
        this.periodSelectorSelectedContainerColor = j7;
        this.periodSelectorUnselectedContainerColor = j8;
        this.periodSelectorSelectedContentColor = j9;
        this.periodSelectorUnselectedContentColor = j10;
        this.timeSelectorSelectedContainerColor = j11;
        this.timeSelectorUnselectedContainerColor = j12;
        this.timeSelectorSelectedContentColor = j13;
        this.timeSelectorUnselectedContentColor = j14;
    }
}
