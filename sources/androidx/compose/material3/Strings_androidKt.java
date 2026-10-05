package androidx.compose.material3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import defpackage.AbstractC4492zt;
import defpackage.C2359hS;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Strings_androidKt {
    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: getString-NWtq2-8, reason: not valid java name */
    public static final String m1841getStringNWtq28(int i, Composer composer, int i2) {
        String string;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-176762646, i2, -1, "androidx.compose.material3.getString (Strings.android.kt:28)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m1774equalsimpl0(i, companion.m1821getNavigationMenuadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.navigation_menu);
            AbstractC4492zt.g(string, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1783getCloseDraweradMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.close_drawer);
            AbstractC4492zt.g(string, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1784getCloseSheetadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.close_sheet);
            AbstractC4492zt.g(string, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1816getDefaultErrorMessageadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.default_error_message);
            AbstractC4492zt.g(string, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1818getExposedDropdownMenuadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.dropdown_menu);
            AbstractC4492zt.g(string, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1824getSliderRangeStartadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.range_start);
            AbstractC4492zt.g(string, "resources.getString(R.string.range_start)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1823getSliderRangeEndadMyvUU())) {
            string = resources.getString(androidx.compose.ui.R.string.range_end);
            AbstractC4492zt.g(string, "resources.getString(R.string.range_end)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1817getDialogadMyvUU())) {
            string = resources.getString(R.string.dialog);
            AbstractC4492zt.g(string, "resources.getString(andr…aterial3.R.string.dialog)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1820getMenuExpandedadMyvUU())) {
            string = resources.getString(R.string.expanded);
            AbstractC4492zt.g(string, "resources.getString(andr…erial3.R.string.expanded)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1819getMenuCollapsedadMyvUU())) {
            string = resources.getString(R.string.collapsed);
            AbstractC4492zt.g(string, "resources.getString(andr…rial3.R.string.collapsed)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1825getSnackbarDismissadMyvUU())) {
            string = resources.getString(R.string.snackbar_dismiss);
            AbstractC4492zt.g(string, "resources.getString(\n   …nackbar_dismiss\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1822getSearchBarSearchadMyvUU())) {
            string = resources.getString(R.string.search_bar_search);
            AbstractC4492zt.g(string, "resources.getString(\n   …arch_bar_search\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1826getSuggestionsAvailableadMyvUU())) {
            string = resources.getString(R.string.suggestions_available);
            AbstractC4492zt.g(string, "resources.getString(andr…ng.suggestions_available)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1805getDatePickerTitleadMyvUU())) {
            string = resources.getString(R.string.date_picker_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …te_picker_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1793getDatePickerHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_picker_headline);
            AbstractC4492zt.g(string, "resources.getString(\n   …picker_headline\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1807getDatePickerYearPickerPaneTitleadMyvUU())) {
            string = resources.getString(R.string.date_picker_year_picker_pane_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …cker_pane_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1804getDatePickerSwitchToYearSelectionadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_year_selection);
            AbstractC4492zt.g(string, "resources.getString(\n   …_year_selection\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1800getDatePickerSwitchToDaySelectionadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_day_selection);
            AbstractC4492zt.g(string, "resources.getString(\n   …o_day_selection\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1802getDatePickerSwitchToNextMonthadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_next_month);
            AbstractC4492zt.g(string, "resources.getString(\n   …h_to_next_month\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1803getDatePickerSwitchToPreviousMonthadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_previous_month);
            AbstractC4492zt.g(string, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1795getDatePickerNavigateToYearDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_navigate_to_year_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …ear_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1794getDatePickerHeadlineDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_headline_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1796getDatePickerNoSelectionDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_no_selection_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …ion_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1806getDatePickerTodayDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_picker_today_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …day_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1798getDatePickerScrollToShowLaterYearsadMyvUU())) {
            string = resources.getString(R.string.date_picker_scroll_to_later_years);
            AbstractC4492zt.g(string, "resources.getString(\n   …_to_later_years\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1797getDatePickerScrollToShowEarlierYearsadMyvUU())) {
            string = resources.getString(R.string.date_picker_scroll_to_earlier_years);
            AbstractC4492zt.g(string, "resources.getString(\n   …o_earlier_years\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1792getDateInputTitleadMyvUU())) {
            string = resources.getString(R.string.date_input_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …ate_input_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1785getDateInputHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_input_headline);
            AbstractC4492zt.g(string, "resources.getString(\n   …_input_headline\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1790getDateInputLabeladMyvUU())) {
            string = resources.getString(R.string.date_input_label);
            AbstractC4492zt.g(string, "resources.getString(\n   …ate_input_label\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1786getDateInputHeadlineDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_input_headline_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …ine_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1791getDateInputNoInputDescriptionadMyvUU())) {
            string = resources.getString(R.string.date_input_no_input_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …put_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1788getDateInputInvalidNotAllowedadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_not_allowed);
            AbstractC4492zt.g(string, "resources.getString(\n   …lid_not_allowed\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1787getDateInputInvalidForPatternadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_for_pattern);
            AbstractC4492zt.g(string, "resources.getString(\n   …lid_for_pattern\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1789getDateInputInvalidYearRangeadMyvUU())) {
            string = resources.getString(R.string.date_input_invalid_year_range);
            AbstractC4492zt.g(string, "resources.getString(\n   …alid_year_range\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1799getDatePickerSwitchToCalendarModeadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_calendar_mode);
            AbstractC4492zt.g(string, "resources.getString(\n   …o_calendar_mode\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1801getDatePickerSwitchToInputModeadMyvUU())) {
            string = resources.getString(R.string.date_picker_switch_to_input_mode);
            AbstractC4492zt.g(string, "resources.getString(\n   …h_to_input_mode\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1815getDateRangePickerTitleadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …ge_picker_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1814getDateRangePickerStartHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_start_headline);
            AbstractC4492zt.g(string, "resources.getString(\n   …_start_headline\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1811getDateRangePickerEndHeadlineadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_end_headline);
            AbstractC4492zt.g(string, "resources.getString(\n   …er_end_headline\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1812getDateRangePickerScrollToShowNextMonthadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_scroll_to_next_month);
            AbstractC4492zt.g(string, "resources.getString(\n   …l_to_next_month\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1813getDateRangePickerScrollToShowPreviousMonthadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_scroll_to_previous_month);
            AbstractC4492zt.g(string, "resources.getString(\n   …_previous_month\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1810getDateRangePickerDayInRangeadMyvUU())) {
            string = resources.getString(R.string.date_range_picker_day_in_range);
            AbstractC4492zt.g(string, "resources.getString(\n   …er_day_in_range\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1809getDateRangeInputTitleadMyvUU())) {
            string = resources.getString(R.string.date_range_input_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …nge_input_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1808getDateRangeInputInvalidRangeInputadMyvUU())) {
            string = resources.getString(R.string.date_range_input_invalid_range_input);
            AbstractC4492zt.g(string, "resources.getString(\n   …lid_range_input\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1781getBottomSheetPaneTitleadMyvUU())) {
            string = resources.getString(R.string.m3c_bottom_sheet_pane_title);
            AbstractC4492zt.g(string, "resources.getString(\n   …heet_pane_title\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1779getBottomSheetDragHandleDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_drag_handle_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …dle_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1782getBottomSheetPartialExpandDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_collapse_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …pse_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1778getBottomSheetDismissDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_dismiss_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …iss_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1780getBottomSheetExpandDescriptionadMyvUU())) {
            string = resources.getString(R.string.bottom_sheet_expand_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …and_description\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1839getTooltipLongPressLabeladMyvUU())) {
            string = resources.getString(R.string.tooltip_long_press_label);
            AbstractC4492zt.g(string, "resources.getString(\n   …ong_press_label\n        )");
        } else if (Strings.m1774equalsimpl0(i, companion.m1828getTimePickerAMadMyvUU())) {
            string = resources.getString(R.string.time_picker_am);
            AbstractC4492zt.g(string, "resources.getString(\n   ….R.string.time_picker_am)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1837getTimePickerPMadMyvUU())) {
            string = resources.getString(R.string.time_picker_pm);
            AbstractC4492zt.g(string, "resources.getString(\n   ….R.string.time_picker_pm)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1838getTimePickerPeriodToggleadMyvUU())) {
            string = resources.getString(R.string.time_picker_period_toggle_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …eriod_toggle_description)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1834getTimePickerMinuteSelectionadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_selection);
            AbstractC4492zt.g(string, "resources.getString(\n   …_picker_minute_selection)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1830getTimePickerHourSelectionadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_selection);
            AbstractC4492zt.g(string, "resources.getString(\n   …me_picker_hour_selection)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1831getTimePickerHourSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_suffix);
            AbstractC4492zt.g(string, "resources.getString(\n   ….time_picker_hour_suffix)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1835getTimePickerMinuteSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_suffix);
            AbstractC4492zt.g(string, "resources.getString(\n   …ime_picker_minute_suffix)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1827getTimePicker24HourSuffixadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_24h_suffix);
            AbstractC4492zt.g(string, "resources.getString(\n   …e_picker_hour_24h_suffix)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1829getTimePickerHouradMyvUU())) {
            string = resources.getString(R.string.time_picker_hour);
            AbstractC4492zt.g(string, "resources.getString(\n   ….string.time_picker_hour)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1833getTimePickerMinuteadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute);
            AbstractC4492zt.g(string, "resources.getString(\n   …tring.time_picker_minute)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1832getTimePickerHourTextFieldadMyvUU())) {
            string = resources.getString(R.string.time_picker_hour_text_field);
            AbstractC4492zt.g(string, "resources.getString(\n   …e_picker_hour_text_field)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1836getTimePickerMinuteTextFieldadMyvUU())) {
            string = resources.getString(R.string.time_picker_minute_text_field);
            AbstractC4492zt.g(string, "resources.getString(\n   …picker_minute_text_field)");
        } else if (Strings.m1774equalsimpl0(i, companion.m1840getTooltipPaneDescriptionadMyvUU())) {
            string = resources.getString(R.string.tooltip_pane_description);
            AbstractC4492zt.g(string, "resources.getString(\n   …tooltip_pane_description)");
        } else {
            string = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: getString-iSCLEhQ, reason: not valid java name */
    public static final String m1842getStringiSCLEhQ(int i, Object[] objArr, Composer composer, int i2) {
        AbstractC4492zt.h(objArr, "formatArgs");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126124681, i2, -1, "androidx.compose.material3.getString (Strings.android.kt:204)");
        }
        String strM1841getStringNWtq28 = m1841getStringNWtq28(i, composer, i2 & 14);
        Locale locale = ConfigurationCompat.getLocales((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        C2359hS c2359hS = C2359hS.a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str = String.format(locale, strM1841getStringNWtq28, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC4492zt.g(str, "format(locale, format, *args)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return str;
    }
}
