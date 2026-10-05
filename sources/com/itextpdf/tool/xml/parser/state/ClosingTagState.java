package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class ClosingTagState implements State {
    private final XMLParser parser;

    public ClosingTagState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '>') {
            this.parser.memory().currentTag(this.parser.bufferToString());
            this.parser.endElement();
            this.parser.flush();
            this.parser.memory().flushNameSpace();
            this.parser.selectState().inTag();
            return;
        }
        if (c == ':') {
            this.parser.memory().namespace(this.parser.bufferToString());
            this.parser.flush();
        } else {
            if (Character.isWhitespace(c)) {
                return;
            }
            this.parser.append(c);
        }
    }
}
