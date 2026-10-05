package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.InternalPlatformTextApi;
import defpackage.AbstractC4492zt;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class WordBoundary {
    private final WordIterator wordIterator;

    public WordBoundary(Locale locale, CharSequence charSequence) {
        AbstractC4492zt.h(locale, "locale");
        AbstractC4492zt.h(charSequence, "text");
        this.wordIterator = new WordIterator(charSequence, 0, charSequence.length(), locale);
    }

    public final int getWordEnd(int i) {
        int punctuationEnd = this.wordIterator.isAfterPunctuation(this.wordIterator.nextBoundary(i)) ? this.wordIterator.getPunctuationEnd(i) : this.wordIterator.getNextWordEndOnTwoWordBoundary(i);
        return punctuationEnd == -1 ? i : punctuationEnd;
    }

    public final int getWordStart(int i) {
        int punctuationBeginning = this.wordIterator.isOnPunctuation(this.wordIterator.prevBoundary(i)) ? this.wordIterator.getPunctuationBeginning(i) : this.wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i);
        return punctuationBeginning == -1 ? i : punctuationBeginning;
    }
}
