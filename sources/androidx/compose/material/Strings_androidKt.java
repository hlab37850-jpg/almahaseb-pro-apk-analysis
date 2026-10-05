package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Strings_androidKt {
    @Composable
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m1225getString4foXLRw(int i, Composer composer, int i2) {
        String string;
        composer.startReplaceableGroup(-726638443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m1214equalsimpl0(i, companion.m1222getNavigationMenuUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.navigation_menu);
            AbstractC4492zt.g(string, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1218getCloseDrawerUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.close_drawer);
            AbstractC4492zt.g(string, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1219getCloseSheetUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.close_sheet);
            AbstractC4492zt.g(string, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1220getDefaultErrorMessageUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.default_error_message);
            AbstractC4492zt.g(string, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1221getExposedDropdownMenuUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.dropdown_menu);
            AbstractC4492zt.g(string, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1224getSliderRangeStartUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.range_start);
            AbstractC4492zt.g(string, "resources.getString(R.string.range_start)");
        } else if (Strings.m1214equalsimpl0(i, companion.m1223getSliderRangeEndUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.range_end);
            AbstractC4492zt.g(string, "resources.getString(R.string.range_end)");
        } else {
            string = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return string;
    }
}
