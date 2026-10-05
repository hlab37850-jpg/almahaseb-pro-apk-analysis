package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.ChunkCssApplier;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

/* JADX INFO: loaded from: classes3.dex */
public interface CssAppliers {
    Element apply(Element element, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext);

    Element apply(Element element, Tag tag, HtmlPipelineContext htmlPipelineContext);

    CssAppliers clone();

    ChunkCssApplier getChunkCssAplier();

    void setChunkCssAplier(ChunkCssApplier chunkCssApplier);
}
