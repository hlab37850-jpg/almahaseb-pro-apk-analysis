package com.itextpdf.text.pdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.api.Spaceable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FloatLayout {
    protected final ColumnText compositeColumn;
    protected final List<Element> content;
    protected float filledWidth;
    protected float floatLeftX;
    protected float floatRightX;
    protected float leftX;
    protected float maxY;
    protected float minY;
    protected float rightX;
    protected final boolean useAscender;
    protected float yLine;

    public FloatLayout(List<Element> list, boolean z) {
        ColumnText columnText = new ColumnText(null);
        this.compositeColumn = columnText;
        columnText.setUseAscender(z);
        this.useAscender = z;
        this.content = list;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x028d  */
    /* JADX WARN: Code duplicated, block: B:108:0x029a  */
    /* JADX WARN: Code duplicated, block: B:115:0x02db  */
    /* JADX WARN: Code duplicated, block: B:128:0x030c  */
    /* JADX WARN: Code duplicated, block: B:153:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0294 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0294 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:87:0x0227  */
    /* JADX WARN: Code duplicated, block: B:89:0x022f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0233  */
    /* JADX WARN: Code duplicated, block: B:92:0x023b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0245  */
    private int floatingLayout(List<Element> list, boolean z) {
        Element element;
        boolean z2;
        WritableDirectElement writableDirectElement;
        PdfDiv pdfDiv;
        float f;
        float f2 = this.yLine;
        ColumnText columnTextDuplicate = this.compositeColumn;
        if (z) {
            columnTextDuplicate = ColumnText.duplicate(columnTextDuplicate);
        }
        ColumnText columnText = columnTextDuplicate;
        int i = 0;
        float fMin = f2;
        boolean z3 = this.maxY == this.yLine;
        int iGo = 1;
        float filledWidth = 0.0f;
        float filledWidth2 = 0.0f;
        while (!list.isEmpty()) {
            Element element2 = list.get(i);
            list.remove(i);
            if (element2 instanceof PdfDiv) {
                PdfDiv pdfDiv2 = (PdfDiv) element2;
                iGo = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                if ((iGo & 1) == 0) {
                    this.yLine = fMin;
                    this.floatLeftX = this.leftX;
                    this.floatRightX = this.rightX;
                    iGo = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if ((iGo & 1) == 0) {
                        list.add(i, pdfDiv2);
                        break;
                    }
                }
                if (pdfDiv2.getFloatType() == PdfDiv.FloatType.LEFT) {
                    pdfDiv = pdfDiv2;
                    element = element2;
                    f = filledWidth;
                    iGo = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    this.floatLeftX += pdfDiv.getActualWidth();
                    filledWidth2 += pdfDiv.getActualWidth();
                } else {
                    pdfDiv = pdfDiv2;
                    element = element2;
                    f = filledWidth;
                    float f3 = filledWidth2;
                    if (pdfDiv.getFloatType() == PdfDiv.FloatType.RIGHT) {
                        iGo = pdfDiv.layout(this.compositeColumn.getCanvas(), this.useAscender, z, (this.floatRightX - pdfDiv.getActualWidth()) - 0.01f, this.minY, this.floatRightX, this.yLine);
                        this.floatRightX -= pdfDiv.getActualWidth();
                        filledWidth = f + pdfDiv.getActualWidth();
                        filledWidth2 = f3;
                    } else {
                        filledWidth2 = f3;
                    }
                    z2 = z;
                    fMin = Math.min(fMin, this.yLine - pdfDiv.getActualHeight());
                    if (element instanceof Paragraph) {
                        for (Element element3 : (Paragraph) element) {
                            if (element3 instanceof WritableDirectElement) {
                                writableDirectElement = (WritableDirectElement) element3;
                                if (writableDirectElement.getDirectElementType() != 1 && !z2) {
                                    PdfWriter pdfWriter = this.compositeColumn.getCanvas().getPdfWriter();
                                    PdfDocument pdfDocument = this.compositeColumn.getCanvas().getPdfDocument();
                                    float f4 = pdfDocument.currentHeight;
                                    pdfDocument.currentHeight = (pdfDocument.top() - this.yLine) - pdfDocument.indentation.indentTop;
                                    writableDirectElement.write(pdfWriter, pdfDocument);
                                    pdfDocument.currentHeight = f4;
                                }
                            }
                        }
                    }
                    if (!z3 && element.getChunks().size() == 0) {
                        if (element instanceof Paragraph) {
                            Element element4 = ((Paragraph) element).get(0);
                            if ((element4 instanceof WritableDirectElement) && ((WritableDirectElement) element4).getDirectElementType() != 1) {
                            }
                        } else if (element instanceof Spaceable) {
                        }
                        i = 0;
                    }
                    i = 0;
                }
                filledWidth = f;
                z2 = z;
                fMin = Math.min(fMin, this.yLine - pdfDiv.getActualHeight());
                if (element instanceof Paragraph) {
                    while (r3.hasNext()) {
                        if (element3 instanceof WritableDirectElement) {
                            writableDirectElement = (WritableDirectElement) element3;
                            if (writableDirectElement.getDirectElementType() != 1) {
                            }
                        }
                    }
                }
                z3 = !z3 ? false : false;
                i = 0;
            } else {
                element = element2;
                float f5 = filledWidth;
                float f6 = filledWidth2;
                if (this.minY > fMin) {
                    list.add(0, element);
                    if (columnText != null) {
                        columnText.setText(null);
                    }
                    iGo = 2;
                    filledWidth2 = f6;
                    filledWidth = f5;
                    break;
                }
                if ((element instanceof Spaceable) && (!z3 || !columnText.isIgnoreSpacingBefore() || ((Spaceable) element).getPaddingTop() != 0.0f)) {
                    this.yLine -= ((Spaceable) element).getSpacingBefore();
                }
                z2 = z;
                if (z2 && (element instanceof PdfPTable)) {
                    columnText.addElement(new PdfPTable((PdfPTable) element));
                } else {
                    columnText.addElement(element);
                }
                float f7 = this.yLine;
                if (f7 > fMin) {
                    columnText.setSimpleColumn(this.floatLeftX, f7, this.floatRightX, fMin);
                } else {
                    columnText.setSimpleColumn(this.floatLeftX, f7, this.floatRightX, this.minY);
                }
                columnText.setFilledWidth(0.0f);
                iGo = columnText.go(z2);
                if (this.yLine > fMin) {
                    float f8 = this.floatLeftX;
                    float f9 = this.leftX;
                    if ((f8 > f9 || this.floatRightX < this.rightX) && (iGo & 1) == 0) {
                        this.yLine = fMin;
                        this.floatLeftX = f9;
                        float f10 = this.rightX;
                        this.floatRightX = f10;
                        if (f6 == 0.0f || f5 == 0.0f) {
                            if (f6 > this.filledWidth) {
                                this.filledWidth = f6;
                            }
                            if (f5 > this.filledWidth) {
                                this.filledWidth = f5;
                            }
                        } else {
                            this.filledWidth = f10 - f9;
                        }
                        if (z2 && (element instanceof PdfPTable)) {
                            columnText.addElement(new PdfPTable((PdfPTable) element));
                        }
                        columnText.setSimpleColumn(this.floatLeftX, this.yLine, this.floatRightX, this.minY);
                        iGo = columnText.go(z2);
                        float yLine = columnText.getYLine() + columnText.getDescender();
                        this.yLine = yLine;
                        if (columnText.getFilledWidth() > this.filledWidth) {
                            this.filledWidth = columnText.getFilledWidth();
                        }
                        fMin = yLine;
                        filledWidth = 0.0f;
                        filledWidth2 = 0.0f;
                    } else {
                        if (f5 > 0.0f) {
                            filledWidth = f5 + columnText.getFilledWidth();
                        } else {
                            if (f6 > 0.0f) {
                                filledWidth2 = f6 + columnText.getFilledWidth();
                                filledWidth = f5;
                            } else {
                                if (columnText.getFilledWidth() > this.filledWidth) {
                                    this.filledWidth = columnText.getFilledWidth();
                                }
                                filledWidth = f5;
                            }
                            float fMin2 = Math.min(columnText.getYLine() + columnText.getDescender(), fMin);
                            this.yLine = columnText.getYLine() + columnText.getDescender();
                            fMin = fMin2;
                        }
                        filledWidth2 = f6;
                        float fMin3 = Math.min(columnText.getYLine() + columnText.getDescender(), fMin);
                        this.yLine = columnText.getYLine() + columnText.getDescender();
                        fMin = fMin3;
                    }
                } else {
                    if (f5 > 0.0f) {
                        filledWidth = f5 + columnText.getFilledWidth();
                    } else {
                        if (f6 > 0.0f) {
                            filledWidth2 = f6 + columnText.getFilledWidth();
                            filledWidth = f5;
                        } else {
                            if (columnText.getFilledWidth() > this.filledWidth) {
                                this.filledWidth = columnText.getFilledWidth();
                            }
                            filledWidth = f5;
                        }
                        float fMin4 = Math.min(columnText.getYLine() + columnText.getDescender(), fMin);
                        this.yLine = columnText.getYLine() + columnText.getDescender();
                        fMin = fMin4;
                    }
                    filledWidth2 = f6;
                    float fMin5 = Math.min(columnText.getYLine() + columnText.getDescender(), fMin);
                    this.yLine = columnText.getYLine() + columnText.getDescender();
                    fMin = fMin5;
                }
                if ((iGo & 1) == 0) {
                    if (!z2) {
                        list.addAll(0, columnText.getCompositeElements());
                        columnText.getCompositeElements().clear();
                        break;
                    }
                    list.add(0, element);
                    columnText.setText(null);
                    break;
                }
                columnText.setText(null);
                if (element instanceof Paragraph) {
                    while (r3.hasNext()) {
                        if (element3 instanceof WritableDirectElement) {
                            writableDirectElement = (WritableDirectElement) element3;
                            if (writableDirectElement.getDirectElementType() != 1) {
                            }
                        }
                    }
                }
                if (!z3) {
                }
                i = 0;
            }
        }
        if (filledWidth2 == 0.0f || filledWidth == 0.0f) {
            if (filledWidth2 > this.filledWidth) {
                this.filledWidth = filledWidth2;
            }
            if (filledWidth > this.filledWidth) {
                this.filledWidth = filledWidth;
            }
        } else {
            this.filledWidth = this.rightX - this.leftX;
        }
        this.yLine = fMin;
        this.floatLeftX = this.leftX;
        this.floatRightX = this.rightX;
        return iGo;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public int getRunDirection() {
        return this.compositeColumn.getRunDirection();
    }

    public float getYLine() {
        return this.yLine;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x008b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b6 A[SYNTHETIC] */
    public int layout(PdfContentByte pdfContentByte, boolean z) {
        this.compositeColumn.setCanvas(pdfContentByte);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = z ? new ArrayList(this.content) : this.content;
        int iFloatingLayout = 1;
        while (!arrayList2.isEmpty()) {
            if (arrayList2.get(0) instanceof PdfDiv) {
                PdfDiv pdfDiv = (PdfDiv) arrayList2.get(0);
                if (pdfDiv.getFloatType() == PdfDiv.FloatType.LEFT || pdfDiv.getFloatType() == PdfDiv.FloatType.RIGHT) {
                    arrayList.add(pdfDiv);
                    arrayList2.remove(0);
                } else if (!arrayList.isEmpty()) {
                    iFloatingLayout = floatingLayout(arrayList, z);
                    if ((iFloatingLayout & 1) != 0) {
                        arrayList2.remove(0);
                        iFloatingLayout = pdfDiv.layout(pdfContentByte, this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                        if (!pdfDiv.getKeepTogether() && (iFloatingLayout & 1) == 0 && (this.compositeColumn.getCanvas().getPdfDocument().currentHeight > 0.0f || this.yLine != this.maxY)) {
                            arrayList2.add(0, pdfDiv);
                            break;
                        }
                        if (!z) {
                            pdfContentByte.openMCBlock(pdfDiv);
                            iFloatingLayout = pdfDiv.layout(pdfContentByte, this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                            pdfContentByte.closeMCBlock(pdfDiv);
                        }
                        if (pdfDiv.getActualWidth() > this.filledWidth) {
                            this.filledWidth = pdfDiv.getActualWidth();
                        }
                        if ((iFloatingLayout & 1) == 0) {
                            arrayList2.add(0, pdfDiv);
                            this.yLine = pdfDiv.getYLine();
                            break;
                        }
                        this.yLine -= pdfDiv.getActualHeight();
                    } else {
                        break;
                    }
                } else {
                    arrayList2.remove(0);
                    iFloatingLayout = pdfDiv.layout(pdfContentByte, this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if (!pdfDiv.getKeepTogether()) {
                        if (!z) {
                            pdfContentByte.openMCBlock(pdfDiv);
                            iFloatingLayout = pdfDiv.layout(pdfContentByte, this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                            pdfContentByte.closeMCBlock(pdfDiv);
                        }
                        if (pdfDiv.getActualWidth() > this.filledWidth) {
                            this.filledWidth = pdfDiv.getActualWidth();
                        }
                        if ((iFloatingLayout & 1) == 0) {
                            arrayList2.add(0, pdfDiv);
                            this.yLine = pdfDiv.getYLine();
                            break;
                        }
                        this.yLine -= pdfDiv.getActualHeight();
                    } else {
                        if (!z) {
                            pdfContentByte.openMCBlock(pdfDiv);
                            iFloatingLayout = pdfDiv.layout(pdfContentByte, this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                            pdfContentByte.closeMCBlock(pdfDiv);
                        }
                        if (pdfDiv.getActualWidth() > this.filledWidth) {
                            this.filledWidth = pdfDiv.getActualWidth();
                        }
                        if ((iFloatingLayout & 1) == 0) {
                            arrayList2.add(0, pdfDiv);
                            this.yLine = pdfDiv.getYLine();
                            break;
                        }
                        this.yLine -= pdfDiv.getActualHeight();
                    }
                }
            } else {
                arrayList.add(arrayList2.get(0));
                arrayList2.remove(0);
            }
        }
        if ((iFloatingLayout & 1) != 0 && !arrayList.isEmpty()) {
            iFloatingLayout = floatingLayout(arrayList, z);
        }
        arrayList2.addAll(0, arrayList);
        return iFloatingLayout;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void setRunDirection(int i) {
        this.compositeColumn.setRunDirection(i);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        float fMax = Math.max(f, f3);
        this.rightX = fMax;
        this.floatLeftX = this.leftX;
        this.floatRightX = fMax;
        this.yLine = this.maxY;
        this.filledWidth = 0.0f;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }
}
