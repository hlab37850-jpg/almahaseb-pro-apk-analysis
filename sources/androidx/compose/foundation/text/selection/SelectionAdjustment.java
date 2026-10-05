package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public interface SelectionAdjustment {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
                return j;
            }
        };
        private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
                if (TextRange.m4699getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(textLayoutResult.getLayoutInput().getText().getText(), TextRange.m4705getStartimpl(j), AbstractC3961tS.L(textLayoutResult.getLayoutInput().getText()), z, textRange != null ? TextRange.m4704getReversedimpl(textRange.m4709unboximpl()) : false);
                }
                return j;
            }
        };
        private static final SelectionAdjustment Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
                return SelectionAdjustment.Companion.$$INSTANCE.m895adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
            }
        };
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
                return SelectionAdjustment.Companion.$$INSTANCE.m895adjustByBoundaryDvylE(textLayoutResult, j, new SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(textLayoutResult.getLayoutInput().getText()));
            }
        };
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$CharacterWithWordAccelerate$1
            private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
                long jM4679getWordBoundaryjx7JFs = textLayoutResult.m4679getWordBoundaryjx7JFs(i);
                return i == TextRange.m4705getStartimpl(jM4679getWordBoundaryjx7JFs) || i == TextRange.m4700getEndimpl(jM4679getWordBoundaryjx7JFs);
            }

            private final boolean isExpanding(int i, int i2, boolean z, boolean z2) {
                if (i2 == -1) {
                    return true;
                }
                if (i == i2) {
                    return false;
                }
                if (z ^ z2) {
                    if (i < i2) {
                        return true;
                    }
                } else if (i > i2) {
                    return true;
                }
                return false;
            }

            private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, boolean z, boolean z2) {
                long jM4679getWordBoundaryjx7JFs = textLayoutResult.m4679getWordBoundaryjx7JFs(i);
                int iM4705getStartimpl = textLayoutResult.getLineForOffset(TextRange.m4705getStartimpl(jM4679getWordBoundaryjx7JFs)) == i2 ? TextRange.m4705getStartimpl(jM4679getWordBoundaryjx7JFs) : textLayoutResult.getLineStart(i2);
                int iM4700getEndimpl = textLayoutResult.getLineForOffset(TextRange.m4700getEndimpl(jM4679getWordBoundaryjx7JFs)) == i2 ? TextRange.m4700getEndimpl(jM4679getWordBoundaryjx7JFs) : TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, null);
                if (iM4705getStartimpl == i3) {
                    return iM4700getEndimpl;
                }
                if (iM4700getEndimpl == i3) {
                    return iM4705getStartimpl;
                }
                int i4 = (iM4705getStartimpl + iM4700getEndimpl) / 2;
                if (z ^ z2) {
                    if (i <= i4) {
                        return iM4705getStartimpl;
                    }
                } else if (i < i4) {
                    return iM4705getStartimpl;
                }
                return iM4700getEndimpl;
            }

            private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, int i4, boolean z, boolean z2) {
                if (i == i2) {
                    return i3;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(i);
                if (lineForOffset != textLayoutResult.getLineForOffset(i3)) {
                    return snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2);
                }
                return (isExpanding(i, i2, z, z2) && isAtWordBoundary(textLayoutResult, i3)) ? snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2) : i;
            }

            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
                int iUpdateSelectionBoundary;
                int iUpdateSelectionBoundary2;
                AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
                if (textRange == null) {
                    return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo893adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
                }
                if (TextRange.m4699getCollapsedimpl(j)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(textLayoutResult.getLayoutInput().getText().getText(), TextRange.m4705getStartimpl(j), AbstractC3961tS.L(textLayoutResult.getLayoutInput().getText()), z, TextRange.m4704getReversedimpl(textRange.m4709unboximpl()));
                }
                if (z) {
                    iUpdateSelectionBoundary2 = updateSelectionBoundary(textLayoutResult, TextRange.m4705getStartimpl(j), i, TextRange.m4705getStartimpl(textRange.m4709unboximpl()), TextRange.m4700getEndimpl(j), true, TextRange.m4704getReversedimpl(j));
                    iUpdateSelectionBoundary = TextRange.m4700getEndimpl(j);
                } else {
                    int iM4705getStartimpl = TextRange.m4705getStartimpl(j);
                    iUpdateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m4700getEndimpl(j), i, TextRange.m4700getEndimpl(textRange.m4709unboximpl()), TextRange.m4705getStartimpl(j), false, TextRange.m4704getReversedimpl(j));
                    iUpdateSelectionBoundary2 = iM4705getStartimpl;
                }
                return TextRangeKt.TextRange(iUpdateSelectionBoundary2, iUpdateSelectionBoundary);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: adjustByBoundary--Dv-ylE, reason: not valid java name */
        public final long m895adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j, InterfaceC3750qp interfaceC3750qp) {
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                return TextRange.Companion.m4710getZerod9O1mEE();
            }
            int iL = AbstractC3961tS.L(textLayoutResult.getLayoutInput().getText());
            long jM4709unboximpl = ((TextRange) interfaceC3750qp.invoke(Integer.valueOf(AbstractC3871sJ.l(TextRange.m4705getStartimpl(j), 0, iL)))).m4709unboximpl();
            long jM4709unboximpl2 = ((TextRange) interfaceC3750qp.invoke(Integer.valueOf(AbstractC3871sJ.l(TextRange.m4700getEndimpl(j), 0, iL)))).m4709unboximpl();
            return TextRangeKt.TextRange(TextRange.m4704getReversedimpl(j) ? TextRange.m4700getEndimpl(jM4709unboximpl) : TextRange.m4705getStartimpl(jM4709unboximpl), TextRange.m4704getReversedimpl(j) ? TextRange.m4705getStartimpl(jM4709unboximpl2) : TextRange.m4700getEndimpl(jM4709unboximpl2));
        }

        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        public final SelectionAdjustment getNone() {
            return None;
        }

        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        public final SelectionAdjustment getWord() {
            return Word;
        }
    }

    /* JADX INFO: renamed from: adjust-ZXO7KMw, reason: not valid java name */
    long mo893adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange);
}
