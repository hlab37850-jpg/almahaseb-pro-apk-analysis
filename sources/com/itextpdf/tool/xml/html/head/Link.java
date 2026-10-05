package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Link extends AbstractTagProcessor {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Link.class);

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> start(WorkerContext workerContext, Tag tag) {
        String str;
        if (HTML.Attribute.Value.TEXTCSS.equalsIgnoreCase(tag.getAttributes().get("type")) && (str = tag.getAttributes().get("href")) != null) {
            try {
                getCSSResolver(workerContext).addCssFile(str, false);
            } catch (NoCustomContextException unused) {
                LOG.warn(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.CUSTOMCONTEXT_404_CONTINUE), CssResolverPipeline.class.getName()));
            } catch (CssResolverException e) {
                LOG.error(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.LINK_404), str), e);
            }
        }
        return new ArrayList(0);
    }
}
