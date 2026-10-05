package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class PdfContentStreamProcessor {
    public static final String DEFAULTOPERATOR = "DefaultOperator";
    private final RenderListener renderListener;
    private ResourceDictionary resources;
    private Matrix textLineMatrix;
    private Matrix textMatrix;
    private final Map<PdfName, XObjectDoHandler> xobjectDoHandlers;
    private final Stack<GraphicsState> gsStack = new Stack<>();
    private final Map<Integer, CMapAwareDocumentFont> cachedFonts = new HashMap();
    private final Stack<MarkedContentInfo> markedContentStack = new Stack<>();
    private final Map<String, ContentOperator> operators = new HashMap();

    public static class BeginMarkedContent implements ContentOperator {
        private BeginMarkedContent() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.beginMarkedContent((PdfName) arrayList.get(0), new PdfDictionary());
        }
    }

    public static class BeginMarkedContentDictionary implements ContentOperator {
        private BeginMarkedContentDictionary() {
        }

        private PdfDictionary getPropertiesDictionary(PdfObject pdfObject, ResourceDictionary resourceDictionary) {
            return pdfObject.isDictionary() ? (PdfDictionary) pdfObject : resourceDictionary.getAsDict((PdfName) pdfObject);
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.beginMarkedContent((PdfName) arrayList.get(0), getPropertiesDictionary(arrayList.get(1), pdfContentStreamProcessor.resources));
        }
    }

    public static class BeginText implements ContentOperator {
        private BeginText() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix();
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
            pdfContentStreamProcessor.beginText();
        }
    }

    public static class ClipPath implements ContentOperator {
        private int rule;

        public ClipPath(int i) {
            this.rule = i;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.clipPath(this.rule);
        }
    }

    public static class CloseSubpath implements ContentOperator {
        private CloseSubpath() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(6, null);
        }
    }

    public static class Curve implements ContentOperator {
        private Curve() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(3, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(2)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(3)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(4)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(5)).floatValue())));
        }
    }

    public static class CurveFirstPointDuplicated implements ContentOperator {
        private CurveFirstPointDuplicated() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(4, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(2)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(3)).floatValue())));
        }
    }

    public static class CurveFourhPointDuplicated implements ContentOperator {
        private CurveFourhPointDuplicated() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(5, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(2)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(3)).floatValue())));
        }
    }

    public static class Do implements ContentOperator {
        private Do() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.displayXObject((PdfName) arrayList.get(0));
        }
    }

    public static class EndMarkedContent implements ContentOperator {
        private EndMarkedContent() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.endMarkedContent();
        }
    }

    public static class EndPath implements ContentOperator {
        private EndPath() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.paintPath(0, -1, false);
        }
    }

    public static class EndText implements ContentOperator {
        private EndText() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = null;
            pdfContentStreamProcessor.textLineMatrix = null;
            pdfContentStreamProcessor.endText();
        }
    }

    public static class FormXObjectDoHandler implements XObjectDoHandler {
        private FormXObjectDoHandler() {
        }

        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            PdfDictionary asDict = pdfStream.getAsDict(PdfName.RESOURCES);
            try {
                byte[] contentBytesFromContentObject = ContentByteUtils.getContentBytesFromContentObject(pdfStream);
                PdfArray asArray = pdfStream.getAsArray(PdfName.MATRIX);
                new PushGraphicsState().invoke(pdfContentStreamProcessor, null, null);
                if (asArray != null) {
                    Matrix matrix = new Matrix(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue(), asArray.getAsNumber(2).floatValue(), asArray.getAsNumber(3).floatValue(), asArray.getAsNumber(4).floatValue(), asArray.getAsNumber(5).floatValue());
                    pdfContentStreamProcessor.gs().ctm = matrix.multiply(pdfContentStreamProcessor.gs().ctm);
                }
                pdfContentStreamProcessor.processContent(contentBytesFromContentObject, asDict);
                new PopGraphicsState().invoke(pdfContentStreamProcessor, null, null);
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public static class IgnoreOperatorContentOperator implements ContentOperator {
        private IgnoreOperatorContentOperator() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
        }
    }

    public static class IgnoreXObjectDoHandler implements XObjectDoHandler {
        private IgnoreXObjectDoHandler() {
        }

        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
        }
    }

    public static class ImageXObjectDoHandler implements XObjectDoHandler {
        private ImageXObjectDoHandler() {
        }

        @Override // com.itextpdf.text.pdf.parser.XObjectDoHandler
        public void handleXObject(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            pdfContentStreamProcessor.renderListener.renderImage(ImageRenderInfo.createForXObject(pdfContentStreamProcessor.gs(), pdfIndirectReference, pdfContentStreamProcessor.resources.getAsDict(PdfName.COLORSPACE)));
        }
    }

    public static class LineTo implements ContentOperator {
        private LineTo() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(2, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue())));
        }
    }

    public static class ModifyCurrentTransformationMatrix implements ContentOperator {
        private ModifyCurrentTransformationMatrix() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix matrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            GraphicsState graphicsState = (GraphicsState) pdfContentStreamProcessor.gsStack.peek();
            graphicsState.ctm = matrix.multiply(graphicsState.ctm);
        }
    }

    public static class MoveNextLineAndShowText implements ContentOperator {
        private final ShowText showText;
        private final TextMoveNextLine textMoveNextLine;

        public MoveNextLineAndShowText(TextMoveNextLine textMoveNextLine, ShowText showText) {
            this.textMoveNextLine = textMoveNextLine;
            this.showText = showText;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            this.textMoveNextLine.invoke(pdfContentStreamProcessor, null, new ArrayList<>(0));
            this.showText.invoke(pdfContentStreamProcessor, null, arrayList);
        }
    }

    public static class MoveNextLineAndShowTextWithSpacing implements ContentOperator {
        private final MoveNextLineAndShowText moveNextLineAndShowText;
        private final SetTextCharacterSpacing setTextCharacterSpacing;
        private final SetTextWordSpacing setTextWordSpacing;

        public MoveNextLineAndShowTextWithSpacing(SetTextWordSpacing setTextWordSpacing, SetTextCharacterSpacing setTextCharacterSpacing, MoveNextLineAndShowText moveNextLineAndShowText) {
            this.setTextWordSpacing = setTextWordSpacing;
            this.setTextCharacterSpacing = setTextCharacterSpacing;
            this.moveNextLineAndShowText = moveNextLineAndShowText;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            PdfNumber pdfNumber2 = (PdfNumber) arrayList.get(1);
            PdfString pdfString = (PdfString) arrayList.get(2);
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(1);
            arrayList2.add(0, pdfNumber);
            this.setTextWordSpacing.invoke(pdfContentStreamProcessor, null, arrayList2);
            ArrayList<PdfObject> arrayList3 = new ArrayList<>(1);
            arrayList3.add(0, pdfNumber2);
            this.setTextCharacterSpacing.invoke(pdfContentStreamProcessor, null, arrayList3);
            ArrayList<PdfObject> arrayList4 = new ArrayList<>(1);
            arrayList4.add(0, pdfString);
            this.moveNextLineAndShowText.invoke(pdfContentStreamProcessor, null, arrayList4);
        }
    }

    public static class MoveTo implements ContentOperator {
        private MoveTo() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(1, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue())));
        }
    }

    public static class PaintPath implements ContentOperator {
        private boolean close;
        private int operation;
        private int rule;

        public PaintPath(int i, int i2, boolean z) {
            this.operation = i;
            this.rule = i2;
            this.close = z;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.paintPath(this.operation, this.rule, this.close);
        }
    }

    public static class PopGraphicsState implements ContentOperator {
        private PopGraphicsState() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gsStack.pop();
        }
    }

    public static class ProcessGraphicsStateResource implements ContentOperator {
        private ProcessGraphicsStateResource() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfName pdfName = (PdfName) arrayList.get(0);
            PdfDictionary asDict = pdfContentStreamProcessor.resources.getAsDict(PdfName.EXTGSTATE);
            if (asDict == null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("resources.do.not.contain.extgstate.entry.unable.to.process.operator.1", pdfLiteral));
            }
            PdfDictionary asDict2 = asDict.getAsDict(pdfName);
            if (asDict2 == null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.is.an.unknown.graphics.state.dictionary", pdfName));
            }
            PdfArray asArray = asDict2.getAsArray(PdfName.FONT);
            if (asArray != null) {
                CMapAwareDocumentFont font = pdfContentStreamProcessor.getFont((PRIndirectReference) asArray.getPdfObject(0));
                float fFloatValue = asArray.getAsNumber(1).floatValue();
                pdfContentStreamProcessor.gs().font = font;
                pdfContentStreamProcessor.gs().fontSize = fFloatValue;
            }
        }
    }

    public static class PushGraphicsState implements ContentOperator {
        private PushGraphicsState() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gsStack.push(new GraphicsState((GraphicsState) pdfContentStreamProcessor.gsStack.peek()));
        }
    }

    public static class Rectangle implements ContentOperator {
        private Rectangle() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.modifyPath(7, Arrays.asList(Float.valueOf(((PdfNumber) arrayList.get(0)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(1)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(2)).floatValue()), Float.valueOf(((PdfNumber) arrayList.get(3)).floatValue())));
        }
    }

    public static class ResourceDictionary extends PdfDictionary {
        private final List<PdfDictionary> resourcesStack = new ArrayList();

        @Override // com.itextpdf.text.pdf.PdfDictionary
        public PdfObject getDirectObject(PdfName pdfName) {
            PdfObject directObject;
            for (int size = this.resourcesStack.size() - 1; size >= 0; size--) {
                PdfDictionary pdfDictionary = this.resourcesStack.get(size);
                if (pdfDictionary != null && (directObject = pdfDictionary.getDirectObject(pdfName)) != null) {
                    return directObject;
                }
            }
            return super.getDirectObject(pdfName);
        }

        public void pop() {
            List<PdfDictionary> list = this.resourcesStack;
            list.remove(list.size() - 1);
        }

        public void push(PdfDictionary pdfDictionary) {
            this.resourcesStack.add(pdfDictionary);
        }
    }

    public static class SetCMYKFill implements ContentOperator {
        private SetCMYKFill() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().fillColor = PdfContentStreamProcessor.getColor(4, arrayList);
        }
    }

    public static class SetCMYKStroke implements ContentOperator {
        private SetCMYKStroke() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().strokeColor = PdfContentStreamProcessor.getColor(4, arrayList);
        }
    }

    public static class SetColorFill implements ContentOperator {
        private SetColorFill() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().fillColor = PdfContentStreamProcessor.getColor(pdfContentStreamProcessor.gs().colorSpaceFill, arrayList);
        }
    }

    public static class SetColorSpaceFill implements ContentOperator {
        private SetColorSpaceFill() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().colorSpaceFill = (PdfName) arrayList.get(0);
        }
    }

    public static class SetColorSpaceStroke implements ContentOperator {
        private SetColorSpaceStroke() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().colorSpaceStroke = (PdfName) arrayList.get(0);
        }
    }

    public static class SetColorStroke implements ContentOperator {
        private SetColorStroke() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().strokeColor = PdfContentStreamProcessor.getColor(pdfContentStreamProcessor.gs().colorSpaceStroke, arrayList);
        }
    }

    public static class SetGrayFill implements ContentOperator {
        private SetGrayFill() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().fillColor = PdfContentStreamProcessor.getColor(1, arrayList);
        }
    }

    public static class SetGrayStroke implements ContentOperator {
        private SetGrayStroke() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().strokeColor = PdfContentStreamProcessor.getColor(1, arrayList);
        }
    }

    public class SetLineCap implements ContentOperator {
        private SetLineCap() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().setLineCapStyle(((PdfNumber) arrayList.get(0)).intValue());
        }
    }

    public class SetLineDashPattern implements ContentOperator {
        private SetLineDashPattern() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().setLineDashPattern(new LineDashPattern((PdfArray) arrayList.get(0), ((PdfNumber) arrayList.get(1)).floatValue()));
        }
    }

    public class SetLineJoin implements ContentOperator {
        private SetLineJoin() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().setLineJoinStyle(((PdfNumber) arrayList.get(0)).intValue());
        }
    }

    public static class SetLineWidth implements ContentOperator {
        private SetLineWidth() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().setLineWidth(((PdfNumber) arrayList.get(0)).floatValue());
        }
    }

    public class SetMiterLimit implements ContentOperator {
        private SetMiterLimit() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().setMiterLimit(((PdfNumber) arrayList.get(0)).floatValue());
        }
    }

    public static class SetRGBFill implements ContentOperator {
        private SetRGBFill() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().fillColor = PdfContentStreamProcessor.getColor(3, arrayList);
        }
    }

    public static class SetRGBStroke implements ContentOperator {
        private SetRGBStroke() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.gs().strokeColor = PdfContentStreamProcessor.getColor(3, arrayList);
        }
    }

    public static class SetTextCharacterSpacing implements ContentOperator {
        private SetTextCharacterSpacing() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().characterSpacing = pdfNumber.floatValue();
        }
    }

    public static class SetTextFont implements ContentOperator {
        private SetTextFont() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfName pdfName = (PdfName) arrayList.get(0);
            float fFloatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            PdfObject pdfObject = pdfContentStreamProcessor.resources.getAsDict(PdfName.FONT).get(pdfName);
            pdfContentStreamProcessor.gs().font = pdfObject instanceof PdfDictionary ? pdfContentStreamProcessor.getFont((PdfDictionary) pdfObject) : pdfContentStreamProcessor.getFont((PRIndirectReference) pdfObject);
            pdfContentStreamProcessor.gs().fontSize = fFloatValue;
        }
    }

    public static class SetTextHorizontalScaling implements ContentOperator {
        private SetTextHorizontalScaling() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().horizontalScaling = pdfNumber.floatValue() / 100.0f;
        }
    }

    public static class SetTextLeading implements ContentOperator {
        private SetTextLeading() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().leading = pdfNumber.floatValue();
        }
    }

    public static class SetTextRenderMode implements ContentOperator {
        private SetTextRenderMode() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().renderMode = pdfNumber.intValue();
        }
    }

    public static class SetTextRise implements ContentOperator {
        private SetTextRise() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().rise = pdfNumber.floatValue();
        }
    }

    public static class SetTextWordSpacing implements ContentOperator {
        private SetTextWordSpacing() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfNumber pdfNumber = (PdfNumber) arrayList.get(0);
            pdfContentStreamProcessor.gs().wordSpacing = pdfNumber.floatValue();
        }
    }

    public static class ShowText implements ContentOperator {
        private ShowText() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.displayPdfString((PdfString) arrayList.get(0));
        }
    }

    public static class ShowTextArray implements ContentOperator {
        private ShowTextArray() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ListIterator<PdfObject> listIterator = ((PdfArray) arrayList.get(0)).listIterator();
            while (listIterator.hasNext()) {
                PdfObject next = listIterator.next();
                if (next instanceof PdfString) {
                    pdfContentStreamProcessor.displayPdfString((PdfString) next);
                } else {
                    pdfContentStreamProcessor.applyTextAdjust(((PdfNumber) next).floatValue());
                }
            }
        }
    }

    public static class TextMoveNextLine implements ContentOperator {
        private final TextMoveStartNextLine moveStartNextLine;

        public TextMoveNextLine(TextMoveStartNextLine textMoveStartNextLine) {
            this.moveStartNextLine = textMoveStartNextLine;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(2);
            arrayList2.add(0, new PdfNumber(0));
            arrayList2.add(1, new PdfNumber(-pdfContentStreamProcessor.gs().leading));
            this.moveStartNextLine.invoke(pdfContentStreamProcessor, null, arrayList2);
        }
    }

    public static class TextMoveStartNextLine implements ContentOperator {
        private TextMoveStartNextLine() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue()).multiply(pdfContentStreamProcessor.textLineMatrix);
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
        }
    }

    public static class TextMoveStartNextLineWithLeading implements ContentOperator {
        private final TextMoveStartNextLine moveStartNextLine;
        private final SetTextLeading setTextLeading;

        public TextMoveStartNextLineWithLeading(TextMoveStartNextLine textMoveStartNextLine, SetTextLeading setTextLeading) {
            this.moveStartNextLine = textMoveStartNextLine;
            this.setTextLeading = setTextLeading;
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            float fFloatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            ArrayList<PdfObject> arrayList2 = new ArrayList<>(1);
            arrayList2.add(0, new PdfNumber(-fFloatValue));
            this.setTextLeading.invoke(pdfContentStreamProcessor, null, arrayList2);
            this.moveStartNextLine.invoke(pdfContentStreamProcessor, null, arrayList);
        }
    }

    public static class TextSetTextMatrix implements ContentOperator {
        private TextSetTextMatrix() {
        }

        @Override // com.itextpdf.text.pdf.parser.ContentOperator
        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.textLineMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            pdfContentStreamProcessor.textMatrix = pdfContentStreamProcessor.textLineMatrix;
        }
    }

    public PdfContentStreamProcessor(RenderListener renderListener) {
        this.renderListener = renderListener;
        populateOperators();
        this.xobjectDoHandlers = new HashMap();
        populateXObjectDoHandlers();
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyTextAdjust(float f) {
        this.textMatrix = new Matrix(((-f) / 1000.0f) * gs().fontSize * gs().horizontalScaling, 0.0f).multiply(this.textMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginMarkedContent(PdfName pdfName, PdfDictionary pdfDictionary) {
        this.markedContentStack.push(new MarkedContentInfo(pdfName, pdfDictionary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginText() {
        this.renderListener.beginTextBlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clipPath(int i) {
        ((ExtRenderListener) this.renderListener).clipPath(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayPdfString(PdfString pdfString) {
        TextRenderInfo textRenderInfo = new TextRenderInfo(pdfString, gs(), this.textMatrix, this.markedContentStack);
        this.renderListener.renderText(textRenderInfo);
        this.textMatrix = new Matrix(textRenderInfo.getUnscaledWidth(), 0.0f).multiply(this.textMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayXObject(PdfName pdfName) {
        PdfDictionary asDict = this.resources.getAsDict(PdfName.XOBJECT);
        PdfObject directObject = asDict.getDirectObject(pdfName);
        PdfStream pdfStream = (PdfStream) directObject;
        PdfName asName = pdfStream.getAsName(PdfName.SUBTYPE);
        if (!directObject.isStream()) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("XObject.1.is.not.a.stream", pdfName));
        }
        XObjectDoHandler xObjectDoHandler = this.xobjectDoHandlers.get(asName);
        if (xObjectDoHandler == null) {
            xObjectDoHandler = this.xobjectDoHandlers.get(PdfName.DEFAULT);
        }
        xObjectDoHandler.handleXObject(this, pdfStream, asDict.getAsIndirectObject(pdfName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endMarkedContent() {
        this.markedContentStack.pop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endText() {
        this.renderListener.endTextBlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BaseColor getColor(PdfName pdfName, List<PdfObject> list) {
        if (PdfName.DEVICEGRAY.equals(pdfName)) {
            return getColor(1, list);
        }
        if (PdfName.DEVICERGB.equals(pdfName)) {
            return getColor(3, list);
        }
        if (PdfName.DEVICECMYK.equals(pdfName)) {
            return getColor(4, list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CMapAwareDocumentFont getFont(PRIndirectReference pRIndirectReference) {
        Integer numValueOf = Integer.valueOf(pRIndirectReference.getNumber());
        CMapAwareDocumentFont cMapAwareDocumentFont = this.cachedFonts.get(numValueOf);
        if (cMapAwareDocumentFont != null) {
            return cMapAwareDocumentFont;
        }
        CMapAwareDocumentFont cMapAwareDocumentFont2 = new CMapAwareDocumentFont(pRIndirectReference);
        this.cachedFonts.put(numValueOf, cMapAwareDocumentFont2);
        return cMapAwareDocumentFont2;
    }

    private void invokeOperator(PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
        ContentOperator contentOperator = this.operators.get(pdfLiteral.toString());
        if (contentOperator == null) {
            contentOperator = this.operators.get(DEFAULTOPERATOR);
        }
        contentOperator.invoke(this, pdfLiteral, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyPath(int i, List<Float> list) {
        ((ExtRenderListener) this.renderListener).modifyPath(new PathConstructionRenderInfo(i, list, gs().getCtm()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void paintPath(int i, int i2, boolean z) {
        if (z) {
            modifyPath(6, null);
        }
        ((ExtRenderListener) this.renderListener).renderPath(new PathPaintingRenderInfo(i, i2, gs()));
    }

    private void populateOperators() {
        registerContentOperator(DEFAULTOPERATOR, new IgnoreOperatorContentOperator());
        registerContentOperator(HTML.Tag.Q, new PushGraphicsState());
        registerContentOperator("Q", new PopGraphicsState());
        registerContentOperator("g", new SetGrayFill());
        registerContentOperator("G", new SetGrayStroke());
        registerContentOperator("rg", new SetRGBFill());
        registerContentOperator("RG", new SetRGBStroke());
        registerContentOperator("k", new SetCMYKFill());
        registerContentOperator("K", new SetCMYKStroke());
        registerContentOperator("cs", new SetColorSpaceFill());
        registerContentOperator("CS", new SetColorSpaceStroke());
        registerContentOperator("sc", new SetColorFill());
        registerContentOperator("SC", new SetColorStroke());
        registerContentOperator("scn", new SetColorFill());
        registerContentOperator("SCN", new SetColorStroke());
        registerContentOperator(CSS.Value.CM, new ModifyCurrentTransformationMatrix());
        registerContentOperator("gs", new ProcessGraphicsStateResource());
        SetTextCharacterSpacing setTextCharacterSpacing = new SetTextCharacterSpacing();
        registerContentOperator("Tc", setTextCharacterSpacing);
        SetTextWordSpacing setTextWordSpacing = new SetTextWordSpacing();
        registerContentOperator("Tw", setTextWordSpacing);
        registerContentOperator("Tz", new SetTextHorizontalScaling());
        SetTextLeading setTextLeading = new SetTextLeading();
        registerContentOperator("TL", setTextLeading);
        registerContentOperator("Tf", new SetTextFont());
        registerContentOperator("Tr", new SetTextRenderMode());
        registerContentOperator("Ts", new SetTextRise());
        registerContentOperator("BT", new BeginText());
        registerContentOperator("ET", new EndText());
        registerContentOperator("BMC", new BeginMarkedContent());
        registerContentOperator("BDC", new BeginMarkedContentDictionary());
        registerContentOperator("EMC", new EndMarkedContent());
        TextMoveStartNextLine textMoveStartNextLine = new TextMoveStartNextLine();
        registerContentOperator("Td", textMoveStartNextLine);
        registerContentOperator("TD", new TextMoveStartNextLineWithLeading(textMoveStartNextLine, setTextLeading));
        registerContentOperator("Tm", new TextSetTextMatrix());
        TextMoveNextLine textMoveNextLine = new TextMoveNextLine(textMoveStartNextLine);
        registerContentOperator("T*", textMoveNextLine);
        ShowText showText = new ShowText();
        registerContentOperator("Tj", showText);
        MoveNextLineAndShowText moveNextLineAndShowText = new MoveNextLineAndShowText(textMoveNextLine, showText);
        registerContentOperator("'", moveNextLineAndShowText);
        registerContentOperator("\"", new MoveNextLineAndShowTextWithSpacing(setTextWordSpacing, setTextCharacterSpacing, moveNextLineAndShowText));
        registerContentOperator("TJ", new ShowTextArray());
        registerContentOperator("Do", new Do());
        registerContentOperator("w", new SetLineWidth());
        registerContentOperator("J", new SetLineCap());
        registerContentOperator("j", new SetLineJoin());
        registerContentOperator("M", new SetMiterLimit());
        registerContentOperator("d", new SetLineDashPattern());
        if (this.renderListener instanceof ExtRenderListener) {
            registerContentOperator("m", new MoveTo());
            registerContentOperator("l", new LineTo());
            registerContentOperator("c", new Curve());
            registerContentOperator("v", new CurveFirstPointDuplicated());
            registerContentOperator("y", new CurveFourhPointDuplicated());
            registerContentOperator("h", new CloseSubpath());
            registerContentOperator("re", new Rectangle());
            registerContentOperator("S", new PaintPath(1, -1, false));
            registerContentOperator("s", new PaintPath(1, -1, true));
            registerContentOperator("f", new PaintPath(2, 1, false));
            registerContentOperator("F", new PaintPath(2, 1, false));
            registerContentOperator("f*", new PaintPath(2, 2, false));
            registerContentOperator("B", new PaintPath(3, 1, false));
            registerContentOperator("B*", new PaintPath(3, 2, false));
            registerContentOperator("b", new PaintPath(3, 1, true));
            registerContentOperator("b*", new PaintPath(3, 2, true));
            registerContentOperator("n", new PaintPath(0, -1, false));
            registerContentOperator("W", new ClipPath(1));
            registerContentOperator("W*", new ClipPath(2));
        }
    }

    private void populateXObjectDoHandlers() {
        registerXObjectDoHandler(PdfName.DEFAULT, new IgnoreXObjectDoHandler());
        registerXObjectDoHandler(PdfName.FORM, new FormXObjectDoHandler());
        registerXObjectDoHandler(PdfName.IMAGE, new ImageXObjectDoHandler());
    }

    public Collection<String> getRegisteredOperatorStrings() {
        return new ArrayList(this.operators.keySet());
    }

    public RenderListener getRenderListener() {
        return this.renderListener;
    }

    public GraphicsState gs() {
        return this.gsStack.peek();
    }

    public void handleInlineImage(InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        this.renderListener.renderImage(ImageRenderInfo.createForEmbeddedImage(gs(), inlineImageInfo, pdfDictionary));
    }

    public void processContent(byte[] bArr, PdfDictionary pdfDictionary) {
        this.resources.push(pdfDictionary);
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(bArr))));
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            while (pdfContentParser.parse(arrayList).size() > 0) {
                PdfLiteral pdfLiteral = (PdfLiteral) arrayList.get(arrayList.size() - 1);
                if ("BI".equals(pdfLiteral.toString())) {
                    PdfDictionary asDict = pdfDictionary != null ? pdfDictionary.getAsDict(PdfName.COLORSPACE) : null;
                    handleInlineImage(InlineImageUtils.parseInlineImage(pdfContentParser, asDict), asDict);
                } else {
                    invokeOperator(pdfLiteral, arrayList);
                }
            }
            this.resources.pop();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public ContentOperator registerContentOperator(String str, ContentOperator contentOperator) {
        return this.operators.put(str, contentOperator);
    }

    public XObjectDoHandler registerXObjectDoHandler(PdfName pdfName, XObjectDoHandler xObjectDoHandler) {
        return this.xobjectDoHandlers.put(pdfName, xObjectDoHandler);
    }

    public void reset() {
        this.gsStack.removeAllElements();
        this.gsStack.add(new GraphicsState());
        this.textMatrix = null;
        this.textLineMatrix = null;
        this.resources = new ResourceDictionary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CMapAwareDocumentFont getFont(PdfDictionary pdfDictionary) {
        return new CMapAwareDocumentFont(pdfDictionary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BaseColor getColor(int i, List<PdfObject> list) {
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            float fFloatValue = ((PdfNumber) list.get(i2)).floatValue();
            fArr[i2] = fFloatValue;
            if (fFloatValue > 1.0f) {
                fArr[i2] = 1.0f;
            } else if (fFloatValue < 0.0f) {
                fArr[i2] = 0.0f;
            }
        }
        if (i == 1) {
            return new GrayColor(fArr[0]);
        }
        if (i == 3) {
            return new BaseColor(fArr[0], fArr[1], fArr[2]);
        }
        if (i != 4) {
            return null;
        }
        return new CMYKColor(fArr[0], fArr[1], fArr[2], fArr[3]);
    }
}
