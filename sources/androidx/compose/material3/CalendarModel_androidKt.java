package androidx.compose.material3;

import android.content.res.Configuration;
import android.os.Build;
import android.text.format.DateFormat;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import defpackage.AbstractC4492zt;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarModel_androidKt {
    @ExperimentalMaterial3Api
    public static final CalendarModel CalendarModel() {
        return Build.VERSION.SDK_INT >= 26 ? new CalendarModelImpl() : new LegacyCalendarModelImpl();
    }

    @Composable
    @ReadOnlyComposable
    @ExperimentalMaterial3Api
    public static final Locale defaultLocale(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(895332416, i, -1, "androidx.compose.material3.defaultLocale (CalendarModel.android.kt:72)");
        }
        Locale locale = ConfigurationCompat.getLocales((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).get(0);
        if (locale == null) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return locale;
    }

    @ExperimentalMaterial3Api
    public static final String formatWithSkeleton(long j, String str, Locale locale) {
        AbstractC4492zt.h(str, "skeleton");
        AbstractC4492zt.h(locale, "locale");
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, str);
        if (Build.VERSION.SDK_INT >= 26) {
            CalendarModelImpl.Companion companion = CalendarModelImpl.Companion;
            AbstractC4492zt.g(bestDateTimePattern, "pattern");
            return companion.formatWithPattern(j, bestDateTimePattern, locale);
        }
        LegacyCalendarModelImpl.Companion companion2 = LegacyCalendarModelImpl.Companion;
        AbstractC4492zt.g(bestDateTimePattern, "pattern");
        return companion2.formatWithPattern(j, bestDateTimePattern, locale);
    }

    public static /* synthetic */ String formatWithSkeleton$default(long j, String str, Locale locale, int i, Object obj) {
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "m epoch)\n * ");
        }
        return formatWithSkeleton(j, str, locale);
    }
}
