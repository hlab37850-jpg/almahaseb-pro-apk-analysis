package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class CloseStarCommentState implements State {
    private final XMLParser parser;

    public CloseStarCommentState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '*') {
            this.parser.memory().comment().append(c);
            return;
        }
        if (c != '/') {
            XMLParser xMLParser = this.parser;
            xMLParser.append(xMLParser.memory().comment().toString());
            this.parser.memory().comment().setLength(0);
            this.parser.selectState().starComment();
            return;
        }
        this.parser.memory().comment().setLength(0);
        this.parser.comment();
        this.parser.flush();
        XMLParser xMLParser2 = this.parser;
        xMLParser2.append(xMLParser2.memory().getStoredString());
        this.parser.selectState().inTag();
    }
}
