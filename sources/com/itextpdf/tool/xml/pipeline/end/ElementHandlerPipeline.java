package com.itextpdf.tool.xml.pipeline.end;

import com.itextpdf.tool.xml.ElementHandler;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;

/* JADX INFO: loaded from: classes3.dex */
public class ElementHandlerPipeline extends AbstractPipeline {
    private final ElementHandler handler;

    public ElementHandlerPipeline(ElementHandler elementHandler, Pipeline pipeline) {
        super(pipeline);
        this.handler = elementHandler;
    }

    private void consume(ProcessObject processObject) {
        if (!processObject.containsWritable()) {
            return;
        }
        while (true) {
            Writable writablePoll = processObject.poll();
            if (writablePoll == null) {
                return;
            } else {
                this.handler.add(writablePoll);
            }
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline close(WorkerContext workerContext, Tag tag, ProcessObject processObject) {
        consume(processObject);
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> content(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) {
        consume(processObject);
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline open(WorkerContext workerContext, Tag tag, ProcessObject processObject) {
        consume(processObject);
        return getNext();
    }
}
