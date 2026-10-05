package com.itextpdf.text.pdf.parser;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleTextExtractionStrategy implements TextExtractionStrategy {
    private Vector lastEnd;
    private Vector lastStart;
    private final StringBuffer result = new StringBuffer();

    public final void appendTextChunk(CharSequence charSequence) {
        this.result.append(charSequence);
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return this.result.toString();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0046  */
    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        StringBuffer stringBuffer;
        boolean z = this.result.length() == 0;
        LineSegment baseline = textRenderInfo.getBaseline();
        Vector startPoint = baseline.getStartPoint();
        Vector endPoint = baseline.getEndPoint();
        if (!z) {
            Vector vector = this.lastStart;
            Vector vector2 = this.lastEnd;
            if (vector2.subtract(vector).cross(vector.subtract(startPoint)).lengthSquared() / vector2.subtract(vector).lengthSquared() > 1.0f) {
                appendTextChunk(StringUtilities.LF);
            } else if (!z) {
                stringBuffer = this.result;
                if (stringBuffer.charAt(stringBuffer.length() - 1) != ' ' && textRenderInfo.getText().length() > 0 && textRenderInfo.getText().charAt(0) != ' ' && this.lastEnd.subtract(startPoint).length() > textRenderInfo.getSingleSpaceWidth() / 2.0f) {
                    appendTextChunk(" ");
                }
            }
        } else if (!z) {
            stringBuffer = this.result;
            if (stringBuffer.charAt(stringBuffer.length() - 1) != ' ') {
                appendTextChunk(" ");
            }
        }
        appendTextChunk(textRenderInfo.getText());
        this.lastStart = startPoint;
        this.lastEnd = endPoint;
    }
}
