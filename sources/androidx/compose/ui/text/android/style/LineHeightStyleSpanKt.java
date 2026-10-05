package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyleSpanKt {
    public static final int lineHeight(Paint.FontMetricsInt fontMetricsInt) {
        AbstractC4492zt.h(fontMetricsInt, "<this>");
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }
}
