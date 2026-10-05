package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class AndroidFontResourceLoaderHelper {
    public static final AndroidFontResourceLoaderHelper INSTANCE = new AndroidFontResourceLoaderHelper();

    private AndroidFontResourceLoaderHelper() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final Typeface create(Context context, int i) {
        AbstractC4492zt.h(context, "context");
        Typeface font = context.getResources().getFont(i);
        AbstractC4492zt.g(font, "context.resources.getFont(resourceId)");
        return font;
    }
}
