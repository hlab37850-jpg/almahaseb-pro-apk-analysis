package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class CloseCommentState implements State {
    private final XMLParser parser;

    public CloseCommentState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '-') {
            this.parser.memory().comment().append('-');
            return;
        }
        if (c == '>' && this.parser.memory().comment().length() == 2) {
            this.parser.memory().comment().setLength(0);
            this.parser.comment();
            this.parser.flush();
            this.parser.selectState().inTag();
            return;
        }
        XMLParser xMLParser = this.parser;
        xMLParser.append(xMLParser.memory().comment().toString());
        this.parser.memory().comment().setLength(0);
        this.parser.selectState().comment();
    }
}
