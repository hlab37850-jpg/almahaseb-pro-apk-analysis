package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgTemplate;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.MarkedObject;
import com.itextpdf.text.MarkedSection;
import com.itextpdf.text.Meta;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Version;
import com.itextpdf.text.api.WriterOperation;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDocument extends Document {
    protected static final DecimalFormat SIXTEEN_DIGITS = new DecimalFormat("0000000000000000");
    static final String hangingPunctuation = ".,;:'";
    protected PdfDictionary additionalActions;
    PdfAnnotationsImp annotationsImp;
    private PdfBody body;
    protected PdfCollection collection;
    protected PdfOutline currentOutline;
    private TempFileCache externalCache;
    protected PdfContentByte graphics;
    int jsCounter;
    protected PdfString language;
    protected float nextMarginBottom;
    protected float nextMarginLeft;
    protected float nextMarginRight;
    protected float nextMarginTop;
    protected PdfAction openActionAction;
    protected String openActionName;
    protected PdfPageLabels pageLabels;
    protected PageResources pageResources;
    protected PdfOutline rootOutline;
    protected TabSettings tabSettings;
    protected PdfContentByte text;
    protected int textEmptySize;
    protected PdfWriter writer;
    private HashMap<AccessibleElementId, PdfStructureElement> structElements = new HashMap<>();
    private HashMap<AccessibleElementId, TempFileCache.ObjectPosition> externallyStoredStructElements = new HashMap<>();
    private HashMap<AccessibleElementId, AccessibleElementId> elementsParents = new HashMap<>();
    private boolean isToUseExternalCache = false;
    protected boolean openMCDocument = false;
    protected HashMap<Object, int[]> structParentIndices = new HashMap<>();
    protected HashMap<Object, Integer> markPoints = new HashMap<>();
    protected float leading = 0.0f;
    protected int alignment = 0;
    protected float currentHeight = 0.0f;
    protected boolean isSectionTitle = false;
    protected PdfAction anchorAction = null;
    private Stack<Float> leadingStack = new Stack<>();
    protected boolean firstPageEvent = true;
    protected PdfLine line = null;
    protected ArrayList<PdfLine> lines = new ArrayList<>();
    protected int lastElementType = -1;
    protected Indentation indentation = new Indentation();

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    protected PdfInfo f89info = new PdfInfo();
    protected PdfViewerPreferencesImp viewerPreferences = new PdfViewerPreferencesImp();
    protected TreeMap<String, Destination> localDestinations = new TreeMap<>();
    protected HashMap<String, PdfObject> documentLevelJS = new HashMap<>();
    protected HashMap<String, PdfObject> documentFileAttachment = new HashMap<>();
    protected Rectangle nextPageSize = null;
    protected HashMap<String, PdfRectangle> thisBoxSize = new HashMap<>();
    protected HashMap<String, PdfRectangle> boxSize = new HashMap<>();
    private boolean pageEmpty = true;
    protected PdfDictionary pageAA = null;
    protected boolean strictImageSequence = false;
    protected float imageEnd = -1.0f;
    protected Image imageWait = null;
    private ArrayList<Element> floatingElements = new ArrayList<>();

    public class Destination {
        public PdfAction action;
        public PdfDestination destination;
        public PdfIndirectReference reference;

        public Destination() {
        }
    }

    public static class Indentation {
        float indentLeft = 0.0f;
        float sectionIndentLeft = 0.0f;
        float listIndentLeft = 0.0f;
        float imageIndentLeft = 0.0f;
        float indentRight = 0.0f;
        float sectionIndentRight = 0.0f;
        float imageIndentRight = 0.0f;
        float indentTop = 0.0f;
        float indentBottom = 0.0f;
    }

    public static class PdfCatalog extends PdfDictionary {
        PdfWriter writer;

        public PdfCatalog(PdfIndirectReference pdfIndirectReference, PdfWriter pdfWriter) {
            super(PdfDictionary.CATALOG);
            this.writer = pdfWriter;
            put(PdfName.PAGES, pdfIndirectReference);
        }

        public void addNames(TreeMap<String, Destination> treeMap, HashMap<String, PdfObject> map, HashMap<String, PdfObject> map2, PdfWriter pdfWriter) {
            if (treeMap.isEmpty() && map.isEmpty() && map2.isEmpty()) {
                return;
            }
            try {
                PdfDictionary pdfDictionary = new PdfDictionary();
                if (!treeMap.isEmpty()) {
                    HashMap map3 = new HashMap();
                    for (Map.Entry<String, Destination> entry : treeMap.entrySet()) {
                        String key = entry.getKey();
                        Destination value = entry.getValue();
                        if (value.destination != null) {
                            map3.put(key, value.reference);
                        }
                    }
                    if (map3.size() > 0) {
                        pdfDictionary.put(PdfName.DESTS, pdfWriter.addToBody(PdfNameTree.writeTree(map3, pdfWriter)).getIndirectReference());
                    }
                }
                if (!map.isEmpty()) {
                    pdfDictionary.put(PdfName.JAVASCRIPT, pdfWriter.addToBody(PdfNameTree.writeTree(map, pdfWriter)).getIndirectReference());
                }
                if (!map2.isEmpty()) {
                    pdfDictionary.put(PdfName.EMBEDDEDFILES, pdfWriter.addToBody(PdfNameTree.writeTree(map2, pdfWriter)).getIndirectReference());
                }
                if (pdfDictionary.size() > 0) {
                    put(PdfName.NAMES, pdfWriter.addToBody(pdfDictionary).getIndirectReference());
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }

        public void setAdditionalActions(PdfDictionary pdfDictionary) {
            try {
                put(PdfName.AA, this.writer.addToBody(pdfDictionary).getIndirectReference());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        public void setOpenAction(PdfAction pdfAction) {
            put(PdfName.OPENACTION, pdfAction);
        }
    }

    public PdfDocument() {
        addProducer();
        addCreationDate();
    }

    private void addDiv(PdfDiv pdfDiv) {
        if (this.floatingElements == null) {
            this.floatingElements = new ArrayList<>();
        }
        this.floatingElements.add(pdfDiv);
    }

    private void flushFloatingElements() {
        ArrayList<Element> arrayList = this.floatingElements;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<Element> arrayList2 = this.floatingElements;
        this.floatingElements = null;
        FloatLayout floatLayout = new FloatLayout(arrayList2, false);
        int i = 0;
        while (true) {
            indentLeft();
            floatLayout.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            try {
                if ((floatLayout.layout(isTagged(this.writer) ? this.text : this.writer.getDirectContent(), false) & 1) != 0) {
                    if (isTagged(this.writer)) {
                        this.text.setTextMatrix(indentLeft(), floatLayout.getYLine());
                    } else {
                        this.text.moveText(0.0f, (floatLayout.getYLine() - indentTop()) + this.currentHeight);
                    }
                    this.currentHeight = indentTop() - floatLayout.getYLine();
                    return;
                }
                i = (indentTop() - this.currentHeight == floatLayout.getYLine() || isPageEmpty()) ? i + 1 : 0;
                if (i == 2) {
                    return;
                } else {
                    newPage();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private PdfLine getLastLine() {
        if (this.lines.size() <= 0) {
            return null;
        }
        ArrayList<PdfLine> arrayList = this.lines;
        return arrayList.get(arrayList.size() - 1);
    }

    private static boolean isTagged(PdfWriter pdfWriter) {
        return pdfWriter != null && pdfWriter.isTagged();
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        MarkedObject title;
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        try {
            if (element.type() != 37) {
                flushFloatingElements();
            }
            int iType = element.type();
            if (iType == 23) {
                PdfPTable pdfPTable = (PdfPTable) element;
                if (pdfPTable.size() > pdfPTable.getHeaderRows()) {
                    ensureNewLine();
                    flushLines();
                    addPTable(pdfPTable);
                    this.pageEmpty = false;
                    newLine();
                }
            } else if (iType == 50) {
                if ((element instanceof MarkedSection) && (title = ((MarkedSection) element).getTitle()) != null) {
                    title.process(this);
                }
                ((MarkedObject) element).process(this);
            } else if (iType == 55) {
                ((DrawInterface) element).draw(this.graphics, indentLeft(), indentBottom(), indentRight(), indentTop(), (indentTop() - this.currentHeight) - (this.leadingStack.size() > 0 ? this.leading : 0.0f));
                this.pageEmpty = false;
            } else if (iType == 666) {
                PdfWriter pdfWriter2 = this.writer;
                if (pdfWriter2 != null) {
                    ((WriterOperation) element).write(pdfWriter2, this);
                }
            } else if (iType == 29) {
                if (this.line == null) {
                    carriageReturn();
                }
                Annotation annotation = (Annotation) element;
                Rectangle rectangle = new Rectangle(0.0f, 0.0f);
                if (this.line != null) {
                    rectangle = new Rectangle(annotation.llx(indentRight() - this.line.widthLeft()), annotation.ury((indentTop() - this.currentHeight) - 20.0f), annotation.urx((indentRight() - this.line.widthLeft()) + 20.0f), annotation.lly(indentTop() - this.currentHeight));
                }
                this.annotationsImp.addPlainAnnotation(PdfAnnotationsImp.convertAnnotation(this.writer, annotation, rectangle));
                this.pageEmpty = false;
            } else if (iType != 30) {
                switch (iType) {
                    case 0:
                        this.f89info.addkey(((Meta) element).getName(), ((Meta) element).getContent());
                        break;
                    case 1:
                        this.f89info.addTitle(((Meta) element).getContent());
                        break;
                    case 2:
                        this.f89info.addSubject(((Meta) element).getContent());
                        break;
                    case 3:
                        this.f89info.addKeywords(((Meta) element).getContent());
                        break;
                    case 4:
                        this.f89info.addAuthor(((Meta) element).getContent());
                        break;
                    case 5:
                        this.f89info.addProducer();
                        break;
                    case 6:
                        this.f89info.addCreationDate();
                        break;
                    case 7:
                        this.f89info.addCreator(((Meta) element).getContent());
                        break;
                    case 8:
                        setLanguage(((Meta) element).getContent());
                        break;
                    default:
                        switch (iType) {
                            case 10:
                                if (this.line == null) {
                                    carriageReturn();
                                }
                                PdfChunk pdfChunk = new PdfChunk((Chunk) element, this.anchorAction, this.tabSettings);
                                while (true) {
                                    PdfChunk pdfChunkAdd = this.line.add(pdfChunk, this.leading);
                                    if (pdfChunkAdd == null) {
                                        this.pageEmpty = false;
                                        if (pdfChunk.isAttribute(Chunk.NEWPAGE)) {
                                            newPage();
                                        }
                                    } else {
                                        carriageReturn();
                                        if (!pdfChunk.isNewlineSplit()) {
                                            pdfChunkAdd.trimFirstSpace();
                                        }
                                        pdfChunk = pdfChunkAdd;
                                    }
                                    break;
                                }
                                break;
                            case 11:
                                TabSettings tabSettings = this.tabSettings;
                                if (((Phrase) element).getTabSettings() != null) {
                                    this.tabSettings = ((Phrase) element).getTabSettings();
                                }
                                this.leading = ((Phrase) element).getTotalLeading();
                                pushLeading();
                                element.process(this);
                                this.tabSettings = tabSettings;
                                popLeading();
                                break;
                            case 12:
                                TabSettings tabSettings2 = this.tabSettings;
                                if (((Phrase) element).getTabSettings() != null) {
                                    this.tabSettings = ((Phrase) element).getTabSettings();
                                }
                                Paragraph paragraph = (Paragraph) element;
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.openMCBlock(paragraph);
                                }
                                addSpacing(paragraph.getSpacingBefore(), this.leading, paragraph.getFont());
                                this.alignment = paragraph.getAlignment();
                                this.leading = paragraph.getTotalLeading();
                                pushLeading();
                                carriageReturn();
                                if (this.currentHeight + calculateLineHeight() > indentTop() - indentBottom()) {
                                    newPage();
                                }
                                this.indentation.indentLeft += paragraph.getIndentationLeft();
                                this.indentation.indentRight += paragraph.getIndentationRight();
                                carriageReturn();
                                PdfPageEvent pageEvent = this.writer.getPageEvent();
                                if (pageEvent != null && !this.isSectionTitle) {
                                    pageEvent.onParagraph(this.writer, this, indentTop() - this.currentHeight);
                                }
                                if (paragraph.getKeepTogether()) {
                                    carriageReturn();
                                    PdfPTable pdfPTable2 = new PdfPTable(1);
                                    pdfPTable2.setKeepTogether(paragraph.getKeepTogether());
                                    pdfPTable2.setWidthPercentage(100.0f);
                                    PdfPCell pdfPCell = new PdfPCell();
                                    pdfPCell.addElement(paragraph);
                                    pdfPCell.setBorder(0);
                                    pdfPCell.setPadding(0.0f);
                                    pdfPTable2.addCell(pdfPCell);
                                    this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                    this.indentation.indentRight -= paragraph.getIndentationRight();
                                    add(pdfPTable2);
                                    this.indentation.indentLeft += paragraph.getIndentationLeft();
                                    this.indentation.indentRight += paragraph.getIndentationRight();
                                } else {
                                    this.line.setExtraIndent(paragraph.getFirstLineIndent());
                                    float f = this.currentHeight;
                                    element.process(this);
                                    carriageReturn();
                                    if (f != this.currentHeight || this.lines.size() > 0) {
                                        addSpacing(paragraph.getSpacingAfter(), paragraph.getTotalLeading(), paragraph.getFont(), true);
                                    }
                                }
                                if (pageEvent != null && !this.isSectionTitle) {
                                    pageEvent.onParagraphEnd(this.writer, this, indentTop() - this.currentHeight);
                                }
                                this.alignment = 0;
                                ArrayList<Element> arrayList = this.floatingElements;
                                if (arrayList != null && arrayList.size() != 0) {
                                    flushFloatingElements();
                                }
                                this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                this.indentation.indentRight -= paragraph.getIndentationRight();
                                carriageReturn();
                                this.tabSettings = tabSettings2;
                                popLeading();
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.closeMCBlock(paragraph);
                                }
                                break;
                            case 13:
                            case 16:
                                Section section = (Section) element;
                                PdfPageEvent pageEvent2 = this.writer.getPageEvent();
                                boolean z = section.isNotAddedYet() && section.getTitle() != null;
                                if (section.isTriggerNewPage()) {
                                    newPage();
                                }
                                if (z) {
                                    float fIndentTop = indentTop() - this.currentHeight;
                                    int rotation = this.pageSize.getRotation();
                                    if (rotation == 90 || rotation == 180) {
                                        fIndentTop = this.pageSize.getHeight() - fIndentTop;
                                    }
                                    PdfDestination pdfDestination = new PdfDestination(2, fIndentTop);
                                    while (this.currentOutline.level() >= section.getDepth()) {
                                        this.currentOutline = this.currentOutline.parent();
                                    }
                                    this.currentOutline = new PdfOutline(this.currentOutline, pdfDestination, section.getBookmarkTitle(), section.isBookmarkOpen());
                                }
                                carriageReturn();
                                this.indentation.sectionIndentLeft += section.getIndentationLeft();
                                this.indentation.sectionIndentRight += section.getIndentationRight();
                                if (section.isNotAddedYet() && pageEvent2 != null) {
                                    if (element.type() == 16) {
                                        pageEvent2.onChapter(this.writer, this, indentTop() - this.currentHeight, section.getTitle());
                                    } else {
                                        pageEvent2.onSection(this.writer, this, indentTop() - this.currentHeight, section.getDepth(), section.getTitle());
                                    }
                                }
                                if (z) {
                                    this.isSectionTitle = true;
                                    add(section.getTitle());
                                    this.isSectionTitle = false;
                                }
                                this.indentation.sectionIndentLeft += section.getIndentation();
                                element.process(this);
                                flushLines();
                                this.indentation.sectionIndentLeft -= section.getIndentationLeft() + section.getIndentation();
                                this.indentation.sectionIndentRight -= section.getIndentationRight();
                                if (section.isComplete() && pageEvent2 != null) {
                                    if (element.type() != 16) {
                                        pageEvent2.onSectionEnd(this.writer, this, indentTop() - this.currentHeight);
                                    } else {
                                        pageEvent2.onChapterEnd(this.writer, this, indentTop() - this.currentHeight);
                                    }
                                }
                                break;
                            case 14:
                                List list = (List) element;
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.openMCBlock(list);
                                }
                                if (list.isAlignindent()) {
                                    list.normalizeIndentation();
                                }
                                this.indentation.listIndentLeft += list.getIndentationLeft();
                                this.indentation.indentRight += list.getIndentationRight();
                                element.process(this);
                                this.indentation.listIndentLeft -= list.getIndentationLeft();
                                this.indentation.indentRight -= list.getIndentationRight();
                                carriageReturn();
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.closeMCBlock(list);
                                }
                                break;
                            case 15:
                                ListItem listItem = (ListItem) element;
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.openMCBlock(listItem);
                                }
                                addSpacing(listItem.getSpacingBefore(), this.leading, listItem.getFont());
                                this.alignment = listItem.getAlignment();
                                this.indentation.listIndentLeft += listItem.getIndentationLeft();
                                this.indentation.indentRight += listItem.getIndentationRight();
                                this.leading = listItem.getTotalLeading();
                                pushLeading();
                                carriageReturn();
                                this.line.setListItem(listItem);
                                element.process(this);
                                addSpacing(listItem.getSpacingAfter(), listItem.getTotalLeading(), listItem.getFont(), true);
                                if (this.line.hasToBeJustified()) {
                                    this.line.resetAlignment();
                                }
                                carriageReturn();
                                this.indentation.listIndentLeft -= listItem.getIndentationLeft();
                                this.indentation.indentRight -= listItem.getIndentationRight();
                                popLeading();
                                if (isTagged(this.writer)) {
                                    flushLines();
                                    this.text.closeMCBlock(listItem.getListBody());
                                    this.text.closeMCBlock(listItem);
                                }
                                break;
                            case 17:
                                Anchor anchor = (Anchor) element;
                                String reference = anchor.getReference();
                                this.leading = anchor.getLeading();
                                pushLeading();
                                if (reference != null) {
                                    this.anchorAction = new PdfAction(reference);
                                }
                                element.process(this);
                                this.anchorAction = null;
                                popLeading();
                                break;
                            default:
                                switch (iType) {
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                        if (isTagged(this.writer) && !((Image) element).isImgTemplate()) {
                                            flushLines();
                                            this.text.openMCBlock((Image) element);
                                        }
                                        add((Image) element);
                                        if (isTagged(this.writer) && !((Image) element).isImgTemplate()) {
                                            flushLines();
                                            this.text.closeMCBlock((Image) element);
                                        }
                                        break;
                                    case 37:
                                        ensureNewLine();
                                        flushLines();
                                        addDiv((PdfDiv) element);
                                        this.pageEmpty = false;
                                        break;
                                    case 38:
                                        PdfBody pdfBody = (PdfBody) element;
                                        this.body = pdfBody;
                                        this.graphics.rectangle(pdfBody);
                                        return false;
                                    default:
                                        return false;
                                }
                                break;
                        }
                        break;
                }
            } else {
                this.graphics.rectangle((Rectangle) element);
                this.pageEmpty = false;
            }
            this.lastElementType = element.type();
            return true;
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public void addAdditionalAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.additionalActions == null) {
            this.additionalActions = new PdfDictionary();
        }
        if (pdfAction == null) {
            this.additionalActions.remove(pdfName);
        } else {
            this.additionalActions.put(pdfName, pdfAction);
        }
        if (this.additionalActions.size() == 0) {
            this.additionalActions = null;
        }
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pageEmpty = false;
        this.annotationsImp.addAnnotation(pdfAnnotation);
    }

    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.annotationsImp.addCalculationOrder(pdfFormField);
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) {
        if (str == null) {
            PdfString pdfString = (PdfString) pdfFileSpecification.get(PdfName.DESC);
            str = pdfString == null ? "" : PdfEncodings.convertToString(pdfString.getBytes(), null);
        }
        pdfFileSpecification.addDescription(str, true);
        if (str.length() == 0) {
            str = "Unnamed";
        }
        String strConvertToString = PdfEncodings.convertToString(new PdfString(str, PdfObject.TEXT_UNICODE).getBytes(), null);
        int i = 0;
        while (this.documentFileAttachment.containsKey(strConvertToString)) {
            i++;
            strConvertToString = PdfEncodings.convertToString(new PdfString(str + " " + i, PdfObject.TEXT_UNICODE).getBytes(), null);
        }
        this.documentFileAttachment.put(strConvertToString, pdfFileSpecification.getReference());
    }

    public void addJavaScript(PdfAction pdfAction) {
        if (pdfAction.get(PdfName.JS) == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
        }
        try {
            HashMap<String, PdfObject> map = this.documentLevelJS;
            DecimalFormat decimalFormat = SIXTEEN_DIGITS;
            int i = this.jsCounter;
            this.jsCounter = i + 1;
            map.put(decimalFormat.format(i), this.writer.addToBody(pdfAction).getIndirectReference());
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void addOutline(PdfOutline pdfOutline, String str) {
        localDestination(str, pdfOutline.getPdfDestination());
    }

    public void addPTable(PdfPTable pdfPTable) throws DocumentException {
        ColumnText columnText = new ColumnText(isTagged(this.writer) ? this.text : this.writer.getDirectContent());
        columnText.setRunDirection(pdfPTable.getRunDirection());
        if (pdfPTable.getKeepTogether() && !fitsPage(pdfPTable, 0.0f) && this.currentHeight > 0.0f) {
            newPage();
            if (isTagged(this.writer)) {
                columnText.setCanvas(this.text);
            }
        }
        if (this.currentHeight == 0.0f) {
            columnText.setAdjustFirstLine(false);
        }
        columnText.addElement(pdfPTable);
        boolean zIsHeadersInEvent = pdfPTable.isHeadersInEvent();
        pdfPTable.setHeadersInEvent(true);
        int i = 0;
        while (true) {
            columnText.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            if ((columnText.go() & 1) != 0) {
                if (isTagged(this.writer)) {
                    this.text.setTextMatrix(indentLeft(), columnText.getYLine());
                } else {
                    this.text.moveText(0.0f, (columnText.getYLine() - indentTop()) + this.currentHeight);
                }
                this.currentHeight = indentTop() - columnText.getYLine();
                pdfPTable.setHeadersInEvent(zIsHeadersInEvent);
                return;
            }
            i = indentTop() - this.currentHeight == columnText.getYLine() ? i + 1 : 0;
            if (i == 3) {
                throw new DocumentException(MessageLocalization.getComposedMessage("infinite.table.loop", new Object[0]));
            }
            this.currentHeight = indentTop() - columnText.getYLine();
            newPage();
            if (isTagged(this.writer)) {
                columnText.setCanvas(this.text);
            }
        }
    }

    public void addSpacing(float f, float f2, Font font) {
        addSpacing(f, f2, font, false);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    public void addWriter(PdfWriter pdfWriter) {
        if (this.writer != null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
        }
        this.writer = pdfWriter;
        this.annotationsImp = new PdfAnnotationsImp(pdfWriter);
    }

    public float calculateLineHeight() {
        float fHeight = this.line.height();
        float f = this.leading;
        return fHeight != f ? fHeight + f : fHeight;
    }

    public void calculateOutlineCount() {
        if (this.rootOutline.getKids().size() == 0) {
            return;
        }
        traverseOutlineCount(this.rootOutline);
    }

    public void carriageReturn() {
        if (this.lines == null) {
            this.lines = new ArrayList<>();
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            if (this.currentHeight + calculateLineHeight() > indentTop() - indentBottom() && this.currentHeight != 0.0f) {
                PdfLine pdfLine2 = this.line;
                this.line = null;
                newPage();
                this.line = pdfLine2;
                pdfLine2.left = indentLeft();
            }
            this.currentHeight += this.line.height();
            this.lines.add(this.line);
            this.pageEmpty = false;
        }
        float f = this.imageEnd;
        if (f > -1.0f && this.currentHeight > f) {
            this.imageEnd = -1.0f;
            Indentation indentation = this.indentation;
            indentation.imageIndentRight = 0.0f;
            indentation.imageIndentLeft = 0.0f;
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    public void clearTextWrap() {
        float fHeight = this.imageEnd - this.currentHeight;
        PdfLine pdfLine = this.line;
        if (pdfLine != null) {
            fHeight += pdfLine.height();
        }
        if (this.imageEnd <= -1.0f || fHeight <= 0.0f) {
            return;
        }
        carriageReturn();
        this.currentHeight += fHeight;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void close() {
        int size;
        if (this.close) {
            return;
        }
        try {
            if (isTagged(this.writer)) {
                flushFloatingElements();
                flushLines();
                this.writer.flushAcroFields();
                this.writer.flushTaggedObjects();
                if (isPageEmpty() && (size = this.writer.pageReferences.size()) > 0) {
                    PdfWriter pdfWriter = this.writer;
                    if (pdfWriter.currentPageNumber == size) {
                        pdfWriter.pageReferences.remove(size - 1);
                    }
                }
            } else {
                this.writer.flushAcroFields();
            }
            if (this.imageWait != null) {
                newPage();
            }
            endPage();
            if (isTagged(this.writer)) {
                this.writer.getDirectContent().closeMCBlock(this);
            }
            if (this.annotationsImp.hasUnusedAnnotations()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            }
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                pageEvent.onCloseDocument(this.writer, this);
            }
            super.close();
            this.writer.addLocalDestinations(this.localDestinations);
            calculateOutlineCount();
            writeOutlines();
            this.writer.close();
        } catch (Exception e) {
            throw ExceptionConverter.convertException(e);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ArrayList<IAccessibleElement> endPage() {
        if (isPageEmpty()) {
            return null;
        }
        try {
            flushFloatingElements();
            this.lastElementType = -1;
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                pageEvent.onEndPage(this.writer, this);
            }
            try {
                flushLines();
                int rotation = this.pageSize.getRotation();
                if (this.writer.isPdfIso()) {
                    if (this.thisBoxSize.containsKey("art") && this.thisBoxSize.containsKey("trim")) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("only.one.of.artbox.or.trimbox.can.exist.in.the.page", new Object[0]));
                    }
                    if (!this.thisBoxSize.containsKey("art") && !this.thisBoxSize.containsKey("trim")) {
                        if (this.thisBoxSize.containsKey("crop")) {
                            HashMap<String, PdfRectangle> map = this.thisBoxSize;
                            map.put("trim", map.get("crop"));
                        } else {
                            HashMap<String, PdfRectangle> map2 = this.thisBoxSize;
                            Rectangle rectangle = this.pageSize;
                            map2.put("trim", new PdfRectangle(rectangle, rectangle.getRotation()));
                        }
                    }
                }
                this.pageResources.addDefaultColorDiff(this.writer.getDefaultColorspace());
                if (this.writer.isRgbTransparencyBlending()) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.CS, PdfName.DEVICERGB);
                    this.pageResources.addDefaultColorDiff(pdfDictionary);
                }
                PdfPage pdfPage = new PdfPage(new PdfRectangle(this.pageSize, rotation), this.thisBoxSize, this.pageResources.getResources(), rotation);
                if (isTagged(this.writer)) {
                    pdfPage.put(PdfName.TABS, PdfName.S);
                } else {
                    pdfPage.put(PdfName.TABS, this.writer.getTabs());
                }
                pdfPage.putAll(this.writer.getPageDictEntries());
                this.writer.resetPageDictEntries();
                PdfDictionary pdfDictionary2 = this.pageAA;
                if (pdfDictionary2 != null) {
                    pdfPage.put(PdfName.AA, this.writer.addToBody(pdfDictionary2).getIndirectReference());
                    this.pageAA = null;
                }
                if (this.annotationsImp.hasUnusedAnnotations()) {
                    PdfArray pdfArrayRotateAnnotations = this.annotationsImp.rotateAnnotations(this.writer, this.pageSize);
                    if (pdfArrayRotateAnnotations.size() != 0) {
                        pdfPage.put(PdfName.ANNOTS, pdfArrayRotateAnnotations);
                    }
                }
                if (isTagged(this.writer)) {
                    pdfPage.put(PdfName.STRUCTPARENTS, new PdfNumber(getStructParentIndex(this.writer.getCurrentPage())));
                }
                if (this.text.size() > this.textEmptySize || isTagged(this.writer)) {
                    this.text.endText();
                } else {
                    this.text = null;
                }
                ArrayList<IAccessibleElement> arrayListSaveMCBlocks = isTagged(this.writer) ? this.writer.getDirectContent().saveMCBlocks() : null;
                this.writer.add(pdfPage, new PdfContents(this.writer.getDirectContentUnder(), this.graphics, isTagged(this.writer) ? null : this.text, this.writer.getDirectContent(), this.pageSize));
                this.annotationsImp.resetAnnotations();
                this.writer.resetContent();
                return arrayListSaveMCBlocks;
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } catch (DocumentException e3) {
            throw new ExceptionConverter(e3);
        }
    }

    public void ensureNewLine() {
        try {
            int i = this.lastElementType;
            if (i == 11 || i == 10) {
                newLine();
                flushLines();
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean fitsPage(PdfPTable pdfPTable, float f) {
        if (!pdfPTable.isLockedWidth()) {
            pdfPTable.setTotalWidth(((indentRight() - indentLeft()) * pdfPTable.getWidthPercentage()) / 100.0f);
        }
        ensureNewLine();
        return (pdfPTable.isSkipFirstHeader() ? pdfPTable.getTotalHeight() - pdfPTable.getHeaderHeight() : pdfPTable.getTotalHeight()) + (this.currentHeight > 0.0f ? pdfPTable.spacingBefore() : 0.0f) <= ((indentTop() - this.currentHeight) - indentBottom()) - f;
    }

    public float flushLines() throws DocumentException {
        ListLabel listLabel;
        if (this.lines == null) {
            return 0.0f;
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            this.lines.add(this.line);
            this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
        }
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        Object[] objArr = new Object[2];
        objArr[1] = new Float(0.0f);
        PdfFont pdfFont = null;
        float fHeight = 0.0f;
        for (PdfLine pdfLine2 : this.lines) {
            float fIndentLeft = pdfLine2.indentLeft() - indentLeft();
            Indentation indentation = this.indentation;
            float f = fIndentLeft + indentation.indentLeft + indentation.listIndentLeft + indentation.sectionIndentLeft;
            this.text.moveText(f, -pdfLine2.height());
            pdfLine2.flush();
            if (pdfLine2.listSymbol() != null) {
                Chunk chunkListSymbol = pdfLine2.listSymbol();
                if (isTagged(this.writer)) {
                    listLabel = pdfLine2.listItem().getListLabel();
                    this.graphics.openMCBlock(listLabel);
                    Chunk chunk = new Chunk(chunkListSymbol);
                    chunk.setRole(null);
                    chunkListSymbol = chunk;
                } else {
                    listLabel = null;
                }
                ColumnText.showTextAligned(this.graphics, 0, new Phrase(chunkListSymbol), this.text.getXTLM() - pdfLine2.listIndent(), this.text.getYTLM(), 0.0f);
                if (listLabel != null) {
                    this.graphics.closeMCBlock(listLabel);
                }
            }
            objArr[0] = pdfFont;
            if (isTagged(this.writer) && pdfLine2.listItem() != null) {
                this.text.openMCBlock(pdfLine2.listItem().getListBody());
            }
            writeLineToContent(pdfLine2, this.text, this.graphics, objArr, this.writer.getSpaceCharRatio());
            pdfFont = (PdfFont) objArr[0];
            fHeight += pdfLine2.height();
            this.text.moveText(-f, 0.0f);
        }
        this.lines = new ArrayList<>();
        return fHeight;
    }

    public void flushStructureElementsOnNewPage() {
        if (this.isToUseExternalCache) {
            Iterator<Map.Entry<AccessibleElementId, PdfStructureElement>> it = this.structElements.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<AccessibleElementId, PdfStructureElement> next = it.next();
                if (!next.getValue().getStructureType().equals(PdfName.DOCUMENT)) {
                    try {
                        PdfStructureElement value = next.getValue();
                        PdfDictionary parent = value.getParent();
                        PdfStructureElement pdfStructureElement = parent instanceof PdfStructureElement ? (PdfStructureElement) parent : null;
                        if (pdfStructureElement != null) {
                            this.elementsParents.put(next.getKey(), pdfStructureElement.getElementId());
                        }
                        this.externallyStoredStructElements.put(next.getKey(), this.externalCache.put(value));
                        it.remove();
                    } catch (IOException e) {
                        throw new ExceptionConverter(e);
                    }
                }
            }
        }
    }

    public PdfAcroForm getAcroForm() {
        return this.annotationsImp.getAcroForm();
    }

    public Rectangle getBoxSize(String str) {
        PdfRectangle pdfRectangle = this.thisBoxSize.get(str);
        if (pdfRectangle != null) {
            return pdfRectangle.getRectangle();
        }
        return null;
    }

    public PdfCatalog getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfCatalog pdfCatalog = new PdfCatalog(pdfIndirectReference, this.writer);
        if (this.rootOutline.getKids().size() > 0) {
            pdfCatalog.put(PdfName.PAGEMODE, PdfName.USEOUTLINES);
            pdfCatalog.put(PdfName.OUTLINES, this.rootOutline.indirectReference());
        }
        this.writer.getPdfVersion().addToCatalog(pdfCatalog);
        this.viewerPreferences.addToCatalog(pdfCatalog);
        PdfPageLabels pdfPageLabels = this.pageLabels;
        if (pdfPageLabels != null) {
            pdfCatalog.put(PdfName.PAGELABELS, pdfPageLabels.getDictionary(this.writer));
        }
        pdfCatalog.addNames(this.localDestinations, getDocumentLevelJS(), this.documentFileAttachment, this.writer);
        String str = this.openActionName;
        if (str != null) {
            pdfCatalog.setOpenAction(getLocalGotoAction(str));
        } else {
            PdfAction pdfAction = this.openActionAction;
            if (pdfAction != null) {
                pdfCatalog.setOpenAction(pdfAction);
            }
        }
        PdfDictionary pdfDictionary = this.additionalActions;
        if (pdfDictionary != null) {
            pdfCatalog.setAdditionalActions(pdfDictionary);
        }
        PdfCollection pdfCollection = this.collection;
        if (pdfCollection != null) {
            pdfCatalog.put(PdfName.COLLECTION, pdfCollection);
        }
        if (this.annotationsImp.hasValidAcroForm()) {
            try {
                pdfCatalog.put(PdfName.ACROFORM, this.writer.addToBody(this.annotationsImp.getAcroForm()).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        PdfString pdfString = this.language;
        if (pdfString != null) {
            pdfCatalog.put(PdfName.LANG, pdfString);
        }
        return pdfCatalog;
    }

    public HashMap<String, PdfObject> getDocumentFileAttachment() {
        return this.documentFileAttachment;
    }

    public HashMap<String, PdfObject> getDocumentLevelJS() {
        return this.documentLevelJS;
    }

    public PdfInfo getInfo() {
        return this.f89info;
    }

    public float getLeading() {
        return this.leading;
    }

    public PdfAction getLocalGotoAction(String str) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        PdfAction pdfAction = destination.action;
        if (pdfAction != null) {
            return pdfAction;
        }
        if (destination.reference == null) {
            destination.reference = this.writer.getPdfIndirectReference();
        }
        PdfAction pdfAction2 = new PdfAction(destination.reference);
        destination.action = pdfAction2;
        this.localDestinations.put(str, destination);
        return pdfAction2;
    }

    public int getNextMarkPoint(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        int i = iArr[1];
        iArr[1] = i + 1;
        return i;
    }

    public PdfPageLabels getPageLabels() {
        return this.pageLabels;
    }

    public PageResources getPageResources() {
        return this.pageResources;
    }

    public PdfOutline getRootOutline() {
        return this.rootOutline;
    }

    public PdfStructureElement getStructElement(AccessibleElementId accessibleElementId) {
        return getStructElement(accessibleElementId, true);
    }

    public Set<AccessibleElementId> getStructElements() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.externallyStoredStructElements.keySet());
        hashSet.addAll(this.structElements.keySet());
        return hashSet;
    }

    public int getStructParentIndex(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        return iArr[0];
    }

    public int[] getStructParentIndexAndNextMarkPoint(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        int i = iArr[1];
        iArr[1] = i + 1;
        return new int[]{iArr[0], i};
    }

    public TabSettings getTabSettings() {
        return this.tabSettings;
    }

    public float getVerticalPosition(boolean z) {
        if (z) {
            ensureNewLine();
        }
        return (top() - this.currentHeight) - this.indentation.indentTop;
    }

    public float indentBottom() {
        return bottom(this.indentation.indentBottom);
    }

    public float indentLeft() {
        Indentation indentation = this.indentation;
        return left(indentation.indentLeft + indentation.listIndentLeft + indentation.imageIndentLeft + indentation.sectionIndentLeft);
    }

    public float indentRight() {
        Indentation indentation = this.indentation;
        return right(indentation.indentRight + indentation.sectionIndentRight + indentation.imageIndentRight);
    }

    public float indentTop() {
        return top(this.indentation.indentTop);
    }

    public void initPage() throws DocumentException {
        this.pageN++;
        this.pageResources = new PageResources();
        if (isTagged(this.writer)) {
            this.graphics = this.writer.getDirectContentUnder().getDuplicate();
            this.writer.getDirectContent().duplicatedFrom = this.graphics;
        } else {
            this.graphics = new PdfContentByte(this.writer);
        }
        setNewPageSizeAndMargins();
        this.imageEnd = -1.0f;
        Indentation indentation = this.indentation;
        indentation.imageIndentRight = 0.0f;
        indentation.imageIndentLeft = 0.0f;
        indentation.indentBottom = 0.0f;
        indentation.indentTop = 0.0f;
        this.currentHeight = 0.0f;
        this.thisBoxSize = new HashMap<>(this.boxSize);
        if (this.pageSize.getBackgroundColor() != null || this.pageSize.hasBorders() || this.pageSize.getBorderColor() != null) {
            add(this.pageSize);
        }
        float f = this.leading;
        int i = this.alignment;
        this.pageEmpty = true;
        try {
            Image image = this.imageWait;
            if (image != null) {
                add(image);
                this.imageWait = null;
            }
            this.leading = f;
            this.alignment = i;
            carriageReturn();
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                if (this.firstPageEvent) {
                    pageEvent.onOpenDocument(this.writer, this);
                }
                pageEvent.onStartPage(this.writer, this);
            }
            this.firstPageEvent = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean isPageEmpty() {
        if (isTagged(this.writer)) {
            PdfWriter pdfWriter = this.writer;
            if (pdfWriter != null) {
                return pdfWriter.getDirectContent().size(false) == 0 && this.writer.getDirectContentUnder().size(false) == 0 && this.text.size(false) - this.textEmptySize == 0 && (this.pageEmpty || this.writer.isPaused());
            }
            return true;
        }
        PdfWriter pdfWriter2 = this.writer;
        if (pdfWriter2 != null) {
            return pdfWriter2.getDirectContent().size() == 0 && this.writer.getDirectContentUnder().size() == 0 && (this.pageEmpty || this.writer.isPaused());
        }
        return true;
    }

    public boolean isStrictImageSequence() {
        return this.strictImageSequence;
    }

    public boolean localDestination(String str, PdfDestination pdfDestination) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.destination != null) {
            return false;
        }
        destination.destination = pdfDestination;
        this.localDestinations.put(str, destination);
        if (pdfDestination.hasPage()) {
            return true;
        }
        pdfDestination.addPage(this.writer.getCurrentPage());
        return true;
    }

    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(this.writer.createAnnotation(f, f2, f3, f4, getLocalGotoAction(str), null));
    }

    public void newLine() {
        this.lastElementType = -1;
        carriageReturn();
        ArrayList<PdfLine> arrayList = this.lines;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.lines.add(this.line);
            this.currentHeight += this.line.height();
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean newPage() {
        if (isPageEmpty()) {
            setNewPageSizeAndMargins();
            return false;
        }
        if (!this.open || this.close) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
        }
        ArrayList<IAccessibleElement> arrayListEndPage = endPage();
        super.newPage();
        Indentation indentation = this.indentation;
        indentation.imageIndentLeft = 0.0f;
        indentation.imageIndentRight = 0.0f;
        try {
            if (isTagged(this.writer)) {
                flushStructureElementsOnNewPage();
                this.writer.getDirectContentUnder().restoreMCBlocks(arrayListEndPage);
            }
            initPage();
            PdfBody pdfBody = this.body;
            if (pdfBody == null || pdfBody.getBackgroundColor() == null) {
                return true;
            }
            this.graphics.rectangle(this.body);
            return true;
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void open() {
        if (!this.open) {
            super.open();
            this.writer.open();
            PdfOutline pdfOutline = new PdfOutline(this.writer);
            this.rootOutline = pdfOutline;
            this.currentOutline = pdfOutline;
        }
        try {
            if (isTagged(this.writer)) {
                this.openMCDocument = true;
            }
            initPage();
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void outlineTree(PdfOutline pdfOutline) {
        pdfOutline.setIndirectReference(this.writer.getPdfIndirectReference());
        if (pdfOutline.parent() != null) {
            pdfOutline.put(PdfName.PARENT, pdfOutline.parent().indirectReference());
        }
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        int size = kids.size();
        for (int i = 0; i < size; i++) {
            outlineTree(kids.get(i));
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                kids.get(i2).put(PdfName.PREV, kids.get(i2 - 1).indirectReference());
            }
            if (i2 < size - 1) {
                kids.get(i2).put(PdfName.NEXT, kids.get(i2 + 1).indirectReference());
            }
        }
        if (size > 0) {
            pdfOutline.put(PdfName.FIRST, kids.get(0).indirectReference());
            pdfOutline.put(PdfName.LAST, kids.get(size - 1).indirectReference());
        }
        for (int i3 = 0; i3 < size; i3++) {
            PdfOutline pdfOutline2 = kids.get(i3);
            this.writer.addToBody(pdfOutline2, pdfOutline2.indirectReference());
        }
    }

    public void popLeading() {
        this.leading = this.leadingStack.pop().floatValue();
        if (this.leadingStack.size() > 0) {
            this.leading = this.leadingStack.peek().floatValue();
        }
    }

    public void pushLeading() {
        this.leadingStack.push(Float.valueOf(this.leading));
    }

    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(this.writer.createAnnotation(f, f2, f3, f4, new PdfAction(str, str2), null));
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void resetPageCount() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetPageCount();
        }
    }

    public void saveStructElement(AccessibleElementId accessibleElementId, PdfStructureElement pdfStructureElement) {
        this.structElements.put(accessibleElementId, pdfStructureElement);
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, pdfAction, null));
    }

    public void setBoxSize(String str, Rectangle rectangle) {
        if (rectangle == null) {
            this.boxSize.remove(str);
        } else {
            this.boxSize.put(str, new PdfRectangle(rectangle));
        }
    }

    public void setCollection(PdfCollection pdfCollection) {
        this.collection = pdfCollection;
    }

    public void setCropBoxSize(Rectangle rectangle) {
        setBoxSize("crop", rectangle);
    }

    public void setDuration(int i) {
        if (i > 0) {
            this.writer.addPageDictEntry(PdfName.DUR, new PdfNumber(i));
        }
    }

    public void setLanguage(String str) {
        this.language = new PdfString(str);
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroring(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroringTopBottom(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextMarginLeft = f;
        this.nextMarginRight = f2;
        this.nextMarginTop = f3;
        this.nextMarginBottom = f4;
        return true;
    }

    public void setNewPageSizeAndMargins() {
        this.pageSize = this.nextPageSize;
        if (this.marginMirroring && (getPageNumber() & 1) == 0) {
            this.marginRight = this.nextMarginLeft;
            this.marginLeft = this.nextMarginRight;
        } else {
            this.marginLeft = this.nextMarginLeft;
            this.marginRight = this.nextMarginRight;
        }
        if (this.marginMirroringTopBottom && (getPageNumber() & 1) == 0) {
            this.marginTop = this.nextMarginBottom;
            this.marginBottom = this.nextMarginTop;
        } else {
            this.marginTop = this.nextMarginTop;
            this.marginBottom = this.nextMarginBottom;
        }
        if (isTagged(this.writer)) {
            this.text = this.graphics;
        } else {
            PdfContentByte pdfContentByte = new PdfContentByte(this.writer);
            this.text = pdfContentByte;
            pdfContentByte.reset();
        }
        this.text.beginText();
        this.text.moveText(left(), top());
        if (isTagged(this.writer)) {
            this.textEmptySize = this.text.size();
        }
    }

    public void setOpenAction(String str) {
        this.openActionName = str;
        this.openActionAction = null;
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.pageAA == null) {
            this.pageAA = new PdfDictionary();
        }
        this.pageAA.put(pdfName, pdfAction);
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void setPageCount(int i) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setPageCount(i);
        }
    }

    public void setPageEmpty(boolean z) {
        this.pageEmpty = z;
    }

    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pageLabels = pdfPageLabels;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextPageSize = new Rectangle(rectangle);
        return true;
    }

    public void setSigFlags(int i) {
        this.annotationsImp.setSigFlags(i);
    }

    public void setStrictImageSequence(boolean z) {
        this.strictImageSequence = z;
    }

    public void setTabSettings(TabSettings tabSettings) {
        this.tabSettings = tabSettings;
    }

    public void setThumbnail(Image image) {
        PdfWriter pdfWriter = this.writer;
        pdfWriter.addPageDictEntry(PdfName.THUMB, pdfWriter.getImageReference(pdfWriter.addDirectImageSimple(image)));
    }

    public void setTransition(PdfTransition pdfTransition) {
        this.writer.addPageDictEntry(PdfName.TRANS, pdfTransition.getTransitionDictionary());
    }

    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setXmpMetadata(byte[] bArr) {
        PdfStream pdfStream = new PdfStream(bArr);
        PdfName pdfName = PdfName.TYPE;
        PdfName pdfName2 = PdfName.METADATA;
        pdfStream.put(pdfName, pdfName2);
        pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
        PdfEncryption encryption = this.writer.getEncryption();
        if (encryption != null && !encryption.isMetadataEncrypted()) {
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(PdfName.CRYPT);
            pdfStream.put(PdfName.FILTER, pdfArray);
        }
        PdfWriter pdfWriter = this.writer;
        pdfWriter.addPageDictEntry(pdfName2, pdfWriter.addToBody(pdfStream).getIndirectReference());
    }

    public void traverseOutlineCount(PdfOutline pdfOutline) {
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        PdfOutline pdfOutlineParent = pdfOutline.parent();
        if (kids.isEmpty()) {
            if (pdfOutlineParent != null) {
                pdfOutlineParent.setCount(pdfOutlineParent.getCount() + 1);
                return;
            }
            return;
        }
        for (int i = 0; i < kids.size(); i++) {
            traverseOutlineCount(kids.get(i));
        }
        if (pdfOutlineParent != null) {
            if (pdfOutline.isOpen()) {
                pdfOutlineParent.setCount(pdfOutline.getCount() + pdfOutlineParent.getCount() + 1);
            } else {
                pdfOutlineParent.setCount(pdfOutlineParent.getCount() + 1);
                pdfOutline.setCount(-pdfOutline.getCount());
            }
        }
    }

    public void useExternalCache(TempFileCache tempFileCache) {
        this.isToUseExternalCache = true;
        this.externalCache = tempFileCache;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0324  */
    /* JADX WARN: Code duplicated, block: B:115:0x033f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0343  */
    /* JADX WARN: Code duplicated, block: B:121:0x034f  */
    /* JADX WARN: Code duplicated, block: B:123:0x035e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0361  */
    /* JADX WARN: Code duplicated, block: B:126:0x0365  */
    /* JADX WARN: Code duplicated, block: B:129:0x0399  */
    /* JADX WARN: Code duplicated, block: B:132:0x03af  */
    /* JADX WARN: Code duplicated, block: B:134:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:141:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:144:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:148:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:150:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:153:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:155:0x0427  */
    /* JADX WARN: Code duplicated, block: B:163:0x0490  */
    /* JADX WARN: Code duplicated, block: B:166:0x0499  */
    /* JADX WARN: Code duplicated, block: B:170:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:172:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:175:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:176:0x04db  */
    /* JADX WARN: Code duplicated, block: B:179:0x0504  */
    /* JADX WARN: Code duplicated, block: B:183:0x050e  */
    /* JADX WARN: Code duplicated, block: B:185:0x0512  */
    /* JADX WARN: Code duplicated, block: B:189:0x0532  */
    /* JADX WARN: Code duplicated, block: B:190:0x0545  */
    /* JADX WARN: Code duplicated, block: B:193:0x054e  */
    /* JADX WARN: Code duplicated, block: B:197:0x0558  */
    /* JADX WARN: Code duplicated, block: B:199:0x055c  */
    /* JADX WARN: Code duplicated, block: B:202:0x0572  */
    /* JADX WARN: Code duplicated, block: B:203:0x057e  */
    /* JADX WARN: Code duplicated, block: B:206:0x0588  */
    /* JADX WARN: Code duplicated, block: B:210:0x0592  */
    /* JADX WARN: Code duplicated, block: B:212:0x0596  */
    /* JADX WARN: Code duplicated, block: B:219:0x05d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:220:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:221:0x05db  */
    /* JADX WARN: Code duplicated, block: B:223:0x05df  */
    /* JADX WARN: Code duplicated, block: B:224:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:228:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:230:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:233:0x0614  */
    /* JADX WARN: Code duplicated, block: B:234:0x0622  */
    /* JADX WARN: Code duplicated, block: B:237:0x062a  */
    /* JADX WARN: Code duplicated, block: B:243:0x0661  */
    /* JADX WARN: Code duplicated, block: B:246:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:249:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:250:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:252:0x0722  */
    /* JADX WARN: Code duplicated, block: B:255:0x074f  */
    /* JADX WARN: Code duplicated, block: B:257:0x075b  */
    /* JADX WARN: Code duplicated, block: B:258:0x076b  */
    /* JADX WARN: Code duplicated, block: B:262:0x0783  */
    /* JADX WARN: Code duplicated, block: B:264:0x078f  */
    /* JADX WARN: Code duplicated, block: B:267:0x0795 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:270:0x079e  */
    /* JADX WARN: Code duplicated, block: B:272:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:275:0x07b5  */
    /* JADX WARN: Code duplicated, block: B:277:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:278:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:280:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:281:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:283:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:286:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:289:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:290:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:292:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:293:0x0810  */
    /* JADX WARN: Code duplicated, block: B:295:0x0818  */
    /* JADX WARN: Code duplicated, block: B:300:0x0841 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:30:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:315:0x08b9  */
    /* JADX WARN: Code duplicated, block: B:317:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:322:0x08e3  */
    /* JADX WARN: Code duplicated, block: B:324:0x08e9  */
    /* JADX WARN: Code duplicated, block: B:326:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:328:0x08f4  */
    /* JADX WARN: Code duplicated, block: B:331:0x08fd  */
    /* JADX WARN: Code duplicated, block: B:334:0x0908  */
    /* JADX WARN: Code duplicated, block: B:336:0x0910  */
    /* JADX WARN: Code duplicated, block: B:340:0x091d  */
    /* JADX WARN: Code duplicated, block: B:342:0x0925  */
    /* JADX WARN: Code duplicated, block: B:345:0x0930  */
    /* JADX WARN: Code duplicated, block: B:348:0x093d  */
    /* JADX WARN: Code duplicated, block: B:354:0x0967  */
    /* JADX WARN: Code duplicated, block: B:356:0x0973  */
    /* JADX WARN: Code duplicated, block: B:357:0x0975  */
    /* JADX WARN: Code duplicated, block: B:359:0x0979  */
    /* JADX WARN: Code duplicated, block: B:364:0x0944 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x03b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x010f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0129  */
    /* JADX WARN: Code duplicated, block: B:50:0x013d  */
    /* JADX WARN: Code duplicated, block: B:51:0x014d  */
    /* JADX WARN: Code duplicated, block: B:54:0x017f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0181  */
    /* JADX WARN: Code duplicated, block: B:56:0x0186  */
    /* JADX WARN: Code duplicated, block: B:59:0x0190  */
    /* JADX WARN: Code duplicated, block: B:61:0x019c  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:66:0x020a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0223  */
    /* JADX WARN: Code duplicated, block: B:71:0x022b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0231  */
    /* JADX WARN: Code duplicated, block: B:75:0x023d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0251  */
    /* JADX WARN: Code duplicated, block: B:77:0x0254  */
    /* JADX WARN: Code duplicated, block: B:79:0x027a  */
    /* JADX WARN: Code duplicated, block: B:81:0x028f  */
    /* JADX WARN: Code duplicated, block: B:84:0x029b  */
    /* JADX WARN: Code duplicated, block: B:86:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:96:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c8  */
    public float writeLineToContent(PdfLine pdfLine, PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2, Object[] objArr, float f) throws DocumentException {
        float f2;
        float fWidthLeft;
        float f3;
        float f4;
        float f5;
        float f6;
        int lastStrokeChunk;
        float xtlm;
        float ytlm;
        PdfFont pdfFont;
        float f7;
        int i;
        float f8;
        boolean z;
        float f9;
        boolean z2;
        PdfContentByte pdfContentByte3;
        float f10;
        boolean z3;
        float size;
        float fHeight;
        float fHeight2;
        float f11;
        String str;
        String str2;
        int i2;
        BaseColor baseColor;
        String str3;
        float f12;
        String str4;
        PdfContentByte pdfContentByte4;
        String str5;
        PdfContentByte pdfContentByte5;
        float f13;
        String str6;
        float f14;
        int i3;
        char c;
        PdfChunk pdfChunk;
        float f15;
        float f16;
        PdfFont pdfFont2;
        PdfFont pdfFontFont;
        PdfChunk pdfChunk2;
        Object[] objArr2;
        Float f17;
        BaseColor baseColor2;
        float fFloatValue;
        int iIntValue;
        float fFloatValue2;
        float f18;
        int i4;
        float f19;
        float f20;
        float f21;
        float f22;
        IAccessibleElement iAccessibleElement;
        float fWidth;
        PdfChunk chunk;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        float[] fArr;
        Float f29;
        float f30;
        float f31;
        float fFloatValue3;
        float f32;
        String str7;
        String str8;
        float f33;
        boolean z4;
        boolean z5;
        float f34;
        float f35;
        Rectangle rectangle;
        PdfPageEvent pageEvent;
        float f36;
        float f37;
        String str9;
        Object obj;
        float f38;
        PdfAnnotation pdfAnnotationCreateAnnotation;
        IAccessibleElement iAccessibleElement2;
        PdfStructureElement structElement;
        boolean inText;
        float f39;
        Object[][] objArr3;
        int i5;
        BaseColor baseColor3;
        BaseColor baseColor4;
        int i6;
        Object[] objArr4;
        boolean inText2;
        float f40;
        DrawInterface drawInterface;
        float fFloatValue4;
        TabStop tabStop;
        Object[] objArr5;
        DrawInterface drawInterface2;
        IAccessibleElement iAccessibleElement3;
        PdfDocument pdfDocument = this;
        PdfLine pdfLine2 = pdfLine;
        PdfContentByte pdfContentByte6 = pdfContentByte;
        PdfContentByte pdfContentByte7 = pdfContentByte2;
        PdfFont pdfFont3 = (PdfFont) objArr[0];
        float fFloatValue5 = ((Float) objArr[1]).floatValue();
        float xtlm2 = pdfContentByte.getXTLM() + pdfLine.getOriginalWidth();
        int iNumberOfSpaces = pdfLine.numberOfSpaces();
        int lineLengthUtf32 = pdfLine.getLineLengthUtf32();
        boolean z6 = pdfLine.hasToBeJustified() && (iNumberOfSpaces != 0 || lineLengthUtf32 > 1);
        int separatorCount = pdfLine.getSeparatorCount();
        if (separatorCount <= 0) {
            if (z6 && separatorCount == 0) {
                if (pdfLine.isNewlineSplit()) {
                    float f41 = (((iNumberOfSpaces * f) + lineLengthUtf32) - 1.0f) * fFloatValue5;
                    if (pdfLine.widthLeft() >= f41) {
                        if (pdfLine.isRTL()) {
                            pdfContentByte6.moveText(pdfLine.widthLeft() - f41, 0.0f);
                        }
                        f4 = fFloatValue5;
                        fFloatValue5 = f4;
                        f2 = xtlm2;
                        f5 = f * fFloatValue5;
                        fWidthLeft = 0.0f;
                        f6 = 0.0f;
                    }
                }
                float fWidthLeft2 = pdfLine.widthLeft();
                PdfChunk chunk2 = pdfLine2.getChunk(pdfLine.size() - 1);
                if (chunk2 != null) {
                    String string = chunk2.toString();
                    if (string.length() > 0) {
                        char cCharAt = string.charAt(string.length() - 1);
                        if (hangingPunctuation.indexOf(cCharAt) >= 0) {
                            float fWidth2 = (chunk2.font().width(cCharAt) * 0.4f) + fWidthLeft2;
                            f3 = fWidth2 - fWidthLeft2;
                            fWidthLeft2 = fWidth2;
                        } else {
                            f3 = 0.0f;
                        }
                    } else {
                        f3 = 0.0f;
                    }
                } else {
                    f3 = 0.0f;
                }
                float f42 = fWidthLeft2 / (((iNumberOfSpaces * f) + lineLengthUtf32) - 1.0f);
                f4 = f42;
                fFloatValue5 = f4;
                f2 = xtlm2;
                f5 = f * f42;
                f6 = f3;
                fWidthLeft = 0.0f;
            } else {
                int i7 = pdfLine2.alignment;
                if (i7 == 0 || i7 == -1) {
                    xtlm2 -= pdfLine.widthLeft();
                }
                f2 = xtlm2;
                fWidthLeft = 0.0f;
            }
            lastStrokeChunk = pdfLine.getLastStrokeChunk();
            xtlm = pdfContentByte.getXTLM();
            ytlm = pdfContentByte.getYTLM();
            pdfFont = pdfFont3;
            f7 = xtlm;
            i = 0;
            f8 = 0.0f;
            z = false;
            f9 = Float.NaN;
            z2 = false;
            for (PdfChunk pdfChunk3 : pdfLine) {
                if (isTagged(pdfDocument.writer) || (iAccessibleElement3 = pdfChunk3.accessibleElement) == null) {
                    z3 = z;
                } else {
                    pdfContentByte6.openMCBlock(iAccessibleElement3);
                    z3 = true;
                }
                BaseColor baseColorColor = pdfChunk3.color();
                size = pdfChunk3.font().size();
                if (pdfChunk3.isImage()) {
                    fHeight2 = pdfChunk3.height();
                    fHeight = pdfChunk3.height();
                    f11 = 0.0f;
                } else {
                    float fontDescriptor = pdfChunk3.font().getFont().getFontDescriptor(1, size);
                    float fontDescriptor2 = pdfChunk3.font().getFont().getFontDescriptor(3, size);
                    fHeight = size;
                    fHeight2 = fontDescriptor;
                    f11 = fontDescriptor2;
                }
                str = Chunk.HSCALE;
                str2 = Chunk.SKEW;
                i2 = iNumberOfSpaces;
                baseColor = baseColorColor;
                str3 = Chunk.WORD_SPACING;
                if (i <= lastStrokeChunk) {
                    if (z6) {
                        fWidth = pdfChunk3.getWidthCorrected(f4, f5);
                    } else {
                        fWidth = pdfChunk3.width();
                    }
                    if (pdfChunk3.isStroked()) {
                        chunk = pdfLine2.getChunk(i + 1);
                        if (pdfChunk3.isSeparator()) {
                            objArr5 = (Object[]) pdfChunk3.getAttribute(Chunk.SEPARATOR);
                            drawInterface2 = (DrawInterface) objArr5[0];
                            if (((Boolean) objArr5[1]).booleanValue()) {
                                f23 = ytlm;
                                f24 = fWidthLeft;
                                drawInterface2.draw(pdfContentByte2, xtlm, ytlm + f11, xtlm + pdfLine.getOriginalWidth(), fHeight2 - f11, f23);
                            } else {
                                f23 = ytlm;
                                f24 = fWidthLeft;
                                drawInterface2.draw(pdfContentByte2, f7, f23 + f11, f7 + f24, fHeight2 - f11, f23);
                            }
                            fWidth = f24;
                        } else {
                            str2 = Chunk.SKEW;
                            f23 = ytlm;
                            lastStrokeChunk = lastStrokeChunk;
                            str = Chunk.HSCALE;
                            f5 = f5;
                            f4 = f4;
                            pdfFont = pdfFont;
                            str3 = Chunk.WORD_SPACING;
                            f24 = fWidthLeft;
                        }
                        if (pdfChunk3.isTab()) {
                            if (pdfChunk3.isAttribute(Chunk.TABSETTINGS)) {
                                tabStop = pdfChunk3.getTabStop();
                                if (tabStop != null) {
                                    fFloatValue4 = tabStop.getPosition() + xtlm;
                                    if (tabStop.getLeader() != null) {
                                        tabStop.getLeader().draw(pdfContentByte2, f7, f23 + f11, fFloatValue4, fHeight2 - f11, f23);
                                    }
                                } else {
                                    fFloatValue4 = f7;
                                }
                            } else {
                                Object[] objArr6 = (Object[]) pdfChunk3.getAttribute(Chunk.TAB);
                                drawInterface = (DrawInterface) objArr6[0];
                                fFloatValue4 = ((Float) objArr6[1]).floatValue() + ((Float) objArr6[3]).floatValue();
                                if (fFloatValue4 > f7) {
                                    drawInterface.draw(pdfContentByte2, f7, f23 + f11, fFloatValue4, fHeight2 - f11, f23);
                                }
                            }
                            f26 = f7;
                            f25 = fFloatValue4;
                        } else {
                            f25 = f7;
                            f26 = f8;
                        }
                        if (pdfChunk3.isAttribute(Chunk.BACKGROUND)) {
                            objArr4 = (Object[]) pdfChunk3.getAttribute(Chunk.BACKGROUND);
                            if (objArr4[0] != null) {
                                inText2 = pdfContentByte2.getInText();
                                if (inText2 && isTagged(pdfDocument.writer)) {
                                    pdfContentByte2.endText();
                                }
                                pdfContentByte2.saveState();
                                if (chunk == null && chunk.isAttribute(Chunk.BACKGROUND)) {
                                    f40 = 0.0f;
                                } else {
                                    f40 = fFloatValue5;
                                }
                                if (chunk == null) {
                                    f40 += f6;
                                }
                                pdfContentByte7.setColorFill((BaseColor) objArr4[0]);
                                float[] fArr2 = (float[]) objArr4[1];
                                pdfContentByte7.rectangle(f25 - fArr2[0], ((f23 + f11) - fArr2[1]) + pdfChunk3.getTextRise(), (fWidth - f40) + fArr2[0] + fArr2[2], (fHeight2 - f11) + fArr2[1] + fArr2[3]);
                                pdfContentByte2.fill();
                                pdfContentByte7.setGrayFill(0.0f);
                                pdfContentByte2.restoreState();
                                if (inText2 && isTagged(pdfDocument.writer)) {
                                    pdfContentByte7.beginText(true);
                                }
                            }
                        }
                        if (pdfChunk3.isAttribute(Chunk.UNDERLINE)) {
                            inText = pdfContentByte2.getInText();
                            if (inText && isTagged(pdfDocument.writer)) {
                                pdfContentByte2.endText();
                            }
                            if (chunk == null && chunk.isAttribute(Chunk.UNDERLINE)) {
                                f39 = 0.0f;
                            } else {
                                f39 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f39 += f6;
                            }
                            objArr3 = (Object[][]) pdfChunk3.getAttribute(Chunk.UNDERLINE);
                            i5 = 0;
                            while (i5 < objArr3.length) {
                                Object[] objArr7 = objArr3[i5];
                                baseColor3 = (BaseColor) objArr7[0];
                                float[] fArr3 = (float[]) objArr7[1];
                                if (baseColor3 == null) {
                                    baseColor4 = baseColor;
                                } else {
                                    baseColor4 = baseColor3;
                                }
                                if (baseColor4 != null) {
                                    pdfContentByte7.setColorStroke(baseColor4);
                                }
                                Object[][] objArr8 = objArr3;
                                pdfContentByte7.setLineWidth(fArr3[0] + (pdfChunk3.font().size() * fArr3[1]));
                                float size2 = fArr3[2] + (pdfChunk3.font().size() * fArr3[3]);
                                i6 = (int) fArr3[4];
                                if (i6 != 0) {
                                    pdfContentByte7.setLineCap(i6);
                                }
                                float f43 = f23 + size2;
                                pdfContentByte7.moveTo(f25, f43);
                                float f44 = f24;
                                pdfContentByte7.lineTo((f25 + fWidth) - f39, f43);
                                pdfContentByte2.stroke();
                                if (baseColor4 != null) {
                                    pdfContentByte2.resetGrayStroke();
                                }
                                if (i6 != 0) {
                                    pdfContentByte7.setLineCap(0);
                                }
                                i5++;
                                f24 = f44;
                                objArr3 = objArr8;
                            }
                            f13 = f24;
                            pdfContentByte7.setLineWidth(1.0f);
                            if (inText && isTagged(pdfDocument.writer)) {
                                pdfContentByte7.beginText(true);
                            }
                        } else {
                            f13 = f24;
                        }
                        if (pdfChunk3.isAttribute(Chunk.ACTION)) {
                            if (chunk == null && chunk.isAttribute(Chunk.ACTION)) {
                                f38 = 0.0f;
                            } else {
                                f38 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f38 += f6;
                            }
                            if (pdfChunk3.isImage()) {
                                f27 = f25;
                                pdfAnnotationCreateAnnotation = pdfDocument.writer.createAnnotation(f25, f23 + pdfChunk3.getImageOffsetY(), (f25 + fWidth) - f38, pdfChunk3.getImageOffsetY() + f23 + pdfChunk3.getImageHeight(), (PdfAction) pdfChunk3.getAttribute(Chunk.ACTION), null);
                            } else {
                                f27 = f25;
                                pdfAnnotationCreateAnnotation = pdfDocument.writer.createAnnotation(f27, f23 + f11 + pdfChunk3.getTextRise(), (f27 + fWidth) - f38, pdfChunk3.getTextRise() + f23 + fHeight2, (PdfAction) pdfChunk3.getAttribute(Chunk.ACTION), null);
                            }
                            pdfContentByte6.addAnnotation(pdfAnnotationCreateAnnotation, true);
                            if (isTagged(pdfDocument.writer) && (iAccessibleElement2 = pdfChunk3.accessibleElement) != null && (structElement = pdfDocument.getStructElement(iAccessibleElement2.getId())) != null) {
                                int structParentIndex = pdfDocument.getStructParentIndex(pdfAnnotationCreateAnnotation);
                                pdfAnnotationCreateAnnotation.put(PdfName.STRUCTPARENT, new PdfNumber(structParentIndex));
                                structElement.setAnnotation(pdfAnnotationCreateAnnotation, pdfDocument.writer.getCurrentPage());
                                pdfDocument.writer.getStructureTreeRoot().setAnnotationMark(structParentIndex, structElement.getReference());
                            }
                        } else {
                            f27 = f25;
                        }
                        if (pdfChunk3.isAttribute(Chunk.REMOTEGOTO)) {
                            if (chunk == null && chunk.isAttribute(Chunk.REMOTEGOTO)) {
                                f37 = 0.0f;
                            } else {
                                f37 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f37 += f6;
                            }
                            Object[] objArr9 = (Object[]) pdfChunk3.getAttribute(Chunk.REMOTEGOTO);
                            str9 = (String) objArr9[0];
                            obj = objArr9[1];
                            if (obj instanceof String) {
                                remoteGoto(str9, (String) obj, f27, pdfChunk3.getTextRise() + f23 + f11, (f27 + fWidth) - f37, f23 + fHeight2 + pdfChunk3.getTextRise());
                            } else {
                                remoteGoto(str9, ((Integer) obj).intValue(), f27, pdfChunk3.getTextRise() + f23 + f11, (f27 + fWidth) - f37, f23 + fHeight2 + pdfChunk3.getTextRise());
                            }
                        }
                        if (pdfChunk3.isAttribute(Chunk.LOCALGOTO)) {
                            if (chunk == null && chunk.isAttribute(Chunk.LOCALGOTO)) {
                                f36 = 0.0f;
                            } else {
                                f36 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f36 += f6;
                            }
                            localGoto((String) pdfChunk3.getAttribute(Chunk.LOCALGOTO), f27, f23, (f27 + fWidth) - f36, f23 + fHeight);
                        }
                        if (pdfChunk3.isAttribute(Chunk.LOCALDESTINATION)) {
                            pdfDocument.localDestination((String) pdfChunk3.getAttribute(Chunk.LOCALDESTINATION), new PdfDestination(0, f27, f23 + fHeight, 0.0f));
                        }
                        if (pdfChunk3.isAttribute(Chunk.GENERICTAG)) {
                            if (chunk == null && chunk.isAttribute(Chunk.GENERICTAG)) {
                                f35 = 0.0f;
                            } else {
                                f35 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f35 += f6;
                            }
                            f28 = f23;
                            rectangle = new Rectangle(f27, f28, (f27 + fWidth) - f35, f23 + fHeight);
                            pageEvent = pdfDocument.writer.getPageEvent();
                            if (pageEvent != null) {
                                pageEvent.onGenericTag(pdfDocument.writer, pdfDocument, rectangle, (String) pdfChunk3.getAttribute(Chunk.GENERICTAG));
                            }
                        } else {
                            f28 = f23;
                        }
                        if (pdfChunk3.isAttribute(Chunk.PDFANNOTATION)) {
                            if (chunk == null && chunk.isAttribute(Chunk.PDFANNOTATION)) {
                                f34 = 0.0f;
                            } else {
                                f34 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f34 += f6;
                            }
                            PdfAnnotation pdfAnnotationShallowDuplicate = PdfFormField.shallowDuplicate((PdfAnnotation) pdfChunk3.getAttribute(Chunk.PDFANNOTATION));
                            pdfAnnotationShallowDuplicate.put(PdfName.RECT, new PdfRectangle(f27, f28 + f11, (f27 + fWidth) - f34, f28 + fHeight2));
                            pdfContentByte6.addAnnotation(pdfAnnotationShallowDuplicate, true);
                        }
                        fArr = (float[]) pdfChunk3.getAttribute(str2);
                        str4 = str;
                        f29 = (Float) pdfChunk3.getAttribute(str4);
                        if (fArr == null || f29 != null) {
                            if (fArr != null) {
                                f30 = fArr[0];
                                f31 = fArr[1];
                            } else {
                                f30 = 0.0f;
                                f31 = 0.0f;
                            }
                            if (f29 != null) {
                                fFloatValue3 = f29.floatValue();
                            } else {
                                fFloatValue3 = 1.0f;
                            }
                            f12 = f28;
                            pdfContentByte.setTextMatrix(fFloatValue3, f30, f31, 1.0f, f27, f12);
                            f32 = fFloatValue3;
                        } else {
                            f12 = f28;
                            f32 = 1.0f;
                        }
                        str7 = str3;
                        if (z6) {
                            str8 = Chunk.CHAR_SPACING;
                        } else {
                            if (pdfChunk3.isAttribute(str7)) {
                                pdfContentByte6.setWordSpacing(((Float) pdfChunk3.getAttribute(str7)).floatValue());
                            }
                            str8 = Chunk.CHAR_SPACING;
                            if (pdfChunk3.isAttribute(str8)) {
                                pdfContentByte6.setCharacterSpacing(((Float) pdfChunk3.getAttribute(str8)).floatValue());
                            }
                        }
                        if (pdfChunk3.isImage()) {
                            Image image = pdfChunk3.getImage();
                            fWidth = pdfChunk3.getImageWidth();
                            float[] fArrMatrix = image.matrix(pdfChunk3.getImageScalePercentage());
                            fArrMatrix[4] = (f27 + pdfChunk3.getImageOffsetX()) - fArrMatrix[4];
                            fArrMatrix[5] = (pdfChunk3.getImageOffsetY() + f12) - fArrMatrix[5];
                            if (pdfContentByte2.getInText() || (image instanceof ImgTemplate)) {
                                z4 = false;
                            } else {
                                pdfContentByte2.endText();
                                z4 = true;
                            }
                            z5 = z4;
                            String str10 = str8;
                            str5 = str7;
                            f14 = 0.0f;
                            pdfChunk = pdfChunk3;
                            str6 = str10;
                            i3 = 1;
                            pdfContentByte5 = pdfContentByte2;
                            f33 = f27;
                            c = 0;
                            pdfContentByte2.addImage(image, fArrMatrix[0], fArrMatrix[1], fArrMatrix[2], fArrMatrix[3], fArrMatrix[4], fArrMatrix[5], false, z3);
                            if (z5) {
                                pdfContentByte5.beginText(true);
                            }
                            pdfContentByte4 = pdfContentByte;
                            pdfContentByte4.moveText(((f33 + fFloatValue5) + pdfChunk.getImageWidth()) - pdfContentByte.getXTLM(), 0.0f);
                        } else {
                            pdfContentByte5 = pdfContentByte2;
                            str5 = str7;
                            str6 = str8;
                            pdfContentByte4 = pdfContentByte6;
                            f33 = f27;
                            f14 = 0.0f;
                            i3 = 1;
                            c = 0;
                            pdfChunk = pdfChunk3;
                        }
                        f16 = f32;
                        f8 = f26;
                        f7 = f33;
                    } else {
                        i = i;
                        str2 = Chunk.SKEW;
                        f12 = ytlm;
                        lastStrokeChunk = lastStrokeChunk;
                        str4 = Chunk.HSCALE;
                        f5 = f5;
                        f4 = f4;
                        pdfContentByte4 = pdfContentByte6;
                        str5 = Chunk.WORD_SPACING;
                        pdfContentByte5 = pdfContentByte7;
                        pdfFont = pdfFont;
                        f13 = fWidthLeft;
                        i2 = i2;
                        baseColor = baseColor;
                        str6 = Chunk.CHAR_SPACING;
                        f14 = 0.0f;
                        i3 = 1;
                        c = 0;
                        pdfChunk = pdfChunk3;
                        f16 = 1.0f;
                    }
                    i++;
                    f15 = f7 + fWidth;
                } else {
                    str2 = Chunk.SKEW;
                    f12 = ytlm;
                    lastStrokeChunk = lastStrokeChunk;
                    str4 = Chunk.HSCALE;
                    f5 = f5;
                    f4 = f4;
                    pdfContentByte4 = pdfContentByte6;
                    str5 = Chunk.WORD_SPACING;
                    pdfContentByte5 = pdfContentByte7;
                    pdfFont = pdfFont;
                    f13 = fWidthLeft;
                    i2 = i2;
                    baseColor = baseColor;
                    str6 = Chunk.CHAR_SPACING;
                    f14 = 0.0f;
                    i3 = 1;
                    c = 0;
                    pdfChunk = pdfChunk3;
                    f15 = f7;
                    f16 = 1.0f;
                }
                if (pdfChunk.isImage()) {
                    pdfFont2 = pdfFont;
                } else {
                    pdfFont2 = pdfFont;
                    if (pdfChunk.font().compareTo(pdfFont2) != 0) {
                        pdfFontFont = pdfChunk.font();
                        pdfContentByte4.setFontAndSize(pdfFontFont.getFont(), pdfFontFont.size());
                    }
                    pdfChunk2 = pdfChunk;
                    objArr2 = (Object[]) pdfChunk2.getAttribute(Chunk.TEXTRENDERMODE);
                    f17 = (Float) pdfChunk2.getAttribute(Chunk.SUBSUPSCRIPT);
                    if (objArr2 != null) {
                        iIntValue = ((Integer) objArr2[c]).intValue() & 3;
                        if (iIntValue != 0) {
                            pdfContentByte4.setTextRenderingMode(iIntValue);
                        }
                        if (iIntValue != i3 || iIntValue == 2) {
                            fFloatValue = ((Float) objArr2[i3]).floatValue();
                            if (fFloatValue != 1.0f) {
                                pdfContentByte4.setLineWidth(fFloatValue);
                            }
                            baseColor2 = (BaseColor) objArr2[2];
                            if (baseColor2 == null) {
                                baseColor2 = baseColor;
                            }
                            if (baseColor2 != null) {
                                pdfContentByte4.setColorStroke(baseColor2);
                            }
                        } else {
                            baseColor2 = null;
                            fFloatValue = 1.0f;
                        }
                    } else {
                        baseColor2 = null;
                        fFloatValue = 1.0f;
                        iIntValue = 0;
                    }
                    if (f17 != null) {
                        fFloatValue2 = f17.floatValue();
                    } else {
                        fFloatValue2 = 0.0f;
                    }
                    if (baseColor != 0) {
                        pdfContentByte4.setColorFill(baseColor);
                    }
                    if (fFloatValue2 != f14) {
                        pdfContentByte4.setTextRise(fFloatValue2);
                    }
                    if (pdfChunk2.isImage()) {
                        i4 = i;
                        f20 = f5;
                        f21 = f4;
                        f19 = f13;
                        z2 = true;
                    } else {
                        if (pdfChunk2.isHorizontalSeparator()) {
                            PdfTextArray pdfTextArray = new PdfTextArray();
                            f18 = f13;
                            pdfTextArray.add((((-f18) * 1000.0f) / pdfChunk2.font.size()) / f16);
                            pdfContentByte4.showText(pdfTextArray);
                        } else {
                            f18 = f13;
                            if (!pdfChunk2.isTab() && f8 != f15) {
                                PdfTextArray pdfTextArray2 = new PdfTextArray();
                                pdfTextArray2.add((((f8 - f15) * 1000.0f) / pdfChunk2.font.size()) / f16);
                                pdfContentByte4.showText(pdfTextArray2);
                            } else if (z6 || i2 <= 0 || !pdfChunk2.isSpecialEncoding()) {
                                i4 = i;
                                f19 = f18;
                                f20 = f5;
                                f21 = f4;
                                if (z6 && f16 != f9) {
                                    pdfContentByte4.setWordSpacing(f20 / f16);
                                    pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                    f9 = f16;
                                }
                                pdfContentByte4.showText(pdfChunk2.toString());
                            } else {
                                f20 = f5;
                                if (f16 != f9) {
                                    pdfContentByte4.setWordSpacing(f20 / f16);
                                    f21 = f4;
                                    pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                    f9 = f16;
                                } else {
                                    f21 = f4;
                                }
                                String string2 = pdfChunk2.toString();
                                i4 = i;
                                int iIndexOf = string2.indexOf(32);
                                if (iIndexOf < 0) {
                                    pdfContentByte4.showText(string2);
                                    f19 = f18;
                                } else {
                                    f19 = f18;
                                    float size3 = (((-f20) * 1000.0f) / pdfChunk2.font.size()) / f16;
                                    PdfTextArray pdfTextArray3 = new PdfTextArray(string2.substring(0, iIndexOf));
                                    while (true) {
                                        int iIndexOf2 = string2.indexOf(32, iIndexOf + 1);
                                        if (iIndexOf2 < 0) {
                                            break;
                                        }
                                        pdfTextArray3.add(size3);
                                        pdfTextArray3.add(string2.substring(iIndexOf, iIndexOf2));
                                        iIndexOf = iIndexOf2;
                                    }
                                    pdfTextArray3.add(size3);
                                    pdfTextArray3.add(string2.substring(iIndexOf));
                                    pdfContentByte4.showText(pdfTextArray3);
                                }
                            }
                        }
                        i4 = i;
                        f19 = f18;
                        f20 = f5;
                        f21 = f4;
                    }
                    if (fFloatValue2 != f14) {
                        pdfContentByte4.setTextRise(0.0f);
                    }
                    if (baseColor != 0) {
                        pdfContentByte.resetRGBColorFill();
                    }
                    if (iIntValue != 0) {
                        pdfContentByte4.setTextRenderingMode(0);
                    }
                    if (baseColor2 != null) {
                        pdfContentByte.resetRGBColorStroke();
                    }
                    if (fFloatValue != 1.0f) {
                        pdfContentByte4.setLineWidth(1.0f);
                    }
                    if (!pdfChunk2.isAttribute(str2) || pdfChunk2.isAttribute(str4)) {
                        f22 = f12;
                        pdfContentByte4.setTextMatrix(f15, f22);
                        z2 = true;
                    } else {
                        f22 = f12;
                    }
                    if (!z6) {
                        if (pdfChunk2.isAttribute(str6)) {
                            pdfContentByte4.setCharacterSpacing(f21);
                        }
                        if (pdfChunk2.isAttribute(str5)) {
                            pdfContentByte4.setWordSpacing(f20);
                        }
                    }
                    if (!isTagged(this.writer) && (iAccessibleElement = pdfChunk2.accessibleElement) != null) {
                        pdfContentByte4.closeMCBlock(iAccessibleElement);
                    }
                    pdfLine2 = pdfLine;
                    i = i4;
                    pdfContentByte6 = pdfContentByte4;
                    f4 = f21;
                    ytlm = f22;
                    f7 = f15;
                    pdfContentByte7 = pdfContentByte5;
                    pdfFont = pdfFontFont;
                    fWidthLeft = f19;
                    z = z3;
                    lastStrokeChunk = lastStrokeChunk;
                    iNumberOfSpaces = i2;
                    pdfDocument = this;
                    f5 = f20;
                }
                pdfFontFont = pdfFont2;
                pdfChunk2 = pdfChunk;
                objArr2 = (Object[]) pdfChunk2.getAttribute(Chunk.TEXTRENDERMODE);
                f17 = (Float) pdfChunk2.getAttribute(Chunk.SUBSUPSCRIPT);
                if (objArr2 != null) {
                    iIntValue = ((Integer) objArr2[c]).intValue() & 3;
                    if (iIntValue != 0) {
                        pdfContentByte4.setTextRenderingMode(iIntValue);
                    }
                    if (iIntValue != i3) {
                        fFloatValue = ((Float) objArr2[i3]).floatValue();
                        if (fFloatValue != 1.0f) {
                            pdfContentByte4.setLineWidth(fFloatValue);
                        }
                        baseColor2 = (BaseColor) objArr2[2];
                        if (baseColor2 == null) {
                            baseColor2 = baseColor;
                        }
                        if (baseColor2 != null) {
                            pdfContentByte4.setColorStroke(baseColor2);
                        }
                    } else {
                        fFloatValue = ((Float) objArr2[i3]).floatValue();
                        if (fFloatValue != 1.0f) {
                            pdfContentByte4.setLineWidth(fFloatValue);
                        }
                        baseColor2 = (BaseColor) objArr2[2];
                        if (baseColor2 == null) {
                            baseColor2 = baseColor;
                        }
                        if (baseColor2 != null) {
                            pdfContentByte4.setColorStroke(baseColor2);
                        }
                    }
                } else {
                    baseColor2 = null;
                    fFloatValue = 1.0f;
                    iIntValue = 0;
                }
                if (f17 != null) {
                    fFloatValue2 = f17.floatValue();
                } else {
                    fFloatValue2 = 0.0f;
                }
                if (baseColor != 0) {
                    pdfContentByte4.setColorFill(baseColor);
                }
                if (fFloatValue2 != f14) {
                    pdfContentByte4.setTextRise(fFloatValue2);
                }
                if (pdfChunk2.isImage()) {
                    i4 = i;
                    f20 = f5;
                    f21 = f4;
                    f19 = f13;
                    z2 = true;
                } else {
                    if (pdfChunk2.isHorizontalSeparator()) {
                        PdfTextArray pdfTextArray4 = new PdfTextArray();
                        f18 = f13;
                        pdfTextArray4.add((((-f18) * 1000.0f) / pdfChunk2.font.size()) / f16);
                        pdfContentByte4.showText(pdfTextArray4);
                    } else {
                        f18 = f13;
                        if (!pdfChunk2.isTab()) {
                        }
                        if (z6) {
                            i4 = i;
                            f19 = f18;
                            f20 = f5;
                            f21 = f4;
                            if (z6) {
                                pdfContentByte4.setWordSpacing(f20 / f16);
                                pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                f9 = f16;
                            }
                            pdfContentByte4.showText(pdfChunk2.toString());
                        } else {
                            i4 = i;
                            f19 = f18;
                            f20 = f5;
                            f21 = f4;
                            if (z6) {
                                pdfContentByte4.setWordSpacing(f20 / f16);
                                pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                f9 = f16;
                            }
                            pdfContentByte4.showText(pdfChunk2.toString());
                        }
                    }
                    i4 = i;
                    f19 = f18;
                    f20 = f5;
                    f21 = f4;
                }
                if (fFloatValue2 != f14) {
                    pdfContentByte4.setTextRise(0.0f);
                }
                if (baseColor != 0) {
                    pdfContentByte.resetRGBColorFill();
                }
                if (iIntValue != 0) {
                    pdfContentByte4.setTextRenderingMode(0);
                }
                if (baseColor2 != null) {
                    pdfContentByte.resetRGBColorStroke();
                }
                if (fFloatValue != 1.0f) {
                    pdfContentByte4.setLineWidth(1.0f);
                }
                if (pdfChunk2.isAttribute(str2)) {
                    f22 = f12;
                    pdfContentByte4.setTextMatrix(f15, f22);
                    z2 = true;
                } else {
                    f22 = f12;
                    pdfContentByte4.setTextMatrix(f15, f22);
                    z2 = true;
                }
                if (!z6) {
                    if (pdfChunk2.isAttribute(str6)) {
                        pdfContentByte4.setCharacterSpacing(f21);
                    }
                    if (pdfChunk2.isAttribute(str5)) {
                        pdfContentByte4.setWordSpacing(f20);
                    }
                }
                if (!isTagged(this.writer)) {
                }
                pdfLine2 = pdfLine;
                i = i4;
                pdfContentByte6 = pdfContentByte4;
                f4 = f21;
                ytlm = f22;
                f7 = f15;
                pdfContentByte7 = pdfContentByte5;
                pdfFont = pdfFontFont;
                fWidthLeft = f19;
                z = z3;
                lastStrokeChunk = lastStrokeChunk;
                iNumberOfSpaces = i2;
                pdfDocument = this;
                f5 = f20;
            }
            PdfFont pdfFont4 = pdfFont;
            pdfContentByte3 = pdfContentByte6;
            if (z6) {
                pdfContentByte3.setWordSpacing(0.0f);
                pdfContentByte3.setCharacterSpacing(0.0f);
                if (pdfLine.isNewlineSplit()) {
                    f10 = 0.0f;
                } else {
                    f10 = fFloatValue5;
                }
            } else {
                f10 = fFloatValue5;
            }
            if (z2) {
                pdfContentByte3.moveText(xtlm - pdfContentByte.getXTLM(), 0.0f);
            }
            objArr[0] = pdfFont4;
            objArr[1] = new Float(f10);
            return f2;
        }
        f2 = xtlm2;
        fWidthLeft = pdfLine.widthLeft() / separatorCount;
        f5 = 0.0f;
        f4 = 0.0f;
        f6 = 0.0f;
        lastStrokeChunk = pdfLine.getLastStrokeChunk();
        xtlm = pdfContentByte.getXTLM();
        ytlm = pdfContentByte.getYTLM();
        pdfFont = pdfFont3;
        f7 = xtlm;
        i = 0;
        f8 = 0.0f;
        z = false;
        f9 = Float.NaN;
        z2 = false;
        while (r31.hasNext()) {
            if (isTagged(pdfDocument.writer)) {
                z3 = z;
            } else {
                z3 = z;
            }
            BaseColor baseColorColor2 = pdfChunk3.color();
            size = pdfChunk3.font().size();
            if (pdfChunk3.isImage()) {
                fHeight2 = pdfChunk3.height();
                fHeight = pdfChunk3.height();
                f11 = 0.0f;
            } else {
                float fontDescriptor3 = pdfChunk3.font().getFont().getFontDescriptor(1, size);
                float fontDescriptor4 = pdfChunk3.font().getFont().getFontDescriptor(3, size);
                fHeight = size;
                fHeight2 = fontDescriptor3;
                f11 = fontDescriptor4;
            }
            str = Chunk.HSCALE;
            str2 = Chunk.SKEW;
            i2 = iNumberOfSpaces;
            baseColor = baseColorColor2;
            str3 = Chunk.WORD_SPACING;
            if (i <= lastStrokeChunk) {
                if (z6) {
                    fWidth = pdfChunk3.getWidthCorrected(f4, f5);
                } else {
                    fWidth = pdfChunk3.width();
                }
                if (pdfChunk3.isStroked()) {
                    chunk = pdfLine2.getChunk(i + 1);
                    if (pdfChunk3.isSeparator()) {
                        objArr5 = (Object[]) pdfChunk3.getAttribute(Chunk.SEPARATOR);
                        drawInterface2 = (DrawInterface) objArr5[0];
                        if (((Boolean) objArr5[1]).booleanValue()) {
                            f23 = ytlm;
                            f24 = fWidthLeft;
                            drawInterface2.draw(pdfContentByte2, xtlm, ytlm + f11, xtlm + pdfLine.getOriginalWidth(), fHeight2 - f11, f23);
                        } else {
                            f23 = ytlm;
                            f24 = fWidthLeft;
                            drawInterface2.draw(pdfContentByte2, f7, f23 + f11, f7 + f24, fHeight2 - f11, f23);
                        }
                        fWidth = f24;
                    } else {
                        str2 = Chunk.SKEW;
                        f23 = ytlm;
                        lastStrokeChunk = lastStrokeChunk;
                        str = Chunk.HSCALE;
                        f5 = f5;
                        f4 = f4;
                        pdfFont = pdfFont;
                        str3 = Chunk.WORD_SPACING;
                        f24 = fWidthLeft;
                    }
                    if (pdfChunk3.isTab()) {
                        if (pdfChunk3.isAttribute(Chunk.TABSETTINGS)) {
                            tabStop = pdfChunk3.getTabStop();
                            if (tabStop != null) {
                                fFloatValue4 = tabStop.getPosition() + xtlm;
                                if (tabStop.getLeader() != null) {
                                    tabStop.getLeader().draw(pdfContentByte2, f7, f23 + f11, fFloatValue4, fHeight2 - f11, f23);
                                }
                            } else {
                                fFloatValue4 = f7;
                            }
                        } else {
                            Object[] objArr10 = (Object[]) pdfChunk3.getAttribute(Chunk.TAB);
                            drawInterface = (DrawInterface) objArr10[0];
                            fFloatValue4 = ((Float) objArr10[1]).floatValue() + ((Float) objArr10[3]).floatValue();
                            if (fFloatValue4 > f7) {
                                drawInterface.draw(pdfContentByte2, f7, f23 + f11, fFloatValue4, fHeight2 - f11, f23);
                            }
                        }
                        f26 = f7;
                        f25 = fFloatValue4;
                    } else {
                        f25 = f7;
                        f26 = f8;
                    }
                    if (pdfChunk3.isAttribute(Chunk.BACKGROUND)) {
                        objArr4 = (Object[]) pdfChunk3.getAttribute(Chunk.BACKGROUND);
                        if (objArr4[0] != null) {
                            inText2 = pdfContentByte2.getInText();
                            if (inText2) {
                                pdfContentByte2.endText();
                            }
                            pdfContentByte2.saveState();
                            if (chunk == null) {
                                f40 = fFloatValue5;
                            } else {
                                f40 = fFloatValue5;
                            }
                            if (chunk == null) {
                                f40 += f6;
                            }
                            pdfContentByte7.setColorFill((BaseColor) objArr4[0]);
                            float[] fArr4 = (float[]) objArr4[1];
                            pdfContentByte7.rectangle(f25 - fArr4[0], ((f23 + f11) - fArr4[1]) + pdfChunk3.getTextRise(), (fWidth - f40) + fArr4[0] + fArr4[2], (fHeight2 - f11) + fArr4[1] + fArr4[3]);
                            pdfContentByte2.fill();
                            pdfContentByte7.setGrayFill(0.0f);
                            pdfContentByte2.restoreState();
                            if (inText2) {
                                pdfContentByte7.beginText(true);
                            }
                        }
                    }
                    if (pdfChunk3.isAttribute(Chunk.UNDERLINE)) {
                        inText = pdfContentByte2.getInText();
                        if (inText) {
                            pdfContentByte2.endText();
                        }
                        if (chunk == null) {
                            f39 = fFloatValue5;
                        } else {
                            f39 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f39 += f6;
                        }
                        objArr3 = (Object[][]) pdfChunk3.getAttribute(Chunk.UNDERLINE);
                        i5 = 0;
                        while (i5 < objArr3.length) {
                            Object[] objArr11 = objArr3[i5];
                            baseColor3 = (BaseColor) objArr11[0];
                            float[] fArr5 = (float[]) objArr11[1];
                            if (baseColor3 == null) {
                                baseColor4 = baseColor;
                            } else {
                                baseColor4 = baseColor3;
                            }
                            if (baseColor4 != null) {
                                pdfContentByte7.setColorStroke(baseColor4);
                            }
                            Object[][] objArr12 = objArr3;
                            pdfContentByte7.setLineWidth(fArr5[0] + (pdfChunk3.font().size() * fArr5[1]));
                            float size4 = fArr5[2] + (pdfChunk3.font().size() * fArr5[3]);
                            i6 = (int) fArr5[4];
                            if (i6 != 0) {
                                pdfContentByte7.setLineCap(i6);
                            }
                            float f45 = f23 + size4;
                            pdfContentByte7.moveTo(f25, f45);
                            float f46 = f24;
                            pdfContentByte7.lineTo((f25 + fWidth) - f39, f45);
                            pdfContentByte2.stroke();
                            if (baseColor4 != null) {
                                pdfContentByte2.resetGrayStroke();
                            }
                            if (i6 != 0) {
                                pdfContentByte7.setLineCap(0);
                            }
                            i5++;
                            f24 = f46;
                            objArr3 = objArr12;
                        }
                        f13 = f24;
                        pdfContentByte7.setLineWidth(1.0f);
                        if (inText) {
                            pdfContentByte7.beginText(true);
                        }
                    } else {
                        f13 = f24;
                    }
                    if (pdfChunk3.isAttribute(Chunk.ACTION)) {
                        if (chunk == null) {
                            f38 = fFloatValue5;
                        } else {
                            f38 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f38 += f6;
                        }
                        if (pdfChunk3.isImage()) {
                            f27 = f25;
                            pdfAnnotationCreateAnnotation = pdfDocument.writer.createAnnotation(f25, f23 + pdfChunk3.getImageOffsetY(), (f25 + fWidth) - f38, pdfChunk3.getImageOffsetY() + f23 + pdfChunk3.getImageHeight(), (PdfAction) pdfChunk3.getAttribute(Chunk.ACTION), null);
                        } else {
                            f27 = f25;
                            pdfAnnotationCreateAnnotation = pdfDocument.writer.createAnnotation(f27, f23 + f11 + pdfChunk3.getTextRise(), (f27 + fWidth) - f38, pdfChunk3.getTextRise() + f23 + fHeight2, (PdfAction) pdfChunk3.getAttribute(Chunk.ACTION), null);
                        }
                        pdfContentByte6.addAnnotation(pdfAnnotationCreateAnnotation, true);
                        if (isTagged(pdfDocument.writer)) {
                            int structParentIndex2 = pdfDocument.getStructParentIndex(pdfAnnotationCreateAnnotation);
                            pdfAnnotationCreateAnnotation.put(PdfName.STRUCTPARENT, new PdfNumber(structParentIndex2));
                            structElement.setAnnotation(pdfAnnotationCreateAnnotation, pdfDocument.writer.getCurrentPage());
                            pdfDocument.writer.getStructureTreeRoot().setAnnotationMark(structParentIndex2, structElement.getReference());
                        }
                    } else {
                        f27 = f25;
                    }
                    if (pdfChunk3.isAttribute(Chunk.REMOTEGOTO)) {
                        if (chunk == null) {
                            f37 = fFloatValue5;
                        } else {
                            f37 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f37 += f6;
                        }
                        Object[] objArr13 = (Object[]) pdfChunk3.getAttribute(Chunk.REMOTEGOTO);
                        str9 = (String) objArr13[0];
                        obj = objArr13[1];
                        if (obj instanceof String) {
                            remoteGoto(str9, (String) obj, f27, pdfChunk3.getTextRise() + f23 + f11, (f27 + fWidth) - f37, f23 + fHeight2 + pdfChunk3.getTextRise());
                        } else {
                            remoteGoto(str9, ((Integer) obj).intValue(), f27, pdfChunk3.getTextRise() + f23 + f11, (f27 + fWidth) - f37, f23 + fHeight2 + pdfChunk3.getTextRise());
                        }
                    }
                    if (pdfChunk3.isAttribute(Chunk.LOCALGOTO)) {
                        if (chunk == null) {
                            f36 = fFloatValue5;
                        } else {
                            f36 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f36 += f6;
                        }
                        localGoto((String) pdfChunk3.getAttribute(Chunk.LOCALGOTO), f27, f23, (f27 + fWidth) - f36, f23 + fHeight);
                    }
                    if (pdfChunk3.isAttribute(Chunk.LOCALDESTINATION)) {
                        pdfDocument.localDestination((String) pdfChunk3.getAttribute(Chunk.LOCALDESTINATION), new PdfDestination(0, f27, f23 + fHeight, 0.0f));
                    }
                    if (pdfChunk3.isAttribute(Chunk.GENERICTAG)) {
                        if (chunk == null) {
                            f35 = fFloatValue5;
                        } else {
                            f35 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f35 += f6;
                        }
                        f28 = f23;
                        rectangle = new Rectangle(f27, f28, (f27 + fWidth) - f35, f23 + fHeight);
                        pageEvent = pdfDocument.writer.getPageEvent();
                        if (pageEvent != null) {
                            pageEvent.onGenericTag(pdfDocument.writer, pdfDocument, rectangle, (String) pdfChunk3.getAttribute(Chunk.GENERICTAG));
                        }
                    } else {
                        f28 = f23;
                    }
                    if (pdfChunk3.isAttribute(Chunk.PDFANNOTATION)) {
                        if (chunk == null) {
                            f34 = fFloatValue5;
                        } else {
                            f34 = fFloatValue5;
                        }
                        if (chunk == null) {
                            f34 += f6;
                        }
                        PdfAnnotation pdfAnnotationShallowDuplicate2 = PdfFormField.shallowDuplicate((PdfAnnotation) pdfChunk3.getAttribute(Chunk.PDFANNOTATION));
                        pdfAnnotationShallowDuplicate2.put(PdfName.RECT, new PdfRectangle(f27, f28 + f11, (f27 + fWidth) - f34, f28 + fHeight2));
                        pdfContentByte6.addAnnotation(pdfAnnotationShallowDuplicate2, true);
                    }
                    fArr = (float[]) pdfChunk3.getAttribute(str2);
                    str4 = str;
                    f29 = (Float) pdfChunk3.getAttribute(str4);
                    if (fArr == null) {
                        if (fArr != null) {
                            f30 = fArr[0];
                            f31 = fArr[1];
                        } else {
                            f30 = 0.0f;
                            f31 = 0.0f;
                        }
                        if (f29 != null) {
                            fFloatValue3 = f29.floatValue();
                        } else {
                            fFloatValue3 = 1.0f;
                        }
                        f12 = f28;
                        pdfContentByte.setTextMatrix(fFloatValue3, f30, f31, 1.0f, f27, f12);
                        f32 = fFloatValue3;
                    } else {
                        if (fArr != null) {
                            f30 = fArr[0];
                            f31 = fArr[1];
                        } else {
                            f30 = 0.0f;
                            f31 = 0.0f;
                        }
                        if (f29 != null) {
                            fFloatValue3 = f29.floatValue();
                        } else {
                            fFloatValue3 = 1.0f;
                        }
                        f12 = f28;
                        pdfContentByte.setTextMatrix(fFloatValue3, f30, f31, 1.0f, f27, f12);
                        f32 = fFloatValue3;
                    }
                    str7 = str3;
                    if (z6) {
                        if (pdfChunk3.isAttribute(str7)) {
                            pdfContentByte6.setWordSpacing(((Float) pdfChunk3.getAttribute(str7)).floatValue());
                        }
                        str8 = Chunk.CHAR_SPACING;
                        if (pdfChunk3.isAttribute(str8)) {
                            pdfContentByte6.setCharacterSpacing(((Float) pdfChunk3.getAttribute(str8)).floatValue());
                        }
                    } else {
                        str8 = Chunk.CHAR_SPACING;
                    }
                    if (pdfChunk3.isImage()) {
                        Image image2 = pdfChunk3.getImage();
                        fWidth = pdfChunk3.getImageWidth();
                        float[] fArrMatrix2 = image2.matrix(pdfChunk3.getImageScalePercentage());
                        fArrMatrix2[4] = (f27 + pdfChunk3.getImageOffsetX()) - fArrMatrix2[4];
                        fArrMatrix2[5] = (pdfChunk3.getImageOffsetY() + f12) - fArrMatrix2[5];
                        if (pdfContentByte2.getInText()) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        z5 = z4;
                        String str11 = str8;
                        str5 = str7;
                        f14 = 0.0f;
                        pdfChunk = pdfChunk3;
                        str6 = str11;
                        i3 = 1;
                        pdfContentByte5 = pdfContentByte2;
                        f33 = f27;
                        c = 0;
                        pdfContentByte2.addImage(image2, fArrMatrix2[0], fArrMatrix2[1], fArrMatrix2[2], fArrMatrix2[3], fArrMatrix2[4], fArrMatrix2[5], false, z3);
                        if (z5) {
                            pdfContentByte5.beginText(true);
                        }
                        pdfContentByte4 = pdfContentByte;
                        pdfContentByte4.moveText(((f33 + fFloatValue5) + pdfChunk.getImageWidth()) - pdfContentByte.getXTLM(), 0.0f);
                    } else {
                        pdfContentByte5 = pdfContentByte2;
                        str5 = str7;
                        str6 = str8;
                        pdfContentByte4 = pdfContentByte6;
                        f33 = f27;
                        f14 = 0.0f;
                        i3 = 1;
                        c = 0;
                        pdfChunk = pdfChunk3;
                    }
                    f16 = f32;
                    f8 = f26;
                    f7 = f33;
                } else {
                    i = i;
                    str2 = Chunk.SKEW;
                    f12 = ytlm;
                    lastStrokeChunk = lastStrokeChunk;
                    str4 = Chunk.HSCALE;
                    f5 = f5;
                    f4 = f4;
                    pdfContentByte4 = pdfContentByte6;
                    str5 = Chunk.WORD_SPACING;
                    pdfContentByte5 = pdfContentByte7;
                    pdfFont = pdfFont;
                    f13 = fWidthLeft;
                    i2 = i2;
                    baseColor = baseColor;
                    str6 = Chunk.CHAR_SPACING;
                    f14 = 0.0f;
                    i3 = 1;
                    c = 0;
                    pdfChunk = pdfChunk3;
                    f16 = 1.0f;
                }
                i++;
                f15 = f7 + fWidth;
            } else {
                str2 = Chunk.SKEW;
                f12 = ytlm;
                lastStrokeChunk = lastStrokeChunk;
                str4 = Chunk.HSCALE;
                f5 = f5;
                f4 = f4;
                pdfContentByte4 = pdfContentByte6;
                str5 = Chunk.WORD_SPACING;
                pdfContentByte5 = pdfContentByte7;
                pdfFont = pdfFont;
                f13 = fWidthLeft;
                i2 = i2;
                baseColor = baseColor;
                str6 = Chunk.CHAR_SPACING;
                f14 = 0.0f;
                i3 = 1;
                c = 0;
                pdfChunk = pdfChunk3;
                f15 = f7;
                f16 = 1.0f;
            }
            if (pdfChunk.isImage()) {
                pdfFont2 = pdfFont;
                if (pdfChunk.font().compareTo(pdfFont2) != 0) {
                    pdfFontFont = pdfChunk.font();
                    pdfContentByte4.setFontAndSize(pdfFontFont.getFont(), pdfFontFont.size());
                }
                pdfChunk2 = pdfChunk;
                objArr2 = (Object[]) pdfChunk2.getAttribute(Chunk.TEXTRENDERMODE);
                f17 = (Float) pdfChunk2.getAttribute(Chunk.SUBSUPSCRIPT);
                if (objArr2 != null) {
                    iIntValue = ((Integer) objArr2[c]).intValue() & 3;
                    if (iIntValue != 0) {
                        pdfContentByte4.setTextRenderingMode(iIntValue);
                    }
                    if (iIntValue != i3) {
                        fFloatValue = ((Float) objArr2[i3]).floatValue();
                        if (fFloatValue != 1.0f) {
                            pdfContentByte4.setLineWidth(fFloatValue);
                        }
                        baseColor2 = (BaseColor) objArr2[2];
                        if (baseColor2 == null) {
                            baseColor2 = baseColor;
                        }
                        if (baseColor2 != null) {
                            pdfContentByte4.setColorStroke(baseColor2);
                        }
                    } else {
                        fFloatValue = ((Float) objArr2[i3]).floatValue();
                        if (fFloatValue != 1.0f) {
                            pdfContentByte4.setLineWidth(fFloatValue);
                        }
                        baseColor2 = (BaseColor) objArr2[2];
                        if (baseColor2 == null) {
                            baseColor2 = baseColor;
                        }
                        if (baseColor2 != null) {
                            pdfContentByte4.setColorStroke(baseColor2);
                        }
                    }
                } else {
                    baseColor2 = null;
                    fFloatValue = 1.0f;
                    iIntValue = 0;
                }
                if (f17 != null) {
                    fFloatValue2 = f17.floatValue();
                } else {
                    fFloatValue2 = 0.0f;
                }
                if (baseColor != 0) {
                    pdfContentByte4.setColorFill(baseColor);
                }
                if (fFloatValue2 != f14) {
                    pdfContentByte4.setTextRise(fFloatValue2);
                }
                if (pdfChunk2.isImage()) {
                    i4 = i;
                    f20 = f5;
                    f21 = f4;
                    f19 = f13;
                    z2 = true;
                } else {
                    if (pdfChunk2.isHorizontalSeparator()) {
                        PdfTextArray pdfTextArray5 = new PdfTextArray();
                        f18 = f13;
                        pdfTextArray5.add((((-f18) * 1000.0f) / pdfChunk2.font.size()) / f16);
                        pdfContentByte4.showText(pdfTextArray5);
                    } else {
                        f18 = f13;
                        if (!pdfChunk2.isTab()) {
                        }
                        if (z6) {
                            i4 = i;
                            f19 = f18;
                            f20 = f5;
                            f21 = f4;
                            if (z6) {
                                pdfContentByte4.setWordSpacing(f20 / f16);
                                pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                f9 = f16;
                            }
                            pdfContentByte4.showText(pdfChunk2.toString());
                        } else {
                            i4 = i;
                            f19 = f18;
                            f20 = f5;
                            f21 = f4;
                            if (z6) {
                                pdfContentByte4.setWordSpacing(f20 / f16);
                                pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                                f9 = f16;
                            }
                            pdfContentByte4.showText(pdfChunk2.toString());
                        }
                    }
                    i4 = i;
                    f19 = f18;
                    f20 = f5;
                    f21 = f4;
                }
                if (fFloatValue2 != f14) {
                    pdfContentByte4.setTextRise(0.0f);
                }
                if (baseColor != 0) {
                    pdfContentByte.resetRGBColorFill();
                }
                if (iIntValue != 0) {
                    pdfContentByte4.setTextRenderingMode(0);
                }
                if (baseColor2 != null) {
                    pdfContentByte.resetRGBColorStroke();
                }
                if (fFloatValue != 1.0f) {
                    pdfContentByte4.setLineWidth(1.0f);
                }
                if (pdfChunk2.isAttribute(str2)) {
                    f22 = f12;
                    pdfContentByte4.setTextMatrix(f15, f22);
                    z2 = true;
                } else {
                    f22 = f12;
                    pdfContentByte4.setTextMatrix(f15, f22);
                    z2 = true;
                }
                if (!z6) {
                    if (pdfChunk2.isAttribute(str6)) {
                        pdfContentByte4.setCharacterSpacing(f21);
                    }
                    if (pdfChunk2.isAttribute(str5)) {
                        pdfContentByte4.setWordSpacing(f20);
                    }
                }
                if (!isTagged(this.writer)) {
                }
                pdfLine2 = pdfLine;
                i = i4;
                pdfContentByte6 = pdfContentByte4;
                f4 = f21;
                ytlm = f22;
                f7 = f15;
                pdfContentByte7 = pdfContentByte5;
                pdfFont = pdfFontFont;
                fWidthLeft = f19;
                z = z3;
                lastStrokeChunk = lastStrokeChunk;
                iNumberOfSpaces = i2;
                pdfDocument = this;
                f5 = f20;
            } else {
                pdfFont2 = pdfFont;
            }
            pdfFontFont = pdfFont2;
            pdfChunk2 = pdfChunk;
            objArr2 = (Object[]) pdfChunk2.getAttribute(Chunk.TEXTRENDERMODE);
            f17 = (Float) pdfChunk2.getAttribute(Chunk.SUBSUPSCRIPT);
            if (objArr2 != null) {
                iIntValue = ((Integer) objArr2[c]).intValue() & 3;
                if (iIntValue != 0) {
                    pdfContentByte4.setTextRenderingMode(iIntValue);
                }
                if (iIntValue != i3) {
                    fFloatValue = ((Float) objArr2[i3]).floatValue();
                    if (fFloatValue != 1.0f) {
                        pdfContentByte4.setLineWidth(fFloatValue);
                    }
                    baseColor2 = (BaseColor) objArr2[2];
                    if (baseColor2 == null) {
                        baseColor2 = baseColor;
                    }
                    if (baseColor2 != null) {
                        pdfContentByte4.setColorStroke(baseColor2);
                    }
                } else {
                    fFloatValue = ((Float) objArr2[i3]).floatValue();
                    if (fFloatValue != 1.0f) {
                        pdfContentByte4.setLineWidth(fFloatValue);
                    }
                    baseColor2 = (BaseColor) objArr2[2];
                    if (baseColor2 == null) {
                        baseColor2 = baseColor;
                    }
                    if (baseColor2 != null) {
                        pdfContentByte4.setColorStroke(baseColor2);
                    }
                }
            } else {
                baseColor2 = null;
                fFloatValue = 1.0f;
                iIntValue = 0;
            }
            if (f17 != null) {
                fFloatValue2 = f17.floatValue();
            } else {
                fFloatValue2 = 0.0f;
            }
            if (baseColor != 0) {
                pdfContentByte4.setColorFill(baseColor);
            }
            if (fFloatValue2 != f14) {
                pdfContentByte4.setTextRise(fFloatValue2);
            }
            if (pdfChunk2.isImage()) {
                i4 = i;
                f20 = f5;
                f21 = f4;
                f19 = f13;
                z2 = true;
            } else {
                if (pdfChunk2.isHorizontalSeparator()) {
                    PdfTextArray pdfTextArray6 = new PdfTextArray();
                    f18 = f13;
                    pdfTextArray6.add((((-f18) * 1000.0f) / pdfChunk2.font.size()) / f16);
                    pdfContentByte4.showText(pdfTextArray6);
                } else {
                    f18 = f13;
                    if (!pdfChunk2.isTab()) {
                    }
                    if (z6) {
                        i4 = i;
                        f19 = f18;
                        f20 = f5;
                        f21 = f4;
                        if (z6) {
                            pdfContentByte4.setWordSpacing(f20 / f16);
                            pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                            f9 = f16;
                        }
                        pdfContentByte4.showText(pdfChunk2.toString());
                    } else {
                        i4 = i;
                        f19 = f18;
                        f20 = f5;
                        f21 = f4;
                        if (z6) {
                            pdfContentByte4.setWordSpacing(f20 / f16);
                            pdfContentByte4.setCharacterSpacing((f21 / f16) + pdfContentByte.getCharacterSpacing());
                            f9 = f16;
                        }
                        pdfContentByte4.showText(pdfChunk2.toString());
                    }
                }
                i4 = i;
                f19 = f18;
                f20 = f5;
                f21 = f4;
            }
            if (fFloatValue2 != f14) {
                pdfContentByte4.setTextRise(0.0f);
            }
            if (baseColor != 0) {
                pdfContentByte.resetRGBColorFill();
            }
            if (iIntValue != 0) {
                pdfContentByte4.setTextRenderingMode(0);
            }
            if (baseColor2 != null) {
                pdfContentByte.resetRGBColorStroke();
            }
            if (fFloatValue != 1.0f) {
                pdfContentByte4.setLineWidth(1.0f);
            }
            if (pdfChunk2.isAttribute(str2)) {
                f22 = f12;
                pdfContentByte4.setTextMatrix(f15, f22);
                z2 = true;
            } else {
                f22 = f12;
                pdfContentByte4.setTextMatrix(f15, f22);
                z2 = true;
            }
            if (!z6) {
                if (pdfChunk2.isAttribute(str6)) {
                    pdfContentByte4.setCharacterSpacing(f21);
                }
                if (pdfChunk2.isAttribute(str5)) {
                    pdfContentByte4.setWordSpacing(f20);
                }
            }
            if (!isTagged(this.writer)) {
            }
            pdfLine2 = pdfLine;
            i = i4;
            pdfContentByte6 = pdfContentByte4;
            f4 = f21;
            ytlm = f22;
            f7 = f15;
            pdfContentByte7 = pdfContentByte5;
            pdfFont = pdfFontFont;
            fWidthLeft = f19;
            z = z3;
            lastStrokeChunk = lastStrokeChunk;
            iNumberOfSpaces = i2;
            pdfDocument = this;
            f5 = f20;
        }
        PdfFont pdfFont5 = pdfFont;
        pdfContentByte3 = pdfContentByte6;
        if (z6) {
            pdfContentByte3.setWordSpacing(0.0f);
            pdfContentByte3.setCharacterSpacing(0.0f);
            if (pdfLine.isNewlineSplit()) {
                f10 = 0.0f;
            } else {
                f10 = fFloatValue5;
            }
        } else {
            f10 = fFloatValue5;
        }
        if (z2) {
            pdfContentByte3.moveText(xtlm - pdfContentByte.getXTLM(), 0.0f);
        }
        objArr[0] = pdfFont5;
        objArr[1] = new Float(f10);
        return f2;
    }

    public void writeOutlines() {
        if (this.rootOutline.getKids().size() == 0) {
            return;
        }
        outlineTree(this.rootOutline);
        PdfWriter pdfWriter = this.writer;
        PdfOutline pdfOutline = this.rootOutline;
        pdfWriter.addToBody(pdfOutline, pdfOutline.indirectReference());
    }

    public void addSpacing(float f, float f2, Font font, boolean z) {
        if (f == 0.0f || this.pageEmpty) {
            return;
        }
        if (this.currentHeight + (z ? f : calculateLineHeight()) > indentTop() - indentBottom()) {
            newPage();
            return;
        }
        this.leading = f;
        carriageReturn();
        if (font.isUnderlined() || font.isStrikethru()) {
            Font font2 = new Font(font);
            font2.setStyle(font2.getStyle() & (-13));
            font = font2;
        }
        Chunk chunk = new Chunk(" ", font);
        if (z && this.pageEmpty) {
            chunk = new Chunk("", font);
        }
        chunk.process(this);
        carriageReturn();
        this.leading = f2;
    }

    public PdfStructureElement getStructElement(AccessibleElementId accessibleElementId, boolean z) {
        TempFileCache.ObjectPosition objectPosition;
        PdfStructureElement pdfStructureElement = this.structElements.get(accessibleElementId);
        if (this.isToUseExternalCache && pdfStructureElement == null && (objectPosition = this.externallyStoredStructElements.get(accessibleElementId)) != null) {
            try {
                pdfStructureElement = (PdfStructureElement) this.externalCache.get(objectPosition);
                pdfStructureElement.setStructureTreeRoot(this.writer.getStructureTreeRoot());
                pdfStructureElement.setStructureElementParent(getStructElement(this.elementsParents.get(pdfStructureElement.getElementId()), z));
                if (z) {
                    this.externallyStoredStructElements.remove(accessibleElementId);
                    this.structElements.put(accessibleElementId, pdfStructureElement);
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            } catch (ClassNotFoundException e2) {
                throw new ExceptionConverter(e2);
            }
        }
        return pdfStructureElement;
    }

    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, new PdfAction(str, i), null));
    }

    public static class PdfInfo extends PdfDictionary {
        public PdfInfo() {
            addProducer();
            addCreationDate();
        }

        public void addAuthor(String str) {
            put(PdfName.AUTHOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        public void addCreationDate() {
            PdfDate pdfDate = new PdfDate();
            put(PdfName.CREATIONDATE, pdfDate);
            put(PdfName.MODDATE, pdfDate);
        }

        public void addCreator(String str) {
            put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        public void addKeywords(String str) {
            put(PdfName.KEYWORDS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        public void addProducer() {
            put(PdfName.PRODUCER, new PdfString(Version.getInstance().getVersion()));
        }

        public void addSubject(String str) {
            put(PdfName.SUBJECT, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        public void addTitle(String str) {
            put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        public void addkey(String str, String str2) {
            if (str.equals(PdfProperties.PRODUCER) || str.equals("CreationDate")) {
                return;
            }
            put(new PdfName(str), new PdfString(str2, PdfObject.TEXT_UNICODE));
        }

        public PdfInfo(String str, String str2, String str3) {
            this();
            addTitle(str2);
            addSubject(str3);
            addAuthor(str);
        }
    }

    public void setOpenAction(PdfAction pdfAction) {
        this.openActionAction = pdfAction;
        this.openActionName = null;
    }

    public void addJavaScript(String str, PdfAction pdfAction) {
        if (pdfAction.get(PdfName.JS) != null) {
            try {
                this.documentLevelJS.put(str, this.writer.addToBody(pdfAction).getIndirectReference());
                return;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
    }

    public void add(Image image) throws DocumentException {
        if (image.hasAbsoluteY()) {
            this.graphics.addImage(image);
            this.pageEmpty = false;
            return;
        }
        if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
            if (!this.strictImageSequence && this.imageWait == null) {
                this.imageWait = image;
                return;
            }
            newPage();
            if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
                this.imageWait = image;
                return;
            }
        }
        this.pageEmpty = false;
        if (image == this.imageWait) {
            this.imageWait = null;
        }
        boolean z = (image.getAlignment() & 4) == 4 && (image.getAlignment() & 1) != 1;
        boolean z2 = (image.getAlignment() & 8) == 8;
        float f = this.leading;
        float f2 = f / 2.0f;
        if (z) {
            f2 += f;
        }
        float f3 = f2;
        float fIndentTop = ((indentTop() - this.currentHeight) - image.getScaledHeight()) - f3;
        float[] fArrMatrix = image.matrix();
        float fIndentLeft = indentLeft() - fArrMatrix[4];
        if ((image.getAlignment() & 2) == 2) {
            fIndentLeft = (indentRight() - image.getScaledWidth()) - fArrMatrix[4];
        }
        if ((image.getAlignment() & 1) == 1) {
            fIndentLeft = (indentLeft() + (((indentRight() - indentLeft()) - image.getScaledWidth()) / 2.0f)) - fArrMatrix[4];
        }
        if (image.hasAbsoluteX()) {
            fIndentLeft = image.getAbsoluteX();
        }
        if (z) {
            float f4 = this.imageEnd;
            if (f4 < 0.0f || f4 < this.currentHeight + image.getScaledHeight() + f3) {
                this.imageEnd = this.currentHeight + image.getScaledHeight() + f3;
            }
            if ((image.getAlignment() & 2) == 2) {
                this.indentation.imageIndentRight += image.getScaledWidth() + image.getIndentationLeft();
            } else {
                this.indentation.imageIndentLeft += image.getScaledWidth() + image.getIndentationRight();
            }
        } else if ((image.getAlignment() & 2) == 2) {
            fIndentLeft -= image.getIndentationRight();
        } else {
            fIndentLeft += (image.getAlignment() & 1) == 1 ? image.getIndentationLeft() - image.getIndentationRight() : image.getIndentationLeft();
        }
        this.graphics.addImage(image, fArrMatrix[0], fArrMatrix[1], fArrMatrix[2], fArrMatrix[3], fIndentLeft, fIndentTop - fArrMatrix[5]);
        if (z || z2) {
            return;
        }
        this.currentHeight += image.getScaledHeight() + f3;
        flushLines();
        this.text.moveText(0.0f, -(image.getScaledHeight() + f3));
        newLine();
    }
}
