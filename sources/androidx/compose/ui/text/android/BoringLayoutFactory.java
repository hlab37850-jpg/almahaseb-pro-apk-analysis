package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class BoringLayoutFactory {
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final BoringLayout create(CharSequence charSequence, TextPaint textPaint, int i, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        AbstractC4492zt.h(metrics, "metrics");
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i2 >= 0) {
            return Build.VERSION.SDK_INT >= 33 ? BoringLayoutFactory33.create(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, z2, truncateAt, i2) : BoringLayoutFactoryDefault.create(charSequence, textPaint, i, alignment, 1.0f, 0.0f, metrics, z, truncateAt, i2);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final boolean isFallbackLineSpacingEnabled(BoringLayout boringLayout) {
        AbstractC4492zt.h(boringLayout, "layout");
        if (Build.VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.INSTANCE.isFallbackLineSpacingEnabled(boringLayout);
        }
        return false;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final BoringLayout.Metrics measure(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        AbstractC4492zt.h(textDirectionHeuristic, "textDir");
        return Build.VERSION.SDK_INT >= 33 ? BoringLayoutFactory33.isBoring(charSequence, textPaint, textDirectionHeuristic) : BoringLayoutFactoryDefault.isBoring(charSequence, textPaint, textDirectionHeuristic);
    }
}
