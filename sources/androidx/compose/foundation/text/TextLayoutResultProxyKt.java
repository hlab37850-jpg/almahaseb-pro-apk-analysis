package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m847coerceIn3MmeM6k(long j, Rect rect) {
        float right;
        float bottom;
        if (Offset.m2798getXimpl(j) < rect.getLeft()) {
            right = rect.getLeft();
        } else {
            right = Offset.m2798getXimpl(j) > rect.getRight() ? rect.getRight() : Offset.m2798getXimpl(j);
        }
        if (Offset.m2799getYimpl(j) < rect.getTop()) {
            bottom = rect.getTop();
        } else {
            bottom = Offset.m2799getYimpl(j) > rect.getBottom() ? rect.getBottom() : Offset.m2799getYimpl(j);
        }
        return OffsetKt.Offset(right, bottom);
    }
}
