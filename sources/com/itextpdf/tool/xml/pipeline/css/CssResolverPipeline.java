package com.itextpdf.tool.xml.pipeline.css;

import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.ObjectContext;

/* JADX INFO: loaded from: classes3.dex */
public class CssResolverPipeline extends AbstractPipeline<ObjectContext<CSSResolver>> {
    public static final String CSS_RESOLVER = "CSS_RESOLVER";
    private CSSResolver resolver;

    public CssResolverPipeline(CSSResolver cSSResolver, Pipeline<?> pipeline) {
        super(pipeline);
        this.resolver = cSSResolver;
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline
    public String getContextKey() {
        return CssResolverPipeline.class.getName();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> init(WorkerContext workerContext) throws PipelineException {
        try {
            workerContext.put(getContextKey(), new ObjectContext(this.resolver.clear()));
            return super.init(workerContext);
        } catch (CssResolverException e) {
            throw new PipelineException(e);
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject) {
        getLocalContext(workerContext).get().resolveStyles(tag);
        return getNext();
    }

    public void setResolver(CSSResolver cSSResolver) {
        this.resolver = cSSResolver;
    }
}
