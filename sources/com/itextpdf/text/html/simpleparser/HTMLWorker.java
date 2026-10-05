package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HTMLWorker implements SimpleXMLDocHandler, DocListener {
    public static final String FONT_PROVIDER = "font_factory";
    public static final String IMG_BASEURL = "img_baseurl";
    public static final String IMG_PROCESSOR = "img_interface";
    public static final String IMG_PROVIDER = "img_provider";
    public static final String IMG_STORE = "img_static";
    public static final String LINK_PROVIDER = "alink_interface";
    private static Logger LOGGER = LoggerFactory.getLogger((Class<?>) HTMLWorker.class);
    private final ChainedProperties chain;
    protected Paragraph currentParagraph;
    protected DocListener document;
    private final ElementFactory factory;
    private boolean insidePRE;
    protected List<Element> objectList;
    private boolean pendingLI;
    private boolean pendingTD;
    private boolean pendingTR;
    private Map<String, Object> providers;
    protected boolean skipText;
    protected Stack<Element> stack;
    private StyleSheet style;
    private final Stack<boolean[]> tableState;
    protected Map<String, HTMLTagProcessor> tags;

    public HTMLWorker(DocListener docListener) {
        this(docListener, null, null);
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet) {
        return parseToList(reader, styleSheet, null);
    }

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) {
        this.objectList.add(element);
        return true;
    }

    public void carriageReturn() {
        if (this.currentParagraph == null) {
            return;
        }
        if (this.stack.empty()) {
            this.document.add(this.currentParagraph);
        } else {
            Element elementPop = this.stack.pop();
            if (elementPop instanceof TextElementArray) {
                ((TextElementArray) elementPop).add(this.currentParagraph);
            }
            this.stack.push(elementPop);
        }
        this.currentParagraph = null;
    }

    @Override // com.itextpdf.text.DocListener
    public void close() {
    }

    public CellWrapper createCell(String str) {
        return new CellWrapper(str, this.chain);
    }

    public Chunk createChunk(String str) {
        return this.factory.createChunk(str, this.chain);
    }

    public Image createImage(Map<String, String> map) {
        String str = map.get("src");
        if (str == null) {
            return null;
        }
        return this.factory.createImage(str, map, this.chain, this.document, (ImageProvider) this.providers.get(IMG_PROVIDER), (ImageStore) this.providers.get(IMG_STORE), (String) this.providers.get(IMG_BASEURL));
    }

    public LineSeparator createLineSeparator(Map<String, String> map) {
        return this.factory.createLineSeparator(map, this.currentParagraph.getLeading() / 2.0f);
    }

    public com.itextpdf.text.List createList(String str) {
        return this.factory.createList(str, this.chain);
    }

    public ListItem createListItem() {
        return this.factory.createListItem(this.chain);
    }

    public Paragraph createParagraph() {
        return this.factory.createParagraph(this.chain);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
        for (int i = 0; i < this.stack.size(); i++) {
            try {
                this.document.add(this.stack.elementAt(i));
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        Paragraph paragraph = this.currentParagraph;
        if (paragraph != null) {
            this.document.add(paragraph);
        }
        this.currentParagraph = null;
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        HTMLTagProcessor hTMLTagProcessor = this.tags.get(str);
        if (hTMLTagProcessor == null) {
            return;
        }
        try {
            hTMLTagProcessor.endElement(this, str);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void flushContent() {
        pushToStack(this.currentParagraph);
        this.currentParagraph = new Paragraph();
    }

    @Deprecated
    public Map<String, Object> getInterfaceProps() {
        return this.providers;
    }

    public boolean isInsidePRE() {
        return this.insidePRE;
    }

    public boolean isPendingLI() {
        return this.pendingLI;
    }

    public boolean isPendingTD() {
        return this.pendingTD;
    }

    public boolean isPendingTR() {
        return this.pendingTR;
    }

    public boolean isSkipText() {
        return this.skipText;
    }

    public void newLine() {
        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph();
        }
        this.currentParagraph.add((Element) createChunk(StringUtilities.LF));
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
    }

    public void parse(Reader reader) throws IOException {
        LOGGER.info("Please note, there is a more extended version of the HTMLWorker available in the iText XMLWorker");
        SimpleXMLParser.parse(this, null, reader, true);
    }

    public void popTableState() {
        boolean[] zArrPop = this.tableState.pop();
        this.pendingTR = zArrPop[0];
        this.pendingTD = zArrPop[1];
    }

    public void processImage(Image image, Map<String, String> map) {
        ImageProcessor imageProcessor = (ImageProcessor) this.providers.get(IMG_PROCESSOR);
        if (imageProcessor == null || !imageProcessor.process(image, map, this.chain, this.document)) {
            String str = map.get("align");
            if (str != null) {
                carriageReturn();
            }
            if (this.currentParagraph == null) {
                this.currentParagraph = createParagraph();
            }
            this.currentParagraph.add((Element) new Chunk(image, 0.0f, 0.0f, true));
            this.currentParagraph.setAlignment(HtmlUtilities.alignmentValue(str));
            if (str != null) {
                carriageReturn();
            }
        }
    }

    public void processLink() {
        String property;
        if (this.currentParagraph == null) {
            this.currentParagraph = new Paragraph();
        }
        LinkProcessor linkProcessor = (LinkProcessor) this.providers.get(LINK_PROVIDER);
        if ((linkProcessor == null || !linkProcessor.process(this.currentParagraph, this.chain)) && (property = this.chain.getProperty("href")) != null) {
            Iterator<Chunk> it = this.currentParagraph.getChunks().iterator();
            while (it.hasNext()) {
                it.next().setAnchor(property);
            }
        }
        if (this.stack.isEmpty()) {
            this.currentParagraph = new Paragraph(new Phrase(this.currentParagraph));
            return;
        }
        Paragraph paragraph = (Paragraph) this.stack.pop();
        paragraph.add((Element) new Phrase(this.currentParagraph));
        this.currentParagraph = paragraph;
    }

    public void processList() {
        if (this.stack.empty()) {
            return;
        }
        Element elementPop = this.stack.pop();
        if (!(elementPop instanceof com.itextpdf.text.List)) {
            this.stack.push(elementPop);
        } else if (this.stack.empty()) {
            this.document.add(elementPop);
        } else {
            ((TextElementArray) this.stack.peek()).add(elementPop);
        }
    }

    public void processListItem() {
        if (this.stack.empty()) {
            return;
        }
        Element elementPop = this.stack.pop();
        if (!(elementPop instanceof ListItem)) {
            this.stack.push(elementPop);
            return;
        }
        if (this.stack.empty()) {
            this.document.add(elementPop);
            return;
        }
        ListItem listItem = (ListItem) elementPop;
        Element elementPop2 = this.stack.pop();
        if (!(elementPop2 instanceof com.itextpdf.text.List)) {
            this.stack.push(elementPop2);
            return;
        }
        ((com.itextpdf.text.List) elementPop2).add(listItem);
        listItem.adjustListSymbolFont();
        this.stack.push(elementPop2);
    }

    public void processRow() {
        Element elementPop;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean zIsPercentage = false;
        float f = 0.0f;
        int i = 0;
        do {
            elementPop = this.stack.pop();
            if (elementPop instanceof CellWrapper) {
                CellWrapper cellWrapper = (CellWrapper) elementPop;
                float width = cellWrapper.getWidth();
                arrayList2.add(new Float(width));
                zIsPercentage |= cellWrapper.isPercentage();
                if (width == 0.0f) {
                    i++;
                } else {
                    f += width;
                }
                arrayList.add(cellWrapper.getCell());
            }
        } while (!(elementPop instanceof TableWrapper));
        TableWrapper tableWrapper = (TableWrapper) elementPop;
        tableWrapper.addRow(arrayList);
        if (arrayList2.size() > 0) {
            float f2 = 100.0f - f;
            Collections.reverse(arrayList2);
            int size = arrayList2.size();
            float[] fArr = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                float fFloatValue = ((Float) arrayList2.get(i2)).floatValue();
                fArr[i2] = fFloatValue;
                if (fFloatValue == 0.0f && zIsPercentage && i > 0) {
                    fArr[i2] = f2 / i;
                }
                if (fArr[i2] != 0.0f) {
                }
            }
            tableWrapper.setColWidths(fArr);
        }
        this.stack.push(tableWrapper);
    }

    public void processTable() {
        PdfPTable pdfPTableCreateTable = ((TableWrapper) this.stack.pop()).createTable();
        pdfPTableCreateTable.setSplitRows(true);
        if (this.stack.empty()) {
            this.document.add(pdfPTableCreateTable);
        } else {
            ((TextElementArray) this.stack.peek()).add(pdfPTableCreateTable);
        }
    }

    public void pushTableState() {
        this.tableState.push(new boolean[]{this.pendingTR, this.pendingTD});
    }

    public void pushToStack(Element element) {
        if (element != null) {
            this.stack.push(element);
        }
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
    }

    public void setInsidePRE(boolean z) {
        this.insidePRE = z;
    }

    @Deprecated
    public void setInterfaceProps(HashMap<String, Object> map) {
        setProviders(map);
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        return true;
    }

    public void setPendingLI(boolean z) {
        this.pendingLI = z;
    }

    public void setPendingTD(boolean z) {
        this.pendingTD = z;
    }

    public void setPendingTR(boolean z) {
        this.pendingTR = z;
    }

    public void setProviders(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.providers = map;
        FontProvider fontProvider = (FontProvider) map.get(FONT_PROVIDER);
        if (fontProvider != null) {
            this.factory.setFontProvider(fontProvider);
        }
    }

    public void setSkipText(boolean z) {
        this.skipText = z;
    }

    public void setStyleSheet(StyleSheet styleSheet) {
        if (styleSheet == null) {
            styleSheet = new StyleSheet();
        }
        this.style = styleSheet;
    }

    public void setSupportedTags(Map<String, HTMLTagProcessor> map) {
        if (map == null) {
            map = new HTMLTagProcessors();
        }
        this.tags = map;
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
        HashMap map = new HashMap();
        this.style.applyStyle("body", map);
        this.chain.addToChain("body", map);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        HTMLTagProcessor hTMLTagProcessor = this.tags.get(str);
        if (hTMLTagProcessor == null) {
            return;
        }
        this.style.applyStyle(str, map);
        StyleSheet.resolveStyleAttribute(map, this.chain);
        try {
            hTMLTagProcessor.startElement(this, str, map);
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        if (this.skipText) {
            return;
        }
        if (this.currentParagraph == null) {
            this.currentParagraph = createParagraph();
        }
        if (!this.insidePRE) {
            if (str.trim().length() == 0 && str.indexOf(32) < 0) {
                return;
            } else {
                str = HtmlUtilities.eliminateWhiteSpace(str);
            }
        }
        this.currentParagraph.add((Element) createChunk(str));
    }

    public void updateChain(String str, Map<String, String> map) {
        this.chain.addToChain(str, map);
    }

    public HTMLWorker(DocListener docListener, Map<String, HTMLTagProcessor> map, StyleSheet styleSheet) {
        this.style = new StyleSheet();
        this.stack = new Stack<>();
        this.chain = new ChainedProperties();
        this.providers = new HashMap();
        this.factory = new ElementFactory();
        this.tableState = new Stack<>();
        this.pendingTR = false;
        this.pendingTD = false;
        this.pendingLI = false;
        this.insidePRE = false;
        this.skipText = false;
        this.document = docListener;
        setSupportedTags(map);
        setStyleSheet(styleSheet);
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet, HashMap<String, Object> map) {
        return parseToList(reader, styleSheet, null, map);
    }

    public void updateChain(String str) {
        this.chain.removeChain(str);
    }

    public static List<Element> parseToList(Reader reader, StyleSheet styleSheet, Map<String, HTMLTagProcessor> map, HashMap<String, Object> map2) throws IOException {
        HTMLWorker hTMLWorker = new HTMLWorker(null, map, styleSheet);
        hTMLWorker.document = hTMLWorker;
        hTMLWorker.setProviders(map2);
        hTMLWorker.objectList = new ArrayList();
        hTMLWorker.parse(reader);
        return hTMLWorker.objectList;
    }
}
