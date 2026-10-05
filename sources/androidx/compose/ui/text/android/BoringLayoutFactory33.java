package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC3939t8;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(33)
final class BoringLayoutFactory33 {
    public static final BoringLayoutFactory33 INSTANCE = new BoringLayoutFactory33();

    private BoringLayoutFactory33() {
    }

    @DoNotInline
    public static final BoringLayout create(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        AbstractC4492zt.h(metrics, "metrics");
        return AbstractC3939t8.a(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }

    @DoNotInline
    public static final BoringLayout.Metrics isBoring(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        AbstractC4492zt.h(textDirectionHeuristic, "textDir");
        return BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristic, true, null);
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout boringLayout) {
        AbstractC4492zt.h(boringLayout, "layout");
        return boringLayout.isFallbackLineSpacingEnabled();
    }
}
