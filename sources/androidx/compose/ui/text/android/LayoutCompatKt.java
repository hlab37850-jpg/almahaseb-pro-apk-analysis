package androidx.compose.ui.text.android;

import android.text.Layout;
import androidx.annotation.IntRange;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutCompatKt {
    @InternalPlatformTextApi
    public static final int getLineForOffset(Layout layout, @IntRange(from = 0) int i, boolean z) {
        AbstractC4492zt.h(layout, "<this>");
        if (i <= 0) {
            return 0;
        }
        if (i >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int lineStart = layout.getLineStart(lineForOffset);
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (lineStart != i && lineEnd != i) {
            return lineForOffset;
        }
        if (lineStart == i) {
            return z ? lineForOffset - 1 : lineForOffset;
        }
        return z ? lineForOffset : lineForOffset + 1;
    }
}
