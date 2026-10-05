package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfOutline;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.util.ParentTreeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Header extends AbstractTagProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Header.class);

    private PdfName getHeaderRole(int i) {
        switch (i) {
            case 1:
                return PdfName.H1;
            case 2:
                return PdfName.H2;
            case 3:
                return PdfName.H3;
            case 4:
                return PdfName.H4;
            case 5:
                return PdfName.H5;
            case 6:
                return PdfName.H6;
            default:
                return PdfName.H;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLevel(Tag tag) {
        return Integer.parseInt(Character.toString(tag.getName().charAt(1)));
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return textContent(workerContext, tag, str);
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, final Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        ParentTreeUtil parentTreeUtil = new ParentTreeUtil();
        if (list.size() > 0) {
            List<Element> listCurrentContentToParagraph = currentContentToParagraph(list, true, true, tag, workerContext);
            Iterator<Element> it = listCurrentContentToParagraph.iterator();
            while (it.hasNext()) {
                ((Paragraph) it.next()).setRole(getHeaderRole(getLevel(tag)));
            }
            try {
                final HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
                boolean zAutoBookmark = htmlPipelineContext.autoBookmark();
                if (!parentTreeUtil.getParentTree(tag).isEmpty() && parentTreeUtil.getParentTree(tag).contains("td")) {
                    htmlPipelineContext.autoBookmark(false);
                }
                if (htmlPipelineContext.autoBookmark()) {
                    final Paragraph paragraph = new Paragraph();
                    Iterator<Element> it2 = listCurrentContentToParagraph.iterator();
                    while (it2.hasNext()) {
                        paragraph.add(it2.next());
                    }
                    arrayList.add(new WritableDirectElement(1) { // from class: com.itextpdf.tool.xml.html.Header.1
                        @Override // com.itextpdf.text.api.WriterOperation
                        public void write(PdfWriter pdfWriter, Document document) {
                            PdfDestination pdfDestination = new PdfDestination(0, 20.0f, pdfWriter.getVerticalPosition(false), 0.0f);
                            Map<String, Object> memory = htmlPipelineContext.getMemory();
                            HeaderNode headerNodeParent = (HeaderNode) memory.get(HtmlPipelineContext.BOOKMARK_TREE);
                            int level = Header.this.getLevel(tag);
                            if (headerNodeParent == null) {
                                headerNodeParent = new HeaderNode(0, pdfWriter.getRootOutline(), null);
                            } else {
                                int iLevel = headerNodeParent.level();
                                if (iLevel == level) {
                                    headerNodeParent = headerNodeParent.parent();
                                } else if (iLevel > level) {
                                    while (iLevel >= level) {
                                        iLevel = headerNodeParent.parent().level();
                                        headerNodeParent = headerNodeParent.parent();
                                    }
                                }
                            }
                            if (Header.LOGGER.isLogging(Level.TRACE)) {
                                Header.LOGGER.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.ADD_HEADER), paragraph.toString()));
                            }
                            memory.put(HtmlPipelineContext.BOOKMARK_TREE, new HeaderNode(level, new PdfOutline(headerNodeParent.outline(), pdfDestination, paragraph), headerNodeParent));
                        }
                    });
                }
                htmlPipelineContext.autoBookmark(zAutoBookmark);
            } catch (NoCustomContextException e) {
                Logger logger = LOGGER;
                if (logger.isLogging(Level.ERROR)) {
                    logger.error(LocaleMessages.getInstance().getMessage(LocaleMessages.HEADER_BM_DISABLED), e);
                }
            }
            arrayList.addAll(listCurrentContentToParagraph);
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
