package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.TabStop;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PdfLine {
    protected int alignment;
    protected float height;
    protected boolean isRTL;
    protected float left;
    protected ArrayList<PdfChunk> line;
    protected ListItem listItem;
    protected boolean newlineSplit;
    protected float originalWidth;
    protected float tabPosition;
    protected TabStop tabStop;
    protected float tabStopAnchorPosition;
    protected float width;

    public PdfLine(float f, float f2, int i, float f3) {
        this.newlineSplit = false;
        this.isRTL = false;
        this.listItem = null;
        this.tabStop = null;
        this.tabStopAnchorPosition = Float.NaN;
        this.tabPosition = Float.NaN;
        this.left = f;
        float f4 = f2 - f;
        this.width = f4;
        this.originalWidth = f4;
        this.alignment = i;
        this.height = f3;
        this.line = new ArrayList<>();
    }

    private void addToLine(PdfChunk pdfChunk) {
        String string;
        int iIndexOf;
        float leading;
        if (pdfChunk.changeLeading) {
            if (pdfChunk.isImage()) {
                Image image = pdfChunk.getImage();
                leading = pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY() + image.getBorderWidthTop() + image.getSpacingBefore();
            } else {
                leading = pdfChunk.getLeading();
            }
            if (leading > this.height) {
                this.height = leading;
            }
        }
        TabStop tabStop = this.tabStop;
        if (tabStop != null && tabStop.getAlignment() == TabStop.Alignment.ANCHOR && Float.isNaN(this.tabStopAnchorPosition) && (iIndexOf = (string = pdfChunk.toString()).indexOf(this.tabStop.getAnchorChar())) != -1) {
            this.tabStopAnchorPosition = (this.originalWidth - this.width) - pdfChunk.width(string.substring(iIndexOf, string.length()));
        }
        this.line.add(pdfChunk);
    }

    public PdfChunk add(PdfChunk pdfChunk, float f) {
        if (pdfChunk != null && !pdfChunk.toString().equals("") && !pdfChunk.toString().equals(" ") && (this.height < f || this.line.isEmpty())) {
            this.height = f;
        }
        return add(pdfChunk);
    }

    public void flush() {
        TabStop tabStop = this.tabStop;
        if (tabStop != null) {
            float f = this.originalWidth;
            float f2 = this.width;
            float f3 = this.tabPosition;
            float f4 = (f - f2) - f3;
            float position = tabStop.getPosition(f3, f - f2, this.tabStopAnchorPosition);
            float f5 = this.originalWidth;
            float f6 = (f5 - position) - f4;
            this.width = f6;
            if (f6 < 0.0f) {
                position += f6;
            }
            if (this.isRTL) {
                this.tabStop.setPosition((f5 - f6) - this.tabPosition);
            } else {
                this.tabStop.setPosition(position);
            }
            this.tabStop = null;
            this.tabPosition = Float.NaN;
        }
    }

    public float getAscender() {
        float fMax = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                fMax = Math.max(fMax, pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY());
            } else {
                PdfFont pdfFontFont = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise <= 0.0f) {
                    textRise = 0.0f;
                }
                fMax = Math.max(fMax, textRise + pdfFontFont.getFont().getFontDescriptor(1, pdfFontFont.size()));
            }
        }
        return fMax;
    }

    public PdfChunk getChunk(int i) {
        if (i < 0 || i >= this.line.size()) {
            return null;
        }
        return this.line.get(i);
    }

    public float getDescender() {
        float fMin = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                fMin = Math.min(fMin, pdfChunk.getImageOffsetY());
            } else {
                PdfFont pdfFontFont = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise >= 0.0f) {
                    textRise = 0.0f;
                }
                fMin = Math.min(fMin, textRise + pdfFontFont.getFont().getFontDescriptor(3, pdfFontFont.size()));
            }
        }
        return fMin;
    }

    public int getLastStrokeChunk() {
        int size = this.line.size() - 1;
        while (size >= 0 && !this.line.get(size).isStroked()) {
            size--;
        }
        return size;
    }

    public int getLineLengthUtf32() {
        Iterator<PdfChunk> it = this.line.iterator();
        int iLengthUtf32 = 0;
        while (it.hasNext()) {
            iLengthUtf32 += it.next().lengthUtf32();
        }
        return iLengthUtf32;
    }

    public float[] getMaxSize(float f, float f2) {
        float fMax = -10000.0f;
        float fMax2 = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                Image image = pdfChunk.getImage();
                if (pdfChunk.changeLeading()) {
                    fMax = Math.max(pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY() + image.getSpacingBefore(), fMax);
                }
            } else {
                fMax2 = pdfChunk.changeLeading() ? Math.max(pdfChunk.getLeading(), fMax2) : Math.max((pdfChunk.font().size() * f2) + f, fMax2);
            }
        }
        if (fMax2 > 0.0f) {
            f = fMax2;
        }
        return new float[]{f, fMax};
    }

    public float getOriginalWidth() {
        return this.originalWidth;
    }

    public int getSeparatorCount() {
        int i = 0;
        for (PdfChunk pdfChunk : this.line) {
            if (pdfChunk.isTab()) {
                if (!pdfChunk.isAttribute(Chunk.TABSETTINGS)) {
                    return -1;
                }
            } else if (pdfChunk.isHorizontalSeparator()) {
                i++;
            }
        }
        return i;
    }

    public float getWidthCorrected(float f, float f2) {
        float widthCorrected = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            widthCorrected += this.line.get(i).getWidthCorrected(f, f2);
        }
        return widthCorrected;
    }

    public boolean hasToBeJustified() {
        int i = this.alignment;
        return ((i == 3 && !this.newlineSplit) || i == 8) && this.width != 0.0f;
    }

    public float height() {
        return this.height;
    }

    public float indentLeft() {
        if (!this.isRTL) {
            if (getSeparatorCount() <= 0) {
                int i = this.alignment;
                if (i == 1) {
                    return this.left + (this.width / 2.0f);
                }
                if (i == 2) {
                    return this.left + this.width;
                }
            }
            return this.left;
        }
        int i2 = this.alignment;
        if (i2 == 1) {
            return this.left + (this.width / 2.0f);
        }
        if (i2 == 2) {
            return this.left;
        }
        if (i2 != 3) {
            return this.left + this.width;
        }
        return this.left + (hasToBeJustified() ? 0.0f : this.width);
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit && this.alignment != 8;
    }

    public boolean isRTL() {
        return this.isRTL;
    }

    public Iterator<PdfChunk> iterator() {
        return this.line.iterator();
    }

    public float listIndent() {
        ListItem listItem = this.listItem;
        if (listItem != null) {
            return listItem.getIndentationLeft();
        }
        return 0.0f;
    }

    public ListItem listItem() {
        return this.listItem;
    }

    public Chunk listSymbol() {
        ListItem listItem = this.listItem;
        if (listItem != null) {
            return listItem.getListSymbol();
        }
        return null;
    }

    public int numberOfSpaces() {
        Iterator<PdfChunk> it = this.line.iterator();
        int i = 0;
        while (it.hasNext()) {
            String string = it.next().toString();
            int length = string.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (string.charAt(i2) == ' ') {
                    i++;
                }
            }
        }
        return i;
    }

    public void resetAlignment() {
        if (this.alignment == 3) {
            this.alignment = 0;
        }
    }

    public void setExtraIndent(float f) {
        this.left += f;
        this.width -= f;
        this.originalWidth -= f;
    }

    public void setListItem(ListItem listItem) {
        this.listItem = listItem;
    }

    public int size() {
        return this.line.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<PdfChunk> it = this.line.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public float widthLeft() {
        return this.width;
    }

    public PdfChunk add(PdfChunk pdfChunk) {
        if (pdfChunk == null || pdfChunk.toString().equals("")) {
            return null;
        }
        PdfChunk pdfChunkSplit = pdfChunk.split(this.width);
        this.newlineSplit = pdfChunk.isNewlineSplit() || pdfChunkSplit == null;
        if (pdfChunk.isTab()) {
            Object[] objArr = (Object[]) pdfChunk.getAttribute(Chunk.TAB);
            if (pdfChunk.isAttribute(Chunk.TABSETTINGS)) {
                boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
                if (zBooleanValue && this.line.isEmpty()) {
                    return null;
                }
                flush();
                this.tabStopAnchorPosition = Float.NaN;
                TabStop tabStop = PdfChunk.getTabStop(pdfChunk, this.originalWidth - this.width);
                this.tabStop = tabStop;
                float position = tabStop.getPosition();
                float f = this.originalWidth;
                if (position > f) {
                    if (zBooleanValue) {
                        pdfChunk = null;
                    } else if (Math.abs(f - this.width) < 0.001d) {
                        addToLine(pdfChunk);
                        pdfChunk = null;
                    }
                    this.width = 0.0f;
                    return pdfChunk;
                }
                pdfChunk.setTabStop(this.tabStop);
                if (!this.isRTL && this.tabStop.getAlignment() == TabStop.Alignment.LEFT) {
                    this.width = this.originalWidth - this.tabStop.getPosition();
                    this.tabStop = null;
                    this.tabPosition = Float.NaN;
                } else {
                    this.tabPosition = this.originalWidth - this.width;
                }
                addToLine(pdfChunk);
                return pdfChunkSplit;
            }
            Float f2 = (Float) objArr[1];
            f2.floatValue();
            if (((Boolean) objArr[2]).booleanValue() && f2.floatValue() < this.originalWidth - this.width) {
                return pdfChunk;
            }
            pdfChunk.adjustLeft(this.left);
            this.width = this.originalWidth - f2.floatValue();
            addToLine(pdfChunk);
            return pdfChunkSplit;
        }
        if (pdfChunk.length() <= 0 && !pdfChunk.isImage()) {
            if (this.line.size() < 1) {
                PdfChunk pdfChunkTruncate = pdfChunkSplit.truncate(this.width);
                this.width -= pdfChunkSplit.width();
                if (pdfChunkSplit.length() > 0) {
                    addToLine(pdfChunkSplit);
                    return pdfChunkTruncate;
                }
                if (pdfChunkTruncate != null) {
                    addToLine(pdfChunkTruncate);
                }
                return null;
            }
            float f3 = this.width;
            ArrayList<PdfChunk> arrayList = this.line;
            this.width = f3 + arrayList.get(arrayList.size() - 1).trimLastSpace();
            return pdfChunkSplit;
        }
        if (pdfChunkSplit != null) {
            pdfChunk.trimLastSpace();
        }
        this.width -= pdfChunk.width();
        addToLine(pdfChunk);
        return pdfChunkSplit;
    }

    public PdfLine(float f, float f2, float f3, int i, boolean z, ArrayList<PdfChunk> arrayList, boolean z2) {
        this.listItem = null;
        this.tabStop = null;
        this.tabStopAnchorPosition = Float.NaN;
        this.tabPosition = Float.NaN;
        this.left = f;
        this.originalWidth = f2;
        this.width = f3;
        this.alignment = i;
        this.line = arrayList;
        this.newlineSplit = z;
        this.isRTL = z2;
    }
}
