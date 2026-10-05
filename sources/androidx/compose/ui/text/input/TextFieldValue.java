package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextFieldValue {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(TextFieldValue$Companion$Saver$1.INSTANCE, TextFieldValue$Companion$Saver$2.INSTANCE);
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.Saver;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, j, textRange);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m4917copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m4919copy3r_uNRQ(annotatedString, j, textRange);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m4919copy3r_uNRQ(AnnotatedString annotatedString, long j, TextRange textRange) {
        AbstractC4492zt.h(annotatedString, "annotatedString");
        return new TextFieldValue(annotatedString, j, textRange, (AbstractC0419Di) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return TextRange.m4698equalsimpl0(this.selection, textFieldValue.selection) && AbstractC4492zt.d(this.composition, textFieldValue.composition) && AbstractC4492zt.d(this.annotatedString, textFieldValue.annotatedString);
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m4921getCompositionMzsxiRA() {
        return this.composition;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m4922getSelectiond9O1mEE() {
        return this.selection;
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int iHashCode = ((this.annotatedString.hashCode() * 31) + TextRange.m4706hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return iHashCode + (textRange != null ? TextRange.m4706hashCodeimpl(textRange.m4709unboximpl()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + ((Object) TextRange.m4708toStringimpl(this.selection)) + ", composition=" + this.composition + ')';
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, AbstractC0419Di abstractC0419Di) {
        this(str, j, textRange);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m4920copy3r_uNRQ(String str, long j, TextRange textRange) {
        AbstractC4492zt.h(str, "text");
        AbstractC0419Di abstractC0419Di = null;
        return new TextFieldValue(new AnnotatedString(str, null, null, 6, abstractC0419Di), j, textRange, abstractC0419Di);
    }

    private TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange) {
        AbstractC4492zt.h(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        this.selection = TextRangeKt.m4711coerceIn8ffj60Q(j, 0, getText().length());
        this.composition = textRange != null ? TextRange.m4693boximpl(TextRangeKt.m4711coerceIn8ffj60Q(textRange.m4709unboximpl(), 0, getText().length())) : null;
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m4918copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j, TextRange textRange, int i, Object obj) {
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        if ((i & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m4920copy3r_uNRQ(str, j, textRange);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange, int i, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, (i & 2) != 0 ? TextRange.Companion.m4710getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (AbstractC0419Di) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j, TextRange textRange, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.Companion.m4710getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (AbstractC0419Di) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private TextFieldValue(String str, long j, TextRange textRange) {
        AbstractC4492zt.h(str, "text");
        AbstractC0419Di abstractC0419Di = null;
        this(new AnnotatedString(str, null, null, 6, abstractC0419Di), j, textRange, abstractC0419Di);
    }
}
