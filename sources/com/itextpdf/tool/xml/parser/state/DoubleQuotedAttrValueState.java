package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class DoubleQuotedAttrValueState implements State {
    private final XMLParser parser;

    public DoubleQuotedAttrValueState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '\"') {
            this.parser.memory().putCurrentAttrValue(this.parser.bufferToString());
            this.parser.flush();
            this.parser.selectState().tagAttributes();
        } else if (c == '&') {
            this.parser.selectState().specialChar();
        } else {
            this.parser.append(c);
        }
    }
}
