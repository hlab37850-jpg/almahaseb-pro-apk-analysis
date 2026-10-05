package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
public final class StaticLayoutFactory {
    public static final int $stable;
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();
    private static final StaticLayoutFactoryImpl delegate;

    static {
        delegate = Build.VERSION.SDK_INT >= 23 ? new StaticLayoutFactory23() : new StaticLayoutFactoryDefault();
        $stable = 8;
    }

    private StaticLayoutFactory() {
    }

    public final StaticLayout create(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, @IntRange(from = 0) int i4, TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i5, @FloatRange(from = 0.0d) float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        AbstractC4492zt.h(textDirectionHeuristic, "textDir");
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        return delegate.create(new StaticLayoutParams(charSequence, i, i2, textPaint, i3, textDirectionHeuristic, alignment, i4, truncateAt, i5, f, f2, i6, z, z2, i7, i8, i9, i10, iArr, iArr2));
    }

    public final boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout, boolean z) {
        AbstractC4492zt.h(staticLayout, "layout");
        return delegate.isFallbackLineSpacingEnabled(staticLayout, z);
    }
}
