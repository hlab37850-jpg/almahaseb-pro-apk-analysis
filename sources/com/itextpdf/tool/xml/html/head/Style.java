package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Style extends AbstractTagProcessor {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Style.class);

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        try {
            getCSSResolver(workerContext).addCss(str, false);
        } catch (NoCustomContextException unused) {
            LOG.warn(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.CUSTOMCONTEXT_404_CONTINUE), CssResolverPipeline.class.getName()));
        } catch (CssResolverException e) {
            Logger logger = LOG;
            logger.error(LocaleMessages.getInstance().getMessage(LocaleMessages.STYLE_NOTPARSED), e);
            if (logger.isLogging(Level.TRACE)) {
                logger.trace(str);
            }
        }
        return new ArrayList(0);
    }
}
