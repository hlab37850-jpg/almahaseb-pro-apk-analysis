package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.exceptions.NoDataException;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersAware;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.TagProcessor;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class HtmlPipelineContext implements CustomContext, Cloneable, MarginMemory, PageSizeContainable, CssAppliersAware {
    public static final String BOOKMARK_TREE = "header.autobookmark.RootNode";
    public static final String LAST_MARGIN_BOTTOM = "lastMarginBottom";
    private Charset charset;
    private CssAppliers cssAppliers;
    private ImageProvider imageProvider;
    private LinkProvider linkprovider;
    private String resourcesRootPath;
    private TagProcessorFactory tagFactory;
    private boolean acceptUnknown = true;
    private final List<Element> ctn = new ArrayList();
    private Rectangle pageSize = PageSize.A4;
    private List<String> roottags = Arrays.asList("body", "div");
    private boolean autoBookmark = true;
    private final LinkedList<StackKeeper> queue = new LinkedList<>();
    private final Map<String, Object> memory = new HashMap();

    public HtmlPipelineContext(CssAppliers cssAppliers) {
        this.cssAppliers = cssAppliers;
        if (cssAppliers == null) {
            this.cssAppliers = new CssAppliersImpl(new XMLWorkerFontProvider());
        }
    }

    public boolean acceptUnknown() {
        return this.acceptUnknown;
    }

    public void addFirst(StackKeeper stackKeeper) {
        this.queue.addFirst(stackKeeper);
    }

    public boolean autoBookmark() {
        return this.autoBookmark;
    }

    public HtmlPipelineContext charSet(Charset charset) {
        this.charset = charset;
        return this;
    }

    public List<Element> currentContent() {
        return this.ctn;
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliersAware
    public CssAppliers getCssAppliers() {
        return this.cssAppliers;
    }

    public ImageProvider getImageProvider() {
        return this.imageProvider;
    }

    @Override // com.itextpdf.tool.xml.css.apply.MarginMemory
    public Float getLastMarginBottom() throws NoDataException {
        Object obj = getMemory().get(LAST_MARGIN_BOTTOM);
        if (obj != null) {
            return (Float) obj;
        }
        throw new NoDataException();
    }

    public LinkProvider getLinkProvider() {
        return this.linkprovider;
    }

    public Map<String, Object> getMemory() {
        return this.memory;
    }

    @Override // com.itextpdf.tool.xml.css.apply.PageSizeContainable
    public Rectangle getPageSize() {
        return this.pageSize;
    }

    public String getResourcesRootPath() {
        return this.resourcesRootPath;
    }

    @Override // com.itextpdf.tool.xml.css.apply.MarginMemory
    public List<String> getRootTags() {
        return this.roottags;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public StackKeeper peek() {
        if (this.queue.isEmpty()) {
            return null;
        }
        return this.queue.getFirst();
    }

    public StackKeeper poll() throws NoStackException {
        try {
            return this.queue.removeFirst();
        } catch (NoSuchElementException unused) {
            throw new NoStackException();
        }
    }

    public TagProcessor resolveProcessor(String str, String str2) {
        TagProcessor processor = this.tagFactory.getProcessor(str, str2);
        if (processor instanceof CssAppliersAware) {
            ((CssAppliersAware) processor).setCssAppliers(this.cssAppliers);
        }
        return processor;
    }

    public HtmlPipelineContext setAcceptUnknown(boolean z) {
        this.acceptUnknown = z;
        return this;
    }

    public HtmlPipelineContext setCssApplier(CssAppliers cssAppliers) {
        this.cssAppliers = cssAppliers;
        return this;
    }

    @Override // com.itextpdf.tool.xml.html.CssAppliersAware
    public void setCssAppliers(CssAppliers cssAppliers) {
        this.cssAppliers = cssAppliers;
    }

    public HtmlPipelineContext setImageProvider(ImageProvider imageProvider) {
        this.imageProvider = imageProvider;
        return this;
    }

    @Override // com.itextpdf.tool.xml.css.apply.MarginMemory
    public void setLastMarginBottom(Float f) {
        getMemory().put(LAST_MARGIN_BOTTOM, f);
    }

    public HtmlPipelineContext setLinkProvider(LinkProvider linkProvider) {
        this.linkprovider = linkProvider;
        return this;
    }

    public HtmlPipelineContext setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        return this;
    }

    public void setResourcesRootPath(String str) {
        this.resourcesRootPath = str;
    }

    public HtmlPipelineContext setRootTags(List<String> list) {
        this.roottags = list;
        return this;
    }

    public HtmlPipelineContext setTagFactory(TagProcessorFactory tagProcessorFactory) {
        this.tagFactory = tagProcessorFactory;
        return this;
    }

    public HtmlPipelineContext autoBookmark(boolean z) {
        this.autoBookmark = z;
        return this;
    }

    public Charset charSet() {
        return this.charset;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HtmlPipelineContext m5458clone() {
        CssAppliers cssAppliersClone = this.cssAppliers.m5457clone();
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(cssAppliersClone);
        ImageProvider imageProvider = this.imageProvider;
        if (imageProvider != null) {
            htmlPipelineContext.setImageProvider(imageProvider);
        }
        String str = this.resourcesRootPath;
        if (str != null) {
            htmlPipelineContext.setResourcesRootPath(str);
        }
        Charset charset = this.charset;
        if (charset != null) {
            htmlPipelineContext.charSet(Charset.forName(charset.name()));
        }
        htmlPipelineContext.setPageSize(new Rectangle(this.pageSize)).setLinkProvider(this.linkprovider).setRootTags(new ArrayList(this.roottags)).autoBookmark(this.autoBookmark).setTagFactory(this.tagFactory).setAcceptUnknown(this.acceptUnknown).setCssApplier(cssAppliersClone);
        return htmlPipelineContext;
    }
}
