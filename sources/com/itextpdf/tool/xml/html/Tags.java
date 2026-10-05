package com.itextpdf.tool.xml.html;

/* JADX INFO: loaded from: classes3.dex */
public class Tags {
    private static String defaultpackage = "com.itextpdf.tool.xml.html.";
    private static String dummyTagProcessor = defaultpackage + "DummyTagProcessor";
    private static String headers = defaultpackage + "Header";
    private static String span = defaultpackage + "Span";
    private static String nonSanitized = defaultpackage + "NonSanitizedTag";
    private static String paragraph = defaultpackage + "ParaGraph";

    public static final TagProcessorFactory getHtmlTagProcessorFactory() {
        DefaultTagProcessorFactory defaultTagProcessorFactory = new DefaultTagProcessorFactory();
        defaultTagProcessorFactory.addProcessor(HTML.Tag.XML, dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor("!doctype", dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.HTML, dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.HEAD, dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.META, dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.OBJECT, dummyTagProcessor);
        defaultTagProcessorFactory.addProcessor("title", defaultpackage + "head.Title");
        defaultTagProcessorFactory.addProcessor(HTML.Tag.LINK, defaultpackage + "head.Link");
        defaultTagProcessorFactory.addProcessor("style", defaultpackage + "head.Style");
        defaultTagProcessorFactory.addProcessor("body", defaultpackage + "Body");
        defaultTagProcessorFactory.addProcessor("div", defaultpackage + "Div");
        defaultTagProcessorFactory.addProcessor("a", defaultpackage + "Anchor");
        defaultTagProcessorFactory.addProcessor("table", defaultpackage + "table.Table");
        defaultTagProcessorFactory.addProcessor("tr", defaultpackage + "table.TableRow");
        defaultTagProcessorFactory.addProcessor("td", defaultpackage + "table.TableData");
        defaultTagProcessorFactory.addProcessor("th", defaultpackage + "table.TableData");
        defaultTagProcessorFactory.addProcessor(HTML.Tag.CAPTION, paragraph);
        defaultTagProcessorFactory.addProcessor("p", paragraph);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.DT, paragraph);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.DD, paragraph);
        defaultTagProcessorFactory.addProcessor("blockquote", paragraph);
        defaultTagProcessorFactory.addProcessor("br", defaultpackage + "Break");
        defaultTagProcessorFactory.addProcessor("span", span);
        defaultTagProcessorFactory.addProcessor("small", span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.BIG, span);
        defaultTagProcessorFactory.addProcessor("s", span);
        defaultTagProcessorFactory.addProcessor("strike", span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.DEL, span);
        defaultTagProcessorFactory.addProcessor("sub", span);
        defaultTagProcessorFactory.addProcessor("sup", span);
        defaultTagProcessorFactory.addProcessor("b", span);
        defaultTagProcessorFactory.addProcessor("strong", span);
        defaultTagProcessorFactory.addProcessor("font", span);
        defaultTagProcessorFactory.addProcessor("i", span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.CITE, span);
        defaultTagProcessorFactory.addProcessor("em", span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.ADDRESS, span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.DFN, span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.VAR, span);
        defaultTagProcessorFactory.addProcessor("pre", nonSanitized);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.TT, nonSanitized);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.CODE, nonSanitized);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.KBD, nonSanitized);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.SAMP, nonSanitized);
        defaultTagProcessorFactory.addProcessor("u", span);
        defaultTagProcessorFactory.addProcessor(HTML.Tag.INS, span);
        defaultTagProcessorFactory.addProcessor("img", defaultpackage + "Image");
        defaultTagProcessorFactory.addProcessor("ul", defaultpackage + "OrderedUnorderedList");
        defaultTagProcessorFactory.addProcessor("ol", defaultpackage + "OrderedUnorderedList");
        defaultTagProcessorFactory.addProcessor("li", defaultpackage + "OrderedUnorderedListItem");
        defaultTagProcessorFactory.addProcessor("h1", headers);
        defaultTagProcessorFactory.addProcessor("h2", headers);
        defaultTagProcessorFactory.addProcessor("h3", headers);
        defaultTagProcessorFactory.addProcessor("h4", headers);
        defaultTagProcessorFactory.addProcessor("h5", headers);
        defaultTagProcessorFactory.addProcessor("h6", headers);
        defaultTagProcessorFactory.addProcessor("hr", defaultpackage + "HorizontalRule");
        defaultTagProcessorFactory.addProcessor(HTML.Tag.LABEL, span);
        return defaultTagProcessorFactory;
    }
}
