package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint textPaint, float f) {
        AbstractC4492zt.h(textPaint, "<this>");
        if (Float.isNaN(f)) {
            return;
        }
        textPaint.setAlpha(AbstractC1210aB.c(AbstractC3871sJ.k(f, 0.0f, 1.0f) * 255));
    }
}
