package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class Paint29 {
    public static final Paint29 INSTANCE = new Paint29();

    private Paint29() {
    }

    @DoNotInline
    public static final void getTextBounds(Paint paint, CharSequence charSequence, int i, int i2, Rect rect) {
        AbstractC4492zt.h(paint, "paint");
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(rect, "rect");
        paint.getTextBounds(charSequence, i, i2, rect);
    }
}
