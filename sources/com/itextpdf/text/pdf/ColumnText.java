package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListBody;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class ColumnText {
    public static final int AR_COMPOSEDTASHKEEL = 4;
    public static final int AR_LIG = 8;
    public static final int AR_NOVOWEL = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final float GLOBAL_SPACE_CHAR_RATIO = 0.0f;
    protected static final int LINE_STATUS_NOLINE = 2;
    protected static final int LINE_STATUS_OFFLIMITS = 1;
    protected static final int LINE_STATUS_OK = 0;
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    public static final int START_COLUMN = 0;
    protected BidiLine bidiLine;
    protected PdfContentByte canvas;
    protected PdfContentByte[] canvases;
    protected ColumnText compositeColumn;
    protected LinkedList<Element> compositeElements;
    protected float descender;
    private float filledWidth;
    private float firstLineY;
    protected boolean isWordSplit;
    protected float lastX;
    protected ArrayList<float[]> leftWall;
    protected float leftX;
    protected int lineStatus;
    private int linesWritten;
    protected float maxY;
    protected float minY;
    protected ArrayList<float[]> rightWall;
    protected float rightX;
    protected Phrase waitPhrase;
    protected float yLine;
    private final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ColumnText.class);
    protected int runDirection = 1;
    protected int alignment = 0;
    protected float currentLeading = 16.0f;
    protected float fixedLeading = 16.0f;
    protected float multipliedLeading = 0.0f;
    protected float indent = 0.0f;
    protected float followingIndent = 0.0f;
    protected float rightIndent = 0.0f;
    protected float extraParagraphSpace = 0.0f;
    protected float rectangularWidth = -1.0f;
    protected boolean rectangularMode = false;
    private float spaceCharRatio = 0.0f;
    private boolean lastWasNewline = true;
    private boolean repeatFirstLineIndent = true;
    private boolean firstLineYDone = false;
    private int arabicOptions = 0;
    protected boolean composite = false;
    protected int listIdx = 0;
    protected int rowIdx = 0;
    private int splittedRow = -2;
    private boolean useAscender = false;
    private boolean adjustFirstLine = true;
    private boolean inheritGraphicState = false;
    private boolean ignoreSpacingBefore = true;

    public ColumnText(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
    }

    private void addWaitingPhrase() {
        if (this.bidiLine != null || this.waitPhrase == null) {
            return;
        }
        this.bidiLine = new BidiLine();
        Iterator<Chunk> it = this.waitPhrase.getChunks().iterator();
        while (it.hasNext()) {
            this.bidiLine.addChunk(new PdfChunk(it.next(), null, this.waitPhrase.getTabSettings()));
        }
        this.waitPhrase = null;
    }

    public static ColumnText duplicate(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText(null);
        columnText2.setACopy(columnText);
        return columnText2;
    }

    public static float fitText(Font font, String str, Rectangle rectangle, float f, int i) {
        float fAbs;
        if (f <= 0.0f) {
            try {
                int i2 = 0;
                int i3 = 0;
                for (char c : str.toCharArray()) {
                    if (c == '\n') {
                        i3++;
                    } else if (c == '\r') {
                        i2++;
                    }
                }
                fAbs = (Math.abs(rectangle.getHeight()) / (Math.max(i2, i3) + 1)) - 0.001f;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            fAbs = f;
        }
        font.setSize(fAbs);
        Phrase phrase = new Phrase(str, font);
        ColumnText columnText = new ColumnText(null);
        columnText.setSimpleColumn(phrase, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), fAbs, 0);
        columnText.setRunDirection(i);
        if ((columnText.go(true) & 1) != 0) {
            return fAbs;
        }
        float f2 = fAbs;
        float f3 = 0.0f;
        for (int i4 = 0; i4 < 50; i4++) {
            fAbs = (f3 + f2) / 2.0f;
            ColumnText columnText2 = new ColumnText(null);
            font.setSize(fAbs);
            columnText2.setSimpleColumn(new Phrase(str, font), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), fAbs, 0);
            columnText2.setRunDirection(i);
            if ((columnText2.go(true) & 1) == 0) {
                f2 = fAbs;
            } else {
                if (f2 - f3 < 0.1f * fAbs) {
                    return fAbs;
                }
                f3 = fAbs;
            }
        }
        return fAbs;
    }

    public static float getWidth(Phrase phrase, int i, int i2) {
        ColumnText columnText = new ColumnText(null);
        columnText.addText(phrase);
        columnText.addWaitingPhrase();
        PdfLine pdfLineProcessLine = columnText.bidiLine.processLine(0.0f, 20000.0f, 0, i, i2, 0.0f, 0.0f, 0.0f);
        if (pdfLineProcessLine == null) {
            return 0.0f;
        }
        return 20000.0f - pdfLineProcessLine.widthLeft();
    }

    public static boolean hasMoreText(int i) {
        return (i & 1) == 0;
    }

    public static boolean isAllowedElement(Element element) {
        int iType = element.type();
        return iType == 10 || iType == 11 || iType == 37 || iType == 12 || iType == 14 || iType == 55 || iType == 23 || (element instanceof Image);
    }

    private static boolean isTagged(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter;
        return (pdfContentByte == null || pdfContentByte.pdf == null || (pdfWriter = pdfContentByte.writer) == null || !pdfWriter.isTagged()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3, int i2, int i3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int i4 = i;
        int i5 = 0;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            i4 = 0;
        }
        pdfContentByte.saveState();
        ColumnText columnText = new ColumnText(pdfContentByte);
        if (i4 != 0) {
            f4 = i4 != 2 ? 20000.0f : 0.0f;
            f5 = -20000.0f;
        } else {
            f4 = 20000.0f;
            f5 = 0.0f;
        }
        if (f3 == 0.0f) {
            f9 = f2 + 2.0f;
            f6 = f4 + f;
            f7 = f5 + f;
            f8 = f2 - 1.0f;
        } else {
            double d = (((double) f3) * 3.141592653589793d) / 180.0d;
            float fCos = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            pdfContentByte.concatCTM(fCos, fSin, -fSin, fCos, f, f2);
            f6 = f4;
            f7 = f5;
            f8 = -1.0f;
            f9 = 2.0f;
        }
        columnText.setSimpleColumn(phrase, f7, f8, f6, f9, 2.0f, i4);
        if (i2 != 3) {
            i5 = i4;
        } else if (i4 == 0) {
            i5 = 2;
        } else if (i4 != 2) {
            i5 = i4;
        }
        columnText.setAlignment(i5);
        columnText.setArabicOptions(i3);
        columnText.setRunDirection(i2);
        try {
            columnText.go();
            pdfContentByte.restoreState();
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    public void addElement(Element element) {
        Paragraph paragraph;
        if (element == null) {
            return;
        }
        if (element instanceof Image) {
            Image image = (Image) element;
            PdfPTable pdfPTable = new PdfPTable(1);
            float widthPercentage = image.getWidthPercentage();
            if (widthPercentage == 0.0f) {
                pdfPTable.setTotalWidth(image.getScaledWidth());
                pdfPTable.setLockedWidth(true);
            } else {
                pdfPTable.setWidthPercentage(widthPercentage);
            }
            pdfPTable.setSpacingAfter(image.getSpacingAfter());
            pdfPTable.setSpacingBefore(image.getSpacingBefore());
            int alignment = image.getAlignment();
            if (alignment == 0) {
                pdfPTable.setHorizontalAlignment(0);
            } else if (alignment != 2) {
                pdfPTable.setHorizontalAlignment(1);
            } else {
                pdfPTable.setHorizontalAlignment(2);
            }
            PdfPCell pdfPCell = new PdfPCell(image, true);
            pdfPCell.setPadding(0.0f);
            pdfPCell.setBorder(image.getBorder());
            pdfPCell.setBorderColor(image.getBorderColor());
            pdfPCell.setBorderWidth(image.getBorderWidth());
            pdfPCell.setBackgroundColor(image.getBackgroundColor());
            pdfPTable.addCell(pdfPCell);
            element = pdfPTable;
        }
        if (element.type() != 10) {
            if (element.type() == 11) {
                paragraph = new Paragraph((Phrase) element);
            } else if (element.type() == 23) {
                ((PdfPTable) element).init();
            }
            if (element.type() == 12 && element.type() != 14 && element.type() != 23 && element.type() != 55 && element.type() != 37) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("element.not.allowed", new Object[0]));
            }
            if (!this.composite) {
                this.composite = true;
                this.compositeElements = new LinkedList<>();
                this.bidiLine = null;
                this.waitPhrase = null;
            }
            if (element.type() == 12) {
                this.compositeElements.addAll(((Paragraph) element).breakUp());
            } else {
                this.compositeElements.add(element);
            }
        }
        paragraph = new Paragraph((Chunk) element);
        element = paragraph;
        if (element.type() == 12) {
        }
        if (!this.composite) {
            this.composite = true;
            this.compositeElements = new LinkedList<>();
            this.bidiLine = null;
            this.waitPhrase = null;
        }
        if (element.type() == 12) {
            this.compositeElements.addAll(((Paragraph) element).breakUp());
        } else {
            this.compositeElements.add(element);
        }
    }

    public void addText(Phrase phrase) {
        if (phrase == null || this.composite) {
            return;
        }
        addWaitingPhrase();
        if (this.bidiLine == null) {
            this.waitPhrase = phrase;
            return;
        }
        Iterator<Chunk> it = phrase.getChunks().iterator();
        while (it.hasNext()) {
            this.bidiLine.addChunk(new PdfChunk(it.next(), null, phrase.getTabSettings()));
        }
    }

    public void clearChunks() {
        BidiLine bidiLine = this.bidiLine;
        if (bidiLine != null) {
            bidiLine.clearChunks();
        }
    }

    public ArrayList<float[]> convertColumn(float[] fArr) {
        if (fArr.length < 4) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        ArrayList<float[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < fArr.length - 2) {
            float f = fArr[i];
            float f2 = fArr[i + 1];
            int i2 = i + 2;
            float f3 = fArr[i2];
            float f4 = fArr[i + 3];
            if (f2 != f4) {
                float f5 = (f - f3) / (f2 - f4);
                float[] fArr2 = {Math.min(f2, f4), Math.max(f2, f4), f5, f - (f5 * f2)};
                arrayList.add(fArr2);
                this.maxY = Math.max(this.maxY, fArr2[1]);
                this.minY = Math.min(this.minY, fArr2[0]);
            }
            i = i2;
        }
        if (arrayList.isEmpty()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        return arrayList;
    }

    public float[] findLimitsOneLine() {
        float fFindLimitsPoint = findLimitsPoint(this.leftWall);
        int i = this.lineStatus;
        if (i == 1 || i == 2) {
            return null;
        }
        float fFindLimitsPoint2 = findLimitsPoint(this.rightWall);
        if (this.lineStatus == 2) {
            return null;
        }
        return new float[]{fFindLimitsPoint, fFindLimitsPoint2};
    }

    public float findLimitsPoint(ArrayList<float[]> arrayList) {
        this.lineStatus = 0;
        float f = this.yLine;
        if (f < this.minY || f > this.maxY) {
            this.lineStatus = 1;
            return 0.0f;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            float f2 = this.yLine;
            if (f2 >= fArr[0] && f2 <= fArr[1]) {
                return (fArr[2] * f2) + fArr[3];
            }
        }
        this.lineStatus = 2;
        return 0.0f;
    }

    public float[] findLimitsTwoLines() {
        do {
            float[] fArrFindLimitsOneLine = findLimitsOneLine();
            int i = this.lineStatus;
            if (i == 1) {
                return null;
            }
            this.yLine -= this.currentLeading;
            if (i != 2) {
                float[] fArrFindLimitsOneLine2 = findLimitsOneLine();
                int i2 = this.lineStatus;
                if (i2 == 1) {
                    return null;
                }
                if (i2 == 2) {
                    this.yLine -= this.currentLeading;
                } else {
                    float f = fArrFindLimitsOneLine[0];
                    float f2 = fArrFindLimitsOneLine2[1];
                    if (f < f2) {
                        float f3 = fArrFindLimitsOneLine2[0];
                        float f4 = fArrFindLimitsOneLine[1];
                        if (f3 < f4) {
                            return new float[]{f, f4, f3, f2};
                        }
                    }
                }
            }
        } while (this.currentLeading != 0.0f);
        return null;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public int getArabicOptions() {
        return this.arabicOptions;
    }

    public PdfContentByte getCanvas() {
        return this.canvas;
    }

    public PdfContentByte[] getCanvases() {
        return this.canvases;
    }

    public List<Element> getCompositeElements() {
        return this.compositeElements;
    }

    public float getCurrentLeading() {
        return this.currentLeading;
    }

    public float getDescender() {
        return this.descender;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public float getFollowingIndent() {
        return this.followingIndent;
    }

    public float getIndent() {
        return this.indent;
    }

    public boolean getInheritGraphicState() {
        return this.inheritGraphicState;
    }

    public float getLastX() {
        return this.lastX;
    }

    public float getLeading() {
        return this.fixedLeading;
    }

    public int getLinesWritten() {
        return this.linesWritten;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public float getRightIndent() {
        return this.rightIndent;
    }

    public int getRowsDrawn() {
        return this.rowIdx;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public float getYLine() {
        return this.yLine;
    }

    public int go() {
        return go(false);
    }

    /* JADX WARN: Code duplicated, block: B:247:0x052a  */
    /* JADX WARN: Code duplicated, block: B:348:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:351:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:354:0x0713  */
    /* JADX WARN: Code duplicated, block: B:355:0x0719  */
    /* JADX WARN: Code duplicated, block: B:364:0x073d  */
    /* JADX WARN: Code duplicated, block: B:367:0x0744  */
    /* JADX WARN: Code duplicated, block: B:369:0x0757  */
    /* JADX WARN: Code duplicated, block: B:370:0x0765  */
    /* JADX WARN: Code duplicated, block: B:372:0x0768  */
    /* JADX WARN: Code duplicated, block: B:374:0x0770  */
    /* JADX WARN: Code duplicated, block: B:377:0x0779  */
    /* JADX WARN: Code duplicated, block: B:379:0x0782  */
    /* JADX WARN: Code duplicated, block: B:382:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:383:0x07af  */
    /* JADX WARN: Code duplicated, block: B:385:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:388:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:391:0x07e2  */
    /* JADX WARN: Code duplicated, block: B:397:0x07fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:398:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:403:0x0815  */
    /* JADX WARN: Code duplicated, block: B:405:0x081a  */
    /* JADX WARN: Code duplicated, block: B:407:0x0822  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public int goComposite(boolean z) throws DocumentException {
        boolean z2;
        float widthPercentage;
        PdfPTable.FittingRows fittingRows;
        float f;
        int i;
        float f2;
        float f3;
        PdfPTable pdfPTableShallowCopy;
        ArrayList<PdfPRow> rows;
        ArrayList<PdfPRow> rows2;
        boolean z3;
        boolean z4;
        boolean z5;
        int size;
        PdfPRow pdfPRow;
        float maxHeights;
        PdfContentByte[] pdfContentByteArr;
        PdfPTableEvent tableEvent;
        PdfPTableEvent tableEvent2;
        float f4;
        boolean z6;
        ListItem listItem;
        boolean z7;
        ColumnText columnText;
        ColumnText columnText2;
        boolean z8;
        int i2 = 3;
        boolean z9 = false;
        int i3 = 2;
        boolean z10 = true;
        PdfContentByte pdfContentByte = this.canvas;
        if (pdfContentByte != null) {
            PdfDocument pdfDocument = pdfContentByte.pdf;
        }
        if (!this.rectangularMode) {
            throw new DocumentException(MessageLocalization.getComposedMessage("irregular.columns.are.not.supported.in.composite.mode", new Object[0]));
        }
        this.linesWritten = 0;
        float f5 = 0.0f;
        this.descender = 0.0f;
        boolean z11 = this.runDirection == 3;
        boolean z12 = true;
        while (!this.compositeElements.isEmpty()) {
            Element first = this.compositeElements.getFirst();
            if (first.type() == 12) {
                Paragraph paragraph = (Paragraph) first;
                int i4 = 0;
                int i5 = 0;
                while (i4 < i3) {
                    float f6 = this.yLine;
                    if (this.compositeColumn == null) {
                        ColumnText columnText3 = new ColumnText(this.canvas);
                        this.compositeColumn = columnText3;
                        columnText3.setAlignment(paragraph.getAlignment());
                        this.compositeColumn.setIndent(paragraph.getIndentationLeft() + paragraph.getFirstLineIndent(), z9);
                        this.compositeColumn.setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
                        this.compositeColumn.setFollowingIndent(paragraph.getIndentationLeft());
                        this.compositeColumn.setRightIndent(paragraph.getIndentationRight());
                        this.compositeColumn.setLeading(paragraph.getLeading(), paragraph.getMultipliedLeading());
                        this.compositeColumn.setRunDirection(this.runDirection);
                        this.compositeColumn.setArabicOptions(this.arabicOptions);
                        this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                        this.compositeColumn.addText(paragraph);
                        if (!z12 || !this.adjustFirstLine) {
                            this.yLine -= paragraph.getSpacingBefore();
                        }
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    this.compositeColumn.setUseAscender(((z12 || this.descender == f5) && this.adjustFirstLine) ? this.useAscender : false);
                    this.compositeColumn.setInheritGraphicState(this.inheritGraphicState);
                    ColumnText columnText4 = this.compositeColumn;
                    columnText4.leftX = this.leftX;
                    columnText4.rightX = this.rightX;
                    columnText4.yLine = this.yLine;
                    columnText4.rectangularWidth = this.rectangularWidth;
                    columnText4.rectangularMode = this.rectangularMode;
                    columnText4.minY = this.minY;
                    columnText4.maxY = this.maxY;
                    boolean z13 = paragraph.getKeepTogether() && z8 && !(z12 && this.adjustFirstLine);
                    boolean z14 = z || (z13 && i4 == 0);
                    if (isTagged(this.canvas) && !z14) {
                        this.canvas.openMCBlock(paragraph);
                    }
                    int iGo = this.compositeColumn.go(z14);
                    if (isTagged(this.canvas) && !z14) {
                        this.canvas.closeMCBlock(paragraph);
                    }
                    this.lastX = this.compositeColumn.getLastX();
                    updateFilledWidth(this.compositeColumn.filledWidth);
                    if ((iGo & 1) == 0 && z13) {
                        this.compositeColumn = null;
                        this.yLine = f6;
                        return i3;
                    }
                    if (z || !z13) {
                        i5 = iGo;
                        break;
                    }
                    if (i4 == 0) {
                        this.compositeColumn = null;
                        this.yLine = f6;
                    }
                    i4 += z10 ? 1 : 0;
                    i5 = iGo;
                    f5 = 0.0f;
                }
                if (this.compositeColumn.getLinesWritten() > 0) {
                    ColumnText columnText5 = this.compositeColumn;
                    this.yLine = columnText5.yLine;
                    this.linesWritten += columnText5.linesWritten;
                    this.descender = columnText5.descender;
                    this.isWordSplit = columnText5.isWordSplit() | this.isWordSplit;
                }
                this.currentLeading = this.compositeColumn.currentLeading;
                if ((i5 & 1) != 0) {
                    this.compositeColumn = null;
                    this.compositeElements.removeFirst();
                    this.yLine -= paragraph.getSpacingAfter();
                }
                if ((i5 & 2) != 0) {
                    return i3;
                }
            } else {
                if (first.type() == 14) {
                    com.itextpdf.text.List list = (com.itextpdf.text.List) first;
                    ArrayList<Element> items = list.getItems();
                    float indentationLeft = list.getIndentationLeft();
                    Stack stack = new Stack();
                    int iIntValue = 0;
                    int i6 = 0;
                    while (true) {
                        if (iIntValue >= items.size()) {
                            listItem = null;
                            break;
                        }
                        Element element = items.get(iIntValue);
                        if (!(element instanceof ListItem)) {
                            if (element instanceof com.itextpdf.text.List) {
                                Integer numValueOf = Integer.valueOf(iIntValue);
                                Float f7 = new Float(indentationLeft);
                                Object[] objArr = new Object[i2];
                                objArr[z9 ? 1 : 0] = list;
                                objArr[z10 ? 1 : 0] = numValueOf;
                                objArr[i3] = f7;
                                stack.push(objArr);
                                com.itextpdf.text.List list2 = (com.itextpdf.text.List) element;
                                items = list2.getItems();
                                indentationLeft += list2.getIndentationLeft();
                                list = list2;
                                iIntValue = -1;
                            }
                            iIntValue += z10 ? 1 : 0;
                        } else {
                            if (i6 == this.listIdx) {
                                listItem = (ListItem) element;
                                break;
                            }
                            i6 += z10 ? 1 : 0;
                        }
                        while (iIntValue == items.size() - (z10 ? 1 : 0) && !stack.isEmpty()) {
                            Object[] objArr2 = (Object[]) stack.pop();
                            list = (com.itextpdf.text.List) objArr2[z9 ? 1 : 0];
                            ArrayList<Element> items2 = list.getItems();
                            iIntValue = ((Integer) objArr2[z10 ? 1 : 0]).intValue();
                            indentationLeft = ((Float) objArr2[i3]).floatValue();
                            items = items2;
                        }
                        iIntValue += z10 ? 1 : 0;
                    }
                    int i7 = 0;
                    boolean z15 = false;
                    int i8 = 0;
                    ?? r4 = z9;
                    while (i7 < i3) {
                        float f8 = this.yLine;
                        if (this.compositeColumn != null) {
                            z7 = false;
                        } else {
                            if (listItem == null) {
                                this.listIdx = r4;
                                this.compositeElements.removeFirst();
                                break;
                            }
                            ColumnText columnText6 = new ColumnText(this.canvas);
                            this.compositeColumn = columnText6;
                            columnText6.setUseAscender(((z12 || this.descender == 0.0f) && this.adjustFirstLine) ? this.useAscender : false);
                            this.compositeColumn.setInheritGraphicState(this.inheritGraphicState);
                            this.compositeColumn.setAlignment(listItem.getAlignment());
                            this.compositeColumn.setIndent(listItem.getIndentationLeft() + indentationLeft + listItem.getFirstLineIndent(), r4);
                            this.compositeColumn.setExtraParagraphSpace(listItem.getExtraParagraphSpace());
                            ColumnText columnText7 = this.compositeColumn;
                            columnText7.setFollowingIndent(columnText7.getIndent());
                            this.compositeColumn.setRightIndent(listItem.getIndentationRight() + list.getIndentationRight());
                            this.compositeColumn.setLeading(listItem.getLeading(), listItem.getMultipliedLeading());
                            this.compositeColumn.setRunDirection(this.runDirection);
                            this.compositeColumn.setArabicOptions(this.arabicOptions);
                            this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                            this.compositeColumn.addText(listItem);
                            if (!z12 || !this.adjustFirstLine) {
                                this.yLine -= listItem.getSpacingBefore();
                            }
                            z7 = true;
                        }
                        ColumnText columnText8 = this.compositeColumn;
                        columnText8.leftX = this.leftX;
                        columnText8.rightX = this.rightX;
                        columnText8.yLine = this.yLine;
                        columnText8.rectangularWidth = this.rectangularWidth;
                        columnText8.rectangularMode = this.rectangularMode;
                        columnText8.minY = this.minY;
                        columnText8.maxY = this.maxY;
                        boolean z16 = listItem.getKeepTogether() && z7 && !(z12 && this.adjustFirstLine);
                        boolean z17 = z || (z16 && i7 == 0);
                        if (isTagged(this.canvas) && !z17) {
                            listItem.getListLabel().setIndentation(indentationLeft);
                            if (list.getFirstItem() == listItem || ((columnText2 = this.compositeColumn) != null && columnText2.bidiLine != null)) {
                                this.canvas.openMCBlock(list);
                            }
                            this.canvas.openMCBlock(listItem);
                        }
                        int iGo2 = this.compositeColumn.go(z17, listItem);
                        if (isTagged(this.canvas) && !z17) {
                            this.canvas.closeMCBlock(listItem.getListBody());
                            this.canvas.closeMCBlock(listItem);
                        }
                        this.lastX = this.compositeColumn.getLastX();
                        updateFilledWidth(this.compositeColumn.filledWidth);
                        if ((iGo2 & 1) == 0 && z16) {
                            columnText = null;
                            this.compositeColumn = null;
                            this.yLine = f8;
                            z15 = true;
                        } else {
                            columnText = null;
                        }
                        if (z || !z16 || z15) {
                            i8 = iGo2;
                            break;
                        }
                        if (i7 == 0) {
                            this.compositeColumn = columnText;
                            this.yLine = f8;
                        }
                        i7 += z10 ? 1 : 0;
                        i8 = iGo2;
                        r4 = 0;
                    }
                    if (isTagged(this.canvas) && !z && (listItem == null || ((list.getLastItem() == listItem && (i8 & 1) != 0) || (i8 & 2) != 0))) {
                        this.canvas.closeMCBlock(list);
                    }
                    if (z15) {
                        return i3;
                    }
                    if (listItem == null) {
                        i2 = 3;
                        z6 = false;
                    } else {
                        ColumnText columnText9 = this.compositeColumn;
                        this.yLine = columnText9.yLine;
                        this.linesWritten += columnText9.linesWritten;
                        this.descender = columnText9.descender;
                        this.currentLeading = columnText9.currentLeading;
                        if (!isTagged(this.canvas) && !Float.isNaN(this.compositeColumn.firstLineY) && !this.compositeColumn.firstLineYDone) {
                            if (!z) {
                                if (z11) {
                                    showTextAligned(this.canvas, 2, new Phrase(listItem.getListSymbol()), this.compositeColumn.lastX + listItem.getIndentationLeft(), this.compositeColumn.firstLineY, 0.0f, this.runDirection, this.arabicOptions);
                                } else {
                                    PdfContentByte pdfContentByte2 = this.canvas;
                                    Phrase phrase = new Phrase(listItem.getListSymbol());
                                    ColumnText columnText10 = this.compositeColumn;
                                    showTextAligned(pdfContentByte2, 0, phrase, columnText10.leftX + indentationLeft, columnText10.firstLineY, 0.0f);
                                }
                            }
                            this.compositeColumn.firstLineYDone = z10;
                        }
                        if ((i8 & 1) != 0) {
                            this.compositeColumn = null;
                            this.listIdx += z10 ? 1 : 0;
                            this.yLine -= listItem.getSpacingAfter();
                        }
                        if ((i8 & 2) != 0) {
                            return i3;
                        }
                    }
                } else {
                    if (first.type() == 23) {
                        PdfPTable pdfPTable = (PdfPTable) first;
                        int i9 = this.runDirection;
                        int runDirection = pdfPTable.getRunDirection();
                        this.runDirection = runDirection;
                        z11 = runDirection == 3;
                        if (pdfPTable.size() <= pdfPTable.getHeaderRows()) {
                            this.compositeElements.removeFirst();
                        } else {
                            float fSpacingBefore = this.yLine + this.descender;
                            if (this.rowIdx == 0 && this.adjustFirstLine) {
                                fSpacingBefore -= pdfPTable.spacingBefore();
                            }
                            float f9 = fSpacingBefore;
                            if (f9 < this.minY || f9 > this.maxY) {
                                return i3;
                            }
                            float f10 = this.leftX;
                            this.currentLeading = 0.0f;
                            if (pdfPTable.isLockedWidth()) {
                                widthPercentage = pdfPTable.getTotalWidth();
                                updateFilledWidth(widthPercentage);
                            } else {
                                widthPercentage = (this.rectangularWidth * pdfPTable.getWidthPercentage()) / 100.0f;
                                pdfPTable.setTotalWidth(widthPercentage);
                            }
                            pdfPTable.normalizeHeadersFooters();
                            int headerRows = pdfPTable.getHeaderRows();
                            int footerRows = pdfPTable.getFooterRows();
                            int i10 = headerRows - footerRows;
                            float footerHeight = pdfPTable.getFooterHeight();
                            float headerHeight = pdfPTable.getHeaderHeight() - footerHeight;
                            boolean z18 = pdfPTable.isSkipFirstHeader() && this.rowIdx <= i10 && (pdfPTable.isComplete() || this.rowIdx != i10);
                            float f11 = !z18 ? f9 - headerHeight : f9;
                            if (this.rowIdx < headerRows) {
                                this.rowIdx = headerRows;
                            }
                            PdfPTable.FittingRows fittingRows2 = pdfPTable.isSkipLastFooter() ? pdfPTable.getFittingRows(f11 - this.minY, this.rowIdx) : null;
                            if (pdfPTable.isSkipLastFooter()) {
                                PdfPTable.FittingRows fittingRows3 = fittingRows2;
                                if (fittingRows2.lastRow < pdfPTable.size() - 1) {
                                    f11 -= footerHeight;
                                    fittingRows = pdfPTable.getFittingRows(f11 - this.minY, this.rowIdx);
                                } else {
                                    fittingRows = fittingRows3;
                                }
                            } else {
                                f11 -= footerHeight;
                                fittingRows = pdfPTable.getFittingRows(f11 - this.minY, this.rowIdx);
                            }
                            if (f11 < this.minY || f11 > this.maxY) {
                                return 2;
                            }
                            int i11 = fittingRows.lastRow + 1;
                            float f12 = f11 - fittingRows.height;
                            this.LOGGER.info("Want to split at row " + i11);
                            int i12 = i11;
                            while (i12 > this.rowIdx && i12 < pdfPTable.size() && pdfPTable.getRow(i12).isMayNotBreak()) {
                                i12--;
                            }
                            if (i12 < pdfPTable.size() - 1 && !pdfPTable.getRow(i12).isMayNotBreak()) {
                                i12++;
                            }
                            if ((i12 <= this.rowIdx || i12 >= i11) && !(i12 == headerRows && pdfPTable.getRow(headerRows).isMayNotBreak() && pdfPTable.isLoopCheck())) {
                                f = f12;
                            } else {
                                f = this.minY;
                                pdfPTable.setLoopCheck(false);
                                i11 = i12;
                            }
                            this.LOGGER.info("Will split at row " + i11);
                            if (pdfPTable.isSplitLate() && i11 > 0) {
                                fittingRows.correctLastRowChosen(pdfPTable, i11 - 1);
                            }
                            if (!pdfPTable.isComplete()) {
                                f += footerHeight;
                            }
                            if (!pdfPTable.isSplitRows()) {
                                this.splittedRow = -1;
                                if (i11 == this.rowIdx) {
                                    if (i11 != pdfPTable.size()) {
                                        if (!pdfPTable.isComplete() && i11 == 1) {
                                            return 2;
                                        }
                                        pdfPTable.getRows().remove(i11);
                                        return 2;
                                    }
                                    this.compositeElements.removeFirst();
                                }
                            } else if (pdfPTable.isSplitLate() && (this.rowIdx < i11 || (this.splittedRow == -2 && (pdfPTable.getHeaderRows() == 0 || pdfPTable.isSkipFirstHeader())))) {
                                this.splittedRow = -1;
                            } else if (i11 < pdfPTable.size()) {
                                f -= fittingRows.completedRowsHeight - fittingRows.height;
                                PdfPRow pdfPRowSplitRow = pdfPTable.getRow(i11).splitRow(pdfPTable, i11, f - this.minY);
                                if (pdfPRowSplitRow == null) {
                                    this.LOGGER.info("Didn't split row!");
                                    this.splittedRow = -1;
                                    if (this.rowIdx == i11) {
                                        return 2;
                                    }
                                } else {
                                    if (i11 != this.splittedRow) {
                                        i = 1;
                                        this.splittedRow = i11 + 1;
                                        PdfPTable pdfPTable2 = new PdfPTable(pdfPTable);
                                        this.compositeElements.set(0, pdfPTable2);
                                        ArrayList<PdfPRow> rows3 = pdfPTable2.getRows();
                                        for (int i13 = headerRows; i13 < this.rowIdx; i13++) {
                                            rows3.set(i13, null);
                                        }
                                        pdfPTable = pdfPTable2;
                                    } else {
                                        i = 1;
                                    }
                                    f = this.minY;
                                    i11 += i;
                                    pdfPTable.getRows().add(i11, pdfPRowSplitRow);
                                    this.LOGGER.info("Inserting row at position " + i11);
                                }
                            }
                            if (!z) {
                                int horizontalAlignment = pdfPTable.getHorizontalAlignment();
                                if (horizontalAlignment != 1) {
                                    if (horizontalAlignment != 2) {
                                        if (z11) {
                                            f4 = this.rectangularWidth;
                                            f2 = f4 - widthPercentage;
                                        }
                                    } else if (!z11) {
                                        f4 = this.rectangularWidth;
                                        f2 = f4 - widthPercentage;
                                    }
                                    f3 = f10;
                                    pdfPTableShallowCopy = PdfPTable.shallowCopy(pdfPTable);
                                    rows = pdfPTableShallowCopy.getRows();
                                    if (!z18 || i10 <= 0) {
                                        pdfPTableShallowCopy.setHeaderRows(footerRows);
                                    } else {
                                        ArrayList<PdfPRow> rows4 = pdfPTable.getRows(0, i10);
                                        if (isTagged(this.canvas)) {
                                            pdfPTableShallowCopy.getHeader().rows = rows4;
                                        }
                                        rows.addAll(rows4);
                                    }
                                    rows2 = pdfPTable.getRows(this.rowIdx, i11);
                                    if (isTagged(this.canvas)) {
                                        pdfPTableShallowCopy.getBody().rows = rows2;
                                    }
                                    rows.addAll(rows2);
                                    z3 = !pdfPTable.isSkipLastFooter();
                                    if (i11 < pdfPTable.size()) {
                                        pdfPTableShallowCopy.setComplete(true);
                                        z5 = true;
                                        z4 = true;
                                    } else {
                                        z4 = z3;
                                        z5 = false;
                                    }
                                    if (footerRows <= 0 && pdfPTableShallowCopy.isComplete() && z4) {
                                        ArrayList<PdfPRow> rows5 = pdfPTable.getRows(i10, i10 + footerRows);
                                        if (isTagged(this.canvas)) {
                                            pdfPTableShallowCopy.getFooter().rows = rows5;
                                        }
                                        rows.addAll(rows5);
                                    } else {
                                        footerRows = 0;
                                    }
                                    if (rows.size() > 0) {
                                        size = (rows.size() - 1) - footerRows;
                                        pdfPRow = rows.get(size);
                                        if (pdfPTable.isExtendLastRow(z5)) {
                                            maxHeights = pdfPRow.getMaxHeights();
                                            pdfPRow.setMaxHeights((f - this.minY) + maxHeights);
                                            f = this.minY;
                                        } else {
                                            maxHeights = 0.0f;
                                        }
                                        if (z5) {
                                            tableEvent2 = pdfPTable.getTableEvent();
                                            if (tableEvent2 instanceof PdfPTableEventSplit) {
                                                ((PdfPTableEventSplit) tableEvent2).splitTable(pdfPTable);
                                            }
                                        }
                                        pdfContentByteArr = this.canvases;
                                        if (pdfContentByteArr != null) {
                                            if (isTagged(pdfContentByteArr[3])) {
                                                this.canvases[3].openMCBlock(pdfPTable);
                                            }
                                            pdfPTableShallowCopy.writeSelectedRows(0, -1, 0, -1, f3, f9, this.canvases, false);
                                            if (isTagged(this.canvases[3])) {
                                                this.canvases[3].closeMCBlock(pdfPTable);
                                            }
                                        } else {
                                            if (isTagged(this.canvas)) {
                                                this.canvas.openMCBlock(pdfPTable);
                                            }
                                            pdfPTableShallowCopy.writeSelectedRows(0, -1, 0, -1, f3, f9, this.canvas, false);
                                            if (isTagged(this.canvas)) {
                                                this.canvas.closeMCBlock(pdfPTable);
                                            }
                                        }
                                        if (!pdfPTable.isComplete()) {
                                            pdfPTable.addNumberOfRowsWritten(i11);
                                        }
                                        if (this.splittedRow != i11 && i11 < pdfPTable.size()) {
                                            pdfPTable.getRows().get(i11).copyRowContent(pdfPTableShallowCopy, size);
                                        } else if (i11 > 0 && i11 < pdfPTable.size()) {
                                            pdfPTable.getRow(i11).splitRowspans(pdfPTable, i11 - 1, pdfPTableShallowCopy, size);
                                        }
                                        if (pdfPTable.isExtendLastRow(z5)) {
                                            pdfPRow.setMaxHeights(maxHeights);
                                        }
                                        if (z5) {
                                            tableEvent = pdfPTable.getTableEvent();
                                            if (tableEvent instanceof PdfPTableEventAfterSplit) {
                                                ((PdfPTableEventAfterSplit) tableEvent).afterSplitTable(pdfPTable, pdfPTable.getRow(i11), i11);
                                            }
                                        }
                                    }
                                } else {
                                    f2 = (this.rectangularWidth - widthPercentage) / 2.0f;
                                }
                                f10 += f2;
                                f3 = f10;
                                pdfPTableShallowCopy = PdfPTable.shallowCopy(pdfPTable);
                                rows = pdfPTableShallowCopy.getRows();
                                if (z18) {
                                    pdfPTableShallowCopy.setHeaderRows(footerRows);
                                } else {
                                    pdfPTableShallowCopy.setHeaderRows(footerRows);
                                }
                                rows2 = pdfPTable.getRows(this.rowIdx, i11);
                                if (isTagged(this.canvas)) {
                                    pdfPTableShallowCopy.getBody().rows = rows2;
                                }
                                rows.addAll(rows2);
                                z3 = !pdfPTable.isSkipLastFooter();
                                if (i11 < pdfPTable.size()) {
                                    pdfPTableShallowCopy.setComplete(true);
                                    z5 = true;
                                    z4 = true;
                                } else {
                                    z4 = z3;
                                    z5 = false;
                                }
                                if (footerRows <= 0) {
                                    footerRows = 0;
                                } else {
                                    footerRows = 0;
                                }
                                if (rows.size() > 0) {
                                    size = (rows.size() - 1) - footerRows;
                                    pdfPRow = rows.get(size);
                                    if (pdfPTable.isExtendLastRow(z5)) {
                                        maxHeights = pdfPRow.getMaxHeights();
                                        pdfPRow.setMaxHeights((f - this.minY) + maxHeights);
                                        f = this.minY;
                                    } else {
                                        maxHeights = 0.0f;
                                    }
                                    if (z5) {
                                        tableEvent2 = pdfPTable.getTableEvent();
                                        if (tableEvent2 instanceof PdfPTableEventSplit) {
                                            ((PdfPTableEventSplit) tableEvent2).splitTable(pdfPTable);
                                        }
                                    }
                                    pdfContentByteArr = this.canvases;
                                    if (pdfContentByteArr != null) {
                                        if (isTagged(pdfContentByteArr[3])) {
                                            this.canvases[3].openMCBlock(pdfPTable);
                                        }
                                        pdfPTableShallowCopy.writeSelectedRows(0, -1, 0, -1, f3, f9, this.canvases, false);
                                        if (isTagged(this.canvases[3])) {
                                            this.canvases[3].closeMCBlock(pdfPTable);
                                        }
                                    } else {
                                        if (isTagged(this.canvas)) {
                                            this.canvas.openMCBlock(pdfPTable);
                                        }
                                        pdfPTableShallowCopy.writeSelectedRows(0, -1, 0, -1, f3, f9, this.canvas, false);
                                        if (isTagged(this.canvas)) {
                                            this.canvas.closeMCBlock(pdfPTable);
                                        }
                                    }
                                    if (!pdfPTable.isComplete()) {
                                        pdfPTable.addNumberOfRowsWritten(i11);
                                    }
                                    if (this.splittedRow != i11) {
                                        if (i11 > 0) {
                                            pdfPTable.getRow(i11).splitRowspans(pdfPTable, i11 - 1, pdfPTableShallowCopy, size);
                                        }
                                    } else if (i11 > 0) {
                                        pdfPTable.getRow(i11).splitRowspans(pdfPTable, i11 - 1, pdfPTableShallowCopy, size);
                                    }
                                    if (pdfPTable.isExtendLastRow(z5)) {
                                        pdfPRow.setMaxHeights(maxHeights);
                                    }
                                    if (z5) {
                                        tableEvent = pdfPTable.getTableEvent();
                                        if (tableEvent instanceof PdfPTableEventAfterSplit) {
                                            ((PdfPTableEventAfterSplit) tableEvent).afterSplitTable(pdfPTable, pdfPTable.getRow(i11), i11);
                                        }
                                    }
                                }
                            } else if (pdfPTable.isExtendLastRow()) {
                                float f13 = this.minY;
                                if (f13 > -1.0737418E9f) {
                                    f = f13;
                                }
                            }
                            this.yLine = f;
                            this.descender = 0.0f;
                            this.currentLeading = 0.0f;
                            if (!z18 && !pdfPTable.isComplete()) {
                                this.yLine += footerHeight;
                            }
                            while (i11 < pdfPTable.size() && pdfPTable.getRowHeight(i11) <= 0.0f && !pdfPTable.hasRowspan(i11)) {
                                i11++;
                            }
                            if (i11 < pdfPTable.size()) {
                                if (this.splittedRow > -1) {
                                    ArrayList<PdfPRow> rows6 = pdfPTable.getRows();
                                    for (int i14 = this.rowIdx; i14 < i11; i14++) {
                                        rows6.set(i14, null);
                                    }
                                }
                                this.rowIdx = i11;
                                return 2;
                            }
                            float fSpacingAfter = this.yLine - pdfPTable.spacingAfter();
                            float f14 = this.minY;
                            if (fSpacingAfter < f14) {
                                this.yLine = f14;
                            } else {
                                this.yLine -= pdfPTable.spacingAfter();
                            }
                            this.compositeElements.removeFirst();
                            this.splittedRow = -1;
                            this.rowIdx = 0;
                            this.runDirection = i9;
                            z11 = i9 == 3;
                            i3 = 2;
                            z2 = false;
                            z12 = z2;
                            i2 = 3;
                            z6 = false;
                        }
                        z12 = z12;
                        i2 = 3;
                        z6 = false;
                        i3 = 2;
                    } else {
                        z2 = z12;
                        if (first.type() == 55) {
                            if (!z) {
                                ((DrawInterface) first).draw(this.canvas, this.leftX, this.minY, this.rightX, this.maxY, this.yLine);
                            }
                            this.compositeElements.removeFirst();
                        } else if (first.type() == 37) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                arrayList.add(first);
                                this.compositeElements.removeFirst();
                                first = !this.compositeElements.isEmpty() ? this.compositeElements.getFirst() : null;
                                if (first == null) {
                                    break;
                                }
                            } while (first.type() == 37);
                            FloatLayout floatLayout = new FloatLayout(arrayList, this.useAscender);
                            floatLayout.setSimpleColumn(this.leftX, this.minY, this.rightX, this.yLine);
                            floatLayout.compositeColumn.setIgnoreSpacingBefore(isIgnoreSpacingBefore());
                            int iLayout = floatLayout.layout(this.canvas, z);
                            this.yLine = floatLayout.getYLine();
                            this.descender = 0.0f;
                            if ((iLayout & 1) == 0) {
                                this.compositeElements.addAll(arrayList);
                                return iLayout;
                            }
                        } else {
                            this.compositeElements.removeFirst();
                        }
                        z12 = z2;
                        i2 = 3;
                        z6 = false;
                    }
                    z10 = true;
                }
                f5 = 0.0f;
                z9 = z6;
            }
            z2 = false;
            z12 = z2;
            i2 = 3;
            z6 = false;
            z10 = true;
            f5 = 0.0f;
            z9 = z6;
        }
        return z10 ? 1 : 0;
    }

    public boolean isAdjustFirstLine() {
        return this.adjustFirstLine;
    }

    public boolean isIgnoreSpacingBefore() {
        return this.ignoreSpacingBefore;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public boolean isWordSplit() {
        return this.isWordSplit;
    }

    public ColumnText setACopy(ColumnText columnText) {
        if (columnText != null) {
            setSimpleVars(columnText);
            if (columnText.bidiLine != null) {
                this.bidiLine = new BidiLine(columnText.bidiLine);
            }
        }
        return this;
    }

    public void setAdjustFirstLine(boolean z) {
        this.adjustFirstLine = z;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setArabicOptions(int i) {
        this.arabicOptions = i;
    }

    public void setCanvas(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
        this.canvases = null;
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvas(pdfContentByte);
        }
    }

    public void setCanvases(PdfContentByte[] pdfContentByteArr) {
        this.canvases = pdfContentByteArr;
        this.canvas = pdfContentByteArr[3];
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvases(pdfContentByteArr);
        }
    }

    public void setColumns(float[] fArr, float[] fArr2) {
        this.maxY = -1.0E21f;
        this.minY = 1.0E21f;
        setYLine(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.rightWall = convertColumn(fArr2);
        this.leftWall = convertColumn(fArr);
        this.rectangularWidth = -1.0f;
        this.rectangularMode = false;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void setFollowingIndent(float f) {
        this.followingIndent = f;
        this.lastWasNewline = true;
    }

    public void setIgnoreSpacingBefore(boolean z) {
        this.ignoreSpacingBefore = z;
    }

    public void setIndent(float f) {
        setIndent(f, true);
    }

    public void setInheritGraphicState(boolean z) {
        this.inheritGraphicState = z;
    }

    public void setLeading(float f) {
        this.fixedLeading = f;
        this.multipliedLeading = 0.0f;
    }

    public void setRightIndent(float f) {
        this.rightIndent = f;
        this.lastWasNewline = true;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public void setSimpleColumn(Phrase phrase, float f, float f2, float f3, float f4, float f5, int i) {
        addText(phrase);
        setSimpleColumn(f, f2, f3, f4, f5, i);
    }

    public void setSimpleVars(ColumnText columnText) {
        this.maxY = columnText.maxY;
        this.minY = columnText.minY;
        this.alignment = columnText.alignment;
        this.leftWall = null;
        if (columnText.leftWall != null) {
            this.leftWall = new ArrayList<>(columnText.leftWall);
        }
        this.rightWall = null;
        if (columnText.rightWall != null) {
            this.rightWall = new ArrayList<>(columnText.rightWall);
        }
        this.yLine = columnText.yLine;
        this.currentLeading = columnText.currentLeading;
        this.fixedLeading = columnText.fixedLeading;
        this.multipliedLeading = columnText.multipliedLeading;
        this.canvas = columnText.canvas;
        this.canvases = columnText.canvases;
        this.lineStatus = columnText.lineStatus;
        this.indent = columnText.indent;
        this.followingIndent = columnText.followingIndent;
        this.rightIndent = columnText.rightIndent;
        this.extraParagraphSpace = columnText.extraParagraphSpace;
        this.rectangularWidth = columnText.rectangularWidth;
        this.rectangularMode = columnText.rectangularMode;
        this.spaceCharRatio = columnText.spaceCharRatio;
        this.lastWasNewline = columnText.lastWasNewline;
        this.repeatFirstLineIndent = columnText.repeatFirstLineIndent;
        this.linesWritten = columnText.linesWritten;
        this.arabicOptions = columnText.arabicOptions;
        this.runDirection = columnText.runDirection;
        this.descender = columnText.descender;
        this.composite = columnText.composite;
        this.splittedRow = columnText.splittedRow;
        if (columnText.composite) {
            this.compositeElements = new LinkedList<>();
            for (Element element : columnText.compositeElements) {
                if (element instanceof PdfPTable) {
                    this.compositeElements.add(new PdfPTable((PdfPTable) element));
                } else {
                    this.compositeElements.add(element);
                }
            }
            ColumnText columnText2 = columnText.compositeColumn;
            if (columnText2 != null) {
                this.compositeColumn = duplicate(columnText2);
            }
        }
        this.listIdx = columnText.listIdx;
        this.rowIdx = columnText.rowIdx;
        this.firstLineY = columnText.firstLineY;
        this.leftX = columnText.leftX;
        this.rightX = columnText.rightX;
        this.firstLineYDone = columnText.firstLineYDone;
        this.waitPhrase = columnText.waitPhrase;
        this.useAscender = columnText.useAscender;
        this.filledWidth = columnText.filledWidth;
        this.adjustFirstLine = columnText.adjustFirstLine;
        this.inheritGraphicState = columnText.inheritGraphicState;
        this.ignoreSpacingBefore = columnText.ignoreSpacingBefore;
    }

    public void setSpaceCharRatio(float f) {
        this.spaceCharRatio = f;
    }

    public void setText(Phrase phrase) {
        this.bidiLine = null;
        this.composite = false;
        this.compositeColumn = null;
        this.compositeElements = null;
        this.listIdx = 0;
        this.rowIdx = 0;
        this.splittedRow = -1;
        this.waitPhrase = phrase;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public void updateFilledWidth(float f) {
        if (f > this.filledWidth) {
            this.filledWidth = f;
        }
    }

    public boolean zeroHeightElement() {
        return this.composite && !this.compositeElements.isEmpty() && this.compositeElements.getFirst().type() == 55;
    }

    public int go(boolean z) {
        return go(z, null);
    }

    public void setIndent(float f, boolean z) {
        this.indent = f;
        this.lastWasNewline = true;
        this.repeatFirstLineIndent = z;
    }

    /* JADX WARN: Code duplicated, block: B:135:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:137:0x02cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:141:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:142:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:144:0x0308  */
    /* JADX WARN: Code duplicated, block: B:150:0x0316  */
    /* JADX WARN: Code duplicated, block: B:153:0x0321  */
    /* JADX WARN: Code duplicated, block: B:154:0x0324  */
    public int go(boolean z, IAccessibleElement iAccessibleElement) {
        PdfContentByte pdfContentByte;
        PdfContentByte pdfContentByte2;
        PdfDocument pdfDocument;
        float f;
        boolean z2;
        PdfLine pdfLineProcessLine;
        float f2;
        boolean z3;
        boolean z4;
        ListBody listBody;
        boolean z5;
        float f3;
        float f4;
        boolean z6;
        PdfContentByte duplicate;
        this.isWordSplit = false;
        if (this.composite) {
            return goComposite(z);
        }
        ListBody listBody2 = (isTagged(this.canvas) && (iAccessibleElement instanceof ListItem)) ? ((ListItem) iAccessibleElement).getListBody() : null;
        addWaitingPhrase();
        int i = 1;
        if (this.bidiLine == null) {
            return 1;
        }
        this.descender = 0.0f;
        this.linesWritten = 0;
        this.lastX = 0.0f;
        float spaceCharRatio = this.spaceCharRatio;
        Object[] objArr = new Object[2];
        objArr[1] = new Float(0.0f);
        this.firstLineY = Float.NaN;
        int i2 = this.runDirection;
        PdfContentByte pdfContentByte3 = this.canvas;
        if (pdfContentByte3 != null) {
            PdfDocument pdfDocument2 = pdfContentByte3.getPdfDocument();
            if (!isTagged(this.canvas)) {
                duplicate = this.canvas.getDuplicate(this.inheritGraphicState);
            } else {
                duplicate = this.canvas;
            }
            pdfContentByte2 = pdfContentByte3;
            pdfDocument = pdfDocument2;
            pdfContentByte = duplicate;
        } else {
            if (!z) {
                throw new NullPointerException(MessageLocalization.getComposedMessage("columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null", new Object[0]));
            }
            pdfContentByte = null;
            pdfContentByte2 = null;
            pdfDocument = null;
        }
        if (!z) {
            if (spaceCharRatio == 0.0f) {
                spaceCharRatio = pdfContentByte.getPdfWriter().getSpaceCharRatio();
            } else if (spaceCharRatio < 0.001f) {
                spaceCharRatio = 0.001f;
            }
        }
        if (!this.rectangularMode) {
            Iterator<PdfChunk> it = this.bidiLine.chunks.iterator();
            float fMax = 0.0f;
            while (it.hasNext()) {
                fMax = Math.max(fMax, it.next().height());
            }
            this.currentLeading = this.fixedLeading + (fMax * this.multipliedLeading);
        }
        boolean z7 = false;
        boolean z8 = false;
        PdfFont pdfFont = null;
        while (true) {
            float f5 = this.lastWasNewline ? this.indent : this.followingIndent;
            if (!this.rectangularMode) {
                f = spaceCharRatio;
                z2 = z8;
                float f6 = this.yLine - this.currentLeading;
                float[] fArrFindLimitsTwoLines = findLimitsTwoLines();
                if (fArrFindLimitsTwoLines == null) {
                    i = this.bidiLine.isEmpty() ? 3 : 2;
                    this.yLine = f6;
                    z8 = z2;
                } else {
                    if (this.bidiLine.isEmpty()) {
                        this.yLine = f6;
                        z8 = z2;
                    } else {
                        float fMax2 = Math.max(fArrFindLimitsTwoLines[0], fArrFindLimitsTwoLines[2]);
                        float fMin = Math.min(fArrFindLimitsTwoLines[1], fArrFindLimitsTwoLines[3]) - fMax2;
                        float f7 = this.rightIndent;
                        if (fMin <= f5 + f7) {
                            z8 = z2;
                        } else {
                            PdfLine pdfLineProcessLine2 = this.bidiLine.processLine(fMax2, (fMin - f5) - f7, this.alignment, i2, this.arabicOptions, this.minY, this.yLine, this.descender);
                            if (z || z7) {
                                z8 = z2;
                            } else {
                                if (pdfLineProcessLine2.isRTL && this.canvas.isTagged()) {
                                    this.canvas.beginMarkedContentSequence(PdfName.REVERSEDCHARS);
                                    z8 = true;
                                } else {
                                    z8 = z2;
                                }
                                pdfContentByte.beginText();
                                z7 = true;
                            }
                            if (pdfLineProcessLine2 == null) {
                                this.yLine = f6;
                            } else {
                                pdfLineProcessLine = pdfLineProcessLine2;
                                f2 = fMax2;
                                z3 = z7;
                                z4 = z8;
                                if (isTagged(this.canvas)) {
                                    listBody = null;
                                } else {
                                    listBody = null;
                                }
                                if (z) {
                                    if (listBody2 != null) {
                                        this.canvas.openMCBlock(listBody2);
                                        listBody2 = listBody;
                                    }
                                    objArr[0] = pdfFont;
                                    if (pdfLineProcessLine.isRTL()) {
                                        f4 = this.rightIndent;
                                    } else {
                                        f4 = f5;
                                    }
                                    pdfContentByte.setTextMatrix(f2 + f4 + pdfLineProcessLine.indentLeft(), this.yLine);
                                    this.lastX = pdfDocument.writeLineToContent(pdfLineProcessLine, pdfContentByte, pdfContentByte2, objArr, f);
                                    pdfFont = (PdfFont) objArr[0];
                                }
                                if (this.repeatFirstLineIndent) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                this.lastWasNewline = z5;
                                float f8 = this.yLine;
                                if (pdfLineProcessLine.isNewlineSplit()) {
                                    f3 = this.extraParagraphSpace;
                                } else {
                                    f3 = 0.0f;
                                }
                                this.yLine = f8 - f3;
                                this.linesWritten++;
                                this.descender = pdfLineProcessLine.getDescender();
                                pdfContentByte = pdfContentByte;
                                z7 = z3;
                                z8 = z4;
                                i2 = i2;
                            }
                        }
                        spaceCharRatio = f;
                        i = 1;
                    }
                    i = 1;
                }
            } else if (this.rectangularWidth <= this.rightIndent + f5) {
                i = this.bidiLine.isEmpty() ? 3 : 2;
            } else if (!this.bidiLine.isEmpty()) {
                z2 = z8;
                f = spaceCharRatio;
                pdfLineProcessLine = this.bidiLine.processLine(this.leftX, (this.rectangularWidth - f5) - this.rightIndent, this.alignment, i2, this.arabicOptions, this.minY, this.yLine, this.descender);
                this.isWordSplit |= this.bidiLine.isWordSplit();
                if (pdfLineProcessLine == null) {
                    z8 = z2;
                    i = 1;
                } else {
                    float[] maxSize = pdfLineProcessLine.getMaxSize(this.fixedLeading, this.multipliedLeading);
                    if (isUseAscender() && Float.isNaN(this.firstLineY)) {
                        this.currentLeading = pdfLineProcessLine.getAscender();
                    } else {
                        this.currentLeading = Math.max(maxSize[0], maxSize[1] - this.descender);
                    }
                    float f9 = this.yLine;
                    if (f9 <= this.maxY) {
                        float f10 = this.currentLeading;
                        if (f9 - f10 >= this.minY) {
                            this.yLine = f9 - f10;
                            if (z || z7) {
                                z6 = z2;
                            } else {
                                if (pdfLineProcessLine.isRTL && this.canvas.isTagged()) {
                                    this.canvas.beginMarkedContentSequence(PdfName.REVERSEDCHARS);
                                    z6 = true;
                                } else {
                                    z6 = z2;
                                }
                                pdfContentByte.beginText();
                                z7 = true;
                            }
                            if (Float.isNaN(this.firstLineY)) {
                                this.firstLineY = this.yLine;
                            }
                            updateFilledWidth(this.rectangularWidth - pdfLineProcessLine.widthLeft());
                            f2 = this.leftX;
                            z3 = z7;
                            z4 = z6;
                            if (isTagged(this.canvas) || !(iAccessibleElement instanceof ListItem) || Float.isNaN(this.firstLineY) || this.firstLineYDone) {
                                listBody = null;
                            } else {
                                if (z) {
                                    listBody = null;
                                } else {
                                    ListItem listItem = (ListItem) iAccessibleElement;
                                    ListLabel listLabel = listItem.getListLabel();
                                    this.canvas.openMCBlock(listLabel);
                                    Chunk chunk = new Chunk(listItem.getListSymbol());
                                    listBody = null;
                                    chunk.setRole(null);
                                    showTextAligned(this.canvas, 0, new Phrase(chunk), this.leftX + listLabel.getIndentation(), this.firstLineY, 0.0f);
                                    this.canvas.closeMCBlock(listLabel);
                                }
                                this.firstLineYDone = true;
                            }
                            if (z) {
                                if (listBody2 != null) {
                                    this.canvas.openMCBlock(listBody2);
                                    listBody2 = listBody;
                                }
                                objArr[0] = pdfFont;
                                if (pdfLineProcessLine.isRTL()) {
                                    f4 = this.rightIndent;
                                } else {
                                    f4 = f5;
                                }
                                pdfContentByte.setTextMatrix(f2 + f4 + pdfLineProcessLine.indentLeft(), this.yLine);
                                this.lastX = pdfDocument.writeLineToContent(pdfLineProcessLine, pdfContentByte, pdfContentByte2, objArr, f);
                                pdfFont = (PdfFont) objArr[0];
                            }
                            if (this.repeatFirstLineIndent || !pdfLineProcessLine.isNewlineSplit()) {
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                            this.lastWasNewline = z5;
                            float f11 = this.yLine;
                            if (pdfLineProcessLine.isNewlineSplit()) {
                                f3 = this.extraParagraphSpace;
                            } else {
                                f3 = 0.0f;
                            }
                            this.yLine = f11 - f3;
                            this.linesWritten++;
                            this.descender = pdfLineProcessLine.getDescender();
                            pdfContentByte = pdfContentByte;
                            z7 = z3;
                            z8 = z4;
                            i2 = i2;
                            spaceCharRatio = f;
                            i = 1;
                        }
                    }
                    this.bidiLine.restore();
                    z8 = z2;
                }
            }
            if (z7) {
                pdfContentByte.endText();
                PdfContentByte pdfContentByte4 = this.canvas;
                if (pdfContentByte4 != pdfContentByte) {
                    pdfContentByte4.add(pdfContentByte);
                }
                if (z8 && this.canvas.isTagged()) {
                    this.canvas.endMarkedContentSequence();
                }
            }
            return i;
        }
    }

    public void setLeading(float f, float f2) {
        this.fixedLeading = f;
        this.multipliedLeading = f2;
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4, float f5, int i) {
        setLeading(f5);
        this.alignment = i;
        setSimpleColumn(f, f2, f3, f4);
    }

    public static float getWidth(Phrase phrase) {
        return getWidth(phrase, 1, 0);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        float fMax = Math.max(f, f3);
        this.rightX = fMax;
        this.yLine = this.maxY;
        float f5 = fMax - this.leftX;
        this.rectangularWidth = f5;
        if (f5 < 0.0f) {
            this.rectangularWidth = 0.0f;
        }
        this.rectangularMode = true;
    }

    public void addText(Chunk chunk) {
        if (chunk == null || this.composite) {
            return;
        }
        addText(new Phrase(chunk));
    }

    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3) {
        showTextAligned(pdfContentByte, i, phrase, f, f2, f3, 1, 0);
    }

    public void setSimpleColumn(Rectangle rectangle) {
        setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop());
    }
}
