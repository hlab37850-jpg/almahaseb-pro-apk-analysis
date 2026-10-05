package defpackage;

import androidx.compose.ui.platform.OpenEndRange;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class QE {
    public static boolean a(OpenEndRange openEndRange, Comparable comparable) {
        AbstractC4492zt.h(comparable, "value");
        return comparable.compareTo(openEndRange.getStart()) >= 0 && comparable.compareTo(openEndRange.getEndExclusive()) < 0;
    }

    public static boolean b(OpenEndRange openEndRange) {
        return openEndRange.getStart().compareTo(openEndRange.getEndExclusive()) >= 0;
    }
}
