package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TableData extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return textContent(workerContext, tag, str);
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        HtmlCell htmlCell = new HtmlCell();
        int runDirection = getRunDirection(tag);
        int i = 1;
        if (runDirection != 1) {
            htmlCell.setRunDirection(runDirection);
        }
        if ("th".equalsIgnoreCase(tag.getName())) {
            htmlCell.setRole(PdfName.TH);
        }
        try {
            HtmlCell htmlCell2 = (HtmlCell) getCssAppliers().apply(htmlCell, tag, getHtmlPipelineContext(workerContext));
            ArrayList arrayList = new ArrayList(1);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i2 = -1;
            int i3 = -1;
            for (Element element : list) {
                int i4 = i3 + 1;
                boolean z = element instanceof Chunk;
                if (z || (element instanceof NoNewLineParagraph) || (element instanceof LineSeparator)) {
                    if (!arrayList3.isEmpty()) {
                        processListItems(workerContext, tag, arrayList3, htmlCell2);
                    }
                    if (z && Chunk.NEWLINE.getContent().equals(((Chunk) element).getContent())) {
                        if (i4 != list.size() - i) {
                            Element element2 = list.get(i3 + 2);
                            if (arrayList2.isEmpty() || (element2 instanceof Chunk) || (element2 instanceof NoNewLineParagraph)) {
                            }
                        }
                        i3 = i4;
                        i = 1;
                        i2 = -1;
                    } else if (element instanceof LineSeparator) {
                        try {
                            arrayList2.add((Chunk) getCssAppliers().apply(new Chunk(Chunk.NEWLINE), tag, getHtmlPipelineContext(workerContext)));
                        } catch (NoCustomContextException e) {
                            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
                        }
                    }
                    arrayList2.add(element);
                    i3 = i4;
                    i = 1;
                    i2 = -1;
                } else if (element instanceof ListItem) {
                    if (!arrayList2.isEmpty()) {
                        processChunkItems(arrayList2, htmlCell2);
                    }
                    arrayList3.add((ListItem) element);
                } else {
                    if (!arrayList2.isEmpty()) {
                        processChunkItems(arrayList2, htmlCell2);
                    }
                    if (!arrayList3.isEmpty()) {
                        processListItems(workerContext, tag, arrayList3, htmlCell2);
                    }
                    if (element instanceof Paragraph) {
                        Paragraph paragraph = (Paragraph) element;
                        if (paragraph.getAlignment() == i2) {
                            paragraph.setAlignment(htmlCell2.getHorizontalAlignment());
                        }
                    }
                    htmlCell2.addElement(element);
                }
                i3 = i4;
                i = 1;
                i2 = -1;
            }
            if (!arrayList2.isEmpty()) {
                processChunkItems(arrayList2, htmlCell2);
            }
            arrayList.add(htmlCell2);
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e2);
        }
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }

    public void processChunkItems(List<Element> list, HtmlCell htmlCell) {
        Paragraph paragraph = new Paragraph();
        paragraph.setMultipliedLeading(1.2f);
        paragraph.addAll(list);
        paragraph.setAlignment(htmlCell.getHorizontalAlignment());
        if (paragraph.trim()) {
            htmlCell.addElement(paragraph);
        }
        list.clear();
    }

    public void processListItems(WorkerContext workerContext, Tag tag, List<ListItem> list, HtmlCell htmlCell) {
        try {
            com.itextpdf.text.List list2 = new com.itextpdf.text.List();
            list2.setAutoindent(false);
            com.itextpdf.text.List list3 = (com.itextpdf.text.List) getCssAppliers().apply(list2, tag, getHtmlPipelineContext(workerContext));
            list3.setIndentationLeft(0.0f);
            Iterator<ListItem> it = list.iterator();
            while (it.hasNext()) {
                ListItem listItem = (ListItem) getCssAppliers().apply(it.next(), tag, getHtmlPipelineContext(workerContext));
                listItem.setSpacingAfter(0.0f);
                listItem.setSpacingBefore(0.0f);
                listItem.setMultipliedLeading(1.2f);
                list3.add(listItem);
            }
            htmlCell.addElement(list3);
            list.clear();
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }
}
