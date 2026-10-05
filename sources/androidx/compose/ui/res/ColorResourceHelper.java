package androidx.compose.ui.res;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.ColorKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class ColorResourceHelper {
    public static final ColorResourceHelper INSTANCE = new ColorResourceHelper();

    private ColorResourceHelper() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: getColor-WaAFU9c, reason: not valid java name */
    public final long m4533getColorWaAFU9c(Context context, @ColorRes int i) {
        AbstractC4492zt.h(context, "context");
        return ColorKt.Color(context.getResources().getColor(i, context.getTheme()));
    }
}
