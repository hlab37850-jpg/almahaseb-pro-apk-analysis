package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.ObjectContext;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.util.ParentTreeUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTagProcessor implements TagProcessor, CssAppliersAware {
    private CssAppliers cssAppliers;
    private List<Tag> tree;
    private Set<String> ignoreDirAttribute = new HashSet<String>() { // from class: com.itextpdf.tool.xml.html.AbstractTagProcessor.1
        {
            add("p");
            add("span");
        }
    };
    private final FontSizeTranslator fontsizeTrans = FontSizeTranslator.getInstance();

    private String getParentDirection() {
        String str = null;
        for (Tag tag : this.tree) {
            if (!this.ignoreDirAttribute.contains(tag.getName().toLowerCase()) && ((str = tag.getAttributes().get(HTML.Attribute.DIR)) != null || (str = tag.getCSS().get(CSS.Property.DIRECTION)) != null)) {
                break;
            }
        }
        return str;
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public List<Element> content(WorkerContext workerContext, Tag tag, String str) {
        return new ArrayList(0);
    }

    public Paragraph createParagraph() {
        return new Paragraph(Float.NaN);
    }

    public List<Element> currentContentToParagraph(List<Element> list, boolean z, boolean z2, Tag tag, WorkerContext workerContext) {
        try {
            int runDirection = getRunDirection(tag);
            ArrayList arrayList = new ArrayList();
            if (list.size() > 0) {
                if (z) {
                    Paragraph paragraphCreateParagraph = createParagraph();
                    paragraphCreateParagraph.setMultipliedLeading(1.2f);
                    for (Element element : list) {
                        if (element instanceof LineSeparator) {
                            try {
                                paragraphCreateParagraph.add(getCssAppliers().apply(new Chunk(Chunk.NEWLINE), tag, getHtmlPipelineContext(workerContext)));
                            } catch (NoCustomContextException e) {
                                throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e);
                            }
                        }
                        paragraphCreateParagraph.add(element);
                    }
                    if (paragraphCreateParagraph.trim()) {
                        if (z2) {
                            paragraphCreateParagraph = (Paragraph) getCssAppliers().apply(paragraphCreateParagraph, tag, getHtmlPipelineContext(workerContext));
                        }
                        if (runDirection == 3) {
                            doRtlIndentCorrections(paragraphCreateParagraph);
                            invertTextAlignForParagraph(paragraphCreateParagraph);
                        }
                        arrayList.add(paragraphCreateParagraph);
                    }
                } else {
                    NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph(Float.NaN);
                    noNewLineParagraph.setMultipliedLeading(1.2f);
                    for (Element element2 : list) {
                        updateParagraphFontIfNeeded(noNewLineParagraph, element2);
                        noNewLineParagraph.add(element2);
                    }
                    NoNewLineParagraph noNewLineParagraph2 = (NoNewLineParagraph) getCssAppliers().apply(noNewLineParagraph, tag, getHtmlPipelineContext(workerContext));
                    if (runDirection == 3) {
                        doRtlIndentCorrections(noNewLineParagraph2);
                        invertTextAlignForParagraph(noNewLineParagraph2);
                    }
                    arrayList.add(noNewLineParagraph2);
                }
            }
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_CUSTOM_CONTEXT), e2);
        }
    }

    public void doRtlIndentCorrections(Indentable indentable) {
        float indentationRight = indentable.getIndentationRight();
        indentable.setIndentationRight(indentable.getIndentationLeft());
        indentable.setIndentationLeft(indentationRight);
    }

    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        return new ArrayList(list);
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public final List<Element> endElement(WorkerContext workerContext, Tag tag, List<Element> list) {
        List<Element> arrayList = new ArrayList<>();
        if (list.isEmpty()) {
            arrayList = end(workerContext, tag, list);
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Element element : list) {
                if (element instanceof Chunk) {
                    Chunk chunk = (Chunk) element;
                    if (chunk.hasAttributes() && chunk.getAttributes().containsKey(Chunk.NEWPAGE)) {
                        if (arrayList2.size() > 0) {
                            arrayList.addAll(end(workerContext, tag, arrayList2));
                            arrayList2.clear();
                        }
                        arrayList.add(element);
                    }
                }
                arrayList2.add(element);
            }
            if (arrayList2.size() > 0) {
                arrayList.addAll(end(workerContext, tag, arrayList2));
                arrayList2.clear();
            }
        }
        String str = tag.getCSS().get(CSS.Property.PAGE_BREAK_AFTER);
        if (str != null && CSS.Value.ALWAYS.equalsIgnoreCase(str)) {
            arrayList.add(Chunk.NEXTPAGE);
        }
        return arrayList;
    }

    public CSSResolver getCSSResolver(WorkerContext workerContext) {
        return (CSSResolver) ((ObjectContext) workerContext.get(CssResolverPipeline.class.getName())).get();
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliersAware
    public CssAppliers getCssAppliers() {
        return this.cssAppliers;
    }

    public HtmlPipelineContext getHtmlPipelineContext(WorkerContext workerContext) {
        return (HtmlPipelineContext) workerContext.get(HtmlPipeline.class.getName());
    }

    public int getRunDirection(Tag tag) {
        boolean z = (tag.getName() == null || this.ignoreDirAttribute.contains(tag.getName().toLowerCase())) ? false : true;
        String parentDirection = z ? tag.getAttributes().get(HTML.Attribute.DIR) : null;
        if (parentDirection == null) {
            if (z) {
                parentDirection = tag.getCSS().get(CSS.Property.DIRECTION);
            }
            if (parentDirection == null) {
                this.tree = new ParentTreeUtil().getParentTagTree(tag, this.tree);
                parentDirection = getParentDirection();
            }
        }
        if (CSS.Value.RTL.equalsIgnoreCase(parentDirection)) {
            return 3;
        }
        if (CSS.Value.LTR.equalsIgnoreCase(parentDirection)) {
            return 2;
        }
        return CSS.Value.AUTO.equalsIgnoreCase(parentDirection) ? 0 : 1;
    }

    public void invertTextAlignForParagraph(Paragraph paragraph) {
        int alignment = paragraph.getAlignment();
        if (alignment == -1 || alignment == 8 || alignment == 1) {
            return;
        }
        if (alignment == 2) {
            paragraph.setAlignment(0);
        } else if (alignment != 3) {
            paragraph.setAlignment(2);
        }
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return false;
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliersAware
    public void setCssAppliers(CssAppliers cssAppliers) {
        this.cssAppliers = cssAppliers;
    }

    public List<Element> start(WorkerContext workerContext, Tag tag) {
        return new ArrayList(0);
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessor
    public final List<Element> startElement(WorkerContext workerContext, Tag tag) {
        float fTranslateFontSize = this.fontsizeTrans.translateFontSize(tag);
        if (fTranslateFontSize != -1.0f) {
            tag.getCSS().put("font-size", fTranslateFontSize + CSS.Value.PT);
        }
        String str = tag.getCSS().get(CSS.Property.PAGE_BREAK_BEFORE);
        if (str == null || !CSS.Value.ALWAYS.equalsIgnoreCase(str)) {
            return start(workerContext, tag);
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(Chunk.NEXTPAGE);
        arrayList.addAll(start(workerContext, tag));
        return arrayList;
    }

    public List<Element> textContent(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> listSanitize = HTMLUtils.sanitize(str, false);
        ArrayList arrayList = new ArrayList(1);
        Iterator<Chunk> it = listSanitize.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(getCssAppliers().apply(it.next(), tag, getHtmlPipelineContext(workerContext)));
            } catch (NoCustomContextException e) {
                throw new RuntimeWorkerException(e);
            }
        }
        return arrayList;
    }

    public void updateParagraphFontIfNeeded(Phrase phrase, Element element) {
        Font font;
        if (element instanceof Chunk) {
            font = ((Chunk) element).getFont();
        } else {
            font = element instanceof Phrase ? ((Phrase) element).getFont() : null;
        }
        float size = phrase.getFont() != null ? phrase.getFont().getSize() : 12.0f;
        if (font == null || font.getSize() <= size) {
            return;
        }
        phrase.setFont(font);
    }

    public void invertTextAlignForParagraph(NoNewLineParagraph noNewLineParagraph) {
        int alignment = noNewLineParagraph.getAlignment();
        if (alignment == -1 || alignment == 8 || alignment == 1) {
            return;
        }
        if (alignment == 2) {
            noNewLineParagraph.setAlignment(0);
        } else if (alignment != 3) {
            noNewLineParagraph.setAlignment(2);
        }
    }

    public final List<Element> currentContentToParagraph(List<Element> list, boolean z) {
        return currentContentToParagraph(list, z, false, null, null);
    }
}
