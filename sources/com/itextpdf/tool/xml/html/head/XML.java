package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class XML extends AbstractTagProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) XML.class);

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> start(WorkerContext workerContext, Tag tag) {
        String str = tag.getAttributes().get(HtmlTags.ENCODING);
        if (str != null) {
            try {
                if (Charset.isSupported(str)) {
                    getHtmlPipelineContext(workerContext).charSet(Charset.forName(str));
                    Logger logger = LOGGER;
                    if (logger.isLogging(Level.DEBUG)) {
                        logger.debug(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.META_CC), str));
                    }
                } else {
                    Logger logger2 = LOGGER;
                    if (logger2.isLogging(Level.DEBUG)) {
                        logger2.debug(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.META_404), getHtmlPipelineContext(workerContext).charSet()));
                    }
                }
            } catch (NoCustomContextException unused) {
                throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT));
            }
        }
        return new ArrayList(0);
    }
}
