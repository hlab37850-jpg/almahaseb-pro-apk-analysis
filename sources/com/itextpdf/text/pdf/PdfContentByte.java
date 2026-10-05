package com.itextpdf.text.pdf;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import com.itextpdf.tool.xml.html.HTML;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfContentByte {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    public static final int LINE_CAP_BUTT = 0;
    public static final int LINE_CAP_PROJECTING_SQUARE = 2;
    public static final int LINE_CAP_ROUND = 1;
    public static final int LINE_JOIN_BEVEL = 2;
    public static final int LINE_JOIN_MITER = 0;
    public static final int LINE_JOIN_ROUND = 1;
    public static final int TEXT_RENDER_MODE_CLIP = 7;
    public static final int TEXT_RENDER_MODE_FILL = 0;
    public static final int TEXT_RENDER_MODE_FILL_CLIP = 4;
    public static final int TEXT_RENDER_MODE_FILL_STROKE = 2;
    public static final int TEXT_RENDER_MODE_FILL_STROKE_CLIP = 6;
    public static final int TEXT_RENDER_MODE_INVISIBLE = 3;
    public static final int TEXT_RENDER_MODE_STROKE = 1;
    public static final int TEXT_RENDER_MODE_STROKE_CLIP = 5;
    private static HashMap<PdfName, String> abrev;
    private static final float[] unitRect = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected ArrayList<Integer> layerDepth;
    protected PdfDocument pdf;
    protected PdfWriter writer;
    protected ByteBuffer content = new ByteBuffer();
    protected int markedContentSize = 0;
    protected GraphicState state = new GraphicState();
    protected ArrayList<GraphicState> stateList = new ArrayList<>();
    protected int separator = 10;
    private int mcDepth = 0;
    private boolean inText = false;
    private boolean suppressTagging = false;
    private ArrayList<IAccessibleElement> mcElements = new ArrayList<>();
    protected PdfContentByte duplicatedFrom = null;

    public static class UncoloredPattern extends PatternColor {
        protected BaseColor color;
        protected float tint;

        public UncoloredPattern(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
            super(pdfPatternPainter);
            this.color = baseColor;
            this.tint = f;
        }

        @Override // com.itextpdf.text.pdf.PatternColor, com.itextpdf.text.BaseColor
        public boolean equals(Object obj) {
            if (obj instanceof UncoloredPattern) {
                UncoloredPattern uncoloredPattern = (UncoloredPattern) obj;
                if (uncoloredPattern.painter.equals(this.painter) && uncoloredPattern.color.equals(this.color) && uncoloredPattern.tint == this.tint) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        HashMap<PdfName, String> map = new HashMap<>();
        abrev = map;
        map.put(PdfName.BITSPERCOMPONENT, "/BPC ");
        abrev.put(PdfName.COLORSPACE, "/CS ");
        abrev.put(PdfName.DECODE, "/D ");
        abrev.put(PdfName.DECODEPARMS, "/DP ");
        abrev.put(PdfName.FILTER, "/F ");
        abrev.put(PdfName.HEIGHT, "/H ");
        abrev.put(PdfName.IMAGEMASK, "/IM ");
        abrev.put(PdfName.INTENT, "/Intent ");
        abrev.put(PdfName.INTERPOLATE, "/I ");
        abrev.put(PdfName.WIDTH, "/W ");
    }

    public PdfContentByte(PdfWriter pdfWriter) {
        if (pdfWriter != null) {
            this.writer = pdfWriter;
            this.pdf = pdfWriter.getPdfDocument();
        }
    }

    private void HelperCMYK(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4);
    }

    private void HelperRGB(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3);
    }

    private void beginLayer2(PdfOCG pdfOCG) {
        this.content.append("/OC ").append(getPageResources().addProperty((PdfName) this.writer.addSimpleProperty(pdfOCG, pdfOCG.getRef())[0], pdfOCG.getRef()).getBytes()).append(" BDC").append_i(this.separator);
    }

    public static ArrayList<double[]> bezierArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return bezierArc(f, f2, f3, f4, f5, f6);
    }

    private void closeMCBlockInt(IAccessibleElement iAccessibleElement) {
        if (!isTagged() || iAccessibleElement.getRole() == null) {
            return;
        }
        PdfStructureElement structElement = this.pdf.getStructElement(iAccessibleElement.getId());
        if (structElement != null) {
            structElement.writeAttributes(iAccessibleElement);
        }
        if (this.writer.needToBeMarkedInContent(iAccessibleElement)) {
            boolean z = this.inText;
            if (z) {
                endText();
            }
            endMarkedContentSequence();
            if (z) {
                beginText(true);
            }
        }
    }

    private boolean compareColors(BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor == null && baseColor2 == null) {
            return true;
        }
        if (baseColor == null || baseColor2 == null) {
            return false;
        }
        return baseColor instanceof ExtendedColor ? baseColor.equals(baseColor2) : baseColor2.equals(baseColor);
    }

    private void ensureDocumentTagIsOpen() {
        PdfDocument pdfDocument = this.pdf;
        if (pdfDocument.openMCDocument) {
            pdfDocument.openMCDocument = false;
            this.writer.getDirectContentUnder().openMCBlock(this.pdf);
        }
    }

    public static PdfTextArray getKernArray(String str, BaseFont baseFont) {
        PdfTextArray pdfTextArray = new PdfTextArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        if (length >= 0) {
            stringBuffer.append(charArray, 0, 1);
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char c = charArray[i2];
            int kerning = baseFont.getKerning(charArray[i], c);
            if (kerning == 0) {
                stringBuffer.append(c);
            } else {
                pdfTextArray.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                stringBuffer.append(charArray, i2, 1);
                pdfTextArray.add(-kerning);
            }
            i = i2;
        }
        pdfTextArray.add(stringBuffer.toString());
        return pdfTextArray;
    }

    private PdfDictionary getParentStructureElement() {
        PdfStructureElement structElement = getMcElements().size() > 0 ? this.pdf.getStructElement(getMcElements().get(getMcElements().size() - 1).getId()) : null;
        return structElement == null ? this.writer.getStructureTreeRoot() : structElement;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00dc  */
    private PdfStructureElement openMCBlockInt(IAccessibleElement iAccessibleElement) {
        PdfStructureElement structElement;
        PdfDictionary pdfDictionary = null;
        if (!isTagged()) {
            return null;
        }
        this.writer.checkElementRole(iAccessibleElement, getMcElements().size() > 0 ? getMcElements().get(getMcElements().size() - 1) : null);
        if (iAccessibleElement.getRole() == null) {
            return null;
        }
        PdfName pdfName = PdfName.ARTIFACT;
        if (pdfName.equals(iAccessibleElement.getRole())) {
            structElement = null;
        } else {
            structElement = this.pdf.getStructElement(iAccessibleElement.getId());
            if (structElement == null) {
                structElement = new PdfStructureElement(getParentStructureElement(), iAccessibleElement.getRole(), iAccessibleElement.getId());
            }
        }
        if (pdfName.equals(iAccessibleElement.getRole())) {
            HashMap<PdfName, PdfObject> accessibleAttributes = iAccessibleElement.getAccessibleAttributes();
            if (accessibleAttributes != null && !accessibleAttributes.isEmpty()) {
                pdfDictionary = new PdfDictionary();
                for (Map.Entry<PdfName, PdfObject> entry : accessibleAttributes.entrySet()) {
                    pdfDictionary.put(entry.getKey(), entry.getValue());
                }
            }
            boolean z = this.inText;
            if (z) {
                endText();
            }
            beginMarkedContentSequence(iAccessibleElement.getRole(), pdfDictionary, true);
            if (z) {
                beginText(true);
            }
        } else if (this.writer.needToBeMarkedInContent(iAccessibleElement)) {
            boolean z2 = this.inText;
            if (z2) {
                endText();
            }
            if (iAccessibleElement.getAccessibleAttributes() != null) {
                PdfName pdfName2 = PdfName.E;
                if (iAccessibleElement.getAccessibleAttribute(pdfName2) != null) {
                    beginMarkedContentSequence(structElement, iAccessibleElement.getAccessibleAttribute(pdfName2).toString());
                    iAccessibleElement.setAccessibleAttribute(pdfName2, null);
                } else {
                    beginMarkedContentSequence(structElement);
                }
            } else {
                beginMarkedContentSequence(structElement);
            }
            if (z2) {
                beginText(true);
            }
        }
        return structElement;
    }

    private void saveColor(BaseColor baseColor, boolean z) {
        if (z) {
            this.state.colorFill = baseColor;
        } else {
            this.state.colorStroke = baseColor;
        }
    }

    private void showText2(String str) {
        FontDetails fontDetails = this.state.fontDetails;
        if (fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        StringUtils.escapeString(fontDetails.convertToBytes(str), this.content);
    }

    public void add(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter = pdfContentByte.writer;
        if (pdfWriter != null && this.writer != pdfWriter) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
        }
        this.content.append(pdfContentByte.content);
        this.markedContentSize += pdfContentByte.markedContentSize;
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        boolean z = isTagged() && pdfAnnotation.getRole() != null && (!(pdfAnnotation instanceof PdfFormField) || ((PdfFormField) pdfAnnotation).getKids() == null);
        if (z) {
            openMCBlock(pdfAnnotation);
        }
        this.writer.addAnnotation(pdfAnnotation);
        if (z) {
            PdfStructureElement structElement = this.pdf.getStructElement(pdfAnnotation.getId());
            if (structElement != null) {
                int structParentIndex = this.pdf.getStructParentIndex(pdfAnnotation);
                pdfAnnotation.put(PdfName.STRUCTPARENT, new PdfNumber(structParentIndex));
                structElement.setAnnotation(pdfAnnotation, getCurrentPage());
                this.writer.getStructureTreeRoot().setAnnotationMark(structParentIndex, structElement.getReference());
            }
            closeMCBlock(pdfAnnotation);
        }
    }

    public PdfName addFormXObj(PdfStream pdfStream, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) {
        return addFormXObj(pdfStream, pdfName, f, f2, f3, f4, f5, f6);
    }

    public void addImage(Image image) {
        addImage(image, false);
    }

    public void addOutline(PdfOutline pdfOutline, String str) {
        checkWriter();
        this.pdf.addOutline(pdfOutline, str);
    }

    public void addPSXObject(PdfPSXObject pdfPSXObject) {
        if (this.inText && isTagged()) {
            endText();
        }
        checkWriter();
        this.content.append(getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfPSXObject, null), pdfPSXObject.getIndirectReference()).getBytes()).append(" Do").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        addTemplate(pdfTemplate, f, f2, f3, f4, f5, f6, false);
    }

    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) {
        addTemplateReference(pdfIndirectReference, pdfName, f, f2, f3, f4, f5, f6);
    }

    public void arc(float f, float f2, float f3, float f4, float f5, float f6) {
        arc(f, f2, f3, f4, f5, f6);
    }

    public void beginLayer(PdfOCG pdfOCG) {
        int i = 0;
        if ((pdfOCG instanceof PdfLayer) && ((PdfLayer) pdfOCG).getTitle() != null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.title.is.not.a.layer", new Object[0]));
        }
        if (this.layerDepth == null) {
            this.layerDepth = new ArrayList<>();
        }
        if (pdfOCG instanceof PdfLayerMembership) {
            this.layerDepth.add(1);
            beginLayer2(pdfOCG);
            return;
        }
        for (PdfLayer parent = (PdfLayer) pdfOCG; parent != null; parent = parent.getParent()) {
            if (parent.getTitle() == null) {
                beginLayer2(parent);
                i++;
            }
        }
        this.layerDepth.add(Integer.valueOf(i));
    }

    public void beginMarkedContentSequence(PdfStructureElement pdfStructureElement) {
        beginMarkedContentSequence(pdfStructureElement, null);
    }

    public void beginText(boolean z) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
            }
            return;
        }
        this.inText = true;
        this.content.append("BT").append_i(this.separator);
        if (!z) {
            GraphicState graphicState = this.state;
            graphicState.xTLM = 0.0f;
            graphicState.yTLM = 0.0f;
            graphicState.tx = 0.0f;
            return;
        }
        GraphicState graphicState2 = this.state;
        float f = graphicState2.xTLM;
        float f2 = graphicState2.tx;
        setTextMatrix(graphicState2.aTLM, graphicState2.bTLM, graphicState2.cTLM, graphicState2.dTLM, f2, graphicState2.yTLM);
        GraphicState graphicState3 = this.state;
        graphicState3.xTLM = f;
        graphicState3.tx = f2;
    }

    public void checkNoPattern(PdfTemplate pdfTemplate) {
        if (pdfTemplate.getType() == 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0017  */
    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    public void checkState() {
        boolean z;
        GraphicState graphicState = this.state;
        int i = graphicState.textRenderMode;
        boolean z2 = false;
        if (i != 0) {
            if (i == 1) {
                z = true;
            } else if (i == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z2) {
                PdfWriter.checkPdfIsoConformance(this.writer, 1, graphicState.colorFill);
            }
            if (z) {
                PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
            }
            PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        }
        z = false;
        z2 = true;
        if (z2) {
            PdfWriter.checkPdfIsoConformance(this.writer, 1, graphicState.colorFill);
        }
        if (z) {
            PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
    }

    public void checkWriter() {
        if (this.writer == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public void circle(float f, float f2, float f3) {
        circle(f, f2, f3);
    }

    public void clip() {
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("W").append_i(this.separator);
    }

    public void closeMCBlock(IAccessibleElement iAccessibleElement) {
        if (isTagged() && iAccessibleElement != null && getMcElements().contains(iAccessibleElement)) {
            closeMCBlockInt(iAccessibleElement);
            getMcElements().remove(iAccessibleElement);
        }
    }

    public void closePath() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append("h").append_i(this.separator);
    }

    public void closePathEoFillStroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("b*").append_i(this.separator);
    }

    public void closePathFillStroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("b").append_i(this.separator);
    }

    public void closePathStroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("s").append_i(this.separator);
    }

    public void concatCTM(float f, float f2, float f3, float f4, float f5, float f6) {
        concatCTM(f, f2, f3, f4, f5, f6);
    }

    public PdfAppearance createAppearance(float f, float f2) {
        return createAppearance(f, f2, null);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4) {
        checkWriter();
        if (f3 == 0.0f || f4 == 0.0f) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return createTemplate(f, f2, null);
    }

    public void curveFromTo(float f, float f2, float f3, float f4) {
        curveFromTo(f, f2, f3, f4);
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        curveTo(f, f2, f3, f4, f5, f6);
    }

    public void drawButton(float f, float f2, float f3, float f4, String str, BaseFont baseFont, float f5) {
        drawButton(f, f2, f3, f4, str, baseFont, f5);
    }

    public void drawRadioField(float f, float f2, float f3, float f4, boolean z) {
        drawRadioField(f, f2, f3, f4, z);
    }

    public void drawTextField(float f, float f2, float f3, float f4) {
        drawTextField(f, f2, f3, f4);
    }

    public void ellipse(float f, float f2, float f3, float f4) {
        ellipse(f, f2, f3, f4);
    }

    public void endLayer() {
        ArrayList<Integer> arrayList = this.layerDepth;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList2 = this.layerDepth;
        int iIntValue = arrayList2.get(arrayList2.size() - 1).intValue();
        ArrayList<Integer> arrayList3 = this.layerDepth;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int i = iIntValue - 1;
            if (iIntValue <= 0) {
                return;
            }
            this.content.append("EMC").append_i(this.separator);
            iIntValue = i;
        }
    }

    public void endMarkedContentSequence() {
        if (getMcDepth() == 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.marked.content.operators", new Object[0]));
        }
        int size = this.content.size();
        setMcDepth(getMcDepth() - 1);
        this.content.append("EMC").append_i(this.separator);
        this.markedContentSize += this.content.size() - size;
    }

    public void endText() {
        if (this.inText) {
            this.inText = false;
            this.content.append("ET").append_i(this.separator);
        } else if (!isTagged()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void eoClip() {
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("W*").append_i(this.separator);
    }

    public void eoFill() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("f*").append_i(this.separator);
    }

    public void eoFillStroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("B*").append_i(this.separator);
    }

    public void fill() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("f").append_i(this.separator);
    }

    public void fillStroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("B").append_i(this.separator);
    }

    public float getCharacterSpacing() {
        return this.state.charSpace;
    }

    public PdfIndirectReference getCurrentPage() {
        return this.writer.getCurrentPage();
    }

    public PdfContentByte getDuplicate() {
        PdfContentByte pdfContentByte = new PdfContentByte(this.writer);
        pdfContentByte.duplicatedFrom = this;
        return pdfContentByte;
    }

    public float getEffectiveStringWidth(String str, boolean z) {
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        float widthPointKerned = z ? baseFont.getWidthPointKerned(str, this.state.size) : baseFont.getWidthPoint(str, this.state.size);
        if (this.state.charSpace != 0.0f && str.length() > 1) {
            widthPointKerned += this.state.charSpace * (str.length() - 1);
        }
        if (this.state.wordSpace != 0.0f && !baseFont.isVertical()) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ') {
                    widthPointKerned += this.state.wordSpace;
                }
            }
        }
        float f = this.state.scale;
        return ((double) f) != 100.0d ? (widthPointKerned * f) / 100.0f : widthPointKerned;
    }

    public float getHorizontalScaling() {
        return this.state.scale;
    }

    public boolean getInText() {
        return this.inText;
    }

    public ByteBuffer getInternalBuffer() {
        return this.content;
    }

    public float getLeading() {
        return this.state.leading;
    }

    public int getMcDepth() {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        return pdfContentByte != null ? pdfContentByte.getMcDepth() : this.mcDepth;
    }

    public ArrayList<IAccessibleElement> getMcElements() {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        return pdfContentByte != null ? pdfContentByte.getMcElements() : this.mcElements;
    }

    public PageResources getPageResources() {
        return this.pdf.getPageResources();
    }

    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public PdfWriter getPdfWriter() {
        return this.writer;
    }

    public PdfOutline getRootOutline() {
        checkWriter();
        return this.pdf.getRootOutline();
    }

    public float getWordSpacing() {
        return this.state.wordSpace;
    }

    public float getXTLM() {
        return this.state.xTLM;
    }

    public float getYTLM() {
        return this.state.yTLM;
    }

    public void inheritGraphicState(PdfContentByte pdfContentByte) {
        this.state = pdfContentByte.state;
        this.stateList = pdfContentByte.stateList;
    }

    public boolean isTagged() {
        PdfWriter pdfWriter = this.writer;
        return (pdfWriter == null || !pdfWriter.isTagged() || isTaggingSuppressed()) ? false : true;
    }

    public boolean isTaggingSuppressed() {
        return this.suppressTagging;
    }

    public void lineTo(float f, float f2) {
        lineTo(f, f2);
    }

    public boolean localDestination(String str, PdfDestination pdfDestination) {
        return this.pdf.localDestination(str, pdfDestination);
    }

    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.pdf.localGoto(str, f, f2, f3, f4);
    }

    public void moveText(float f, float f2) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        GraphicState graphicState = this.state;
        graphicState.xTLM += f;
        graphicState.yTLM += f2;
        if (isTagged()) {
            GraphicState graphicState2 = this.state;
            float f3 = graphicState2.xTLM;
            if (f3 != graphicState2.tx) {
                setTextMatrix(graphicState2.aTLM, graphicState2.bTLM, graphicState2.cTLM, graphicState2.dTLM, f3, graphicState2.yTLM);
                return;
            }
        }
        this.content.append(f).append(' ').append(f2).append(" Td").append_i(this.separator);
    }

    public void moveTextWithLeading(float f, float f2) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        GraphicState graphicState = this.state;
        graphicState.xTLM += f;
        graphicState.yTLM += f2;
        graphicState.leading = -f2;
        if (isTagged()) {
            GraphicState graphicState2 = this.state;
            float f3 = graphicState2.xTLM;
            if (f3 != graphicState2.tx) {
                setTextMatrix(graphicState2.aTLM, graphicState2.bTLM, graphicState2.cTLM, graphicState2.dTLM, f3, graphicState2.yTLM);
                return;
            }
        }
        this.content.append(f).append(' ').append(f2).append(" TD").append_i(this.separator);
    }

    public void moveTo(float f, float f2) {
        moveTo(f, f2);
    }

    public void newPath() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append("n").append_i(this.separator);
    }

    public void newlineShowText(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        GraphicState graphicState = this.state;
        graphicState.yTLM -= graphicState.leading;
        showText2(str);
        this.content.append("'").append_i(this.separator);
        GraphicState graphicState2 = this.state;
        graphicState2.tx = graphicState2.xTLM;
        updateTx(str, 0.0f);
    }

    public void newlineText() {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        if (isTagged()) {
            GraphicState graphicState = this.state;
            float f = graphicState.xTLM;
            if (f != graphicState.tx) {
                setTextMatrix(graphicState.aTLM, graphicState.bTLM, graphicState.cTLM, graphicState.dTLM, f, graphicState.yTLM);
            }
        }
        GraphicState graphicState2 = this.state;
        graphicState2.yTLM -= graphicState2.leading;
        this.content.append("T*").append_i(this.separator);
    }

    public void openMCBlock(IAccessibleElement iAccessibleElement) {
        if (isTagged()) {
            ensureDocumentTagIsOpen();
            if (iAccessibleElement == null || getMcElements().contains(iAccessibleElement)) {
                return;
            }
            PdfStructureElement pdfStructureElementOpenMCBlockInt = openMCBlockInt(iAccessibleElement);
            getMcElements().add(iAccessibleElement);
            if (pdfStructureElementOpenMCBlockInt != null) {
                this.pdf.saveStructElement(iAccessibleElement.getId(), pdfStructureElementOpenMCBlockInt);
            }
        }
    }

    public void outputColorNumbers(BaseColor baseColor, float f) {
        PdfWriter.checkPdfIsoConformance(this.writer, 1, baseColor);
        int type = ExtendedColor.getType(baseColor);
        if (type == 0) {
            this.content.append(baseColor.getRed() / 255.0f);
            this.content.append(' ');
            this.content.append(baseColor.getGreen() / 255.0f);
            this.content.append(' ');
            this.content.append(baseColor.getBlue() / 255.0f);
            return;
        }
        if (type == 1) {
            this.content.append(((GrayColor) baseColor).getGray());
            return;
        }
        if (type != 2) {
            if (type != 3) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.color.type", new Object[0]));
            }
            this.content.append(f);
        } else {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            this.content.append(cMYKColor.getCyan()).append(' ').append(cMYKColor.getMagenta());
            this.content.append(' ').append(cMYKColor.getYellow()).append(' ').append(cMYKColor.getBlack());
        }
    }

    public void paintShading(PdfShading pdfShading) {
        this.writer.addSimpleShading(pdfShading);
        PageResources pageResources = getPageResources();
        this.content.append(pageResources.addShading(pdfShading.getShadingName(), pdfShading.getShadingReference()).getBytes()).append(" sh").append_i(this.separator);
        ColorDetails colorDetails = pdfShading.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    public void rectangle(float f, float f2, float f3, float f4) {
        rectangle(f, f2, f3, f4);
    }

    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, str2, f, f2, f3, f4);
    }

    public void reset() {
        reset(true);
    }

    public void resetCMYKColorFill() {
        saveColor(new CMYKColor(0, 0, 0, 1), true);
        this.content.append("0 0 0 1 k").append_i(this.separator);
    }

    public void resetCMYKColorStroke() {
        saveColor(new CMYKColor(0, 0, 0, 1), false);
        this.content.append("0 0 0 1 K").append_i(this.separator);
    }

    public void resetGrayFill() {
        saveColor(new GrayColor(0), true);
        this.content.append("0 g").append_i(this.separator);
    }

    public void resetGrayStroke() {
        saveColor(new GrayColor(0), false);
        this.content.append("0 G").append_i(this.separator);
    }

    public void resetRGBColorFill() {
        resetGrayFill();
    }

    public void resetRGBColorStroke() {
        resetGrayStroke();
    }

    public void restoreMCBlocks(ArrayList<IAccessibleElement> arrayList) {
        if (!isTagged() || arrayList == null) {
            return;
        }
        setMcElements(arrayList);
        for (int i = 0; i < getMcElements().size(); i++) {
            openMCBlockInt(getMcElements().get(i));
        }
    }

    public void restoreState() {
        PdfWriter.checkPdfIsoConformance(this.writer, 12, "Q");
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("Q").append_i(this.separator);
        int size = this.stateList.size() - 1;
        if (size < 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
        }
        this.state.restore(this.stateList.get(size));
        this.stateList.remove(size);
    }

    public void roundRectangle(float f, float f2, float f3, float f4, float f5) {
        roundRectangle(f, f2, f3, f4, f5);
    }

    public void sanityCheck() {
        if (getMcDepth() != 0) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.marked.content.operators", new Object[0]));
        }
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
            }
            endText();
        }
        ArrayList<Integer> arrayList = this.layerDepth;
        if (arrayList != null && !arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
        }
        if (!this.stateList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
        }
    }

    public ArrayList<IAccessibleElement> saveMCBlocks() {
        ArrayList<IAccessibleElement> arrayList = new ArrayList<>();
        if (isTagged()) {
            arrayList = getMcElements();
            for (int i = 0; i < arrayList.size(); i++) {
                closeMCBlockInt(arrayList.get(i));
            }
            setMcElements(new ArrayList<>());
        }
        return arrayList;
    }

    public void saveState() {
        PdfWriter.checkPdfIsoConformance(this.writer, 12, HTML.Tag.Q);
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append(HTML.Tag.Q).append_i(this.separator);
        this.stateList.add(new GraphicState(this.state));
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        this.pdf.setAction(pdfAction, f, f2, f3, f4);
    }

    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        saveColor(new CMYKColor(i, i2, i3, i4), true);
        this.content.append((i & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i2 & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i3 & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i4 & 255) / 255.0f);
        this.content.append(" k").append_i(this.separator);
    }

    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        saveColor(new CMYKColor(f, f2, f3, f4), true);
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" k").append_i(this.separator);
    }

    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        saveColor(new CMYKColor(i, i2, i3, i4), false);
        this.content.append((i & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i2 & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i3 & 255) / 255.0f);
        this.content.append(' ');
        this.content.append((i4 & 255) / 255.0f);
        this.content.append(" K").append_i(this.separator);
    }

    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        saveColor(new CMYKColor(f, f2, f3, f4), false);
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" K").append_i(this.separator);
    }

    public void setCharacterSpacing(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.charSpace = f;
        this.content.append(f).append(" Tc").append_i(this.separator);
    }

    public void setColorFill(BaseColor baseColor) {
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayFill(((GrayColor) baseColor).getGray());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorFillF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorFill(spotColor.getPdfSpotColor(), spotColor.getTint());
                break;
            case 4:
                setPatternFill(((PatternColor) baseColor).getPainter());
                break;
            case 5:
                setShadingFill(((ShadingColor) baseColor).getPdfShadingPattern());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                setColorFill(deviceNColor.getPdfDeviceNColor(), deviceNColor.getTints());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                setColorFill(labColor.getLabColorSpace(), labColor.getL(), labColor.getA(), labColor.getB());
                break;
            default:
                setRGBColorFill(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                break;
        }
        int alpha = baseColor.getAlpha();
        if (alpha < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.setFillOpacity(alpha / 255.0f);
            setGState(pdfGState);
        }
    }

    public void setColorStroke(BaseColor baseColor) {
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayStroke(((GrayColor) baseColor).getGray());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorStrokeF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorStroke(spotColor.getPdfSpotColor(), spotColor.getTint());
                break;
            case 4:
                setPatternStroke(((PatternColor) baseColor).getPainter());
                break;
            case 5:
                setShadingStroke(((ShadingColor) baseColor).getPdfShadingPattern());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                setColorStroke(deviceNColor.getPdfDeviceNColor(), deviceNColor.getTints());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                setColorStroke(labColor.getLabColorSpace(), labColor.getL(), labColor.getA(), labColor.getB());
                break;
            default:
                setRGBColorStroke(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                break;
        }
        int alpha = baseColor.getAlpha();
        if (alpha < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.setStrokeOpacity(alpha / 255.0f);
            setGState(pdfGState);
        }
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        getPageResources().addDefaultColor(pdfName, pdfObject);
    }

    public void setFlatness(float f) {
        setFlatness(f);
    }

    public void setFontAndSize(BaseFont baseFont, float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        checkWriter();
        if (f < 1.0E-4f && f > -1.0E-4f) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("font.size.too.small.1", String.valueOf(f)));
        }
        GraphicState graphicState = this.state;
        graphicState.size = f;
        graphicState.fontDetails = this.writer.addSimple(baseFont);
        this.content.append(getPageResources().addFont(this.state.fontDetails.getFontName(), this.state.fontDetails.getIndirectReference()).getBytes()).append(' ').append(f).append(" Tf").append_i(this.separator);
    }

    public void setGState(PdfGState pdfGState) {
        PdfObject[] pdfObjectArrAddSimpleExtGState = this.writer.addSimpleExtGState(pdfGState);
        PdfName pdfNameAddExtGState = getPageResources().addExtGState((PdfName) pdfObjectArrAddSimpleExtGState[0], (PdfIndirectReference) pdfObjectArrAddSimpleExtGState[1]);
        this.state.extGState = pdfGState;
        this.content.append(pdfNameAddExtGState.getBytes()).append(" gs").append_i(this.separator);
    }

    public void setGrayFill(float f) {
        saveColor(new GrayColor(f), true);
        this.content.append(f).append(" g").append_i(this.separator);
    }

    public void setGrayStroke(float f) {
        saveColor(new GrayColor(f), false);
        this.content.append(f).append(" G").append_i(this.separator);
    }

    public void setHorizontalScaling(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.scale = f;
        this.content.append(f).append(" Tz").append_i(this.separator);
    }

    public void setLeading(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.leading = f;
        this.content.append(f).append(" TL").append_i(this.separator);
    }

    public void setLineCap(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.content.append(i).append(" J").append_i(this.separator);
    }

    public void setLineDash(float f) {
        setLineDash(f);
    }

    public void setLineJoin(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.content.append(i).append(" j").append_i(this.separator);
    }

    public void setLineWidth(float f) {
        setLineWidth(f);
    }

    public void setLiteral(String str) {
        this.content.append(str);
    }

    public void setMcDepth(int i) {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            pdfContentByte.setMcDepth(i);
        } else {
            this.mcDepth = i;
        }
    }

    public void setMcElements(ArrayList<IAccessibleElement> arrayList) {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            pdfContentByte.setMcElements(arrayList);
        } else {
            this.mcElements = arrayList;
        }
    }

    public void setMiterLimit(float f) {
        setMiterLimit(f);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternFill(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        PdfName pdfNameAddPattern = getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        saveColor(new PatternColor(pdfPatternPainter), true);
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(pdfNameAddPattern.getBytes()).append(" scn").append_i(this.separator);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternStroke(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternStroke(pdfPatternPainter, baseColor, 0.0f);
        }
    }

    public void setRGBColorFill(int i, int i2, int i3) {
        saveColor(new BaseColor(i, i2, i3), true);
        HelperRGB((i & 255) / 255.0f, (i2 & 255) / 255.0f, (i3 & 255) / 255.0f);
        this.content.append(" rg").append_i(this.separator);
    }

    public void setRGBColorFillF(float f, float f2, float f3) {
        saveColor(new BaseColor(f, f2, f3), true);
        HelperRGB(f, f2, f3);
        this.content.append(" rg").append_i(this.separator);
    }

    public void setRGBColorStroke(int i, int i2, int i3) {
        saveColor(new BaseColor(i, i2, i3), false);
        HelperRGB((i & 255) / 255.0f, (i2 & 255) / 255.0f, (i3 & 255) / 255.0f);
        this.content.append(" RG").append_i(this.separator);
    }

    public void setRGBColorStrokeF(float f, float f2, float f3) {
        saveColor(new BaseColor(f, f2, f3), false);
        HelperRGB(f, f2, f3);
        this.content.append(" RG").append_i(this.separator);
    }

    public void setRenderingIntent(PdfName pdfName) {
        this.content.append(pdfName.getBytes()).append(" ri").append_i(this.separator);
    }

    public void setShadingFill(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        PdfName pdfNameAddPattern = pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference());
        saveColor(new ShadingColor(pdfShadingPattern), true);
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(pdfNameAddPattern.getBytes()).append(" scn").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    public void setShadingStroke(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        PdfName pdfNameAddPattern = pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference());
        saveColor(new ShadingColor(pdfShadingPattern), false);
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(pdfNameAddPattern.getBytes()).append(" SCN").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    public PdfContentByte setSuppressTagging(boolean z) {
        this.suppressTagging = z;
        return this;
    }

    public void setTextMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        GraphicState graphicState = this.state;
        graphicState.xTLM = f5;
        graphicState.yTLM = f6;
        graphicState.aTLM = f;
        graphicState.bTLM = f2;
        graphicState.cTLM = f3;
        graphicState.dTLM = f4;
        graphicState.tx = f5;
        this.content.append(f).append(' ').append(f2).append_i(32).append(f3).append_i(32).append(f4).append_i(32).append(f5).append_i(32).append(f6).append(" Tm").append_i(this.separator);
    }

    public void setTextRenderingMode(int i) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.textRenderMode = i;
        this.content.append(i).append(" Tr").append_i(this.separator);
    }

    public void setTextRise(float f) {
        setTextRise(f);
    }

    public void setWordSpacing(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.wordSpace = f;
        this.content.append(f).append(" Tw").append_i(this.separator);
    }

    public void showText(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        showText2(str);
        updateTx(str, 0.0f);
        this.content.append("Tj").append_i(this.separator);
    }

    public void showTextAligned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, false);
    }

    public void showTextAlignedKerned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, true);
    }

    public void showTextGid(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        FontDetails fontDetails = this.state.fontDetails;
        if (fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        Object[] objArrConvertToBytesGid = fontDetails.convertToBytesGid(str);
        StringUtils.escapeString((byte[]) objArrConvertToBytesGid[0], this.content);
        this.state.tx += ((Integer) objArrConvertToBytesGid[2]).intValue() * 0.001f * this.state.size;
        this.content.append("Tj").append_i(this.separator);
    }

    public void showTextKerned(String str) {
        FontDetails fontDetails = this.state.fontDetails;
        if (fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        BaseFont baseFont = fontDetails.getBaseFont();
        if (baseFont.hasKernPairs()) {
            showText(getKernArray(str, baseFont));
        } else {
            showText(str);
        }
    }

    public int size() {
        return size(true);
    }

    public void stroke() {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("S").append_i(this.separator);
    }

    public byte[] toPdf(PdfWriter pdfWriter) {
        sanityCheck();
        return this.content.toByteArray();
    }

    public String toString() {
        return this.content.toString();
    }

    public void transform(AffineTransform affineTransform) {
        if (this.inText && isTagged()) {
            endText();
        }
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.state.CTM.concatenate(affineTransform);
        this.content.append(dArr[0]).append(' ').append(dArr[1]).append(' ').append(dArr[2]).append(' ');
        this.content.append(dArr[3]).append(' ').append(dArr[4]).append(' ').append(dArr[5]).append(" cm").append_i(this.separator);
    }

    public void updateTx(String str, float f) {
        this.state.tx += getEffectiveStringWidth(str, false, f);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0129  */
    /* JADX WARN: Code duplicated, block: B:62:0x012d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x013a  */
    /* JADX WARN: Code duplicated, block: B:68:0x013e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0150  */
    /* JADX WARN: Code duplicated, block: B:72:0x0152  */
    /* JADX WARN: Code duplicated, block: B:75:0x0159  */
    /* JADX WARN: Code duplicated, block: B:76:0x015b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0167 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0169  */
    /* JADX WARN: Code duplicated, block: B:83:0x016f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0171  */
    /* JADX WARN: Code duplicated, block: B:85:0x0175  */
    /* JADX WARN: Code duplicated, block: B:87:0x017a  */
    /* JADX WARN: Code duplicated, block: B:89:0x018b  */
    public void variableRectangle(Rectangle rectangle) {
        BaseColor baseColor;
        float f;
        boolean z;
        boolean z2;
        boolean zCompareColors;
        boolean zCompareColors2;
        float f2;
        float f3;
        float top = rectangle.getTop();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float left = rectangle.getLeft();
        float borderWidthTop = rectangle.getBorderWidthTop();
        float borderWidthBottom = rectangle.getBorderWidthBottom();
        float borderWidthRight = rectangle.getBorderWidthRight();
        float borderWidthLeft = rectangle.getBorderWidthLeft();
        BaseColor borderColorTop = rectangle.getBorderColorTop();
        BaseColor borderColorBottom = rectangle.getBorderColorBottom();
        BaseColor borderColorRight = rectangle.getBorderColorRight();
        BaseColor borderColorLeft = rectangle.getBorderColorLeft();
        saveState();
        setLineCap(0);
        setLineJoin(0);
        borderColorRight = null;
        if (borderWidthTop > 0.0f) {
            setLineWidth(borderWidthTop);
            if (borderColorTop == null) {
                resetRGBColorStroke();
            } else {
                setColorStroke(borderColorTop);
            }
            float f4 = top - (borderWidthTop / 2.0f);
            moveTo(left, f4);
            lineTo(right, f4);
            stroke();
            f = borderWidthTop;
            baseColor = borderColorTop;
            z = true;
        } else {
            baseColor = null;
            f = 0.0f;
            z = false;
        }
        if (borderWidthBottom > 0.0f) {
            if (borderWidthBottom != f) {
                setLineWidth(borderWidthBottom);
                f = borderWidthBottom;
            }
            if (!z || !compareColors(baseColor, borderColorBottom)) {
                if (borderColorBottom == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorBottom);
                }
                baseColor = borderColorBottom;
                z = true;
            }
            float f5 = bottom + (borderWidthBottom / 2.0f);
            moveTo(right, f5);
            lineTo(left, f5);
            stroke();
        }
        if (borderWidthRight > 0.0f) {
            if (borderWidthRight != f) {
                setLineWidth(borderWidthRight);
                f = borderWidthRight;
            }
            if (!z || !compareColors(baseColor, borderColorRight)) {
                if (borderColorRight == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorRight);
                }
                baseColor = borderColorRight;
                z = true;
            }
            boolean zCompareColors3 = compareColors(borderColorTop, borderColorRight);
            boolean zCompareColors4 = compareColors(borderColorBottom, borderColorRight);
            float f6 = f;
            float f7 = right - (borderWidthRight / 2.0f);
            moveTo(f7, zCompareColors3 ? top : top - borderWidthTop);
            lineTo(f7, zCompareColors4 ? bottom : bottom + borderWidthBottom);
            stroke();
            if (zCompareColors3 && zCompareColors4) {
                f = f6;
                baseColor = baseColor;
            } else {
                if (borderColorRight == null) {
                    resetRGBColorFill();
                } else {
                    setColorFill(borderColorRight);
                }
                if (!zCompareColors3) {
                    moveTo(right, top);
                    float f8 = top - borderWidthTop;
                    lineTo(right, f8);
                    lineTo(right - borderWidthRight, f8);
                    fill();
                }
                if (!zCompareColors4) {
                    moveTo(right, bottom);
                    float f9 = bottom + borderWidthBottom;
                    lineTo(right, f9);
                    lineTo(right - borderWidthRight, f9);
                    fill();
                }
                f = f6;
                baseColor = baseColor;
                z2 = true;
            }
            if (borderWidthLeft > 0.0f) {
                if (borderWidthLeft != f) {
                    setLineWidth(borderWidthLeft);
                }
                if (z || !compareColors(baseColor, borderColorLeft)) {
                    if (borderColorLeft == null) {
                        resetRGBColorStroke();
                    } else {
                        setColorStroke(borderColorLeft);
                    }
                }
                zCompareColors = compareColors(borderColorTop, borderColorLeft);
                zCompareColors2 = compareColors(borderColorBottom, borderColorLeft);
                float f10 = (borderWidthLeft / 2.0f) + left;
                if (zCompareColors) {
                    f2 = top;
                } else {
                    f2 = top - borderWidthTop;
                }
                moveTo(f10, f2);
                if (zCompareColors2) {
                    f3 = bottom;
                } else {
                    f3 = bottom + borderWidthBottom;
                }
                lineTo(f10, f3);
                stroke();
                if (zCompareColors || !zCompareColors2) {
                    if (z2 || !compareColors(borderColorRight, borderColorLeft)) {
                        if (borderColorLeft == null) {
                            resetRGBColorFill();
                        } else {
                            setColorFill(borderColorLeft);
                        }
                    }
                    if (!zCompareColors) {
                        moveTo(left, top);
                        float f11 = top - borderWidthTop;
                        lineTo(left, f11);
                        lineTo(left + borderWidthLeft, f11);
                        fill();
                    }
                    if (!zCompareColors2) {
                        moveTo(left, bottom);
                        float f12 = bottom + borderWidthBottom;
                        lineTo(left, f12);
                        lineTo(left + borderWidthLeft, f12);
                        fill();
                    }
                }
            }
            restoreState();
        }
        z2 = false;
        if (borderWidthLeft > 0.0f) {
            if (borderWidthLeft != f) {
                setLineWidth(borderWidthLeft);
            }
            if (z) {
                if (borderColorLeft == null) {
                    resetRGBColorStroke();
                } else {
                    setColorStroke(borderColorLeft);
                }
            } else if (borderColorLeft == null) {
                resetRGBColorStroke();
            } else {
                setColorStroke(borderColorLeft);
            }
            zCompareColors = compareColors(borderColorTop, borderColorLeft);
            zCompareColors2 = compareColors(borderColorBottom, borderColorLeft);
            float f13 = (borderWidthLeft / 2.0f) + left;
            if (zCompareColors) {
                f2 = top;
            } else {
                f2 = top - borderWidthTop;
            }
            moveTo(f13, f2);
            if (zCompareColors2) {
                f3 = bottom;
            } else {
                f3 = bottom + borderWidthBottom;
            }
            lineTo(f13, f3);
            stroke();
            if (zCompareColors) {
                if (z2) {
                    if (borderColorLeft == null) {
                        resetRGBColorFill();
                    } else {
                        setColorFill(borderColorLeft);
                    }
                } else if (borderColorLeft == null) {
                    resetRGBColorFill();
                } else {
                    setColorFill(borderColorLeft);
                }
                if (!zCompareColors) {
                    moveTo(left, top);
                    float f14 = top - borderWidthTop;
                    lineTo(left, f14);
                    lineTo(left + borderWidthLeft, f14);
                    fill();
                }
                if (!zCompareColors2) {
                    moveTo(left, bottom);
                    float f15 = bottom + borderWidthBottom;
                    lineTo(left, f15);
                    lineTo(left + borderWidthLeft, f15);
                    fill();
                }
            } else {
                if (z2) {
                    if (borderColorLeft == null) {
                        resetRGBColorFill();
                    } else {
                        setColorFill(borderColorLeft);
                    }
                } else if (borderColorLeft == null) {
                    resetRGBColorFill();
                } else {
                    setColorFill(borderColorLeft);
                }
                if (!zCompareColors) {
                    moveTo(left, top);
                    float f16 = top - borderWidthTop;
                    lineTo(left, f16);
                    lineTo(left + borderWidthLeft, f16);
                    fill();
                }
                if (!zCompareColors2) {
                    moveTo(left, bottom);
                    float f17 = bottom + borderWidthBottom;
                    lineTo(left, f17);
                    lineTo(left + borderWidthLeft, f17);
                    fill();
                }
            }
        }
        restoreState();
    }

    private void beginMarkedContentSequence(PdfStructureElement pdfStructureElement, String str) {
        PdfArray pdfArray;
        PdfName pdfName = PdfName.K;
        PdfObject pdfObject = pdfStructureElement.get(pdfName);
        int[] structParentIndexAndNextMarkPoint = this.pdf.getStructParentIndexAndNextMarkPoint(getCurrentPage());
        int i = structParentIndexAndNextMarkPoint[0];
        int i2 = structParentIndexAndNextMarkPoint[1];
        if (pdfObject != null) {
            if (pdfObject.isNumber()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfObject);
                pdfStructureElement.put(pdfName, pdfArray);
            } else {
                if (!pdfObject.isArray()) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("unknown.object.at.k.1", pdfObject.getClass().toString()));
                }
                pdfArray = (PdfArray) pdfObject;
            }
            if (pdfArray.getAsNumber(0) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary(PdfName.MCR);
                pdfDictionary.put(PdfName.PG, getCurrentPage());
                pdfDictionary.put(PdfName.MCID, new PdfNumber(i2));
                pdfArray.add(pdfDictionary);
            }
            pdfStructureElement.setPageMark(this.pdf.getStructParentIndex(getCurrentPage()), -1);
        } else {
            pdfStructureElement.setPageMark(i, i2);
            pdfStructureElement.put(PdfName.PG, getCurrentPage());
        }
        setMcDepth(getMcDepth() + 1);
        int size = this.content.size();
        this.content.append(pdfStructureElement.get(PdfName.S).getBytes()).append(" <</MCID ").append(i2);
        if (str != null) {
            this.content.append("/E (").append(str).append(")");
        }
        this.content.append(">> BDC").append_i(this.separator);
        this.markedContentSize += this.content.size() - size;
    }

    public static ArrayList<double[]> bezierArc(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        int iCeil;
        double d11;
        int i = 1;
        if (d > d3) {
            d8 = d;
            d7 = d3;
        } else {
            d7 = d;
            d8 = d3;
        }
        if (d4 > d2) {
            d10 = d2;
            d9 = d4;
        } else {
            d9 = d2;
            d10 = d4;
        }
        if (Math.abs(d6) <= 90.0d) {
            d11 = d6;
            iCeil = 1;
        } else {
            iCeil = (int) Math.ceil(Math.abs(d6) / 90.0d);
            d11 = d6 / ((double) iCeil);
        }
        double d12 = (d7 + d8) / 2.0d;
        double d13 = (d9 + d10) / 2.0d;
        double d14 = (d8 - d7) / 2.0d;
        double d15 = (d10 - d9) / 2.0d;
        double d16 = 3.141592653589793d;
        double d17 = (d11 * 3.141592653589793d) / 360.0d;
        double dAbs = Math.abs(((1.0d - Math.cos(d17)) * 1.3333333333333333d) / Math.sin(d17));
        ArrayList<double[]> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < iCeil) {
            double d18 = ((d5 + (((double) i2) * d11)) * d16) / 180.0d;
            i2 += i;
            double d19 = ((d5 + (((double) i2) * d11)) * d16) / 180.0d;
            double dCos = Math.cos(d18);
            double dCos2 = Math.cos(d19);
            double dSin = Math.sin(d18);
            double dSin2 = Math.sin(d19);
            if (d11 > 0.0d) {
                arrayList.add(new double[]{d12 + (d14 * dCos), d13 - (d15 * dSin), d12 + ((dCos - (dAbs * dSin)) * d14), d13 - ((dSin + (dCos * dAbs)) * d15), d12 + ((dCos2 + (dAbs * dSin2)) * d14), d13 - ((dSin2 - (dAbs * dCos2)) * d15), d12 + (dCos2 * d14), d13 - (dSin2 * d15)});
            } else {
                arrayList.add(new double[]{d12 + (d14 * dCos), d13 - (d15 * dSin), d12 + ((dCos + (dAbs * dSin)) * d14), d13 - ((dSin - (dCos * dAbs)) * d15), d12 + ((dCos2 - (dAbs * dSin2)) * d14), d13 - ((dSin2 + (dAbs * dCos2)) * d15), d12 + (dCos2 * d14), d13 - (dSin2 * d15)});
            }
            i = 1;
            d16 = 3.141592653589793d;
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    private void showTextAligned(int i, String str, float f, float f2, float f3, boolean z) {
        float effectiveStringWidth;
        float f4;
        float f5;
        float effectiveStringWidth2;
        float f6;
        if (this.state.fontDetails == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
        if (f3 == 0.0f) {
            if (i != 1) {
                if (i != 2) {
                    f6 = f;
                } else {
                    effectiveStringWidth2 = getEffectiveStringWidth(str, z);
                }
                setTextMatrix(f6, f2);
                if (z) {
                    showTextKerned(str);
                    return;
                } else {
                    showText(str);
                    return;
                }
            }
            effectiveStringWidth2 = getEffectiveStringWidth(str, z) / 2.0f;
            f6 = f - effectiveStringWidth2;
            setTextMatrix(f6, f2);
            if (z) {
                showTextKerned(str);
                return;
            } else {
                showText(str);
                return;
            }
        }
        double d = (((double) f3) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        if (i != 1) {
            if (i != 2) {
                f5 = f;
                f4 = f2;
            } else {
                effectiveStringWidth = getEffectiveStringWidth(str, z);
            }
            setTextMatrix(fCos, fSin, -fSin, fCos, f5, f4);
            if (z) {
                showTextKerned(str);
            } else {
                showText(str);
            }
            setTextMatrix(0.0f, 0.0f);
        }
        effectiveStringWidth = getEffectiveStringWidth(str, z) / 2.0f;
        f4 = f2 - (effectiveStringWidth * fSin);
        f5 = f - (effectiveStringWidth * fCos);
        setTextMatrix(fCos, fSin, -fSin, fCos, f5, f4);
        if (z) {
            showTextKerned(str);
        } else {
            showText(str);
        }
        setTextMatrix(0.0f, 0.0f);
    }

    public PdfName addFormXObj(PdfStream pdfStream, PdfName pdfName, double d, double d2, double d3, double d4, double d5, double d6) {
        PdfArtifact pdfArtifact;
        checkWriter();
        PdfWriter.checkPdfIsoConformance(this.writer, 9, pdfStream);
        PdfName pdfNameAddXObject = getPageResources().addXObject(pdfName, this.writer.addToBody(pdfStream).getIndirectReference());
        if (isTagged()) {
            if (this.inText) {
                endText();
            }
            pdfArtifact = new PdfArtifact();
            openMCBlock(pdfArtifact);
        } else {
            pdfArtifact = null;
        }
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(pdfNameAddXObject.getBytes()).append(" Do Q").append_i(this.separator);
        if (isTagged()) {
            closeMCBlock(pdfArtifact);
        }
        return pdfNameAddXObject;
    }

    public void addImage(Image image, boolean z) throws DocumentException {
        if (!image.hasAbsoluteY()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.image.must.have.absolute.positioning", new Object[0]));
        }
        float[] fArrMatrix = image.matrix();
        fArrMatrix[4] = image.getAbsoluteX() - fArrMatrix[4];
        float absoluteY = image.getAbsoluteY() - fArrMatrix[5];
        fArrMatrix[5] = absoluteY;
        addImage(image, fArrMatrix[0], fArrMatrix[1], fArrMatrix[2], fArrMatrix[3], fArrMatrix[4], absoluteY, z);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6) {
        addTemplate(pdfTemplate, d, d2, d3, d4, d5, d6, false);
    }

    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText && isTagged()) {
            endText();
        }
        checkWriter();
        PdfName pdfNameAddXObject = getPageResources().addXObject(pdfName, pdfIndirectReference);
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(pdfNameAddXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    public void arc(double d, double d2, double d3, double d4, double d5, double d6) {
        ArrayList<double[]> arrayListBezierArc = bezierArc(d, d2, d3, d4, d5, d6);
        if (arrayListBezierArc.isEmpty()) {
            return;
        }
        double[] dArr = arrayListBezierArc.get(0);
        moveTo(dArr[0], dArr[1]);
        for (int i = 0; i < arrayListBezierArc.size(); i++) {
            double[] dArr2 = arrayListBezierArc.get(i);
            curveTo(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
        }
    }

    public void circle(double d, double d2, double d3) {
        double d4 = d + d3;
        moveTo(d4, d2);
        double d5 = d3 * ((double) 0.5523f);
        double d6 = d2 + d5;
        double d7 = d + d5;
        double d8 = d2 + d3;
        curveTo(d4, d6, d7, d8, d, d8);
        double d9 = d - d5;
        double d10 = d - d3;
        curveTo(d9, d8, d10, d6, d10, d2);
        double d11 = d2 - d5;
        double d12 = d2 - d3;
        curveTo(d10, d11, d9, d12, d, d12);
        curveTo(d7, d12, d4, d11, d4, d2);
    }

    public void concatCTM(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText && isTagged()) {
            endText();
        }
        this.state.CTM.concatenate(new AffineTransform(d, d2, d3, d4, d5, d6));
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ');
        this.content.append(d4).append(' ').append(d5).append(' ').append(d6).append(" cm").append_i(this.separator);
    }

    public PdfAppearance createAppearance(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfAppearance pdfAppearance = new PdfAppearance(this.writer);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public PdfTemplate createTemplate(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public void curveFromTo(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" y").append_i(this.separator);
    }

    public void curveTo(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(' ').append(d5).append(' ').append(d6).append(" c").append_i(this.separator);
    }

    public void drawButton(double d, double d2, double d3, double d4, String str, BaseFont baseFont, float f) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d6 = d;
            d5 = d3;
        } else {
            d5 = d;
            d6 = d3;
        }
        if (d2 > d4) {
            d8 = d2;
            d7 = d4;
        } else {
            d7 = d2;
            d8 = d4;
        }
        saveState();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        double d9 = d6 - d5;
        double d10 = d8 - d7;
        rectangle(d5, d7, d9, d10);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(192, 192, 192));
        rectangle(d5 + 0.5d, d7 + 0.5d, d9 - 1.0d, d10 - 1.0d);
        fill();
        setColorStroke(new BaseColor(255, 255, 255));
        setLineWidth(1.0f);
        setLineCap(0);
        double d11 = d5 + 1.0d;
        double d12 = d7 + 1.0d;
        moveTo(d11, d12);
        double d13 = d8 - 1.0d;
        lineTo(d11, d13);
        double d14 = d6 - 1.0d;
        lineTo(d14, d13);
        stroke();
        setColorStroke(new BaseColor(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(d11, d12);
        lineTo(d14, d12);
        lineTo(d14, d13);
        stroke();
        resetRGBColorFill();
        beginText();
        setFontAndSize(baseFont, f);
        showTextAligned(1, str, (float) (d5 + (d9 / 2.0d)), (float) (d7 + ((d10 - ((double) f)) / 2.0d)), 0.0f);
        endText();
        restoreState();
    }

    public void drawRadioField(double d, double d2, double d3, double d4, boolean z) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d6 = d;
            d5 = d3;
        } else {
            d5 = d;
            d6 = d3;
        }
        if (d2 > d4) {
            d8 = d2;
            d7 = d4;
        } else {
            d7 = d2;
            d8 = d4;
        }
        saveState();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(192, 192, 192));
        double d9 = d5;
        arc(d5 + 1.0d, d7 + 1.0d, d6 - 1.0d, d8 - 1.0d, 0.0d, 360.0d);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(160, 160, 160));
        arc(d9 + 0.5d, d7 + 0.5d, d6 - 0.5d, d8 - 0.5d, 45.0d, 180.0d);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(0, 0, 0));
        arc(d9 + 1.5d, d7 + 1.5d, d6 - 1.5d, d8 - 1.5d, 45.0d, 180.0d);
        stroke();
        if (z) {
            setLineWidth(1.0f);
            setLineCap(1);
            setColorFill(new BaseColor(0, 0, 0));
            arc(d9 + 4.0d, d7 + 4.0d, d6 - 4.0d, d8 - 4.0d, 0.0d, 360.0d);
            fill();
        }
        restoreState();
    }

    public void drawTextField(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d6 = d;
            d5 = d3;
        } else {
            d5 = d;
            d6 = d3;
        }
        if (d2 > d4) {
            d8 = d2;
            d7 = d4;
        } else {
            d7 = d2;
            d8 = d4;
        }
        saveState();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        double d9 = d6 - d5;
        double d10 = d8 - d7;
        double d11 = d6;
        rectangle(d5, d7, d9, d10);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(255, 255, 255));
        rectangle(d5 + 0.5d, d7 + 0.5d, d9 - 1.0d, d10 - 1.0d);
        fill();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        double d12 = d5 + 1.0d;
        double d13 = d7 + 1.5d;
        moveTo(d12, d13);
        double d14 = d11 - 1.5d;
        lineTo(d14, d13);
        double d15 = d8 - 1.0d;
        lineTo(d14, d15);
        stroke();
        setColorStroke(new BaseColor(160, 160, 160));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(d12, d7 + 1.0d);
        lineTo(d12, d15);
        lineTo(d11 - 1.0d, d15);
        stroke();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        double d16 = d5 + 2.0d;
        moveTo(d16, d7 + 2.0d);
        double d17 = d8 - 2.0d;
        lineTo(d16, d17);
        lineTo(d11 - 2.0d, d17);
        stroke();
        restoreState();
    }

    public void ellipse(double d, double d2, double d3, double d4) {
        arc(d, d2, d3, d4, 0.0d, 360.0d);
    }

    public void lineTo(double d, double d2) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append(d).append(' ').append(d2).append(" l").append_i(this.separator);
    }

    public void moveTo(double d, double d2) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append(d).append(' ').append(d2).append(" m").append_i(this.separator);
    }

    public void rectangle(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (!isTagged()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
            endText();
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" re").append_i(this.separator);
    }

    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, i, f, f2, f3, f4);
    }

    public void reset(boolean z) {
        this.content.reset();
        this.markedContentSize = 0;
        if (z) {
            sanityCheck();
        }
        this.state = new GraphicState();
        this.stateList = new ArrayList<>();
    }

    public void roundRectangle(double d, double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9 = d3;
        if (d9 < 0.0d) {
            double d10 = d + d9;
            d9 = -d9;
            d6 = d10;
        } else {
            d6 = d;
        }
        if (d4 < 0.0d) {
            d8 = -d4;
            d7 = d2 + d4;
        } else {
            d7 = d2;
            d8 = d4;
        }
        double d11 = d5 < 0.0d ? -d5 : d5;
        double d12 = d6 + d11;
        moveTo(d12, d7);
        double d13 = d6 + d9;
        double d14 = d13 - d11;
        lineTo(d14, d7);
        double d15 = d11 * ((double) 0.4477f);
        double d16 = d13 - d15;
        double d17 = d7 + d15;
        double d18 = d7 + d11;
        double d19 = d6;
        double d20 = d7;
        curveTo(d16, d7, d13, d17, d13, d18);
        double d21 = d20 + d8;
        double d22 = d21 - d11;
        lineTo(d13, d22);
        double d23 = d21 - d15;
        curveTo(d13, d23, d16, d21, d14, d21);
        lineTo(d12, d21);
        double d24 = d19 + d15;
        curveTo(d24, d21, d19, d23, d19, d22);
        lineTo(d19, d18);
        curveTo(d19, d17, d24, d20, d12, d20);
    }

    public void setFlatness(double d) {
        if (d < 0.0d || d > 100.0d) {
            return;
        }
        this.content.append(d).append(" i").append_i(this.separator);
    }

    public void setLineDash(double d) {
        this.content.append("[] ").append(d).append(" d").append_i(this.separator);
    }

    public void setLineWidth(double d) {
        this.content.append(d).append(" w").append_i(this.separator);
    }

    public void setLiteral(char c) {
        this.content.append(c);
    }

    public void setMiterLimit(double d) {
        if (d > 1.0d) {
            this.content.append(d).append(" M").append_i(this.separator);
        }
    }

    public void setTextRise(double d) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.content.append(d).append(" Ts").append_i(this.separator);
    }

    public int size(boolean z) {
        return z ? this.content.size() : this.content.size() - this.markedContentSize;
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        addTemplate(pdfTemplate, f, f2, f3, f4, f5, f6, z);
    }

    public PdfContentByte getDuplicate(boolean z) {
        PdfContentByte duplicate = getDuplicate();
        if (z) {
            duplicate.state = this.state;
            duplicate.stateList = this.stateList;
        }
        return duplicate;
    }

    public void setLineDash(float f, float f2) {
        setLineDash(f, f2);
    }

    public void setLiteral(float f) {
        this.content.append(f);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6, boolean z) {
        addTemplate(pdfTemplate, d, d2, d3, d4, d5, d6, true, z);
    }

    public void setLineDash(double d, double d2) {
        this.content.append("[").append(d).append("] ").append(d2).append(" d").append_i(this.separator);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName pdfNameAddPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails colorDetailsAddSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
            PdfName pdfNameAddColor = pageResources.addColor(colorDetailsAddSimplePatternColorspace.getColorSpaceName(), colorDetailsAddSimplePatternColorspace.getIndirectReference());
            saveColor(new UncoloredPattern(pdfPatternPainter, baseColor, f), false);
            this.content.append(pdfNameAddColor.getBytes()).append(" CS").append_i(this.separator);
            outputColorNumbers(baseColor, f);
            this.content.append(' ').append(pdfNameAddPattern.getBytes()).append(" SCN").append_i(this.separator);
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
    }

    private void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6, boolean z, boolean z2) {
        checkWriter();
        checkNoPattern(pdfTemplate);
        PdfWriter.checkPdfIsoConformance(this.writer, 20, pdfTemplate);
        PdfName pdfNameAddXObject = getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfTemplate, null), pdfTemplate.getIndirectReference());
        if (isTagged() && z) {
            if (this.inText) {
                endText();
            }
            if (!pdfTemplate.isContentTagged() && (pdfTemplate.getPageReference() == null || !z2)) {
                pdfTemplate.setPageReference(this.writer.getCurrentPage());
                if (z2) {
                    pdfTemplate.setContentTagged(true);
                    ensureDocumentTagIsOpen();
                    ArrayList<IAccessibleElement> mcElements = getMcElements();
                    if (mcElements != null && mcElements.size() > 0) {
                        pdfTemplate.getMcElements().add(mcElements.get(mcElements.size() - 1));
                    }
                } else {
                    openMCBlock(pdfTemplate);
                }
            } else {
                throw new RuntimeException(MessageLocalization.getComposedMessage("template.with.tagged.could.not.be.used.more.than.once", new Object[0]));
            }
        }
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(pdfNameAddXObject.getBytes()).append(" Do Q").append_i(this.separator);
        if (isTagged() && z && !z2) {
            closeMCBlock(pdfTemplate);
            pdfTemplate.setId(null);
        }
    }

    public void setLineDash(float f, float f2, float f3) {
        setLineDash(f, f2, f3);
    }

    public void setLineDash(double d, double d2, double d3) {
        this.content.append("[").append(d).append(' ').append(d2).append("] ").append(d3).append(" d").append_i(this.separator);
    }

    public void concatCTM(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        concatCTM(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5]);
    }

    public void curveTo(float f, float f2, float f3, float f4) {
        curveTo(f, f2, f3, f4);
    }

    public void paintShading(PdfShadingPattern pdfShadingPattern) {
        paintShading(pdfShadingPattern.getShading());
    }

    public void rectangle(Rectangle rectangle) {
        float left = rectangle.getLeft();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        BaseColor backgroundColor = rectangle.getBackgroundColor();
        if (backgroundColor != null) {
            saveState();
            setColorFill(backgroundColor);
            rectangle(left, bottom, right - left, top - bottom);
            fill();
            restoreState();
        }
        if (rectangle.hasBorders()) {
            if (rectangle.isUseVariableBorders()) {
                variableRectangle(rectangle);
                return;
            }
            if (rectangle.getBorderWidth() != -1.0f) {
                setLineWidth(rectangle.getBorderWidth());
            }
            BaseColor borderColor = rectangle.getBorderColor();
            if (borderColor != null) {
                setColorStroke(borderColor);
            }
            if (rectangle.hasBorder(15)) {
                rectangle(left, bottom, right - left, top - bottom);
            } else {
                if (rectangle.hasBorder(8)) {
                    moveTo(right, bottom);
                    lineTo(right, top);
                }
                if (rectangle.hasBorder(4)) {
                    moveTo(left, bottom);
                    lineTo(left, top);
                }
                if (rectangle.hasBorder(2)) {
                    moveTo(left, bottom);
                    lineTo(right, bottom);
                }
                if (rectangle.hasBorder(1)) {
                    moveTo(left, top);
                    lineTo(right, top);
                }
            }
            stroke();
            if (borderColor != null) {
                resetRGBColorStroke();
            }
        }
    }

    public final void setLineDash(float[] fArr, float f) {
        this.content.append("[");
        for (int i = 0; i < fArr.length; i++) {
            this.content.append(fArr[i]);
            if (i < fArr.length - 1) {
                this.content.append(' ');
            }
        }
        this.content.append("] ").append(f).append(" d").append_i(this.separator);
    }

    public void showText(PdfTextArray pdfTextArray) {
        Object next;
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        if (this.state.fontDetails != null) {
            this.content.append("[");
            Iterator<Object> it = pdfTextArray.getArrayList().iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (next instanceof String) {
                            break;
                        }
                        if (z) {
                            this.content.append(' ');
                        } else {
                            z = true;
                        }
                        Float f = (Float) next;
                        this.content.append(f.floatValue());
                        updateTx("", f.floatValue());
                    } else {
                        this.content.append("]TJ").append_i(this.separator);
                        return;
                    }
                }
                String str = (String) next;
                showText2(str);
                updateTx(str, 0.0f);
            }
        } else {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        addImage(image, f, f2, f3, f4, f5, f6, false);
    }

    public void curveTo(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" v").append_i(this.separator);
    }

    public void addImage(Image image, double d, double d2, double d3, double d4, double d5, double d6) throws DocumentException {
        addImage(image, d, d2, d3, d4, d5, d6, false);
    }

    public PdfPatternPainter createPattern(float f, float f2) {
        return createPattern(f, f2, f, f2);
    }

    public void newlineShowText(float f, float f2, String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        GraphicState graphicState = this.state;
        graphicState.yTLM -= graphicState.leading;
        this.content.append(f).append(' ').append(f2);
        showText2(str);
        this.content.append("\"").append_i(this.separator);
        GraphicState graphicState2 = this.state;
        graphicState2.charSpace = f2;
        graphicState2.wordSpace = f;
        graphicState2.tx = graphicState2.xTLM;
        updateTx(str, 0.0f);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternFill(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternFill(pdfPatternPainter, baseColor, 0.0f);
        }
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, boolean z) {
        if (z && this.state.CTM.getType() != 0) {
            pdfAnnotation.applyCTM(this.state.CTM);
        }
        addAnnotation(pdfAnnotation);
    }

    public void addImage(Image image, AffineTransform affineTransform) throws DocumentException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addImage(image, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], false);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4, BaseColor baseColor) {
        checkWriter();
        if (f3 != 0.0f && f4 != 0.0f) {
            PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer, baseColor);
            pdfPatternPainter.setWidth(f);
            pdfPatternPainter.setHeight(f2);
            pdfPatternPainter.setXStep(f3);
            pdfPatternPainter.setYStep(f4);
            this.writer.addSimplePattern(pdfPatternPainter);
            return pdfPatternPainter;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
    }

    private float getEffectiveStringWidth(String str, boolean z, float f) {
        float widthPoint;
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (z) {
            widthPoint = baseFont.getWidthPointKerned(str, this.state.size);
        } else {
            widthPoint = baseFont.getWidthPoint(str, this.state.size);
        }
        if (this.state.charSpace != 0.0f && str.length() > 0) {
            widthPoint += this.state.charSpace * str.length();
        }
        if (this.state.wordSpace != 0.0f && !baseFont.isVertical()) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    widthPoint += this.state.wordSpace;
                }
            }
        }
        GraphicState graphicState = this.state;
        float f2 = widthPoint - ((f / 1000.0f) * graphicState.size);
        float f3 = graphicState.scale;
        return ((double) f3) != 100.0d ? (f2 * f3) / 100.0f : f2;
    }

    public final void setLineDash(double[] dArr, double d) {
        this.content.append("[");
        for (int i = 0; i < dArr.length; i++) {
            this.content.append(dArr[i]);
            if (i < dArr.length - 1) {
                this.content.append(' ');
            }
        }
        this.content.append("] ").append(d).append(" d").append_i(this.separator);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName pdfNameAddPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails colorDetailsAddSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
            PdfName pdfNameAddColor = pageResources.addColor(colorDetailsAddSimplePatternColorspace.getColorSpaceName(), colorDetailsAddSimplePatternColorspace.getIndirectReference());
            saveColor(new UncoloredPattern(pdfPatternPainter, baseColor, f), true);
            this.content.append(pdfNameAddColor.getBytes()).append(" cs").append_i(this.separator);
            outputColorNumbers(baseColor, f);
            this.content.append(' ').append(pdfNameAddPattern.getBytes()).append(" scn").append_i(this.separator);
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6, boolean z) throws DocumentException {
        addImage(image, f, f2, f3, f4, f5, f6, z);
    }

    public void setTextMatrix(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        setTextMatrix((float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    public void addImage(Image image, double d, double d2, double d3, double d4, double d5, double d6, boolean z) throws DocumentException {
        addImage(image, d, d2, d3, d4, d5, d6, z, false);
    }

    public void beginText() {
        beginText(false);
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0403  */
    /* JADX WARN: Code duplicated, block: B:140:0x0412  */
    /* JADX WARN: Code duplicated, block: B:93:0x0275  */
    /* JADX WARN: Code duplicated, block: B:96:0x0280 A[Catch: IOException -> 0x01ae, TryCatch #6 {IOException -> 0x01ae, blocks: (B:107:0x033a, B:47:0x0158, B:49:0x0167, B:59:0x01d3, B:61:0x01dc, B:79:0x0248, B:81:0x0252, B:83:0x025d, B:99:0x029e, B:94:0x027a, B:96:0x0280, B:98:0x0286, B:100:0x02b2, B:103:0x02f2, B:105:0x0300, B:106:0x030f), top: B:155:0x0158 }] */
    public void addImage(Image image, double d, double d2, double d3, double d4, double d5, double d6, boolean z, boolean z2) throws DocumentException {
        int i;
        String composedMessage;
        PdfContentByte pdfContentByte;
        double d7;
        double d8;
        double d9;
        Iterator<PdfName> it;
        byte[] globalBytes;
        int i2;
        char c;
        char c2;
        PdfContentByte pdfContentByte2 = this;
        try {
            AffineTransform affineTransform = new AffineTransform(d, d2, d3, d4, d5, d6);
            if (image.getLayer() != null) {
                pdfContentByte2.beginLayer(image.getLayer());
            }
            if (isTagged()) {
                try {
                    if (pdfContentByte2.inText) {
                        endText();
                    }
                    Point2D.Float[] floatArr = new Point2D.Float[4];
                    affineTransform.transform(new Point2D.Float[]{new Point2D.Float(0.0f, 0.0f), new Point2D.Float(1.0f, 0.0f), new Point2D.Float(1.0f, 1.0f), new Point2D.Float(0.0f, 1.0f)}, 0, floatArr, 0, 4);
                    float x = -3.4028235E38f;
                    float y = -3.4028235E38f;
                    float x2 = Float.MAX_VALUE;
                    float y2 = Float.MAX_VALUE;
                    int i3 = 0;
                    for (int i4 = 4; i3 < i4; i4 = 4) {
                        if (floatArr[i3].getX() < x2) {
                            x2 = (float) floatArr[i3].getX();
                        }
                        if (floatArr[i3].getX() > x) {
                            x = (float) floatArr[i3].getX();
                        }
                        if (floatArr[i3].getY() < y2) {
                            y2 = (float) floatArr[i3].getY();
                        }
                        if (floatArr[i3].getY() > y) {
                            y = (float) floatArr[i3].getY();
                        }
                        i3++;
                    }
                    image.setAccessibleAttribute(PdfName.BBOX, new PdfArray(new float[]{x2, y2, x, y}));
                } catch (IOException e) {
                    e = e;
                    i = 0;
                    if (image != null) {
                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                    } else {
                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                    }
                    Object[] objArr = new Object[1];
                    objArr[i] = composedMessage;
                    throw new DocumentException(MessageLocalization.getComposedMessage("add.image.exception", objArr), e);
                }
            }
            pdfContentByte2 = this;
            if (pdfContentByte2.writer != null && image.isImgTemplate()) {
                pdfContentByte2.writer.addDirectImageSimple(image);
                PdfTemplate templateData = image.getTemplateData();
                if (image.getAccessibleAttributes() != null) {
                    for (PdfName pdfName : image.getAccessibleAttributes().keySet()) {
                        templateData.setAccessibleAttribute(pdfName, image.getAccessibleAttribute(pdfName));
                    }
                }
                double width = templateData.getWidth();
                double height = templateData.getHeight();
                addTemplate(templateData, d / width, d2 / width, d3 / height, d4 / height, d5, d6, false, false);
                pdfContentByte = this;
                d7 = d;
                d8 = d2;
                d9 = d3;
            } else {
                pdfContentByte = this;
                try {
                    pdfContentByte.content.append("q ");
                    if (affineTransform.isIdentity()) {
                        d7 = d;
                        d8 = d2;
                        d9 = d3;
                    } else {
                        d7 = d;
                        pdfContentByte.content.append(d7).append(' ');
                        d8 = d2;
                        pdfContentByte.content.append(d8).append(' ');
                        d9 = d3;
                        pdfContentByte.content.append(d9).append(' ');
                        pdfContentByte.content.append(d4).append(' ');
                        pdfContentByte.content.append(d5).append(' ');
                        pdfContentByte.content.append(d6).append(" cm");
                    }
                    if (z) {
                        try {
                            pdfContentByte.content.append("\nBI\n");
                            try {
                                PdfImage pdfImage = new PdfImage(image, "", null);
                                if ((image instanceof ImgJBIG2) && (globalBytes = ((ImgJBIG2) image).getGlobalBytes()) != null) {
                                    PdfDictionary pdfDictionary = new PdfDictionary();
                                    pdfDictionary.put(PdfName.JBIG2GLOBALS, pdfContentByte.writer.getReferenceJBIG2Globals(globalBytes));
                                    pdfImage.put(PdfName.DECODEPARMS, pdfDictionary);
                                }
                                PdfWriter.checkPdfIsoConformance(pdfContentByte.writer, 17, pdfImage);
                                Iterator<PdfName> it2 = pdfImage.getKeys().iterator();
                                while (it2.hasNext()) {
                                    PdfName next = it2.next();
                                    PdfObject pdfObject = pdfImage.get(next);
                                    String str = abrev.get(next);
                                    if (str != null) {
                                        pdfContentByte.content.append(str);
                                        PdfName pdfName2 = PdfName.COLORSPACE;
                                        if (next.equals(pdfName2) && pdfObject.isArray()) {
                                            PdfArray pdfArray = (PdfArray) pdfObject;
                                            if (pdfArray.size() == 4) {
                                                it = it2;
                                                try {
                                                    if (PdfName.INDEXED.equals(pdfArray.getAsName(0))) {
                                                        if (pdfArray.getPdfObject(1).isName() && pdfArray.getPdfObject(2).isNumber()) {
                                                            if (pdfArray.getPdfObject(3).isString()) {
                                                            }
                                                        }
                                                        if (next.equals(pdfName2)) {
                                                            PdfName colorspaceName = pdfContentByte.writer.getColorspaceName();
                                                            getPageResources().addColor(colorspaceName, pdfContentByte.writer.addToBody(pdfObject).getIndirectReference());
                                                            pdfObject = colorspaceName;
                                                        }
                                                    }
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    i = 0;
                                                    if (image != null) {
                                                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                                                    } else {
                                                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                                                    }
                                                    Object[] objArr2 = new Object[1];
                                                    objArr2[i] = composedMessage;
                                                    throw new DocumentException(MessageLocalization.getComposedMessage("add.image.exception", objArr2), e);
                                                }
                                            } else {
                                                it = it2;
                                            }
                                            if (next.equals(pdfName2)) {
                                                PdfName colorspaceName2 = pdfContentByte.writer.getColorspaceName();
                                                getPageResources().addColor(colorspaceName2, pdfContentByte.writer.addToBody(pdfObject).getIndirectReference());
                                                pdfObject = colorspaceName2;
                                            }
                                        } else {
                                            it = it2;
                                            if (next.equals(pdfName2) && !pdfObject.isName()) {
                                                PdfName colorspaceName3 = pdfContentByte.writer.getColorspaceName();
                                                getPageResources().addColor(colorspaceName3, pdfContentByte.writer.addToBody(pdfObject).getIndirectReference());
                                                pdfObject = colorspaceName3;
                                            }
                                        }
                                        pdfObject.toPdf(null, pdfContentByte.content);
                                        pdfContentByte.content.append('\n');
                                        it2 = it;
                                    }
                                }
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                pdfImage.writeContent(byteArrayOutputStream);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                pdfContentByte.content.append(String.format("/L %s\n", Integer.valueOf(byteArray.length)));
                                pdfContentByte.content.append("ID\n");
                                pdfContentByte.content.append(byteArray);
                                pdfContentByte.content.append("\nEI\nQ").append_i(pdfContentByte.separator);
                            } catch (IOException e3) {
                                e = e3;
                                i = 0;
                                if (image != null || image.getUrl() == null) {
                                    composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                                } else {
                                    composedMessage = image.getUrl().getPath();
                                }
                                Object[] objArr3 = new Object[1];
                                objArr3[i] = composedMessage;
                                throw new DocumentException(MessageLocalization.getComposedMessage("add.image.exception", objArr3), e);
                            }
                        } catch (IOException e4) {
                            e = e4;
                        }
                    } else {
                        PageResources pageResources = getPageResources();
                        Image imageMask = image.getImageMask();
                        if (imageMask != null) {
                            PdfName pdfNameAddDirectImageSimple = pdfContentByte.writer.addDirectImageSimple(imageMask);
                            pageResources.addXObject(pdfNameAddDirectImageSimple, pdfContentByte.writer.getImageReference(pdfNameAddDirectImageSimple));
                        }
                        PdfName pdfNameAddDirectImageSimple2 = pdfContentByte.writer.addDirectImageSimple(image);
                        pdfContentByte.content.append(' ').append(pageResources.addXObject(pdfNameAddDirectImageSimple2, pdfContentByte.writer.getImageReference(pdfNameAddDirectImageSimple2)).getBytes()).append(" Do Q").append_i(pdfContentByte.separator);
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            }
            if (image.hasBorders()) {
                try {
                    saveState();
                    double width2 = image.getWidth();
                    double d10 = d7 / width2;
                    double d11 = d8 / width2;
                    double height2 = image.getHeight();
                    double d12 = d9 / height2;
                    double d13 = d4 / height2;
                    i2 = 2;
                    c = 0;
                    c2 = 1;
                    concatCTM(d10, d11, d12, d13, d5, d6);
                    rectangle(image);
                    restoreState();
                } catch (IOException e6) {
                    e = e6;
                    i = 0;
                    if (image != null) {
                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                    } else {
                        composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                    }
                    Object[] objArr4 = new Object[1];
                    objArr4[i] = composedMessage;
                    throw new DocumentException(MessageLocalization.getComposedMessage("add.image.exception", objArr4), e);
                }
            } else {
                i2 = 2;
                c = 0;
                c2 = 1;
            }
            if (image.getLayer() != null) {
                endLayer();
            }
            Annotation annotation = image.getAnnotation();
            if (annotation == null) {
                return;
            }
            int length = unitRect.length;
            double[] dArr = new double[length];
            int i5 = 0;
            while (true) {
                float[] fArr = unitRect;
                if (i5 >= fArr.length) {
                    break;
                }
                float f = fArr[i5];
                int i6 = i5 + 1;
                float f2 = fArr[i6];
                dArr[i5] = (((double) f) * d) + (((double) f2) * d3) + d5;
                dArr[i6] = (((double) f) * d2) + (((double) f2) * d4) + d6;
                i5 += i2;
            }
            double dMin = dArr[c];
            double dMin2 = dArr[c2];
            double dMax = dMin2;
            int i7 = 2;
            double dMax2 = dMin;
            while (i7 < length) {
                dMin = Math.min(dMin, dArr[i7]);
                int i8 = i7 + 1;
                dMin2 = Math.min(dMin2, dArr[i8]);
                dMax2 = Math.max(dMax2, dArr[i7]);
                dMax = Math.max(dMax, dArr[i8]);
                i7 += 2;
                annotation = annotation;
            }
            Annotation annotation2 = new Annotation(annotation);
            float f3 = (float) dMin;
            float f4 = (float) dMin2;
            float f5 = (float) dMax2;
            float f6 = (float) dMax;
            annotation2.setDimensions(f3, f4, f5, f6);
            i = 0;
            try {
                PdfAnnotation pdfAnnotationConvertAnnotation = PdfAnnotationsImp.convertAnnotation(this.writer, annotation2, new Rectangle(f3, f4, f5, f6));
                if (pdfAnnotationConvertAnnotation == null) {
                    return;
                }
                addAnnotation(pdfAnnotationConvertAnnotation);
            } catch (IOException e7) {
                e = e7;
                if (image != null) {
                    composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                } else {
                    composedMessage = MessageLocalization.getComposedMessage("unknown", new Object[i]);
                }
                Object[] objArr5 = new Object[1];
                objArr5[i] = composedMessage;
                throw new DocumentException(MessageLocalization.getComposedMessage("add.image.exception", objArr5), e);
            }
        } catch (IOException e8) {
            e = e8;
        }
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternStroke(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        PdfName pdfNameAddPattern = getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        saveColor(new PatternColor(pdfPatternPainter), false);
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(pdfNameAddPattern.getBytes()).append(" SCN").append_i(this.separator);
    }

    public void setTextMatrix(float f, float f2) {
        setTextMatrix(1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public static class GraphicState {
        ColorDetails colorDetails;
        FontDetails fontDetails;
        float size;
        protected float xTLM = 0.0f;
        protected float yTLM = 0.0f;
        protected float aTLM = 1.0f;
        protected float bTLM = 0.0f;
        protected float cTLM = 0.0f;
        protected float dTLM = 1.0f;
        protected float tx = 0.0f;
        protected float leading = 0.0f;
        protected float scale = 100.0f;
        protected float charSpace = 0.0f;
        protected float wordSpace = 0.0f;
        protected BaseColor colorFill = new GrayColor(0);
        protected BaseColor colorStroke = new GrayColor(0);
        protected int textRenderMode = 0;
        protected AffineTransform CTM = new AffineTransform();
        protected PdfObject extGState = null;

        public GraphicState() {
        }

        public void copyParameters(GraphicState graphicState) {
            this.fontDetails = graphicState.fontDetails;
            this.colorDetails = graphicState.colorDetails;
            this.size = graphicState.size;
            this.xTLM = graphicState.xTLM;
            this.yTLM = graphicState.yTLM;
            this.aTLM = graphicState.aTLM;
            this.bTLM = graphicState.bTLM;
            this.cTLM = graphicState.cTLM;
            this.dTLM = graphicState.dTLM;
            this.tx = graphicState.tx;
            this.leading = graphicState.leading;
            this.scale = graphicState.scale;
            this.charSpace = graphicState.charSpace;
            this.wordSpace = graphicState.wordSpace;
            this.colorFill = graphicState.colorFill;
            this.colorStroke = graphicState.colorStroke;
            this.CTM = new AffineTransform(graphicState.CTM);
            this.textRenderMode = graphicState.textRenderMode;
            this.extGState = graphicState.extGState;
        }

        public void restore(GraphicState graphicState) {
            copyParameters(graphicState);
        }

        public GraphicState(GraphicState graphicState) {
            copyParameters(graphicState);
        }
    }

    public PdfPatternPainter createPattern(float f, float f2, BaseColor baseColor) {
        return createPattern(f, f2, f, f2, baseColor);
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new SpotColor(pdfSpotColor, f), true);
        this.content.append(pdfNameAddColor.getBytes()).append(" cs ").append(f).append(" scn").append_i(this.separator);
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new SpotColor(pdfSpotColor, f), false);
        this.content.append(pdfNameAddColor.getBytes()).append(" CS ").append(f).append(" SCN").append_i(this.separator);
    }

    public void beginMarkedContentSequence(PdfName pdfName, PdfDictionary pdfDictionary, boolean z) {
        PdfObject[] pdfObjectArrAddSimpleProperty;
        int size = this.content.size();
        if (pdfDictionary == null) {
            this.content.append(pdfName.getBytes()).append(" BMC").append_i(this.separator);
            setMcDepth(getMcDepth() + 1);
        } else {
            this.content.append(pdfName.getBytes()).append(' ');
            if (z) {
                try {
                    pdfDictionary.toPdf(this.writer, this.content);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } else {
                if (this.writer.propertyExists(pdfDictionary)) {
                    pdfObjectArrAddSimpleProperty = this.writer.addSimpleProperty(pdfDictionary, null);
                } else {
                    PdfWriter pdfWriter = this.writer;
                    pdfObjectArrAddSimpleProperty = pdfWriter.addSimpleProperty(pdfDictionary, pdfWriter.getPdfIndirectReference());
                }
                this.content.append(getPageResources().addProperty((PdfName) pdfObjectArrAddSimpleProperty[0], (PdfIndirectReference) pdfObjectArrAddSimpleProperty[1]).getBytes());
            }
            this.content.append(" BDC").append_i(this.separator);
            setMcDepth(getMcDepth() + 1);
        }
        this.markedContentSize += this.content.size() - size;
    }

    public void setColorFill(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfDeviceNColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.content.append(pdfNameAddColor.getBytes()).append(" cs ");
        for (float f : fArr) {
            this.content.append(f + " ");
        }
        this.content.append("scn").append_i(this.separator);
    }

    public void setColorStroke(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfDeviceNColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.content.append(pdfNameAddColor.getBytes()).append(" CS ");
        for (float f : fArr) {
            this.content.append(f + " ");
        }
        this.content.append("SCN").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, AffineTransform affineTransform) {
        addTemplate(pdfTemplate, affineTransform, false);
    }

    public void addTemplate(PdfTemplate pdfTemplate, AffineTransform affineTransform, boolean z) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addTemplate(pdfTemplate, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], z);
    }

    public void setColorFill(PdfLabColor pdfLabColor, float f, float f2, float f3) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfLabColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new LabColor(pdfLabColor, f, f2, f3), true);
        this.content.append(pdfNameAddColor.getBytes()).append(" cs ");
        this.content.append(f + " " + f2 + " " + f3 + " ");
        this.content.append("scn").append_i(this.separator);
    }

    public void setColorStroke(PdfLabColor pdfLabColor, float f, float f2, float f3) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfLabColor);
        PdfName pdfNameAddColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new LabColor(pdfLabColor, f, f2, f3), true);
        this.content.append(pdfNameAddColor.getBytes()).append(" CS ");
        this.content.append(f + " " + f2 + " " + f3 + " ");
        this.content.append("SCN").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2) {
        addTemplate(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2) {
        addTemplate(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d, d2);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, boolean z) {
        addTemplate(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f, f2, z);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, boolean z) {
        addTemplate(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d, d2, z);
    }

    public void beginMarkedContentSequence(PdfName pdfName) {
        beginMarkedContentSequence(pdfName, null, false);
    }
}
