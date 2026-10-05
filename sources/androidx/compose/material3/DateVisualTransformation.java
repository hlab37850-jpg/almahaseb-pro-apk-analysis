package androidx.compose.material3;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class DateVisualTransformation implements VisualTransformation {
    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator;
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;

    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1] */
    public DateVisualTransformation(DateInputFormat dateInputFormat) {
        AbstractC4492zt.h(dateInputFormat, "dateInputFormat");
        this.dateInputFormat = dateInputFormat;
        this.firstDelimiterOffset = AbstractC3961tS.Q(dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, false, 6, null);
        this.secondDelimiterOffset = AbstractC3961tS.W(dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, false, 6, null);
        this.dateFormatLength = dateInputFormat.getPatternWithoutDelimiters().length();
        this.dateOffsetTranslator = new OffsetMapping() { // from class: androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1
            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int originalToTransformed(int i) {
                if (i < this.this$0.firstDelimiterOffset) {
                    return i;
                }
                if (i < this.this$0.secondDelimiterOffset) {
                    return i + 1;
                }
                if (i > this.this$0.dateFormatLength) {
                    i = this.this$0.dateFormatLength;
                }
                return i + 2;
            }

            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int transformedToOriginal(int i) {
                if (i <= this.this$0.firstDelimiterOffset - 1) {
                    return i;
                }
                if (i <= this.this$0.secondDelimiterOffset - 1) {
                    return i - 1;
                }
                return i <= this.this$0.dateFormatLength + 1 ? i - 2 : this.this$0.dateFormatLength;
            }
        };
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString annotatedString) {
        AbstractC4492zt.h(annotatedString, "text");
        int i = 0;
        String strW0 = annotatedString.getText().length() > this.dateFormatLength ? AbstractC3961tS.w0(annotatedString.getText(), AbstractC3871sJ.s(0, this.dateFormatLength)) : annotatedString.getText();
        String str = "";
        int i2 = 0;
        while (i < strW0.length()) {
            int i3 = i2 + 1;
            String str2 = str + strW0.charAt(i);
            if (i3 == this.firstDelimiterOffset || i2 + 2 == this.secondDelimiterOffset) {
                str = str2 + this.dateInputFormat.getDelimiter();
            } else {
                str = str2;
            }
            i++;
            i2 = i3;
        }
        return new TransformedText(new AnnotatedString(str, null, null, 6, null), this.dateOffsetTranslator);
    }
}
