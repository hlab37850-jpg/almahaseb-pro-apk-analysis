package androidx.compose.foundation.text.modifiers;

import defpackage.AbstractC3880sS;

/* JADX INFO: loaded from: classes.dex */
public final class MinLinesConstrainerKt {
    private static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement;
    private static final String TwoLineTextReplacement;

    static {
        String strT = AbstractC3880sS.t("H", 10);
        EmptyTextReplacement = strT;
        TwoLineTextReplacement = strT + '\n' + strT;
    }
}
