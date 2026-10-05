package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class ValidatingOffsetMapping implements OffsetMapping {
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public ValidatingOffsetMapping(OffsetMapping offsetMapping, int i, int i2) {
        AbstractC4492zt.h(offsetMapping, "delegate");
        this.delegate = offsetMapping;
        this.originalLength = i;
        this.transformedLength = i2;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int i) {
        int iOriginalToTransformed = this.delegate.originalToTransformed(i);
        if (iOriginalToTransformed >= 0 && iOriginalToTransformed <= this.transformedLength) {
            return iOriginalToTransformed;
        }
        throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i + " -> " + iOriginalToTransformed + " is not in range of transformed text [0, " + this.transformedLength + ']').toString());
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int i) {
        int iTransformedToOriginal = this.delegate.transformedToOriginal(i);
        if (iTransformedToOriginal >= 0 && iTransformedToOriginal <= this.originalLength) {
            return iTransformedToOriginal;
        }
        throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + i + " -> " + iTransformedToOriginal + " is not in range of original text [0, " + this.originalLength + ']').toString());
    }
}
