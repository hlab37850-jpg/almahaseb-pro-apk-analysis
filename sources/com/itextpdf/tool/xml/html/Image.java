package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.net.ImageRetrieve;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Image extends AbstractTagProcessor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) Image.class);
    private final CssUtils utils = CssUtils.getInstance();

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        com.itextpdf.text.Image imageRetrieveImage;
        Map<String, String> attributes = tag.getAttributes();
        String str = attributes.get("src");
        ArrayList arrayList = new ArrayList(1);
        if (str != null && str.length() > 0) {
            String strTrim = XMLUtil.unescapeXML(str).trim();
            try {
                Logger logger2 = logger;
                if (logger2.isLogging(Level.TRACE)) {
                    logger2.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.HTML_IMG_USE), strTrim));
                }
                HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
                imageRetrieveImage = new ImageRetrieve(htmlPipelineContext.getResourcesRootPath(), htmlPipelineContext.getImageProvider()).retrieveImage(strTrim);
            } catch (NoCustomContextException e) {
                throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
            } catch (NoImageException e2) {
                Logger logger3 = logger;
                if (logger3.isLogging(Level.ERROR)) {
                    logger3.error(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.HTML_IMG_RETRIEVE_FAIL), strTrim), e2);
                }
                imageRetrieveImage = null;
            }
            if (imageRetrieveImage != null) {
                try {
                    if (attributes.get(HTML.Attribute.ALT) != null) {
                        imageRetrieveImage.setAccessibleAttribute(PdfName.ALT, new PdfString(attributes.get(HTML.Attribute.ALT)));
                    }
                    HtmlPipelineContext htmlPipelineContext2 = getHtmlPipelineContext(workerContext);
                    arrayList.add(getCssAppliers().apply(new Chunk((com.itextpdf.text.Image) getCssAppliers().apply(imageRetrieveImage, tag, htmlPipelineContext2), 0.0f, 0.0f, true), tag, htmlPipelineContext2));
                } catch (NoCustomContextException e3) {
                    throw new RuntimeWorkerException(e3);
                }
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return false;
    }
}
