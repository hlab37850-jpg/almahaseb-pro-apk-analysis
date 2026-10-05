package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public class StaticTextSelectionParams {
    public static final Companion Companion = new Companion(null);
    private static final StaticTextSelectionParams Empty = new StaticTextSelectionParams(null, null);
    private final LayoutCoordinates layoutCoordinates;
    private final TextLayoutResult textLayoutResult;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final StaticTextSelectionParams getEmpty() {
            return StaticTextSelectionParams.Empty;
        }

        private Companion() {
        }
    }

    public StaticTextSelectionParams(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        this.layoutCoordinates = layoutCoordinates;
        this.textLayoutResult = textLayoutResult;
    }

    public static /* synthetic */ StaticTextSelectionParams copy$default(StaticTextSelectionParams staticTextSelectionParams, LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            layoutCoordinates = staticTextSelectionParams.layoutCoordinates;
        }
        if ((i & 2) != 0) {
            textLayoutResult = staticTextSelectionParams.textLayoutResult;
        }
        return staticTextSelectionParams.copy(layoutCoordinates, textLayoutResult);
    }

    public final StaticTextSelectionParams copy(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        return new StaticTextSelectionParams(layoutCoordinates, textLayoutResult);
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public Path getPathForRange(int i, int i2) {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return textLayoutResult.getPathForRange(i, i2);
        }
        return null;
    }

    public boolean getShouldClip() {
        TextLayoutInput layoutInput;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        TextOverflow textOverflowM5103boximpl = (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : TextOverflow.m5103boximpl(layoutInput.m4674getOverflowgIe3tQ8());
        int iM5115getVisiblegIe3tQ8 = TextOverflow.Companion.m5115getVisiblegIe3tQ8();
        if (textOverflowM5103boximpl == null) {
            return false;
        }
        return TextOverflow.m5106equalsimpl0(textOverflowM5103boximpl.m5109unboximpl(), iM5115getVisiblegIe3tQ8);
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }
}
