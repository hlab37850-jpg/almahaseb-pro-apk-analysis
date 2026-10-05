package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class OrderedUnorderedList extends AbstractTagProcessor {
    private static final FontSizeTranslator fst = FontSizeTranslator.getInstance();
    private static final CssUtils utils = CssUtils.getInstance();

    /* JADX WARN: Code duplicated, block: B:40:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f4  */
    private float calculateTopOrBottomSpacing(boolean z, boolean z2, Tag tag, Tag tag2, WorkerContext workerContext) {
        float valueToPt;
        float valueToPt2;
        float valueToPt3;
        try {
            HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
            String str = z ? "-top" : "-bottom";
            FontSizeTranslator fontSizeTranslator = fst;
            float fontSize = fontSizeTranslator.getFontSize(tag);
            float f = 0.0f;
            if (fontSize == -1.0f) {
                fontSize = 0.0f;
            }
            String str2 = tag.getCSS().get(CSS.Property.MARGIN + str);
            if (str2 == null) {
                valueToPt = (tag.getParent() == null || !getHtmlPipelineContext(workerContext).getRootTags().contains(tag.getParent().getName())) ? 0.0f : fontSize;
            } else {
                valueToPt = utils.parseValueToPt(str2, fontSize);
            }
            if (tag.getCSS().get(CSS.Property.PADDING + str) != null) {
                valueToPt2 = utils.parseValueToPt(tag.getCSS().get(CSS.Property.PADDING + str), fontSize);
            } else {
                valueToPt2 = 0.0f;
            }
            float fontSize2 = fontSizeTranslator.getFontSize(tag2);
            if (tag2.getCSS().get(CSS.Property.MARGIN + str) != null) {
                valueToPt3 = utils.parseValueToPt(tag2.getCSS().get(CSS.Property.MARGIN + str), fontSize2);
            } else {
                valueToPt3 = 0.0f;
            }
            if (valueToPt2 == 0.0f) {
                if (valueToPt == 0.0f || valueToPt3 == 0.0f) {
                    if (valueToPt != 0.0f) {
                        f = valueToPt;
                    } else if (valueToPt3 != 0.0f) {
                        f = valueToPt3;
                    }
                } else if (valueToPt >= valueToPt3) {
                    f = valueToPt;
                } else {
                    f = valueToPt3;
                }
                if (!z && z2) {
                    htmlPipelineContext.getMemory().put(HtmlPipelineContext.LAST_MARGIN_BOTTOM, Float.valueOf(f));
                }
            } else {
                f = valueToPt2 + valueToPt + valueToPt3;
                if (!z && z2) {
                    htmlPipelineContext.getMemory().put(HtmlPipelineContext.LAST_MARGIN_BOTTOM, Float.valueOf(valueToPt));
                }
            }
            return f;
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }

    private List<Element> populateList(List<Element> list) {
        ArrayList arrayList = new ArrayList();
        for (Element element : list) {
            if ((element instanceof ListItem) || (element instanceof com.itextpdf.text.List)) {
                arrayList.add(element);
            } else {
                ListItem listItem = new ListItem();
                listItem.add(element);
                arrayList.add(listItem);
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        com.itextpdf.text.List list2;
        String str;
        List<Element> listPopulateList = populateList(list);
        int size = listPopulateList.size();
        ArrayList arrayList = new ArrayList();
        if (size > 0) {
            try {
                list2 = (com.itextpdf.text.List) getCssAppliers().apply(new com.itextpdf.text.List(), tag, getHtmlPipelineContext(workerContext));
            } catch (NoCustomContextException unused) {
                list2 = (com.itextpdf.text.List) getCssAppliers().apply(new com.itextpdf.text.List(), tag, null);
            }
            com.itextpdf.text.List list3 = list2;
            int i = 0;
            for (Element element : listPopulateList) {
                if (element instanceof ListItem) {
                    Tag tag2 = tag.getChildren().get(i);
                    if (size == 1) {
                        tag2.getCSS().put(CSS.Property.MARGIN_TOP, calculateTopOrBottomSpacing(true, false, tag, tag2, workerContext) + CSS.Value.PT);
                        float fCalculateTopOrBottomSpacing = calculateTopOrBottomSpacing(false, false, tag, tag2, workerContext);
                        tag2.getCSS().put(CSS.Property.MARGIN_BOTTOM, fCalculateTopOrBottomSpacing + CSS.Value.PT);
                    } else {
                        if (i == 0) {
                            Map<String, String> css = tag2.getCSS();
                            StringBuilder sb = new StringBuilder();
                            str = CSS.Value.PT;
                            sb.append(calculateTopOrBottomSpacing(true, false, tag, tag2, workerContext));
                            sb.append(str);
                            css.put(CSS.Property.MARGIN_TOP, sb.toString());
                        } else {
                            str = CSS.Value.PT;
                        }
                        if (i == size - 1) {
                            float fCalculateTopOrBottomSpacing2 = calculateTopOrBottomSpacing(false, true, tag, tag2, workerContext);
                            tag2.getCSS().put(CSS.Property.MARGIN_BOTTOM, fCalculateTopOrBottomSpacing2 + str);
                        }
                    }
                    try {
                        list3.add(getCssAppliers().apply(element, tag2, getHtmlPipelineContext(workerContext)));
                    } catch (NoCustomContextException e) {
                        throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
                    }
                } else {
                    list3.add(element);
                }
                i++;
            }
            arrayList.add(list3);
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
