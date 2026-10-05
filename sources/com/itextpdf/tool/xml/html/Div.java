package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Div extends AbstractTagProcessor {
    private void invertTextAlignForDiv(PdfDiv pdfDiv) {
        int textAlignment = pdfDiv.getTextAlignment();
        if (textAlignment == -1 || textAlignment == 8 || textAlignment == 1) {
            return;
        }
        if (textAlignment == 2) {
            pdfDiv.setTextAlignment(0);
        } else if (textAlignment != 3) {
            pdfDiv.setTextAlignment(2);
        }
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> listSanitize = HTMLUtils.sanitize(str, false);
        NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
        ArrayList arrayList = new ArrayList(1);
        try {
            HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
            Iterator<Chunk> it = listSanitize.iterator();
            while (it.hasNext()) {
                noNewLineParagraph.add(getCssAppliers().apply(it.next(), tag, htmlPipelineContext));
            }
            if (noNewLineParagraph.size() > 0) {
                arrayList.add(getCssAppliers().apply(noNewLineParagraph, tag, htmlPipelineContext));
            }
            return arrayList;
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(e);
        }
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        try {
            PdfDiv pdfDiv = (PdfDiv) getCssAppliers().apply(new PdfDiv(), tag, getHtmlPipelineContext(workerContext));
            int runDirection = getRunDirection(tag);
            if (runDirection != 1) {
                pdfDiv.setRunDirection(runDirection);
            }
            Paragraph paragraph = null;
            for (Element element : list) {
                if ((element instanceof Paragraph) || (element instanceof PdfPTable) || (element instanceof PdfDiv)) {
                    if (paragraph != null) {
                        if (paragraph.trim()) {
                            pdfDiv.addElement(paragraph);
                        }
                        paragraph = null;
                    }
                    pdfDiv.addElement(element);
                } else {
                    if (paragraph == null) {
                        paragraph = new Paragraph();
                        paragraph.setAlignment(pdfDiv.getTextAlignment());
                        if (runDirection == 3) {
                            invertTextAlignForParagraph(paragraph);
                        }
                        paragraph.setMultipliedLeading(1.2f);
                    }
                    paragraph.add(element);
                }
            }
            if (paragraph != null && paragraph.trim()) {
                pdfDiv.addElement(paragraph);
            }
            if (runDirection == 3) {
                invertTextAlignForDiv(pdfDiv);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(pdfDiv);
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
