package androidx.compose.ui.text.font;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public final class TypefaceHelperMethodsApi28 {
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    private TypefaceHelperMethodsApi28() {
    }

    @DoNotInline
    @RequiresApi(28)
    public final android.graphics.Typeface create(android.graphics.Typeface typeface, int i, boolean z) {
        AbstractC4492zt.h(typeface, "typeface");
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(typeface, i, z);
        AbstractC4492zt.g(typefaceCreate, "create(typeface, finalFontWeight, finalFontStyle)");
        return typefaceCreate;
    }
}
