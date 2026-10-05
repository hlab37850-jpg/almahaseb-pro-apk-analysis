package com.itextpdf.tool.xml.html.head;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Meta extends AbstractTagProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Meta.class);

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> start(WorkerContext workerContext, Tag tag) {
        String str;
        if (tag.getAttributes().get("http-equiv") != null && HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(tag.getAttributes().get("http-equiv")) && (str = tag.getAttributes().get(Annotation.CONTENT)) != null) {
            for (String str2 : str.split(";")) {
                if (str2.contains("charset")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length > 1) {
                        String str3 = strArrSplit[1];
                        try {
                            if (Charset.isSupported(str3)) {
                                getHtmlPipelineContext(workerContext).charSet(Charset.forName(str3));
                                Logger logger = LOGGER;
                                if (logger.isLogging(Level.DEBUG)) {
                                    logger.debug(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.META_CC), str3));
                                }
                            } else {
                                Logger logger2 = LOGGER;
                                if (logger2.isLogging(Level.DEBUG)) {
                                    logger2.debug(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.META_404), getHtmlPipelineContext(workerContext).charSet()));
                                }
                            }
                        } catch (NoCustomContextException e) {
                            LOGGER.error("", e);
                        }
                    }
                }
            }
        }
        return new ArrayList(0);
    }
}
