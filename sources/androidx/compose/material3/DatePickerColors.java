package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
public final class DatePickerColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long currentYearContentColor;
    private final long dayContentColor;
    private final long dayInSelectionRangeContainerColor;
    private final long dayInSelectionRangeContentColor;
    private final long disabledDayContentColor;
    private final long disabledSelectedDayContainerColor;
    private final long disabledSelectedDayContentColor;
    private final long headlineContentColor;
    private final long selectedDayContainerColor;
    private final long selectedDayContentColor;
    private final long selectedYearContainerColor;
    private final long selectedYearContentColor;
    private final long subheadContentColor;
    private final long titleContentColor;
    private final long todayContentColor;
    private final long todayDateBorderColor;
    private final long weekdayContentColor;
    private final long yearContentColor;

    public /* synthetic */ DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    @Composable
    public final State<Color> dayContainerColor$material3_release(boolean z, boolean z2, boolean z3, Composer composer, int i) {
        long jM3067getTransparent0d7_KjU;
        State<Color> stateRememberUpdatedState;
        composer.startReplaceableGroup(-1240482658);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1240482658, i, -1, "androidx.compose.material3.DatePickerColors.dayContainerColor (DatePicker.kt:611)");
        }
        if (z) {
            jM3067getTransparent0d7_KjU = z2 ? this.selectedDayContainerColor : this.disabledSelectedDayContainerColor;
        } else {
            jM3067getTransparent0d7_KjU = Color.Companion.m3067getTransparent0d7_KjU();
        }
        long j = jM3067getTransparent0d7_KjU;
        if (z3) {
            composer.startReplaceableGroup(1577406023);
            stateRememberUpdatedState = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1577406187);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(j), composer, 0);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> dayContentColor$material3_release(boolean z, boolean z2, boolean z3, boolean z4, Composer composer, int i) {
        long j;
        State<Color> stateM72animateColorAsStateeuL9pac;
        composer.startReplaceableGroup(-1233694918);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1233694918, i, -1, "androidx.compose.material3.DatePickerColors.dayContentColor (DatePicker.kt:576)");
        }
        if (z2 && z4) {
            j = this.selectedDayContentColor;
        } else if (z2 && !z4) {
            j = this.disabledSelectedDayContentColor;
        } else if (z3 && z4) {
            j = this.dayInSelectionRangeContentColor;
        } else if (z3 && !z4) {
            j = this.disabledDayContentColor;
        } else if (z) {
            j = this.todayContentColor;
        } else {
            j = z4 ? this.dayContentColor : this.disabledDayContentColor;
        }
        long j2 = j;
        if (z3) {
            composer.startReplaceableGroup(379006271);
            stateM72animateColorAsStateeuL9pac = SnapshotStateKt.rememberUpdatedState(Color.m3022boximpl(j2), composer, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(379006329);
            stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j2, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DatePickerColors)) {
            return false;
        }
        DatePickerColors datePickerColors = (DatePickerColors) obj;
        return Color.m3033equalsimpl0(this.containerColor, datePickerColors.containerColor) && Color.m3033equalsimpl0(this.titleContentColor, datePickerColors.titleContentColor) && Color.m3033equalsimpl0(this.headlineContentColor, datePickerColors.headlineContentColor) && Color.m3033equalsimpl0(this.weekdayContentColor, datePickerColors.weekdayContentColor) && Color.m3033equalsimpl0(this.subheadContentColor, datePickerColors.subheadContentColor) && Color.m3033equalsimpl0(this.yearContentColor, datePickerColors.yearContentColor) && Color.m3033equalsimpl0(this.currentYearContentColor, datePickerColors.currentYearContentColor) && Color.m3033equalsimpl0(this.selectedYearContentColor, datePickerColors.selectedYearContentColor) && Color.m3033equalsimpl0(this.selectedYearContainerColor, datePickerColors.selectedYearContainerColor) && Color.m3033equalsimpl0(this.dayContentColor, datePickerColors.dayContentColor) && Color.m3033equalsimpl0(this.disabledDayContentColor, datePickerColors.disabledDayContentColor) && Color.m3033equalsimpl0(this.selectedDayContentColor, datePickerColors.selectedDayContentColor) && Color.m3033equalsimpl0(this.disabledSelectedDayContentColor, datePickerColors.disabledSelectedDayContentColor) && Color.m3033equalsimpl0(this.selectedDayContainerColor, datePickerColors.selectedDayContainerColor) && Color.m3033equalsimpl0(this.disabledSelectedDayContainerColor, datePickerColors.disabledSelectedDayContainerColor) && Color.m3033equalsimpl0(this.todayContentColor, datePickerColors.todayContentColor) && Color.m3033equalsimpl0(this.todayDateBorderColor, datePickerColors.todayDateBorderColor) && Color.m3033equalsimpl0(this.dayInSelectionRangeContainerColor, datePickerColors.dayInSelectionRangeContainerColor) && Color.m3033equalsimpl0(this.dayInSelectionRangeContentColor, datePickerColors.dayInSelectionRangeContentColor);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1489getContainerColor0d7_KjU$material3_release() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getDayInSelectionRangeContainerColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1490getDayInSelectionRangeContainerColor0d7_KjU$material3_release() {
        return this.dayInSelectionRangeContainerColor;
    }

    /* JADX INFO: renamed from: getHeadlineContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1491getHeadlineContentColor0d7_KjU$material3_release() {
        return this.headlineContentColor;
    }

    /* JADX INFO: renamed from: getSubheadContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1492getSubheadContentColor0d7_KjU$material3_release() {
        return this.subheadContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1493getTitleContentColor0d7_KjU$material3_release() {
        return this.titleContentColor;
    }

    /* JADX INFO: renamed from: getTodayDateBorderColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1494getTodayDateBorderColor0d7_KjU$material3_release() {
        return this.todayDateBorderColor;
    }

    /* JADX INFO: renamed from: getWeekdayContentColor-0d7_KjU$material3_release, reason: not valid java name */
    public final long m1495getWeekdayContentColor0d7_KjU$material3_release() {
        return this.weekdayContentColor;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((Color.m3039hashCodeimpl(this.containerColor) * 31) + Color.m3039hashCodeimpl(this.titleContentColor)) * 31) + Color.m3039hashCodeimpl(this.headlineContentColor)) * 31) + Color.m3039hashCodeimpl(this.weekdayContentColor)) * 31) + Color.m3039hashCodeimpl(this.subheadContentColor)) * 31) + Color.m3039hashCodeimpl(this.yearContentColor)) * 31) + Color.m3039hashCodeimpl(this.currentYearContentColor)) * 31) + Color.m3039hashCodeimpl(this.selectedYearContentColor)) * 31) + Color.m3039hashCodeimpl(this.selectedYearContainerColor)) * 31) + Color.m3039hashCodeimpl(this.dayContentColor)) * 31) + Color.m3039hashCodeimpl(this.disabledDayContentColor)) * 31) + Color.m3039hashCodeimpl(this.selectedDayContentColor)) * 31) + Color.m3039hashCodeimpl(this.disabledSelectedDayContentColor)) * 31) + Color.m3039hashCodeimpl(this.selectedDayContainerColor)) * 31) + Color.m3039hashCodeimpl(this.disabledSelectedDayContainerColor)) * 31) + Color.m3039hashCodeimpl(this.todayContentColor)) * 31) + Color.m3039hashCodeimpl(this.todayDateBorderColor)) * 31) + Color.m3039hashCodeimpl(this.dayInSelectionRangeContainerColor)) * 31) + Color.m3039hashCodeimpl(this.dayInSelectionRangeContentColor);
    }

    @Composable
    public final State<Color> yearContainerColor$material3_release(boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(488208633);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(488208633, i, -1, "androidx.compose.material3.DatePickerColors.yearContainerColor (DatePicker.kt:659)");
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(z ? this.selectedYearContainerColor : Color.Companion.m3067getTransparent0d7_KjU(), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    @Composable
    public final State<Color> yearContentColor$material3_release(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1749254827);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749254827, i, -1, "androidx.compose.material3.DatePickerColors.yearContentColor (DatePicker.kt:638)");
        }
        if (z2) {
            j = this.selectedYearContentColor;
        } else {
            j = z ? this.currentYearContentColor : this.yearContentColor;
        }
        State<Color> stateM72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(j, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer, 0, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM72animateColorAsStateeuL9pac;
    }

    private DatePickerColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.containerColor = j;
        this.titleContentColor = j2;
        this.headlineContentColor = j3;
        this.weekdayContentColor = j4;
        this.subheadContentColor = j5;
        this.yearContentColor = j6;
        this.currentYearContentColor = j7;
        this.selectedYearContentColor = j8;
        this.selectedYearContainerColor = j9;
        this.dayContentColor = j10;
        this.disabledDayContentColor = j11;
        this.selectedDayContentColor = j12;
        this.disabledSelectedDayContentColor = j13;
        this.selectedDayContainerColor = j14;
        this.disabledSelectedDayContainerColor = j15;
        this.todayContentColor = j16;
        this.todayDateBorderColor = j17;
        this.dayInSelectionRangeContainerColor = j18;
        this.dayInSelectionRangeContentColor = j19;
    }
}
