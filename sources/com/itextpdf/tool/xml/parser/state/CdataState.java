package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class CdataState implements State {
    private final XMLParser parser;

    public CdataState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c != '>' || !"]]".equals(this.parser.memory().comment().toString())) {
            if (c == ']') {
                this.parser.memory().comment().append(c);
                return;
            } else {
                this.parser.append(c);
                this.parser.memory().comment().setLength(0);
                return;
            }
        }
        this.parser.memory().comment().setLength(0);
        this.parser.text("<![CDATA[" + this.parser.bufferToString() + "]]>");
        this.parser.flush();
        this.parser.selectState().inTag();
    }
}
