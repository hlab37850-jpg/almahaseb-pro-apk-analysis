package androidx.compose.ui.text;

import defpackage.AbstractC4492zt;
import java.text.BreakIterator;

/* JADX INFO: loaded from: classes.dex */
public final class JvmCharHelpers_androidKt {
    public static final int findFollowingBreak(String str, int i) {
        AbstractC4492zt.h(str, "<this>");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.following(i);
    }

    public static final int findPrecedingBreak(String str, int i) {
        AbstractC4492zt.h(str, "<this>");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }
}
