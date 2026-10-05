package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class EditingBuffer {
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, AbstractC0419Di abstractC0419Di) {
        this(annotatedString, j);
    }

    private final void setSelectionEnd(int i) {
        if (i >= 0) {
            this.selectionEnd = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i).toString());
    }

    private final void setSelectionStart(int i) {
        if (i >= 0) {
            this.selectionStart = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i).toString());
    }

    public final void cancelComposition$ui_text_release() {
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int i, int i2) {
        long jTextRange = TextRangeKt.TextRange(i, i2);
        this.gapBuffer.replace(i, i2, "");
        long jM4846updateRangeAfterDeletepWDy79M = EditingBufferKt.m4846updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m4703getMinimpl(jM4846updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m4702getMaximpl(jM4846updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text_release()) {
            long jM4846updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m4846updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m4699getCollapsedimpl(jM4846updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.m4703getMinimpl(jM4846updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m4702getMaximpl(jM4846updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text_release(int i) {
        return this.gapBuffer.get(i);
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m4844getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m4693boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    public final int getCompositionEnd$ui_text_release() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m4845getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text_release() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int i, int i2, AnnotatedString annotatedString) {
        AbstractC4492zt.h(annotatedString, "text");
        replace$ui_text_release(i, i2, annotatedString.getText());
    }

    public final void setComposition$ui_text_release(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i < i2) {
            this.compositionStart = i;
            this.compositionEnd = i2;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
    }

    public final void setCursor$ui_text_release(int i) {
        setSelection$ui_text_release(i, i);
    }

    public final void setSelection$ui_text_release(int i, int i2) {
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i <= i2) {
            setSelectionStart(i);
            setSelectionEnd(i2);
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public /* synthetic */ EditingBuffer(String str, long j, AbstractC0419Di abstractC0419Di) {
        this(str, j);
    }

    public final void replace$ui_text_release(int i, int i2, String str) {
        AbstractC4492zt.h(str, "text");
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i <= i2) {
            this.gapBuffer.replace(i, i2, str);
            setSelectionStart(str.length() + i);
            setSelectionEnd(i + str.length());
            this.compositionStart = -1;
            this.compositionEnd = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        AbstractC4492zt.h(annotatedString, "text");
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m4703getMinimpl(j);
        this.selectionEnd = TextRange.m4702getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM4703getMinimpl = TextRange.m4703getMinimpl(j);
        int iM4702getMaximpl = TextRange.m4702getMaximpl(j);
        if (iM4703getMinimpl >= 0 && iM4703getMinimpl <= annotatedString.length()) {
            if (iM4702getMaximpl < 0 || iM4702getMaximpl > annotatedString.length()) {
                throw new IndexOutOfBoundsException("end (" + iM4702getMaximpl + ") offset is outside of text region " + annotatedString.length());
            }
            if (iM4703getMinimpl <= iM4702getMaximpl) {
                return;
            }
            throw new IllegalArgumentException("Do not set reversed range: " + iM4703getMinimpl + " > " + iM4702getMaximpl);
        }
        throw new IndexOutOfBoundsException("start (" + iM4703getMinimpl + ") offset is outside of text region " + annotatedString.length());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private EditingBuffer(String str, long j) {
        this(new AnnotatedString(str, null, null, 6, null), j, (AbstractC0419Di) null);
        AbstractC4492zt.h(str, "text");
    }
}
