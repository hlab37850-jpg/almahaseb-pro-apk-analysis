package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class VerticalText {
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    protected PdfChunk currentStandbyChunk;
    protected float height;
    protected float leading;
    protected int maxLines;
    protected String splittedChunkText;
    protected float startX;
    protected float startY;
    protected PdfContentByte text;
    protected ArrayList<PdfChunk> chunks = new ArrayList<>();
    protected int alignment = 0;
    protected int currentChunkMarker = -1;
    private Float curCharSpace = Float.valueOf(0.0f);

    public VerticalText(PdfContentByte pdfContentByte) {
        this.text = pdfContentByte;
    }

    public void addText(Phrase phrase) {
        Iterator<Chunk> it = phrase.getChunks().iterator();
        while (it.hasNext()) {
            this.chunks.add(new PdfChunk(it.next(), (PdfAction) null));
        }
    }

    public PdfLine createLine(float f) {
        if (this.chunks.isEmpty()) {
            return null;
        }
        this.splittedChunkText = null;
        this.currentStandbyChunk = null;
        PdfLine pdfLine = new PdfLine(0.0f, f, this.alignment, 0.0f);
        int i = 0;
        while (true) {
            this.currentChunkMarker = i;
            if (this.currentChunkMarker >= this.chunks.size()) {
                return pdfLine;
            }
            PdfChunk pdfChunk = this.chunks.get(this.currentChunkMarker);
            String string = pdfChunk.toString();
            PdfChunk pdfChunkAdd = pdfLine.add(pdfChunk);
            this.currentStandbyChunk = pdfChunkAdd;
            if (pdfChunkAdd != null) {
                this.splittedChunkText = pdfChunk.toString();
                pdfChunk.setValue(string);
                return pdfLine;
            }
            i = this.currentChunkMarker + 1;
        }
    }

    public int getAlignment() {
        return this.alignment;
    }

    public float getHeight() {
        return this.height;
    }

    public float getLeading() {
        return this.leading;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public float getOriginX() {
        return this.startX;
    }

    public float getOriginY() {
        return this.startY;
    }

    public int go() {
        return go(false);
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public void setMaxLines(int i) {
        this.maxLines = i;
    }

    public void setOrigin(float f, float f2) {
        this.startX = f;
        this.startY = f2;
    }

    public void setVerticalLayout(float f, float f2, float f3, int i, float f4) {
        this.startX = f;
        this.startY = f2;
        this.height = f3;
        this.maxLines = i;
        setLeading(f4);
    }

    public void shortenChunkArray() {
        int i = this.currentChunkMarker;
        if (i < 0) {
            return;
        }
        if (i >= this.chunks.size()) {
            this.chunks.clear();
            return;
        }
        this.chunks.get(this.currentChunkMarker).setValue(this.splittedChunkText);
        this.chunks.set(this.currentChunkMarker, this.currentStandbyChunk);
        for (int i2 = this.currentChunkMarker - 1; i2 >= 0; i2--) {
            this.chunks.remove(i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0006 A[SYNTHETIC] */
    public void writeLine(PdfLine pdfLine, PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2) {
        int iIntValue;
        float fFloatValue;
        Float f;
        BaseColor baseColor = null;
        PdfFont pdfFontFont = null;
        for (PdfChunk pdfChunk : pdfLine) {
            if (!pdfChunk.isImage() && pdfChunk.font().compareTo(pdfFontFont) != 0) {
                pdfFontFont = pdfChunk.font();
                pdfContentByte.setFontAndSize(pdfFontFont.getFont(), pdfFontFont.size());
            }
            Object[] objArr = (Object[]) pdfChunk.getAttribute(Chunk.TEXTRENDERMODE);
            BaseColor baseColorColor = pdfChunk.color();
            if (objArr != null) {
                iIntValue = ((Integer) objArr[0]).intValue() & 3;
                if (iIntValue != 0) {
                    pdfContentByte.setTextRenderingMode(iIntValue);
                }
                if (iIntValue == 1 || iIntValue == 2) {
                    fFloatValue = ((Float) objArr[1]).floatValue();
                    if (fFloatValue != 1.0f) {
                        pdfContentByte.setLineWidth(fFloatValue);
                    }
                    baseColor = (BaseColor) objArr[2];
                    if (baseColor == null) {
                        baseColor = baseColorColor;
                    }
                    if (baseColor != null) {
                        pdfContentByte.setColorStroke(baseColor);
                    }
                }
                f = (Float) pdfChunk.getAttribute(Chunk.CHAR_SPACING);
                if (f != null && !this.curCharSpace.equals(f)) {
                    this.curCharSpace = f;
                    pdfContentByte.setCharacterSpacing(f.floatValue());
                }
                if (baseColorColor != null) {
                    pdfContentByte.setColorFill(baseColorColor);
                }
                pdfContentByte.showText(pdfChunk.toString());
                if (baseColorColor != null) {
                    pdfContentByte.resetRGBColorFill();
                }
                if (iIntValue != 0) {
                    pdfContentByte.setTextRenderingMode(0);
                }
                if (baseColor != null) {
                    pdfContentByte.resetRGBColorStroke();
                }
                if (fFloatValue != 1.0f) {
                    pdfContentByte.setLineWidth(1.0f);
                }
            } else {
                iIntValue = 0;
            }
            fFloatValue = 1.0f;
            f = (Float) pdfChunk.getAttribute(Chunk.CHAR_SPACING);
            if (f != null) {
                this.curCharSpace = f;
                pdfContentByte.setCharacterSpacing(f.floatValue());
            }
            if (baseColorColor != null) {
                pdfContentByte.setColorFill(baseColorColor);
            }
            pdfContentByte.showText(pdfChunk.toString());
            if (baseColorColor != null) {
                pdfContentByte.resetRGBColorFill();
            }
            if (iIntValue != 0) {
                pdfContentByte.setTextRenderingMode(0);
            }
            if (baseColor != null) {
                pdfContentByte.resetRGBColorStroke();
            }
            if (fFloatValue != 1.0f) {
                pdfContentByte.setLineWidth(1.0f);
            }
        }
    }

    public int go(boolean z) {
        PdfContentByte duplicate;
        int i;
        PdfContentByte pdfContentByte = this.text;
        boolean z2 = false;
        if (pdfContentByte != null) {
            duplicate = pdfContentByte.getDuplicate();
        } else {
            if (!z) {
                throw new NullPointerException(MessageLocalization.getComposedMessage("verticaltext.go.with.simulate.eq.eq.false.and.text.eq.eq.null", new Object[0]));
            }
            duplicate = null;
        }
        while (true) {
            if (this.maxLines <= 0) {
                if (!this.chunks.isEmpty()) {
                    i = 2;
                    break;
                }
                i = 3;
                break;
            }
            if (this.chunks.isEmpty()) {
                i = 1;
                break;
            }
            PdfLine pdfLineCreateLine = createLine(this.height);
            if (!z && !z2) {
                this.text.beginText();
                z2 = true;
            }
            shortenChunkArray();
            if (!z) {
                this.text.setTextMatrix(this.startX, this.startY - pdfLineCreateLine.indentLeft());
                writeLine(pdfLineCreateLine, this.text, duplicate);
            }
            this.maxLines--;
            this.startX -= this.leading;
        }
        if (z2) {
            this.text.endText();
            this.text.add(duplicate);
        }
        return i;
    }

    public void addText(Chunk chunk) {
        this.chunks.add(new PdfChunk(chunk, (PdfAction) null));
    }
}
