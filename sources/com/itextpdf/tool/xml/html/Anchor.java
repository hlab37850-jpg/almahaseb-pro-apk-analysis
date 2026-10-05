package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Anchor extends AbstractTagProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Anchor.class);

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return textContent(workerContext, tag, str);
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        try {
            final String str = tag.getAttributes().get("name");
            ArrayList arrayList = new ArrayList(0);
            if (list.size() > 0) {
                NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
                String str2 = tag.getAttributes().get("href");
                for (Element element : list) {
                    if (element instanceof Chunk) {
                        if (str2 != null) {
                            if (str2.startsWith("#")) {
                                Logger logger = LOGGER;
                                if (logger.isLogging(Level.TRACE)) {
                                    logger.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.A_LOCALGOTO), str2));
                                }
                                ((Chunk) element).setLocalGoto(str2.replaceFirst("#", ""));
                            } else {
                                if (getHtmlPipelineContext(workerContext).getLinkProvider() != null && !str2.startsWith("http")) {
                                    String linkRoot = getHtmlPipelineContext(workerContext).getLinkProvider().getLinkRoot();
                                    if (linkRoot.endsWith("/") && str2.startsWith("/")) {
                                        linkRoot = linkRoot.substring(0, linkRoot.length() - 1);
                                    }
                                    str2 = linkRoot + str2;
                                }
                                Logger logger2 = LOGGER;
                                if (logger2.isLogging(Level.TRACE)) {
                                    logger2.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.A_EXTERNAL), str2));
                                }
                                ((Chunk) element).setAnchor(str2);
                            }
                        } else if (str != null) {
                            ((Chunk) element).setLocalDestination(str);
                            Logger logger3 = LOGGER;
                            if (logger3.isLogging(Level.TRACE)) {
                                logger3.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.A_SETLOCALGOTO), str));
                            }
                        }
                    }
                    noNewLineParagraph.add(element);
                }
                arrayList.add(getCssAppliers().apply(noNewLineParagraph, tag, getHtmlPipelineContext(workerContext)));
            } else if (str != null) {
                Logger logger4 = LOGGER;
                if (logger4.isLogging(Level.TRACE)) {
                    logger4.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.SPACEHACK), str));
                }
                arrayList.add(new WritableDirectElement() { // from class: com.itextpdf.tool.xml.html.Anchor.1
                    @Override // com.itextpdf.text.api.WriterOperation
                    public void write(PdfWriter pdfWriter, Document document) {
                        ColumnText columnText = new ColumnText(pdfWriter.getDirectContent());
                        float verticalPosition = pdfWriter.getVerticalPosition(false);
                        columnText.setSimpleColumn(new Phrase(new Chunk(" ").setLocalDestination(str)), 1.0f, verticalPosition - 5.0f, 6.0f, verticalPosition, 5.0f, 0);
                        try {
                            columnText.go();
                        } catch (DocumentException e) {
                            throw new RuntimeWorkerException(e);
                        }
                    }
                });
            }
            return arrayList;
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
