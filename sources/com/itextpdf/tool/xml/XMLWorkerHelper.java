package com.itextpdf.tool.xml;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.css.CSSFileWrapper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.CssFileProcessor;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.ElementHandlerPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class XMLWorkerHelper {
    private static XMLWorkerHelper myself = new XMLWorkerHelper();
    private CssFile defaultCssFile;
    private TagProcessorFactory tpf;

    private XMLWorkerHelper() {
    }

    public static synchronized CssFile getCSS(InputStream inputStream) {
        CSSFileWrapper cSSFileWrapper;
        if (inputStream != null) {
            CssFileProcessor cssFileProcessor = new CssFileProcessor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                try {
                    char[] cArr = new char[8192];
                    while (true) {
                        int i = bufferedReader.read(cArr);
                        if (i <= 0) {
                            break;
                        }
                        for (int i2 = 0; i2 < i; i2++) {
                            cssFileProcessor.process(cArr[i2]);
                        }
                        throw th;
                    }
                    cSSFileWrapper = new CSSFileWrapper(cssFileProcessor.getCss(), true);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeWorkerException(e);
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e2) {
                        throw new RuntimeWorkerException(e2);
                    }
                }
            } catch (IOException e3) {
                throw new RuntimeWorkerException(e3);
            }
        } else {
            cSSFileWrapper = null;
        }
        return cSSFileWrapper;
    }

    public static synchronized XMLWorkerHelper getInstance() {
        return myself;
    }

    public static ElementList parseToElementList(String str, String str2) throws IOException {
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver();
        if (str2 != null) {
            styleAttrCSSResolver.addCss(getCSS(new ByteArrayInputStream(str2.getBytes())));
        }
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(new CssAppliersImpl(FontFactory.getFontImp()));
        htmlPipelineContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        htmlPipelineContext.autoBookmark(false);
        ElementList elementList = new ElementList();
        new XMLParser(new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementList, null))), true)).parse(new ByteArrayInputStream(str.getBytes()));
        return elementList;
    }

    public synchronized CssFile getDefaultCSS() {
        try {
            if (this.defaultCssFile == null) {
                this.defaultCssFile = getCSS(XMLWorkerHelper.class.getResourceAsStream("/default.css"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.defaultCssFile;
    }

    public CSSResolver getDefaultCssResolver(boolean z) {
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver();
        if (z) {
            styleAttrCSSResolver.addCss(getDefaultCSS());
        }
        return styleAttrCSSResolver;
    }

    public synchronized TagProcessorFactory getDefaultTagProcessorFactory() {
        try {
            if (this.tpf == null) {
                this.tpf = Tags.getHtmlTagProcessorFactory();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.tpf;
    }

    public void parseXHtml(ElementHandler elementHandler, Reader reader) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.add(getDefaultCSS());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(null);
        htmlPipelineContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(getDefaultTagProcessorFactory());
        XMLWorker xMLWorker = new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementHandler, null))), true);
        XMLParser xMLParser = new XMLParser();
        xMLParser.addListener(xMLWorker);
        xMLParser.parse(reader);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, Reader reader) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.add(getDefaultCSS());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(null);
        htmlPipelineContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(getDefaultTagProcessorFactory());
        XMLWorker xMLWorker = new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new PdfWriterPipeline(document, pdfWriter))), true);
        XMLParser xMLParser = new XMLParser();
        xMLParser.addListener(xMLWorker);
        xMLParser.parse(reader);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), null, new XMLWorkerFontProvider());
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, Charset charset, FontProvider fontProvider) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), charset, fontProvider);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, Charset charset) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), charset);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset, FontProvider fontProvider) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, inputStream2, charset, fontProvider, null);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset, FontProvider fontProvider, String str) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        if (inputStream2 != null) {
            cssFilesImpl.add(getCSS(inputStream2));
        } else {
            cssFilesImpl.add(getDefaultCSS());
        }
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(new CssAppliersImpl(fontProvider));
        htmlPipelineContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(getDefaultTagProcessorFactory()).setResourcesRootPath(str);
        XMLParser xMLParser = new XMLParser(true, new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new PdfWriterPipeline(document, pdfWriter))), true), charset);
        if (charset != null) {
            xMLParser.parse(inputStream, charset);
        } else {
            xMLParser.parse(inputStream);
        }
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, inputStream2, null, new XMLWorkerFontProvider());
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, FontProvider fontProvider) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, inputStream2, null, fontProvider);
    }

    public void parseXHtml(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset) throws IOException {
        parseXHtml(pdfWriter, document, inputStream, inputStream2, charset, new XMLWorkerFontProvider());
    }

    public void parseXHtml(ElementHandler elementHandler, InputStream inputStream, Charset charset) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.add(getDefaultCSS());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(null);
        htmlPipelineContext.setAcceptUnknown(true).autoBookmark(true).setTagFactory(getDefaultTagProcessorFactory());
        XMLParser xMLParser = new XMLParser(true, new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementHandler, null))), true), charset);
        if (charset != null) {
            xMLParser.parse(inputStream, charset);
        } else {
            xMLParser.parse(inputStream);
        }
    }
}
