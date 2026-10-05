package com.itextpdf.text.html.simpleparser;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {
    private static final long serialVersionUID = -959260811961222824L;
    public static final HTMLTagProcessor EM_STRONG_STRIKE_SUP_SUP = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.1
        private String mapTag(String str) {
            if ("em".equalsIgnoreCase(str)) {
                return "i";
            }
            if ("strong".equalsIgnoreCase(str)) {
                return "b";
            }
            return "strike".equalsIgnoreCase(str) ? "s" : str;
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(mapTag(str));
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            String strMapTag = mapTag(str);
            map.put(strMapTag, null);
            hTMLWorker.updateChain(strMapTag, map);
        }
    };
    public static final HTMLTagProcessor A = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.2
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.processLink();
            hTMLWorker.updateChain(str);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.flushContent();
        }
    };
    public static final HTMLTagProcessor BR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.3
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.newLine();
        }
    };
    public static final HTMLTagProcessor UL_OL = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.4
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement("li");
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processList();
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement("li");
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createList(str));
        }
    };
    public static final HTMLTagProcessor HR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.5
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(hTMLWorker.createLineSeparator(map));
        }
    };
    public static final HTMLTagProcessor SPAN = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.6
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(str);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
        }
    };
    public static final HTMLTagProcessor H = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.7
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (!map.containsKey("size")) {
                map.put("size", Integer.toString(7 - Integer.parseInt(str.substring(1))));
            }
            hTMLWorker.updateChain(str, map);
        }
    };
    public static final HTMLTagProcessor LI = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.8
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingLI(false);
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str);
            hTMLWorker.processListItem();
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingLI(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createListItem());
        }
    };
    public static final HTMLTagProcessor PRE = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.9
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
            hTMLWorker.setInsidePRE(false);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (!map.containsKey("face")) {
                map.put("face", "Courier");
            }
            hTMLWorker.updateChain(str, map);
            hTMLWorker.setInsidePRE(true);
        }
    };
    public static final HTMLTagProcessor DIV = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.10
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str, map);
        }
    };
    public static final HTMLTagProcessor TABLE = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.11
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement("tr");
            }
            hTMLWorker.updateChain(str);
            hTMLWorker.processTable();
            hTMLWorker.popTableState();
            hTMLWorker.setSkipText(false);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(new TableWrapper(map));
            hTMLWorker.pushTableState();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.setPendingTR(false);
            hTMLWorker.setSkipText(true);
            map.remove("align");
            map.put("colspan", "1");
            map.put("rowspan", "1");
            hTMLWorker.updateChain(str, map);
        }
    };
    public static final HTMLTagProcessor TR = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.12
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement("td");
            }
            hTMLWorker.setPendingTR(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processRow();
            hTMLWorker.setSkipText(true);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.setPendingTR(true);
            hTMLWorker.updateChain(str, map);
        }
    };
    public static final HTMLTagProcessor TD = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.13
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.updateChain("td");
            hTMLWorker.setSkipText(true);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingTD(true);
            hTMLWorker.updateChain("td", map);
            hTMLWorker.pushToStack(hTMLWorker.createCell(str));
        }
    };
    public static final HTMLTagProcessor IMG = new HTMLTagProcessor() { // from class: com.itextpdf.text.html.simpleparser.HTMLTagProcessors.14
        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.processImage(hTMLWorker.createImage(map), map);
            hTMLWorker.updateChain(str);
        }
    };

    public HTMLTagProcessors() {
        put("a", A);
        HTMLTagProcessor hTMLTagProcessor = EM_STRONG_STRIKE_SUP_SUP;
        put("b", hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor2 = DIV;
        put("body", hTMLTagProcessor2);
        put("br", BR);
        put("div", hTMLTagProcessor2);
        put("em", hTMLTagProcessor);
        HTMLTagProcessor hTMLTagProcessor3 = SPAN;
        put("font", hTMLTagProcessor3);
        HTMLTagProcessor hTMLTagProcessor4 = H;
        put("h1", hTMLTagProcessor4);
        put("h2", hTMLTagProcessor4);
        put("h3", hTMLTagProcessor4);
        put("h4", hTMLTagProcessor4);
        put("h5", hTMLTagProcessor4);
        put("h6", hTMLTagProcessor4);
        put("hr", HR);
        put("i", hTMLTagProcessor);
        put("img", IMG);
        put("li", LI);
        HTMLTagProcessor hTMLTagProcessor5 = UL_OL;
        put("ol", hTMLTagProcessor5);
        put("p", hTMLTagProcessor2);
        put("pre", PRE);
        put("s", hTMLTagProcessor);
        put("span", hTMLTagProcessor3);
        put("strike", hTMLTagProcessor);
        put("strong", hTMLTagProcessor);
        put("sub", hTMLTagProcessor);
        put("sup", hTMLTagProcessor);
        put("table", TABLE);
        HTMLTagProcessor hTMLTagProcessor6 = TD;
        put("td", hTMLTagProcessor6);
        put("th", hTMLTagProcessor6);
        put("tr", TR);
        put("u", hTMLTagProcessor);
        put("ul", hTMLTagProcessor5);
    }
}
