package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class SelfClosingTagState implements State {
    private final XMLParser parser;

    public SelfClosingTagState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '>') {
            this.parser.startElement();
            this.parser.endElement();
            this.parser.flush();
            this.parser.memory().flushNameSpace();
            this.parser.selectState().inTag();
        }
    }
}
