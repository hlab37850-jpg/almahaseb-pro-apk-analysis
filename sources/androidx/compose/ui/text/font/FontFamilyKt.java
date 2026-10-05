package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;
import defpackage.Q5;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyKt {
    @Stable
    public static final FontFamily FontFamily(List<? extends Font> list) {
        AbstractC4492zt.h(list, "fonts");
        return new FontListFontFamily(list);
    }

    @Stable
    public static final FontFamily FontFamily(Font... fontArr) {
        AbstractC4492zt.h(fontArr, "fonts");
        return new FontListFontFamily(Q5.c(fontArr));
    }

    @Stable
    public static final FontFamily FontFamily(Typeface typeface) {
        AbstractC4492zt.h(typeface, "typeface");
        return new LoadedFontFamily(typeface);
    }
}
