package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class InsideTagState implements State {
    private final XMLParser parser;

    public InsideTagState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c != '<') {
            if (c == '&') {
                this.parser.selectState().specialChar();
                return;
            } else {
                this.parser.append(c);
                return;
            }
        }
        if (this.parser.bufferSize() > 0) {
            XMLParser xMLParser = this.parser;
            xMLParser.text(xMLParser.current());
        }
        this.parser.flush();
        this.parser.selectState().tagEncountered();
    }
}
