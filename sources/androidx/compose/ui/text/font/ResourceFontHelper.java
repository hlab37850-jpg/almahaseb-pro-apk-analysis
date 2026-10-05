package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class ResourceFontHelper {
    public static final ResourceFontHelper INSTANCE = new ResourceFontHelper();

    private ResourceFontHelper() {
    }

    @DoNotInline
    public final android.graphics.Typeface load(Context context, ResourceFont resourceFont) {
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(resourceFont, "font");
        android.graphics.Typeface font = context.getResources().getFont(resourceFont.getResId());
        AbstractC4492zt.g(font, "context.resources.getFont(font.resId)");
        return font;
    }
}
