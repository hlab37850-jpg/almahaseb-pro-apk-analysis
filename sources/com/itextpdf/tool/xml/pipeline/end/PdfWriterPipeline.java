package com.itextpdf.tool.xml.pipeline.end;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;

/* JADX INFO: loaded from: classes3.dex */
public class PdfWriterPipeline extends AbstractPipeline<MapContext> {
    public static final String CONTINUOUS = "CONTINUOUS";
    public static final String DOCUMENT = "DOCUMENT";
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) PdfWriterPipeline.class);
    public static final String WRITER = "WRITER";
    private Boolean continiously;
    private Document doc;
    private PdfWriter writer;

    public PdfWriterPipeline() {
        super(null);
    }

    private void write(WorkerContext workerContext, ProcessObject processObject) throws PipelineException {
        MapContext localContext = getLocalContext(workerContext);
        if (!processObject.containsWritable()) {
            return;
        }
        Document document = (Document) localContext.get(DOCUMENT);
        boolean zBooleanValue = ((Boolean) localContext.get(CONTINUOUS)).booleanValue();
        while (true) {
            Writable writablePoll = processObject.poll();
            if (writablePoll == null) {
                return;
            }
            if (writablePoll instanceof WritableElement) {
                for (Element element : ((WritableElement) writablePoll).elements()) {
                    try {
                        if (!document.add(element)) {
                            LOG.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.ELEMENT_NOT_ADDED), element.toString()));
                        }
                    } catch (DocumentException e) {
                        if (!zBooleanValue) {
                            throw new PipelineException(e);
                        }
                        LOG.error(LocaleMessages.getInstance().getMessage(LocaleMessages.ELEMENT_NOT_ADDED_EXC), e);
                    }
                }
            }
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> close(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        write(workerContext, processObject);
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> content(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        write(workerContext, processObject);
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> init(WorkerContext workerContext) {
        MapContext mapContext = new MapContext();
        Boolean bool = Boolean.TRUE;
        this.continiously = bool;
        mapContext.put(CONTINUOUS, bool);
        Document document = this.doc;
        if (document != null) {
            mapContext.put(DOCUMENT, document);
        }
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null) {
            mapContext.put(WRITER, pdfWriter);
        }
        workerContext.put(getContextKey(), mapContext);
        return super.init(workerContext);
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        write(workerContext, processObject);
        return getNext();
    }

    public void setDocument(Document document) {
        this.doc = document;
    }

    public void setWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public PdfWriterPipeline(Pipeline<?> pipeline) {
        super(pipeline);
    }

    public PdfWriterPipeline(Document document, PdfWriter pdfWriter) {
        super(null);
        this.doc = document;
        this.writer = pdfWriter;
        this.continiously = Boolean.TRUE;
    }
}
