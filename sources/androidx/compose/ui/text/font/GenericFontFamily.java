package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class GenericFontFamily extends SystemFontFamily {
    public static final int $stable = 0;
    private final String fontFamilyName;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericFontFamily(String str, String str2) {
        super(null);
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(str2, "fontFamilyName");
        this.name = str;
        this.fontFamilyName = str2;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.fontFamilyName;
    }
}
