package com.itextpdf.tool.xml.pipeline;

import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractPipeline<T extends CustomContext> implements Pipeline<T> {
    private Pipeline<?> next;

    public AbstractPipeline(Pipeline<?> pipeline) {
        setNext(pipeline);
    }

    @Override // com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> close(WorkerContext workerContext, Tag tag, ProcessObject processObject) {
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> content(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) {
        return getNext();
    }

    public String getContextKey() {
        return getClass().getName();
    }

    public T getLocalContext(WorkerContext workerContext) throws PipelineException {
        try {
            T t = (T) workerContext.get(getContextKey());
            if (t != null) {
                return t;
            }
            throw new PipelineException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.OWN_CONTEXT_404), getClass().getName()));
        } catch (NoCustomContextException e) {
            throw new PipelineException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.OWN_CONTEXT_404), getClass().getName()), e);
        }
    }

    @Override // com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> getNext() {
        return this.next;
    }

    @Override // com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> init(WorkerContext workerContext) {
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject) {
        return getNext();
    }

    public void setNext(Pipeline<?> pipeline) {
        this.next = pipeline;
    }
}
