package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoTagProcessorException;
import com.itextpdf.tool.xml.html.TagProcessor;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HtmlPipeline extends AbstractPipeline<HtmlPipelineContext> {
    private final HtmlPipelineContext hpc;

    public HtmlPipeline(HtmlPipelineContext htmlPipelineContext, Pipeline<?> pipeline) {
        super(pipeline);
        this.hpc = htmlPipelineContext;
    }

    public void addStackKeeper(Tag tag, HtmlPipelineContext htmlPipelineContext, TagProcessor tagProcessor) {
        if (tagProcessor.isStackOwner()) {
            htmlPipelineContext.addFirst(new StackKeeper(tag));
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> close(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        List<Element> listEndElement;
        HtmlPipelineContext localContext = getLocalContext(workerContext);
        try {
            if (tag.getLastMarginBottom() != null) {
                localContext.getMemory().put(HtmlPipelineContext.LAST_MARGIN_BOTTOM, tag.getLastMarginBottom());
            } else {
                localContext.getMemory().remove(HtmlPipelineContext.LAST_MARGIN_BOTTOM);
            }
            TagProcessor tagProcessorResolveProcessor = localContext.resolveProcessor(tag.getName(), tag.getNameSpace());
            if (tagProcessorResolveProcessor.isStackOwner()) {
                try {
                    listEndElement = tagProcessorResolveProcessor.endElement(workerContext, tag, localContext.poll().getElements());
                } catch (NoStackException e) {
                    throw new PipelineException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.STACK_404), tag.toString()), e);
                }
            } else {
                listEndElement = tagProcessorResolveProcessor.endElement(workerContext, tag, localContext.currentContent());
                localContext.currentContent().clear();
            }
            if (listEndElement.size() > 0) {
                StackKeeper stackKeeperPeek = localContext.peek();
                if (stackKeeperPeek != null) {
                    Iterator<Element> it = listEndElement.iterator();
                    while (it.hasNext()) {
                        stackKeeperPeek.add(it.next());
                    }
                } else {
                    WritableElement writableElement = new WritableElement();
                    processObject.add(writableElement);
                    writableElement.addAll(listEndElement);
                }
            }
        } catch (NoTagProcessorException e2) {
            if (!localContext.acceptUnknown()) {
                throw e2;
            }
        }
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> content(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        HtmlPipelineContext localContext = getLocalContext(workerContext);
        try {
            List<Element> listContent = localContext.resolveProcessor(tag.getName(), tag.getNameSpace()).content(workerContext, tag, str);
            if (listContent.size() > 0) {
                StackKeeper stackKeeperPeek = localContext.peek();
                if (stackKeeperPeek != null) {
                    Iterator<Element> it = listContent.iterator();
                    while (it.hasNext()) {
                        stackKeeperPeek.add(it.next());
                    }
                } else {
                    WritableElement writableElement = new WritableElement();
                    Iterator<Element> it2 = listContent.iterator();
                    while (it2.hasNext()) {
                        writableElement.add(it2.next());
                    }
                    processObject.add(writableElement);
                }
            }
        } catch (NoTagProcessorException e) {
            if (!localContext.acceptUnknown()) {
                throw e;
            }
        }
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline
    public String getContextKey() {
        return HtmlPipeline.class.getName();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> init(WorkerContext workerContext) throws PipelineException {
        try {
            workerContext.put(getContextKey(), this.hpc.m5458clone());
            return getNext();
        } catch (CloneNotSupportedException e) {
            throw new PipelineException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.UNSUPPORTED_CLONING), this.hpc.getClass().toString()), e);
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        HtmlPipelineContext localContext = getLocalContext(workerContext);
        try {
            tag.setLastMarginBottom(localContext.getMemory().get(HtmlPipelineContext.LAST_MARGIN_BOTTOM));
            localContext.getMemory().remove(HtmlPipelineContext.LAST_MARGIN_BOTTOM);
            TagProcessor tagProcessorResolveProcessor = localContext.resolveProcessor(tag.getName(), tag.getNameSpace());
            addStackKeeper(tag, localContext, tagProcessorResolveProcessor);
            List<Element> listStartElement = tagProcessorResolveProcessor.startElement(workerContext, tag);
            if (listStartElement.size() > 0) {
                if (tagProcessorResolveProcessor.isStackOwner()) {
                    StackKeeper stackKeeperPeek = localContext.peek();
                    if (stackKeeperPeek == null) {
                        throw new PipelineException(String.format(LocaleMessages.STACK_404, tag.toString()));
                    }
                    Iterator<Element> it = listStartElement.iterator();
                    while (it.hasNext()) {
                        stackKeeperPeek.add(it.next());
                    }
                } else {
                    for (Element element : listStartElement) {
                        localContext.currentContent().add(element);
                        if (element.type() == 38) {
                            WritableElement writableElement = new WritableElement();
                            writableElement.add(element);
                            processObject.add(writableElement);
                            localContext.currentContent().remove(element);
                        }
                    }
                }
            }
        } catch (NoTagProcessorException e) {
            if (!localContext.acceptUnknown()) {
                throw e;
            }
        }
        return getNext();
    }
}
