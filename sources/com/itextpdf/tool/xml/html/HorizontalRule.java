package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalRule extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> start(WorkerContext workerContext, Tag tag) {
        try {
            ArrayList arrayList = new ArrayList();
            LineSeparator lineSeparator = (LineSeparator) getCssAppliers().apply(new LineSeparator(), tag, getHtmlPipelineContext(workerContext));
            Paragraph paragraph = new Paragraph();
            Map<String, String> css = tag.getCSS();
            float pxInCmMmPcToPt = css.get("font-size") != null ? CssUtils.getInstance().parsePxInCmMmPcToPt(css.get("font-size")) : 12.0f;
            String str = css.get(CSS.Property.MARGIN_TOP);
            String str2 = "0.5em";
            if (str == null) {
                str = "0.5em";
            }
            String str3 = css.get(CSS.Property.MARGIN_BOTTOM);
            if (str3 != null) {
                str2 = str3;
            }
            paragraph.setSpacingBefore(paragraph.getSpacingBefore() + CssUtils.getInstance().parseValueToPt(str, pxInCmMmPcToPt));
            paragraph.setSpacingAfter(paragraph.getSpacingAfter() + CssUtils.getInstance().parseValueToPt(str2, pxInCmMmPcToPt));
            paragraph.setLeading(0.0f);
            paragraph.add((Element) lineSeparator);
            arrayList.add(paragraph);
            return arrayList;
        } catch (NoCustomContextException e) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
        }
    }
}
