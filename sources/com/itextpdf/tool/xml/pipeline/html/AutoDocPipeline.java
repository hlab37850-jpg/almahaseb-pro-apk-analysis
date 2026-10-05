package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;
import com.itextpdf.tool.xml.pipeline.ctx.WorkerContextImpl;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AutoDocPipeline extends AbstractPipeline {
    private final FileMaker fm;
    private final String opentag;
    private final Rectangle pagesize;
    private final String tag;

    public AutoDocPipeline(FileMaker fileMaker, String str, String str2, Rectangle rectangle) {
        super(null);
        this.fm = fileMaker;
        this.tag = str;
        this.opentag = str2;
        this.pagesize = rectangle;
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> close(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        if (this.tag.equals(tag.getName())) {
            try {
                ((Document) ((MapContext) workerContext.get(PdfWriterPipeline.class.getName())).get(PdfWriterPipeline.DOCUMENT)).close();
                try {
                    HtmlPipelineContext htmlPipelineContextM5458clone = ((HtmlPipelineContext) workerContext.get(HtmlPipeline.class.getName())).m5458clone();
                    htmlPipelineContextM5458clone.setPageSize(this.pagesize);
                    ((WorkerContextImpl) workerContext).put(HtmlPipeline.class.getName(), htmlPipelineContextM5458clone);
                } catch (NoCustomContextException | CloneNotSupportedException unused) {
                }
            } catch (NoCustomContextException e) {
                throw new PipelineException("AutoDocPipeline depends on PdfWriterPipeline.", e);
            }
        }
        return getNext();
    }

    @Override // com.itextpdf.tool.xml.pipeline.AbstractPipeline, com.itextpdf.tool.xml.Pipeline
    public Pipeline<?> open(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        try {
            if (this.tag.equals(tag.getName())) {
                MapContext mapContext = (MapContext) workerContext.get(PdfWriterPipeline.class.getName());
                Document document = new Document(this.pagesize);
                try {
                    OutputStream stream = this.fm.getStream();
                    mapContext.put(PdfWriterPipeline.DOCUMENT, document);
                    mapContext.put(PdfWriterPipeline.WRITER, PdfWriter.getInstance(document, stream));
                } catch (DocumentException e) {
                    throw new PipelineException(e);
                } catch (IOException e2) {
                    throw new PipelineException(e2);
                }
            }
            if (tag.getName().equalsIgnoreCase(this.opentag)) {
                Document document2 = (Document) ((MapContext) workerContext.get(PdfWriterPipeline.class.getName())).get(PdfWriterPipeline.DOCUMENT);
                CssUtils cssUtils = CssUtils.getInstance();
                float width = document2.getPageSize().getWidth();
                float valueToPt = 0.0f;
                float valueToPt2 = 0.0f;
                float valueToPt3 = 0.0f;
                float valueToPt4 = 0.0f;
                for (Map.Entry<String, String> entry : tag.getCSS().entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key.equalsIgnoreCase(CSS.Property.MARGIN_LEFT)) {
                        valueToPt = cssUtils.parseValueToPt(value, width);
                    } else if (key.equalsIgnoreCase(CSS.Property.MARGIN_RIGHT)) {
                        valueToPt2 = cssUtils.parseValueToPt(value, width);
                    } else if (key.equalsIgnoreCase(CSS.Property.MARGIN_TOP)) {
                        valueToPt3 = cssUtils.parseValueToPt(value, width);
                    } else if (key.equalsIgnoreCase(CSS.Property.MARGIN_BOTTOM)) {
                        valueToPt4 = cssUtils.parseValueToPt(value, width);
                    }
                }
                document2.setMargins(valueToPt, valueToPt2, valueToPt3, valueToPt4);
                document2.open();
            }
            return getNext();
        } catch (NoCustomContextException e3) {
            throw new PipelineException(LocaleMessages.getInstance().getMessage(LocaleMessages.PIPELINE_AUTODOC), e3);
        }
    }
}
