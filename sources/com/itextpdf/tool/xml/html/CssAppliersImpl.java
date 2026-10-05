package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.ChunkCssApplier;
import com.itextpdf.tool.xml.css.apply.DivCssApplier;
import com.itextpdf.tool.xml.css.apply.HtmlCellCssApplier;
import com.itextpdf.tool.xml.css.apply.ImageCssApplier;
import com.itextpdf.tool.xml.css.apply.LineSeparatorCssApplier;
import com.itextpdf.tool.xml.css.apply.ListStyleTypeCssApplier;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.NoNewLineParagraphCssApplier;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.css.apply.ParagraphCssApplier;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CssAppliersImpl implements CssAppliers {
    private Map<Class<?>, CssApplier<? extends Element>> map;

    public CssAppliersImpl() {
        HashMap map = new HashMap();
        this.map = map;
        map.put(Chunk.class, new ChunkCssApplier(null));
        this.map.put(Paragraph.class, new ParagraphCssApplier(this));
        this.map.put(NoNewLineParagraph.class, new NoNewLineParagraphCssApplier());
        this.map.put(HtmlCell.class, new HtmlCellCssApplier());
        this.map.put(List.class, new ListStyleTypeCssApplier());
        this.map.put(LineSeparator.class, new LineSeparatorCssApplier());
        this.map.put(com.itextpdf.text.Image.class, new ImageCssApplier());
        this.map.put(PdfDiv.class, new DivCssApplier());
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliers
    public Element apply(Element element, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        CssApplier<? extends Element> value;
        Iterator<Map.Entry<Class<?>, CssApplier<? extends Element>>> it = this.map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                value = null;
                break;
            }
            Map.Entry<Class<?>, CssApplier<? extends Element>> next = it.next();
            if (next.getKey().isInstance(element)) {
                value = next.getValue();
                break;
            }
        }
        CssApplier<? extends Element> cssApplier = value;
        if (cssApplier != null) {
            return cssApplier.apply(element, tag, marginMemory, pageSizeContainable, htmlPipelineContext);
        }
        throw new RuntimeException();
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliers
    public ChunkCssApplier getChunkCssAplier() {
        return (ChunkCssApplier) this.map.get(Chunk.class);
    }

    public CssAppliersImpl getClonedObject() {
        return new CssAppliersImpl();
    }

    public CssApplier getCssApplier(Class<?> cls) {
        return this.map.get(cls);
    }

    public void putCssApplier(Class<?> cls, CssApplier cssApplier) {
        this.map.put(cls, cssApplier);
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliers
    public void setChunkCssAplier(ChunkCssApplier chunkCssApplier) {
        this.map.put(Chunk.class, chunkCssApplier);
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliers
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CssAppliers m5457clone() {
        CssAppliersImpl clonedObject = getClonedObject();
        clonedObject.map = new HashMap(this.map);
        return clonedObject;
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliers
    public Element apply(Element element, Tag tag, HtmlPipelineContext htmlPipelineContext) {
        return apply(element, tag, htmlPipelineContext, htmlPipelineContext, htmlPipelineContext);
    }

    public CssAppliersImpl(FontProvider fontProvider) {
        this();
        ((ChunkCssApplier) this.map.get(Chunk.class)).setFontProvider(fontProvider);
    }
}
