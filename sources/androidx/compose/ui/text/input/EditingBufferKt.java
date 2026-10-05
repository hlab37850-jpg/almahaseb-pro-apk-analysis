package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* JADX INFO: loaded from: classes.dex */
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4846updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM4701getLengthimpl;
        int iM4703getMinimpl = TextRange.m4703getMinimpl(j);
        int iM4702getMaximpl = TextRange.m4702getMaximpl(j);
        if (TextRange.m4707intersects5zctL8(j2, j)) {
            if (TextRange.m4695contains5zctL8(j2, j)) {
                iM4703getMinimpl = TextRange.m4703getMinimpl(j2);
                iM4702getMaximpl = iM4703getMinimpl;
            } else {
                if (TextRange.m4695contains5zctL8(j, j2)) {
                    iM4701getLengthimpl = TextRange.m4701getLengthimpl(j2);
                } else if (TextRange.m4696containsimpl(j2, iM4703getMinimpl)) {
                    iM4703getMinimpl = TextRange.m4703getMinimpl(j2);
                    iM4701getLengthimpl = TextRange.m4701getLengthimpl(j2);
                } else {
                    iM4702getMaximpl = TextRange.m4703getMinimpl(j2);
                }
                iM4702getMaximpl -= iM4701getLengthimpl;
            }
        } else if (iM4702getMaximpl > TextRange.m4703getMinimpl(j2)) {
            iM4703getMinimpl -= TextRange.m4701getLengthimpl(j2);
            iM4701getLengthimpl = TextRange.m4701getLengthimpl(j2);
            iM4702getMaximpl -= iM4701getLengthimpl;
        }
        return TextRangeKt.TextRange(iM4703getMinimpl, iM4702getMaximpl);
    }
}
