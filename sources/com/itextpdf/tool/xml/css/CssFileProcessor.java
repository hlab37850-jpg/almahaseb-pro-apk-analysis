package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.net.ReadingProcessor;

/* JADX INFO: loaded from: classes3.dex */
public class CssFileProcessor implements ReadingProcessor {
    private final CssStateController controller;
    private final CssFile css;

    public CssFileProcessor() {
        CssFileImpl cssFileImpl = new CssFileImpl();
        this.css = cssFileImpl;
        this.controller = new CssStateController(cssFileImpl);
    }

    public CssFile getCss() {
        return this.css;
    }

    @Override // com.itextpdf.tool.xml.net.ReadingProcessor
    public void process(int i) {
        this.controller.process((char) i);
    }
}
