package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.platform.AndroidDefaultTypeface;
import androidx.compose.ui.text.platform.AndroidFontListTypeface;
import androidx.compose.ui.text.platform.AndroidGenericFontFamilyTypeface;
import androidx.compose.ui.text.platform.AndroidTypefaceWrapper;
import defpackage.AD;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTypeface_androidKt {
    public static final FontFamily FontFamily(android.graphics.Typeface typeface) {
        AbstractC4492zt.h(typeface, "typeface");
        return FontFamilyKt.FontFamily(Typeface(typeface));
    }

    public static final Typeface Typeface(Context context, FontFamily fontFamily, List<C2020dG> list) {
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(fontFamily, "fontFamily");
        if (fontFamily instanceof FontListFontFamily) {
            return new AndroidFontListTypeface((FontListFontFamily) fontFamily, context, list, null, 8, null);
        }
        if (fontFamily instanceof GenericFontFamily) {
            return new AndroidGenericFontFamilyTypeface((GenericFontFamily) fontFamily);
        }
        if (fontFamily instanceof DefaultFontFamily) {
            return new AndroidDefaultTypeface();
        }
        if (fontFamily instanceof LoadedFontFamily) {
            return ((LoadedFontFamily) fontFamily).getTypeface();
        }
        throw new AD();
    }

    public static /* synthetic */ Typeface Typeface$default(Context context, FontFamily fontFamily, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return Typeface(context, fontFamily, list);
    }

    public static final Typeface Typeface(android.graphics.Typeface typeface) {
        AbstractC4492zt.h(typeface, "typeface");
        return new AndroidTypefaceWrapper(typeface);
    }
}
