package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Body extends AbstractTagProcessor {
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> listSanitize = HTMLUtils.sanitize(str, false);
        ArrayList arrayList = new ArrayList(1);
        NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
        Iterator<Chunk> it = listSanitize.iterator();
        while (it.hasNext()) {
            noNewLineParagraph.add((Element) getCssAppliers().getChunkCssAplier().apply(it.next(), tag));
        }
        if (noNewLineParagraph.size() > 0) {
            try {
                arrayList.add(getCssAppliers().apply(noNewLineParagraph, tag, getHtmlPipelineContext(workerContext)));
            } catch (NoCustomContextException e) {
                throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> start(WorkerContext workerContext, Tag tag) {
        MapContext mapContext;
        ArrayList arrayList = new ArrayList(1);
        try {
            Map<String, String> css = tag.getCSS();
            if (css.containsKey(CSS.Property.BACKGROUND_COLOR) && (mapContext = (MapContext) workerContext.get(PdfWriterPipeline.class.getName())) != null) {
                Document document = (Document) mapContext.get(PdfWriterPipeline.DOCUMENT);
                Rectangle rectangle = new Rectangle(document.left(), document.bottom(), document.right(), document.top(), document.getPageSize().getRotation());
                rectangle.setBackgroundColor(HtmlUtilities.decodeColor(css.get(CSS.Property.BACKGROUND_COLOR)));
                arrayList.add(new PdfBody(rectangle));
            }
        } catch (NoCustomContextException unused) {
        }
        return arrayList;
    }
}
