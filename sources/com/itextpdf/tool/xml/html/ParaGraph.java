package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.TabbedChunk;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ParaGraph extends AbstractTagProcessor {
    private void addTabIntervalContent(WorkerContext workerContext, Tag tag, List<Element> list, Paragraph paragraph, String str) {
        float tabCount = 0.0f;
        for (Element element : list) {
            if (element instanceof TabbedChunk) {
                TabbedChunk tabbedChunk = (TabbedChunk) element;
                tabCount += tabbedChunk.getTabCount() * CssUtils.getInstance().parsePxInCmMmPcToPt(str);
                paragraph.add((Element) new Chunk(new TabbedChunk(new VerticalPositionMark(), tabCount, false)));
                paragraph.add((Element) new Chunk(tabbedChunk));
            } else {
                if (element instanceof LineSeparator) {
                    try {
                        paragraph.add(getCssAppliers().apply(new Chunk(Chunk.NEWLINE), tag, getHtmlPipelineContext(workerContext)));
                    } catch (NoCustomContextException e) {
                        throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
                    }
                }
                paragraph.add(element);
            }
        }
    }

    private void addTabStopsContent(List<Element> list, Paragraph paragraph, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(" ");
        float pxInCmMmPcToPt = 0.0f;
        int i = 0;
        for (int i2 = 1; i2 < strArrSplit.length; i2 += 2) {
            pxInCmMmPcToPt += CssUtils.getInstance().parsePxInCmMmPcToPt(strArrSplit[i2]);
            arrayList.add(new TabbedChunk(new VerticalPositionMark(), pxInCmMmPcToPt, true, strArrSplit[i]));
            i += 2;
        }
        int size = arrayList.size();
        int i3 = 0;
        for (Element element : list) {
            if (element instanceof TabbedChunk) {
                if (i3 == size) {
                    i3 = 0;
                }
                TabbedChunk tabbedChunk = (TabbedChunk) element;
                if (tabbedChunk.getTabCount() != 0) {
                    paragraph.add((Element) new Chunk((Chunk) arrayList.get(i3)));
                    paragraph.add((Element) new Chunk(tabbedChunk));
                    i3++;
                }
            } else {
                paragraph.add(element);
            }
        }
    }

    private Tag getLastChild(Tag tag) {
        if (tag.getChildren().size() != 0) {
            return tag.getChildren().get(tag.getChildren().size() - 1);
        }
        return null;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> listSanitize = HTMLUtils.sanitize(str, false);
        ArrayList arrayList = new ArrayList(1);
        for (Chunk chunk : listSanitize) {
            try {
                HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
                if (tag.getCSS().get(CSS.Property.TAB_INTERVAL) != null) {
                    TabbedChunk tabbedChunk = new TabbedChunk(chunk.getContent());
                    if (getLastChild(tag) != null && getLastChild(tag).getCSS().get(CSS.Property.XFA_TAB_COUNT) != null) {
                        tabbedChunk.setTabCount(Integer.parseInt(getLastChild(tag).getCSS().get(CSS.Property.XFA_TAB_COUNT)));
                    }
                    arrayList.add(getCssAppliers().apply(tabbedChunk, tag, htmlPipelineContext));
                } else if (getLastChild(tag) == null || getLastChild(tag).getCSS().get(CSS.Property.XFA_TAB_COUNT) == null) {
                    arrayList.add(getCssAppliers().apply(chunk, tag, htmlPipelineContext));
                } else {
                    TabbedChunk tabbedChunk2 = new TabbedChunk(chunk.getContent());
                    tabbedChunk2.setTabCount(Integer.parseInt(getLastChild(tag).getCSS().get(CSS.Property.XFA_TAB_COUNT)));
                    arrayList.add(getCssAppliers().apply(tabbedChunk2, tag, htmlPipelineContext));
                }
            } catch (NoCustomContextException e) {
                throw new RuntimeWorkerException(e);
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        if (list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Element element : list) {
                if (element instanceof ListItem) {
                    if (!arrayList2.isEmpty()) {
                        processParagraphItems(workerContext, tag, arrayList2, arrayList);
                        arrayList2.clear();
                    }
                    arrayList3.add((ListItem) element);
                } else {
                    if (!arrayList3.isEmpty()) {
                        processListItems(workerContext, tag, arrayList3, arrayList);
                        arrayList3.clear();
                    }
                    arrayList2.add(element);
                }
            }
            if (!arrayList2.isEmpty()) {
                processParagraphItems(workerContext, tag, arrayList2, arrayList);
                arrayList2.clear();
            } else if (!arrayList3.isEmpty()) {
                processListItems(workerContext, tag, arrayList3, arrayList);
                arrayList3.clear();
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }

    public void processListItems(WorkerContext workerContext, Tag tag, List<ListItem> list, List<Element> list2) {
        try {
            com.itextpdf.text.List list3 = new com.itextpdf.text.List();
            int i = 0;
            list3.setAlignindent(false);
            com.itextpdf.text.List list4 = (com.itextpdf.text.List) getCssAppliers().apply(list3, tag, getHtmlPipelineContext(workerContext));
            list4.setIndentationLeft(0.0f);
            Iterator<ListItem> it = list.iterator();
            while (it.hasNext()) {
                ListItem listItem = (ListItem) getCssAppliers().apply(it.next(), tag, getHtmlPipelineContext(workerContext));
                if (i != list.size() - 1) {
                    listItem.setSpacingAfter(0.0f);
                }
                if (i != 0) {
                    listItem.setSpacingBefore(0.0f);
                }
                i++;
                listItem.setMultipliedLeading(1.2f);
                list4.add(listItem);
            }
            if (!list2.isEmpty()) {
                Element element = list2.get(list2.size() - 1);
                if (element instanceof Paragraph) {
                    ((Paragraph) element).setSpacingAfter(0.0f);
                }
            }
            list2.add(list4);
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }

    public void processParagraphItems(WorkerContext workerContext, Tag tag, List<Element> list, List<Element> list2) {
        Paragraph paragraph = new Paragraph();
        paragraph.setMultipliedLeading(1.2f);
        Map<String, String> css = tag.getCSS();
        if (css.get(CSS.Property.TAB_INTERVAL) != null) {
            addTabIntervalContent(workerContext, tag, list, paragraph, css.get(CSS.Property.TAB_INTERVAL));
            list2.add(paragraph);
            return;
        }
        if (css.get(CSS.Property.TAB_STOPS) != null) {
            addTabStopsContent(list, paragraph, css.get(CSS.Property.TAB_STOPS));
            list2.add(paragraph);
            return;
        }
        if (css.get(CSS.Property.XFA_TAB_STOPS) != null) {
            addTabStopsContent(list, paragraph, css.get(CSS.Property.XFA_TAB_STOPS));
            list2.add(paragraph);
            return;
        }
        List<Element> listCurrentContentToParagraph = currentContentToParagraph(list, true, true, tag, workerContext);
        if (!list2.isEmpty() && !listCurrentContentToParagraph.isEmpty()) {
            Element element = listCurrentContentToParagraph.get(0);
            if (element instanceof Paragraph) {
                ((Paragraph) element).setSpacingBefore(0.0f);
            }
        }
        Iterator<Element> it = listCurrentContentToParagraph.iterator();
        while (it.hasNext()) {
            list2.add(it.next());
        }
    }
}
